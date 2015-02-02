package org.bimserver.charting.Algorithms;

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

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import org.bimserver.charting.Containers.ChartExtent;
import org.bimserver.charting.Containers.PackableCircle;
import org.bimserver.charting.Containers.Rectangle;
import org.bimserver.charting.Delegates.INodeHandler;
import org.openmali.vecmath2.Vector2d;

import prefuse.action.layout.graph.TreeLayout;
import prefuse.data.Graph;
import prefuse.data.Node;
import prefuse.data.Schema;
import prefuse.data.tuple.TupleSet;
import prefuse.visual.NodeItem;

public class CirclePacking extends TreeLayout implements INodeHandler {

	// Column value in which layout stores circle information.
	public static final String CIRCLE = "_circle";
	public static final Schema CIRCLE_SCHEMA = new Schema();
	static {
		CIRCLE_SCHEMA.addColumn(CIRCLE, PackableCircle.class);
	}

	private enum Mode {
		SetInitialRadii,
		LayNodesOut
	};

	/**
	 * Padding between things.
	 */
	public double Padding = 0;

	/**
	 * Provide for a translation between incoming value of "size" value into a world-space value.
	 */
	public ChartExtent RadiusExtent = new ChartExtent();

	public boolean SortBySize = false;

	/**
	 * Which internal method should be used as an INodeHandler.
	 */
	private Mode CurrentMode = Mode.SetInitialRadii;

	public static Comparator<Node> sortLargerRadiusSizesToFront = new Comparator<Node>() {
		public int compare(Node p1, Node p2) {
			Node first = p1;
			Node second = p2;
			//
			PackableCircle firstData = getPackableCircle(first);
			PackableCircle secondData = getPackableCircle(second);
			//
			double a = firstData.Radius;
			double b = secondData.Radius;
			// Sort larger values to front of collection. Sort smaller values to end of collection.
			if (a > b)
				return 1;
			else if (a < b)
				return -1;
			else
				return 0;
		}
	};

	public CirclePacking(String group) {
		super(group);
	}

	public CirclePacking(String group, ChartExtent sizeExtent) {
		super(group);
		RadiusExtent = sizeExtent;
	}

	public CirclePacking(String group, ChartExtent sizeExtent, double padding, boolean sortBySize) {
		super(group);
		RadiusExtent = sizeExtent;
		Padding = padding;
		SortBySize = sortBySize;
	}

	/**
	 * @see prefuse.action.Action#run(double)
	 */
	public void run(double frac) {
		// Ensure area data column exists.
		Graph g = (Graph) m_vis.getGroup(m_group);
		TupleSet nodes = g.getNodes();
		nodes.addColumns(CIRCLE_SCHEMA);
		//
		Rectangle2D r = getLayoutBounds();
		// Replaces w.
		double width = r.getWidth();
		// Replaces h.
		double height = r.getHeight();
		// Root.
		double radiusOfRoot = 0;
		NodeItem root = getLayoutRoot();
		PackableCircle rootData = new PackableCircle(new Vector2d(0, 0), radiusOfRoot);
		setPackableCircle(root, rootData);
		// Walk the nodes from root to its leaves, running the "handleNode" method on the node. This method provides the initial packing circle definitions.
		CurrentMode = Mode.SetInitialRadii;
		walkNodesFromLeavesToRoot(root, this);
		// Lay everything out.
		CurrentMode = Mode.LayNodesOut;
		walkNodesFromLeavesToRoot(root, this);
		// Translate and scale the layout to fit the requested size.
		packTransform(root, width / 2.0, height / 2.0, 1.0 / Math.max(2 * rootData.Radius / width, 2 * rootData.Radius / height));
		// When padding, recompute the layout using scaled padding.
		if (Padding != 0) {
			final double dr = Padding * Math.max(rootData.Radius / width, rootData.Radius / height);
			walkNodesFromRootToLeaves(root, new INodeHandler() {
				@Override
				public void handleNode(Node node) {
					Node parent = node.getParent();
					// Avoid setting the radius of root. Root is a containment node.
					if (parent != null) {
						PackableCircle data = getPackableCircle(node);
						data.Radius = Math.max(data.Radius - dr, 1.0);
					}
				}
			});
		}
	}

	public void handleNode(Node node) {
		if (CurrentMode == Mode.SetInitialRadii)
			setRadiusOnNodeBasedOnValue(node);
		else if(CurrentMode == Mode.LayNodesOut)
			layoutSiblingCircles(node);
	}

