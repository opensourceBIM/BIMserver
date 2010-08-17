package org.bimserver.ifc;

import java.io.File;
import java.io.FileNotFoundException;

import nl.tue.buildingsmart.emf.DerivedReader;
import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;

import org.bimserver.ifc.file.reader.IfcFileReader;

public class SchemaLoader {
	public static final File DEFAULT_SCHEMA_FILE = new File((".." + File.separator + "BimServer" + File.separator + "deploy" + File.separator + "shared" + File.separator + "IFC2X3_FINAL.exp"));

	public static SchemaDefinition loadDefaultSchema() {
		return loadSchema(DEFAULT_SCHEMA_FILE);
	}

	public static SchemaDefinition loadSchema(File schemaFile) {
		ExpressSchemaParser schemaParser = new ExpressSchemaParser(IfcFileReader.DEFAULT_SCHEMA_FILE);
		schemaParser.parse();
		SchemaDefinition schema = schemaParser.getSchema();
		try {
			new DerivedReader(schemaFile, schema);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return schema;
	}
}
