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

import java.util.Set;

import com.google.common.base.Joiner;

public class OctreeKey {
	private final Set<Long> roids;
	private final Set<String> excludedClasses;
	private final Set<Long> geometryIdsToReuse;
	private final int excludedClassesHashCode;
	private final int geometryIdsToReuseHashCode;
	private final int roidsHashCode;

	public OctreeKey(Set<Long> roids, Set<String> excludedClasses, Set<Long> geometryIdsToReuse) {
		this.roids = roids;
		if (excludedClasses != null) {
			this.excludedClasses = excludedClasses;
			excludedClassesHashCode = this.excludedClasses.hashCode();
		} else {
			this.excludedClasses = null;
			this.excludedClassesHashCode = 0;
		}
		this.geometryIdsToReuse = geometryIdsToReuse;
		this.geometryIdsToReuseHashCode = geometryIdsToReuse == null ? 0 : geometryIdsToReuse.hashCode();
		this.roidsHashCode = roids == null ? 0 : roids.hashCode();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + excludedClassesHashCode;
		result = prime * result + geometryIdsToReuseHashCode;
		result = prime * result + roidsHashCode;
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
		if (roidsHashCode != other.roidsHashCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (excludedClasses != null) {
			builder.append(Joiner.on(", ").join(this.excludedClasses) + "\n");
		}
		builder.append("Roids: " + Joiner.on(", ").join(roids) + "\n");
		if (geometryIdsToReuse != null) {
			builder.append("Reuse: " + Joiner.on(", ").join(geometryIdsToReuse) + "\n");
		}
		return builder.toString();
	}
}