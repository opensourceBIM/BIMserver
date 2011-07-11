package org.bimserver.guidanceproviders;

import java.util.Set;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.guidanceproviders.GuidanceProvider;
import org.bimserver.plugins.guidanceproviders.GuidanceProviderPlugin;
import org.bimserver.utils.CollectionUtils;

public class FileBasedGuidanceProviderPlugin implements GuidanceProviderPlugin {

	private boolean initialized;
	private FileBasedGuidanceProvider fileBasedGuidanceProvider;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		fileBasedGuidanceProvider = new FileBasedGuidanceProvider(CollectionUtils.singleSet(Ifc2x3Package.eINSTANCE));
		initialized = true;
	}

	@Override
	public String getName() {
		return getClass().getName();
	}

	@Override
	public String getDescription() {
		return "FileBasedGuidanceProviderPlugin";
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
	public Set<Class<? extends Plugin>> getRequiredPlugins() {
		return null;
	}

	@Override
	public GuidanceProvider getGuidanceProvider() {
		return fileBasedGuidanceProvider;
	}

	@Override
	public String getDefaultGuidanceProviderName() {
		return "FileBasedGuidanceProviderPlugin";
	}
}