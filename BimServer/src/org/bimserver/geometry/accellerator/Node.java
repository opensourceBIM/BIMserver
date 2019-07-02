package org.bimserver.geometry.accellerator;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.bimserver.database.queries.Bounds;

public class Node {
	private final Node[] nodes = new Node[8];
	private Bounds bounds;
	private Bounds minimumBounds = new Bounds();
	private List<GeometryObject> values = new ArrayList<>();
	private int level;
	private int id;
	private int maxDepth;
	private Octree root;
	private int parentId;
	private int localId;
	
	public Node(Octree root, Bounds bounds, int level, int parentId, int localId, int maxDepth) {
		this.parentId = parentId;
		this.localId = localId - 1;
		this.id = parentId * 8 + localId;
		if (root != null) {
			root.addToList(this);
			if (level > root.getDeepestLevel()) {
				root.setDeepestLevel(level);
			}
		}
		this.level = level;
		this.root = root;
		this.bounds = bounds;
		this.maxDepth = maxDepth;
	}
	
	public int size() {
		int total = 0;
		for (Node node : nodes) {
			if (node != null) {
				total += node.size();
			}
		}
		total += values.size();
		return total;
	}
	
	protected void setRoot(Octree root) {
		this.root = root;
	}
	
	public int getId() {
		return id;
	}
	
	public Bounds getMinimumBounds() {
		return minimumBounds;
	}
	
	public Collection<GeometryObject> getValues() {
		return values;
	}
	
	public int valuesSize(Float minimumThreshold, Float maximumThreshold) {
		int count = 0;
		for (GeometryObject geometryObject : values) {
			// TODO lookup exact compare operators
			if ((minimumThreshold == -1 || geometryObject.getDensity() > minimumThreshold) && 
					(maximumThreshold == -1 || geometryObject.getDensity() <= maximumThreshold)) {
				count++;
			}
		}
		return count;
	}

	public int valuesSize() {
		return values.size();
	}

	public Node add(GeometryObject v) {
		return add(v, false);
	}
	
	public Node add(GeometryObject v, boolean forcedLevel) {
		// TODO do we really have to do this here? What if one of our children takes this one?	
		minimumBounds.integrate(v.getBounds());
		if (level != maxDepth && !forcedLevel) {
			int localId = 1;
			for (int x=0; x<=1; x++) {
				for (int y=0; y<=1; y++) {
					for (int z=0; z<=1; z++) {
						Bounds offset = this.bounds.offset(x, y, z);
						if (v.getBounds().within(offset)) {
							Node node = nodes[x * 4 + y * 2 + z];
							if (node == null) {
								node = new Node(root, offset, this.level + 1, this.id, localId, maxDepth);
								nodes[x * 4 + y * 2 + z] = node;
							}
							Node addedNode = node.add(v);
							return addedNode;
						}
						localId++;
					}
				}
			}
		}
		// Did not fit in any of the children, or forced
//		System.out.println(q++ + ", " + this.level);
		if (!values.add(v)) {
		}
		return this;
	}
	
	public void query(List<GeometryObject> results, Bounds bounds) {
		for (Node node : nodes) {
			if (node != null) {
				if (bounds.getMinX() > node.getBounds().getMaxX() || bounds.getMinY() > node.getBounds().getMaxY() || bounds.getMinZ() > node.getBounds().getMaxZ()) {
					continue;
				}
				if (bounds.getMaxX() < node.getBounds().getMinX() || bounds.getMaxY() < node.getBounds().getMinY() || bounds.getMaxZ() < node.getBounds().getMinZ()) {
					continue;
				}
				node.query(results, bounds);
			}
		}
	}

	public Bounds getBounds() {
		return bounds;
	}

	public int getNrObjects() {
		return values.size();
	}
	
	public Node[] getNodes() {
		return nodes;
	}
	
	public void traverseBreathFirst(Traverser traverser, int level) {
		if (this.level == level) {
			traverser.traverse(this);
		}
		if (level < this.level) {
			return;
		}
		for (Node child : nodes) {
			if (child != null) {
				child.traverseBreathFirst(traverser, level);
			}
		}
	}

	public void traverseBreathFirst(Traverser traverser) {
		traverser.traverse(this);
		for (Node child : nodes) {
			if (child != null) {
				child.traverseBreathFirst(traverser);
			}
		}
	}

	public void traverseBreathFirst(Traverser traverser, int level, int maxLevel) {
		if (this.level == level || level > maxLevel) {
			traverser.traverse(this);
		}
		if (level < this.level) {
			return;
		}
		for (Node child : nodes) {
			if (child != null) {
				child.traverseBreathFirst(traverser, level);
			}
		}
	}

	public void sort() {
		Collections.sort(this.values);
	}
	
	public int getLevel() {
		return level;
	}

	public Node getParent() {
		return root.getById(parentId);
	}
	
	public void moveUp() {
		Node parent = getParent();
		for (GeometryObject geometryObject : getValues()) {
			geometryObject.setTileId(parent.getId());
			geometryObject.setTileLevel(parent.getLevel());
			parent.add(geometryObject, true);
		}
		// If we don't do this, it doesn't result in the correct amount of objects, which implies duplication somewhere in the tree
		this.values.clear();
		parent.remove(localId);
	}

	private void remove(int localId) {
		nodes[localId] = null;
	}
}