package org.bimserver.database.queries;

import java.util.ArrayList;
import java.util.List;

public class Octree<V> extends Node<V> {
	public Octree(Bounds bounds, int depth) {
		super(bounds);
	}
	
	public List<V> query(Bounds queryBounds) {
		List<V> results = new ArrayList<>();
		query(results, queryBounds);
		return results;
	}
}
