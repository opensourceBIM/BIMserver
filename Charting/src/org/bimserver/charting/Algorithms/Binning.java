package org.bimserver.charting.Algorithms;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.bimserver.charting.Containers.Bin;
import org.bimserver.charting.Containers.BinCollection;
import org.bimserver.charting.Containers.ChartRow;
import org.bimserver.charting.Containers.ChartRows;
import org.bimserver.charting.Delegates.IModulateValueDelegate;
import org.bimserver.charting.Dimensions.ModelDimension;
import org.openmali.vecmath2.Vector2d;

public class Binning {

	/**
	 * Basis of the polygon (in radians). For non-self-intersecting shapes, this is 180 degrees, which is PI. This is equivalent to stating that any interior angle of a closed polygon must be less than 180 degrees to not be self-intersecting.
	 */
	public static final double AngleBasis = Math.PI;

	/**
	 * Used to generate the shape.
	 */
	public double DistanceToAngle = 0;
	/**
	 * Sides of the symmetrical polygon within which to consider data. Must be greater than 2 to be useful.
	 */
	public int NumberOfSides = 4;
	/**
	 * Used to scale down incoming x and y values.
	 */
	public Vector2d Delta = Vector2d.ZERO;
	// Methods to modulate just incoming x and just incoming y values (useful for scaling using ChartExtent).
	public IModulateValueDelegate<Double> XHandler = null;
	public IModulateValueDelegate<Double> YHandler = null;

	/**
 	 * Repeated interior angle of the symmetric polygon (in radians).
	 *
	 * For equilateral triangles: 60 degrees, which yields exterior angles of 120 degrees, which is 2 * PI / 3.
	 * For squares: 90 degrees, which yields exterior angles of 90 degrees, which is PI / 2.
	 * For pentagon: 108 degrees, which yields exterior angles of 72 degrees, which is 2 * PI / 5.
	 * For hexagons: 120 degrees, which yields exterior angles of 60 degrees, which is PI / 3.
	 * @return the interiorAngle
	 */
	public double getInteriorAngle() {
		// Interior angle given number of sides as n: 180 - (360 / n)
		if (NumberOfSides > 2)
			return 2 * Math.PI / NumberOfSides;
		// Default back to the angle of an equilateral triangle (60 degrees). 
		return 2 * Math.PI / 3.0;
	}

	/**
	 * @return the exteriorAngle
	 */
	public double getExteriorAngle() {
		return AngleBasis - getInteriorAngle();
	}

	/**
	 * @return the distanceToAngle
	 */
	public double getDistanceToAngle() {
		return DistanceToAngle;
	}

	/**
	 * @param distanceToAngle the distanceToAngle to set
	 */
	public void setDistanceToAngle(double distanceToAngle) {
		DistanceToAngle = distanceToAngle;
		Delta = calculateDelta();
	}

	/**
	 * @return the xHandler
	 */
	public IModulateValueDelegate<Double> getXHandler() {
		return XHandler;
	}

	/**
	 * @param xHandler the xHandler to set
	 */
	public void setXHandler(IModulateValueDelegate<Double> xHandler) {
		XHandler = xHandler;
	}

	/**
	 * @return the yHandler
	 */
	public IModulateValueDelegate<Double> getYHandler() {
		return YHandler;
	}

	/**
	 * @param yHandler the yHandler to set
	 */
	public void setYHandler(IModulateValueDelegate<Double> yHandler) {
		YHandler = yHandler;
	}

	/**
	 * @param distanceToAngle
	 * @param numberOfSides
	 */
	public Binning(double distanceToAngle, int numberOfSides) {
		this(distanceToAngle, numberOfSides, null, null);
	}

	/**
	 * @param distanceToAngle
	 * @param numberOfSides
	 * @param xHandler
	 * @param yHandler
	 */
	public Binning(double distanceToAngle, int numberOfSides, IModulateValueDelegate<Double> xHandler, IModulateValueDelegate<Double> yHandler) {
		super();
		// Shape.
		NumberOfSides = numberOfSides;
		setDistanceToAngle(distanceToAngle);
		// Handlers.
		XHandler = xHandler;
		YHandler = yHandler;
	}

