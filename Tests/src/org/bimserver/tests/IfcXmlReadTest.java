package org.bimserver.tests;

import java.io.File;
import java.io.FileNotFoundException;

import nl.tue.buildingsmart.emf.DerivedReader;
import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;

import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SerializerException;
import org.bimserver.ifc.file.reader.IfcFileReader;
import org.bimserver.ifc.file.writer.IfcStepSerializer;
import org.bimserver.ifc.xml.reader.IfcXmlDeserializeException;
import org.bimserver.ifc.xml.reader.IfcXmlDeserializer;

import com.google.common.collect.BiMap;

public class IfcXmlReadTest {
	public static void main(String[] args) {
		new IfcXmlReadTest().start();
	}

	private void start() {
		IfcXmlDeserializer ifcXmlReader = new IfcXmlDeserializer();
		BiMap<Long, IdEObject> read;
		try {
			read = ifcXmlReader.read(TestFile.AC11_XML.getFile());
			IfcModel ifcModel = new IfcModel(read);
			
			ExpressSchemaParser schemaParser = new ExpressSchemaParser(IfcFileReader.DEFAULT_SCHEMA_FILE);
			schemaParser.parse();
			SchemaDefinition schema = schemaParser.getSchema();
			try {
				new DerivedReader(IfcFileReader.DEFAULT_SCHEMA_FILE, schema);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
			IfcStepSerializer ifcStepSerializer = new IfcStepSerializer(null, null, "", ifcModel, schema);
			try {
				ifcStepSerializer.writeToFile(new File("out.ifc"));
			} catch (SerializerException e) {
				e.printStackTrace();
			}
		} catch (IfcXmlDeserializeException e2) {
			e2.printStackTrace();
		}
	}
}
