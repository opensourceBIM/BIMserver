package nl.tue.buildingsmart.emf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;

import org.apache.commons.io.IOUtils;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuildingSmartLibrarySchemaPlugin implements SchemaPlugin {

	private static final Logger LOGGER = LoggerFactory.getLogger(BuildingSmartLibrarySchemaPlugin.class);
	private SchemaDefinition schemaDefinition;
	private boolean initialized = false;
	private File schemaFile;
	
	@Override
	public SchemaDefinition getSchemaDefinition() {
		return schemaDefinition;
	}

	@Override
	public String getDescription() {
		return "BuildingSmartLibrarySchemaPlugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) {
		PluginContext pluginContext = pluginManager.getPluginContext(this);
		InputStream inputStream = pluginContext.getResourceAsInputStream("schema/IFC2X3_FINAL.exp");
		File tmpFolder = new File(pluginManager.getHomeDir(), "tmp");
		if (!tmpFolder.exists()) {
			tmpFolder.mkdir();
		}
		schemaFile = new File(tmpFolder, "IFC2X3_FINAL.exp");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(schemaFile);
			IOUtils.copy(inputStream, fileOutputStream);
			fileOutputStream.close();
			schemaDefinition = loadIfcSchema(schemaFile);
			initialized = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private SchemaDefinition loadIfcSchema(File schemaFile) {
		try {
			ExpressSchemaParser schemaParser = new ExpressSchemaParser(schemaFile);
			schemaParser.parse();
			SchemaDefinition schema = schemaParser.getSchema();
			new DerivedReader(schemaFile, schema);
			if (schema != null) {
				LOGGER.info("IFC-Schema successfully loaded from " + schemaFile.getAbsolutePath());
			} else {
				LOGGER.error("Error loading IFC-Schema");
			}
			return schema;
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public File getExpressSchemaFile() {
		return schemaFile;
	}
}