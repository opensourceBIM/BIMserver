package org.bimserver.database.queries;

import org.bimserver.geometry.accellerator.GeometryObject;

public class ObjectWrapper implements Comparable<ObjectWrapper> {
	private Bounds bounds;
	private GeometryObject v;

	public ObjectWrapper(Bounds bounds, GeometryObject v) {
		this.bounds = bounds;
		this.v = v;
	}
	
	public Bounds getBounds() {
		return bounds;
	}
	
	public GeometryObject getV() {
		return v;
	}

	@Override
	public int compareTo(ObjectWrapper o) {
		return v.compareTo(o.getV());
	}
	
	@Override
	public int hashCode() {
		return v.hashCode();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		ObjectWrapper other = (ObjectWrapper)obj;
		return v.equals(other.v);
	}
}