	private void setRadiusOnNodeBasedOnValue(Node node) {
		Node parent = node.getParent();
		// Avoid setting the radius of root. Root is a containment node.
		if (parent != null) {
			// Potentially get the pre-existing data.
			PackableCircle nodeData = getPackableCircle(node);
			// If it doesn't exist, create an initial packing circle with no location.
			if (nodeData == null)
				nodeData = new PackableCircle();
			//
			double valueAsRadius = 0.0;
			// Get a value from the incoming data, "size".
			Double rawValue = node.getDouble("size");
			// Clamp the value to chart extent range.
			rawValue = (rawValue != null) ? rawValue : RadiusExtent.getLower();
			// Get the world-space value. Ideally meant to clamps values to range 1 to 100 (i.e. non-zero and doubling as % of whole).
			double value = RadiusExtent.getLinearWorldSpaceValueAtXGivenActualValue(rawValue);
			//
			valueAsRadius = Math.sqrt(value);
			// Set the radius.
			nodeData.Radius = valueAsRadius;
			// Store it.
			node.set(CIRCLE, nodeData);
		}
	}

	private static void setPackableCircle(Node node, PackableCircle circle) {
		node.set(CIRCLE, circle);
	}

	private static PackableCircle getPackableCircle(Node node) {
		return (PackableCircle)node.get(CIRCLE);
	}

	// Call linkNode on children of presented node.
	public void setInitialNextAndPreviousLinksOnChildNodes(Node node) {
		int n = node.getChildCount();
		if (n > 0) {
			int i = -1;
			while (++i < n) linkNode(node.getChild(i));
		}
	}

	// Call unlinkNode on children of presented node.
	public void clearNextAndPreviousLinksOnChildNodes(Node node) {
		int n = node.getChildCount();
		if (n > 0) {
			int i = -1;
			while (++i < n) unlinkNode(node.getChild(i));
		}
	}

	private void linkNode(Node node) {
		PackableCircle nodeData = getPackableCircle(node);
		linkNode(node, nodeData);
	}

	private void unlinkNode(Node node) {
		PackableCircle nodeData = getPackableCircle(node);
		unlinkNode(nodeData);
	}

	private void linkNode(Node node, PackableCircle nodeData) {
		nodeData.Next = nodeData.Current = nodeData.Previous = node;
	}

	private void unlinkNode(PackableCircle nodeData) {
		nodeData.Next = nodeData.Current = nodeData.Previous = null;
	}

	private void packInsert(Node node, Node other) {
		PackableCircle a = getPackableCircle(node);
		PackableCircle b = getPackableCircle(other);
		Node interloper = a.Next;
		PackableCircle c = getPackableCircle(interloper);
		// Pack->Splice: a, b.
		a.Next = other;
		b.Previous = node;
		// Pack->Splice: b, c.
		b.Next = interloper;
		c.Previous = other;
	}

	private void packSplice(Node node, Node other) {
		PackableCircle a = getPackableCircle(node);
		PackableCircle b = getPackableCircle(other);
		// Node<->Other Node
		a.Next = other;
		b.Previous = node;
	}

	public boolean packIntersects(PackableCircle a, PackableCircle b) {
		// Calculate differences.
		double dx = b.Location.x() - a.Location.x();
		double dy = b.Location.y() - a.Location.y();
		double dr = a.Radius + b.Radius;
		// If RadiiSquared(AB) > DistanceSquared(BA), then it intersects. 
		return 0.999 * Math.pow(dr, 2) > Math.pow(dx, 2) + Math.pow(dy, 2);
	}

	private void packTransform(Node node, double x, double y, double k) {
		PackableCircle circle = getPackableCircle(node);
		double actualX = x + k * circle.Location.x();
		double actualY = y + k * circle.Location.y();
		circle.Location = new Vector2d(actualX, actualY);
		circle.Radius = k * circle.Radius;
		int n = node.getChildCount();
		if (n > 0) {
			int i = -1;
			while (++i < n) packTransform(node.getChild(i), actualX, actualY, k);
		}
	}