	/**
	 * @return
	 */
	public Vector2d calculateDelta() {
		double exteriorAngle = getExteriorAngle();
		// Using the exterior angle (180 - interior angle), find the ratio of the two non-real sides (re: the hypotenuse is the actual line that exists in the shape being drawn).
		double ratioOfOppositeSideToHypotenuseInRightTriangle = Math.sin(exteriorAngle);
		double ratioOfAdjacentSideToHypotenuseInRightTriangle = Math.cos(exteriorAngle);
		// Send back a delta, such that an exterior angle of 60 degrees (PI / 3.0) yields: (1.73205, 1.5).
		return new Vector2d(
			2.0 * DistanceToAngle * ratioOfOppositeSideToHypotenuseInRightTriangle,
			3.0 * DistanceToAngle * ratioOfAdjacentSideToHypotenuseInRightTriangle
		);
	}

	/**
	 * Get bins (a bin is variant of an ArrayList<Vector2d> object) containing data points. This is done to query length.
	 *
	 * @param filteredData
	 * @return
	 */
	public BinCollection getBinsById(ModelDimension x, ModelDimension y, ChartRows filteredData) {
		LinkedHashMap<String, Bin> binsById = new LinkedHashMap<String, Bin>();
		boolean xHandlerIsValid = XHandler != null;
		boolean yHandlerIsValid = YHandler != null;
		if (x != null && y != null) {
			for (ChartRow row : filteredData) {
				// Create place holders for values.
				Vector2d point = new Vector2d();
				Vector2d worldSpacePoint = new Vector2d();
				// Get filtered raw values.
				ArrayList<Object> xValues = row.get(x);
				ArrayList<Object> yValues = row.get(y);
				// Coerce the values. Also, modulate them based on the supplied handlers.
				if (xValues.size() > 0) {
					Object testValue = xValues.get(0);
					if (testValue instanceof Number) {
						Double actualValue = ((Number)testValue).doubleValue();
						point.x(actualValue);
						if (xHandlerIsValid)
							worldSpacePoint.x(XHandler.modulate(actualValue));
						else
							worldSpacePoint.x(actualValue);
					}
				}
				if (yValues.size() > 0) {
					Object testValue = yValues.get(0);
					if (testValue instanceof Number) {
						Double actualValue = ((Number)testValue).doubleValue();
						point.y(actualValue);
						if (yHandlerIsValid)
							worldSpacePoint.y(YHandler.modulate(actualValue));
						else
							worldSpacePoint.y(actualValue);
					}
				}
				handlePointAndIndex(point, worldSpacePoint, binsById);
			}
		}
		// Send it back. Implicitly caches lower and upper lengths.
		return new BinCollection(binsById.values());
	}

