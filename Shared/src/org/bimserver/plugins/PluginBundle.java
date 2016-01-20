package org.bimserver.plugins;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.bimserver.plugins.classloaders.FileJarClassLoader;

public class PluginBundle implements Iterable<Plugin> {
	private final Set<Plugin> plugins = new HashSet<>();
	private final Set<FileJarClassLoader> classloaders = new HashSet<>();
	private String identifier;

	public PluginBundle(String identifier) {
		this.identifier = identifier;
	}
	
	public void add(Plugin plugin) {
		plugins.add(plugin);
	}

	@Override
	public Iterator<Plugin> iterator() {
		return plugins.iterator();
	}

	public void close() throws IOException {
		for (FileJarClassLoader fileJarClassLoader : classloaders) {
			fileJarClassLoader.close();
		}
	}

	public void addClassLoader(FileJarClassLoader jarClassLoader) {
		classloaders.add(jarClassLoader);
	}

	public String getIdentifier() {
		return identifier;
	}
}
