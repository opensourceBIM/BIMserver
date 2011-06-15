package nl.tue.buildingsmart.emf;

import java.io.File;
import java.io.FileNotFoundException;

import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;

import org.bimserver.plugins.schema.SchemaDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchemaLoader {
	private static final Logger LOGGER = LoggerFactory.getLogger(SchemaLoader.class);
	public static final File DEFAULT_SCHEMA_FILE = new File((".." + File.separator + "BimServer" + File.separator + "build" + File.separator + "targets" + File.separator + "shared" + File.separator + "IFC2X3_FINAL.exp"));

	private SchemaLoader() {
	}
	
	public static SchemaDefinition loadDefaultSchema() {
		return loadSchema(DEFAULT_SCHEMA_FILE);
	}

	public static SchemaDefinition loadSchema(File schemaFile) {
		ExpressSchemaParser schemaParser = new ExpressSchemaParser(DEFAULT_SCHEMA_FILE);
		schemaParser.parse();
		SchemaDefinition schema = schemaParser.getSchema();
		try {
			new DerivedReader(schemaFile, schema);
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		}
		return schema;
	}
}
