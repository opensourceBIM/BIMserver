package org.bimserver.plugins.classloaders;

import java.net.URL;

public abstract class JarClassLoader extends ClassLoader {

	public JarClassLoader(ClassLoader parentClassLoader) {
		super(parentClassLoader);
	}
	
	public abstract Class<?> findClass(String name) throws ClassNotFoundException;
	public abstract URL findResource(String name);
}
