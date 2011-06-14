package org.bimserver.tests;

import org.bimserver.ifc.FileFieldIgnoreMap;
import org.bimserver.ifc.SchemaLoader;
import org.bimserver.ifc.step.deserializer.IfcStepDeserializer;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.ResourceFetcher;
import org.bimserver.utils.CollectionUtils;

import com.sun.xml.internal.ws.encoding.soap.DeserializationException;

public class O3dTest {
	public static void main(String[] args) {
		new O3dTest().start();
	}

	private void start() {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();

		ResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher();
		new FileFieldIgnoreMap(CollectionUtils.singleSet(Ifc2x3Package.eINSTANCE), resourceFetcher);
		
		TestFile testFile = TestFile.MERGE_TEST_SOURCE_FILE;
		IfcStepDeserializer fastIfcFileReader = new IfcStepDeserializer();
		fastIfcFileReader.init(schema);
		try {
			fastIfcFileReader.read(testFile.getFile());
		} catch (DeserializationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		O3dJsonSerializer o3dJsonSerializer = new O3dJsonSerializer(fastIfcFileReader.getModel(), fieldIgnoreMap, IfcFileReader.DEFAULT_SCHEMA_FILE, schema);
//		try {
//			System.out.print(new String(o3dJsonSerializer.writeJSON(null, null)));
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
	}
}