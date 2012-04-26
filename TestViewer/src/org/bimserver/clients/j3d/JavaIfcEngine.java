package org.bimserver.clients.j3d;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

//import java.util.Map;
//
//import javax.media.j3d.Appearance;
//import javax.media.j3d.GeometryArray;
//import javax.media.j3d.QuadArray;
//import javax.media.j3d.Shape3D;
//import javax.media.j3d.Transform3D;
//import javax.media.j3d.TransformGroup;
//import javax.media.j3d.TriangleArray;
//import javax.vecmath.Matrix3f;
//import javax.vecmath.Point2f;
//import javax.vecmath.Point3f;
//import javax.vecmath.Vector3f;
//
//import org.bimserver.emf.IdEObject;
//import org.bimserver.ifc.IfcModel;
//import org.bimserver.models.ifc2x3tc1.IfcArbitraryClosedProfileDef;
//import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement;
//import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
//import org.bimserver.models.ifc2x3tc1.IfcBooleanClippingResult;
//import org.bimserver.models.ifc2x3tc1.IfcBooleanOperand;
//import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
//import org.bimserver.models.ifc2x3tc1.IfcClosedShell;
//import org.bimserver.models.ifc2x3tc1.IfcCurve;
//import org.bimserver.models.ifc2x3tc1.IfcDirection;
//import org.bimserver.models.ifc2x3tc1.IfcExtrudedAreaSolid;
//import org.bimserver.models.ifc2x3tc1.IfcFace;
//import org.bimserver.models.ifc2x3tc1.IfcFaceBound;
//import org.bimserver.models.ifc2x3tc1.IfcFacetedBrep;
//import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
//import org.bimserver.models.ifc2x3tc1.IfcLoop;
//import org.bimserver.models.ifc2x3tc1.IfcObjectPlacement;
//import org.bimserver.models.ifc2x3tc1.IfcPolyLoop;
//import org.bimserver.models.ifc2x3tc1.IfcPolyline;
//import org.bimserver.models.ifc2x3tc1.IfcProduct;
//import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
//import org.bimserver.models.ifc2x3tc1.IfcProfileDef;
//import org.bimserver.models.ifc2x3tc1.IfcRectangleProfileDef;
//import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
//import org.bimserver.models.ifc2x3tc1.IfcRepresentationItem;
//import org.bimserver.models.ifc2x3tc1.IfcRoot;
//
//import com.sun.j3d.utils.geometry.GeometryInfo;
//import com.sun.j3d.utils.geometry.NormalGenerator;
//import com.sun.j3d.utils.geometry.Stripifier;
//import com.sun.j3d.utils.geometry.Triangulator;
//
//public class JavaIfcEngine implements IfcEngine {
//	private final Appearances appearances;
//
//	public JavaIfcEngine(Appearances appearances) {
//		this.appearances = appearances;
//	}
//	
//	public void createTriangles(IfcRoot ifcRootObject, IfcModel ifcModel, TransformGroup buildingTransformGroup) {
//		TransformGroup mainGroup = new TransformGroup();
//		Appearance appearance = appearances.getAppearance(ifcRootObject);
//		Map<IfcProduct, TransformGroup> rotationGroups = new HashMap<IfcProduct, TransformGroup>();
//		if (appearance != null) {
//			for (IdEObject idEObject : ifcModel.getValues()) {
//				if (idEObject instanceof IfcProduct) {
//					IfcProduct ifcProduct = (IfcProduct) idEObject;
//					TransformGroup translationGroup = new TransformGroup();
//					TransformGroup rotationGroup = new TransformGroup();
//					if (rotationGroups.containsKey(ifcProduct)) {
//						rotationGroup = rotationGroups.get(ifcProduct);
//					}
//					translationGroup.addChild(rotationGroup);
//
//					Shape3D shape = new Shape3D();
//					shape.setAppearance(appearance);
//					rotationGroup.addChild(shape);
//
//					IfcObjectPlacement objectPlacement = ifcProduct.getObjectPlacement();
//					if (objectPlacement instanceof IfcLocalPlacement) {
//						IfcLocalPlacement ifcLocalPlacement = (IfcLocalPlacement) objectPlacement;
//						IfcObjectPlacement relative = ifcLocalPlacement.getPlacementRelTo();
//						if (relative != null && relative.getPlacesObject().size() > 0) {
//							if (rotationGroups.containsKey(relative.getPlacesObject().get(0))) {
//								rotationGroups.get(relative.getPlacesObject().get(0)).addChild(translationGroup);
//							} else {
//								TransformGroup newGroup = new TransformGroup();
//								rotationGroups.put(relative.getPlacesObject().get(0), newGroup);
//								newGroup.addChild(translationGroup);
//							}
//						}
//						IfcAxis2Placement relativePlacement = ifcLocalPlacement.getRelativePlacement();
//						if (relativePlacement instanceof IfcAxis2Placement3D) {
//							IfcAxis2Placement3D ifcAxis2Placement3D = (IfcAxis2Placement3D) relativePlacement;
//							Vector3f direction = createVector3f(ifcAxis2Placement3D.getRefDirection());
//							Vector3f axis = createVector3f(ifcAxis2Placement3D.getAxis());
//							Vector3f combinedRotation = new Vector3f();
//							Matrix3f t1 = t(direction);
//							Matrix3f t2 = t(axis);
//							Matrix3f finalM = new Matrix3f();
//							finalM.mul(t2, t1);
//							combinedRotation.cross(direction, axis);
//							Vector3f location = createVector3f(ifcAxis2Placement3D.getLocation());
//
//							System.out.println("dir: " + direction);
//							System.out.println("axis: " + axis);
//							System.out.println();
//
//							Transform3D translation = new Transform3D();
//							translation.setTranslation(location);
//							translationGroup.setTransform(translation);
//
//							Transform3D rotation = new Transform3D();
//							rotation.setRotation(finalM);
//							rotationGroup.setTransform(rotation);
//						} else {
//							System.out.println("other placement");
//						}
//					}
//					if (translationGroup.getParent() == null) {
//						mainGroup.addChild(translationGroup);
//					}
//					IfcProductRepresentation representation = ifcProduct.getRepresentation();
//					if (representation != null) {
//						for (IfcRepresentation ifcRepresentation : representation.getRepresentations()) {
//							for (IfcRepresentationItem ifcRepresentationItem : ifcRepresentation.getItems()) {
//								if (ifcRepresentationItem instanceof IfcPolyline) {
//									IfcPolyline ifcPolyLine = (IfcPolyline) ifcRepresentationItem;
//									ifcPolyLine.setDim(ifcPolyLine.getPoints().get(0).getCoordinates().size());
//									if (ifcPolyLine.getDim() == 3) {
//										processPolyLine3D(shape, ifcPolyLine);
//									} else if (ifcPolyLine.getDim() == 2) {
//										processPolyLine2D(shape, new Vector3f(), new Vector3f(), ifcPolyLine);
//									}
//								} else if (ifcRepresentationItem instanceof IfcExtrudedAreaSolid) {
//									IfcExtrudedAreaSolid ifcExtrudedAreaSolid = (IfcExtrudedAreaSolid) ifcRepresentationItem;
//									ifcExtrudedAreaSolid.getDepth();
//									IfcProfileDef sweptArea = ifcExtrudedAreaSolid.getSweptArea();
//									processProfileDef(shape, sweptArea, createVector3f(ifcExtrudedAreaSolid.getPosition().getAxis()), createVector3f(ifcExtrudedAreaSolid
//											.getExtrudedDirection()));
//								} else if (ifcRepresentationItem instanceof IfcFacetedBrep) {
//									IfcFacetedBrep ifcFacetedBrep = (IfcFacetedBrep) ifcRepresentationItem;
//									IfcClosedShell outer = ifcFacetedBrep.getOuter();
//									for (IfcFace ifcFace : outer.getCfsFaces()) {
//										for (IfcFaceBound ifcFaceBound : ifcFace.getBounds()) {
//											IfcLoop bound = ifcFaceBound.getBound();
//											if (bound instanceof IfcPolyLoop) {
//												IfcPolyLoop ifcPolyLoop = (IfcPolyLoop) bound;
//												if (ifcPolyLoop.getPolygon().size() == 4) {
//													QuadArray quadArray = new QuadArray(4, GeometryArray.COORDINATES);
//													int i = 0;
//													for (IfcCartesianPoint ifcCartesianPoint : ifcPolyLoop.getPolygon()) {
//														quadArray.setCoordinate(i++, createPoint3f(ifcCartesianPoint));
//													}
//													GeometryInfo info = new GeometryInfo(GeometryInfo.QUAD_ARRAY);
//													info.reset(quadArray);
//													NormalGenerator ng = new NormalGenerator();
//													ng.generateNormals(info);
//													GeometryArray result = info.getGeometryArray();
//													// dumpGeometryArray(result);
//													shape.addGeometry(result);
//												} else if (ifcPolyLoop.getPolygon().size() == 3) {
//													TriangleArray triangleArray = new TriangleArray(3, GeometryArray.COORDINATES);
//													int i = 0;
//													for (IfcCartesianPoint ifcCartesianPoint : ifcPolyLoop.getPolygon()) {
//														triangleArray.setCoordinate(i, createPoint3f(ifcCartesianPoint));
//													}
//													GeometryInfo info = new GeometryInfo(triangleArray);
//													NormalGenerator ng = new NormalGenerator();
//													ng.generateNormals(info);
//													GeometryArray result = info.getGeometryArray();
//													// dumpGeometryArray(result);
//													shape.addGeometry(result);
//												} else {
//													int i = 0;
//													Point3f points[] = new Point3f[ifcPolyLoop.getPolygon().size()];
//													for (IfcCartesianPoint ifcCartesianPoint : ifcPolyLoop.getPolygon()) {
//														points[i++] = createPoint3f(ifcCartesianPoint);
//													}
//													GeometryInfo info = new GeometryInfo(GeometryInfo.POLYGON_ARRAY);
//													info.setCoordinates(points);
//
//													int[] stripCountArray = { ifcPolyLoop.getPolygon().size() };
//													int[] countourCountArray = { stripCountArray.length };
//													info.setContourCounts(countourCountArray);
//													info.setStripCounts(stripCountArray);
//
//													Triangulator triangulator = new Triangulator();
//													triangulator.triangulate(info);
//
//													NormalGenerator normalGenerator = new NormalGenerator();
//													normalGenerator.generateNormals(info);
//
//													Stripifier st = new Stripifier();
//													st.stripify(info);
//
//													GeometryArray result = info.getGeometryArray();
//													// dumpGeometryArray(result);
//													shape.addGeometry(result);
//												}
//											} else {
//												System.out.println("Unimplemented bound: " + bound);
//											}
//										}
//									}
//								} else if (ifcRepresentationItem instanceof IfcBooleanClippingResult) {
//									IfcBooleanClippingResult ifcBooleanClippingResult = (IfcBooleanClippingResult) ifcRepresentationItem;
//									IfcBooleanOperand firstOperand = ifcBooleanClippingResult.getFirstOperand();
//									processBooleanOperand(shape, firstOperand);
//								} else {
//									System.out.println("Unimplemented representation item: " + ifcRepresentationItem);
//								}
//							}
//						}
//					}
//				}
//			}
//			buildingTransformGroup.addChild(mainGroup);
//		}
//	}
//
//	private Vector3f calculateNormal(Point3f p1, Point3f p2, Point3f p3) {
//		Vector3f a = new Vector3f();
//		Vector3f b = new Vector3f();
//		a.sub(p2, p1);
//		b.sub(p3, p1);
//		Vector3f normal = new Vector3f();
//		normal.cross(a, b);
//		normal.normalize();
//		return normal;
//	}
//	
//	private void processBooleanOperand(Shape3D shape, IfcBooleanOperand firstOperand) {
//		if (firstOperand instanceof IfcProfileDef) {
//			IfcProfileDef ifcProfileDef = (IfcProfileDef) firstOperand;
//			processProfileDef(shape, ifcProfileDef, new Vector3f(), new Vector3f());
//		} else if (firstOperand instanceof IfcBooleanClippingResult) {
//		} else if (firstOperand instanceof IfcExtrudedAreaSolid) {
//		} else {
//			System.out.println("Unimplemented IfcBooleanClippingResult firstOperand: " + firstOperand);
//		}
//	}
//
//	private void processProfileDef(Shape3D shape, IfcProfileDef sweptArea, Vector3f position, Vector3f direction) {
//		if (sweptArea instanceof IfcArbitraryClosedProfileDef) {
//			IfcArbitraryClosedProfileDef ifcArbitraryClosedProfileDef = (IfcArbitraryClosedProfileDef) sweptArea;
//			processArbitraryClosedProfileDef(shape, direction, position, ifcArbitraryClosedProfileDef);
//		} else if (sweptArea instanceof IfcRectangleProfileDef) {
//			IfcRectangleProfileDef ifcRectangleProfileDef = (IfcRectangleProfileDef) sweptArea;
//			float width = ifcRectangleProfileDef.getXDim();
//			float height = ifcRectangleProfileDef.getYDim();
//			// IfcAxis2Placement2D position =
//			// ifcRectangleProfileDef.getPosition();
//			// Vector3f location =
//			// createVector(position.getLocation());
//			// Vector3f direction =
//			// createVector(position.getRefDirection());
//		} else {
//			System.out.println("Unimplemented profile def: " + sweptArea);
//		}
//	}
//
//	private void processArbitraryClosedProfileDef(Shape3D shape, Vector3f sweptAreaDirection, Vector3f sweptAreaPosition, IfcArbitraryClosedProfileDef ifcArbitraryClosedProfileDef) {
//		IfcCurve outerCurve = ifcArbitraryClosedProfileDef.getOuterCurve();
//		if (outerCurve instanceof IfcPolyline) {
//			IfcPolyline ifcPolyLine = (IfcPolyline) outerCurve;
//			ifcPolyLine.setDim(ifcPolyLine.getPoints().get(0).getCoordinates().size());
//			if (ifcPolyLine.getDim() == 3) {
//				processPolyLine3D(shape, ifcPolyLine);
//			} else if (ifcPolyLine.getDim() == 2) {
//				processPolyLine2D(shape, sweptAreaDirection, sweptAreaPosition, ifcPolyLine);
//			}
//		} else {
//			System.out.println(outerCurve);
//		}
//	}
//
//	private Matrix3f t(Vector3f body) {
//		Vector3f vec_y = (Vector3f) body.clone();
//		vec_y.normalize();
//
//		Vector3f vec_x; // reference vector, will correct later
//		if (vec_y.x == 0 && vec_y.z == 0) {
//			vec_x = new Vector3f(-vec_y.y, 0f, 0f); // could be optimized
//		} else {
//			vec_x = new Vector3f(0f, 1f, 0f);
//		}
//
//		Vector3f vec_z = new Vector3f();
//		vec_z.cross(vec_x, vec_y);
//		vec_z.normalize();
//
//		vec_x.cross(vec_z, vec_y);
//		vec_x.normalize();
//		vec_x.negate();
//
//		Matrix3f rotation = new Matrix3f(vec_x.x, vec_x.y, vec_x.z, vec_y.x, vec_y.y, vec_y.z, vec_z.x, vec_z.y, vec_z.z);
//		rotation.invert();
//		return rotation;
//	}
//
//	private void processPolyLine2D(Shape3D shape, Vector3f sweptAreaDirection, Vector3f sweptAreaPosition, IfcPolyline ifcPolyLine) {
//		int i = 0;
//		Point3f points[] = new Point3f[ifcPolyLine.getPoints().size()];
//		if (ifcPolyLine.getPoints().size() == 2) {
//			System.out.println("2 vertices in polygon?");
//			return;
//		}
//		for (IfcCartesianPoint ifcCartesianPoint : ifcPolyLine.getPoints()) {
//			points[i++] = new Point3f(sweptAreaPosition.getX() + ifcCartesianPoint.getCoordinates().get(0), sweptAreaPosition.getY(), ifcCartesianPoint.getCoordinates().get(1)
//					+ sweptAreaPosition.getZ());
//		}
//		GeometryInfo info = new GeometryInfo(GeometryInfo.POLYGON_ARRAY);
//		info.setCoordinates(points);
//
//		int[] stripCountArray = { ifcPolyLine.getPoints().size() };
//		int[] countourCountArray = { stripCountArray.length };
//		info.setContourCounts(countourCountArray);
//		info.setStripCounts(stripCountArray);
//
//		Triangulator triangulator = new Triangulator();
//		triangulator.triangulate(info);
//
//		NormalGenerator normalGenerator = new NormalGenerator();
//		normalGenerator.generateNormals(info);
//
//		Stripifier st = new Stripifier();
//		st.stripify(info);
//
//		GeometryArray result = info.getGeometryArray();
//		shape.addGeometry(result);
//	}
//
//	private void processPolyLine3D(Shape3D shape, IfcPolyline ifcPolyLine) {
//		if (ifcPolyLine.getDim() == 2) {
//			System.out.println("2 dimensions not implemented");
//			// int i = 0;
//			// Point2f points[] = new Point2f[ifcPolyLine.getPoints().size()];
//			// for (IfcCartesianPoint ifcCartesianPoint :
//			// ifcPolyLine.getPoints()) {
//			// points[i++] = createPoint2f(ifcCartesianPoint);
//			// }
//			// GeometryInfo info = new GeometryInfo(GeometryInfo.POLYGON_ARRAY);
//			// info.setCoordinates(points);
//			//			
//			// int[] stripCountArray = { ifcPolyLine.getPoints().size()};
//			// int[] countourCountArray = { stripCountArray.length };
//			// info.setContourCounts(countourCountArray);
//			// info.setStripCounts(stripCountArray);
//			//			
//			// Triangulator triangulator = new Triangulator();
//			// triangulator.triangulate(info);
//			//			
//			// NormalGenerator normalGenerator = new NormalGenerator();
//			// normalGenerator.generateNormals( info );
//			//			
//			// Stripifier st = new Stripifier();
//			// st.stripify(info);
//			//			
//			// GeometryArray result = info.getGeometryArray();
//			// // dumpGeometryArray(result);
//			// shape.addGeometry(result);
//		} else if (ifcPolyLine.getDim() == 3) {
//			int i = 0;
//			Point3f points[] = new Point3f[ifcPolyLine.getPoints().size()];
//			for (IfcCartesianPoint ifcCartesianPoint : ifcPolyLine.getPoints()) {
//				points[i++] = createPoint3f(ifcCartesianPoint);
//			}
//			GeometryInfo info = new GeometryInfo(GeometryInfo.POLYGON_ARRAY);
//			info.setCoordinates(points);
//
//			int[] stripCountArray = { ifcPolyLine.getPoints().size() };
//			int[] countourCountArray = { stripCountArray.length };
//			info.setContourCounts(countourCountArray);
//			info.setStripCounts(stripCountArray);
//
//			Triangulator triangulator = new Triangulator();
//			triangulator.triangulate(info);
//
//			NormalGenerator normalGenerator = new NormalGenerator();
//			normalGenerator.generateNormals(info);
//
//			Stripifier st = new Stripifier();
//			st.stripify(info);
//
//			GeometryArray result = info.getGeometryArray();
//			// dumpGeometryArray(result);
//			shape.addGeometry(result);
//		} else {
//			System.out.println(ifcPolyLine.getDim() + " dimensions not implemented");
//		}
//
//		// if (ifcPolyLine.getPoints().size() == 3) {
//		// int nrNumbers = ifcPolyLine.getPoints().size();
//		// Point3f[] coordinates = new Point3f[nrNumbers];
//		// Vector3f[] normals = new Vector3f[nrNumbers];
//		// int i = 0;
//		// for (IfcCartesianPoint ifcCartesianPoint : ifcPolyLine.getPoints()) {
//		// Point3f point = new Point3f();
//		// point.set(ifcCartesianPoint.getCoordinates().get(0),
//		// ifcCartesianPoint.getCoordinates().get(1),
//		// ifcCartesianPoint.getCoordinates().get(
//		// 2));
//		// coordinates[i] = point;
//		// i++;
//		// }
//		// Vector3f normal = calculateNormal(coordinates[0], coordinates[1],
//		// coordinates[2]);
//		// normals[0] = normal;
//		// normals[1] = normal;
//		// normals[2] = normal;
//		// TriangleArray triangleArray = new TriangleArray(coordinates.length,
//		// GeometryArray.COORDINATES | GeometryArray.NORMALS);
//		// triangleArray.setCoordinates(0, coordinates);
//		// triangleArray.setNormals(0, normals);
//		// shape.addGeometry(triangleArray);
//		// }
//	}
//
//	private void dumpGeometryArray(GeometryArray result) {
//		for (int x = 0; x < result.getVertexCount(); x++) {
//			Point3f point3d = new Point3f();
//			Vector3f vector3f = new Vector3f();
//			result.getCoordinate(x, point3d);
//			result.getNormal(x, vector3f);
//			System.out.println(vector3f);
//		}
//	}
//
//	private Vector3f createVector3f(IfcDirection refDirection) {
//		return new Vector3f(refDirection.getDirectionRatios().get(0), refDirection.getDirectionRatios().get(1), refDirection.getDirectionRatios().get(2));
//	}
//
//	private Vector3f createVector3f(IfcCartesianPoint ifcCartesianPoint) {
//		return new Vector3f(ifcCartesianPoint.getCoordinates().get(0), ifcCartesianPoint.getCoordinates().get(1), ifcCartesianPoint.getCoordinates().get(2));
//	}
//
//	private Point3f createPoint3f(IfcCartesianPoint ifcCartesianPoint) {
//		return new Point3f(ifcCartesianPoint.getCoordinates().get(0), ifcCartesianPoint.getCoordinates().get(1), ifcCartesianPoint.getCoordinates().get(2));
//	}
//
//	private Point2f createPoint2f(IfcCartesianPoint ifcCartesianPoint) {
//		return new Point2f(ifcCartesianPoint.getCoordinates().get(0), ifcCartesianPoint.getCoordinates().get(1));
//	}
//}
