package org.bimserver.plugins;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.bimserver.plugins.classloaders.FileJarClassLoader;

public class PluginBundleImpl implements PluginBundle, Iterable<PluginContext> {
	private final Set<PluginContext> pluginsContexts = new HashSet<>();
	private final Set<FileJarClassLoader> classloaders = new HashSet<>();
	private String identifier;

	public PluginBundleImpl(String identifier) {
		this.identifier = identifier;
	}
	
	public void add(PluginContext pluginContext) {
		pluginsContexts.add(pluginContext);
	}

	@Override
	public Iterator<PluginContext> iterator() {
		return pluginsContexts.iterator();
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

	@Override
	public String getVersion() {
		return null;
	}
}
