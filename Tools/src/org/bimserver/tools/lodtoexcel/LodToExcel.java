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

import org.bimserver.client.BimServerClient;
import org.bimserver.client.BimServerClientFactory;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.models.ifc2x3tc1.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
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
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.eclipse.emf.ecore.EAttribute;

public class LodToExcel {
	private WritableCellFormat times;
	private WritableCellFormat timesbold;

	public static void main(String[] args) {
		long start = System.nanoTime();
		new LodToExcel().export(new File("lod.xls"));
		long end = System.nanoTime();
		System.out.println(((end - start) / 1000000) + " ms");
	}

	private void export(File file) {
		try {
//			BimServerClientFactory factory = new JsonBimServerClientFactory("http://sandbox.bimserver.org");
			BimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
			BimServerClient bimServerClient = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
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

			List<SProject> projects = bimServerClient.getBimsie1ServiceInterface().getAllProjects(true, true);
			int row = 2;
			for (SProject project : projects) {
				long roid = project.getLastRevisionId();
				if (roid != -1) {
					SRevision revision = bimServerClient.getBimsie1ServiceInterface().getRevision(roid);
					System.out.println(revision.getComment());
					ClientIfcModel model = bimServerClient.getModel(project.getOid(), roid, true);
					
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
					GeometryInfo totalBounds = Ifc2x3tc1Factory.eINSTANCE.createGeometryInfo();
					Vector3f totalMin = Ifc2x3tc1Factory.eINSTANCE.createVector3f();
					totalMin.setX(Float.MAX_VALUE);
					totalMin.setY(Float.MAX_VALUE);
					totalMin.setZ(Float.MAX_VALUE);
					totalBounds.setMinBounds(totalMin);
					Vector3f totalMax = Ifc2x3tc1Factory.eINSTANCE.createVector3f();
					totalMax.setX(-Float.MAX_VALUE);
					totalMax.setY(-Float.MAX_VALUE);
					totalMax.setZ(-Float.MAX_VALUE);
					totalBounds.setMaxBounds(totalMax);
					int totalUsedAttributes = 0;
					int totalUsedAttributesNoFurniture = 0;
					int totalUsedAttributesNoProxies = 0;
					
					double totalSpaceM3 = 0;
					
					model.getAll(GeometryInfo.class);
					model.getAll(Vector3f.class);
					
					for (IfcSpace ifcSpace : model.getAll(IfcSpace.class)) {
						GeometryInfo geometryInfo = ifcSpace.getGeometry();
						if (geometryInfo != null) {
							Vector3f min = geometryInfo.getMinBounds();
							Vector3f max = geometryInfo.getMaxBounds();
							if (min != null && max != null) {
								double v = cubicScaleFactor * (max.getX() - min.getX()) * (max.getY() - min.getY()) * (max.getZ() - min.getZ());
								totalSpaceM3 += v;
							} else {
								if (min == null) {
									System.out.println("Min");
								}
								if (max == null) {
									System.out.println("Max");
								}
							}
						}
					}
					
					for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
						GeometryInfo geometryInfo = ifcProduct.getGeometry();
						if (geometryInfo != null) {
							int nrTriangles = geometryInfo.getPrimitiveCount() / 12;
							Vector3f min = geometryInfo.getMinBounds();
							Vector3f max = geometryInfo.getMaxBounds();
							if (min != null && max != null) {
								if (min.getX() < totalMin.getX()) {
									totalMin.setX(min.getX());
								}
								if (min.getY() < totalMin.getY()) {
									totalMin.setY(min.getY());
								}
								if (min.getZ() < totalMin.getZ()) {
									totalMin.setZ(min.getZ());
								}
								if (max.getX() > totalMax.getX()) {
									totalMax.setX(max.getX());
								}
								if (max.getY() > totalMax.getY()) {
									totalMax.setY(max.getY());
								}
								if (max.getZ() > totalMax.getZ()) {
									totalMax.setZ(max.getZ());
								}
							}
							totalNrTriangles += nrTriangles;
							if (!(ifcProduct instanceof IfcFurnishingElement)) {
								totalNrTrianglesNoFurniture += nrTriangles;
							}
							if (!(ifcProduct instanceof IfcProxy)) {
								totalNrTrianglesNoProxies += nrTriangles;
							}
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
					
					System.out.println("Min: " + totalBounds.getMinBounds().getX() + ", " + totalBounds.getMinBounds().getY() + ", " + totalBounds.getMinBounds().getZ());
					System.out.println("Max: " + totalBounds.getMaxBounds().getX() + ", " + totalBounds.getMaxBounds().getY() + ", " + totalBounds.getMaxBounds().getZ());
					System.out.println("Cubic scale factor: " + cubicScaleFactor);
					
					writeRow(allSheet, row, revision, cubicScaleFactor, totalNrTriangles, nrIfcProducts, totalMin, totalMax, totalUsedAttributes, totalSpaceM3);
					writeRow(noFurnitureSheet, row, revision, cubicScaleFactor, totalNrTrianglesNoFurniture, nrIfcProductsNoFurniture, totalMin, totalMax, totalUsedAttributesNoFurniture, totalSpaceM3);
					writeRow(noProxySheet, row, revision, cubicScaleFactor, totalNrTrianglesNoProxies, nrIfcProductsNoProxies, totalMin, totalMax, totalUsedAttributesNoProxies, totalSpaceM3);
					
					row++;
				}
			}
		    
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeRow(WritableSheet allSheet, int row, SRevision revision, double cubicScaleFactor, int totalNrTriangles, int nrIfcProducts, Vector3f totalMin,
			Vector3f totalMax, int totalUsedProperties, double totalSpaceM3) throws WriteException, RowsExceededException {
		double volume = cubicScaleFactor * (totalMax.getX() - totalMin.getX()) * (totalMax.getY() - totalMin.getY()) * (totalMax.getZ() - totalMin.getZ());
		allSheet.addCell(new Label(0, row, revision.getComment(), times));
		allSheet.addCell(new Label(1, row, String.valueOf(nrIfcProducts), times));
		allSheet.addCell(new Label(2, row, String.valueOf(volume), times));
		allSheet.addCell(new Label(3, row, String.valueOf(totalSpaceM3), times));
		allSheet.addCell(new Label(4, row, String.valueOf(totalNrTriangles), times));
		allSheet.addCell(new Label(5, row, String.valueOf(nrIfcProducts / volume), times));
		allSheet.addCell(new Label(6, row, String.valueOf(totalNrTriangles / volume), times));
		allSheet.addCell(new Label(7, row, String.valueOf(nrIfcProducts / totalSpaceM3), times));
		allSheet.addCell(new Label(8, row, String.valueOf(totalNrTriangles / totalSpaceM3), times));
		allSheet.addCell(new Label(9, row, String.valueOf((totalUsedProperties) / (float)nrIfcProducts), times));
	}

	private void createHeader(WritableSheet allSheet) throws WriteException, RowsExceededException {
		allSheet.addCell(new Label(0, 0, "File", timesbold));
		allSheet.addCell(new Label(1, 0, "# Objects", timesbold));
		allSheet.addCell(new Label(2, 0, "Volume M\u00B3", timesbold));
		allSheet.addCell(new Label(3, 0, "Space Volume M\u00B3", timesbold));
		allSheet.addCell(new Label(4, 0, "# Triangles", timesbold));
		allSheet.addCell(new Label(5, 0, "# Objects / Volume M\u00B3", timesbold));
		allSheet.addCell(new Label(6, 0, "# Triangles / Volume M\u00B3", timesbold));
		allSheet.addCell(new Label(7, 0, "# Objects / Space Volume m\u00B3", timesbold));
		allSheet.addCell(new Label(8, 0, "# Triangles / Space Volume M\u00B3", timesbold));
		allSheet.addCell(new Label(9, 0, "Avg. # Object properties / Object", timesbold));
	}
}