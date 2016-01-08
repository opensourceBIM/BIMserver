package org.bimserver.javamodelchecker;

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.modelchecker.ModelChecker;
import org.bimserver.plugins.modelchecker.ModelCheckerPlugin;
import org.bimserver.shared.exceptions.PluginException;

public class JavaModelCheckerPlugin implements ModelCheckerPlugin {

	private boolean initialized;
	private PluginManagerInterface pluginManager;
	
	@Override
	public void init(PluginManagerInterface pluginManager) throws PluginException {
		this.pluginManager = pluginManager;
		initExamples(pluginManager);
		initialized = true;
	}

	private void initExamples(PluginManagerInterface pluginManager) {
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
