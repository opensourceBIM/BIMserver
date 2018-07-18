package org.bimserver.database.queries.om;

import java.util.HashSet;
import java.util.Set;

public class Tiles {

	private final Set<Integer> tileIds = new HashSet<>();
	private final Set<Long> geometryIdsToReuse = new HashSet<>();
	private float minimumThreshold;
	
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
}
