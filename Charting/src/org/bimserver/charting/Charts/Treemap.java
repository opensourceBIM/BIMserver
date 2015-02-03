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
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.bimserver.charting.Algorithms.SizeBasedSquarifiedTreeMapLayout;
import org.bimserver.charting.ColorScales.HSLColorScale;
import org.bimserver.charting.Containers.ChartExtent;
import org.bimserver.charting.Containers.ChartOption;
import org.bimserver.charting.Containers.ChartRows;
import org.bimserver.charting.Containers.ElementLike;
import org.bimserver.charting.Containers.GroupedChartExtents;
import org.bimserver.charting.Containers.TreeNode;
import org.bimserver.charting.Dimensions.ModelDimension;
import org.bimserver.charting.Models.TreeModel;

import prefuse.Visualization;
import prefuse.action.ActionList;
import prefuse.data.Graph;
import prefuse.data.Node;
import prefuse.data.Tree;
import prefuse.render.AbstractShapeRenderer;
import prefuse.render.DefaultRendererFactory;
import prefuse.util.FontLib;
import prefuse.visual.VisualItem;
import prefuse.visual.expression.InGroupPredicate;

public class Treemap extends Chart {

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

	public Treemap() {
		this("Treemap");
	}

	@SuppressWarnings("serial")
	public Treemap(String title) {
		this(
			title,
			"A space filling visualization of data hierarchies and proportion between elements. The different hierarchical levels create visual clusters through the subdivision into rectangles proportionally to each element's value. Treemaps are useful to represent the different proportion of nested hierarchical data structures.<br/>Based on <a href='http://bl.ocks.org/mbostock/4063582'>http://bl.ocks.org/mbostock/4063582</a>",
			"Hierarchies",
			new ArrayList<ChartOption> () {{
				add(new ChartOption("Width", "Horizontal dimension.", 1000));
				add(new ChartOption("Height", "Vertical dimension.", 500));
				add(new ChartOption("Padding", "Padding between major node groups.", 5));
				add(new ChartOption("Show Labels", "Show labels on blocks.", true));
				// Any valid GroupedChartExtents<String>, including HSLColorScale and LinearColorScale.
				add(new ChartOption("Color Scale", "Scale of the color.", new HSLColorScale()));
			}},
			new TreeModel(Arrays.asList(new String[] {"hierarchy", "size", "color", "label"})),
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
	public Treemap(String title, String description, String category, ArrayList<ChartOption> options, org.bimserver.charting.Models.Model model, boolean fitToWidth) {
		super(title, description, category, options, model, fitToWidth);
	}

	@Override
	public StringBuilder writeSVGChartSpecificPayload(StringBuilder builder, ChartRows filteredData) {
		// Get "hierarchy" and "size" dimensions.
		ModelDimension hierarchy = Model.getDimensionByKey("hierarchy");
		ModelDimension size = Model.getDimensionByKey("size");
		// Get the width and height options.
		double width = (hasOption("Width")) ? (int)getOptionValue("Width") : 1000;
		double height = (hasOption("Height")) ? (int)getOptionValue("Height") : 500;
		double padding = (hasOption("Padding")) ? ((Number)getOptionValue("Padding")).doubleValue() : 5.0;
		boolean showLabels = (hasOption("Show Labels")) ? (boolean)getOptionValue("Show Labels") : true;
		// Make it so that padding is the actual value between things rather than 2 times the value.
		padding /= 2.0;
		// Color extent. Transforms data to be in range of 0 to 1. Put these values through a color scale.
		ChartExtent colorExtent = Model.getExtentFromDimensionGivenKey("color", false, filteredData, 0, 1);
		// Get color scale.
		@SuppressWarnings("unchecked")
		GroupedChartExtents<String> colorScale = (GroupedChartExtents<String>)getOptionValue("Color Scale");
		//
		TreeNode root = TreeNode.Consume(filteredData, hierarchy, size);
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
		visualization.add("tree", graph);
		//
		iterateTreeSize(visualization, graph);
		//
		DefaultRendererFactory drf = new DefaultRendererFactory();
		drf.add(new InGroupPredicate("tree.nodes"), new NodeRenderer());
		visualization.setRendererFactory(drf);
		//
		ActionList list = new ActionList();
		// "tree" refers to root of XML document. Second argument is padding versus primary node groups.
		SizeBasedSquarifiedTreeMapLayout layout = new SizeBasedSquarifiedTreeMapLayout("tree", padding);
		layout.setLayoutBounds(new Rectangle2D.Double(0, 0, width, height));
		list.add(layout);
		//
		visualization.putAction("layout", list);
		// Zero elapsed time.
		layout.run(0.0);
		//
		iterateTree(visualization, graph, colorExtent, colorScale, width, showLabels, builder);
		//
		return builder;
	}

	/**
	 * @param visualization
	 * @param node
	 */
	public void iterateTreeSize(Visualization visualization, Graph graph) {
		Iterator graphChildNodes = graph.nodes();
		Node child = null;
		while (graphChildNodes.hasNext()) {
			child = (Node)graphChildNodes.next();
			VisualItem item = visualization.getVisualItem("tree", child);
			// If it's a leaf, set its size. Don't set value otherwise.
			if (child.getChildCount() == 0) {
				Double size = ((Number)child.get("size")).doubleValue();
				item.setSize(size);
			}
		}
	}

	/**
	 * @param visualization
	 * @param node
	 */
	public StringBuilder iterateTree(Visualization visualization, Graph graph, ChartExtent colorExtent, GroupedChartExtents<String> colorScale, double viewportWidth, boolean showLabels, StringBuilder builder) {
		// Prepare to measure text widths.
		Font font = null;
		FontRenderContext frc = null;
		if (showLabels) {
			// Prepare to measure text.
			font = FontLib.getFont("Arial", 11);
			frc = new FontRenderContext(new AffineTransform(), false, true);
		}
		//
		Iterator graphChildNodes = graph.nodes();
		Node child = null;
		ElementLike boxGroup = new ElementLike("g");
		while (graphChildNodes.hasNext()) {
			child = (Node)graphChildNodes.next();
			if (child.getChildCount() == 0) {
				VisualItem item = visualization.getVisualItem("tree", child);
				//
				Rectangle2D bounds = (Rectangle2D)item.get("_bounds");
				String tooltip = child.getString("tooltip");
				Double thisRawColorValue = child.getDouble("color");
				String label = child.getString("label");
				// Derive color value.
				Double colorValue = colorExtent.getLinearWorldSpaceValueAtXGivenActualValue(thisRawColorValue);
				// Derive tooltip.
				if (label != null)
					tooltip = String.format("%s: %s", tooltip, label);
				else
					tooltip = String.format("%s: %s", tooltip, item.getSize());
				// Derive label.
				if (label == null)
					label = child.getString("name");
				// Get color in color scale.
				String color = colorScale.getModulatedLinearWorldSpaceValueAtXGivenActualValue(colorValue, false);
				//
				ElementLike rect = new ElementLike("rect");
				rect.attribute("class", "cell");
				rect.attribute("width", String.format("%s", bounds.getWidth()));
				rect.attribute("height", String.format("%s", bounds.getHeight()));
				rect.attribute("style", String.format("fill: %s;", color));
				rect.attribute("stroke", "white");
				rect.attribute("transform", String.format("translate(%s, %s)", bounds.getX(), bounds.getY()));
				//
				ElementLike title = new ElementLike("title");
				title.text(tooltip);
				//
				rect.child(title);
				boxGroup.child(rect);
				// Figure out a size (based around Arial near 11px) that will be relative to the viewport's coordinates (re: vw) so that the font's scale with their containers.
				if (showLabels && label != null) {
					// Pad label.
					label = String.format(" %s ", label);
					// Container width.
					double containerWidth = bounds.getWidth();
					// Text width.
					Rectangle2D lineRectangle = font.getStringBounds(label, frc);
					double widthEstimateOfText = lineRectangle.getWidth();
					// Derived.
					double viewportMultiplierForText = 1.1 * widthEstimateOfText / containerWidth;
					//
					ElementLike text = new ElementLike("text");
					String fontSize;
					double scaleX = 1.0, scaleY = 1.0;
					if (viewportMultiplierForText < 1.0)
						fontSize = "11px";
					else {
						if (viewportMultiplierForText > 7.0)
							fontSize = null;
						else {
							fontSize = "11ptx";
							double inverseMultiplier = 1.0 / viewportMultiplierForText;
							scaleX = scaleY = inverseMultiplier;
						}
					}
					// If the font size is not infintesimally small, show the text.
					if (fontSize != null) {
						text.attribute("style", String.format("font-size: %s; font-family: Arial, Helvetica;", fontSize));
						text.attribute("text-anchor", "middle");
						text.attribute("dy", "0.45em");
						text.attribute("transform", String.format("translate(%s, %s)scale(%s, %s)", bounds.getCenterX(), bounds.getCenterY(), scaleX, scaleY));
						text.text(label);
						//
						boxGroup.child(text);
					}
				}
			}
		}
		builder.append(boxGroup.buildString(1));
		return builder;
	}

	/**
	 * A renderer for treemap nodes. Draws simple rectangles, but defers
	 * the bounds management to the layout.
	 */
	public static class NodeRenderer extends AbstractShapeRenderer {
		private Rectangle2D m_bounds = new Rectangle2D.Double();
		
		public NodeRenderer() {
			m_manageBounds = false;
		}

		protected Shape getRawShape(VisualItem item) {
			m_bounds.setRect(item.getBounds());
			return m_bounds;
		}
	}
}
