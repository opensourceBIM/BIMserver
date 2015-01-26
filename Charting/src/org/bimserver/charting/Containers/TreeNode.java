package org.bimserver.charting.Containers;

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
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.bimserver.charting.Delegates.ITreeNodeHandler;
import org.bimserver.charting.Dimensions.ModelDimension;

import prefuse.data.Node;

public class TreeNode
{
	/**
	 * This node's parent node.
	 */
	private TreeNode Parent = null;

	/**
	 * An array of all this node's child nodes.
	 */
	public TreeNode[] Children = new TreeNode[0];

	/**
	 * A handle to the assigned object encapsulated by this node.
	 */
	public ChartRow Data = null;

	/**
	 * A string representation of the value of the data at the hierarchy location. Should not exist on leaf nodes. Leaf nodes are considered to be the value of the hierarchy at such a level.
	 */
	public String Name = null;

	/**
	 * A string representing the key of the ModelDimension that the data in Name came from. Should exist on all nodes.
	 */
	public String Class = null;

	/**
	 * Relative size of the node. 1.0 is a pass-through.
	 */
	public Double Size = 1.0;

	public TreeNode CollapsesInto = null;

	/**
	 * Gets the parent node of this one.
	 * 
	 * @return
	 */
	public TreeNode getParent()
	{
		return Parent;
	}

	public String getTooltip()
	{
		ArrayList<String> parts = new ArrayList<>();
		TreeNode currentNode = this;
		while (currentNode != null) {
			// Add to beginning of list.
			if (currentNode.CollapsesInto == null && currentNode.Name != null)
				parts.add(0, String.format("%s", currentNode.Name));
			// Next.
			if (!currentNode.isRoot())
				currentNode = currentNode.Parent;
			else
				currentNode = null;
		}
		return StringUtils.join(parts, " > ");
	}

	/**
	 * Gets the object attached to this node. It must be cast back to what it was inserted as.
	 * 
	 * @return
	 */
	public ChartRow getData()
	{
		return Data;
	}

	/**
	 * Attaches an object to this node. Only one object can be attached to a node.
	 *
	 * @param userObject
	 */
	public void setData(ChartRow userObject)
	{
		Data = userObject;
	}

	/**
	 * Constructs a tree node object.
	 */
	public TreeNode () {}

	/**
	 * Constructs a tree node object.
	 *
	 * @param userObject
	 */
	public TreeNode (ChartRow userObject)
	{
		Data = userObject;
	}

	/**
	 * Adds the <code>child</code> node to this container making this its parent.
	 * The child is appended to the list of children as the last child.
	 *
	 * @param child
	 */
	public void add(TreeNode child)
	{
		add(child, null);
	}

	/**
	 * Adds the <code>child</code> node to this container making this its parent.
	 *
	 * @param child
	 * @param index
	 */
	public void add(TreeNode child, Integer index)
	{
		// If index is null, rewrite so that it appends.
		if (index == null)
			index = Children.length;
		// Add the child to the end of the list of children. Then, replace the list.
		if (index < 0 || index == Children.length)
		{
			TreeNode[] newChildren = new TreeNode[Children.length + 1];
			System.arraycopy(Children, 0, newChildren, 0, Children.length);
			newChildren[Children.length] = child;
			Children = newChildren;
		}
		else if (index > Children.length)
		{
			throw new IllegalArgumentException(
				String.format("Cannot add child to an index, %s. There are only %s children.", index, Children.length)
			);
		}
		// Insert node somewhere in the middle, slicing around it.
		else
		{
			TreeNode[] newChildren = new TreeNode[Children.length + 1];
			if (index > 0)
				System.arraycopy(Children, 0, newChildren, 0, index);
			newChildren[index] = child;
			System.arraycopy(Children, index, newChildren, index + 1, Children.length - index);
			Children = newChildren;
		}
		// Set the parent of the child.
		child.Parent = this;
	}

