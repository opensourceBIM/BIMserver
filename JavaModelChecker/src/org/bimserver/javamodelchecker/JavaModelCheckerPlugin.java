package org.bimserver.javamodelchecker;

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.modelchecker.ModelChecker;
import org.bimserver.plugins.modelchecker.ModelCheckerPlugin;

public class JavaModelCheckerPlugin implements ModelCheckerPlugin {

	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		initialized = true;
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
		return new JavaModelChecker();
	}
}
