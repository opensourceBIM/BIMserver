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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.bimserver.database.queries.Bounds;
import org.bimserver.database.queries.TilingImplementation;
import org.bimserver.database.queries.om.TilingInterface;

public class Octree extends Node {

	private final Map<Integer, Node> list = new HashMap<>();
	private TilingImplementation tilingImplementation;
	private int deepestLevel = 0;
	
	public Octree(Bounds bounds, int maxDepth) {
		super(null, bounds, 0, 0, 0, maxDepth);
		setRoot(this);
		addToList(this);
	}

	protected void addToList(Node node) {
		list.put(node.getId(), node);
	}
	
	public void setDeepestLevel(int deepestLevel) {
		this.deepestLevel = deepestLevel;
	}
	
	public int getDeepestLevel() {
		return deepestLevel;
	}
	
	public List<GeometryObject> query(Bounds queryBounds) {
		List<GeometryObject> results = new ArrayList<>();
		query(results, queryBounds);
		return results;
	}

	public void traverseBreathFirst(Traverser traverser) {
		for (int l=0; l<=getDeepestLevel(); l++) {
			traverseBreathFirst(traverser, l);
		}
	}
	
	public void traverseBreathFirstMaxLevel(Traverser traverser, Integer maxDepth) {
		for (int l=0; l<=getDeepestLevel(); l++) {
			traverseBreathFirst(traverser, l, maxDepth);
		}
	}
	
	public Node getById(Integer tileId) {
		return list.get(tileId);
	}

	public synchronized TilingInterface getTilingImplementation() {
		if (tilingImplementation == null) {
			this.tilingImplementation = new TilingImplementation((Octree) this);
		}
		return this.tilingImplementation;
	}
	
	public void moveUp(MoveUpDecider moveUpDecider) {
		for (int level=getDeepestLevel(); level > 0; level--) {
			Set<Node> toMoveUp = new HashSet<>();
			traverseBreathFirst(new Traverser() {
				@Override
				public void traverse(Node node) {
					if (moveUpDecider.moveUp(node)) {
						toMoveUp.add(node);
					}
				}
			}, level);
			for (Node node : toMoveUp) {
				node.moveUp();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getLevelOfId(0));
		System.out.println(getLevelOfId(1));
		System.out.println(getLevelOfId(2));
		System.out.println(getLevelOfId(8));
		System.out.println(getLevelOfId(15));
		System.out.println(getLevelOfId(123456));
		
		System.out.println();
		
		System.out.println(getParentNodeIdAtLevel(0));
		System.out.println(getParentNodeIdAtLevel(1));
		System.out.println(getParentNodeIdAtLevel(2));
		System.out.println(getParentNodeIdAtLevel(3));
		System.out.println(getParentNodeIdAtLevel(4));
		System.out.println(getParentNodeIdAtLevel(5));
		
		System.out.println();
		
		System.out.println(getStartIdAtLevel(0));
		System.out.println(getEndIdAtLevel(0));
		System.out.println(getStartIdAtLevel(1));
		System.out.println(getEndIdAtLevel(1));
		System.out.println(getStartIdAtLevel(2));
		System.out.println(getEndIdAtLevel(2));
		System.out.println(getStartIdAtLevel(3));
		System.out.println(getEndIdAtLevel(3));
		System.out.println(getStartIdAtLevel(4));
		System.out.println(getEndIdAtLevel(4));
	}
	
	public static int getLevelOfId(int id) {
		if (id == 0) {
			return 0;
		}
		for (int level=1; level<9; level++) {
			id -= Math.pow(8, level);
			if (id <= 0) {
				return level;
			}
		}
		return 0;
	}
	
	public Collection<Node> values() {
		return list.values();
	}

	public void breathFirstCounts(Float minimumThreshold, Float maximumThreshold, NodeCounter nodeCounter, int maxDepth) {
		Traverser traverser = new Traverser() {
			@Override
			public void traverse(Node t) {
				nodeCounter.counted(t, t.valuesSize(minimumThreshold, maximumThreshold));
			}
		};
		for (int l=0; l<=Math.min(getDeepestLevel(), maxDepth); l++) {
			if (l == maxDepth) {
				int startId = getStartIdAtLevel(l);
				int endId = getEndIdAtLevel(l);
				for (int nodeId=startId; nodeId<=endId; nodeId++) {
					Node node = getById(nodeId);
					if (node != null) {
						// We need to aggregate counts
						final AtomicInteger count = new AtomicInteger();
						Traverser countingTraverser = new Traverser() {
							@Override
							public void traverse(Node t) {
								count.addAndGet(t.valuesSize(minimumThreshold, maximumThreshold));
						}};
						node.traverseBreathFirst(countingTraverser);
						if (count.get() > 0) {
							nodeCounter.counted(node, count.get());
						}
					}
				}
			} else {
				traverseBreathFirst(traverser, l);
			}
		}
	}

	private static int getEndIdAtLevel(int level) {
		return getParentNodeIdAtLevel(level + 1) - 1;
	}

	private static int getStartIdAtLevel(int level) {
		int startId = 0;
		for (int i=1; i<=level; i++) {
			startId += Math.pow(8, (i - 1));
		}
		return startId;
	}

	private static int getParentNodeIdAtLevel(int level) {
		int id = 0;
		for (int i=0; i<level; i++) {
			id += Math.pow(8, i);
		}
		return id;
	}

	public void moveGeometryDown(MoveGeometryDownDecider moveGeometryDownDecider) {
		for (int level=0; level <= getDeepestLevel(); level++) {
			traverseBreathFirst(new Traverser() {
				@Override
				public void traverse(Node node) {
					Set<GeometryObject> toMoveDown = new HashSet<>();
					for (GeometryObject geometryObject : node.getValues()) {
						if (moveGeometryDownDecider.shouldMoveDown(geometryObject)) {
							toMoveDown.add(geometryObject);
						}
					}
					for (GeometryObject geometryObject : toMoveDown) {
						// Moving it down means
					}
				}
			}, level);
			
		}
	}
}