	/**
	 * Removes the child at position <code>index</code> from the tree.
	 *
	 * @param index
	 * @return The removed child node.
	 */
	public TreeNode remove(int index)
	{
		if ( index < 0 || index >= Children.length )
			throw new IllegalArgumentException(
				String.format("Cannot remove element with index %s when there are %s elements.", index, Children.length)
			);
		// Get a handle to the node being removed.
		TreeNode node = Children[index];
		node.Parent = null;
		// Remove the child from this node.
		TreeNode[] newChildren = new TreeNode[ Children.length - 1 ];
		if ( index > 0 )
			System.arraycopy( Children, 0, newChildren, 0, index );
		if ( index != Children.length - 1 )
			System.arraycopy( Children, index + 1, newChildren, index, Children.length - index - 1 );
		Children = newChildren;
		return node;
	}

	/**
	 * Removes this node from its parent.  This node becomes the root
	 * of a subtree where all of its children become first level
	 * nodes.
	 */
	public boolean removeFromParent()
	{
		boolean removed = false;
		if (Parent != null)
		{
			int position = this.index();
			Parent.remove( position );
			Parent = null;
			removed = true;
		}
		return removed;
	}

	/**
	 * Returns if this node is the root node in the tree or not.
	 *
	 * @return
	 */
	public boolean isRoot()
	{
		return (Parent == null) ? true : false;
	}

	public boolean isLeaf()
	{
		return !hasChildren();
	}

	public boolean isParentRoot()
	{
		return !isRoot() && Parent.isRoot();
	}

	public TreeNode getMajorBranch()
	{
		if (this.isRoot())
			return null;
		else {
			TreeNode node = this;
			// Walk up.
			while (!node.Parent.isRoot())
				node = node.Parent;
			return node;
		}
	}

	/**
	 * Gets a list of all the child nodes of this node.
	 *
	 * @return
	 */
	public TreeNode[] children()
	{
		return Children;
	}

	/**
	 * Returns if this node has children or if it is a leaf node.
	 *
	 * @return
	 */
	public boolean hasChildren()
	{
		return (Children.length > 0) ? true : false;
	}

	public int getLeafNodeCount() {
		int leafCount = 0;
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>(Arrays.asList(this));
		TreeNode thisNode = null;
		while (nodes.size() > 0) {
			thisNode = nodes.pop();
			if (thisNode.Children.length > 0) {
				int n = thisNode.Children.length;
				while (--n >= 0) nodes.push(thisNode.Children[n]);
			} else
				leafCount++;
		}
		return leafCount;
	}

	public TreeNode get(Integer index)
	{
		return (index != null && Children != null && Children.length > index) ? Children[index] : null;
	}

	public TreeNode get(String className)
	{
		// Go looking for a string representing the name of internal data key that was used to annotate the node.
		if (className != null && Children != null)
			for (int i = 0; i < Children.length; i++)
				if (Children[i].Class.equals(className))
					return Children[i];
		// Wasn't found.
		return null;
	}

	public TreeNode get(String className, String name)
	{
		// Go looking for a string representing the name of internal data key that was used to annotate the node.
		if (className != null && Children != null)
			for (int i = 0; i < Children.length; i++)
				if (Children[i].Class.equals(className) && Children[i].Name.equals(name))
					return Children[i];
		// Wasn't found.
		return null;
	}

	public TreeNode getByName(String name)
	{
		// Go looking for a string representing the name of internal data key that was used to annotate the node.
		if (Children != null)
			for (int i = 0; i < Children.length; i++)
				if (Children[i].Name.equals(name))
					return Children[i];
		// Wasn't found.
		return null;
	}

	/**
	 * Gets the position of this node in the list of siblings managed by the parent node. This node can be obtained by <code>this = parent.children[this.index()]</code>.
	 *
	 * @return The index of the child array of this node's parent. If this is the root node it will return null.
	 */
	public Integer index()
	{
		if (Parent != null)
		{
			for (int i = 0; ; i++)
			{
				Object node = Parent.Children[i];
				if (this == node)
					return i;
			}
		} else
			return null;
	}

	/**
	 * Gets this node's depth in the tree. The root node will have a depth of 0, first-level nodes will have a depth of 1, and so on.
	 *
	 * @return The depth of this node in the tree.
	 */
	public int depth()
	{
		return recurseDepth(Parent, 0);
	}

