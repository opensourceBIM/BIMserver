package org.bimserver.tests;

import java.io.File;

import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SchemaLoader;
import org.bimserver.ifc.file.reader.IfcStepDeserializer;
import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
import org.bimserver.ifc.file.writer.IfcStepSerializer;
import org.bimserver.merging.IncrementingOidProvider;
import org.bimserver.merging.RevisionMerger;
import org.bimserver.plugins.schema.SchemaDefinition;

public class RevisionMergeTest {
	public static void main(String[] args) {
		new RevisionMergeTest().start();
	}

	private void start() {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		IfcStepDeserializer deserializer = new IfcStepDeserializer(schema);
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
			serializer.init(merged, schema, null, null, null);
			serializer.writeToFile(new File("merged.ifc"));
		} catch (IncorrectIfcFileException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}