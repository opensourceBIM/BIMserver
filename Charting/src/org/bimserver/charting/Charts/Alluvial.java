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
import java.util.Collections;
import java.util.LinkedHashMap;

import org.bimserver.charting.Algorithms.Sankey.Sankey;
import org.bimserver.charting.Algorithms.Sankey.SankeyLink;
import org.bimserver.charting.Algorithms.Sankey.SankeyNode;
import org.bimserver.charting.ColorScales.HSLColorScale;
import org.bimserver.charting.Containers.ChartExtent;
import org.bimserver.charting.Containers.ChartOption;
import org.bimserver.charting.Containers.ChartRow;
import org.bimserver.charting.Containers.ChartRows;
import org.bimserver.charting.Containers.ElementLike;
import org.bimserver.charting.Containers.GroupedChartExtents;
import org.bimserver.charting.Dimensions.ModelDimension;
import org.bimserver.charting.Models.AlluvialModel;

public class Alluvial extends Chart {

	public Alluvial() {
		this("Alluvial Diagram");
	}

	@SuppressWarnings("serial")
	public Alluvial(String title) {
		this(
			title,
			"Alluvial diagrams allow to represent flows and to see correlations between categorical dimensions, visually linking to the number of elements sharing the same categories. It is useful to see the evolution of cluster (such as the number of people belonging to a specific group). It can also be used to represent bipartite graphs, using each node group as dimensions.<br/>Mainly based on our previous work with Fineo, it is inspired by <a href='http://bost.ocks.org/mike/sankey/'>http://bost.ocks.org/mike/sankey/</a>",
			"Correlations",
			new ArrayList<ChartOption> () {{
				add(new ChartOption("Width", "Horizontal dimension.", 1000));
				add(new ChartOption("Height", "Vertical dimension.", 500));
				add(new ChartOption("Node Width", "Width of dimension markers.", 5));
				add(new ChartOption("Node Padding", "Padding between links.", 8));
				add(new ChartOption("Iteration Limit", "Limit iteration to this many passes.", 32));
				add(new ChartOption("Sort", "Sort data by: name, size, or none.", "name"));
				// Any valid GroupedChartExtents<String>, including HSLColorScale and LinearColorScale.
				add(new ChartOption("Color Scale", "Scale of the color.", new HSLColorScale()));
			}},
			new AlluvialModel(Arrays.asList(new String[] {"steps", "size"})),
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
	public Alluvial(String title, String description, String category, ArrayList<ChartOption> options, org.bimserver.charting.Models.Model model, boolean fitToWidth) {
		super(title, description, category, options, model, fitToWidth);
	}

	@Override
	public StringBuilder writeSVGChartSpecificPayload(StringBuilder builder, ChartRows filteredData) {
		// Get "steps" and "size" dimensions.
		ModelDimension steps = Model.getDimensionByKey("steps");
		ModelDimension size = Model.getDimensionByKey("size");
		// Get the width and height options.
		double width = (hasOption("Width")) ? (int)getOptionValue("Width") : 1000;
		double height = (hasOption("Height")) ? (int)getOptionValue("Height") : 500;
		double nodeWidth = (hasOption("Node Width")) ? ((Number)getOptionValue("Node Width")).doubleValue() : 5;
		double nodePadding = (hasOption("Node Padding")) ? ((Number)getOptionValue("Node Padding")).doubleValue() : 8;
		double heightPadding = nodePadding;
		int iterationLimit = (hasOption("Iteration Limit")) ? ((Number)getOptionValue("Iteration Limit")).intValue() : 32;
		String sort = (hasOption("Sort")) ? (String)getOptionValue("Sort") : "name";
		// Derived.
		double halfNodeWidth = nodeWidth / 2.0;
		//
		ArrayList<SankeyNode> nodes = new ArrayList<>();
		LinkedHashMap<String, SankeyNode> nodeTable = new LinkedHashMap<>();
		ArrayList<SankeyLink> links = new ArrayList<>();
		//
		for (ChartRow data : filteredData) {
			ArrayList<Object> rawSteps = data.get(steps);
			ArrayList<Object> rawSizes = data.get(size);
			double sizeValue = (rawSizes.size() > 0) ? ((Number)rawSizes.get(0)).doubleValue() : 0.0;
			int count = rawSteps.size();
			if (count >= 2) {
				for (int i = 0; i < count - 1; i++) {
					Object step = rawSteps.get(i);
					Object nextStep = rawSteps.get(i + 1);
					String stepName = String.format("%s", step);
					String nextStepName = String.format("%s", nextStep);
					// Check for it.
					SankeyNode stepNode = null;
					SankeyNode nextStepNode = null;
					// Get (or create) the first step node.
					if (!nodeTable.containsKey(stepName)) {
						stepNode = new SankeyNode(stepName, sizeValue);
						nodes.add(stepNode);
						nodeTable.put(stepName, stepNode);
					} else {
						stepNode = nodeTable.get(stepName);
						stepNode.Value += sizeValue;
					}
					// Get (or create) the first step node.
					if (!nodeTable.containsKey(nextStepName)) {
						nextStepNode = new SankeyNode(nextStepName, sizeValue);
						nodes.add(nextStepNode);
						nodeTable.put(nextStepName, nextStepNode);
					} else {
						nextStepNode = nodeTable.get(nextStepName);
						nextStepNode.Value += sizeValue;
					}
					// Ignore data that loops back. This is an infinite loop scenario.
					if (stepNode != nextStepNode) {
						SankeyLink link = new SankeyLink(stepNode, nextStepNode, sizeValue);
						links.add(link);
					}
				}
			}
		}
		//
		double heightMinusPadding = height - 2 * heightPadding;
		Sankey layoutEngine = new Sankey(nodes, links, iterationLimit, nodeWidth, nodePadding, width, heightMinusPadding);
		layoutEngine.layout();
		// Count nodes that exist as sources.
		int nodesUsedAsSources = 0;
		for (SankeyNode node : layoutEngine.Nodes) {
			if (node.SourceLinks.size() > 0) {
				node.ColorId = nodesUsedAsSources;
				nodesUsedAsSources += 1;
			}
		}
		ArrayList<ArrayList<SankeyNode>> groupedNodes = layoutEngine.getGroupedNodes();
		// Reorder nodes.
		for (ArrayList<SankeyNode> nodesInGroup : groupedNodes) {
			double sum = 0.0;
			for (SankeyNode node : nodesInGroup)
				sum += node.Delta.y() + nodePadding;
			double y = heightPadding + (heightMinusPadding - sum) / 2.0 + nodePadding / 2.0;
			// Do sort.
			if (sort.equals("name"))
				Collections.sort(nodesInGroup, SankeyNode.ascendingName);
			else if (sort.equals("value"))
				Collections.sort(nodesInGroup, SankeyNode.ascendingValue);
			// Update location.
			for (SankeyNode node : nodesInGroup) {
				node.Location.y(y);
				y += node.Delta.y() + nodePadding;
			}
		}
		// Reorder links.
		for (ArrayList<SankeyNode> nodesInGroup : groupedNodes) {
			for (SankeyNode node : nodesInGroup) {
				// Handle source links.
				{
					double ly = 0;
					Collections.sort(node.SourceLinks, SankeyLink.ascendingTargetDepth);
					for (SankeyLink link : node.SourceLinks) {
						link.sy = ly;
						ly += link.Delta.y();
					}
				}
				{
					double ly = 0;
					Collections.sort(node.TargetLinks, SankeyLink.ascendingSourceDepth);
					for (SankeyLink link : node.TargetLinks) {
						link.ty = ly;
						ly += link.Delta.y();
					}
				}
			}
		}
		// Get color. Done differently from other charts.
		ChartExtent colorExtent = new ChartExtent(0.0, (double)nodesUsedAsSources, 0.0, 1.0);
		// Get color scale.
		@SuppressWarnings("unchecked")
		GroupedChartExtents<String> colorScale = (GroupedChartExtents<String>)getOptionValue("Color Scale");
		// Draw links.
		for (SankeyLink link : layoutEngine.Links) {
			//
			double rawColorValue = colorExtent.getLinearWorldSpaceValueAtXGivenActualValue(link.Source.ColorId);
			String color = colorScale.getModulatedLinearWorldSpaceValueAtXGivenActualValue(rawColorValue, false);
			//
			ElementLike path = new ElementLike("path");
			path.attribute("d", link.link());
			path.attribute("style", String.format("stroke-width: %s; fill: none; stroke: %s; stroke-opacity: 0.4;", link.Delta.y(), color));
			path.attribute("class", "link");
			//
			ElementLike title = new ElementLike("title");
			title.text(String.format("%s is %s units (%.2f%%) %s.", link.Source.Name, link.getValue(), 100.0 * link.getValue() / link.Source.getValue(), link.Target.Name));
			path.child(title);
			//
			builder.append(path.buildString(1));
		}
		// Markers.
		for (SankeyNode node : nodes) {
			ElementLike rect = new ElementLike("rect");
			rect.attribute("x", String.format("%s", node.Location.x()));
			rect.attribute("y", String.format("%s", node.Location.y()));
			rect.attribute("width", String.format("%s", node.Delta.x()));
			rect.attribute("height", String.format("%s", node.Delta.y()));
			rect.attribute("fill", "black");
			//
			ElementLike text = new ElementLike("text");
			text.attribute("style", "font-size: 11px; font-family: Arial,Helvetica; pointer-events: none;");
			String anchor = (node.SourceLinks.size() == 0) ? "end" : "start";
			text.attribute("text-anchor", anchor);
			double dx = (node.SourceLinks.size() == 0) ? -halfNodeWidth : halfNodeWidth + 4;
			text.attribute("dx", String.format("%spx", dx));
			text.attribute("dy", "0.34em");
			text.attribute("transform", String.format("translate(%s, %s)", node.Location.x(), node.getCenterY()));
			text.text(node.Name);
			//
			builder.append(text.buildString(1));
			builder.append(rect.buildString(1));
		}
		//
		return builder;
	}
}
