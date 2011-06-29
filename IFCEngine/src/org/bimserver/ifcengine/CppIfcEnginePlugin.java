package org.bimserver.ifcengine;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;

public class CppIfcEnginePlugin implements IfcEnginePlugin {

	private PluginManager pluginManager;
	private boolean initialized = false;

	@Override
	public String getName() {
		return getClass().getName();
	}
	
	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) {
		this.pluginManager = pluginManager;
		initialized = true;
	}

	@Override
	public Set<Class<? extends Plugin>> getRequiredPlugins() {
		return new HashSet<Class<? extends Plugin>>();
	}
	
	@Override
	public String getDescription() {
		return "Native implementation of an IFC Engine";
	}

	@Override
	public IfcEngine createIfcEngine() throws IfcEngineException {
		File nativeFolder = pluginManager.getResourceFetcher().getFile("lib/" + File.separator + System.getProperty("sun.arch.data.model"));
		File schemaFile = pluginManager.getResourceFetcher().getFile("IFC2X3_FINAL.exp").getAbsoluteFile();
		return new FailSafeIfcEngine(schemaFile, nativeFolder, new File(pluginManager.getHomeDir(), "tmp"), pluginManager.getPluginContext(this).getLocation());
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}
}