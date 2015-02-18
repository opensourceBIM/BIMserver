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

import org.bimserver.charting.ColorScales.HSLColorScale;
import org.bimserver.charting.Containers.Axis;
import org.bimserver.charting.Containers.ChartExtent;
import org.bimserver.charting.Containers.ChartOption;
import org.bimserver.charting.Containers.ChartRow;
import org.bimserver.charting.Containers.ChartRows;
import org.bimserver.charting.Containers.ElementLike;
import org.bimserver.charting.Containers.GroupedChartExtents;
import org.bimserver.charting.Dimensions.ModelDimension;
import org.bimserver.charting.Models.ParallelCoordinatesModel;
import org.openmali.vecmath2.Vector2d;

public class ParallelCoordinates extends Chart {

	public ParallelCoordinates() {
		this("Parallel Coordinates");
	}

	@SuppressWarnings("serial")
	public ParallelCoordinates(String title) {
		this(
			title,
			"Parallel coordinates is a common way of visualizing high-dimensional geometry and analyzing multivariate data.To show a set of points in an n-dimensional space, a backdrop is drawn consisting of n parallel lines, typically vertical and equally spaced. A point in n-dimensional space is represented as a polyline with vertices on the parallel axes; the position of the vertex on the ith axis corresponds to the ith coordinate of the point. <br/>Based on <a href='http://bl.ocks.org/jasondavies/1341281'>http://bl.ocks.org/jasondavies/1341281</a>",
			"Distributions",
			new ArrayList<ChartOption> () {{
				add(new ChartOption("Width", "Horizontal dimension.", 1000));
				add(new ChartOption("Height", "Vertical dimension.", 500));
				// Any valid GroupedChartExtents<String>, including HSLColorScale and LinearColorScale.
				add(new ChartOption("Color Scale", "Scale of the color.", new HSLColorScale()));
			}},
			new ParallelCoordinatesModel(Arrays.asList(new String[] {"dimensions", "color"})),
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
	public ParallelCoordinates(String title, String description, String category, ArrayList<ChartOption> options, org.bimserver.charting.Models.Model model, boolean fitToWidth) {
		super(title, description, category, options, model, fitToWidth);
	}

	@Override
	public StringBuilder writeSVGChartSpecificPayload(StringBuilder builder, ChartRows filteredData) {
		ModelDimension dimensions = Model.getDimensionByKey("dimensions");
		// Get optional dimensions.
		ModelDimension color = Model.getDimensionByKey("color");
		//
		int axesCount = dimensions.getLength();
		ArrayList<ChartExtent> extents = new ArrayList<>();
		// Create placeholder extents.
		for (int i = 0; i < axesCount; i++) {
			ChartExtent extent = new ChartExtent();
			extent.DefaultTickCount = 11;
			extents.add(extent);
		}
		// Iterate rows.
		for (ChartRow row : filteredData) {
			ArrayList<Object> objects = row.get(dimensions);
			for (int i = 0; i < objects.size(); i ++) {
				Object object = objects.get(i);
				if (object != null) {
					Double value = ((Number)object).doubleValue();
					// Include value in appropriate axis (NOTE: not stored if not relevant to lower or upper bound of axis).
					extents.get(i).includeValue(value);
				}
			}
		}
		boolean onlyHaveOneAxis = axesCount == 1;
		// Calculate left margin. If dates, it's static. Otherwise, calculate the display length in digits of each numeric value, allotting 10 pixels per digit. NOTE: Replaces log base 10 of densitydesign/raw.
		double marginLeft = Math.max(
			10 * dimensions.KeysToBeFiltered.get(0).length() / 2.0,
			10 * ParallelCoordinatesModel.getNumberOfFiguresFromDouble(extents.get(0).getUpper())
		);
		double marginRight = 5;
		// Get a constant bottom margin of 20.
		double marginBottom = 20;
		// Get the width and height options.
		double width = (hasOption("Width")) ? (int)getOptionValue("Width") : 1000;
		double height = (hasOption("Height")) ? (int)getOptionValue("Height") : 500;
		// Calculate width and height, minus the left and bottom margins.
		double innerWidth = width - marginLeft - marginRight;
		double innerHeight = height - marginBottom;
		// Color extent. Transforms data to be in range of 0 to 1. Put these values through a color scale.
		ChartExtent colorExtent = Model.getExtentFromDimensionGivenKey("color", false, filteredData, 0, 1);
		// Get color scale.
		@SuppressWarnings("unchecked")
		GroupedChartExtents<String> colorScale = (GroupedChartExtents<String>)getOptionValue("Color Scale");
		// Iterate the extents, transforming them into drawn axes.
		ArrayList<Axis> axes = new ArrayList<>();
		for (int i = 0; i < axesCount; i++) {
			ChartExtent extent = extents.get(i);
			Vector2d startLocation = (onlyHaveOneAxis) ? new Vector2d(marginLeft + innerWidth / 2.0, marginBottom) : new Vector2d(marginLeft + i * innerWidth / (axesCount - 1.0), marginBottom);
			Axis axis = new Axis(dimensions.KeysToBeFiltered.get(i), extent, startLocation, new Vector2d(0, innerHeight / (extent.DefaultTickCount - 1)), Axis.Movement.BottomToTop);
			axis.Extent.setWorldSpace(0, innerHeight);
			axis.LineSettings.StartLineCapAmount = 5;
			axis.LineSettings.DoNotDrawLastAxisLine = true;
			axes.add(axis);
			// Add the axis's title.
			ElementLike text = new ElementLike("text");
			text.attribute("text-anchor", (!onlyHaveOneAxis && i + 1 == axesCount) ? "end" : "middle");
			text.attribute("transform", String.format("translate(%s, %s)", startLocation.getX(), startLocation.getY() - 10));
			text.attribute("style", "font-size: 10px; font-family: Arial, Helvetica;");
			text.text(dimensions.KeysToBeFiltered.get(i));
			// Add the axes.
			builder.append(axis.buildString(1));
			// Add text.
			builder.append(text.buildString(1));
		}
		// Iterate rows.
		for (ChartRow row : filteredData) {
			ArrayList<Object> valueObjects = row.get(dimensions);
			ArrayList<Object> colorObjects = row.get(color);
			// Get color.
			double colorValue = (colorObjects.size() > 0) ? colorExtent.getLinearWorldSpaceValueAtXGivenActualValue(((Number)colorObjects.get(0)).doubleValue()) : 0;
			String stroke = colorScale.getModulatedLinearWorldSpaceValueAtXGivenActualValue(colorValue, false);
			// Create a group in preparation for lines.
			ElementLike group = new ElementLike("g");
			group.attribute("transform", String.format("translate(%s, %s)", 0, marginBottom));
			// Track previous data.
			Double lx = null;
			Double ly = null;
			Double lValue = null;
			int previousIndex = 0;
			// Iterate objects.
			for (int i = 0; i < valueObjects.size(); i ++) {
				Object object = valueObjects.get(i);
				if (object != null) {
					Double value = ((Number)object).doubleValue();
					Axis axis = axes.get(i);
					double x = axis.StartingLocation.x();
					double y = axis.getWorldSpaceValueGivenActualValue(value);
					if (lx != null && ly != null && lValue != null) {
						// Create and add the line.
						ElementLike line = new ElementLike("line");
						line.attribute("x1", String.format("%s", lx));
						line.attribute("y1", String.format("%s", ly));
						line.attribute("x2", String.format("%s", x));
						line.attribute("y2", String.format("%s", y));
						line.attribute("style", String.format("fill: none; stroke: %s; stroke-opacity: 0.4;", stroke));
						// Add tooltip, like: Value in Dimension becomes Value in Other Dimension.
						ElementLike title = new ElementLike("title");
						title.text(String.format("%s in %s becomes %s in %s", lValue, dimensions.KeysToBeFiltered.get(previousIndex), value, dimensions.KeysToBeFiltered.get(i)));
						// Reparent.
						line.child(title);
						group.child(line);
					}
					// Store last point.
					lx = x;
					ly = y;
					lValue = value;
					previousIndex = i;
				}
			}
			// Add the group.
			builder.append(group.buildString(1));
		}
		// Send it back.
		return builder;
	}
}
