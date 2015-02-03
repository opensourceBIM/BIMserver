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
import com.vividsolutions.jts.triangulate.DelaunayTriangulationBuilder;

public class Delaunay extends Chart {

	public Delaunay() {
		this("Delaunay Triangulation");
	}

	@SuppressWarnings("serial")
	public Delaunay(String title) {
		this(
			title,
			"The Delaunay triangulation, the dual of Voronoi tesselation, creates a planar, triangular mesh for a given set of points. <br/>Based on <a href='http://bl.ocks.org/mbostock/4341156'>http://bl.ocks.org/mbostock/4341156</a>",
			"Distributions",
			new ArrayList<ChartOption> () {{
				add(new ChartOption("Width", "Horizontal dimension.", 1000));
				add(new ChartOption("Height", "Vertical dimension.", 500));
			}},
			new PointsModel(Arrays.asList(new String[] {"x", "y"})),
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
	public Delaunay(String title, String description, String category, ArrayList<ChartOption> options, org.bimserver.charting.Models.Model model, boolean fitToWidth) {
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
		// Get objects that represent the lowest and the highest values in a dimension of the data as a whole, including the context they exist in (i.e. some portion of the SVG's size).
		ChartExtent xExtent = Model.getExtentFromDimensionGivenKey("x", false, filteredData, 0, width, 11);
		// densitydesign/raw reverses this, going from upper to lower rather than from lower to upper. WARN: Queries need to specify the values are reversed.
		ChartExtent yExtent = Model.getExtentFromDimensionGivenKey("y", false, filteredData, 0, height, 10);
		// Make list of points.
		ArrayList<Coordinate> list = new ArrayList<>();
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
			}
		}
		// Configure the Delaunay triangulation builder.
		DelaunayTriangulationBuilder delaunayTriangulationBuilder = new DelaunayTriangulationBuilder();
		delaunayTriangulationBuilder.setSites(list);
		GeometryFactory geometryFactory = new GeometryFactory();
		// Triangulate.
		Geometry geometry = delaunayTriangulationBuilder.getTriangles(geometryFactory);
		// Create a holder for all the triangles.
		ElementLike group = new ElementLike("g");
		// Iterate the resulting geometry container, retrieving deliverable triangles.
		for (int n = 0; n < geometry.getNumGeometries(); n++) {
			// Get the triangle.
			Geometry triangle = geometry.getGeometryN(n);
			// Add geometry as an outlined triangle. 
			ElementLike path = new ElementLike("path");
			path.attribute("style", "fill: #bbb; stroke: #fff;");
			path.d(triangle, true, true);
			// Reparent.
			group.child(path);
		}
		// Write it out.
		builder.append(group.buildString(1));
		// Send it back.
		return builder;
	}
}
