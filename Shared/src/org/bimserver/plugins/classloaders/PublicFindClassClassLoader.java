package org.bimserver.plugins.classloaders;

import java.net.URL;

public abstract class PublicFindClassClassLoader extends ClassLoader {

	public PublicFindClassClassLoader(ClassLoader parentClassloader) {
		super(parentClassloader);
	}

	public abstract Class<?> findClass(String name) throws ClassNotFoundException;
	public abstract URL findResource(String name);
	public abstract void dumpStructure(int indent);
}