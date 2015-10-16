package org.bimserver.plugins.classloaders;

public interface Lazy<T> {
	T get();
}