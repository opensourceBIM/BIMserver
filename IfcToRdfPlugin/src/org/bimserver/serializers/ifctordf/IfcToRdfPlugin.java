package org.bimserver.serializers.ifctordf;

import java.io.File;
import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class IfcToRdfPlugin implements SerializerPlugin {

	private boolean initialized;
	private File schemaFile;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		SchemaPlugin schemaPlugin = pluginManager.getFirstSchemaPlugin("ifc2x3tc1", true);
		schemaFile = schemaPlugin.getExpressSchemaFile();
		if (schemaFile == null) {
			throw new RenderEngineException("No schema file");
		}
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "Ifc to RDF";
	}

	@Override
	public String getDefaultName() {
		return "Ifc to RDF";
	}

	@Override
	public String getVersion() {
		return "Ifc to RDF";
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
	public Serializer createSerializer(PluginConfiguration plugin) {
		return new IfcToRdfSerializer(schemaFile);
	}

	@Override
	public boolean needsGeometry() {
		return false;
	}

	@Override
	public Set<Schema> getSupportedSchemas() {
		return Schema.IFC2X3TC1.toSet();
	}
}