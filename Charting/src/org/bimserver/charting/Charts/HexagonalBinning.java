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

import org.bimserver.charting.Algorithms.Binning;
import org.bimserver.charting.ColorScales.LinearColorScale;
import org.bimserver.charting.Containers.Axis;
import org.bimserver.charting.Containers.Bin;
import org.bimserver.charting.Containers.BinCollection;
import org.bimserver.charting.Containers.ChartExtent;
import org.bimserver.charting.Containers.ChartOption;
import org.bimserver.charting.Containers.ChartRows;
import org.bimserver.charting.Containers.ElementLike;
import org.bimserver.charting.Containers.GroupedChartExtents;
import org.bimserver.charting.Delegates.IModulateValueDelegate;
import org.bimserver.charting.Dimensions.ModelDimension;
import org.bimserver.charting.Models.PointsModel;
import org.openmali.vecmath2.Vector2d;

public class HexagonalBinning extends Chart {

	public HexagonalBinning() {
		this("Hexagonal Binning");
	}

	@SuppressWarnings("serial")
	public HexagonalBinning(String title) {
		this(
			title,
			"Visually clusters the most populated areas on a scatterplot. Useful to make more readable a scatterplot when plotting hundreds of points.<br/>Based on <a href='http://bl.ocks.org/mbostock/4248145'>http://bl.ocks.org/mbostock/4248145</a>",
			"Distributions",
			new ArrayList<ChartOption> () {{
				add(new ChartOption("Width", "Horizontal dimension.", 1000));
				add(new ChartOption("Height", "Vertical dimension.", 500));
				add(new ChartOption("Radius", "Radius of hexagon.", 20));
				add(new ChartOption("Use Zeroed Origin", "Set origin at (0, 0).", false));
				add(new ChartOption("Color Scale", "Scale of the color.", new LinearColorScale()));
				add(new ChartOption("Show Points", "Show points explicitly.", true));
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
	public HexagonalBinning(String title, String description, String category, ArrayList<ChartOption> options, org.bimserver.charting.Models.Model model, boolean fitToWidth) {
		super(title, description, category, options, model, fitToWidth);
	}

	@Override
	public StringBuilder writeSVGChartSpecificPayload(StringBuilder builder, ChartRows filteredData) {
		// Get "x" and "y" dimensions.
		ModelDimension x = Model.getDimensionByKey("x");
		ModelDimension y = Model.getDimensionByKey("y");
		// Get max radius.
		int radius = (hasOption("Radius")) ? (int)getOptionValue("Radius") : 20;
		// See if y is all dates. If so, push for a static margin.
		boolean yIsDates = filteredData.isDataInDimensionAllDates(y);
		// Calculate left margin. If dates, it's static. Otherwise, calculate the display length in digits of each numeric value, allotting 10 pixels per digit. NOTE: Replaces log base 10 of densitydesign/raw.
		double marginLeft = (yIsDates) ? 100 : Math.max(
			radius,
			10 * Model.getMaximumDoubleFromDimensionGivenKey("y", 4.0, filteredData, new IModulateValueDelegate<Double>() {
				@Override
				public Double modulate(Double value) {
					return org.bimserver.charting.Models.Model.getNumberOfFiguresFromDouble(value);
				}
			})
		);
		// Account for axis setting.
		marginLeft += 6.0;
		// Get a constant bottom margin of 20.
		double marginBottom = 20;
		// Get the width and height options.
		double width = (hasOption("Width")) ? (int)getOptionValue("Width") : 1000;
		double height = (hasOption("Height")) ? (int)getOptionValue("Height") : 500;
		// Calculate width and height, minus the left and bottom margins.
		double innerWidth = width - marginLeft;
		double innerHeight = height - marginBottom;
		//double aspectRatio = innerWidth / innerHeight;
		// Calculate width and height, minus maximum radius. 
		double widthMinusRadius = width - radius;
		double innerHeightMinusRadius = innerHeight - radius;
		// Get the use zeroed origin option.
		boolean useOrigin = (hasOption("Use Zeroed Origin")) ? (boolean)getOptionValue("Use Zeroed Origin") : false;
		// Get objects that represent the lowest and the highest values in a dimension of the data as a whole, including the context they exist in (i.e. some portion of the SVG's size).
		final ChartExtent xExtent = Model.getExtentFromDimensionGivenKey("x", useOrigin, filteredData, marginLeft, widthMinusRadius, 11);
		// densitydesign/raw goes h to 0 instead of lesser to upper.
		final ChartExtent yExtent = Model.getExtentFromDimensionGivenKey("y", useOrigin, filteredData, marginBottom, innerHeightMinusRadius, 10);
		// Calculate tick sizes. Used to line lengths later.
		double xAxisTickHeight = -innerHeight + radius * 2;
		double yAxisTickWidth = innerWidth - radius;
		// Get color scale.
		@SuppressWarnings("unchecked")
		GroupedChartExtents<String> colorScale = (GroupedChartExtents<String>)getOptionValue("Color Scale");
		// Create clip path. Not used until referenced in SVG.
		ElementLike clipPath = ElementLike.createRectangularClipPath("clip", marginLeft, marginBottom, xAxisTickHeight, yAxisTickWidth);
		// Add reference-capable clip path.
		builder.append(clipPath.buildString(1));
		// Handle x axis, which is a series of vertical lines.
		Axis xAxis = new Axis("x", xExtent, new Vector2d(0, innerHeight - radius), new Vector2d(0, xAxisTickHeight), Axis.Movement.LeftToRight);
		xAxis.LineSettings.StartLineCapAmount = 6.0;
		xAxis.LineSettings.OnlyDrawLineForFirstAndLastTick = true;
		// Handle y axis, which is a series of horizontal lines.
		Axis yAxis = new Axis("y", yExtent, new Vector2d(marginLeft, 0), new Vector2d(yAxisTickWidth, 0), Axis.Movement.BottomToTop);
		yAxis.LineSettings.StartLineCapAmount = 6.0;
		yAxis.LineSettings.OnlyDrawLineForFirstAndLastTick = true;
		// Add the axes.
		builder.append(xAxis.buildString(1));
		builder.append(yAxis.buildString(1));
		// Show small points in addition to data visualizations.
		boolean showPoints = (hasOption("Show Points")) ? (boolean)getOptionValue("Show Points") : false;
		// Create context-specific handlers.
		IModulateValueDelegate<Double> scaleXValueToWorldSpace = new IModulateValueDelegate<Double>() {
			@Override
			public Double modulate(Double value) {
				return xExtent.getLinearWorldSpaceValueAtXGivenActualValue(value);
			}
		};
		IModulateValueDelegate<Double> scaleYValueToWorldSpace = new IModulateValueDelegate<Double>() {
			@Override
			public Double modulate(Double value) {
				return yExtent.getLinearWorldSpaceValueAtXGivenActualValue(value, true);
			}
		};
		// Configure the binning algorithm to be in the shape of a hexagon.
		Binning hexagonalBinningAlgorithm = new Binning(radius, 6, scaleXValueToWorldSpace, scaleYValueToWorldSpace);
		//
		BinCollection bins = hexagonalBinningAlgorithm.getBinsById(x, y, filteredData);
		// Color extent. Transforms data to be in range of 0 to 1. Put these values through a color scale.
		ChartExtent colorExtent = new ChartExtent(new Double(bins.MinimumObservedLength), new Double(bins.MaximumObservedLength), 0.0, 1.0);
		//
		String hexagonSVGPath = hexagonalBinningAlgorithm.getSVGShape();
		//
		ElementLike group = new ElementLike("g");
		group.attribute("clip-path", "url(#clip)");
		//
		ElementLike hexagonsGroup = new ElementLike("g");
		ElementLike pointsGroup = new ElementLike("g");
		pointsGroup.attribute("class", "point");
		for (Bin bin : bins) {
			// World space color value.
			double percentAlongColorScale = colorExtent.getLinearWorldSpaceValueAtXGivenActualValue(bin.size());
			// Create a path to represent the hexagon. densitydesign/raw doesn't do it, but the size can be modulated here by using the getSVGShape of the binning algorithm with an explicit radius. The radius can be walked like any other scale.
			ElementLike hexagonPath = new ElementLike("path");
			hexagonPath.attribute("class", "hexagon");
			hexagonPath.attribute("d", hexagonSVGPath);
			hexagonPath.attribute("transform", String.format("translate(%s, %s)", bin.Location.getX(), bin.Location.getY()));
			hexagonPath.attribute("style", String.format("fill: %s;", colorScale.getModulatedLinearWorldSpaceValueAtXGivenActualValue(percentAlongColorScale, false)));
			hexagonPath.attribute("stroke", "black");
			hexagonPath.attribute("stroke-width", "0.5px");
			if (showPoints) {
				for (Vector2d rawPoint : bin) {
					// Get the world space value of the location of the point.
					double xValue = xExtent.getLinearWorldSpaceValueAtXGivenActualValue(rawPoint.x());
					double yValue = yExtent.getLinearWorldSpaceValueAtXGivenActualValue(rawPoint.y(), true);
					// Create a circle to represent the point.
					ElementLike circle = new ElementLike("circle");
					circle.attribute("style", "fill: black;");
					circle.attribute("transform", String.format("translate(%s, %s)", xValue, yValue));
					circle.attribute("r", "1");
					// Reparent.
					pointsGroup.child(circle);
				}
			}
			// Reparenting.
			hexagonsGroup.child(hexagonPath);
		}
		// Add bins as hexagons.
		if (hexagonsGroup.Children.size() > 0)
			group.child(hexagonsGroup);
		// Add bins as dots.
		if (showPoints && pointsGroup.Children.size() > 0)
			group.child(pointsGroup);
		// Write everything out.
		builder.append(group.buildString(1));
		// Send it back.
		return builder;
	}
}
