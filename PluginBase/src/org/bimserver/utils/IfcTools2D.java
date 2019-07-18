package org.bimserver.utils;

import java.awt.Rectangle;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.bimserver.emf.IdEObject;
import org.bimserver.geometry.Matrix;
import org.bimserver.geometry.Vector;
import org.bimserver.models.geometry.GeometryData;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.IfcArbitraryClosedProfileDef;
import org.bimserver.models.ifc2x3tc1.IfcArbitraryProfileDefWithVoids;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcCompositeCurve;
import org.bimserver.models.ifc2x3tc1.IfcCompositeCurveSegment;
import org.bimserver.models.ifc2x3tc1.IfcCurve;
import org.bimserver.models.ifc2x3tc1.IfcDirection;
import org.bimserver.models.ifc2x3tc1.IfcExtrudedAreaSolid;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcObjectPlacement;
import org.bimserver.models.ifc2x3tc1.IfcPolyline;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcProfileDef;
import org.bimserver.models.ifc2x3tc1.IfcRectangleProfileDef;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationItem;
import org.bimserver.models.ifc2x3tc1.IfcShapeRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcTrimmedCurve;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcTools2D {
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcTools2D.class);
	
	private final Map<String, AtomicInteger> unimplementedGeometryTypes = new HashMap<>();
	
	public Area get2D(IfcProduct ifcProduct, double multiplierMillimeters) {
		IfcObjectPlacement objectPlacement = ifcProduct.getObjectPlacement();
		double[] productMatrix = placementToMatrix(objectPlacement);
//		Matrix.dump(productMatrix);

		IfcProductRepresentation representation = ifcProduct.getRepresentation();
		if (representation == null) {
			return null;
		}
		for (IfcRepresentation ifcRepresentation : representation.getRepresentations()) {
			if ("Curve2D".equals(ifcRepresentation.getRepresentationType())) {
				// Skip
			} else {
				if (ifcRepresentation instanceof IfcShapeRepresentation) {
					IfcShapeRepresentation ifcShapeRepresentation = (IfcShapeRepresentation) ifcRepresentation;
					for (IfcRepresentationItem ifcRepresentationItem : ifcShapeRepresentation.getItems()) {
						Area area = getArea(multiplierMillimeters, productMatrix, ifcRepresentationItem);
						if (area != null && area.getPathIterator(null).isDone()) {
							return area;
						}
					}
				}
			}
		}

		// Fall back to 3D geometry projected from the top
		GeometryInfo geometry = ifcProduct.getGeometry();
		if (geometry != null) {
			GeometryData geometryData = geometry.getData();
			if (geometryData != null) {
				int[] indices = GeometryUtils.toIntegerArray(geometryData.getIndices().getData());
				float[] vertices = GeometryUtils.toFloatArray(geometryData.getVertices().getData());
				double[] matrix = GeometryUtils.toDoubleArray(geometry.getTransformation());
				
				Area area = new Area();
				
				for (int i=0; i<indices.length; i+=3) {
					int index1 = indices[i + 0];
					int index2 = indices[i + 1];
					int index3 = indices[i + 2];

					float[] a = new float[]{vertices[index1 * 3], vertices[index1 * 3 + 1], vertices[index1 * 3 + 2]};
					float[] b = new float[]{vertices[index2 * 3], vertices[index2 * 3 + 1], vertices[index2 * 3 + 2]};
					float[] c = new float[]{vertices[index3 * 3], vertices[index3 * 3 + 1], vertices[index3 * 3 + 2]};

					float[][] points = new float[][]{a, b, c};
					
//					if (similar(a[2], b[2], c[2])) {
						boolean first = true;
						Path2D.Float path = new Path2D.Float();
						for (int j=0; j<3; j++) {
							float[] point = points[j];
							float[] res = new float[4];
							Matrix.multiplyMV(res, 0, matrix, 0, new double[]{point[0], point[1], point[2], 1}, 0);
							
							float x = (float) (res[0] * multiplierMillimeters);
							float y = (float) (res[1] * multiplierMillimeters);
							if (first) {
								path.moveTo(x, y);
								first = false;
							} else {
								path.lineTo(x, y);
							}
						}
						path.closePath();
						area.add(new Area(path));
//					}
				}
				return area;
			}
		} else {
			LOGGER.info("No geometry generated for " + ifcProduct);
		}
		
		return null;
	}
	
	private static boolean similar(float... floats) {
		float max = -Float.MAX_VALUE;
		float min = Float.MAX_VALUE;
		for (float f : floats) {
			if (f > max) {
				max = f;
			}
			if (f < min) {
				min = f;
			}
		}
		return max - min < 0.1f;
	}

	private Area getArea(double multiplierMillimeters, double[] productMatrix, IfcRepresentationItem ifcRepresentationItem) {
		if (ifcRepresentationItem instanceof IfcExtrudedAreaSolid) {
			IfcExtrudedAreaSolid ifcExtrudedAreaSolid = (IfcExtrudedAreaSolid) ifcRepresentationItem;
			IfcAxis2Placement3D position = ifcExtrudedAreaSolid.getPosition();
			
//							1 0 0 0 <- 3de argument
//							0 1 0 0 <- cross product van 2 en 3 (levert ortogonale vector op)
//							0 0 1 0 <- 2st argument
//							5 0 0 1 <- 1st argument
			
			double[] matrix = placement3DToMatrix(position);
			if (productMatrix != null) {
				double[] rhs = matrix;
				matrix = Matrix.identity();
				Matrix.multiplyMM(matrix, 0, productMatrix, 0, rhs, 0);
			}
			
			IfcDirection extrudedDirection = ifcExtrudedAreaSolid.getExtrudedDirection();
			// TODO do something with this
			
			IfcProfileDef ifcProfileDef = ifcExtrudedAreaSolid.getSweptArea();
			if (ifcProfileDef instanceof IfcArbitraryProfileDefWithVoids) {
				IfcArbitraryProfileDefWithVoids ifcArbitraryProfileDefWithVoids = (IfcArbitraryProfileDefWithVoids) ifcProfileDef;
				IfcCurve outerCurve = ifcArbitraryProfileDefWithVoids.getOuterCurve();
				Path2D outerPath = null;
				if (outerCurve instanceof IfcPolyline) {
					outerPath = curveToPath(matrix, outerCurve, multiplierMillimeters);
				} else {
					storeUnimplemented(outerCurve);
				}

				if (outerPath != null) {
					Area area = new Area(outerPath);
					for (IfcCurve innerCurve : ifcArbitraryProfileDefWithVoids.getInnerCurves()) {
						Path2D.Float innerPath = curveToPath(matrix, innerCurve, multiplierMillimeters);
						if (innerPath != null) {
							area.subtract(new Area(innerPath));
						}
					}
					return area;
				}
			} else if (ifcProfileDef instanceof IfcArbitraryClosedProfileDef) {
				IfcArbitraryClosedProfileDef ifcArbitraryClosedProfileDef = (IfcArbitraryClosedProfileDef) ifcProfileDef;
				Path2D.Float path2d = new Path2D.Float();
				IfcCurve outerCurve = ifcArbitraryClosedProfileDef.getOuterCurve();
				boolean first = true;
				if (outerCurve instanceof IfcPolyline) {
					IfcPolyline ifcPolyline = (IfcPolyline) outerCurve;

					double[] res = new double[4];

					int i=0;
					for (IfcCartesianPoint cartesianPoint : ifcPolyline.getPoints()) {
						EList<Double> coords = cartesianPoint.getCoordinates();

						Matrix.multiplyMV(res, 0, matrix, 0, new double[]{coords.get(0), coords.get(1), 0, 1}, 0);
						
						if (first) {
							path2d.moveTo(res[0] * multiplierMillimeters, res[1] * multiplierMillimeters);
							first = false;
						} else {
							if (i > 1) {
								
							}
							path2d.lineTo(res[0] * multiplierMillimeters, res[1] * multiplierMillimeters);
						}
						i++;
					}
					path2d.closePath();

					return new Area(path2d);
				} else if (outerCurve instanceof IfcCompositeCurve) {
					IfcCompositeCurve ifcCompositeCurve = (IfcCompositeCurve)outerCurve;

					for (IfcCompositeCurveSegment ifcCompositeCurveSegment : ifcCompositeCurve.getSegments()) {
						IfcCurve curve = ifcCompositeCurveSegment.getParentCurve();
						if (curve instanceof IfcPolyline) {
							IfcPolyline ifcPolyline = (IfcPolyline)curve;
							double[] res = new double[4];
							for (IfcCartesianPoint cartesianPoint : ifcPolyline.getPoints()) {
								EList<Double> coords = cartesianPoint.getCoordinates();

								Matrix.multiplyMV(res, 0, matrix, 0, new double[]{coords.get(0), coords.get(1), 0, 1}, 0);
								
								if (first) {
									path2d.moveTo(res[0] * multiplierMillimeters, res[1] * multiplierMillimeters);
									first = false;
								} else {
									path2d.lineTo(res[0] * multiplierMillimeters, res[1] * multiplierMillimeters);
								}
							}
						} else if (curve instanceof IfcTrimmedCurve) {
							storeUnimplemented(curve);
						} else {
							storeUnimplemented(curve);
						}
					}
					try {
						path2d.closePath();
						return new Area(path2d);
					} catch (Exception e) {
						//
					}
				}
			} else if (ifcProfileDef instanceof IfcRectangleProfileDef) {
				IfcRectangleProfileDef ifcRectangleProfileDef = (IfcRectangleProfileDef) ifcProfileDef;

				double[] min = new double[]{ifcRectangleProfileDef.getPosition().getLocation().getCoordinates().get(0) - ifcRectangleProfileDef.getXDim() / 2, ifcRectangleProfileDef.getPosition().getLocation().getCoordinates().get(1) - ifcRectangleProfileDef.getYDim() / 2, 0, 1};
				double[] max = new double[]{ifcRectangleProfileDef.getPosition().getLocation().getCoordinates().get(0) + ifcRectangleProfileDef.getXDim() / 2, ifcRectangleProfileDef.getPosition().getLocation().getCoordinates().get(1) + ifcRectangleProfileDef.getYDim() / 2, 0, 1};

				Cube cube = new Cube(min, max);
				cube.transform(matrix);
				double[] transformedMin = cube.getMin();
				double[] transformedMax = cube.getMax();
				
				Path2D.Float path2d = new Path2D.Float();
				path2d.moveTo(transformedMin[0] * multiplierMillimeters, transformedMin[1] * multiplierMillimeters);
				path2d.lineTo(transformedMax[0] * multiplierMillimeters, transformedMin[1] * multiplierMillimeters);
				path2d.lineTo(transformedMax[0] * multiplierMillimeters, transformedMax[1] * multiplierMillimeters);
				path2d.lineTo(transformedMin[0] * multiplierMillimeters, transformedMax[1] * multiplierMillimeters);
				path2d.lineTo(transformedMin[0] * multiplierMillimeters, transformedMin[1] * multiplierMillimeters);
				
				path2d.closePath();
				return new Area(path2d);
			} else {
				storeUnimplemented(ifcProfileDef);
			}
		} else if (ifcRepresentationItem instanceof IfcPolyline) {
			IfcPolyline ifcPolyline = (IfcPolyline)ifcRepresentationItem;
			double[] res = new double[4];
			Path2D.Float path2d = new Path2D.Float();
			boolean first = true;

			for (IfcCartesianPoint cartesianPoint : ifcPolyline.getPoints()) {
				EList<Double> coords = cartesianPoint.getCoordinates();
				Matrix.multiplyMV(res, 0, productMatrix, 0, new double[]{coords.get(0), coords.get(1), 0, 1}, 0);
				
				if (first) {
					path2d.moveTo(res[0] * multiplierMillimeters, res[1] * multiplierMillimeters);
					first = false;
				} else {
					path2d.lineTo(res[0] * multiplierMillimeters, res[1] * multiplierMillimeters);
				}
			}
			path2d.closePath();
			return new Area(path2d);
		} else {
			storeUnimplemented(ifcRepresentationItem);
		}
		return null;
	}

	private void storeUnimplemented(IdEObject ifcRepresentationItem) {
		if (unimplementedGeometryTypes.containsKey(ifcRepresentationItem.eClass().getName())) {
			unimplementedGeometryTypes.get(ifcRepresentationItem.eClass().getName()).incrementAndGet();
		} else {
			unimplementedGeometryTypes.put(ifcRepresentationItem.eClass().getName(), new AtomicInteger(1));
		}
	}

	public static double[] placement3DToMatrix(IfcAxis2Placement3D ifcAxis2Placement3D) {
		if (ifcAxis2Placement3D.getAxis() != null && ifcAxis2Placement3D.getRefDirection() != null) {
			double[] cross = Vector.crossProduct(new double[]{ifcAxis2Placement3D.getAxis().getDirectionRatios().get(0), ifcAxis2Placement3D.getAxis().getDirectionRatios().get(1), ifcAxis2Placement3D.getAxis().getDirectionRatios().get(2), 1}, new double[]{ifcAxis2Placement3D.getRefDirection().getDirectionRatios().get(0), ifcAxis2Placement3D.getRefDirection().getDirectionRatios().get(1), ifcAxis2Placement3D.getRefDirection().getDirectionRatios().get(2), 1});
			return new double[]{
					ifcAxis2Placement3D.getRefDirection().getDirectionRatios().get(0), ifcAxis2Placement3D.getRefDirection().getDirectionRatios().get(1), ifcAxis2Placement3D.getRefDirection().getDirectionRatios().get(2), 0,
					cross[0], cross[1], cross[2], 0,
					ifcAxis2Placement3D.getAxis().getDirectionRatios().get(0), ifcAxis2Placement3D.getAxis().getDirectionRatios().get(1), ifcAxis2Placement3D.getAxis().getDirectionRatios().get(2), 0,
					ifcAxis2Placement3D.getLocation().getCoordinates().get(0), ifcAxis2Placement3D.getLocation().getCoordinates().get(1), ifcAxis2Placement3D.getLocation().getCoordinates().get(2), 1
			};
		} else if (ifcAxis2Placement3D.getLocation() != null) {
			return new double[]{
					1, 0, 0, 0,
					0, 1, 0, 0,
					0, 0, 1, 0,
					ifcAxis2Placement3D.getLocation().getCoordinates().get(0), ifcAxis2Placement3D.getLocation().getCoordinates().get(1), ifcAxis2Placement3D.getLocation().getCoordinates().get(2), 1
			};
		}
		return Matrix.identity();
	}

	public static double[] placementToMatrix(IfcObjectPlacement objectPlacement) {
		double[] matrix = Matrix.identity();
		if (objectPlacement instanceof IfcLocalPlacement) {
			IfcLocalPlacement ifcLocalPlacement = (IfcLocalPlacement)objectPlacement;
			IfcAxis2Placement relativePlacement = ifcLocalPlacement.getRelativePlacement();
			if (relativePlacement instanceof IfcAxis2Placement3D) {
				IfcAxis2Placement3D ifcAxis2Placement3D = (IfcAxis2Placement3D)relativePlacement;
				matrix = placement3DToMatrix(ifcAxis2Placement3D);
			}
			IfcObjectPlacement relativeTo = ifcLocalPlacement.getPlacementRelTo();
			if (relativeTo != null) {
				double[] baseMatrix = placementToMatrix(relativeTo);
				double[] rhs = matrix;
				matrix = Matrix.identity();
				Matrix.multiplyMM(matrix, 0, baseMatrix, 0, rhs, 0);
			}
		}

		return matrix;
	}

	private static Path2D.Float curveToPath(double[] matrix, IfcCurve outerCurve, double multiplierMillimeters) {
		Path2D.Float path2d = new Path2D.Float();
		if (outerCurve instanceof IfcPolyline) {
			IfcPolyline ifcPolyline = (IfcPolyline) outerCurve;
			IfcCartesianPoint first = ifcPolyline.getPoints().get(0);
			double[] res = new double[4];
			
			Matrix.multiplyMV(res, 0, matrix, 0, new double[]{first.getCoordinates().get(0), first.getCoordinates().get(1), 0, 1}, 0);
			path2d.moveTo(res[0] * multiplierMillimeters, res[1] * multiplierMillimeters);
			
			for (IfcCartesianPoint cartesianPoint : ifcPolyline.getPoints()) {
				EList<Double> coords = cartesianPoint.getCoordinates();
				Matrix.multiplyMV(res, 0, matrix, 0, new double[]{coords.get(0), coords.get(1), 0, 1}, 0);
				path2d.lineTo(res[0] * multiplierMillimeters, res[1] * multiplierMillimeters);
			}
			path2d.closePath();
			return path2d;
		}
		return null;
	}
	
	public static void main(String[] args) {
		Path2D.Float path = new Path2D.Float();
		path.moveTo(0, 0);
		path.lineTo(0, 10);
		path.lineTo(10, 10);
		path.lineTo(10, 0);
		path.closePath();
		
		System.out.println(getArea(new Area(path)));

		path = new Path2D.Float();
		path.moveTo(1, 1);
		path.lineTo(3, 1);
		path.lineTo(3, -3);
		path.lineTo(1, -3);
		path.closePath();
		
		System.out.println(getArea(new Area(path)));
		
		Rectangle rectangle = new Rectangle(24000, 2300, 8900, 4400);
		Area newArea = new Area(rectangle);
		System.out.println(getArea(newArea) / 1000000);

		rectangle = new Rectangle(24000, 9299, 2900, 4400);
		newArea = new Area(rectangle);
		System.out.println(getArea(newArea) / 1000000);
	}
	
	public static Path2D enlargeSlightlyInPlace(Path2D path2d) {
		AffineTransform aLittleLarger = new AffineTransform();
		double centerX = path2d.getBounds2D().getCenterX();
		double centerY = path2d.getBounds2D().getCenterY();
		aLittleLarger.translate(centerX, centerY);
		aLittleLarger.scale(1.01, 1.01);
		aLittleLarger.translate(-centerX, -centerY);

		path2d.transform(aLittleLarger);
		return path2d;
	}

	public static Area enlargeSlightlyInPlace(Area area) {
		return enlargeSlightlyInPlace(area, 1.01f);
	}
	
	public static Area enlargeSlightlyInPlace(Area area, float scale) {
		AffineTransform aLittleLarger = new AffineTransform();
		double centerX = area.getBounds2D().getCenterX();
		double centerY = area.getBounds2D().getCenterY();
		aLittleLarger.translate(centerX, centerY);
		aLittleLarger.scale(scale, scale);
		aLittleLarger.translate(-centerX, -centerY);
		
		area.transform(aLittleLarger);
		return area;
	}
	
	public static boolean containsAllPoints(Area areaOutside, Area areaInside) {
		Area clone = (Area) areaOutside.clone();
		IfcTools2D.enlargeSlightlyInPlace(clone);
		PathIterator iterator = areaInside.getPathIterator(null);
		double[] coords = new double[6];
		boolean allInside = true;
		while (!iterator.isDone()) {
			iterator.currentSegment(coords);
			if (!clone.contains(new Point2D.Double(coords[0], coords[1]))) {
				allInside = false;
				break;
			}
			iterator.next();
		}
		return allInside;
	}
	
	public static Area findSmallest(Area area) {
		if (area.isSingular()) {
			System.out.println("Is singular");
			return null;
		}
		PathIterator pathIterator = area.getPathIterator(null);
		Path2D.Double tmp = new Path2D.Double();
		Path2D.Double smallest = null;
		Path2D smallestPath = null;
		while (!pathIterator.isDone()) {
			double[] coords = new double[6];
			int type = pathIterator.currentSegment(coords);
			if (type == 0) {
				tmp.moveTo(coords[0], coords[1]);
			} else if (type == 4) {
				tmp.closePath();
				
				if (smallestPath == null || IfcTools2D.containsAllPoints(new Area(smallestPath), new Area(new Path2D.Double(tmp)))) {
					smallestPath = new Path2D.Double(tmp);
					enlargeSlightlyInPlace(smallestPath);
					smallest = tmp;
				}
				tmp = new Path2D.Double();
			} else if (type == 1) {
				tmp.lineTo(coords[0], coords[1]);
			}
			pathIterator.next();
		}
		if (smallest != null) {
			return new Area(smallest);
		}
		return null;
	}
	
	public static float getArea(Area area) {
		float sum = 0;
		PathIterator pathIterator = area.getPathIterator(null);
		float[] coords = new float[6];
		float[] last = null;
		float[] first = null;
		float[] lastMoveTo = null;
		while (!pathIterator.isDone()) {
			int currentSegment = pathIterator.currentSegment(coords);
			if (currentSegment == PathIterator.SEG_CLOSE) {
//				sum += lastMoveTo[0] * coords[1] - lastMoveTo[1] * coords[0];
				last = new float[]{coords[0], coords[1]};
			} else if (currentSegment == PathIterator.SEG_MOVETO) {
				lastMoveTo = new float[]{coords[0], coords[1]};
				last = new float[]{coords[0], coords[1]};
				if (first == null) {
					first = new float[]{coords[0], coords[1]};
				}
			} else if (currentSegment == PathIterator.SEG_LINETO) {
				if (last != null) {
					sum += last[0] * coords[1] - last[1] * coords[0];
				}

				last = new float[]{coords[0], coords[1]};
			} else {
				LOGGER.info("Unimplemented segment: " + currentSegment);
			}
			pathIterator.next();
		}
		if (last != null && first != null) {
			sum += last[0] * first[1] - last[1] * first[0];
		}
		return Math.abs(sum / 2f);
	}

	public void dumpStatistics() {
		if (unimplementedGeometryTypes.size() > 0) {
			LOGGER.info("Unimplemented geometry:");
			for (String type : unimplementedGeometryTypes.keySet()) {
				LOGGER.info("\t" + type + " " + unimplementedGeometryTypes.get(type).get());
			}
		}
	}
}