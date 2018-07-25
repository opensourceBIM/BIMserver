package org.bimserver.geometry;

public class Tuple<A, B> {
	private A a;
	private B b;

	public Tuple(A a, B b) {
		this.a = a;
		this.b = b;
	}
	
	public A getA() {
		return a;
	}
	
	public B getB() {
		return b;
	}
}