	public int maximumLeafDepth() {
		Integer maximumDepth = null;
		Iterator<TreeNode> iterator = iterateLeafNodes();
		while (iterator.hasNext()) {
			int depth = iterator.next().depth();
			if (maximumDepth == null || maximumDepth < depth)
				maximumDepth = depth;
		}
		return (maximumDepth != null) ? maximumDepth : 0;
	}

	public int minimumLeafDepth() {
		Integer minimumDepth = null;
		Iterator<TreeNode> iterator = iterateLeafNodes();
		while (iterator.hasNext()) {
			int depth = iterator.next().depth();
			if (minimumDepth == null || minimumDepth > depth)
				minimumDepth = depth;
		}
		return (minimumDepth != null) ? minimumDepth : 0;
	}

	/**
	 * Recursive helper method to calculate the depth of a node.
	 * The caller should pass its parent and an initial depth of 0.
	 * <p>
	 * A recursive approach is used so that when a node that is
	 * part of a tree is removed from that tree, we do not need
	 * to recalculate the depth of every node in that subtree.
	 * 
	 * @param node is the node to recursively check for its depth.
	 *  This should be set to <code>parent</code> by the caller.
	 * @param depth is the depth of the current node (i.e. the
	 *  child of <code>node</code>).  This should be set to 0 by the
	 *  caller.
	 */
	private int recurseDepth(TreeNode node, int depth)
	{
		// Reached top of tree if node (i.e. Parent of previous request) equals null. 
		return (node == null) ? depth : recurseDepth(node.Parent, depth + 1);
	}

	public boolean leavesAreAtSameDepth()
	{
		Integer lastObservedDepth = null;
		Iterator<TreeNode> iterator = iterateLeafNodes();
		while(iterator.hasNext()) {
			int depth = iterator.next().depth();
			if (lastObservedDepth != null && !lastObservedDepth.equals(depth))
				return false;
			lastObservedDepth = depth;
		}
		return true;
	}

	// Pre-order traversal.
	public void walkNodesFromRootToLeaves(ITreeNodeHandler callback) {
		Iterator<TreeNode> nodes = iterateFromRootToLeafNodes();
		while(nodes.hasNext())
			callback.handleNode(nodes.next());
	}

	// Post-order traversal.
	public void walkNodesFromLeavesToRoot(ITreeNodeHandler callback) {
		Iterator<TreeNode> nodes2 = iterateFromLeafNodesToRoot();
		while (nodes2.hasNext())
			callback.handleNode(nodes2.next());
	}

	// Leaf node traversal.
	public void walkLeafNodes(ITreeNodeHandler callback) {
		Iterator<TreeNode> nodes = iterateLeafNodes();
		while (nodes.hasNext())
			callback.handleNode(nodes.next());
	}

	public Iterator<TreeNode> iterateFromRootToLeafNodes() {
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>(Arrays.asList(this));
		LinkedList<TreeNode> returningNodes = new LinkedList<TreeNode>();
		TreeNode thisNode = null;
		while (nodes.size() > 0) {
			thisNode = nodes.pop();
			returningNodes.add(thisNode);
			if (thisNode.Children.length > 0) {
				int n = thisNode.Children.length;
				while (--n >= 0) nodes.push(thisNode.Children[n]);
			}
		}
		return returningNodes.iterator();
	}

	public Iterator<TreeNode> iterateFromLeafNodesToRoot() {
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>(Arrays.asList(this));
		LinkedList<TreeNode> returningNodes = new LinkedList<>();
		TreeNode thisNode = null;
		while (nodes.size() > 0) {
			thisNode = nodes.pop();
			returningNodes.push(thisNode);
			if (thisNode.Children.length > 0) {
				int i = -1;
				int n = thisNode.Children.length;
				while (++i < n) nodes.push(thisNode.Children[i]);
			}
		}
		return returningNodes.iterator();
	}

