package org.bimserver.charting.Algorithms.Sankey;

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
import java.util.Collections;
import java.util.LinkedList;

public class Sankey {

	public int IterationLimit = 32;
	public double NodeWidth = 24;
	public double NodePadding = 8;
	// Replaces: size
	public double Width = 1;
	public double Height = 1;
	//
	public ArrayList<SankeyNode> Nodes = new ArrayList<>();
	public ArrayList<SankeyLink> Links = new ArrayList<>();

	/**
	 * @param nodes
	 * @param links
	 * @param iterationLimit
	 * @param nodeWidth
	 * @param nodePadding
	 * @param width
	 * @param height
	 */
	public Sankey(ArrayList<SankeyNode> nodes, ArrayList<SankeyLink> links, int iterationLimit, double nodeWidth, double nodePadding, double width, double height) {
		super();
		NodeWidth = nodeWidth;
		NodePadding = nodePadding;
		IterationLimit = iterationLimit;
		Width = width;
		Height = height;
		Nodes = nodes;
		Links = links;
	}

	public ArrayList<ArrayList<SankeyNode>> getGroupedNodes() {
		LinkedList<SankeyNode> copy = new LinkedList<SankeyNode>(Nodes);
		Collections.sort(copy, SankeyNode.advancingXValue);
		//
		ArrayList<ArrayList<SankeyNode>> list = new ArrayList<>();
		Integer currentX = null;
		ArrayList<SankeyNode> currentList = null;
		// Walk list.
		while (copy.size() > 0) {
			SankeyNode node = copy.pop();
			int thisX = (int)node.Location.x();
			// If current x is not same as this, start new sub-list.
			if (currentX == null || currentX != thisX) {
				currentX = thisX;
				currentList = new ArrayList<>();
				list.add(currentList);
			}
			currentList.add(node);
		}
		return list;
	}

	private void reLayout() {
		computeLinkDepths();
	}

	public void layout() {
		computeNodeLinks();
		computeNodeValues();
		computeNodeBreadths();
		computeNodeDepths();
		computeLinkDepths();
	}

	private void computeLinkDepths() {
		for (SankeyNode node : Nodes) {
			Collections.sort(node.SourceLinks, SankeyLink.ascendingTargetDepth);
			Collections.sort(node.TargetLinks, SankeyLink.ascendingSourceDepth);
		}
		for (SankeyNode node : Nodes) {
			double sy = 0;
			double ty = 0;
			for (SankeyLink link : node.SourceLinks) {
				link.sy = sy;
				sy += link.Delta.y();
			}
			for (SankeyLink link : node.TargetLinks) {
				link.ty = ty;
				ty += link.Delta.y();
			}
		}
	}

	private void computeNodeDepths() {
		SankeyMatrix nodesByBreadth = new SankeyMatrix(Nodes);
		nodesByBreadth.computeNodeDepths(Links, NodePadding, Height, IterationLimit);
	}

	// Iteratively assign the breadth (x-position) for each node.
	// Nodes are assigned the maximum breadth of incoming neighbors plus one;
	// nodes with no incoming links are assigned breadth zero, while
	// nodes with no outgoing links are assigned the maximum breadth.
	private void computeNodeBreadths() {
		LinkedList<SankeyNode> remainingNodes = new LinkedList<>(Nodes);
		LinkedList<SankeyNode> nextNodes;
		int x = 0;
		while (remainingNodes.size() > 0) {
			nextNodes = new LinkedList<>(); 
			for (SankeyNode node : remainingNodes) {
				node.Location.x(x);
				node.Delta.x(NodeWidth);
				for (SankeyLink link : node.SourceLinks)
					if (!nextNodes.contains(link.Target))
						nextNodes.push(link.Target);
			}
			remainingNodes = nextNodes;
			x++;
		}
		moveNodesWithNoSourceLinksByX(x);
		scaleNodeBreadths((Width - NodeWidth) / (double)(x - 1));
	}

	private void moveSourcesRight() {
		for (SankeyNode node: Nodes)
			if (node.TargetLinks.size() == 0) {
				double x = Integer.MAX_VALUE;
				// Get minimum location from target nodes.
				for (SankeyLink link : node.SourceLinks)
					x = Math.min(x, link.Target.Location.x());
				// New location, one to the left: x - 1.
				node.Location.x(x - 1);
			}
	}

	private void moveNodesWithNoSourceLinksByX(int x) {
		for (SankeyNode node : Nodes)
			if (node.SourceLinks.size() == 0)
				node.Location.x(x - 1);
	}

	private void scaleNodeBreadths(double kx) {
		for (SankeyNode node : Nodes)
			node.Location.x(node.Location.x() * kx);
	}

	// Compute the value (size) of each node by summing the associated links.
	private void computeNodeValues() {
		for (SankeyNode node : Nodes) {
			double sumSourceOnValue = 0.0;
			double sumTargetOnValue = 0.0;
			// Sum source links.
			for (SankeyLink link : node.SourceLinks)
				sumSourceOnValue += link.getValue();
			// Sum target links.
			for (SankeyLink link : node.TargetLinks)
				sumTargetOnValue += link.getValue();
			// Pick the biggest value.
			node.Value = Math.max(sumSourceOnValue, sumTargetOnValue);
		}
	}

	// Populate the sourceLinks and targetLinks for each node.
	// Also, if the source and target are not objects, assume they are indices.
	private void computeNodeLinks() {
		// Clear links on stored nodes.
		for (SankeyNode node : Nodes) {
			node.SourceLinks.clear();
			node.TargetLinks.clear();
		}
		// Attach links to nodes.
		for (SankeyLink link : Links) {
			SankeyNode source = link.Source;
			SankeyNode target = link.Target;
			//
			source.SourceLinks.add(link);
			target.TargetLinks.add(link);
		} 
	}
}
