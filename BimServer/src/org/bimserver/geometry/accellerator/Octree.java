package org.bimserver.geometry.accellerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.database.queries.Bounds;
import org.bimserver.database.queries.TilingImplementation;
import org.bimserver.database.queries.om.TilingInterface;

public class Octree<V extends Comparable<V>> extends Node<V> {

	private final Map<Integer, Node<V>> list = new HashMap<>();
	private TilingImplementation tilingImplementation;
	private int deepestLevel = 0;
	
	public Octree(Bounds bounds, int maxDepth) {
		super(null, bounds, 0, 0, 0, maxDepth);
		setRoot(this);
		addToList(this);
	}

	protected void addToList(Node<V> node) {
		list.put(node.getId(), node);
	}
	
	public void setDeepestLevel(int deepestLevel) {
		this.deepestLevel = deepestLevel;
	}
	
	public int getDeepestLevel() {
		return deepestLevel;
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

	public synchronized TilingInterface getTilingImplementation() {
		if (tilingImplementation == null) {
			this.tilingImplementation = new TilingImplementation((Octree<GeometryObject>) this);
		}
		return this.tilingImplementation;
	}
}
