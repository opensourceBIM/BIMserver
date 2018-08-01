package org.bimserver.database.queries;

public class ObjectWrapper<V extends Comparable<V>> implements Comparable<ObjectWrapper<V>> {
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

	@Override
	public int compareTo(ObjectWrapper<V> o) {
		return v.compareTo(o.getV());
	}
	
	@Override
	public int hashCode() {
		return v.hashCode();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		ObjectWrapper<V> other = (ObjectWrapper<V>)obj;
		return v.equals(other.v);
	}
}
