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

public class ReuseObject {
	private long geometryDataOid;
	private int reused;
	private int nrPrimitives;
	
	public ReuseObject(long geometryDataOid, int reused, int nrPrimitives) {
		this.geometryDataOid = geometryDataOid;
		this.reused = reused;
		this.nrPrimitives = nrPrimitives;
	}
	
	public int getNrPrimitives() {
		return nrPrimitives;
	}
	
	public int getReused() {
		return reused;
	}
	
	public long getGeometryDataOid() {
		return geometryDataOid;
	}

	public int getSaveablePrimitives() {
		return Math.max(0, (reused - 1) * nrPrimitives);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (geometryDataOid ^ (geometryDataOid >>> 32));
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
		ReuseObject other = (ReuseObject) obj;
		if (geometryDataOid != other.geometryDataOid)
			return false;
		return true;
	}

	public void inc() {
		reused++;
	}
}