	public void handlePointAndIndex(Vector2d point, Vector2d worldSpacePoint, LinkedHashMap<String, Bin> existingBins) {
		// Distance formula: c^2 = a^2 + b^2
		// Calculate world space y as a ratio to the delta y.
		double py = worldSpacePoint.y() / Delta.y();
		// Derivisions from py.
		int pj = (int)Math.round(py);
		// Indent row if y value is not even.
		boolean pjIsNotEvenAtThisPoint = (Math.abs(pj % 2) == 1);
		// "b" of distance formula.
		//double bOfWorldSpaceRoundingDeviation = py - pj;
		// Calculate world space x as a ratio to the delta x.
		double px = worldSpacePoint.x() / Delta.x() - (pjIsNotEvenAtThisPoint ? .5 : 0);
		// Derivisions from px.
		int pi = (int)Math.round(px);
		// TODO: Figure out what this case represents. It's less of a priority because it destroys the syntactical notion of the variable "pi" (not to be confused with Math.PI) as an integer.
		/*if (Math.abs(bOfWorldSpaceRoundingDeviation) * 3 > 1) {
			// "a" of distance formula.
			double aOfWorldSpaceRoundingDeviation = px - pi;
			// Figure out if the world space values were rounded up.
			boolean xWasRoundedUp = (px < pi) ? true : false;
			boolean yWasRoundedUp = (py < pj) ? true : false;
			//
			double pi2 = pi + (xWasRoundedUp ? -0.5 : 0.5);
			int pj2 = pj + (yWasRoundedUp ? -1 : 1);
			double aOfWorldSpaceRecentering = px - pi2;
			double bOfWorldSpaceRecentering = py - pj2;
			// The penultimate step of the distance function to the rounded coordinates, left as-is for comparison.
			double cSquaredOfWorldSpaceRoundingDeviation = Math.pow(aOfWorldSpaceRoundingDeviation, 2) + Math.pow(bOfWorldSpaceRoundingDeviation, 2);
			// The penultimate step of the distance function to the recentered coordinates, left as-is for comparison.
			double cSquaredOfWorldSpaceRecentering = Math.pow(aOfWorldSpaceRecentering, 2) + Math.pow(bOfWorldSpaceRecentering, 2);
			// ADDITION: Avoid denaturing integer.
			double piNot = pi;
			// If the rounded coordinates are farther away, use the recentered ones.
			if (cSquaredOfWorldSpaceRoundingDeviation > cSquaredOfWorldSpaceRecentering) {
				piNot = (pjIsNotEvenAtThisPoint) ? pi2 + 0.5 : pi2 - 0.5;
				pj = pj2;
				pjIsNotEvenAtThisPoint = (pj % 2 == 1);
			}
			// Create ID for bin in format of WorldSpaceX-WorldSpaceY.
			String id = String.format("%s-%s", piNot, pj);
			// If ID a already exists, add the point.
			if (existingBins.containsKey(id)) {
				Bin bin = existingBins.get(id);
				bin.add(point);
			}
			// Otherwise, create a bin and set the appropriate locations.
			else {
				Bin thisBin = new Bin(Arrays.asList(point));
				// Center in world space.
				thisBin.WorldSpaceLocation = new Vector2d(piNot, pj);
				// Center in raw data as (cx, cy).
				double modifier = (pjIsNotEvenAtThisPoint) ? 0.5 : 0;
				double cx = (piNot + modifier) * Delta.x();
				double cy = pj * Delta.y();
				thisBin.Location = new Vector2d(cx, cy);
				// Add bin.
				existingBins.put(id, thisBin);
			}
		} else {*/
			// Create ID for bin in format of WorldSpaceX-WorldSpaceY.
			String id = String.format("%s-%s", pi, pj);
			// If ID a already exists, add the point.
			if (existingBins.containsKey(id)) {
				Bin bin = existingBins.get(id);
				bin.add(point);
			}
			// Otherwise, create a bin and set the appropriate locations.
			else {
				Bin thisBin = new Bin(Arrays.asList(point));
				// Center in world space.
				thisBin.WorldSpaceLocation = new Vector2d(pi, pj);
				// Center in raw data as (cx, cy).
				double modifier = (pjIsNotEvenAtThisPoint) ? 0.5 : 0;
				double cx = (pi + modifier) * Delta.x();
				double cy = pj * Delta.y();
				thisBin.Location = new Vector2d(cx, cy);
				// Add bin.
				existingBins.put(id, thisBin);
			}
		//}
	}

	public String getSVGShape() {
		return getSVGShape(DistanceToAngle, Vector2d.ZERO, 0);
	}

	public String getSVGShape(double distance) {
		return getSVGShape(distance, Vector2d.ZERO, 0);
	}

	public String getSVGShape(double distance, Vector2d startLocation, double startAngleInRadians) {
		List<Vector2d> relativePoints = getShape(distance, startLocation, startAngleInRadians);
		ArrayList<String> strings = new ArrayList<String>();
		// Write relative points as (using periods to represent decimal points): px, py
		for (Vector2d relativePoint : relativePoints)
			strings.add(String.format(Locale.US, "%f,%f", new Double(relativePoint.x()), new Double(relativePoint.y())));
		// Return something in format of: m px1,py1 l px2,py2 ... l pxn, pyn z
		if (strings.size() > 0)
			return "m " + StringUtils.join(strings, " l ") + " z";
		else
			return "";
	}

	public List<Vector2d> getShape() {
		return getShape(DistanceToAngle, Vector2d.ZERO, 0);
	}

	public List<Vector2d> getShape(double distance, Vector2d startLocation, double startAngleInRadians) {
		ArrayList<Vector2d> list = new ArrayList<Vector2d>();
		double interiorAngle = getInteriorAngle();
		// Iterate the sides, drawing a line along the interior angle for some value, distance.
		for (int n = 0; n < NumberOfSides; n++) {
			double angleInRadians =  n * interiorAngle;
			// Calculate point 2 of the line.
			double x1 = Math.sin(angleInRadians) * distance;
			// Negative cosine is needed to invert the coordinate space such that -y is up.
			double y1 = -Math.cos(angleInRadians) * distance;
			// Calculate the difference between the start location and point 2.
			double dx = x1 - startLocation.x();
			double dy = y1 - startLocation.y();
			// Update start location to be the end of the line that was just created from startLocation to (x1, y1).
			startLocation = new Vector2d(x1, y1);
			// Add the relative point to the list.
			list.add(new Vector2d(dx, dy));
		}
		return list;
	}
}
