package org.bimserver.database.queries.om;

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

import java.util.HashSet;
import java.util.Set;

public class Tiles {

	private final Set<Integer> tileIds = new HashSet<>();
	private final Set<Long> geometryIdsToReuse = new HashSet<>();
	private float minimumThreshold;
	private float maximumThreshold;
	private Object nodes;
	private int maxDepth;
	private int minimumReuseThreshold = -1;
	private TilingInterface tilingInterface;
	
	public void add(int tileId) {
		tileIds.add(tileId);
	}
	
	public void setMinimumThreshold(float minimumThreshold) {
		this.minimumThreshold = minimumThreshold;
	}
	
	public Set<Integer> getTileIds() {
		return tileIds;
	}

	public float getMinimumThreshold() {
		return minimumThreshold;
	}

	public void addGeometryIdToReuse(long id) {
		this.geometryIdsToReuse.add(id);
	}
	
	public Set<Long> getGeometryIdsToReuse() {
		return geometryIdsToReuse;
	}

	public void setNodes(Object nodes) {
		this.nodes = nodes;
	}
	
	public Object getNodes() {
		return nodes;
	}

	public int getMaxDepth() {
		return maxDepth;
	}
	
	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}

	public void setMinimumReuseThreshold(int minimumReuseThreshold) {
		this.minimumReuseThreshold = minimumReuseThreshold;
	}
	
	public int getMinimumReuseThreshold() {
		return minimumReuseThreshold;
	}
	
	public float getMaximumThreshold() {
		return maximumThreshold;
	}
	
	public void setMaximumThreshold(float maximumThreshold) {
		this.maximumThreshold = maximumThreshold;
	}

	public void setTilingInterface(TilingInterface tilingInterface) {
		this.tilingInterface = tilingInterface;
	}
	
	public TilingInterface getTilingInterface() {
		return tilingInterface;
	}
}
