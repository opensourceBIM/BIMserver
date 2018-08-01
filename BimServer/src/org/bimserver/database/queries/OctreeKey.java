package org.bimserver.database.queries;

import java.util.Set;

import com.google.common.base.Joiner;

public class OctreeKey {
	private final Set<Long> roids;
	private final Set<String> excludedClasses;
	private final int maxDepth;
	private final float minimumThreshold;
	private final Set<Long> geometryIdsToReuse;
	private final int excludedClassesHashCode;
	private final int geometryIdsToReuseHashCode;
	private float maximumThreshold;

	public OctreeKey(Set<Long> roids, Set<String> excludedClasses, Set<Long> geometryIdsToReuse, int maxDepth, float minimumThreshold, float maximumThreshold) {
		this.roids = roids;
		if (excludedClasses != null) {
			this.excludedClasses = excludedClasses;
			excludedClassesHashCode = this.excludedClasses.hashCode();
		} else {
			this.excludedClasses = null;
			this.excludedClassesHashCode = 0;
		}
		this.geometryIdsToReuse = geometryIdsToReuse;
		this.geometryIdsToReuseHashCode = geometryIdsToReuse.hashCode();
		this.maxDepth = maxDepth;
		this.minimumThreshold = minimumThreshold;
		this.maximumThreshold = maximumThreshold;
	}

	public Set<Long> getRoids() {
		return roids;
	}

	public Set<String> getExcludedClasses() {
		return excludedClasses;
	}

	public Set<Long> getGeometryIdsToReuse() {
		return geometryIdsToReuse;
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
		result = prime * result + excludedClassesHashCode;
		result = prime * result + geometryIdsToReuseHashCode;
		result = prime * result + maxDepth;
		result = prime * result + Float.floatToIntBits(minimumThreshold);
		result = prime * result + Float.floatToIntBits(maximumThreshold);
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
		if (excludedClassesHashCode != other.excludedClassesHashCode)
			return false;
		if (geometryIdsToReuseHashCode != other.geometryIdsToReuseHashCode)
			return false;
		if (maxDepth != other.maxDepth)
			return false;
		if (Float.floatToIntBits(minimumThreshold) != Float.floatToIntBits(other.minimumThreshold))
			return false;
		if (Float.floatToIntBits(maximumThreshold) != Float.floatToIntBits(other.maximumThreshold))
			return false;
		if (roids == null) {
			if (other.roids != null)
				return false;
		} else if (!roids.equals(other.roids))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (excludedClasses != null) {
			builder.append(Joiner.on(", ").join(this.excludedClasses) + "\n");
		}
		builder.append(Joiner.on(", ").join(this.geometryIdsToReuse) + "\n");
		builder.append(maxDepth + "\n");
		builder.append(minimumThreshold + "\n");
		builder.append(roids + "\n");
		return builder.toString();
	}
	
	public float getMaximumThreshold() {
		return maximumThreshold;
	}
}