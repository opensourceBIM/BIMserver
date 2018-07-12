package org.bimserver.database.queries;

import java.util.Set;
import java.util.TreeSet;

public class OctreeKey {
	private Set<Long> roids;
	private Set<String> excludedClasses;
	private int maxDepth;
	private float minimumThreshold;

	public OctreeKey(Set<Long> roids, Set<String> excludedClasses, int maxDepth, float minimumThreshold) {
		this.roids = new TreeSet<>(roids);
		this.excludedClasses = new TreeSet<>(excludedClasses);
		this.maxDepth = maxDepth;
		this.minimumThreshold = minimumThreshold;
	}

	public Set<Long> getRoids() {
		return roids;
	}

	public Set<String> getExcludedClasses() {
		return excludedClasses;
	}

	public int getMaxDepth() {
		return maxDepth;
	}

	public float getMinimumThreshold() {
		return minimumThreshold;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((excludedClasses == null) ? 0 : excludedClasses.hashCode());
		result = prime * result + maxDepth;
		result = prime * result + Float.floatToIntBits(minimumThreshold);
		result = prime * result + ((roids == null) ? 0 : roids.hashCode());
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
		OctreeKey other = (OctreeKey) obj;
		if (excludedClasses == null) {
			if (other.excludedClasses != null)
				return false;
		} else if (!excludedClasses.equals(other.excludedClasses))
			return false;
		if (maxDepth != other.maxDepth)
			return false;
		if (Float.floatToIntBits(minimumThreshold) != Float.floatToIntBits(other.minimumThreshold))
			return false;
		if (roids == null) {
			if (other.roids != null)
				return false;
		} else if (!roids.equals(other.roids))
			return false;
		return true;
	}
}