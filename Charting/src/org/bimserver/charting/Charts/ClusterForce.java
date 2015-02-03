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
import java.util.Iterator;

import org.bimserver.charting.Algorithms.CirclePacking;
import org.bimserver.charting.ColorScales.HSLColorScale;
import org.bimserver.charting.Containers.ChartExtent;
import org.bimserver.charting.Containers.ChartOption;
import org.bimserver.charting.Containers.ChartRows;
import org.bimserver.charting.Containers.ElementLike;
import org.bimserver.charting.Containers.GroupedChartExtents;
import org.bimserver.charting.Containers.PackableCircle;
import org.bimserver.charting.Containers.TreeNode;
import org.bimserver.charting.Dimensions.ModelDimension;
import org.bimserver.charting.Models.TreeModel;

import prefuse.Constants;
import prefuse.Display;
import prefuse.Visualization;
import prefuse.action.ActionList;
import prefuse.data.Graph;
import prefuse.data.Node;
import prefuse.data.Tree;
import prefuse.render.AbstractShapeRenderer;
import prefuse.render.DefaultRendererFactory;
import prefuse.render.LabelRenderer;
import prefuse.visual.VisualItem;
import prefuse.visual.expression.InGroupPredicate;

public class ClusterForce extends Chart {

	/**
	 * Data keys: name, value, size, fill, and label.
	 *
	 * Obtain on node like: node.get("name")
	 */
	private static final prefuse.data.Schema Schema = new prefuse.data.Schema() {{
		// String representation of actual value. Used in place of label if not specified.
		addColumn("name", String.class);
		// Value of hierarchy.
		addColumn("class", String.class);
		// String description of node.
		addColumn("tooltip", String.class);
		// Relative size of node as compared to all other nodes. A value of "1.0" is meant as a pass-through.
		addColumn("size", double.class, 1.0);
		// Relative color of node as compared to all other nodes. A value of "0.0" is meant to fall at the start of the scale.
		addColumn("color", double.class, null);
		// Label to be used in place of name.
		addColumn("label", String.class, null);
	}};

	public ClusterForce() {
		this("Cluster Force");
	}

