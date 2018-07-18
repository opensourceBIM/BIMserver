package org.bimserver.database.queries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Octree<V> extends Node<V> {

	private final Map<Integer, Node<V>> list = new HashMap<>();
	
	public Octree(Bounds bounds, int maxDepth) {
		super(null, bounds, 0, 0, 0, maxDepth);
		setRoot(this);
		addToList(this);
	}

	protected void addToList(Node<V> node) {
		list.put(node.getId(), node);
	}
	
	public List<V> query(Bounds queryBounds) {
		List<V> results = new ArrayList<>();
		query(results, queryBounds);
		return results;
	}

	public void traverseBreathFirst(Traverser<V> traverser) {
		traverser.traverse(this);
		for (int l=0; l<=getDeepestLevel(); l++) {
			traverseBreathFirst(traverser, l);
		}
	}
	
	public Node<V> getById(Integer tileId) {
		return list.get(tileId);
	}
}
