package org.bimserver.tests;

import java.io.File;

import nl.tue.buildingsmart.emf.SchemaLoader;

import org.bimserver.ifc.step.deserializer.IfcStepDeserializer;
import org.bimserver.plugins.schema.SchemaDefinition;

import com.sun.xml.internal.ws.encoding.soap.DeserializationException;

public class TestErrorFile {
	public static void main(String[] args) {
		new TestErrorFile().start();
	}

	private void start() {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		IfcStepDeserializer fastIfcFileReader = new IfcStepDeserializer();
		fastIfcFileReader.init(schema);
		try {
			fastIfcFileReader.read(new File("../TestData/data/errorfile.ifc"));
		} catch (DeserializationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}
}
