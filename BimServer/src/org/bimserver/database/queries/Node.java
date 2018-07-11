package org.bimserver.database.queries;

import java.util.ArrayList;
import java.util.List;

public class Node<V> {
	private final Node<V>[] nodes = new Node[8];
	private Bounds bounds;
	private List<ObjectWrapper<V>> values = new ArrayList<>();
	private int level;
	
	public Node(Bounds bounds) {
		this.bounds = bounds;
	}

	public void add(V v, Bounds bounds) {
		for (int x=0; x<1; x++) {
			for (int y=0; y<1; y++) {
				for (int z=0; z<1; z++) {
					Bounds offset = this.bounds.offset(x, y, z);
					if (bounds.within(offset)) {
						Node<V> node = nodes[x * 4 + y * 2 + z];
						if (node == null) {
							node = new Node<>(offset);
							nodes[x * 4 + y * 2 + z] = node;
						}
						nodes[x * 4 + y * 2 + z].add(v, bounds);
						return;
					}
				}
			}
		}
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
}
