package org.bimserver.tests;

import java.io.File;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.ifc.SchemaLoader;
import org.bimserver.ifc.file.reader.IfcStepDeserializer;
import org.bimserver.ifc.file.reader.IncorrectIfcFileException;

public class TestErrorFile {
	public static void main(String[] args) {
		new TestErrorFile().start();
	}

	private void start() {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		IfcStepDeserializer fastIfcFileReader = new IfcStepDeserializer(schema);
		try {
			fastIfcFileReader.read(new File("../TestData/data/errorfile.ifc"));
		} catch (IncorrectIfcFileException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}
}
