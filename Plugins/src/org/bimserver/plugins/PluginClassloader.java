package org.bimserver.plugins;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class PluginClassloader extends ClassLoader {

	private final File classDir;
	private Map<String, Class<?>> loadedClasses = new HashMap<String, Class<?>>();

	public PluginClassloader(ClassLoader parentClassloader, File classDir) {
		super(parentClassloader);
		this.classDir = classDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String filename = name.replace(".", File.separator) + ".class";
		if (loadedClasses.containsKey(filename)) {
			return loadedClasses.get(filename);
		}
		File classFile = new File(classDir, filename);
		if (classFile.isFile()) {
			try {
				byte[] bytes = FileUtils.readFileToByteArray(classFile);
				Class<?> definedClass = defineClass(name, bytes, 0, bytes.length);
				if (definedClass != null) {
					loadedClasses.put(filename, definedClass);
					return definedClass;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		throw new ClassNotFoundException(name);
	}
}
