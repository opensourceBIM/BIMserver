package org.bimserver.ifc.compare;

import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.modelcompare.ModelCompare;
import org.bimserver.plugins.modelcompare.ModelComparePlugin;

public class GuidBasedModelComparePlugin implements ModelComparePlugin {

	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
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
	public String getDefaultModelCompareName() {
		return "GUID based compare";
	}

	@Override
	public ModelCompare createModelCompare() {
		return new GuidBasedModelCompare(null);
	}
}
