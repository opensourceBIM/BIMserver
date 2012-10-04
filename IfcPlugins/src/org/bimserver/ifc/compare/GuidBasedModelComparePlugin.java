package org.bimserver.ifc.compare;

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.modelcompare.ModelCompare;
import org.bimserver.plugins.modelcompare.ModelCompareException;
import org.bimserver.plugins.modelcompare.ModelComparePlugin;
import org.bimserver.plugins.objectidms.ObjectIDMException;

public class GuidBasedModelComparePlugin implements ModelComparePlugin {

	private boolean initialized;
	private PluginManager pluginManager;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		this.pluginManager = pluginManager;
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "GUID based compare";
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
		return "GUID based compare";
	}

	@Override
	public ModelCompare createModelCompare() throws ModelCompareException {
		try {
			return new GuidBasedModelCompare(pluginManager.requireObjectIDM());
		} catch (ObjectIDMException e) {
			throw new ModelCompareException(e);
		}
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}
}
