package org.bimserver.tests;

import java.io.File;

import nl.tue.buildingsmart.emf.SchemaLoader;

import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.step.deserializer.IfcStepDeserializer;
import org.bimserver.ifc.step.serializer.IfcStepSerializer;
import org.bimserver.merging.IncrementingOidProvider;
import org.bimserver.merging.RevisionMerger;
import org.bimserver.plugins.schema.SchemaDefinition;

import com.sun.xml.internal.ws.encoding.soap.DeserializationException;

public class RevisionMergeTest {
	public static void main(String[] args) {
		new RevisionMergeTest().start();
	}

	private void start() {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		IfcStepDeserializer deserializer = new IfcStepDeserializer();
		deserializer.init(schema);
		try {
			IfcModel model1 = deserializer.read(TestFile.EXPORT1.getFile());
			IfcModel model2 = deserializer.read(TestFile.EXPORT3.getFile());
			model1.setObjectOids();
			model2.setObjectOids();
			model1.indexGuids();
			model2.indexGuids();
			model2.fixOids(new IncrementingOidProvider(model1.getHighestOid() + 1));
			IfcModel merged = new RevisionMerger(model1, model2).merge();
			IfcStepSerializer serializer = new IfcStepSerializer();
			serializer.init(merged, null, null);
			serializer.writeToFile(new File("merged.ifc"));
		} catch (DeserializationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}