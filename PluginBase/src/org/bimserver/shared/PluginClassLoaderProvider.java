package org.bimserver.shared;

public interface PluginClassLoaderProvider {
	ClassLoader getClassLoaderFor(String name);
}
