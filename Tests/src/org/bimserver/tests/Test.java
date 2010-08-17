//package org.bimserver.tests;
//
//import java.io.FileNotFoundException;
//
//import nl.tue.buildingsmart.emf.DerivedReader;
//import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
//import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;
//
//import org.bimserver.ifc.file.reader.FastIfcFileReader;
//import org.bimserver.ifc.file.reader.IfcFileReader;
//import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
//import org.bimserver.ifc.file.writer.IfcStepSerializer;
//
//public class Test {
//	private static SchemaDefinition schema;
//
//	public static void main(String[] args) {
//		ExpressSchemaParser schemaParser = new ExpressSchemaParser(IfcFileReader.DEFAULT_SCHEMA_FILE);
//		schemaParser.parse();
//		schema = schemaParser.getSchema();
//		try {
//			new DerivedReader(IfcFileReader.DEFAULT_SCHEMA_FILE, schema);
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		FastIfcFileReader fastIfcFileReader = new FastIfcFileReader(schema);
//		try {
//			fastIfcFileReader.read(TestFile.PAOLO.getFile());
//		} catch (IncorrectIfcFileException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		IfcStepSerializer serializer = new IfcStepSerializer(project, user, "", fastIfcFileReader.getModel(), schema);
//		serializer.write(System.out);
//	}
//}