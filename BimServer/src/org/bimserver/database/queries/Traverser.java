package org.bimserver.database.queries;

public interface Traverser<T> {
	void traverse(Node<T> t);
}
