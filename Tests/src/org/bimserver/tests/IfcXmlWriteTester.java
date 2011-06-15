package org.bimserver.tests;

import java.io.File;
import java.io.FileNotFoundException;

import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SchemaLoader;
import org.bimserver.ifc.step.deserializer.IfcStepDeserializer;
import org.bimserver.ifc.xml.serializer.IfcXmlSerializer;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.SerializerException;

import com.sun.xml.internal.ws.encoding.soap.DeserializationException;

public class IfcXmlWriteTester {
	public static void main(String[] args) {
		try {
			new IfcXmlWriteTester().start();
		} catch (SerializerException e) {
			e.printStackTrace();
		}
	}

	private void start() throws SerializerException {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		
		IfcStepDeserializer reader = new IfcStepDeserializer();
		reader.init(schema);
		try {
			reader.read(TestFile.HAUS_SOURCE_FILE.getFile());
			// reader.read(TestFile.AC11.getFile());
		} catch (DeserializationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		IfcModel model = reader.getModel();
		IfcXmlSerializer ifcXmlWriter = new IfcXmlSerializer();
		try {
			ifcXmlWriter.init(model, null, null);
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