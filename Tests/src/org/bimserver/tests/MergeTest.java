package org.bimserver.tests;

import java.io.File;

import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.ifc.SchemaLoader;
import org.bimserver.ifc.step.deserializer.IfcStepDeserializer;
import org.bimserver.ifc.step.serializer.IfcStepSerializer;
import org.bimserver.merging.IncrementingOidProvider;
import org.bimserver.merging.Merger;
import org.bimserver.merging.Merger.GuidMergeIdentifier;
import org.bimserver.plugins.schema.SchemaDefinition;

import com.sun.xml.internal.ws.encoding.soap.DeserializationException;

public class MergeTest {
	public static void main(String[] args) {
		new MergeTest().start();
	}

	private void start() {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		IfcStepDeserializer deserializer = new IfcStepDeserializer();
		deserializer.init(schema);
		try {
//			File baseFolder = new File("C:\\Users\\Ruben de Laat\\Documents\\My Dropbox\\Logic Labs\\Projecten\\BIMserver\\IFCFiles");
//			IfcModel model1 = deserializer.read(new File(baseFolder, "Constructiedeel.ifc"));
//			IfcModel model2 = deserializer.read(new File(baseFolder, "Installatiedeel.ifc"));
			
			IfcModel model1 = deserializer.read(TestFile.EXPORT1.getFile());
			IfcModel model2 = deserializer.read(TestFile.EXPORT1.getFile());
//			IfcModel model3 = deserializer.read(TestFile.EXPORT3.getFile());
			
			model1.setObjectOids();
			model2.setObjectOids();
			model1.indexGuids();
			model2.indexGuids();
			model2.fixOids(new IncrementingOidProvider(model1.getHighestOid() + 1));
			IfcModelSet ifcModelSet = new IfcModelSet(model1, model2);
			IfcModel merged = new Merger(new GuidMergeIdentifier()).merge(null, ifcModelSet, true);
			merged.checkDoubleOidsPlusReferences();
			IfcStepSerializer serializer = new IfcStepSerializer();
			serializer.init(merged, schema, null, null, null, null);
			serializer.writeToFile(new File("merged.ifc"));
		} catch (DeserializationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}