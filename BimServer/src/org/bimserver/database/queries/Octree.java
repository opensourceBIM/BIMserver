package org.bimserver.database.queries;

import java.util.ArrayList;
import java.util.List;

public class Octree<V> extends Node<V> {

	public Octree(Bounds bounds, int maxDepth) {
		super(bounds, 0, 0, 0, maxDepth);
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
}
