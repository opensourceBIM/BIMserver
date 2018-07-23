package org.bimserver.database.queries;

import java.util.Set;

public class DensityThresholdKey {

	private Long roid;
	private Long nrTriangles;
	private Set<String> excludedTypes;

	public DensityThresholdKey(Long roid, Long nrTriangles, Set<String> excludedTypes) {
		this.roid = roid;
		this.nrTriangles = nrTriangles;
		this.excludedTypes = excludedTypes;
	}
	
	public Long getRoid() {
		return roid;
	}
	
	public Long getNrTriangles() {
		return nrTriangles;
	}
	
	public Set<String> getExcludedTypes() {
		return excludedTypes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((excludedTypes == null) ? 0 : excludedTypes.hashCode());
		result = prime * result + ((nrTriangles == null) ? 0 : nrTriangles.hashCode());
		result = prime * result + ((roid == null) ? 0 : roid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DensityThresholdKey other = (DensityThresholdKey) obj;
		if (excludedTypes == null) {
			if (other.excludedTypes != null)
				return false;
		} else if (!excludedTypes.equals(other.excludedTypes))
			return false;
		if (nrTriangles == null) {
			if (other.nrTriangles != null)
				return false;
		} else if (!nrTriangles.equals(other.nrTriangles))
			return false;
		if (roid == null) {
			if (other.roid != null)
				return false;
		} else if (!roid.equals(other.roid))
			return false;
		return true;
	}
}
