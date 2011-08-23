package org.bimserver;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.guidanceproviders.GuidanceProvider;
import org.bimserver.plugins.guidanceproviders.GuidanceProviderPlugin;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.utils.CollectionUtils;

public class SchemaFieldGuidanceProviderPlugin implements GuidanceProviderPlugin {

	private SchemaFieldIgnoreMap guidanceProvider;
	private boolean initialized = false;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		SchemaDefinition schema = pluginManager.requireSchemaDefinition();
		guidanceProvider = new SchemaFieldIgnoreMap(CollectionUtils.singleSet(Ifc2x3Package.eINSTANCE), schema);
		initialized = true;
	}

	@Override
	public String getName() {
		return getClass().getName();
	}

	@Override
	public String getDescription() {
		return "SchemaFieldGuidanceProviderPlugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public GuidanceProvider getGuidanceProvider() {
		return guidanceProvider;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getDefaultGuidanceProviderName() {
		return "default";
	}
}