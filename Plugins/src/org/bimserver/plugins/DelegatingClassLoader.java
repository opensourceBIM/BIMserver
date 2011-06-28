package org.bimserver.plugins;

import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Set;

public class DelegatingClassLoader extends ClassLoader {
	private final Set<JarClassLoader> jarClassLoaders = new LinkedHashSet<JarClassLoader>();
	
	public DelegatingClassLoader(ClassLoader parentClassLoader) {
		super(parentClassLoader);
	}

	public void add(JarClassLoader jarClassLoader) {
		jarClassLoaders.add(jarClassLoader);
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		for (JarClassLoader jarClassLoader : jarClassLoaders) {
			try {
				Class<?> findClass = jarClassLoader.findClass(name);
				if (findClass != null) {
					return findClass;
				}
			} catch (ClassNotFoundException e) {
			}
		}
		throw new ClassNotFoundException(name);
	}

	@Override
	protected URL findResource(String name) {
		for (JarClassLoader jarClassLoader : jarClassLoaders) {
			URL resource = jarClassLoader.findResource(name);
			if (resource != null) {
				return resource;
			}
		}
		return null;
	}
}