	private void packPlace(PackableCircle a, PackableCircle b, PackableCircle c) {
		double db = a.Radius + c.Radius;
		double dx = b.Location.x() - a.Location.x();
		double dy = b.Location.y() - a.Location.y();
		// Put C around A, but not on its same horizontal plane.
		if (db != 0 && (dx != 0 || dy != 0)) {
			// Squared lengths: RadiiSquared(BC), RadiiSquared(AC), and DistanceSquared(BA).
			double da = Math.pow(b.Radius + c.Radius, 2);
			db = Math.pow(db, 2);
			double dc = Math.pow(dx, 2) + Math.pow(dy, 2);
			// Normalization factor, driven by distance between B and A.
			double normalizationFactor = 2.0 * dc;
			// Location of C.
			double x = 0.5 + (db - da) / normalizationFactor;
			double y = Math.sqrt(Math.max(0, 2.0 * da * (db + dc) - (db -= dc) * db - Math.pow(da, 2))) / normalizationFactor;
			// Set location.
			c.Location = new Vector2d(a.Location.x() + x * dx + y * dy, a.Location.y() + x * dy - y * dx);
		}
		// Put C to left or right of A. 
		else
			c.Location = new Vector2d(a.Location.x() + db, a.Location.y());
	}

	// Ensure separation of cells in array.
	private void layoutSiblingCircles(Node node) {
		if (node == null)
			return;
		int n = node.getChildCount();
		// This is a leaf. It needs to be filled (and that's all).
		PackableCircle thisCircle = getPackableCircle(node);
		if (n <= 0) {
			thisCircle.Filled = true;
			return;
		}
		// Replaces: xMin, xMax, yMin, yMax.
		Rectangle runningBoundaries = new Rectangle(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
		// For each child node in this node, link the child's Next and Previous pointers to itself (i.e. loop back).
		setInitialNextAndPreviousLinksOnChildNodes(node);
		// Switch code focus to sorted list: get a list of sorted nodes in this pass (uses the children of the supplied node after sorting them by radius).
		ArrayList<Node> nodesInThisPass = getChildrenSortedByLargerRadiusSizeFirst(node);
		// Only ever consider three nodes as relevant to calculations.
		PackableCircle a = null, b = null, c = null;
		// Layout first node.
		a = getPackableCircle(nodesInThisPass.get(0));
		a.Location = new Vector2d(-a.Radius, 0);
		// Update running boundaries.
		runningBoundaries = runningBoundaries.getMinimumAndMaximumComponents(a.getBounds());
		if (n > 1) {
			// Layout second node.
			b = getPackableCircle(nodesInThisPass.get(1));
			b.Location = new Vector2d(b.Radius, 0);
			// Update running boundaries.
			runningBoundaries = runningBoundaries.getMinimumAndMaximumComponents(b.getBounds());
			if (n > 2) {
				c = getPackableCircle(nodesInThisPass.get(2));
				// Pack->Place: a, b, c.
				packPlace(a, b, c);
				// Update running boundaries.
				runningBoundaries = runningBoundaries.getMinimumAndMaximumComponents(c.getBounds());
				// Pack->Insert: a, c.
				packInsert(nodesInThisPass.get(0), nodesInThisPass.get(2));
				// Update link.
				a.Previous = nodesInThisPass.get(2);
				// Pack->Insert: c, b.
				packInsert(nodesInThisPass.get(2), nodesInThisPass.get(1));
				// Update link.
				b = getPackableCircle(a.Next);
				// Iterate through the rest of the children in this pass.
				for (int i = 3; i < n; i++) {
					c = getPackableCircle(nodesInThisPass.get(i));
					// Pack->Place: a, b, c.
					packPlace(a, b, c);
					// Search for the closest intersection.
					boolean thereWasAnIntersectionInTheForwardPass = false;
					double s1 = 1, s2 = 1;
					PackableCircle j = null, k = null;
					// Forward pass; loop from b.Next to Next, etc, until there is some intersection, J, against C.
					for (j = getPackableCircle(b.Next); j != b; j = getPackableCircle(j.Next), s1++) {
						// Pack->Intersects: j, c.
						if (packIntersects(j, c)) {
							thereWasAnIntersectionInTheForwardPass = true;
							break;
						}
					}
					// Backward pass; loop from a.Previous to Previous, etc, until there is some intersection, K, against C.
					if (thereWasAnIntersectionInTheForwardPass)
						for (k = getPackableCircle(a.Previous); k != getPackableCircle(j.Previous); k = getPackableCircle(k.Previous), s2++)
							if (packIntersects(k, c))
								break;
					// Update node chain.
					if (thereWasAnIntersectionInTheForwardPass) {
						// Move J to B. Otherwise, move K to A.
						if (s1 < s2 || (s1 == s2 && b.Radius < a.Radius))
							b = j;
						else
							a = k;
						// Pack->Splice: A, B;
						packSplice(a.Current, b.Current);
						i--;
					} else {
						// Pack->Insert: A, C.
						packInsert(a.Current, c.Current);
						// Move C to B.
						b = c;
						// Update running boundaries.
						runningBoundaries = runningBoundaries.getMinimumAndMaximumComponents(c.getBounds());
					}
				}
			}
		}
		// Re-center the circles and compute the encompassing radius.
		Vector2d center = runningBoundaries.getCenter();
		double cr = 0.0;
		for (int i = 0; i < n; i++) {
			c = getPackableCircle(nodesInThisPass.get(i));
			// Update location: subtract the center from the location.
			Vector2d delta = new Vector2d(c.Location.x() - center.x(), c.Location.y() - center.y());
			// Distance: (x^2 + y^2)^(0.5)
			double distance = Math.sqrt(Math.pow(delta.x(), 2) + Math.pow(delta.y(), 2));
			// Update radius.
			cr = Math.max(cr, c.Radius + distance);
			//
			c.Location.sub(center);
		}
		// Update the radius of the supplied node so that it encompasses its children.
		thisCircle.Radius = cr;
		// For each child node in this node, remove the child node's links.
		clearNextAndPreviousLinksOnChildNodes(node);
	}

	public ArrayList<Node> getChildrenSortedByLargerRadiusSizeFirst(Node node) {
		ArrayList<Node> list = new ArrayList<Node>();
		int n = node.getChildCount();
		if (n > 0) {
			int i = -1;
			while (++i < n) list.add(node.getChild(i));
		}
		// Sort larger circles to front.
		if (SortBySize)
			Collections.sort(list, sortLargerRadiusSizesToFront);
		// Send it back.
		return list;
	}

	// Pre-order traversal.
	public static void walkNodesFromRootToLeaves(Node root, INodeHandler callback) {
		Iterator<Node> nodes = iterateFromRootToLeafNodes(root);
		while(nodes.hasNext())
			callback.handleNode(nodes.next());
	}

	// Post-order traversal.
	public static void walkNodesFromLeavesToRoot(Node root, INodeHandler callback) {
		Iterator<Node> nodes2 = iterateFromLeafNodesToRoot(root);
		while (nodes2.hasNext())
			callback.handleNode(nodes2.next());
	}

	// Leaf node traversal.
	public static void walkLeafNodes(Node root, INodeHandler callback) {
		Iterator<Node> nodes = iterateLeafNodes(root);
		while (nodes.hasNext())
			callback.handleNode(nodes.next());
	}

	public static Iterator<Node> iterateFromRootToLeafNodes(Node root) {
		LinkedList<Node> nodes = new LinkedList<Node>(Arrays.asList(root));
		LinkedList<Node> returningNodes = new LinkedList<Node>();
		Node thisNode = null;
		while (nodes.size() > 0) {
			thisNode = nodes.pop();
			returningNodes.add(thisNode);
			int n = thisNode.getChildCount();
			if (n > 0)
				while (--n >= 0) nodes.push(thisNode.getChild(n));
		}
		return returningNodes.iterator();
	}

	public static Iterator<Node> iterateFromLeafNodesToRoot(Node root) {
		LinkedList<Node> nodes = new LinkedList<Node>(Arrays.asList(root));
		LinkedList<Node> returningNodes = new LinkedList<>();
		Node thisNode = null;
		while (nodes.size() > 0) {
			thisNode = nodes.pop();
			returningNodes.push(thisNode);
			int n = thisNode.getChildCount();
			if (n > 0) {
				int i = -1;
				while (++i < n) nodes.push(thisNode.getChild(i));
			}
		}
		return returningNodes.iterator();
	}

	public static Iterator<Node> iterateLeafNodes(Node root) {
		LinkedList<Node> nodes = new LinkedList<Node>(Arrays.asList(root));
		LinkedList<Node> leafNodes = new LinkedList<>();
		Node thisNode = null;
		while (nodes.size() > 0) {
			thisNode = nodes.pop();
			int n = thisNode.getChildCount();
			if (n > 0) {
				int i = -1;
				while (++i < n) nodes.push(thisNode.getChild(i));
			} else
				leafNodes.push(thisNode);
		}
		return leafNodes.iterator();
	}
}