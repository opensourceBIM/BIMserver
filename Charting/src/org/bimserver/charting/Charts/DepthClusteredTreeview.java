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

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.bimserver.charting.Containers.ChartExtent;
import org.bimserver.charting.Containers.ChartOption;
import org.bimserver.charting.Containers.ChartRows;
import org.bimserver.charting.Containers.ElementLike;
import org.bimserver.charting.Containers.TreeNode;
import org.bimserver.charting.Dimensions.ModelDimension;
import org.bimserver.charting.Models.TreeModel;

import prefuse.Constants;
import prefuse.Display;
import prefuse.Visualization;
import prefuse.action.ActionList;
import prefuse.action.assignment.FontAction;
import prefuse.action.layout.graph.NodeLinkTreeLayout;
import prefuse.data.Edge;
import prefuse.data.Graph;
import prefuse.data.Node;
import prefuse.data.Tree;
import prefuse.render.AbstractShapeRenderer;
import prefuse.render.DefaultRendererFactory;
import prefuse.render.EdgeRenderer;
import prefuse.render.LabelRenderer;
import prefuse.util.FontLib;
import prefuse.visual.VisualItem;
import prefuse.visual.expression.InGroupPredicate;

public class DepthClusteredTreeview extends Chart {

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
		//
		addColumn("collapsesInto", int.class, null);
	}};

	public DepthClusteredTreeview() {
		this("Clustered Dendrogram");
	}

	@SuppressWarnings("serial")
	public DepthClusteredTreeview(String title) {
		this(
			title,
			"Dendrograms are tree-like diagrams used to represent the distribution of a hierarchical clustering. The different depth levels represented by each node are visualized on the horizontal axes and it is useful to visualize a non-weighted hierarchy.<br />Based on <br /><a href='http://bl.ocks.org/mbostock/4063570'>http://bl.ocks.org/mbostock/4063570</a>",
			"Hierarchies",
			new ArrayList<ChartOption> () {{
				add(new ChartOption("Width", "Horizontal dimension.", 1000));
				add(new ChartOption("Height", "Vertical dimension.", 500));
			}},
			new TreeModel(Arrays.asList(new String[] {"hierarchy", "label"})),
			false
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
	public DepthClusteredTreeview(String title, String description, String category, ArrayList<ChartOption> options, org.bimserver.charting.Models.Model model, boolean fitToWidth) {
		super(title, description, category, options, model, fitToWidth);
	}

	@Override
	public StringBuilder writeSVGChartSpecificPayload(StringBuilder builder, ChartRows filteredData) {
		// Get "hierarchy" and "size" dimensions.
		ModelDimension hierarchy = Model.getDimensionByKey("hierarchy");
		// Get the width and height options.
		double width = (hasOption("Width")) ? ((Number)getOptionValue("Width")).doubleValue() : 1000;
		double height = (hasOption("Height")) ? ((Number)getOptionValue("Height")).doubleValue() : 500;
		// Turn the data into a tree, and get the metrics from it.
		TreeNode root = TreeNode.Consume(filteredData, hierarchy, null);
		root.collapseAllNodesWithNullNames();
		root.padTreeSoThatLeafNodesAreAllTheSameDepth();
		// At this point, inspect exactly how many leaf nodes there are.
		double depth = root.maximumLeafDepth() + 1;
		// Prepare to configure the tree layout.
		double spaceBetweenSiblingNodes = 11;
		double spaceBetweenSubTrees = 11;
		// Derive other metrics.
		Point2D.Double halfSizeOfPointMarker = new Point2D.Double(4.5, 4.5);
		Rectangle2D.Double bounds = new Rectangle2D.Double(0, 0, width, height);
		Point2D.Double anchor = new Point2D.Double(25, height / 2.0);
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
		EdgeRenderer edges = new EdgeRenderer(Constants.EDGE_TYPE_CURVE);
		//
		DefaultRendererFactory drf = new DefaultRendererFactory();
		drf.add(new InGroupPredicate("tree.nodes"), nodeRenderer);
		drf.add(new InGroupPredicate("tree.edges"), edges);
		visualization.setRendererFactory(drf);
		//
		ActionList list = new ActionList();
		// "tree" refers to root of XML document. Second argument is padding versus primary node groups.
		NodeLinkTreeLayout layout = new NodeLinkTreeLayout("tree", Constants.ORIENT_LEFT_RIGHT, width / depth, spaceBetweenSiblingNodes, spaceBetweenSubTrees);
		layout.setLayoutAnchor(anchor);
		layout.setLayoutBounds(bounds);
		list.add(new FontAction("tree.nodes", FontLib.getFont("Arial", 11)));
		list.add(layout);
		//
		visualization.putAction("layout", list);
		// Zero elapsed time.
		layout.run(0.0);
		// Collapse edges that are marked for simplification.
		iterateTreeCollapsingEdges(visualization, graph);
		// Fit values along vertical axis.
		iterateTreeToFitY(visualization, graph, halfSizeOfPointMarker, bounds);
		// Add shapes to builder.
		iterateTree(visualization, graph, halfSizeOfPointMarker, builder);
		//
		return builder;
	}

	/**
	 * @param visualization
	 * @param node
	 */
	public void iterateTreeCollapsingEdges(Visualization visualization, Graph graph) {
		// Nodes: labels.
		Iterator b = graph.nodes();
		Node child = null;
		while (b.hasNext()) {
			//
			child = (Node)b.next();
			//
			VisualItem item = visualization.getVisualItem("tree", child);
			int collapsesInto = (Integer)item.get("collapsesInto");
			if (collapsesInto >= 0) {
				// Get all edges.
				ArrayList<Integer> sources = new ArrayList<Integer>();
				ArrayList<Integer> targets = new ArrayList<Integer>();
				Iterator asTarget = child.inEdges();
				while(asTarget.hasNext()) {
					Edge otherEdge = (Edge)asTarget.next();
					sources.add(otherEdge.getSourceNode().getRow());
				}
				Iterator asSource = child.outEdges();
				while(asSource.hasNext()) {
					Edge otherEdge = (Edge)asSource.next();
					targets.add(otherEdge.getTargetNode().getRow());
				}
				//
				graph.removeNode(child);
				// Make edges.
				for (Integer source : sources)
					for (Integer target : targets)
						graph.addEdge(source, target);
			}
		}
	}

	/**
	 * @param visualization
	 * @param node
	 */
	public void iterateTreeToFitY(Visualization visualization, Graph graph, Point2D.Double halfSizeOfPointMarker, Rectangle2D.Double bounds) {
		double verticalDiameter = halfSizeOfPointMarker.y * 2;
		// Prepare to iterate for maximum and minimum values.
		Double minY = null;
		Double maxY = null;
		// Iterate nodes for maximum and minimum values.
		Iterator b = graph.nodes();
		while (b.hasNext()) {
			//
			Node child = (Node)b.next();
			VisualItem item = visualization.getVisualItem("tree", child);
			//
			double y = item.getY();
			if (minY == null || y < minY)
				minY = y;
			if (maxY == null || y > maxY)
				maxY = y;
		}
		// Calculate the fit.
		ChartExtent yExtent = null;
		if (minY != null && maxY != null) {
			double desiredStartY = minY - verticalDiameter;
			double desiredEndY = maxY + verticalDiameter;
			boolean someYValuesAreBeforeViewport = desiredStartY < bounds.y;
			boolean someYValuesAreAfterViewport = desiredEndY > bounds.y + bounds.height;
			boolean feelLikeIt = true;
			if (feelLikeIt || someYValuesAreBeforeViewport || someYValuesAreAfterViewport)
				yExtent = new ChartExtent(desiredStartY, desiredEndY, bounds.y, bounds.y + bounds.height);
		}
		// Fit all values.
		if (yExtent != null) {
			b = graph.nodes();
			while (b.hasNext()) {
				//
				Node child = (Node)b.next();
				VisualItem item = visualization.getVisualItem("tree", child);
				//
				double y = item.getY();
				item.setY(yExtent.getLinearWorldSpaceValueAtXGivenActualValue(y));
			}
		}
	}

	/**
	 * @param visualization
	 * @param node
	 */
	@SuppressWarnings("unused")
	public StringBuilder iterateTree(Visualization visualization, Graph graph, Point2D.Double halfSizeOfPointMarker, StringBuilder builder) {
		double horizontalDiameter = halfSizeOfPointMarker.x * 2;
		ElementLike boxGroup = new ElementLike("g");
		// Edges: lines between points.
		Iterator c = graph.edges();
		Edge edge = null;
		while(c.hasNext()) {
			//
			edge = (Edge)c.next();
			//
			Node source = graph.getSourceNode(edge);
			Node target = graph.getTargetNode(edge);
			//
			VisualItem sourceItem = visualization.getVisualItem("tree.nodes", source);
			VisualItem targetItem = visualization.getVisualItem("tree.nodes", target);
			//
			ElementLike line = new ElementLike("path");
			double sx = sourceItem.getX();
			double sy = sourceItem.getY();
			double tx = targetItem.getX();
			double ty = targetItem.getY();
			// Derived.
			double dx = tx - sx;
			double dy = ty - sy;
			//
			double mx = sx + dx / 2.0;
			double my = sy + dy / 2.0;
			//
			String startPoint = String.format("%s, %s", sx, sy);
			String curveThrough = String.format("%s, %s", mx, sy);
			String thenThrough = String.format("%s, %s", mx, ty);
			String endPoint = String.format("%s, %s", tx, ty);
			line.attribute("d", String.format("M %s C %s %s %s", startPoint, curveThrough, thenThrough, endPoint));
			line.attribute("style", "fill: none; stroke: rgb(204, 204, 204); stroke-width: 1px;");
			line.attribute("class", "link");
			//
			boxGroup.child(line);
		}
		// Nodes: labels.
		Iterator b = graph.nodes();
		Node child = null;
		while (b.hasNext()) {
			//
			child = (Node)b.next();
			//
			VisualItem item = visualization.getVisualItem("tree", child);
			String name = child.getString("name");
			//
			ElementLike pointGroup = new ElementLike("g");
			pointGroup.attribute("transform", String.format("translate(%s, %s)", item.getX() - halfSizeOfPointMarker.x, item.getY()));
			pointGroup.attribute("class", "node");
			//
			ElementLike point = new ElementLike("circle");
			point.attribute("r", String.format("%s", halfSizeOfPointMarker.x));
			point.attribute("style", "fill: rgb(238, 238, 238); stroke: rgb(153, 153, 153); stroke-width: 1px;");
			point.attribute("transform", String.format("translate(%s, 0)", halfSizeOfPointMarker.x));
			//
			ElementLike pointTitle = new ElementLike("title");
			pointTitle.text(child.getString("tooltip"));
			point.child(pointTitle);
			//
			pointGroup.child(point);
			// If there's a label to print, do a text object. Otherwise, don't.
			if (name != null) {
				//
				Rectangle2D bounds = (Rectangle2D)item.get("_bounds");
				String label = child.getString("label");
				// Derive label.
				if (label == null)
					label = name;
				//
				ElementLike text = new ElementLike("text");
				text.attribute("style", "font-size: 11px; font-family: Arial, Helvetica;");
				text.attribute("dy", "0.35em");
				// Put to left of point.
				if (child.getChildCount() > 0) {
					text.attribute("text-anchor", "end");
					text.attribute("dx", String.format("-%s", halfSizeOfPointMarker.x));
				}
				// Put to right of point.
				else {
					text.attribute("text-anchor", "start");
					text.attribute("dx", String.format("%s", horizontalDiameter + halfSizeOfPointMarker.x));
				}
				text.text(label);
				//
				pointGroup.child(text);
			}
			boxGroup.child(pointGroup);
		}
		//
		builder.append(boxGroup.buildString(1));
		return builder;
	}
}
