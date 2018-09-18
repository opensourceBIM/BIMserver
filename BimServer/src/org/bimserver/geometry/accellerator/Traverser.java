package org.bimserver.geometry.accellerator;

public interface Traverser<T extends Comparable<T>> {
	void traverse(Node<T> t);
}
