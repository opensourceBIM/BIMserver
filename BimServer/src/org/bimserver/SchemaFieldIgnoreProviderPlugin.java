package org.bimserver;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ignoreproviders.IgnoreProvider;
import org.bimserver.plugins.ignoreproviders.IgnoreProviderPlugin;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.schema.SchemaException;
import org.bimserver.utils.CollectionUtils;

public class SchemaFieldIgnoreProviderPlugin implements IgnoreProviderPlugin {

	private SchemaFieldIgnoreMap ignoreProvider;

	@Override
	public void init(PluginManager pluginManager) {
		try {
			SchemaDefinition schema = pluginManager.requireSchemaDefinition();
			ignoreProvider = new SchemaFieldIgnoreMap(CollectionUtils.singleSet(Ifc2x3Package.eINSTANCE), schema);
		} catch (SchemaException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getName() {
		return getClass().getName();
	}

	@Override
	public String getDescription() {
		return "SchemaFieldIgnoreProviderPlugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public IgnoreProvider getIgnoreProvider() {
		return ignoreProvider;
	}
}