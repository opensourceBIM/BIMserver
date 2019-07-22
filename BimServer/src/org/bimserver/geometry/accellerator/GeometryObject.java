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

import org.bimserver.database.queries.Bounds;
import org.eclipse.emf.ecore.EClass;

public class GeometryObject implements Comparable<GeometryObject> {

	private final long oid;
	private final long croid;
	private final int saveableTriangles;
	private final float density;
	private final EClass eClass;
	private final int triangles;
	private final float biggestFace;
	private Bounds bounds;
	private int tileId;
	private int tileLevel;
	private int reused;
	private GeometryDataObject geometryDataObject;

	public GeometryObject(long oid, EClass eClass, long croid, int saveableTriangles, int reused, int triangles, float density, Bounds objectBounds) {
		this.oid = oid;
		this.eClass = eClass;
		this.croid = croid;
		this.saveableTriangles = saveableTriangles;
		this.triangles = triangles;
		this.density = density;
		this.reused = reused;
		this.bounds = objectBounds;
		this.biggestFace = triangles / density;
	}
	
	public int getReused() {
		return reused;
	}
	
	public void setTileId(int tileId) {
		this.tileId = tileId;
	}
	
	public int getTriangles() {
		return triangles;
	}
	
	public EClass geteClass() {
		return eClass;
	}
	
	public long getOid() {
		return oid;
	}
	
	public long getCroid() {
		return croid;
	}
	
	public int getSaveableTriangles() {
		return saveableTriangles;
	}

	@Override
	public int compareTo(GeometryObject o) {
		return Float.compare(o.biggestFace, biggestFace);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (oid ^ (oid >>> 32));
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
		GeometryObject other = (GeometryObject) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
	
	public float getDensity() {
		return density;
	}

	public int getTileId() {
		return tileId;
	}

	public float getOrder() {
		// The idea is that later on the determinator for ordering can be changed to something else
		return biggestFace;
	}

	public int getTileLevel() {
		return tileLevel;
	}
	
	public void setTileLevel(int tileLevel) {
		this.tileLevel = tileLevel;
	}

	public Bounds getBounds() {
		return bounds;
	}

	public void setGeometryDataObject(GeometryDataObject geometryDataObject) {
		this.geometryDataObject = geometryDataObject;
	}
	
	public GeometryDataObject getGeometryDataObject() {
		return geometryDataObject;
	}
}
