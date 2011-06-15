package nl.tue.buildingsmart.emf;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;

import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuildingSmartLibrarySchemaPlugin implements SchemaPlugin {

	private static final Logger LOGGER = LoggerFactory.getLogger(BuildingSmartLibrarySchemaPlugin.class);
	private SchemaDefinition schemaDefinition;
	
	@Override
	public SchemaDefinition getSchemaDefinition() {
		return schemaDefinition;
	}

	@Override
	public String getDescription() {
		return "BuildingSmartLibrarySchemaPlugin";
	}

	@Override
	public String getName() {
		return getClass().getName();
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) {
		schemaDefinition = loadIfcSchema(pluginManager.getResourceFetcher());
	}

	private SchemaDefinition loadIfcSchema(ResourceFetcher resourceFetcher) {
		try {
			URL ifcSchemaFile = resourceFetcher.getResource("IFC2X3_FINAL.exp");
			if (ifcSchemaFile == null) {
				LOGGER.error("IFC-Schema file not found");
			} else {
				LOGGER.info("IFC-Schema file found");
				ExpressSchemaParser schemaParser = new ExpressSchemaParser(ifcSchemaFile);
				schemaParser.parse();
				SchemaDefinition schema = schemaParser.getSchema();
				new DerivedReader(ifcSchemaFile.openStream(), schema);
				if (schema != null) {
					LOGGER.info("IFC-Schema successfully loaded");
				} else {
					LOGGER.error("Error loading IFC-Schema");
				}
				return schema;
			}
		} catch (MalformedURLException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return null;
	}
}