	public Iterator<TreeNode> iterateLeafNodes() {
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>(Arrays.asList(this));
		LinkedList<TreeNode> leafNodes = new LinkedList<>();
		TreeNode thisNode = null;
		while (nodes.size() > 0) {
			thisNode = nodes.pop();
			if (thisNode.Children.length > 0) {
				int i = -1;
				int n = thisNode.Children.length;
				while (++i < n) nodes.push(thisNode.Children[i]);
			} else
				leafNodes.push(thisNode);
		}
		return leafNodes.iterator();
	}

	public static TreeNode Consume(ChartRows filteredData, ModelDimension hierarchy, ModelDimension size) {
		return Consume(filteredData, hierarchy, size, 1.0);
	}

	/**
	 * @param filteredData
	 * @param hierarchy
	 * @param size
	 * @param minimumSize
	 * @return
	 */
	public static TreeNode Consume(ChartRows filteredData, ModelDimension hierarchy, ModelDimension size, Double minimumSize) {
		// Create a TreeNode to act as a root for all other data.
		TreeNode root = new TreeNode();
		// If hierarchy is available, go find it in the data.
		if (hierarchy != null) {
			// Iterate filtered data.
			for (ChartRow row : filteredData) {
				// Look up hierarchy.
				if (row.containsKey(hierarchy)) {
					// Get values.
					ArrayList<Object> values = row.get(hierarchy);
					ArrayList<Object> sizes = row.get(size);
					// Get sizes.
					int valuesCount = values.size();
					int sizesCount = (sizes != null) ? sizes.size() : 0;
					// Use the top-level node as the parent.
					TreeNode parent = root;
					// Iterate hierarchy;
					for (int n = 0; n < valuesCount; n++) {
						// Get name of hierarchy.
						String className = hierarchy.KeysToBeFiltered.get(n);
						// Get the value to use as name.
						Object value = values.get(n);
						String name = String.format("%s", value);
						Number rawSize = (sizesCount > 0) ? (Number)sizes.get(n % sizesCount) : null;
						double sizeValue = (rawSize != null) ? rawSize.doubleValue() : 1.0;
						// If this is the last value in the hierarchy, this is the place where data should actually be stored.
						boolean isLeaf = (n + 1 >= valuesCount) ? true : false;
						// If it's a leaf, put data on it.
						if (isLeaf) {
							TreeNode child = new TreeNode();
							child.Class = className;
							child.Name = name;
							child.Size = (minimumSize != null) ? Math.max(minimumSize, sizeValue) : sizeValue;
							child.Data = row;
							// Given some hierarchy, ("x", "y"), this node is: root->x(Value)->y(Value)
							parent.add(child);
						}
						// Otherwise, create it if it doesn't exist, and give it a name.
						else {
							// Check if root contains node.
							TreeNode potentiallyExistingNode = parent.get(className, name);
							// Make the hierarchy node if it doesn't exist yet.
							if (potentiallyExistingNode == null) {
								TreeNode child = new TreeNode();
								child.Class = className;
								child.Name = name;
								// Add the hierarchy node.
								parent.add(child);
								// Lose the reference to parent.
								parent = child;
							}
							// Update the parent variable in preparation for the (potential) value of the next iteration.
							else
								parent = potentiallyExistingNode;
						}
					}
				}
			}
		}
		// Walk nodes. Sum size on non-leaf nodes.
		if (size != null) {
			root.walkNodesFromLeavesToRoot(new ITreeNodeHandler() {
				@Override
				public void handleNode(TreeNode node) {
					if (!node.isLeaf())
					{
						// Clear pass-through size, replacing it with a sum of its children.
						if (node.Size == 1.0) {
							node.Size = 0.0;
							for (TreeNode child : node.Children)
								node.Size += child.Size;
						}
					}
				}
			});
		}
		//
		return root;
	}

