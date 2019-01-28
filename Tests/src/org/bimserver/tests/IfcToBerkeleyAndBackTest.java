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
//import java.util.Map;
//
//import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
//import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;
//
//import org.bimserver.emf2codb.berkeley.BerkeleyColumnDatabase;
//import org.bimserver.ifc.file.compare.IfcFileCompare;
//import org.bimserver.ifc.file.reader.IfcFileReader;
//import org.bimserver.ifc.file.writer.IfcFileWriter;
//import org.eclipse.emf.ecore.EObject;
//
//import com.sleepycat.je.DatabaseException;
//import com.sleepycat.je.Transaction;
//
//public class IfcToBerkeleyAndBackTest {
//	private BerkeleyColumnDatabase database;
//
//	public static void main(String[] args) {
//		new IfcToBerkeleyAndBackTest().start();
//	}
//
//	private void start() {
//		ExpressSchemaParser schemaParser = new ExpressSchemaParser(IfcFileReader.DEFAULT_SCHEMA_FILE);
//		schemaParser.parse();
//		SchemaDefinition schemaDefinition = schemaParser.getSchema();
//
//		try {
//			File src = TestFileConstants.HITOS_SOURCE_FILE;
//			File dest = Paths.get("test.txt");
//
//			Map<Long, EObject> map = new IfcFileReader().read(schemaDefinition, src);
//			database = new BerkeleyColumnDatabase(Paths.get("bdb"));
//			Transaction writeTransaction = null;//database.startTransaction();
//			try {
//				BerkeleyIfcWriter berkeleyIfcWriter = new BerkeleyIfcWriter(database);
//				long projectId = berkeleyIfcWriter.store(map, writeTransaction);
//				map = null;
//				database.sync();
////				writeTransaction.commit();
//				berkeleyIfcWriter = null;
//				Transaction readTransaction = null;//database.startTransaction();
//				BerkeleyIfcReader berkeleyIfcReader = new BerkeleyIfcReader(database);
//				Map<Long, EObject> restored = berkeleyIfcReader.restore(projectId, readTransaction);
//				IfcIdModel ifcModel = new IfcIdModel(restored);
//				berkeleyIfcReader = null;
//				database.close();
////				IfcPrinter ifcPrinter = new IfcPrinter();
////				ifcPrinter.printMap(restored);
//				IfcFileWriter writer = new IfcFileWriter(ifcModel, schemaDefinition);
//				writer.write(dest);
//				writer = null;
//				
//				IfcFileCompare compare = new IfcFileCompare();
//				try {
//					compare.compare(src, dest);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			} catch (DatabaseException e) {
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//}