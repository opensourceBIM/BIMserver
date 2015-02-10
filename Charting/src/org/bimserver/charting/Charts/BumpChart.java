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

import org.bimserver.charting.Algorithms.StreamgraphLayout;
import org.bimserver.charting.Algorithms.StreamGraph.BumpLayout;
import org.bimserver.charting.Algorithms.StreamGraph.Layer;
import org.bimserver.charting.Algorithms.StreamGraph.LayerLayout;
import org.bimserver.charting.Algorithms.StreamGraph.TreeNodeDataSource;
import org.bimserver.charting.ColorScales.HSLColorScale;
import org.bimserver.charting.Containers.Axis;
import org.bimserver.charting.Containers.ChartExtent;
import org.bimserver.charting.Containers.ChartOption;
import org.bimserver.charting.Containers.ChartRows;
import org.bimserver.charting.Containers.ElementLike;
import org.bimserver.charting.Containers.GroupedChartExtents;
import org.bimserver.charting.Containers.TreeNode;
import org.bimserver.charting.Dimensions.ModelDimension;
import org.bimserver.charting.Models.StreamModel;
import org.openmali.vecmath2.Vector2d;

public class BumpChart extends Chart {

	public BumpChart() {
		this("Bump Chart");
	}

	@SuppressWarnings("serial")
	public BumpChart(String title) {
		this(
			title,
			"For continuous data such as time series, a bump chart can be used in place of stacked bars. Based on New York Times's <a href='http://www.nytimes.com/interactive/2014/08/13/upshot/where-people-in-each-state-were-born.html'>interactive visualization.</a>",
			"Time Series",
			new ArrayList<ChartOption> () {{
				add(new ChartOption("Width", "Horizontal dimension.", 1000));
				add(new ChartOption("Height", "Vertical dimension.", 500));
				add(new ChartOption("Padding", "Padding between sub-charts.", 10));
				add(new ChartOption("Interpolation", "The shape smoothing technique: basis spline or linear.", "basis spline"));
				add(new ChartOption("Normalize", "Normalize the data at each point.", false));
				add(new ChartOption("Sort", "Sort by: value (descending), value (ascending), or group.", "value (descending)"));
				add(new ChartOption("Show Labels", "Show labels on data.", true));
				// Any valid GroupedChartExtents<String>, including HSLColorScale and LinearColorScale.
				add(new ChartOption("Color Scale", "Scale of the color.", new HSLColorScale()));
			}},
			new StreamModel(Arrays.asList(new String[] {"group", "date", "size"})),
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
	public BumpChart(String title, String description, String category, ArrayList<ChartOption> options, org.bimserver.charting.Models.Model model, boolean fitToWidth) {
		super(title, description, category, options, model, fitToWidth);
	}

	@Override
	public StringBuilder writeSVGChartSpecificPayload(StringBuilder builder, ChartRows filteredData) {
		// Get "group", "date", and "size" dimensions.
		ModelDimension group = Model.getDimensionByKey("group");
		ModelDimension date = Model.getDimensionByKey("date");
		ModelDimension size = Model.getDimensionByKey("size");
		// Get the width and height options.
		double width = (hasOption("Width")) ? (int)getOptionValue("Width") : 1000;
		double height = (hasOption("Height")) ? (int)getOptionValue("Height") : 500;
		double padding = (hasOption("Padding")) ? ((Number)getOptionValue("Padding")).doubleValue() : 10;
		String interpolation = (hasOption("Interpolation")) ? (String)getOptionValue("Interpolation") : "basis spline";
		boolean normalize = (hasOption("Normalize")) ? (boolean)getOptionValue("Normalize") : false;
		String sort = (hasOption("Sort")) ? (String)getOptionValue("Sort") : "value (descending)";
		boolean showLabels = (hasOption("Show Labels")) ? (boolean)getOptionValue("Show Labels") : true;
		// See if date is all dates. If so, push for that formatting along the X axis.
		boolean dateIsDates = filteredData.isDataInDimensionAllDates(date);
		ChartExtent xExtent = filteredData.getExtentFromDimension(date, false);
		//
		double horizontalBorderMargin = (dateIsDates) ? 40 : 10 * String.format("%s", xExtent.getLower()).length() / 2.0;
		double minorVerticalBorderMargin = 10;
		double verticalBorderMargin = (dateIsDates) ? 40 : 20;
		//
		double rightEdge = width - horizontalBorderMargin;
		double bottomEdge = height - verticalBorderMargin;
		//
		TreeNode root = TreeNode.ConsumeByGroup(filteredData, group, size);
		// At this point, inspect how many children the root has.
		double subChartCount = root.Children.length;
		// Get color. Done differently from other charts.
		ChartExtent colorExtent = new ChartExtent(0.0, subChartCount, 0.0, 1.0);
		// Get color scale.
		@SuppressWarnings("unchecked")
		GroupedChartExtents<String> colorScale = (GroupedChartExtents<String>)getOptionValue("Color Scale");
		//
		TreeNodeDataSource dataSource = new TreeNodeDataSource(root);
		// Zero (and fallback) layout.
		LayerLayout layerLayout = new BumpLayout(sort, normalize, padding, minorVerticalBorderMargin);
		boolean expandAboveBaseline = false;
		//
		StreamgraphLayout layout = new StreamgraphLayout(layerLayout, dataSource, normalize, expandAboveBaseline, padding, horizontalBorderMargin, minorVerticalBorderMargin, rightEdge, bottomEdge);
		//
		xExtent.setWorldSpace(layout.xExtent.WorldSpaceStart, layout.xExtent.WorldSpaceEnd);
		//
		layout.layout();
		//
		Axis xAxis = new Axis("x", xExtent, new Vector2d(0, bottomEdge), new Vector2d(0, -(height - minorVerticalBorderMargin - verticalBorderMargin)), Axis.Movement.LeftToRight);
		Axis yAxis = new Axis("y", layout.sizeExtent, new Vector2d(horizontalBorderMargin, 0), new Vector2d(width - horizontalBorderMargin * 2, 0), Axis.Movement.BottomToTop);
		yAxis.LineSettings.IncludeLabels = false;
		//
		builder.append(yAxis.buildString(1));
		builder.append(xAxis.buildString(1));
		//
		int subChartIndex = 0;
		Layer[] layers = layout.layers;
		ElementLike defs = new ElementLike("defs");
		// Create clip path. Not used until referenced in SVG.
		ElementLike clipPath = ElementLike.createRectangularClipPath("clip", horizontalBorderMargin, minorVerticalBorderMargin, xAxis.P2OfConstructedLine.y(), yAxis.P2OfConstructedLine.x());
		// Add reference-capable clip path.
		defs.child(clipPath);
		//
		ElementLike pathGroup = new ElementLike("g");
		pathGroup.attribute("clip-path", "url(#clip)");
		ElementLike textGroup = new ElementLike("g");
		textGroup.attribute("clip-path", "url(#clip)");
		for (Layer layer : layers) {
			double rawColorValue = colorExtent.getLinearWorldSpaceValueAtXGivenActualValue(subChartIndex);
			String fill = colorScale.getModulatedLinearWorldSpaceValueAtXGivenActualValue(rawColorValue, false);
			{
				// Prepare a place to store the area between the data.
				ElementLike path = new ElementLike("path");
				path.attribute("fill", fill);
				path.attribute("fill-opacity", "0.9");
				StringBuilder d;
				if (interpolation == "basis spline") 
					d = getBSplineInterpolatedPath(layer, layout);
				else
					d = getLinearlyInterpolatedPath(layer, layout);
				path.attribute("d", d.toString());
				//
				ElementLike title = new ElementLike("title");
				title.text(layer.name);
				path.child(title);
				//
				pathGroup.child(path);
			}
			//
			{
				ElementLike path = new ElementLike("path");
				path.attribute("id", "path-" + subChartIndex);
				StringBuilder d;
				if (interpolation == "basis spline") 
					d = getBSplineInterpolatedValuePath(layer, layout);
				else
					d = getLinearlyInterpolatedValuePath(layer, layout);
				path.attribute("d", d.toString());
				defs.child(path);
			}
			// Add labels.
			if (showLabels) {
				double distance = layout.getDistanceConsumedAtMax(layer.name.length() * 1.5, subChartIndex);
				// Get offset.
				Vector2d textOffset = layout.getTextOffset(subChartIndex);
				// Get anchor.
				double horizontalOffsetPercent = Math.round(textOffset.x() / layout.xExtent.WorldSpaceEnd * 100);
				String anchor = (horizontalOffsetPercent > 90) ? "end" : (horizontalOffsetPercent < 20) ? "start" : "middle";
				// Add text element.
				ElementLike text = new ElementLike("text");
				text.attribute("dy", "0.5ex");
				text.attribute("class", "label");
				text.attribute("text-anchor", anchor);
				text.attribute("font-size", "11px");
				text.attribute("font-family", "Arial, Helvetica");
				text.attribute("font-weight", "normal");
				//
				ElementLike textPath = new ElementLike("textPath");
				textPath.attribute("xlink:href", "#path-" + subChartIndex);
				textPath.attribute("startOffset", String.format("%s", distance));
				textPath.text(layer.name);
				text.child(textPath);
				//
				textGroup.child(text);
			}
			//
			subChartIndex++;
		}
		builder.append(defs.buildString(1));
		//
		builder.append(pathGroup.buildString(1));
		// Add text.
		if (textGroup.Children.size() > 0)
			builder.append(textGroup.buildString(1));
		//
		return builder;
	}

	/**
	 * @param layer
	 * @param layout
	 * @return
	 */
	public StringBuilder getLinearlyInterpolatedPath(Layer layer, StreamgraphLayout layout) {
		StringBuilder d = new StringBuilder();
		//
		boolean lastLayer = layer == layout.layers[layout.layers.length - 1];
		//
		double verticalAdjustment = (!lastLayer) ? -1 : 0;
		// Add the points to the path data.
		int dataPointsCount = layer.size.length;
		//
		if (dataPointsCount > 0) {
			//
			{
				int p = 0;
				double x0 = 0, y0 = 0;
				x0 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(p, false);
				y0 = layer.yTop[p] + verticalAdjustment;
				d.append(String.format("M %s, %s L", x0, y0));
			}
			// Upper pass.
			for (int i = 1; i < dataPointsCount; i++) {
				double x1 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(i, false);
				double y1 = layer.yTop[i];
				d.append(String.format(" %s, %s", x1, y1));
			}
			// Lower pass.
			for (int i = dataPointsCount - 1; i >= 0; i--) {
				double x1 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(i, false);
				double y1 = layer.yBottom[i];
				d.append(String.format(" %s, %s", x1, y1));
			}
		}
		return d;
	}

	/**
	 * @param layer
	 * @param layout
	 * @return
	 */
	public StringBuilder getLinearlyInterpolatedValuePath(Layer layer, StreamgraphLayout layout) {
		StringBuilder d = new StringBuilder();
		// Add the points to the path data.
		int dataPointsCount = layer.size.length;
		//
		if (dataPointsCount > 0) {
			//
			{
				int p = 0;
				double x0 = 0, y0 = 0;
				x0 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(p, false);
				y0 = (layer.yBottom[p] + layer.yTop[p]) / 2.0;
				d.append(String.format("M %s, %s L", x0, y0));
			}
			// Upper pass.
			for (int i = 1; i < dataPointsCount; i++) {
				double x1 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(i, false);
				double y1 = (layer.yBottom[i] + layer.yTop[i]) / 2.0;
				d.append(String.format(" %s, %s", x1, y1));
			}
		}
		return d;
	}

	/**
	 * @param layer
	 * @param layout
	 * @return
	 */
	public StringBuilder getBSplineInterpolatedPath(Layer layer, StreamgraphLayout layout) {
		StringBuilder d = new StringBuilder();
		// Add the points to the path data.
		int dataPointsCount = layer.size.length;
		//
		if (dataPointsCount > 0) {
			double x0 = 0, y0 = 0;
			//
			{
				int p = 0;
				x0 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(p, false);
				y0 = layer.yTop[p] - 1;
				d.append(String.format("M %s, %s", x0, y0));
			}
			// Upper lead to onset pass.
			for (int i = 1; i < dataPointsCount - 1; i++) {
				
				double x1 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(i, false);
				double y1 = layer.yTop[i] - 1;
				//
				int p = i + 1;
				double x2 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(p, false);
				double y2 = layer.yTop[p] - 1;
				//
				double mx = (x1 + x2) / 2.0;
				double my = (y1 + y2) / 2.0;
				//
				d.append(String.format(" Q %s, %s %s, %s", x1, y1, mx, my));
			}
			{
				int p = dataPointsCount - 1;
				//
				x0 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(p, false);
				y0 = layer.yTop[p] - 1;
				d.append(String.format("L %s, %s", x0, y0));
				//
				x0 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(p, false);
				y0 = layer.yBottom[p];
				d.append(String.format(" L %s, %s", x0, y0));
			}
			// Lower pass.
			for (int i = dataPointsCount - 1; i > 0; i--) {
				double x1 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(i, false);
				double y1 = layer.yBottom[i];
				//
				int p = i - 1;
				double x2 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(p, false);
				double y2 = layer.yBottom[p];
				//
				double mx = (x1 + x2) / 2.0;
				double my = (y1 + y2) / 2.0;
				//
				d.append(String.format(" Q %s, %s %s, %s", x1, y1, mx, my));
			}
			{
				int p = 0;
				x0 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(p, false);
				y0 = layer.yBottom[p];
				d.append(String.format(" L %s, %s", x0, y0));
			}
		}
		return d;
	}

	/**
	 * @param layer
	 * @param layout
	 * @return
	 */
	public StringBuilder getBSplineInterpolatedValuePath(Layer layer, StreamgraphLayout layout) {
		StringBuilder d = new StringBuilder();
		// Add the points to the path data.
		int dataPointsCount = layer.size.length;
		//
		if (dataPointsCount > 0) {
			double x0 = 0, y0 = 0;
			//
			{
				int p = 0;
				x0 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(p, false);
				y0 = (layer.yBottom[p] + layer.yTop[p]) / 2.0;
				d.append(String.format("M %s, %s", x0, y0));
			}
			// Upper lead to onset pass.
			for (int i = 1; i < dataPointsCount - 1; i++) {
				
				double x1 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(i, false);
				double y1 = (layer.yBottom[i] + layer.yTop[i]) / 2.0;;
				//
				int p = i + 1;
				double x2 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(p, false);
				double y2 = (layer.yBottom[p] + layer.yTop[p]) / 2.0;
				//
				double mx = (x1 + x2) / 2.0;
				double my = (y1 + y2) / 2.0;
				//
				d.append(String.format(" Q %s, %s %s, %s", x1, y1, mx, my));
			}
			{
				int p = dataPointsCount - 1;
				//
				x0 = layout.xExtent.getLinearWorldSpaceValueAtXGivenActualValue(p, false);
				y0 = (layer.yBottom[p] + layer.yTop[p]) / 2.0;
				d.append(String.format(" L %s, %s", x0, y0));
			}
		}
		return d;
	}
}
