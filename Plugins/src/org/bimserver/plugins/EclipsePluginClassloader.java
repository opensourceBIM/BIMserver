package org.bimserver.plugins;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class EclipsePluginClassloader extends ClassLoader {

	private final Map<String, Class<?>> loadedClasses = new HashMap<String, Class<?>>();
	private final File projectFolder;
	private File classFolder;

	public EclipsePluginClassloader(ClassLoader parentClassloader, File projectFolder) {
		super(parentClassloader);
		this.projectFolder = projectFolder;
		this.classFolder = new File(projectFolder, "bin");
	}

	@Override
	protected URL findResource(String name) {
		File file = new File(projectFolder, name);
		if (file.exists()) {
			try {
				return file.toURI().toURL();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String filename = name.replace(".", File.separator) + ".class";
		if (loadedClasses.containsKey(filename)) {
			return loadedClasses.get(filename);
		}
		File classFile = new File(classFolder, filename);
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