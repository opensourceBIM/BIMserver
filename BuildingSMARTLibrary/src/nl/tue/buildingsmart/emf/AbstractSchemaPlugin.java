package nl.tue.buildingsmart.emf;

import java.io.ByteArrayInputStream;

import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;

public abstract class AbstractSchemaPlugin implements SchemaPlugin {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractSchemaPlugin.class);

	protected SchemaDefinition loadIfcSchema(String name, byte[] schemaBytes) {
		SchemaDefinition schema = null;
		
		ExpressSchemaParser schemaParser = new ExpressSchemaParser(new ByteArrayInputStream(schemaBytes));
		schemaParser.parse();
		schema = schemaParser.getSchema();
		
		new DerivedReader(new ByteArrayInputStream(schemaBytes), schema);
		if (schema != null) {
			LOGGER.info("IFC-Schema successfully loaded from " + name);
		} else {
			LOGGER.error("Error loading IFC-Schema");
		}
		return schema;
	}
}