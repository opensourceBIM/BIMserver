package org.bimserver;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.guidanceproviders.GuidanceProvider;
import org.bimserver.plugins.guidanceproviders.GuidanceProviderPlugin;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.schema.SchemaException;
import org.bimserver.utils.CollectionUtils;

public class SchemaFieldGuidanceProviderPlugin implements GuidanceProviderPlugin {

	private SchemaFieldIgnoreMap guidanceProvider;

	@Override
	public void init(PluginManager pluginManager) {
		try {
			SchemaDefinition schema = pluginManager.requireSchemaDefinition();
			guidanceProvider = new SchemaFieldIgnoreMap(CollectionUtils.singleSet(Ifc2x3Package.eINSTANCE), schema);
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
}