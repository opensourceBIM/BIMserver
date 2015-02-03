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
import java.util.Comparator;

import org.bimserver.charting.ColorScales.HSLColorScale;
import org.bimserver.charting.Containers.ChartExtent;
import org.bimserver.charting.Containers.ChartOption;
import org.bimserver.charting.Containers.ChartRows;
import org.bimserver.charting.Containers.ElementLike;
import org.bimserver.charting.Containers.GroupedChartExtents;
import org.bimserver.charting.Containers.TreeNode;
import org.bimserver.charting.Delegates.ITreeNodeHandler;
import org.bimserver.charting.Dimensions.ModelDimension;
import org.bimserver.charting.Models.StreamModel;

public class SmallMultiplesArea extends Chart {

	private class MinimumAndMaximumSizeTreeNodeHandler implements ITreeNodeHandler {
		public Double Maximum = null;
		public Double Minimum = null;

		@Override
		public void handleNode(TreeNode node) {
			if (Maximum == null || Maximum < node.Size)
				Maximum = node.Size;
			if (Minimum == null || Minimum > node.Size)
				Minimum = node.Size;
		}
	}

	public SmallMultiplesArea() {
		this("Small Multiples (Area)");
	}

	@SuppressWarnings("serial")
	public SmallMultiplesArea(String title) {
		this(
			title,
			"A small multiple is a series of small similar graphics or charts, allowing them to be easily compared.<br/>Based on <a href='http://bl.ocks.org/mbostock/9490313'>http://bl.ocks.org/mbostock/9490313</a>",
			"Time Series",
			new ArrayList<ChartOption> () {{
				add(new ChartOption("Width", "Horizontal dimension.", 1000));
				add(new ChartOption("Height", "Vertical dimension.", 500));
				add(new ChartOption("Padding", "Padding between sub-charts.", 10));
				add(new ChartOption("Use Same Scale", "Set minimum and maximum based off of all observed vertical data.", false));
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
	public SmallMultiplesArea(String title, String description, String category, ArrayList<ChartOption> options, org.bimserver.charting.Models.Model model, boolean fitToWidth) {
		super(title, description, category, options, model, fitToWidth);
	}

	public static Comparator<TreeNode> sortLargerDatesToEnd = new Comparator<TreeNode>() {
		public int compare(TreeNode first, TreeNode second) {
			//
			double a = getDateFromTreeNodeData(first);
			double b = getDateFromTreeNodeData(second);
			// Sort larger values to end of collection.
			if (a > b)
				return 1;
			else if (a < b)
				return -1;
			else
				return 0;
		}
	};

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
		boolean useSameScale = (hasOption("Use Same Scale")) ? (boolean)getOptionValue("Use Same Scale") : false;
		//
		double horizontalBorderMargin = 20;
		double verticalBorderMargin = 20;
		//
		double rightEdge = width - horizontalBorderMargin;
		//
		TreeNode root = TreeNode.ConsumeByGroup(filteredData, group, size);
		// At this point, inspect how many children the root has.
		double subChartCount = root.Children.length;
		double spaces = subChartCount - 1;
		//
		double heightOfSubChart = (subChartCount != 0) ? (height - verticalBorderMargin * 2 - padding * spaces) / subChartCount : 0;
		double widthOfSubChart = rightEdge - horizontalBorderMargin;
		// Get axis for dates to be used horizontally.
		ChartExtent xExtent = Model.getExtentFromDimensionGivenKey("date", false, filteredData);
		xExtent.setWorldSpace(0, widthOfSubChart);
		// Get axis or axes to be used vertically.
		ArrayList<ChartExtent> yExtents = new ArrayList<>();
		if (useSameScale) {
			ChartExtent yExtent = Model.getExtentFromDimensionGivenKey("size", false, filteredData);
			yExtent.setWorldSpace(0, heightOfSubChart);
			yExtents.add(yExtent);
		} else {
			for (TreeNode subChartNode : root.Children) {
				MinimumAndMaximumSizeTreeNodeHandler handler = new MinimumAndMaximumSizeTreeNodeHandler();
				subChartNode.walkLeafNodes(handler);
				ChartExtent yExtent = new ChartExtent(handler.Minimum, handler.Maximum, false);
				yExtent.setWorldSpace(0, heightOfSubChart);
				yExtents.add(yExtent);
			}
		}
		int yExtentsCount = yExtents.size();
		// Get color. Done differently from other charts.
		ChartExtent colorExtent = new ChartExtent(0.0, subChartCount, 0.0, 1.0);
		// Get color scale.
		@SuppressWarnings("unchecked")
		GroupedChartExtents<String> colorScale = (GroupedChartExtents<String>)getOptionValue("Color Scale");
		// Create a prototype for sub-chart title text.
		ElementLike subChartTextPrototype = new ElementLike("text");
		subChartTextPrototype.attribute("transform", String.format("translate(%s, %s)", widthOfSubChart, heightOfSubChart));
		subChartTextPrototype.attribute("text-anchor", "end");
		subChartTextPrototype.attribute("style", "font-family: Arial, Helvetica;font-size: 11px;");
		subChartTextPrototype.attribute("dy", "-0.34em");
		//
		ElementLike clipPathRectanglePrototype = new ElementLike("rect");
		clipPathRectanglePrototype.attribute("x", "0");
		clipPathRectanglePrototype.attribute("y", String.format("%s", (padding != 0) ? -padding : 0.0));
		clipPathRectanglePrototype.attribute("width", String.format("%s", widthOfSubChart));
		clipPathRectanglePrototype.attribute("height", String.format("%s", (padding != 0) ? padding + heightOfSubChart : heightOfSubChart));
		// Make a place to store clip paths.
		ElementLike definitions = new ElementLike("defs");
		//
		String clipPathName = "clip-each";
		ElementLike clipPath = new ElementLike("clipPath");
		clipPath.attribute("id", clipPathName);
		clipPath.child(clipPathRectanglePrototype);
		definitions.child(clipPath);
		builder.append(definitions.buildString(1));
		//
		int subChartIndex = 0;
		for (TreeNode subChartNode : root.Children) {
			//
			double x = horizontalBorderMargin;
			double y = verticalBorderMargin + heightOfSubChart * subChartIndex + padding * subChartIndex;
			double rawColorValue = colorExtent.getLinearWorldSpaceValueAtXGivenActualValue(subChartIndex);
			String fill = colorScale.getModulatedLinearWorldSpaceValueAtXGivenActualValue(rawColorValue, false);
			//
			ElementLike thisGroup = new ElementLike("g");
			thisGroup.attribute("transform", String.format("translate(%s, %s)", x, y));
			thisGroup.attribute("clip-path", String.format("url(#%s)", clipPathName));
			//
			ElementLike title = new ElementLike("title");
			title.text(subChartNode.Name);
			//
			ElementLike subChartText = subChartTextPrototype.clone();
			subChartText.text(subChartNode.Name);
			thisGroup.child(subChartText);
			//
			int dataPointsCount = subChartNode.Children.length;
			// Sort children.
			Arrays.sort(subChartNode.Children, 0, dataPointsCount, sortLargerDatesToEnd);
			// Prepare a place to store the area beneath the data.
			ElementLike path = new ElementLike("path");
			path.attribute("fill", fill);
			StringBuilder d = new StringBuilder();
			d.append(String.format("M %s, %s", widthOfSubChart, heightOfSubChart));
			d.append(String.format(" L %s, %s", 0, heightOfSubChart));
			// Iterate children.
			for (int i = 0; i < Math.max(1, dataPointsCount - 1); i++) {
				// Get Y-Axis extent.
				ChartExtent yExtent = yExtents.get(subChartIndex % yExtentsCount);
				// Get nodes.
				TreeNode p1 = subChartNode.Children[i];
				TreeNode p2 = subChartNode.Children[(i + 1) % dataPointsCount];
				// Get raw values for dates.
				double rawDateP1 = getDateFromTreeNodeData(date, p1);
				double rawDateP2 = getDateFromTreeNodeData(date, p2);
				// Translate dates into world-space coordinates; use as X1 and X2.
				double x1 = xExtent.getLinearWorldSpaceValueAtXGivenActualValue(rawDateP1);
				double x2 = xExtent.getLinearWorldSpaceValueAtXGivenActualValue(rawDateP2);
				// Get size; use as Y1 and Y2.
				double y1 = yExtent.getLinearWorldSpaceValueAtXGivenActualValue(p1.Size, true);
				double y2 = yExtent.getLinearWorldSpaceValueAtXGivenActualValue(p2.Size, true);
				//
				ElementLike line = new ElementLike("line");
				line.attribute("x1", String.format("%s", x1));
				line.attribute("y1", String.format("%s", y1));
				line.attribute("x2", String.format("%s", x2));
				line.attribute("y2", String.format("%s", y2));
				line.attribute("style", "stroke: black; stroke-width: 3; stroke-opacity: 0.05");
				//
				ElementLike lineTitle = new ElementLike("title");
				lineTitle.text(String.format("%s to %s", p1.Size, p2.Size));
				//
				line.child(lineTitle);
				//
				thisGroup.child(line);
				//
				if (i == 0)
					d.append(String.format(" L %s, %s", x1, y1));
				d.append(String.format(" L %s, %s", x2, y2));
			}
			d.append(" Z");
			path.attribute("d", d.toString());
			thisGroup.Children.add(0, path);
			//
			builder.append(thisGroup.buildString(1));
			//
			subChartIndex++;
		}
		//
		return builder;
	}

	private static double getDateFromTreeNodeData(ModelDimension date, TreeNode node) {
		ArrayList<Object> dates = node.Data.get(date);
		return (dates.size() > 0) ? ((Number)dates.get(0)).doubleValue() : System.currentTimeMillis();
	}

	private static double getDateFromTreeNodeData(TreeNode node) {
		ArrayList<Object> dates = node.Data.getValueListByDimensionId("date");
		return (dates.size() > 0) ? ((Number)dates.get(0)).doubleValue() : System.currentTimeMillis();
	}
}