	public static TreeNode ConsumeByGroup(ChartRows filteredData, ModelDimension group, ModelDimension size) {
		// Create a TreeNode to act as a root for all other data.
		TreeNode root = new TreeNode();
		// If hierarchy is available, go find it in the data.
		if (group != null) {
			// Iterate filtered data.
			for (ChartRow row : filteredData) {
				// Look up hierarchy.
				if (row.containsKey(group)) {
					// Get values.
					ArrayList<Object> values = row.get(group);
					ArrayList<Object> sizes = row.get(size);
					// Get sizes.
					int valuesCount = values.size();
					int sizesCount = (sizes != null) ? sizes.size() : 0;
					// Iterate values. Treat all of them as leaves.
					for (int n = 0; n < valuesCount; n++) {
						// Get name of the group.
						String groupName = group.KeysToBeFiltered.get(n);
						// Get the value to use as name.
						Object rawParentNodeName = values.get(n);
						String parentName = String.format("%s", rawParentNodeName);
						double sizeValue = (sizesCount > 0) ? ((Number)sizes.get(n % sizesCount)).doubleValue() : 1.0;
						//
						TreeNode parent = null;
						{
							// Check if root contains node.
							TreeNode potentiallyExistingNode = root.getByName(parentName);
							// Make the hierarchy node if it doesn't exist yet.
							if (potentiallyExistingNode == null) {
								TreeNode child = new TreeNode();
								child.Class = null;
								child.Name = parentName;
								// Add the hierarchy node.
								root.add(child);
								// Lose the reference to parent.
								parent = child;
							}
							// Update the parent variable in preparation for the (potential) value of the next iteration.
							else
								parent = potentiallyExistingNode;
						}
						// Add the child.
						TreeNode child = new TreeNode();
						child.Class = groupName;
						child.Name = String.format("%s", sizeValue);
						child.Size = sizeValue;
						child.Data = row;
						// Given some group, "x", this node is: root->"x"->Value
						parent.add(child);
					}
				}
			}
		}
		//
		return root;
	}

	/**
	 * @param tree
	 */
	public void parseIntoPrefuseTree(prefuse.data.Tree tree) {
		TreeNode thisNode;
		Iterator<TreeNode> nodes = iterateFromLeafNodesToRoot();
		// Track IDs.
		LinkedHashMap<TreeNode, prefuse.data.Node> translationTable = new LinkedHashMap<>();
		// Make root first node. Prefuse throws exceptions otherwise.
		prefuse.data.Node prefuseRootNode = tree.addRoot();
		translationTable.put(this, prefuseRootNode);
		// Walk up from the leaves.
		while (nodes.hasNext()) {
			// Get node.
			thisNode = nodes.next();
			// Handle node.
			if (!thisNode.isRoot()) {
				prefuse.data.Node prefuseNode = tree.addNode();
				prefuseNode.set("class", thisNode.Class);
				prefuseNode.set("name", thisNode.Name);
				prefuseNode.set("size", thisNode.Size);
				prefuseNode.set("tooltip", thisNode.getTooltip());
				if (thisNode.Data != null) {
					// Do color. NOTE: Color is a value relative to other data based on magnitude.
					ArrayList<Object> colorValues = thisNode.Data.getValueListByDimensionId("color");
					if (colorValues != null && colorValues.size() > 0) {
						Object colorValue = colorValues.get(0);
						if (colorValue instanceof String)
							prefuseNode.set("color", ((String)colorValue).hashCode());
						else
							prefuseNode.set("color", ((Number)colorValue).doubleValue());
					}
					// Do labels.
					ArrayList<Object> labelValues = thisNode.Data.getValueListByDimensionId("label");
					if (labelValues != null && labelValues.size() > 0)
						prefuseNode.set("label", StringUtils.join(labelValues, ", "));
				}
				translationTable.put(thisNode, prefuseNode);
			}
		}
		// Walk translation table, adding relationships.
		for (Entry<TreeNode, Node> entry : translationTable.entrySet()) {
			TreeNode sourceNode = entry.getKey();
			prefuse.data.Node destinationNode = entry.getValue();
			//
			if (sourceNode.CollapsesInto != null)
			{
				Node prefuseNode = translationTable.get(sourceNode.CollapsesInto);
				destinationNode.set("collapsesInto", prefuseNode.getRow());
			}
			//
			if (!sourceNode.isRoot()) {
				TreeNode parentSourceNode = sourceNode.getParent();
				prefuse.data.Node parentDestinationNode = translationTable.get(parentSourceNode);
				// Add relationship.
				tree.addChildEdge(parentDestinationNode, destinationNode);
			}
		}
	}

