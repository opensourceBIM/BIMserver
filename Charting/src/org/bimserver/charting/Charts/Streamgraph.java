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
import org.bimserver.charting.Algorithms.StreamGraph.Layer;
import org.bimserver.charting.Algorithms.StreamGraph.LayerLayout;
import org.bimserver.charting.Algorithms.StreamGraph.StackLayout;
import org.bimserver.charting.Algorithms.StreamGraph.StreamLayout;
import org.bimserver.charting.Algorithms.StreamGraph.ThemeRiverLayout;
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
import org.openmali.distance.Distance2D;
import org.openmali.vecmath2.Vector2d;

public class Streamgraph extends Chart {

	public Streamgraph() {
		this("Streamgraph");
	}

	public Streamgraph(String title) {
		this(
			title,
			"For continuous data such as time series, a streamgraph can be used in place of stacked bars. <br/>Based on <a href='http://bl.ocks.org/mbostock/4060954'>http://bl.ocks.org/mbostock/4060954</a>",
			"Time Series",
			new ArrayList<ChartOption> () {{
				add(new ChartOption("Width", "Horizontal dimension.", 1000));
				add(new ChartOption("Height", "Vertical dimension.", 500));
				add(new ChartOption("Offset", "Graph offset: zero, expand, wiggle, silhouette, and expand. Zero places data on the lower edge of the graph. Expand extends data towards the top of the graph. Wiggle places data around a central baseline. Silhouette places data around a central baseline but makes it symmetrical. ", "silhouette"));
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
	public Streamgraph(String title, String description, String category, ArrayList<ChartOption> options, org.bimserver.charting.Models.Model model, boolean fitToWidth) {
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
		boolean showLabels = (hasOption("Show Labels")) ? (boolean)getOptionValue("Show Labels") : true;
		String offset = (hasOption("Offset")) ? (String)getOptionValue("Offset") : "silhouette";
		//
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
		LayerLayout layerLayout = null;
		boolean expandAboveBaseline = false;
		if (offset == "silhouette")
			layerLayout = new ThemeRiverLayout();
		else if (offset == "wiggle")
			layerLayout = new StreamLayout();
		else if (offset == "expand") {
			layerLayout = new StackLayout();
			expandAboveBaseline = true;
		} else if (offset == "zero")
			layerLayout = new StackLayout();
		else
			layerLayout = new StackLayout();
		//
		StreamgraphLayout layout = new StreamgraphLayout(layerLayout, dataSource, false, expandAboveBaseline, 0, horizontalBorderMargin, minorVerticalBorderMargin, rightEdge, bottomEdge);
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
		ElementLike textGroup = new ElementLike("g");
		for (Layer layer : layers) {
			double rawColorValue = colorExtent.getLinearWorldSpaceValueAtXGivenActualValue(subChartIndex);
			String fill = colorScale.getModulatedLinearWorldSpaceValueAtXGivenActualValue(rawColorValue, false);
			// Prepare a place to store the area between the data.
			ElementLike path = new ElementLike("path");
			path.attribute("fill", fill);
			StringBuilder d = new StringBuilder();
			// Add the points to the path data.
			int dataPointsCount = layer.points.size();
			Vector2d previousPoint = null;
			if (dataPointsCount > 0) {
				Vector2d first = layer.points.get(0);
				d.append(String.format("M %s, %s", first.x(), first.y()));
				previousPoint = first;
			}
			for (int i = 1; i < dataPointsCount; i++) {
				Vector2d point = layer.points.get(i);
				if (Distance2D.dist((float)point.x(), (float)point.y(), (float)previousPoint.x(), (float)previousPoint.y()) != 0f) {
					d.append(String.format(" L %s, %s", point.x(), point.y()));
					previousPoint = point;
				}
			}
			path.attribute("d", d.toString());
			// Add labels.
			if (showLabels) {
				// Get offset.
				Vector2d textOffset = layout.getTextOffset(subChartIndex);
				// Get anchor.
				double horizontalOffsetPercent = Math.round(textOffset.x() / layout.xExtent.WorldSpaceEnd * 100);
				String anchor = (horizontalOffsetPercent > 90) ? "end" : (horizontalOffsetPercent < 10) ? "start" : "middle";
				// Add text element.
				ElementLike text = new ElementLike("text");
				text.attribute("dy", "0.5ex");
				text.attribute("class", "label");
				text.attribute("text-anchor", anchor);
				text.attribute("x", String.format("%s", textOffset.x()));
				text.attribute("y", String.format("%s", textOffset.y()));
				text.attribute("font-size", "11px");
				text.attribute("font-family", "Arial, Helvetica");
				text.attribute("font-weight", "normal");
				text.text(layer.name);
				textGroup.child(text);
			}
			//
			builder.append(path.buildString(1));
			//
			subChartIndex++;
		}
		// Add text.
		if (textGroup.Children.size() > 0)
			builder.append(textGroup.buildString(1));
		//
		return builder;
	}
}
