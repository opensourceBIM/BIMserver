package org.bimserver.plugins;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class PluginClassloader extends ClassLoader {

	private final File classDir;

	public PluginClassloader(ClassLoader parentClassloader, File classDir) {
		super(parentClassloader);
		this.classDir = classDir;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			Class<?> existing = super.findClass(name);
			if (existing != null) {
				return existing;
			}
		} catch (ClassNotFoundException e) {
		}
		String path = name.replace(".", File.separator) + ".class";
		File classFile = new File(classDir, path);
		if (classFile.isFile()) {
			byte[] bytes;
			try {
				bytes = FileUtils.readFileToByteArray(classFile);
				Class<?> definedClass = defineClass(name, bytes, 0, bytes.length);
				if (definedClass != null) {
					return definedClass;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		throw new ClassNotFoundException(name);
	}
}
