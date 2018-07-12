package org.bimserver.database.queries;

import java.util.ArrayList;
import java.util.List;

public class Node<V> {
	private final Node<V>[] nodes = new Node[8];
	private Bounds bounds;
	private List<ObjectWrapper<V>> values = new ArrayList<>();
	private int level;
	private int id;
	private static int q;
	private int deepestLevel;
	private int maxDepth;
	
	public Node(Bounds bounds, int level, int parentId, int localId, int maxDepth) {
		this.bounds = bounds;
		this.level = level;
		this.maxDepth = maxDepth;
		this.id = parentId * 8 + localId;
	}
	
	public int getId() {
		return id;
	}
	
	public List<ObjectWrapper<V>> getValues() {
		return values;
	}

	public int add(V v, Bounds bounds) {
		if (level != maxDepth) {
			int localId = 1;
			for (int x=0; x<=1; x++) {
				for (int y=0; y<=1; y++) {
					for (int z=0; z<=1; z++) {
						Bounds offset = this.bounds.offset(x, y, z);
						if (bounds.within(offset)) {
							Node<V> node = nodes[x * 4 + y * 2 + z];
							if (node == null) {
								node = new Node<>(offset, this.level + 1, this.id, localId, maxDepth);
								nodes[x * 4 + y * 2 + z] = node;
							}
							int finalLevel = node.add(v, bounds);
							if (finalLevel > deepestLevel) {
								deepestLevel = finalLevel;
							}
							return finalLevel;
						}
						localId++;
					}
				}
			}
		}
		// Did not fit in any of the children
//		System.out.println(q++ + ", " + this.level);
		values.add(new ObjectWrapper<>(bounds, v));
		return level;
	}
	
	public int getDeepestLevel() {
		return deepestLevel;
	}
	
	public void query(List<V> results, Bounds bounds) {
		for (Node<V> node : nodes) {
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
	
	public Node<V>[] getNodes() {
		return nodes;
	}
	
	public void traverseBreathFirst(Traverser<V> traverser, int level) {
		if (this.level == level) {
			traverser.traverse(this);
		}
		if (level < this.level) {
			return;
		}
		for (Node<V> child : nodes) {
			if (child != null) {
				child.traverseBreathFirst(traverser, level);
			}
		}
	}
}