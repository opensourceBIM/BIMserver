package org.bimserver.demoplugins.service;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SInternalServicePluginConfiguration;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.models.ifc2x3tc1.IfcOpeningElement;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

		public Hit(BoundingBox b1, BoundingBox b2, IfcOpeningElement el1, IfcOpeningElement el2) {
			this.b1 = b1;
			this.b2 = b2;
			this.el1 = el1;
			this.el2 = el2;
		}
	}
	
	@Override
	public void register(SInternalServicePluginConfiguration internalServicePluginConfiguration, PluginConfiguration pluginConfiguration) {
		ServiceDescriptor serviceDescriptor = StoreFactory.eINSTANCE.createServiceDescriptor();
		serviceDescriptor.setProviderName("BIMserver");
		serviceDescriptor.setIdentifier("" + internalServicePluginConfiguration.getOid());
		serviceDescriptor.setName("Geometry Matcher");
		serviceDescriptor.setDescription("Geometry Matcher");
		serviceDescriptor.setReadRevision(true);
		serviceDescriptor.setWriteExtendedData("test");
		serviceDescriptor.setNotificationProtocol(AccessMethod.INTERNAL);
		serviceDescriptor.setTrigger(Trigger.NEW_REVISION);
		registerNewRevisionHandler(serviceDescriptor, new NewRevisionHandler() {
			@Override
			public void newRevision(BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException {
				try {
					Date startDate = new Date();
					Long topicId = bimServerClientInterface.getRegistry().registerProgressOnRevisionTopic(SProgressTopicType.RUNNING_SERVICE, poid, roid, "Running Demo Service");
					
					Map<Long, Map<BoundingBox, IfcOpeningElement>> map = new HashMap<>();
					
					List<SProjectSmall> allRelatedProjects = bimServerClientInterface.getServiceInterface().getAllRelatedProjects(poid);
					for (SProjectSmall project : allRelatedProjects) {
						if (project.getLastRevisionId() != -1 && project.getNrSubProjects() == 0) {
							IfcModelInterface model = bimServerClientInterface.getModel(project.getOid(), project.getLastRevisionId(), false);
							Map<BoundingBox, IfcOpeningElement> boundingBoxes = new HashMap<>();
							map.put(project.getLastRevisionId(), boundingBoxes);
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
					for (Hit hit : hits) {
						System.out.println(hit.el1.getGlobalId() + " / " + hit.el2.getGlobalId() + " " + hit.b1 + " / " + hit.b2);
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
				}
			}

			private List<Hit> analyze(Map<Long, Map<BoundingBox, IfcOpeningElement>> map) {
				List<Hit> hits = new ArrayList<>();
				for (long roid : map.keySet()) {
					Map<BoundingBox, IfcOpeningElement> m = map.get(roid);
					for (BoundingBox b : m.keySet()) {
						for (long r2 : map.keySet()) {
							if (r2 != roid) {
								Map<BoundingBox, IfcOpeningElement> m2 = map.get(r2);
								for (BoundingBox b2 : m2.keySet()) {
									if (b.closeTo(b2)) {
										hits.add(new Hit(b, b2, m.get(b), m2.get(b2)));
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

	@Override
	public void unregister(SInternalServicePluginConfiguration internalService) {
	}
}