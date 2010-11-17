package org.bimserver.tests;

import java.io.FileNotFoundException;

import nl.tue.buildingsmart.emf.DerivedReader;
import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;

import org.bimserver.ifc.FileFieldIgnoreMap;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
import org.bimserver.ifc.file.reader.IfcStepDeserializer;
import org.bimserver.ifc.file.reader.IfcFileReader;
import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.ResourceFetcher;
import org.bimserver.utils.CollectionUtils;

public class O3dTest {
	public static void main(String[] args) {
		new O3dTest().start();
	}

	private void start() {
		ExpressSchemaParser schemaParser = new ExpressSchemaParser(IfcFileReader.DEFAULT_SCHEMA_FILE);
		schemaParser.parse();
		SchemaDefinition schema = schemaParser.getSchema();
		try {
			new DerivedReader(IfcFileReader.DEFAULT_SCHEMA_FILE, schema);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		ResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher();
		new FileFieldIgnoreMap(CollectionUtils.singleSet(Ifc2x3Package.eINSTANCE), resourceFetcher);
		
		TestFile testFile = TestFile.MERGE_TEST_SOURCE_FILE;
		IfcStepDeserializer fastIfcFileReader = new IfcStepDeserializer(schema);
		try {
			fastIfcFileReader.read(testFile.getFile());
		} catch (IncorrectIfcFileException e) {
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