	public void collapseAllNodesWithNullNames() {
		// Copied from: walkNodesFromRootToLeaves.
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>(Arrays.asList(this));
		TreeNode thisNode = null;
		while (nodes.size() > 0) {
			thisNode = nodes.pop();
			// If not root and name is string "null", this node will be collapsed. Otherwise, keep iterating tree.
			if (!thisNode.isRoot() && thisNode.Name.equals("null"))
			{
				// Collapse non-leaf node: reparent children to parent of collapsing node.
				if (thisNode.Children.length > 0) {
					TreeNode newParent = thisNode.Parent;
					//
					int n = thisNode.Children.length;
					while (--n >= 0) {
						// Remove child node from the node that's getting collapsed.
						TreeNode childNodeToBeReparented = thisNode.remove(n);
						// Reparent the child.
						newParent.add(childNodeToBeReparented);
						// Add the child to be processed.
						nodes.push(childNodeToBeReparented);
					}
					// Remove the node that's being collapsed.
					thisNode.removeFromParent();
				}
				// Collapse leaf node: remove this node.
				else {
					thisNode.removeFromParent();
				}
			} else {
				if (thisNode.Children.length > 0) {
					int n = thisNode.Children.length;
					while (--n >= 0) nodes.push(thisNode.Children[n]);
				}
			}
		}
	}

	public void padTreeSoThatLeafNodesAreAllTheSameDepth() {
		int maximumLeafDepth = maximumLeafDepth();
		//
		LinkedList<TreeNode> majorBranches = new LinkedList<>();
		Iterator<TreeNode> leaves = iterateLeafNodes();
		while(leaves.hasNext()) {
			TreeNode node = leaves.next();
			int depth = node.depth();
			boolean nodeMustBePadded = depth != maximumLeafDepth;
			if (nodeMustBePadded) {
				TreeNode branch = node.getMajorBranch();
				if (!majorBranches.contains(branch))
					majorBranches.add(branch);
			}
		}
		//
		while (majorBranches.size() > 0) {
			// Get branch.
			TreeNode branch = majorBranches.pop();
			LinkedList<TreeNode> nodesToConsider = new LinkedList<>(Arrays.asList(branch));
			TreeNode thisNode = null;
			do {
				thisNode = nodesToConsider.pop();
				if (thisNode.isLeaf()) {
					// This node is the only relevant one. Push it to the edge of the tree.
					int maximumDepthOfBranch = thisNode.depth();
					int delta = maximumLeafDepth - maximumDepthOfBranch;
					padParentWithXNodesThatCollapseIntoThisNode(thisNode, delta);
				} else if (thisNode.leavesAreAtSameDepth()) {
					// This node and all its children are only relevant. Push them all to the edge of the tree.
					int maximumDepthOfBranch = thisNode.maximumLeafDepth();
					int delta = maximumLeafDepth - maximumDepthOfBranch;
					padParentWithXNodesThatCollapseIntoThisNode(thisNode, delta);
				} else {
					// Prepare to move to next on next iteration of do-while loop. Only add children with an aggregate set of leaves less than the maximum leaf depth in the tree.
					for (TreeNode child : thisNode.Children) {
						int minimumLeafDepth = child.minimumLeafDepth();
						if (minimumLeafDepth < maximumLeafDepth)
							nodesToConsider.add(child);
					}
				}
			} while (!branch.leavesAreAtSameDepth());
		}
	}

	/**
	 * @param thisNode
	 * @param delta
	 * @return
	 */
	public void padParentWithXNodesThatCollapseIntoThisNode(TreeNode thisNode, int delta) {
		//
		TreeNode parent = thisNode.Parent;
		thisNode.removeFromParent();
		while (delta > 0) {
			TreeNode placeholder = new TreeNode();
			placeholder.Name = "COLLAPSE";
			placeholder.CollapsesInto = thisNode;
			parent.add(placeholder);
			parent = placeholder;
			//
			delta--;
		}
		parent.add(thisNode);
	}
}