	@SuppressWarnings("serial")
	public ClusterForce(String title) {
		this(
			title,
			"Nested circles allow to represent hierarchies and compare values. This visualization is particularly effective to show the proportion between elements through their areas and their position inside a hierarchical structure. <br/>Based on <a href='http://bl.ocks.org/mbostock/7882658'>http://bl.ocks.org/mbostock/7882658</a>",
			"Hierarchies",
			// NOTE: Options for this chart diverge from densitydesign/raw because this version is a static chart.
			new ArrayList<ChartOption> () {{
				add(new ChartOption("Diameter", "Diameter of the root circle.", 1000));
				add(new ChartOption("Padding", "Padding between sibling circles.", 5));
				// Sort by size: true/false. More generally, determines layout order.
				add(new ChartOption("Sort by Size", "Sort values by size.", false));
				add(new ChartOption("Show Labels", "Show the labels field.", true));
				// Any valid GroupedChartExtents<String>, including HSLColorScale and LinearColorScale.
				add(new ChartOption("Color Scale", "Scale of the color.", new HSLColorScale()));
			}},
			new TreeModel(Arrays.asList(new String[] {"clusters", "size", "color", "label"})),
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
	public ClusterForce(String title, String description, String category, ArrayList<ChartOption> options, org.bimserver.charting.Models.Model model, boolean fitToWidth) {
		super(title, description, category, options, model, fitToWidth);
	}

	@Override
	public StringBuilder writeSVGChartSpecificPayload(StringBuilder builder, ChartRows filteredData) {
		// Get "hierarchy" and "size" dimensions.
		ModelDimension hierarchy = Model.getDimensionByKey("clusters");
		ModelDimension size = Model.getDimensionByKey("size");
		// Get parameters.
		double diameter = (hasOption("Diameter")) ? ((Number)getOptionValue("Diameter")).doubleValue() : 1000;
		double padding = (hasOption("Padding")) ? ((Number)getOptionValue("Padding")).doubleValue() : 5;
		boolean sortBySize = (hasOption("Sort by Size")) ? (boolean)getOptionValue("Sort by Size") : false;
		boolean showLabels = (hasOption("Show Labels")) ? (boolean)getOptionValue("Show Labels") : true;
		// Get the width and height options.
		double width = diameter;
		double height = diameter;
		// Get size scale.
		ChartExtent sizeExtent = Model.getExtentFromDimensionGivenKey("size", false, filteredData);
		// Set scale so that largest objects are only ever twice the size as their companions (and nothing gets zero for a radius).
		sizeExtent.setWorldSpace(50.0, 100.0);
		// Color extent. Transforms data to be in range of 0 to 1. Put these values through a color scale.
		ChartExtent colorExtent = Model.getExtentFromDimensionGivenKey("color", false, filteredData, 0, 1);
		// Get color scale.
		@SuppressWarnings("unchecked")
		GroupedChartExtents<String> colorScale = (GroupedChartExtents<String>)getOptionValue("Color Scale");
		// Consume tree. Opt out of setting size to be at least 1.
		TreeNode root = TreeNode.Consume(filteredData, hierarchy, size, null);
		// Make place to store transformable data.
		Tree tree = new Tree();
		// Add structure to data.
		tree.addColumns(Schema);
		// Parse the data in the local tree structure into the prefuse.data structure.
		root.parseIntoPrefuseTree(tree);
		// Make graph. Contains data table structure.
		Graph graph = tree;
		//
		Visualization visualization = new Visualization();
		Display display = new Display(visualization);
		display.setBounds(0, 0, (int)Math.ceil(width), (int)Math.ceil(height));
		visualization.add("tree", graph);
		//
		LabelRenderer nodeRenderer = new LabelRenderer("label");
		nodeRenderer.setRenderType(AbstractShapeRenderer.RENDER_TYPE_DRAW);
		nodeRenderer.setHorizontalAlignment(Constants.LEFT);
		nodeRenderer.setRoundedCorner(8,8);
		//
		DefaultRendererFactory drf = new DefaultRendererFactory();
		drf.add(new InGroupPredicate("tree.nodes"), nodeRenderer);
		visualization.setRendererFactory(drf);
		//
		ActionList list = new ActionList();
		// "tree" refers to root of XML document. Second argument is padding versus primary node groups.
		CirclePacking layout = new CirclePacking("tree", sizeExtent, padding, sortBySize);
		layout.setLayoutAnchor(new java.awt.geom.Point2D.Double(width / 2.0, height / 2.0));
		layout.setLayoutBounds(new java.awt.geom.Rectangle2D.Double(0, 0, width, height));
		list.add(layout);
		//
		visualization.putAction("layout", list);
		// Zero elapsed time.
		layout.run(0.0);
		//
		iterateTree(visualization, graph, showLabels, colorExtent, colorScale, builder);
		//
		return builder;
	}

	/**
	 * @param visualization
	 * @param node
	 */
	@SuppressWarnings("unused")
	public StringBuilder iterateTree(Visualization visualization, Graph graph, boolean showLabels, ChartExtent colorExtent, GroupedChartExtents<String> colorScale, StringBuilder builder) {
		//
		java.awt.geom.Rectangle2D bounds = visualization.getBounds("tree");
		double maxComponent = Math.max(1, Math.max(bounds.getWidth(), bounds.getHeight()));
		// 5%
		double maxRelativeSize = 5;
		// Nodes: labels.
		Iterator b = graph.nodes();
		Node child = null;
		while (b.hasNext()) {
			//
			child = (Node) b.next();
			//
			VisualItem item = visualization.getVisualItem("tree", child);
			String name = child.getString("name");
			PackableCircle circle = (PackableCircle) item.get(CirclePacking.CIRCLE);
			if (circle.Filled) {
				//
				ElementLike pointGroup = new ElementLike("g");
				pointGroup.attribute("transform", String.format("translate(%s, %s)", circle.Location.x(), circle.Location.y()));
				pointGroup.attribute("class", "node");
				//
				ElementLike variableSizeCircle = new ElementLike("circle");
				variableSizeCircle.attribute("r", String.format("%s", circle.Radius));
				// Get color raw value.
				Double thisRawColorValue = child.getDouble("color");
				// Derive color value.
				Double colorValue = colorExtent.getLinearWorldSpaceValueAtXGivenActualValue(thisRawColorValue);
				// Get color in color scale.
				String color = colorScale.getModulatedLinearWorldSpaceValueAtXGivenActualValue(colorValue, false);
				// Set style of circle.
				variableSizeCircle.attribute("style", String.format("fill: %s;", color));
				// Set tooltip of filled circle.
				ElementLike pointTitle = new ElementLike("title");
				String tooltip = child.getString("tooltip");
				pointTitle.text(String.format("%s > %s", tooltip, child.getDouble("size")));
				variableSizeCircle.child(pointTitle);
				//
				pointGroup.child(variableSizeCircle);
				// If there's a label to print, do a text object. Otherwise, don't.
				if (showLabels && name != null) {
					//
					String label = child.getString("label");
					// Derive label.
					if (label == null)
						label = name;
					//
					ElementLike text = new ElementLike("text");
					text.attribute("text-anchor", "middle");
					if (circle.Filled) {
						text.attribute("dy", "0.34em");
						text.attribute("style", "font-size: 11px; font-family: Arial, Helvetica;");
					} else {
						// Context.
						double labelLength = Math.max(1, label.length());
						double size = Math.min(maxRelativeSize, circle.Radius * 2.0 / maxComponent / labelLength);
						text.attribute("style", String.format("font-size: %svw; font-family: Arial, Helvetica; fill-opacity: 0.2; stroke: black; stroke-width: %svw;", size, size / 100.0));
					}
					text.text(label);
					//
					pointGroup.child(text);
				}
				builder.append(pointGroup.buildString(1));
			}
		}
		return builder;
	}
}
