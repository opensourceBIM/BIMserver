package org.bimserver.database.queries;

public class ObjectWrapper<V> {
	private Bounds bounds;
	private V v;

	public ObjectWrapper(Bounds bounds, V v) {
		this.bounds = bounds;
		this.v = v;
	}
	
	public Bounds getBounds() {
		return bounds;
	}
	
	public V getV() {
		return v;
	}
}
