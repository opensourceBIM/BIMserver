package org.bimserver.tools.lodtoexcel;

import java.io.File;
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
import nl.tue.buildingsmart.emf.SchemaLoader;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifc.step.deserializer.IfcStepDeserializer;
import org.bimserver.ifcengine.JvmIfcEngine;
import org.bimserver.ifcengine.JvmIfcEngineModel;
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
import org.bimserver.plugins.renderengine.IndexFormat;
import org.bimserver.plugins.renderengine.Precision;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEngineGeometry;
import org.bimserver.plugins.renderengine.RenderEngineInstance;
import org.bimserver.plugins.renderengine.RenderEngineInstanceVisualisationProperties;
import org.bimserver.plugins.renderengine.RenderEngineSettings;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.eclipse.emf.ecore.EAttribute;

public class LodToExcel2 {
	private WritableCellFormat times;
	private WritableCellFormat timesbold;

	public static void main(String[] args) {
		long start = System.nanoTime();
		new LodToExcel2().export(new File("lod.xls"));
		long end = System.nanoTime();
		System.out.println(((end - start) / 1000000) + " ms");
	}
	
	class Bounds {
		float minX = Float.MAX_VALUE;
		float minY = Float.MAX_VALUE;
		float minZ = Float.MAX_VALUE;
		float maxX = -Float.MAX_VALUE;
		float maxY = -Float.MAX_VALUE;
		float maxZ = -Float.MAX_VALUE;

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

	private void export(File file) {
		try {
		    WorkbookSettings wbSettings = new WorkbookSettings();
			
		    wbSettings.setLocale(new Locale("en", "EN"));
		    
		    WritableWorkbook workbook = null;

		    WritableFont times10pt = new WritableFont(WritableFont.ARIAL, 10);
		    times = new WritableCellFormat(times10pt);

		    WritableFont times10ptbold = new WritableFont(WritableFont.ARIAL, 10);
		    times10ptbold.setBoldStyle(WritableFont.BOLD);
		    timesbold = new WritableCellFormat(times10ptbold);
		    
		    workbook = Workbook.createWorkbook(file, wbSettings);
		    WritableSheet allSheet = workbook.createSheet("All", 0);
		    WritableSheet noFurnitureSheet = workbook.createSheet("No furniture", 1);
		    WritableSheet noProxySheet = workbook.createSheet("No proxies", 2);
		    
		    createHeader(allSheet);
		    createHeader(noFurnitureSheet);
		    createHeader(noProxySheet);

		    JvmIfcEngine engine = new JvmIfcEngine(new File("../buildingSMARTLibrary/schema/IFC2X3_TC1.exp").getAbsoluteFile(), new File("../IfcEngine/lib/64"), new File("tmp"), System.getProperty("java.class.path"));
			RenderEngineSettings settings = new RenderEngineSettings();
			settings.setPrecision(Precision.SINGLE);
			settings.setIndexFormat(IndexFormat.AUTO_DETECT);
			settings.setGenerateNormals(true);
			settings.setGenerateTriangles(true);
			settings.setGenerateWireFrame(false);
		    engine.init();

		    SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		    
		    File dir = new File("C:\\Users\\Ruben de Laat\\Dropbox\\Shared\\BIMserver\\LOD modellen");
		    int row = 2;
		    for (File f : dir.listFiles()) {
		    	if (f.isFile() && f.getName().endsWith(".ifc")) {
			    	JvmIfcEngineModel ifcEngineModel = engine.openModel(f);
			    	ifcEngineModel.setSettings(settings);
	
			    	RenderEngineGeometry geometry = ifcEngineModel.finalizeModelling(ifcEngineModel.initializeModelling());
			    	
			    	IfcStepDeserializer deserializer = new IfcStepDeserializer();
					deserializer.init(schema);
			    	IfcModelInterface model = deserializer.read(f);
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
						RenderEngineInstance instance = ifcEngineModel.getInstanceFromExpressId(ifcSpace.getExpressId());
	
						Bounds bounds = getBounds(geometry, instance);
						System.out.println("Space bounds: " + bounds);
						
						double v = cubicScaleFactor * (bounds.maxX - bounds.minX) * (bounds.maxY - bounds.minY) * (bounds.maxZ - bounds.minZ);
						totalSpaceM3 += v;
						nrSpaces++;
					}
					
					for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
						RenderEngineInstance instance = ifcEngineModel.getInstanceFromExpressId(ifcProduct.getExpressId());
						int nrTriangles = instance.getVisualisationProperties().getPrimitiveCount() / 12;
						Bounds bounds = getBounds(geometry, instance);
						System.out.println("Product bounds: " + bounds);
						totalBounds.integrate(bounds);
						
						totalNrTriangles += nrTriangles;
						if (!(ifcProduct instanceof IfcFurnishingElement)) {
							totalNrTrianglesNoFurniture += nrTriangles;
						}
						if (!(ifcProduct instanceof IfcProxy)) {
							totalNrTrianglesNoProxies += nrTriangles;
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
					
					System.out.println(totalBounds);
					System.out.println("Cubic scale factor: " + cubicScaleFactor);
					
					writeRow(allSheet, row, f.getName(), cubicScaleFactor, totalNrTriangles, nrIfcProducts, totalBounds, totalUsedAttributes, totalSpaceM3, nrSpaces);
					writeRow(noFurnitureSheet, row, f.getName(), cubicScaleFactor, totalNrTrianglesNoFurniture, nrIfcProductsNoFurniture, totalBounds, totalUsedAttributesNoFurniture, totalSpaceM3, nrSpaces);
					writeRow(noProxySheet, row, f.getName(), cubicScaleFactor, totalNrTrianglesNoProxies, nrIfcProductsNoProxies, totalBounds, totalUsedAttributesNoProxies, totalSpaceM3, nrSpaces);
					
					row++;
					ifcEngineModel.close();
		    	}
			}
		    
		    engine.close();
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Bounds getBounds(RenderEngineGeometry geometry, RenderEngineInstance instance) throws RenderEngineException {
		RenderEngineInstanceVisualisationProperties visualisationProperties = instance.getVisualisationProperties();
		Bounds bounds = new Bounds();
		for (int i=visualisationProperties.getStartIndex(); i<visualisationProperties.getStartIndex() + visualisationProperties.getPrimitiveCount() * 3; i++) {
			int index = geometry.getIndex(i) * 3;
			float x = geometry.getVertex(index);
			float y = geometry.getVertex(index + 1);
			float z = geometry.getVertex(index + 2);
			if (x < bounds.minX) {
				bounds.minX = x;
			}
			if (y < bounds.minY) {
				bounds.minY = y;
			}
			if (z < bounds.minZ) {
				bounds.minZ = z;
			}
			if (x > bounds.maxX) {
				bounds.maxX = x;
			}
			if (y > bounds.maxY) {
				bounds.maxY = y;
			}
			if (z > bounds.maxZ) {
				bounds.maxZ = z;
			}
		}
		return bounds;
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
}