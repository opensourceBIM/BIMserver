package org.bimserver.database.queries;

import java.util.Iterator;

public class SingleIterator<E> implements Iterator<E> {

	private E e;

	public SingleIterator(E e) {
		this.e = e;
	}
	
	@Override
	public boolean hasNext() {
		return e != null;
	}

	@Override
	public E next() {
		E n = e;
		e = null;
		return n;
	}
}