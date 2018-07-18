package org.bimserver.database.queries;

import java.util.Set;

public class ReuseKey {

	private final Set<Long> roids;
	private final Set<String> excludedClasses;

	public ReuseKey(Set<Long> roids, Set<String> excludedClasses) {
		this.roids = roids;
		this.excludedClasses = excludedClasses;
	}

	public Set<Long> getRoids() {
		return roids;
	}

	public Set<String> getExcludedClasses() {
		return excludedClasses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((excludedClasses == null) ? 0 : excludedClasses.hashCode());
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
		ReuseKey other = (ReuseKey) obj;
		if (excludedClasses == null) {
			if (other.excludedClasses != null)
				return false;
		} else if (!excludedClasses.equals(other.excludedClasses))
			return false;
		if (roids == null) {
			if (other.roids != null)
				return false;
		} else if (!roids.equals(other.roids))
			return false;
		return true;
	}
}
