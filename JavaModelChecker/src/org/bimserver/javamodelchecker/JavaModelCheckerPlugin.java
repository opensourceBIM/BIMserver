package org.bimserver.javamodelchecker;

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.modelchecker.ModelChecker;
import org.bimserver.plugins.modelchecker.ModelCheckerPlugin;

public class JavaModelCheckerPlugin implements ModelCheckerPlugin {

	private boolean initialized;
	private PluginManager pluginManager;
	
	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		this.pluginManager = pluginManager;
		initExamples(pluginManager);
		initialized = true;
	}

	private void initExamples(PluginManager pluginManager) {
	}

	@Override
	public String getDescription() {
		return "Java Model Checker Plugin";
	}

	@Override
	public String getDefaultName() {
		return "Java Model Checker Plugin";
	}

	@Override
	public String getVersion() {
		return "0.1";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}
	
	@Override
	public ModelChecker createModelChecker(PluginConfiguration pluginConfiguration) {
		PluginContext pluginContext = pluginManager.getPluginContext(this);
		return new JavaModelChecker(pluginContext.getClassLoader(), pluginContext.getRootPath());
	}
}
