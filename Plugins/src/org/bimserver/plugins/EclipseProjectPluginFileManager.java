package org.bimserver.plugins;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;

public class EclipseProjectPluginFileManager implements JavaFileManager {
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
					next = new PhysicalJavaFileObject(arrayList.next());
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