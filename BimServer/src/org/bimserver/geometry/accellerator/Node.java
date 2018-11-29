package org.bimserver.geometry.accellerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.bimserver.database.queries.Bounds;
import org.bimserver.database.queries.ObjectWrapper;

public class Node {
	private final Node[] nodes = new Node[8];
	private Bounds bounds;
	private Bounds minimumBounds = new Bounds();
	private List<ObjectWrapper> values = new ArrayList<>();
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
	
	public Collection<ObjectWrapper> getValues() {
		return values;
	}
	
	public int valuesSize(Float minimumThreshold, Float maximumThreshold) {
		int count = 0;
		for (ObjectWrapper objectWrapper : values) {
			GeometryObject geometryObject = objectWrapper.getGeometry();
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

	public Node add(GeometryObject v, Bounds bounds) {
		return add(v, bounds, false);
	}
	
	public Node add(GeometryObject v, Bounds bounds, boolean forcedLevel) {
		// TODO do we really have to do this here? What if one of our children takes this one?	
		minimumBounds.integrate(bounds);
		if (level != maxDepth && !forcedLevel) {
			int localId = 1;
			for (int x=0; x<=1; x++) {
				for (int y=0; y<=1; y++) {
					for (int z=0; z<=1; z++) {
						Bounds offset = this.bounds.offset(x, y, z);
						if (bounds.within(offset)) {
							Node node = nodes[x * 4 + y * 2 + z];
							if (node == null) {
								node = new Node(root, offset, this.level + 1, this.id, localId, maxDepth);
								nodes[x * 4 + y * 2 + z] = node;
							}
							Node addedNode = node.add(v, bounds);
							return addedNode;
						}
						localId++;
					}
				}
			}
		}
		// Did not fit in any of the children, or forced
//		System.out.println(q++ + ", " + this.level);
		if (!values.add(new ObjectWrapper(bounds, v))) {
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

	private Bounds getBounds() {
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
		for (ObjectWrapper objectWrapper : getValues()) {
			objectWrapper.getGeometry().setTileId(parent.getId());
			objectWrapper.getGeometry().setTileLevel(parent.getLevel());
			parent.add(objectWrapper.getGeometry(), objectWrapper.getBounds(), true);
		}
		// If we don't do this, it doesn't result in the correct amount of objects, which implies duplication somewhere in the tree
		this.values.clear();
		parent.remove(localId);
	}

	private void remove(int localId) {
		nodes[localId] = null;
	}
}