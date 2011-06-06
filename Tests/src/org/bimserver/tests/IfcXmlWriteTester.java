package org.bimserver.tests;

import java.io.File;
import java.io.FileNotFoundException;

import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SchemaLoader;
import org.bimserver.ifc.file.reader.IfcStepDeserializer;
import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
import org.bimserver.ifc.xml.writer.IfcXmlSerializer;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.SerializerException;

public class IfcXmlWriteTester {
	public static void main(String[] args) {
		new IfcXmlWriteTester().start();
	}

	private void start() {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		
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
		IfcXmlSerializer ifcXmlWriter = new IfcXmlSerializer();
		try {
			ifcXmlWriter.init(model, schema, null, null, null);
		} catch (SerializerException e1) {
			e1.printStackTrace();
		}
		try {
			ifcXmlWriter.write(new File("test.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}