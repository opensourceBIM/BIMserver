package org.bimserver.ifc.xml.deserializer;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.schema.SchemaPlugin;

public class IfcXmlDeserializerPlugin implements DeserializerPlugin {

	private boolean initialized = false;

	@Override
	public EmfDeserializer createDeserializer() {
		return new IfcXmlDeserializer();
	}

	@Override
	public String getDescription() {
		return "IfcXmlDeserializer";
	}

	@Override
	public String getName() {
		return getClass().getName();
	}

	@Override
	public Set<Class<? extends Plugin>> getRequiredPlugins() {
		Set<Class<? extends Plugin>> set = new HashSet<Class<? extends Plugin>>();
		set.add(SchemaPlugin.class);
		return set;
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		initialized = true;
		pluginManager.requireSchemaDefinition();
	}

	@Override
	public boolean canHandleExtension(String extension) {
		return extension.equalsIgnoreCase("ifcxml");
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}
}