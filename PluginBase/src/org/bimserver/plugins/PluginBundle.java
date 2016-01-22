package org.bimserver.plugins;

import java.io.Closeable;
import java.io.IOException;

import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.interfaces.objects.SPluginBundleVersion;

public interface PluginBundle extends Iterable<PluginContext> {

	String getVersion();

	void add(PluginContext pluginContext);

	void close() throws IOException;

	SPluginBundleVersion getPluginBundleVersion();
	
	SPluginBundle getPluginBundle();

	void addCloseable(Closeable closeable);

	PluginContext getPluginContext(String name);
}
