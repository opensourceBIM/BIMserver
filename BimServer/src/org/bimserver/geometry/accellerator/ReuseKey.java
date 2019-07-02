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
	public String toString() {
		return Joiner.on(", ").join(roids) + ", " + Joiner.on(", ").join(excludedClasses);
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
