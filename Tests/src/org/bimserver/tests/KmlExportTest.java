package org.bimserver.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SchemaLoader;
import org.bimserver.ifc.database.IfcDatabase;
import org.bimserver.ifc.emf.Ifc2x3.IfcArbitraryClosedProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcAxis2Placement3D;
import org.bimserver.ifc.emf.Ifc2x3.IfcCartesianPoint;
import org.bimserver.ifc.emf.Ifc2x3.IfcExtrudedAreaSolid;
import org.bimserver.ifc.emf.Ifc2x3.IfcLocalPlacement;
import org.bimserver.ifc.emf.Ifc2x3.IfcPolyline;
import org.bimserver.ifc.emf.Ifc2x3.IfcProduct;
import org.bimserver.ifc.emf.Ifc2x3.IfcProductDefinitionShape;
import org.bimserver.ifc.emf.Ifc2x3.IfcProductRepresentation;
import org.bimserver.ifc.emf.Ifc2x3.IfcRepresentation;
import org.bimserver.ifc.emf.Ifc2x3.IfcRepresentationItem;
import org.bimserver.ifc.emf.Ifc2x3.IfcShapeRepresentation;
import org.bimserver.ifc.file.reader.IfcStepDeserializer;
import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
import org.eclipse.emf.common.util.EList;

public class KmlExportTest {
	public static void main(String[] args) {
		new KmlExportTest().start();
	}

	private void start() {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		
		File kmlFile = new File("test.kml");
		PrintWriter out = null;
		try {
			out = new PrintWriter(kmlFile);
			IfcStepDeserializer fastIfcFileReader = new IfcStepDeserializer(schema);
			Set<IfcExtrudedAreaSolid> solids = new HashSet<IfcExtrudedAreaSolid>();
			try {
				fastIfcFileReader.read(TestFile.AC11.getFile());
				IfcModel model = fastIfcFileReader.getModel();
				IfcDatabase database = new IfcDatabase(model, null);
				out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?><kml xmlns=\"http://www.opengis.net/kml/2.2\">  <Document>");
				out.println("      <Folder>       <name>Extruded Polygon</name>        <description>A simple way to model a building</description>        ");
				List<IfcProduct> products = new ArrayList<IfcProduct>();
//				products.addAll(spaces);
//				products.addAll(walls);
//				products.addAll(database.getAll(IfcRoof.class));
				products.addAll(database.getAll(IfcProduct.class));
				for (IfcProduct product : products) {
					IfcLocalPlacement ilp = (IfcLocalPlacement) product.getObjectPlacement();
					IfcAxis2Placement3D placement = (IfcAxis2Placement3D) ilp.getRelativePlacement();
					IfcLocalPlacement placementRelTo = (IfcLocalPlacement) ilp.getPlacementRelTo();
					if (placementRelTo!= null) {
						IfcAxis2Placement3D placement2 = (IfcAxis2Placement3D) placementRelTo.getRelativePlacement();
						IfcProductRepresentation representation = product.getRepresentation();
						IfcProductDefinitionShape ipds = (IfcProductDefinitionShape) representation;
						if (ipds != null && ipds.getRepresentations() != null) {
							for (IfcRepresentation ir : ipds.getRepresentations()) {
								IfcShapeRepresentation isr = (IfcShapeRepresentation) ir;
								for (IfcRepresentationItem iri : isr.getItems()) {
									if (iri instanceof IfcExtrudedAreaSolid) {
										IfcExtrudedAreaSolid ieas = (IfcExtrudedAreaSolid) iri;
										if (!solids.contains(ieas)) {
											if (ieas.getSweptArea() instanceof IfcArbitraryClosedProfileDef) {
												IfcArbitraryClosedProfileDef iacpd = (IfcArbitraryClosedProfileDef) ieas.getSweptArea();
												IfcPolyline poly = (IfcPolyline) iacpd.getOuterCurve();
												processPoints(out, placement, placement2, poly);
												solids.add(ieas);
											}
										}
//									} else if (iri instanceof IfcPolyline) {
//										IfcPolyline ifcPolyline = (IfcPolyline) iri;
//										processPoints(out, placement, placement2, ifcPolyline);
									} else {
										System.out.println(iri);
									}
								}
							}
						}
					}
				}
				out.println("             </Folder>  </Document></kml>");
			} catch (IncorrectIfcFileException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} finally {
			out.close();
		}
	}

	private void processPoints(PrintWriter out, IfcAxis2Placement3D placement,
			IfcAxis2Placement3D placement2, IfcPolyline poly) {
		out.println("<Placemark>");
		out.println("<Polygon>       <extrude>0</extrude>            <altitudeMode>relativeToGround</altitudeMode>            <outerBoundaryIs>");
		out.println("<LinearRing>");
		out.println("<coordinates>");
		EList<Float> directionRatios = placement.getRefDirection().getDirectionRatios();
		
		for (IfcCartesianPoint icp : poly.getPoints()) {
			float x = icp.getCoordinates().get(0);
			float y = icp.getCoordinates().get(1);
			float z = 0;

			if (directionRatios.get(0) == 1) {
			} else if (directionRatios.get(0) == -1) {
				x = -x;
//				y = -y;
			} else if (directionRatios.get(1) == 1) {
				float q = x;
				x = y;
				y = q;
			} else if (directionRatios.get(1) == -1) {
				float q = x;
				x = -y;
				y = -q;
			} else if (directionRatios.get(2) == 1) {
				float q = x;
				float w = y;
				x = z;
				y = -q;
				z = w;
			} else if (directionRatios.get(2) == -1) {
				float q = x;
				x = -z;
				y = -y;
				z = q;
			}
			x += placement.getLocation().getCoordinates().get(0);
			y += placement.getLocation().getCoordinates().get(1);
			z += placement2.getLocation().getCoordinates().get(2);
			
			x = x/10000;
			out.print(x + ", ");
			y = y / 10000;
			out.print(y + ", ");
			out.print(z + "\n");
		}
		out.println("</coordinates>");
		out.println("</LinearRing>");
		out.println("</outerBoundaryIs>");
		out.println("</Polygon>");
		out.println("</Placemark>");
	}
}
