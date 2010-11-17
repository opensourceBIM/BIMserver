package org.bimserver.tests;

import java.io.File;
import java.io.FileNotFoundException;

import nl.tue.buildingsmart.emf.DerivedReader;
import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;

import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.file.reader.IfcStepDeserializer;
import org.bimserver.ifc.file.reader.IfcFileReader;
import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
import org.bimserver.ifc.xml.writer.IfcXmlSerializer;

public class IfcXmlWriteTester {
	public static void main(String[] args) {
		new IfcXmlWriteTester().start();
	}

	private void start() {
		ExpressSchemaParser schemaParser = new ExpressSchemaParser(IfcFileReader.DEFAULT_SCHEMA_FILE);
		schemaParser.parse();
		SchemaDefinition schema = schemaParser.getSchema();
		try {
			new DerivedReader(IfcFileReader.DEFAULT_SCHEMA_FILE, schema);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		IfcStepDeserializer reader = new IfcStepDeserializer(schema);
		try {
			reader.read(TestFile.HAUS_SOURCE_FILE.getFile());
			// reader.read(TestFile.AC11.getFile());
		} catch (IncorrectIfcFileException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		IfcModel model = reader.getModel();
		IfcXmlSerializer ifcXmlWriter = new IfcXmlSerializer("", model, schema);
		ifcXmlWriter.write(new File("test.xml"));
	}
}