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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class SankeyMatrix extends LinkedHashMap<Double, ArrayList<SankeyNode>> {

	public SankeyMatrix(ArrayList<SankeyNode> nodes) {
		// Sort nodes.
		ArrayList<SankeyNode> nodesSortedByAscendingBreadth = new ArrayList<>(nodes);
		Collections.sort(nodesSortedByAscendingBreadth, SankeyNode.ascendingBreadth);
		// Add them.
		for (SankeyNode node : nodesSortedByAscendingBreadth) {
			double key = node.Location.x();
			if (!containsKey(key))
				put(key, new ArrayList<SankeyNode>());
			get(key).add(node);
		}
	}

	public void computeNodeDepths(List<SankeyLink> links, double nodePadding, double height, int iterationLimit) {
		int iteration = iterationLimit;
		initializeNodeDepth(links, nodePadding, height);
		resolveCollisions(nodePadding, height);
		for (double alpha = 1; iteration > 0; iteration--) {
			alpha *= 0.99;
			relaxRightToLeft(alpha);
			resolveCollisions(nodePadding, height);
			relaxLeftToRight(alpha);
			resolveCollisions(nodePadding, height);
		}
	}

	private void initializeNodeDepth(List<SankeyLink> links, double nodePadding, double height) {
		double ky = Double.MAX_VALUE;
		for (Entry<Double, ArrayList<SankeyNode>> entry : this.entrySet()) {
			ArrayList<SankeyNode> nodes = entry.getValue();
			// Sum the value of the nodes.
			double sum = 0.0;
			for (SankeyNode node : nodes)
				sum += node.getValue();
			// Get best guess.
			double bestGuessDepthValue = (height - (nodes.size() - 1) * nodePadding) / sum;
			// If the best guess is less that what's on hand, pick that.
			ky = Math.min(ky, bestGuessDepthValue);
		}
		// Update nodes.
		for (Entry<Double, ArrayList<SankeyNode>> entry : this.entrySet()) {
			ArrayList<SankeyNode> nodes = entry.getValue();
			int i = 0;
			for (SankeyNode node : nodes) {
				node.Location.y(i);
				node.Delta.y(node.getValue() * ky);
				i++;
			}
		}
		// Update links.
		for (SankeyLink link : links)
			link.Delta.y(link.getValue() * ky);
	}

	private void relaxLeftToRight(double alpha) {
		for (Entry<Double, ArrayList<SankeyNode>> entry : this.entrySet()) {
			ArrayList<SankeyNode> nodes = entry.getValue();
			for (SankeyNode node : nodes) {
				if (node.TargetLinks.size() > 0) {
					// Sum value of targeted source's center, weighted by the value of the link.
					double weightedSourceSum = 0.0;
					// Sum value of target links.
					double targetLinksSum = 0.0;
					// Perform the summations.
					for (SankeyLink link : node.TargetLinks) {
						weightedSourceSum += link.Source.getCenterY() * link.getValue();
						targetLinksSum += link.getValue();
					}
					// Centering.
					double centeredY = (weightedSourceSum / targetLinksSum) - node.getCenterY();
					// Update the value.
					node.Location.y(centeredY * alpha);
				}
			}
		}
	}

	private void relaxRightToLeft(double alpha) {
		List<Entry<Double, ArrayList<SankeyNode>>> list = new ArrayList<>(entrySet());
		int end = list.size() - 1;
		for(int i = end; i >= 0 ; i--){
			Entry<Double, ArrayList<SankeyNode>> entry = list.get(i);
			ArrayList<SankeyNode> nodes = entry.getValue();
			for (SankeyNode node : nodes) {
				if (node.SourceLinks.size() > 0) {
					// Sum value of sourced target's center, weighted by the value of the link.
					double weightedTargetSum = 0.0;
					// Sum value of source links.
					double sourceLinksSum = 0.0;
					// Perform the summations.
					for (SankeyLink link : node.SourceLinks) {
						weightedTargetSum += link.Target.getCenterY() * link.getValue();
						sourceLinksSum += link.getValue();
					}
					// Centering.
					double centeredY = (weightedTargetSum / sourceLinksSum) - node.getCenterY();
					// Update the value.
					node.Location.y(centeredY * alpha);
				}
			}
		}
	}

	private void resolveCollisions(double nodePadding, double height) {
		for (Entry<Double, ArrayList<SankeyNode>> entry : this.entrySet()) {
			ArrayList<SankeyNode> nodes = entry.getValue();
			SankeyNode node = null;
			int n = nodes.size();
			//
			double dy = 0.0;
			double y0 = 0.0;
			int i = 0;
			// Push any overlapping nodes down.
			Collections.sort(nodes, SankeyNode.ascendingDepth);
			//
			for (i = 0; i < n; i++) {
				node = nodes.get(i);
				dy = y0 - node.Location.y();
				if (dy > 0)
					node.Location.y(node.Location.y() + dy);
				y0 = node.Location.y() + node.Delta.y() + nodePadding;
			}
			// If the bottom-most node goes outside the bounds, push it back up.
			dy = y0 - nodePadding - height;
			if (dy > 0) {
				node.Location.y(node.Location.y() - dy);
				y0 = node.Location.y();
				// Push any overlapping nodes back up.
				for (i = n - 2; i >= 0; i--) {
					node = nodes.get(i);
					dy = node.Location.y() + node.Delta.y() + nodePadding - y0;
					if (dy > 0)
						node.Location.y(node.Location.y() - dy);
					y0 = node.Location.y();
				}
			}
		}
	}
}
