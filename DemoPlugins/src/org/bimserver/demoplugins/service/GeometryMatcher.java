package org.bimserver.demoplugins.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SInternalServicePluginConfiguration;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.models.ifc2x3tc1.IfcElement;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcOpeningElement;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcRelFillsElement;
import org.bimserver.models.ifc2x3tc1.IfcText;
import org.bimserver.models.ifc2x3tc1.IfcValue;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.Trigger;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.services.BimServerClientException;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.Geometry;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.bytecode.opencsv.CSVWriter;

public class GeometryMatcher extends ServicePlugin {
	private static final Logger LOGGER = LoggerFactory.getLogger(GeometryMatcher.class);
	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}
	
	@Override
	public String getDescription() {
		return "Geometry Matcher";
	}

	@Override
	public String getDefaultName() {
		return "Geometry Matcher";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getTitle() {
		return "Geometry Matcher";
	}

	public static class BoundingBox {
		private float[] min;
		private float[] max;
		
		public BoundingBox(float[] min, float[] max) {
			this.min = min;
			this.max = max;
		}
		
		public BoundingBox() {
			min = new float[]{Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE};
			max = new float[]{-Float.MAX_VALUE, -Float.MAX_VALUE, -Float.MAX_VALUE};
		}

		public void process(float[] point) {
			for (int i=0; i<3; i++) {
				if (point[i] < min[i]) {
					min[i] = point[i];
				}
				if (point[i] > max[i]) {
					max[i] = point[i];
				}
			}
		}
		
		@Override
		public String toString() {
			return min[0] + ", " + min[1] + ", " + min[2] + " / " + max[0] + ", " + max[1] + ", " + max[2];
		}

		public boolean closeTo(BoundingBox other) {
			for (int i=0; i<3; i++) {
				if (Math.abs(min[i] - other.min[i]) > .005) {
					return false;
				}
				if (Math.abs(max[i] - other.max[i]) > .005) {
					return false;
				}
			}
			return true;
		}
	}
	
	public static class Hit {
		public IfcOpeningElement el1;
		public IfcOpeningElement el2;
		public BoundingBox b1;
		public BoundingBox b2;
		public SProjectSmall secondProject;
		public SProjectSmall firstProject;

		public Hit(SProjectSmall firstProject, SProjectSmall secondProject, BoundingBox b1, BoundingBox b2, IfcOpeningElement el1, IfcOpeningElement el2) {
			this.firstProject = firstProject;
			this.secondProject = secondProject;
			this.b1 = b1;
			this.b2 = b2;
			this.el1 = el1;
			this.el2 = el2;
		}
	}
	
	@Override
	public void register(long uoid, SInternalServicePluginConfiguration internalServicePluginConfiguration, PluginConfiguration pluginConfiguration) {
		ServiceDescriptor serviceDescriptor = StoreFactory.eINSTANCE.createServiceDescriptor();
		serviceDescriptor.setProviderName("BIMserver");
		serviceDescriptor.setIdentifier("" + internalServicePluginConfiguration.getOid());
		serviceDescriptor.setName("Geometry Matcher");
		serviceDescriptor.setDescription("Geometry Matcher");
		serviceDescriptor.setReadRevision(true);
		serviceDescriptor.setWriteExtendedData("geometrymatching");
		serviceDescriptor.setNotificationProtocol(AccessMethod.INTERNAL);
		serviceDescriptor.setTrigger(Trigger.NEW_REVISION);
		registerNewRevisionHandler(uoid, serviceDescriptor, new NewRevisionHandler() {
			@Override
			public void newRevision(BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException {
				try {
					Date startDate = new Date();
					Long topicId = bimServerClientInterface.getRegistry().registerProgressOnRevisionTopic(SProgressTopicType.RUNNING_SERVICE, poid, roid, "Running Demo Service");
					
					Map<SProjectSmall, Map<BoundingBox, IfcOpeningElement>> map = new HashMap<>();
					
					Map<Long, String> projectNames = new LinkedHashMap<>();
					
					List<SProjectSmall> allRelatedProjects = bimServerClientInterface.getServiceInterface().getAllRelatedProjects(poid);
					for (SProjectSmall project : allRelatedProjects) {
						if (project.getLastRevisionId() != -1 && project.getNrSubProjects() == 0) {
							projectNames.put(project.getOid(), project.getName());
							IfcModelInterface model = bimServerClientInterface.getModel(null, project.getLastRevisionId(), false, false); // TODO
							Map<BoundingBox, IfcOpeningElement> boundingBoxes = new HashMap<>();
							map.put(project, boundingBoxes);
							for (IfcOpeningElement ifcOpeningElement : model.getAll(IfcOpeningElement.class)) {
								
								Geometry geometry = bimServerClientInterface.getGeometry(project.getLastRevisionId(), ifcOpeningElement);
								
//								IntBuffer indexBuffer = geometry.getIndices();
//								FloatBuffer vertexBuffer = geometry.getVertices();
//								
//								for (int i=0; i<indexBuffer.capacity(); i+=3) {
//									int index1 = indexBuffer.get(i);
//									int index2 = indexBuffer.get(i + 1);
//									int index3 = indexBuffer.get(i + 2);
//									
//									boundingBox.process(new float[]{vertexBuffer.get(index1), vertexBuffer.get(index1 + 1), vertexBuffer.get(index1 + 2)});
//									boundingBox.process(new float[]{vertexBuffer.get(index2), vertexBuffer.get(index2 + 1), vertexBuffer.get(index2 + 2)});
//									boundingBox.process(new float[]{vertexBuffer.get(index3), vertexBuffer.get(index3 + 1), vertexBuffer.get(index3 + 2)});
//								}
								
								BoundingBox boundingBox = new BoundingBox(new float[]{geometry.getMinX(), geometry.getMinY(), geometry.getMinZ()}, new float[]{geometry.getMaxX(), geometry.getMaxY(), geometry.getMaxZ()});
								
								boundingBoxes.put(boundingBox, ifcOpeningElement);
							}
						}
					}
					
					List<Hit> hits = analyze(map);
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(byteArrayOutputStream));

					Iterator<String> projectIter = projectNames.values().iterator();
					csvWriter.writeNext(new String[]{"GUID in " + projectIter.next(), "GUID in " + projectIter.next(), "Mark"});
					for (Hit hit : hits) {
						String mark = "NOT MATCHED";
						for (IfcOpeningElement ifcOpeningElement : new IfcOpeningElement[]{hit.el1, hit.el2}) {
							for (IfcRelFillsElement ifcRelFillsElement : ifcOpeningElement.getHasFillings()) {
								IfcElement relatedBuildingElement = ifcRelFillsElement.getRelatedBuildingElement();
								if (relatedBuildingElement instanceof IfcWindow) {
									dump(relatedBuildingElement);
									String m = getStringProperty(relatedBuildingElement, "Mark");
									if (m != null) {
										mark = m;
									}
								}
							}
						}
						System.out.println(mark);
						csvWriter.writeNext(new String[]{hit.el1.getGlobalId(), hit.el2.getGlobalId(), mark});
					}
					csvWriter.close();
					
					SExtendedDataSchema extendedDataSchemaByNamespace = bimServerClientInterface.getBimsie1ServiceInterface().getExtendedDataSchemaByNamespace(
							"geometrymatching");

					SFile file = new SFile();

					SExtendedData extendedData = new SExtendedData();
					extendedData.setTitle("Geometry Matching Results");
					file.setFilename("geometrymatching.csv");
					extendedData.setSchemaId(extendedDataSchemaByNamespace.getOid());
					try {
						byte[] bytes = byteArrayOutputStream.toByteArray();
						file.setData(bytes);
						file.setMime("text/csv");

						long fileId = bimServerClientInterface.getServiceInterface().uploadFile(file);
						extendedData.setFileId(fileId);

						bimServerClientInterface.getBimsie1ServiceInterface().addExtendedDataToRevision(roid, extendedData);
					} catch (Exception e) {
						LOGGER.error("", e);
					}

					
					SLongActionState state = new SLongActionState();
					state.setProgress(100);
					state.setTitle("Geometry Matcher");
					state.setState(SActionState.FINISHED);
					state.setStart(startDate);
					state.setEnd(new Date());
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					
					bimServerClientInterface.getRegistry().unregisterProgressTopic(topicId);
				} catch (PublicInterfaceNotFoundException | BimServerClientException e) {
					LOGGER.error("", e);
				} catch (IOException e) {
					LOGGER.error("", e);
				}
			}

			private void dump(IdEObject object) {
				System.out.println(object.eClass().getName() + " " + object.getOid());
				for (EStructuralFeature eStructuralFeature : object.eClass().getEAllStructuralFeatures()) {
					System.out.print(eStructuralFeature.getName() + ": ");
					Object val = object.eGet(eStructuralFeature);
					if (eStructuralFeature instanceof EReference) {
						if (eStructuralFeature.isMany()) {
							List list = (List)val;
							for (Object o : list) {
								IdEObject ref = (IdEObject)o;
								System.out.print(ref.eClass().getName() + " " + ref.getOid() + ", ");
							}
						} else {
							if (val != null) {
								IdEObject ref = ((IdEObject)val);
								System.out.print(ref.eClass().getName() + " " + ref.getOid());
							}
						}
					} else {
						if (eStructuralFeature.isMany()) {
							System.out.print("values...");
						} else {
							System.out.print(val);
						}
					}
					System.out.println();
				}
			}

			private List<Hit> analyze(Map<SProjectSmall, Map<BoundingBox, IfcOpeningElement>> map) {
				Set<IfcOpeningElement> matched = new HashSet<>();
				List<Hit> hits = new ArrayList<>();
				for (SProjectSmall project : map.keySet()) {
					Map<BoundingBox, IfcOpeningElement> m = map.get(project);
					for (BoundingBox b : m.keySet()) {
						for (SProjectSmall project2 : map.keySet()) {
							if (project2.getOid() != project.getOid()) {
								Map<BoundingBox, IfcOpeningElement> m2 = map.get(project2);
								for (BoundingBox b2 : m2.keySet()) {
									if (b.closeTo(b2)) {
										if (!matched.contains(m.get(b)) && !matched.contains(m2.get(b2))) {
											hits.add(new Hit(project, project2, b, b2, m.get(b), m2.get(b2)));
											matched.add(m.get(b));
											matched.add(m2.get(b2));
										}
									}
								}
							}
						}
					}
				}
				return hits;
			}
		});
	}

	private String getStringProperty(IfcProduct ifcProduct, String propertyName) {
		for (IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
			if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties)ifcRelDefines;
				IfcPropertySetDefinition relatingPropertyDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (relatingPropertyDefinition instanceof IfcPropertySet) {
					IfcPropertySet ifcProperySet = ((IfcPropertySet)relatingPropertyDefinition);
					for (IfcProperty ifcProperty : ifcProperySet.getHasProperties()) {
						if (propertyName.equals(ifcProperty.getName())) {
							if (ifcProperty instanceof IfcPropertySingleValue) {
								IfcPropertySingleValue ifcPropertySingleValue = (IfcPropertySingleValue)ifcProperty;
								IfcValue nominalValue = ifcPropertySingleValue.getNominalValue();
								if (nominalValue instanceof IfcLabel) {
									IfcLabel ifcLabel = (IfcLabel)nominalValue;
									return ifcLabel.getWrappedValue();
								} else if (nominalValue instanceof IfcText) {
									IfcText ifcText = (IfcText)nominalValue;
									return ifcText.getWrappedValue();
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	@Override
	public void unregister(SInternalServicePluginConfiguration internalService) {
	}
}