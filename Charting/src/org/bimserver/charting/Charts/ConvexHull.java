package org.bimserver.charting.Charts;

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
import java.util.Date;

import org.bimserver.charting.Containers.ChartExtent;
import org.bimserver.charting.Containers.ChartOption;
import org.bimserver.charting.Containers.ChartRow;
import org.bimserver.charting.Containers.ChartRows;
import org.bimserver.charting.Containers.ElementLike;
import org.bimserver.charting.Dimensions.ModelDimension;
import org.bimserver.charting.Models.PointsModel;
import org.openmali.vecmath2.Vector2d;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;

public class ConvexHull extends Chart {

	public ConvexHull() {
		this("Convex Hull");
	}

	@SuppressWarnings("serial")
	public ConvexHull(String title) {
		this(
			title,
			"In mathematics, the <a href='https://en.wikipedia.org/wiki/Convex_hull'>convex hull</a> is the smallest convex shape containing a set o points. Applied to a scatterplot, it is useful to identify points belonging to the same category.<br /> <br/>Based on <a href='http://bl.ocks.org/mbostock/4341699'>http://bl.ocks.org/mbostock/4341699</a>",
			"Distributions",
			new ArrayList<ChartOption> () {{
				add(new ChartOption("Width", "Horizontal dimension.", 1000));
				add(new ChartOption("Height", "Vertical dimension.", 500));
				add(new ChartOption("Stroke Width", "Width of the line used to represent the convex hull.", 32));
			}},
			new PointsModel(Arrays.asList(new String[]{"x", "y"})),
			true
		);
	}

	/**
	 * @param title
	 * @param description
	 * @param category
	 * @param options
	 * @param model
	 * @param fitToWidth
	 */
	public ConvexHull(String title, String description, String category, ArrayList<ChartOption> options, org.bimserver.charting.Models.Model model, boolean fitToWidth) {
		super(title, description, category, options, model, fitToWidth);
	}

	@Override
	public StringBuilder writeSVGChartSpecificPayload(StringBuilder builder, ChartRows filteredData) {
		// Get "x" and "y" dimensions.
		ModelDimension x = Model.getDimensionByKey("x");
		ModelDimension y = Model.getDimensionByKey("y");
		// Get the width and height options.
		double width = (hasOption("Width")) ? (int)getOptionValue("Width") : 1000;
		double height = (hasOption("Height")) ? (int)getOptionValue("Height") : 500;
		double strokeWidth = (hasOption("Stroke Width")) ? ((Number)getOptionValue("Stroke Width")).doubleValue() : 32.0;
		// Derived.
		double halfStrokeWidth = strokeWidth / 2.0;
		double margin = Math.max(2, halfStrokeWidth);
		//
		double widthMinusStroke = width - strokeWidth - margin;
		double heightMinusStroke = height - strokeWidth;
		// Get objects that represent the lowest and the highest values in a dimension of the data as a whole, including the context they exist in (i.e. some portion of the SVG's size).
		ChartExtent xExtent = Model.getExtentFromDimensionGivenKey("x", false, filteredData, margin, widthMinusStroke, 11);
		// densitydesign/raw reverses this, going from upper to lower rather than from lower to upper. WARN: Queries need to specify the values are reversed.
		ChartExtent yExtent = Model.getExtentFromDimensionGivenKey("y", false, filteredData, margin, heightMinusStroke, 10);
		// Make list of points.
		ArrayList<Coordinate> list = new ArrayList<>();
		ElementLike circlesGroup = new ElementLike("g");
		for (ChartRow row : filteredData) {
			ArrayList<Object> xValues = row.get(x);
			ArrayList<Object> yValues = row.get(y);
			// Sizes.
			int xValuesSize = xValues.size();
			int yValuesSize = yValues.size();
			// Determine how many points can be made out of the data by picking the largest dimension. Other data in the row will be cycled through if enough data is not explicitly available.
			int pointCount = Math.min(xValuesSize, yValuesSize);
			// Effectively, zip the data together.
			for (int i = 0; i < pointCount; i++) {
				// Coerce X value.
				Object xValue = xValues.get(i % xValuesSize);
				double coercedXValue = 0;
				if (xValue instanceof Number)
					coercedXValue = ((Number)xValue).doubleValue();
				else if (xValue instanceof Date)
					coercedXValue = ((Date)xValue).getTime();
				// Coerce Y value.
				Object yValue = yValues.get(i % yValuesSize);
				double coercedYValue = 0;
				if (yValue instanceof Number)
					coercedYValue = ((Number)yValue).doubleValue();
				else if (yValue instanceof Date)
					coercedYValue = ((Date)yValue).getTime();
				// Get actual values.
				Vector2d thisPoint = new Vector2d(coercedXValue, coercedYValue);
				// Convert the actual values into world-space coordinates.
				Coordinate coordinate = new Coordinate(
					xExtent.getLinearWorldSpaceValueAtXGivenActualValue(thisPoint.getX()),
					yExtent.getLinearWorldSpaceValueAtXGivenActualValue(thisPoint.getY(), true)
				);
				list.add(coordinate);
				// Create a circle to represent the point. Doing it from the result of the convex hull decidedly misses data points.
				ElementLike circle = new ElementLike("circle");
				circle.attribute("r", String.format("%s", new Double(2)));
				circle.attribute("transform", String.format("translate(%s, %s)", new Double(coordinate.x), new Double(coordinate.y)));
				circle.attribute("style", String.format("fill: %s; fill-opacity: 0.9;", "black"));
				// Reparent.
				circlesGroup.child(circle);
			}
		}
		// Move points to data structure as JTS will expect them.
		Coordinate[] coodinateArray = list.toArray(new Coordinate[list.size()]);
		GeometryFactory geometryFactory = new GeometryFactory();
		com.vividsolutions.jts.algorithm.ConvexHull algorithm = new com.vividsolutions.jts.algorithm.ConvexHull(coodinateArray, geometryFactory);
		Geometry geometry = algorithm.getConvexHull();
		// Prepare a place to store the path and the points.
		ElementLike group = new ElementLike("g");
		group.attribute("transform", String.format("translate(%s, %s)", halfStrokeWidth, halfStrokeWidth));
		// Add the geometry as an outlined and filled path with rounded edges.
		ElementLike path = new ElementLike("path");
		path.attribute("style", String.format("fill: #bbb; stroke: #bbb; stroke-width: %s; stroke-linejoin: round", strokeWidth));
		path.d(geometry, true, true);
		// Reparent.
		group.child(path);
		// Add points as circles.
		if (circlesGroup.Children.size() > 0)
			group.child(circlesGroup);
		// Write it out.
		builder.append(group.buildString(1));
		// Send it back.
		return builder;
	}
}
