package org.bimserver.merging;

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.modelmerger.ModelMerger;
import org.bimserver.plugins.modelmerger.ModelMergerPlugin;

public class IntelligentGuidBasedModelMergerPlugin implements ModelMergerPlugin {

	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "Intelligent GUID Based Merger";
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
		return "Intelligent GUID Based Merger";
	}

	@Override
	public ModelMerger createModelMerger() {
		return new IntelligentGuidBasedModelMerger();
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}
}