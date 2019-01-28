package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EclipseProjectPluginFileManager implements JavaFileManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(EclipseProjectPluginFileManager.class);
	private final JavaFileManager fallbackFileManager;
	private final ClassLoader classLoader;
	private final File classDir;

	public EclipseProjectPluginFileManager(JavaFileManager fallbackFileManager, ClassLoader classLoader, File classDir) {
		this.fallbackFileManager = fallbackFileManager;
		this.classLoader = classLoader;
		this.classDir = classDir;
	}

	@Override
	public boolean isSameFile(FileObject a, FileObject b) {
		if (a instanceof PhysicalJavaFileObject || b instanceof PhysicalJavaFileObject) {
			return a.toUri().equals(b.toUri());
		}
		return fallbackFileManager.isSameFile(a, b);
	}

	@Override
	public void close() throws IOException {
		fallbackFileManager.close();
	}

	@Override
	public void flush() throws IOException {
		fallbackFileManager.flush();
	}

	@Override
	public ClassLoader getClassLoader(Location location) {
		return classLoader;
	}

	@Override
	public FileObject getFileForInput(Location location, String packageName, String relativeName) throws IOException {
		return fallbackFileManager.getFileForInput(location, packageName, relativeName);
	}

	@Override
	public FileObject getFileForOutput(Location location, String packageName, String relativeName, FileObject sibling) throws IOException {
		return fallbackFileManager.getFileForOutput(location, packageName, relativeName, sibling);
	}

	@Override
	public JavaFileObject getJavaFileForInput(Location location, String className, Kind kind) throws IOException {
		return fallbackFileManager.getJavaFileForInput(location, className, kind);
	}

	@Override
	public JavaFileObject getJavaFileForOutput(Location location, String className, Kind kind, FileObject sibling) throws IOException {
		String path = className.replace(".", File.separator);
		String cleanPath = path;
		if (cleanPath.contains("$")) {
			cleanPath = cleanPath.substring(0, cleanPath.indexOf("$"));
		}
		return null;
	}

	@Override
	public boolean handleOption(String current, Iterator<String> remaining) {
		return fallbackFileManager.handleOption(current, remaining);
	}

	@Override
	public boolean hasLocation(Location location) {
		return fallbackFileManager.hasLocation(location);
	}

	@Override
	public String inferBinaryName(Location location, JavaFileObject file) {
		if (file instanceof PhysicalJavaFileObject) {
			return ((PhysicalJavaFileObject)file).getCleanName();
		} else {
			return fallbackFileManager.inferBinaryName(location, file);
		}
	}

	@Override
	public Iterable<JavaFileObject> list(Location location, final String packageName, Set<Kind> kinds, boolean recurse) throws IOException {
		File file = new File(classDir, packageName.replace(".", File.separator));
		final Iterator<File> arrayList = file.isDirectory() ? (Iterator<File>) Arrays.asList(file.listFiles()).iterator() : new Iterator<File>(){
			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public File next() {
				return null;
			}

			@Override
			public void remove() {
			}};
		Iterable<JavaFileObject> base = fallbackFileManager.list(location, packageName, kinds, recurse);
		if (!arrayList.hasNext()) {
			return base;
		}
		final Iterator<JavaFileObject> baseIterator = base.iterator();
		final Iterator<JavaFileObject> iterator = new Iterator<JavaFileObject>() {
			@Override
			public boolean hasNext() {
				boolean result = baseIterator.hasNext() || arrayList.hasNext();
				return result;
			}

			@Override
			public JavaFileObject next() {
				JavaFileObject next = null;
				if (baseIterator.hasNext()) {
					next = baseIterator.next();
				} else if (arrayList.hasNext()) {
					try {
						next = new PhysicalJavaFileObject(arrayList.next());
					} catch (IOException e) {
						LOGGER.error("", e);
					}
				}
				return next;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
		Iterable<JavaFileObject> iterable = new Iterable<JavaFileObject>() {
			@Override
			public Iterator<JavaFileObject> iterator() {
				return iterator;
			}
		};
		return iterable;
	}

	@Override
	public int isSupportedOption(String option) {
		return fallbackFileManager.isSupportedOption(option);
	}
}