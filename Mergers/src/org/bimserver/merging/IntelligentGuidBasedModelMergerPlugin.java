package org.bimserver.merging;

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.modelmerger.ModelMerger;
import org.bimserver.plugins.modelmerger.ModelMergerPlugin;
import org.bimserver.shared.exceptions.PluginException;

public class IntelligentGuidBasedModelMergerPlugin implements ModelMergerPlugin {

	private boolean initialized;

	@Override
	public void init(PluginManagerInterface pluginManager) throws PluginException {
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "Intelligent GUID Based Fusion";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getDefaultName() {
		return "Intelligent GUID Based Fusion";
	}

	@Override
	public ModelMerger createModelMerger(PluginConfiguration pluginConfiguration) {
		return new IntelligentGuidBasedModelMerger();
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}
}