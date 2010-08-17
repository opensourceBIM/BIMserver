//package org.bimserver.tests;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Set;
//
//import nl.tue.buildingsmart.emf.DerivedReader;
//import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
//import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;
//
//import org.bimserver.collada.ColladaSerializer;
//import org.bimserver.ifc.FieldIgnoreMap;
//import org.bimserver.ifc.FileFieldIgnoreMap;
//import org.bimserver.ifc.IfcModel;
//import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
//import org.bimserver.ifc.file.reader.FastIfcFileReader;
//import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
//import org.bimserver.ifcengine.FailSafeIfcEngine;
//import org.bimserver.shared.LocalDevelopmentResourceFetcher;
//import org.bimserver.utils.CollectionUtils;
//
//public class ColladaTester {
//	public static void main(String[] args) {
//		new ColladaTester().start();
//	}
//
//	private void start() {
//		File ifcSchemaFile = new File("C:\\Users\\Ruben\\Workspaces\\BIMserver\\BimServer\\deploy\\shared\\IFC2X3_FINAL.exp");
//		ExpressSchemaParser schemaParser = new ExpressSchemaParser(ifcSchemaFile);
//		schemaParser.parse();
//		SchemaDefinition schema = schemaParser.getSchema();
//		try {
//			new DerivedReader(ifcSchemaFile, schema);
//			FastIfcFileReader fastIfcFileReader = new FastIfcFileReader(schema);
//			fastIfcFileReader.read(new File("C:\\Users\\Ruben\\Workspaces\\BIMserver\\TestData\\data\\AC11-Institute-Var-2-IFC.ifc"));
//			IfcModel model = fastIfcFileReader.getModel();
//			LocalDevelopmentResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher();
//			Set<Ifc2x3Package> packages = CollectionUtils.singleSet(Ifc2x3Package.eINSTANCE);
//			FieldIgnoreMap fieldIgnoreMap = new FileFieldIgnoreMap(packages, resourceFetcher);
//			File nativeFolder = resourceFetcher.getFile("lib/");
//			FailSafeIfcEngine failSafeIfcEngine = new FailSafeIfcEngine(ifcSchemaFile, nativeFolder, resourceFetcher, true);
//			
//			for (int i=0; i<100; i++) {
//				System.out.println(i);
//				ColladaSerializer colladaSerializer = new ColladaSerializer("test", model, schema, fieldIgnoreMap, failSafeIfcEngine);
//				colladaSerializer.writeToFile(new File("test" + i + ".collada"));
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IncorrectIfcFileException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}