package org.bimserver.plugins;

import java.util.Set;

import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.schema.SchemaException;

public interface Plugin {
	void init(PluginManager pluginManager) throws PluginException;
	String getName();
	String getDescription();
	String getVersion();
	boolean isInitialized();
	Set<Class<? extends Plugin>> getRequiredPlugins();
}