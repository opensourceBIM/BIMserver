package org.bimserver.database.queries;

public interface Traverser<T extends Comparable<T>> {
	void traverse(Node<T> t);
}
