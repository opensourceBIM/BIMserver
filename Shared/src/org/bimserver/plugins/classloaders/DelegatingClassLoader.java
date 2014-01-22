package org.bimserver.plugins.classloaders;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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