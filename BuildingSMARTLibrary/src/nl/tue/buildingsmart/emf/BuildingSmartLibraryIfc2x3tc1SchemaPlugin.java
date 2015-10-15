package nl.tue.buildingsmart.emf;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.io.IOUtils;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.SchemaDefinition;

public class BuildingSmartLibraryIfc2x3tc1SchemaPlugin extends AbstractSchemaPlugin {

	private SchemaDefinition schemaDefinition;
	private boolean initialized = false;
	private Path schemaFile;

	@Override
	public SchemaDefinition getSchemaDefinition(PluginConfiguration pluginConfiguration) {
		return schemaDefinition;
	}

	@Override
	public String getDescription() {
		return "BuildingSmartLibrarySchemaPlugin IFC2x3TC1";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}
	
	public String getSchemaVersion() {
		return "ifc2x3tc1";
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		PluginContext pluginContext = pluginManager.getPluginContext(this);
		try {
			String schemaName = "IFC2X3_TC1.exp";
			InputStream inputStream = pluginContext.getResourceAsInputStream("schema/" + schemaName);
			try {
				byte[] data = IOUtils.toByteArray(inputStream);
				if (!Files.exists(pluginManager.getTempDir())) {
					Files.createDirectory(pluginManager.getTempDir());
				}
				schemaFile = pluginManager.getTempDir().resolve(schemaName);
				OutputStream outputStream = Files.newOutputStream(schemaFile);
				try {
					IOUtils.write(data, outputStream);
				} finally {
					outputStream.close();
				}
				schemaDefinition = loadIfcSchema(schemaName, data);
				initialized = true;
			} finally {
				inputStream.close();
			}
		} catch (Exception e) {
			throw new PluginException(e);
		}
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public Path getExpressSchemaFile() {
		return schemaFile;
	}

	@Override
	public String getDefaultName() {
		return "BuildingSmartLibrarySchemaPlugin IFC2x3TC1";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}
}