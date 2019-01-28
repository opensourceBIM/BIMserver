package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

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
//import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3tc1Package;
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
//		File ifcSchemaFile = Paths.get("C:\\Users\\Ruben\\Workspaces\\BIMserver\\BimServer\\deploy\\shared\\IFC2X3_TC1.exp");
//		ExpressSchemaParser schemaParser = new ExpressSchemaParser(ifcSchemaFile);
//		schemaParser.parse();
//		SchemaDefinition schema = schemaParser.getSchema();
//		try {
//			new DerivedReader(ifcSchemaFile, schema);
//			FastIfcFileReader fastIfcFileReader = new FastIfcFileReader(schema);
//			fastIfcFileReader.read(Paths.get("C:\\Users\\Ruben\\Workspaces\\BIMserver\\TestData\\data\\AC11-Institute-Var-2-IFC.ifc"));
//			IfcModel model = fastIfcFileReader.getModel();
//			LocalDevelopmentResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher();
//			Set<Ifc2x3tc1Package> packages = CollectionUtils.singleSet(Ifc2x3tc1Package.eINSTANCE);
//			FieldIgnoreMap fieldIgnoreMap = new FileFieldIgnoreMap(packages, resourceFetcher);
//			File nativeFolder = resourceFetcher.getFile("lib/");
//			FailSafeIfcEngine failSafeIfcEngine = new FailSafeIfcEngine(ifcSchemaFile, nativeFolder, resourceFetcher, true);
//			
//			for (int i=0; i<100; i++) {
//				System.out.println(i);
//				ColladaSerializer colladaSerializer = new ColladaSerializer("test", model, schema, fieldIgnoreMap, failSafeIfcEngine);
//				colladaSerializer.writeToFile(Paths.get("test" + i + ".collada"));
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