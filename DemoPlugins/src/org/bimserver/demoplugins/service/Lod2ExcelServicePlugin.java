package org.bimserver.demoplugins.service;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.ifc2x3tc1.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcProxy;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.models.ifc2x3tc1.Vector3f;
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
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lod2ExcelServicePlugin extends ServicePlugin {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoServicePlugin2.class);
	private boolean initialized;
	private WritableCellFormat times;
	private WritableCellFormat timesbold;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}
	
	@Override
	public String getDescription() {
		return "LOD to Excel";
	}

	@Override
	public String getDefaultName() {
		return "LOD to Excel";
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
		return "LOD to Excel";
	}

	@Override
	public void register(PluginConfiguration pluginConfiguration) {
		ServiceDescriptor serviceDescriptor = StoreFactory.eINSTANCE.createServiceDescriptor();
		serviceDescriptor.setProviderName("BIMserver");
		serviceDescriptor.setIdentifier(getClass().getName());
		serviceDescriptor.setName("LOD to Excel");
		serviceDescriptor.setDescription("LOD to Excel");
		serviceDescriptor.setNotificationProtocol(AccessMethod.INTERNAL);
		serviceDescriptor.setTrigger(Trigger.NEW_REVISION);
		serviceDescriptor.setReadRevision(true);
		serviceDescriptor.setWriteExtendedData("http://www.buildingsmart-tech.org/specifications/excellod");
		registerNewRevisionHandler(serviceDescriptor, new NewRevisionHandler() {
			@Override
			public void newRevision(BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException {
				try {
					Date startDate = new Date();
					Long topicId = bimServerClientInterface.getRegistry().registerProgressOnRevisionTopic(SProgressTopicType.RUNNING_SERVICE, poid, roid, "LOD to Excel");
					SLongActionState state = new SLongActionState();
					state.setTitle("LOD to Excel");
					state.setState(SActionState.STARTED);
					state.setProgress(-1);
					state.setStart(startDate);
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					
					IfcModelInterface model = bimServerClientInterface.getModel(poid, roid, true);
					
					try {
					    WorkbookSettings wbSettings = new WorkbookSettings();
						
					    wbSettings.setLocale(new Locale("en", "EN"));
					    
					    WritableWorkbook workbook = null;

					    WritableFont times10pt = new WritableFont(WritableFont.ARIAL, 10);
					    times = new WritableCellFormat(times10pt);

					    WritableFont times10ptbold = new WritableFont(WritableFont.ARIAL, 10);
					    times10ptbold.setBoldStyle(WritableFont.BOLD);
					    timesbold = new WritableCellFormat(times10ptbold);
					    
					    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
						workbook = Workbook.createWorkbook(byteArrayOutputStream, wbSettings);
					    WritableSheet allSheet = workbook.createSheet("All", 0);
					    WritableSheet noFurnitureSheet = workbook.createSheet("No furniture", 1);
					    WritableSheet noProxySheet = workbook.createSheet("No proxies", 2);
					    
					    createHeader(allSheet);
					    createHeader(noFurnitureSheet);
					    createHeader(noProxySheet);

						float scaleFactorToMeter = 1;

						for (IfcSIUnit ifcSIUnit : model.getAll(IfcSIUnit.class)) {
							if (ifcSIUnit.getUnitType() == IfcUnitEnum.LENGTHUNIT) {
								IfcSIUnitName ifcSiUnitName = ifcSIUnit.getName();
								if (IfcSIUnitName.METRE == ifcSiUnitName) {
									IfcSIPrefix lengthPrefix = ifcSIUnit.getPrefix();
									System.out.println("Using length unit " + lengthPrefix);
									if (lengthPrefix == IfcSIPrefix.DECA) {
										scaleFactorToMeter = 10f;
									} else if (lengthPrefix == IfcSIPrefix.CENTI) {
										scaleFactorToMeter = 0.1f;
									} else if (lengthPrefix == IfcSIPrefix.DECI) {
										scaleFactorToMeter = 0.01f;
									} else if (lengthPrefix == IfcSIPrefix.MILLI) {
										scaleFactorToMeter = 0.001f;
									} else if (lengthPrefix == IfcSIPrefix.NULL) {
										scaleFactorToMeter = 1;
									} else {
										System.out.println("Unimplemented prefix " + lengthPrefix);
									}
								} else {
									System.out.println("Lengthunit not meters?!?");
								}
							}
						}
						
						double cubicScaleFactor = Math.pow(scaleFactorToMeter, 3);
						
						int totalNrTriangles = 0;
						int totalNrTrianglesNoProxies = 0;
						int totalNrTrianglesNoFurniture = 0;
						int nrIfcProducts = 0;
						int nrIfcProductsNoFurniture = 0;
						int nrIfcProductsNoProxies = 0;
						
						Bounds totalBounds = new Bounds();
						
						int totalUsedAttributes = 0;
						int totalUsedAttributesNoFurniture = 0;
						int totalUsedAttributesNoProxies = 0;
						
						double totalSpaceM3 = 0;
						
						model.getAll(GeometryInfo.class);
						model.getAll(Vector3f.class);
						
						int nrSpaces = 0;
						
						for (IfcSpace ifcSpace : model.getAll(IfcSpace.class)) {
							if (ifcSpace.getGeometry() != null) {
								Vector3f minBounds = ifcSpace.getGeometry().getMinBounds();
								Vector3f maxBounds = ifcSpace.getGeometry().getMinBounds();
								
								double v = cubicScaleFactor * (maxBounds.getX() - minBounds.getX() * (maxBounds.getY() - minBounds.getY()) * (maxBounds.getZ() - minBounds.getZ()));
								totalSpaceM3 += v;
								nrSpaces++;
							}
						}
						
						for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
							if (ifcProduct.getGeometry() != null) {
								totalBounds.integrate(new Bounds(ifcProduct.getGeometry().getMinBounds(), ifcProduct.getGeometry().getMaxBounds()));
								
								totalNrTriangles += ifcProduct.getGeometry().getPrimitiveCount();
								if (!(ifcProduct instanceof IfcFurnishingElement)) {
									totalNrTrianglesNoFurniture += ifcProduct.getGeometry().getPrimitiveCount();
								}
								if (!(ifcProduct instanceof IfcProxy)) {
									totalNrTrianglesNoProxies += ifcProduct.getGeometry().getPrimitiveCount();
								}
								int usedAttributes = 0;
								for (EAttribute eAttribute : ifcProduct.eClass().getEAllAttributes()) {
									Object val = ifcProduct.eGet(eAttribute);
									if (eAttribute.isMany()) {
										List<?> list = (List<?>)val;
										if (list.size() > 0) {
											usedAttributes++;
										}
									} else {
										if (val != null) {
											usedAttributes++;
										}
									}
								}
								
								for (IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
									if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
										IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties)ifcRelDefines;
										IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
										if (propertySetDefinition instanceof IfcPropertySet) {
											IfcPropertySet ifcPropertySet = (IfcPropertySet)propertySetDefinition;
											usedAttributes += ifcPropertySet.getHasProperties().size();
										}
									}
								}
								totalUsedAttributes += usedAttributes;
								nrIfcProducts++;
								if (!(ifcProduct instanceof IfcFurnishingElement)) {
									totalUsedAttributesNoFurniture += usedAttributes;
									nrIfcProductsNoFurniture++;
								}
								if (!(ifcProduct instanceof IfcProxy)) {
									totalUsedAttributesNoProxies += usedAttributes;
									nrIfcProductsNoProxies++;
								}
							}
						}
						
						writeRow(allSheet, 2, "model", cubicScaleFactor, totalNrTriangles, nrIfcProducts, totalBounds, totalUsedAttributes, totalSpaceM3, nrSpaces);
						writeRow(noFurnitureSheet, 2, "model", cubicScaleFactor, totalNrTrianglesNoFurniture, nrIfcProductsNoFurniture, totalBounds, totalUsedAttributesNoFurniture, totalSpaceM3, nrSpaces);
						writeRow(noProxySheet, 2, "model", cubicScaleFactor, totalNrTrianglesNoProxies, nrIfcProductsNoProxies, totalBounds, totalUsedAttributesNoProxies, totalSpaceM3, nrSpaces);
						
					    
						workbook.write();
						workbook.close();
						
						SExtendedDataSchema extendedDataSchemaByNamespace = bimServerClientInterface.getBimsie1ServiceInterface().getExtendedDataSchemaByNamespace(
								"http://www.buildingsmart-tech.org/specifications/excellod");

						SFile file = new SFile();

						SExtendedData extendedData = new SExtendedData();
						extendedData.setTitle("Excel LOD Results");
						file.setFilename("lod.xls");
						extendedData.setSchemaId(extendedDataSchemaByNamespace.getOid());
						try {
							byte[] bytes = byteArrayOutputStream.toByteArray();
							file.setData(bytes);
							file.setMime("application/excel");

							long fileId = bimServerClientInterface.getServiceInterface().uploadFile(file);
							extendedData.setFileId(fileId);

							bimServerClientInterface.getBimsie1ServiceInterface().addExtendedDataToRevision(roid, extendedData);
						} catch (Exception e) {
							LOGGER.error("", e);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

					
					state = new SLongActionState();
					state.setProgress(100);
					state.setTitle("LOD to Excel");
					state.setState(SActionState.FINISHED);
					state.setStart(startDate);
					state.setEnd(new Date());
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					
					bimServerClientInterface.getRegistry().unregisterProgressTopic(topicId);
				} catch (PublicInterfaceNotFoundException e) {
					LOGGER.error("", e);
				} catch (BimServerClientException e) {
					LOGGER.error("", e);
				}
			}
		});
	}
	
	private void writeRow(WritableSheet allSheet, int row, String name, double cubicScaleFactor, int totalNrTriangles, int nrIfcProducts, Bounds totalBounds, int totalUsedProperties, double totalSpaceM3, int nrSpaces) throws WriteException, RowsExceededException {
		double volume = cubicScaleFactor * (totalBounds.maxX - totalBounds.minX) * (totalBounds.maxY - totalBounds.minY) * (totalBounds.maxZ - totalBounds.minZ);
		allSheet.addCell(new Label(0, row, name, times));
		allSheet.addCell(new Label(1, row, String.valueOf(nrIfcProducts), times));
		allSheet.addCell(new Label(2, row, String.format("%.2f", volume), times));
		allSheet.addCell(new Label(3, row, "" + nrSpaces));
		allSheet.addCell(new Label(4, row, String.format("%.2f", totalSpaceM3), times));
		allSheet.addCell(new Label(5, row, String.valueOf(totalNrTriangles), times));
		allSheet.addCell(new Label(6, row, String.format("%.2f", nrIfcProducts / volume), times));
		allSheet.addCell(new Label(7, row, String.format("%.2f", totalNrTriangles / volume), times));
		allSheet.addCell(new Label(8, row, String.format("%.2f", nrIfcProducts / totalSpaceM3), times));
		allSheet.addCell(new Label(9, row, String.format("%.2f", totalNrTriangles / totalSpaceM3), times));
		allSheet.addCell(new Label(10, row, String.format("%.2f", (totalUsedProperties) / (float)nrIfcProducts), times));
	}

	private void createHeader(WritableSheet allSheet) throws WriteException, RowsExceededException {
		allSheet.addCell(new Label(0, 0, "File", timesbold));
		allSheet.addCell(new Label(1, 0, "# Objects", timesbold));
		allSheet.addCell(new Label(2, 0, "Volume M\u00B3", timesbold));
		allSheet.addCell(new Label(3, 0, "# Spaces", timesbold));
		allSheet.addCell(new Label(4, 0, "Space Volume M\u00B3", timesbold));
		allSheet.addCell(new Label(5, 0, "# Triangles", timesbold));
		allSheet.addCell(new Label(6, 0, "# Objects / Volume M\u00B3", timesbold));
		allSheet.addCell(new Label(7, 0, "# Triangles / Volume M\u00B3", timesbold));
		allSheet.addCell(new Label(8, 0, "# Objects / Space Volume m\u00B3", timesbold));
		allSheet.addCell(new Label(9, 0, "# Triangles / Space Volume M\u00B3", timesbold));
		allSheet.addCell(new Label(10, 0, "Avg. # Object properties / Object", timesbold));
	}
	
	class Bounds {
		float minX = Float.MAX_VALUE;
		float minY = Float.MAX_VALUE;
		float minZ = Float.MAX_VALUE;
		float maxX = -Float.MAX_VALUE;
		float maxY = -Float.MAX_VALUE;
		float maxZ = -Float.MAX_VALUE;

		public Bounds(Vector3f minBounds, Vector3f maxBounds) {
			minX = minBounds.getX();
			minY = minBounds.getY();
			minZ = minBounds.getZ();
			maxX = maxBounds.getX();
			maxY = maxBounds.getY();
			maxZ = maxBounds.getZ();
		}

		public Bounds() {
			// TODO Auto-generated constructor stub
		}

		public void integrate(Bounds bounds) {
			if (bounds.maxX > maxX) {
				maxX = bounds.maxX;
			}
			if (bounds.maxY > maxY) {
				maxY = bounds.maxY;
			}
			if (bounds.maxZ > maxZ) {
				maxZ = bounds.maxZ;
			}
			if (bounds.minX < minX) {
				minX = bounds.minX;
			}
			if (bounds.minY < minY) {
				minY = bounds.minY;
			}
			if (bounds.minZ < minZ) {
				minZ = bounds.minZ;
			}
		}
		
		@Override
		public String toString() {
			return minX + ", " + minY + ", " + minZ + ", " + maxX + ", " + maxY + ", " + maxZ;
		}
	}
}