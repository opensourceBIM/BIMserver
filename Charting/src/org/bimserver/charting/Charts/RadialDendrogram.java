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

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.bimserver.charting.Algorithms.RadialTreeLayout;
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

public class RadialDendrogram extends Chart {

	/**
	 * Data keys: name, value, size, fill, and label.
	 *
	 * Obtain on node like: node.get("name")
	 */
	private static final prefuse.data.Schema Schema = new prefuse.data.Schema() {
		{
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
		}
	};

	public RadialDendrogram() {
		this("Radial Dendrogram");
	}

	@SuppressWarnings("serial")
	public RadialDendrogram(String title) {
		this(title,
			"Dendrograms are tree-like diagrams used to represent the distribution of a hierarchical clustering. The different depth levels represented by each node are visualized on the horizontal axes and it is useful to visualize a non-weighted hierarchy.<br />Based on <br /><a href='http://bl.ocks.org/mbostock/4063570'>http://bl.ocks.org/mbostock/4063570</a>",
			"Hierarchies",
			new ArrayList<ChartOption>() {{
				add(new ChartOption("Diameter", "Diameter of the circular representation.", 1000));
			}},
			new TreeModel(Arrays.asList(new String[] { "hierarchy", "label" })),
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
	public RadialDendrogram(String title, String description, String category, ArrayList<ChartOption> options, org.bimserver.charting.Models.Model model, boolean fitToWidth) {
		super(title, description, category, options, model, fitToWidth);
	}

	@Override
	public StringBuilder writeSVGChartSpecificPayload(StringBuilder builder, ChartRows filteredData) {
		// Get "hierarchy" and "size" dimensions.
		ModelDimension hierarchy = Model.getDimensionByKey("hierarchy");
		// Get the width and height options.
		int diameter = (hasOption("Diameter")) ? ((Number) getOptionValue("Diameter")).intValue() : 1000;
		double width = diameter;
		double height = diameter;
		//
		Point2D.Double halfSizeOfPointMarker = new Point2D.Double(4.5, 4.5);
		Point2D.Double anchor = new Point2D.Double(width / 2.0, height / 2.0);
		Rectangle2D.Double bounds = new Rectangle2D.Double(0, 0, width, height);
		//
		TreeNode root = TreeNode.Consume(filteredData, hierarchy, null);
		root.collapseAllNodesWithNullNames();
		root.padTreeSoThatLeafNodesAreAllTheSameDepth();
		//
		int maxDepth = Math.max(1, root.maximumLeafDepth() + 2);
		//
		double effectiveDiameter = diameter / 2.0 / maxDepth;
		double diameterIncrement = 0.9 * effectiveDiameter;

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
		display.setBounds(0, 0, (int) Math.ceil(width), (int) Math.ceil(height));
		visualization.add("tree", graph);
		//
		LabelRenderer nodeRenderer = new LabelRenderer("label");
		nodeRenderer.setRenderType(AbstractShapeRenderer.RENDER_TYPE_DRAW);
		nodeRenderer.setHorizontalAlignment(Constants.LEFT);
		nodeRenderer.setRoundedCorner(8, 8);
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

		RadialTreeLayout layout = new RadialTreeLayout("tree", (int) effectiveDiameter);
		layout.setAutoScale(false);
		layout.setLayoutAnchor(anchor);
		layout.setLayoutBounds(bounds);
		layout.setRadiusIncrement(diameterIncrement);
		list.add(new FontAction("tree.nodes", FontLib.getFont("Arial", 11)));
		list.add(layout);
		//
		visualization.putAction("layout", list);
		// Zero elapsed time.
		layout.run(0.0);
		//
		iterateTreeCollapsingEdges(visualization, graph);
		iterateTreeToFitXAndY(visualization, graph, bounds, halfSizeOfPointMarker, builder);
		iterateTree(visualization, graph, anchor, halfSizeOfPointMarker, builder);
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
			child = (Node) b.next();
			//
			VisualItem item = visualization.getVisualItem("tree", child);
			int collapsesInto = (Integer) item.get("collapsesInto");
			if (collapsesInto >= 0) {
				// Get all edges.
				ArrayList<Integer> sources = new ArrayList<Integer>();
				ArrayList<Integer> targets = new ArrayList<Integer>();
				Iterator asTarget = child.inEdges();
				while (asTarget.hasNext()) {
					Edge otherEdge = (Edge) asTarget.next();
					sources.add(otherEdge.getSourceNode().getRow());
				}
				Iterator asSource = child.outEdges();
				while (asSource.hasNext()) {
					Edge otherEdge = (Edge) asSource.next();
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

	public void iterateTreeToFitXAndY(Visualization visualization, Graph graph, Rectangle2D.Double bounds, Point2D.Double halfSizeOfPointMarker, StringBuilder builder) {
		double horizontalDiameter = halfSizeOfPointMarker.x * 2;
		// Prepare to measure text.
		Font font = FontLib.getFont("Arial", 20);
		FontRenderContext frc = new FontRenderContext(new AffineTransform(), false, true);
		// Track maximum and minimum components.
		Double minX = null;
		Double maxX = null;
		Double minY = null;
		Double maxY = null;
		// Nodes: labels.
		Iterator b = graph.nodes();
		while (b.hasNext()) {
			//
			Node child = (Node) b.next();
			double angleInDegrees = 0;
			//
			int count = child.getChildCount();
			VisualItem otherNodeA = null;
			VisualItem otherNodeB = null;
			boolean countIsOdd = count % 2 == 1;
			if (count > 0) {
				if (countIsOdd) {
					Node pointAtNode = child.getChild(count / 2);
					otherNodeA = otherNodeB = visualization.getVisualItem("tree", pointAtNode);
				} else {
					Node pointAtNodeA = child.getChild(count / 2 - 1);
					Node pointAtNodeB = child.getChild(count / 2);
					otherNodeA = visualization.getVisualItem("tree", pointAtNodeA);
					otherNodeB = visualization.getVisualItem("tree", pointAtNodeB);
				}
			} else {
				Node parent = child.getParent();
				if (parent != null) {
					otherNodeA = otherNodeB = visualization.getVisualItem("tree", parent);
					angleInDegrees += 180;
				}
			}
			//
			VisualItem item = visualization.getVisualItem("tree", child);
			String name = child.getString("name");
			//
			double px = item.getX() - halfSizeOfPointMarker.x;
			double py = item.getY();
			//
			double x1 = px;
			double y1 = py;
			double x2 = px;
			double y2 = py;
			Point2D.Double centerOfPoint = new Point2D.Double(px, py);
			// If there's a label to print, do a text object. Otherwise, don't.
			if (name != null) {
				//
				String label = child.getString("label");
				// Derive label.
				if (label == null)
					label = name;
				if (otherNodeA != null && otherNodeB != null) {
					double mx = (otherNodeA.getX() + otherNodeB.getX()) / 2.0;
					double my = (otherNodeA.getY() + otherNodeB.getY()) / 2.0;
					angleInDegrees += Math.toDegrees(Math.atan2(my - item.getY(), mx - item.getX()));
				}
				Rectangle2D lineRectangle = font.getStringBounds(label, frc);
				double horizontalAdjustment = horizontalDiameter;
				//
				double angleInRadians = Math.toRadians(angleInDegrees);
				// Rotate.
				Point2D.Double rotatedP1 = RadialTreeLayout.Params.rotatePoint(angleInRadians, new Point2D.Double(centerOfPoint.getX() + lineRectangle.getX() + horizontalAdjustment, centerOfPoint.getY() + lineRectangle.getY()), centerOfPoint);
				Point2D.Double rotatedP2 = RadialTreeLayout.Params.rotatePoint(angleInRadians, new Point2D.Double(centerOfPoint.getX() + lineRectangle.getX() + lineRectangle.getWidth() + horizontalAdjustment, centerOfPoint.getY() + lineRectangle.getY() + lineRectangle.getHeight()), centerOfPoint);
				//
				x1 = rotatedP1.x;
				y1 = rotatedP1.y;
				x2 = rotatedP2.x;
				y2 = rotatedP2.y;
				// X.
				if (minX == null || minX > x1)
					minX = x1;
				if (minX == null || minX > x2)
					minX = x2;
				if (maxX == null || maxX < x1)
					maxX = x1;
				if (maxX == null || maxX < x2)
					maxX = x2;
				// Y.
				if (minY == null || minY > y1)
					minY = y1;
				if (minY == null || minY > y2)
					minY = y2;
				if (maxY == null || maxY < y1)
					maxY = y1;
				if (maxY == null || maxY < y2)
					maxY = y2;
			}
		}
		// Perform the fitting.
		if (minX != null && maxX != null && minY != null && maxY != null) {
			// Make translations to fitted size.
			ChartExtent xExtent = new ChartExtent(minX, maxX, bounds.x, bounds.x + bounds.width);
			ChartExtent yExtent = new ChartExtent(minY, maxY, bounds.y, bounds.y + bounds.height);
			//
			b = graph.nodes();
			while (b.hasNext()) {
				//
				Node child = (Node) b.next();
				VisualItem item = visualization.getVisualItem("tree", child);
				//
				double x = xExtent.getLinearWorldSpaceValueAtXGivenActualValue(item.getX());
				double y = yExtent.getLinearWorldSpaceValueAtXGivenActualValue(item.getY());
				//
				item.setX(x);
				item.setY(y);
			}
		}
	}

	/**
	 * @param visualization
	 * @param node
	 */
	@SuppressWarnings("unused")
	public StringBuilder iterateTree(Visualization visualization, Graph graph, Point2D.Double center, Point2D.Double halfSizeOfPointMarker, StringBuilder builder) {
		double horizontalDiameter = halfSizeOfPointMarker.x * 2;
		ElementLike boxGroup = new ElementLike("g");
		// Edges: lines between points.
		Iterator graphChildEdges = graph.edges();
		Edge edge = null;
		while (graphChildEdges.hasNext()) {
			//
			edge = (Edge) graphChildEdges.next();
			//
			Node source = graph.getSourceNode(edge);
			Node target = graph.getTargetNode(edge);
			Node sourceParent = source.getParent();
			//
			VisualItem sourceItem = visualization.getVisualItem("tree.nodes", source);
			VisualItem targetItem = visualization.getVisualItem("tree.nodes", target);
			VisualItem sourceParentItem = (sourceParent == null) ? null : visualization.getVisualItem("tree.nodes", sourceParent);
			//
			RadialTreeLayout.Params params = (RadialTreeLayout.Params) sourceItem.get(RadialTreeLayout.PARAMS);
			RadialTreeLayout.Params params2 = (RadialTreeLayout.Params) targetItem.get(RadialTreeLayout.PARAMS);
			//
			ElementLike line = new ElementLike("path");
			double sx = sourceItem.getX();
			double sy = sourceItem.getY();
			double tx = targetItem.getX();
			double ty = targetItem.getY();
			//
			double spx = sx;
			double spy = sy;
			double tpx = tx;
			double tpy = ty;
			//
			double startAdjustment = 0;
			// If there's a parent, pick P1 as a point along the simple line made by extending the parent edge. P'l is the previous edge's start point.
			if (sourceParentItem != null) {
				spx = sourceParentItem.getX();
				spy = sourceParentItem.getY();
			}
			// Otherwise, pick P1 as a point along the simple line made by this edge, but in the other direction (i.e. point back at P0). P'1 is the end of this edge.
			else {
				spx = tx;
				spy = ty;
				startAdjustment = Math.PI;
			}
			int targetChildCount = target.getChildCount();
			double endAdjustment = 0;
			// If the target node has children, pick P2 as a point drawn back from the middle of the target node's children.
			if (targetChildCount > 0) {
				boolean targetChildCountIsOdd = targetChildCount % 2 == 1;
				// P'2 can be represented exactly by the middle node.
				int idx = targetChildCount / 2;
				if (targetChildCountIsOdd) {
					Node targetChild = null;
					targetChild = target.getChild(idx);
					VisualItem targetChildItem = visualization.getVisualItem("tree.nodes", targetChild);
					tpx = targetChildItem.getX();
					tpy = targetChildItem.getY();
				}
				// P'2 can be estimated by the midpoint of it's middle 2 child nodes.
				else {
					Node targetChildA = null;
					Node targetChildB = null;
					targetChildA = target.getChild(idx - 1);
					targetChildB = target.getChild(idx);
					VisualItem targetChildItemA = visualization.getVisualItem("tree.nodes", targetChildA);
					VisualItem targetChildItemB = visualization.getVisualItem("tree.nodes", targetChildB);
					tpx = (targetChildItemA.getX() + targetChildItemB.getX()) / 2.0;
					tpy = (targetChildItemA.getY() + targetChildItemB.getY()) / 2.0;
				}
			}
			// Otherwise, target the start point of this edge, but in other direction. P'2 is the start of this edge.
			else {
				tpx = sx;
				tpy = sy;
				endAdjustment = Math.PI;
			}
			// Derived.
			double dx = tx - sx;
			double dy = ty - sy;
			// Midpoint of this edge.
			double mx = sx + dx / 2.0;
			double my = sy + dy / 2.0;
			// Get angles to extend P'1 and P'2 by the derive P1 and P2.
			double angleForPNot1 = startAdjustment + RadialTreeLayout.Params.angle(spx, spy, sx, sy);
			double angleForPNot2 = endAdjustment + RadialTreeLayout.Params.angle(tpx, tpy, tx, ty);
			// Get length at which to extend P'1 and P'2 by to derive P1 and P2.
			double length = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)) / 4.0;
			// Derive P1 and P2.
			Point2D.Double p1 = new Point2D.Double(sx + length * Math.cos(angleForPNot1), sy + length * Math.sin(angleForPNot1));
			Point2D.Double p2 = new Point2D.Double(tx + length * Math.cos(angleForPNot2), ty + length * Math.sin(angleForPNot2));
			// Prepare to add the points to the line.
			String startPoint = String.format("%s, %s", sx, sy);
			String curveThrough = String.format("%s, %s", p1.x, p1.y);
			String thenThrough = String.format("%s, %s", p2.x, p2.y);
			String endPoint = String.format("%s, %s", tx, ty);
			// Add the points to make the line.
			line.attribute("d", String.format("M %s C %s %s %s", startPoint, curveThrough, thenThrough, endPoint));
			line.attribute("style", "fill: none; stroke: rgb(204, 204, 204); stroke-width: 1px;");
			line.attribute("class", "link");
			//
			boxGroup.child(line);
		}
		// Nodes: labels.
		Iterator graphChildNodes = graph.nodes();
		Node child = null;
		while (graphChildNodes.hasNext()) {
			//
			child = (Node) graphChildNodes.next();
			double angleInDegrees = 0;
			//
			int count = child.getChildCount();
			VisualItem otherNodeA = null;
			VisualItem otherNodeB = null;
			boolean countIsOdd = count % 2 == 1;
			if (count > 0) {
				if (countIsOdd) {
					Node pointAtNode = child.getChild(count / 2);
					otherNodeA = otherNodeB = visualization.getVisualItem("tree", pointAtNode);
				} else {
					Node pointAtNodeA = child.getChild(count / 2 - 1);
					Node pointAtNodeB = child.getChild(count / 2);
					otherNodeA = visualization.getVisualItem("tree", pointAtNodeA);
					otherNodeB = visualization.getVisualItem("tree", pointAtNodeB);
				}
			} else {
				Node parent = child.getParent();
				if (parent != null) {
					otherNodeA = otherNodeB = visualization.getVisualItem("tree", parent);
					angleInDegrees += 180;
				}
			}
			//
			VisualItem item = visualization.getVisualItem("tree", child);
			RadialTreeLayout.Params params = (RadialTreeLayout.Params) item.get(RadialTreeLayout.PARAMS);
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
				Rectangle2D bounds = (Rectangle2D) item.get("_bounds");
				String label = child.getString("label");
				// Derive label.
				if (label == null)
					label = name;
				//
				ElementLike text = new ElementLike("text");
				text.attribute("style", "font-size: 20px; font-family: Arial, Helvetica;");
				text.attribute("dy", "0.31em");
				text.attribute("text-antialiasing", "true");
				//
				if (otherNodeA != null && otherNodeB != null) {
					double mx = (otherNodeA.getX() + otherNodeB.getX()) / 2.0;
					double my = (otherNodeA.getY() + otherNodeB.getY()) / 2.0;
					angleInDegrees += Math.toDegrees(Math.atan2(my - item.getY(), mx - item.getX()));
				}
				if (angleInDegrees > 90.5 && angleInDegrees < 270.5) {
					angleInDegrees += 180;
					text.attribute("text-anchor", "end");
					text.attribute("transform", String.format("rotate(%s)translate(%s, 0)", angleInDegrees, -2 * halfSizeOfPointMarker.x));
				} else {
					text.attribute("text-anchor", "start");
					text.attribute("transform", String.format("rotate(%s)translate(%s, 0)", angleInDegrees, 2 * halfSizeOfPointMarker.x));
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
