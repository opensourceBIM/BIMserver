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

import org.apache.commons.lang.StringUtils;
import org.bimserver.charting.ColorScales.HSLColorScale;
import org.bimserver.charting.Containers.Axis;
import org.bimserver.charting.Containers.ChartExtent;
import org.bimserver.charting.Containers.ChartOption;
import org.bimserver.charting.Containers.ChartRow;
import org.bimserver.charting.Containers.ChartRows;
import org.bimserver.charting.Containers.ElementLike;
import org.bimserver.charting.Containers.GroupedChartExtents;
import org.bimserver.charting.Delegates.IModulateValueDelegate;
import org.bimserver.charting.Dimensions.ModelDimension;
import org.bimserver.charting.Models.PointsModel;
import org.openmali.vecmath2.Colord;
import org.openmali.vecmath2.Vector2d;

public class ScatterPlot extends Chart {

	public ScatterPlot() {
		this("Scatter Plot");
	}

	@SuppressWarnings("serial")
	public ScatterPlot(String title) {
		this(
			title,
			"A scatter plot, scatterplot, or scattergraph is a type of mathematical diagram using Cartesian coordinates to display values for two variables for a set of data. The data is displayed as a collection of points, each having the value of one variable determining the position on the horizontal axis and the value of the other variable determining the position on the vertical axis. This kind of plot is also called a scatter chart, scattergram, scatter diagram, or scatter graph.",
			"Distributions",
			new ArrayList<ChartOption> () {{
				add(new ChartOption("Width", "Horizontal dimension.", 1000));
				add(new ChartOption("Height", "Vertical dimension.", 500));
				add(new ChartOption("Max Radius", "Maximum radius.", 20));
				add(new ChartOption("Use Zeroed Origin", "Set origin at (0, 0).", false));
				// Any valid GroupedChartExtents<String>, including HSLColorScale and LinearColorScale.
				add(new ChartOption("Color Scale", "Scale of the color.", new HSLColorScale()));
				add(new ChartOption("Show Points", "Show points explicitly.", true));
			}},
			new PointsModel(Arrays.asList(new String[] {"x", "y", "size", "color", "label"})),
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
	public ScatterPlot(String title, String description, String category, ArrayList<ChartOption> options, org.bimserver.charting.Models.Model model, boolean fitToWidth) {
		super(title, description, category, options, model, fitToWidth);
	}

	@Override
	public StringBuilder writeSVGChartSpecificPayload(StringBuilder builder, ChartRows filteredData) {
		// Get "x" and "y" dimensions.
		ModelDimension x = Model.getDimensionByKey("x");
		ModelDimension y = Model.getDimensionByKey("y");
		// Get optional dimensions.
		ModelDimension size = Model.getDimensionByKey("size");
		ModelDimension color = Model.getDimensionByKey("color");
		ModelDimension label = Model.getDimensionByKey("label");
		// Get max radius.
		int maxRadius = (hasOption("Max Radius")) ? (int)getOptionValue("Max Radius") : 20;
		// See if y is all dates. If so, push for a static margin.
		boolean yIsDates = filteredData.isDataInDimensionAllDates(y);
		// Calculate left margin. If dates, it's static. Otherwise, calculate the display length in digits of each numeric value, allotting 10 pixels per digit. NOTE: Replaces log base 10 of densitydesign/raw.
		double marginLeft = (yIsDates) ? 100 : Math.max(
			maxRadius,
			10 * Model.getMaximumDoubleFromDimensionGivenKey("y", null, filteredData, new IModulateValueDelegate<Double>() {
				@Override
				public Double modulate(Double value) {
					return org.bimserver.charting.Models.Model.getNumberOfFiguresFromDouble(value);
				}
			})
		);
		// Get a constant bottom margin of 20.
		double marginBottom = 20;
		// Get the width and height options.
		double width = (hasOption("Width")) ? (int)getOptionValue("Width") : 1000;
		double height = (hasOption("Height")) ? (int)getOptionValue("Height") : 500;
		// Show small points in addition to data visualizations.
		boolean showPoints = (hasOption("Show Points")) ? (boolean)getOptionValue("Show Points") : false;
		// Calculate width and height, minus the left and bottom margins.
		double innerWidth = width - marginLeft;
		double innerHeight = height - marginBottom;
		//double aspectRatio = innerWidth / innerHeight;
		// Calculate width and height, minus maximum radius. 
		double widthMinusMaxRadius = width - maxRadius;
		double innerHeightMinusMaxRadius = innerHeight - maxRadius;
		// Get the use zeroed origin option.
		boolean useOrigin = (hasOption("Use Zeroed Origin")) ? (boolean)getOptionValue("Use Zeroed Origin") : false;
		// Get objects that represent the lowest and the highest values in a dimension of the data as a whole, including the context they exist in (i.e. some portion of the SVG's size).
		ChartExtent xExtent = Model.getExtentFromDimensionGivenKey("x", useOrigin, filteredData, marginLeft, widthMinusMaxRadius, 11);
		ChartExtent yExtent = Model.getExtentFromDimensionGivenKey("y", useOrigin, filteredData, marginBottom, innerHeightMinusMaxRadius, 10);
		// Calculate tick sizes. Used to line lengths later.
		double xAxisTickHeight = -innerHeight + maxRadius * 2;
		double yAxisTickWidth = innerWidth - maxRadius;
		// Calculate controllers for size scale.
		double sizeExtentStart = 1;
		double sizeExtentTotal = Math.pow(maxRadius, 2) * Math.PI;
		// Get the size scaled from 1 to max radius.
		ChartExtent sizeExtent = Model.getExtentFromDimensionGivenKey("size", true, filteredData, sizeExtentStart, sizeExtentTotal);
		// Color extent. Transforms data to be in range of 0 to 1. Put these values through a color scale.
		ChartExtent colorExtent = Model.getExtentFromDimensionGivenKey("color", false, filteredData, 0, 1);
		// Get color scale.
		@SuppressWarnings("unchecked")
		GroupedChartExtents<String> colorScale = (GroupedChartExtents<String>)getOptionValue("Color Scale");
		// Handle x axis, which is a series of vertical lines.
		Axis xAxis = new Axis("x", xExtent, new Vector2d(0, innerHeight - maxRadius), new Vector2d(0, xAxisTickHeight), Axis.Movement.LeftToRight);
		xAxis.LineSettings.LineColor = new Colord(0.8);
		// Handle y axis, which is a series of horizontal lines.
		Axis yAxis = new Axis("y", yExtent, new Vector2d(marginLeft, 0), new Vector2d(yAxisTickWidth, 0), Axis.Movement.BottomToTop);
		yAxis.LineSettings.LineColor = new Colord(0.8);
		// Add the axes.
		builder.append(xAxis.buildString(1));
		builder.append(yAxis.buildString(1));
		//
		ElementLike circlesGroup = new ElementLike("g");
		ElementLike pointsGroup = new ElementLike("g");
		// Iterate the points to draw circles and labels.
		for (ChartRow row : filteredData) {
			ArrayList<Object> xValues = row.get(x);
			ArrayList<Object> yValues = row.get(y);
			ArrayList<Object> sizeValues = row.get(size);
			ArrayList<Object> colorValues = row.get(color);
			ArrayList<Object> labelValues = row.get(label);
			// Sizes.
			int xValuesSize = xValues.size();
			int yValuesSize = yValues.size();
			int sizeValuesSize = sizeValues.size();
			int colorValuesSize = colorValues.size();
			int labelValuesSize = labelValues.size();
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
				Vector2d worldSpacePoint = new Vector2d(
					xAxis.getWorldSpaceValueGivenActualValue(thisPoint.getX()),
					yAxis.getWorldSpaceValueGivenActualValue(thisPoint.getY())
				);
				// OPTIONAL: Size.
				double circleSize = maxRadius;
				if (sizeValuesSize > 0) {
					double thisRawSize = ((Number)sizeValues.get(i % sizeValuesSize)).doubleValue();
					double thisWorldSpaceSize = sizeExtent.getLinearWorldSpaceValueAtXGivenActualValue(thisRawSize);
					circleSize = Math.sqrt(thisWorldSpaceSize) / Math.PI;
				}
				// OPTIONAL: Color.
				double thisRawColorValue = 0;
				double thisWorldSpaceColorValue = 0;
				if (colorValuesSize > 0) {
					thisRawColorValue = ((Number)colorValues.get(i % colorValuesSize)).doubleValue();
					thisWorldSpaceColorValue = colorExtent.getLinearWorldSpaceValueAtXGivenActualValue(thisRawColorValue);
				}
				// OPTIONAL: Label(s).
				String labels = null;
				if (labelValuesSize > 0)
					labels = StringUtils.join(labelValues, ", ");
				//
				ElementLike circleGroup = new ElementLike("g");
				circleGroup.attribute("class", "circle");
				// Create a circle to represent the point, including size and color drivers.
				ElementLike circle = new ElementLike("circle");
				circle.attribute("r", String.format("%s", new Double(circleSize)));
				circle.attribute("transform", String.format("translate(%s, %s)", new Double(worldSpacePoint.getX()), new Double(worldSpacePoint.getY())));
				circle.attribute("style", String.format("fill: %s; fill-opacity: 0.9;", colorScale.getModulatedLinearWorldSpaceValueAtXGivenActualValue(thisWorldSpaceColorValue, false)));
				// Reparenting.
				circleGroup.child(circle);
				// Add labels, if specified.
				if (labels != null) {
					ElementLike text = new ElementLike("text");
					text.attribute("dy", "15");
					text.attribute("style", "font-size: 10px; font-family: Arial, Helvetica;");
					text.attribute("text-anchor", "middle");
					text.attribute("transform", String.format("translate(%s, %s)", new Double(worldSpacePoint.getX()), new Double(worldSpacePoint.getY())));
					text.text(labels);
					// Reparenting.
					circleGroup.child(text);
				}
				// Reparent to appropriate container.
				circlesGroup.child(circleGroup);
				// Handle points.
				if (showPoints) {
					ElementLike pointGroup = new ElementLike("g");
					pointGroup.attribute("class", "point");
					//
					ElementLike point = new ElementLike("circle");
					point.attribute("r", "1");
					point.attribute("transform", String.format("translate(%s, %s)", new Double(worldSpacePoint.getX()), new Double(worldSpacePoint.getY())));
					point.attribute("style", "fill: rgb(0, 0, 0);");
					// Reparenting.
					pointGroup.child(point);
					// Reparent to appropriate container.
					pointsGroup.child(pointGroup);
				}
			}
		}
		// Write the points as circles.
		if (circlesGroup.Children.size() > 0)
			builder.append(circlesGroup.buildString(1));
		// Write the points as dots.
		if (showPoints && pointsGroup.Children.size() > 0)
			builder.append(pointsGroup.buildString(1));
		// Send it back.
		return builder;
	}
}
