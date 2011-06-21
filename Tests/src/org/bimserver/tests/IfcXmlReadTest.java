package org.bimserver.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import nl.tue.buildingsmart.emf.SchemaLoader;

import org.bimserver.ifc.step.deserializer.IfcStepDeserializer;
import org.bimserver.ifc.step.serializer.IfcStepSerializer;
import org.bimserver.ifc.xml.deserializer.IfcXmlDeserializer;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.SerializerException;

import com.sun.xml.internal.ws.encoding.soap.DeserializationException;

public class IfcXmlReadTest {
	public static void main(String[] args) {
		new IfcXmlReadTest().start();
	}

	private void start() {
		IfcXmlDeserializer ifcXmlReader = new IfcXmlDeserializer();
		try {
			File file = TestFile.AC11_XML.getFile();
			IfcModelInterface model = ifcXmlReader.read(new FileInputStream(file), false, file.length());
			
			SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
			
			File outFile = new File("out.ifc");
			IfcStepSerializer ifcStepSerializer = new IfcStepSerializer();
			ifcStepSerializer.init(model, null, null);
			try {
				ifcStepSerializer.writeToFile(outFile);
			} catch (SerializerException e) {
				e.printStackTrace();
			}
			
			IfcStepDeserializer deserializer = new IfcStepDeserializer();
			deserializer.init(schema);
			deserializer.read(outFile);
		} catch (DeserializationException e2) {
			e2.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}