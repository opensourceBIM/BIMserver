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

import jersey.repackaged.com.google.common.base.Joiner;

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
	public String toString() {
		return roid + " " + nrTriangles + " " + Joiner.on(", ").join(excludedTypes);
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
