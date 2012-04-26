package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.HashSet;
//import java.util.Random;
//
//import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
//import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;
//
//import org.apache.cxf.helpers.FileUtils;
//import org.bimserver.ModelConverter;
//import org.bimserver.emf2codb.Database;
//import org.bimserver.emf2codb.IfcModel;
//import org.bimserver.emf2codb.FieldIgnoreMap;
//import org.bimserver.emf2codb.Session;
//import org.bimserver.emf2codb.berkeley.BerkeleyColumnDatabase;
//import org.bimserver.emf2codb.store.Revision;
//import org.bimserver.ifc.IfcModel;
//import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3tc1Package;
//import org.bimserver.ifc.file.reader.FastIfcFileReader;
//import org.bimserver.ifc.file.reader.IfcFileReader;
//import org.bimserver.ifc.file.writer.IfcFileWriter;
//import org.bimserver.shared.UserException;
//import org.eclipse.emf.ecore.EPackage;
//
//public class Ifc2CodbTest {
//	private SchemaDefinition schema;
//	private Database database;
//	private HashSet<EPackage> packages;
//	private int uid;
//
//	public static void main(String[] args) {
//		new Ifc2CodbTest().start();
//	}
//
//	private void start() {
//		File dataDir = new File("../BimServer/database");
//		FileUtils.removeDir(dataDir);
//		BerkeleyColumnDatabase columnDatabase = new BerkeleyColumnDatabase(dataDir);
//		packages = new HashSet<EPackage>();
//		packages.add(Ifc2x3tc1Package.eINSTANCE);
//		database = new Database(packages, columnDatabase, new FieldIgnoreMap(packages));
//		ExpressSchemaParser schemaParser = new ExpressSchemaParser(IfcFileReader.DEFAULT_SCHEMA_FILE);
//		schemaParser.parse();
//		schema = schemaParser.getSchema();
//		uid = getAdmin();
//
//		// int pid = createProject("project");
//		// Revision revision1 =
//		// checkInModel(readModelFromFile(TestFile.HAUS_SOURCE_FILE.getFile()),
//		// pid, uid, TestFile.HAUS_SOURCE_FILE.getFile().getName());
//		// Revision revision2 =
//		// checkInModel(readModelFromFile(TestFile.MERGE_TEST_SOURCE_FILE.getFile()),
//		// pid, uid, TestFile.MERGE_TEST_SOURCE_FILE.getFile().getName());
//		// Revision revision3 =
//		// checkInModel(readModelFromFile(TestFile.NIEDRI.getFile()), pid, uid,
//		// TestFile.NIEDRI.getFile().getName());
//		// Revision revision4 =
//		// checkInModel(readModelFromFile(TestFile.HAUS_SOURCE_FILE.getFile()),
//		// pid, uid, TestFile.HAUS_SOURCE_FILE.getFile().getName());
//		// IfcModel newModel1 = downloadModel(revision1.getProject().getId(),
//		// revision1.getId());
//		// writeToFile(newModel1, new File("files" + File.separator + "test." +
//		// TestFile.HAUS_SOURCE_FILE.getFile().getName()));
//		// IfcModel newModel2 = downloadModel(revision2.getProject().getId(),
//		// revision2.getId());
//		// writeToFile(newModel2, new File("files" + File.separator + "test." +
//		// TestFile.MERGE_TEST_SOURCE_FILE.getFile().getName()));
//		// IfcModel newModel3 = downloadModel(revision3.getProject().getId(),
//		// revision3.getId());
//		// writeToFile(newModel3, new File("files" + File.separator + "test." +
//		// TestFile.NIEDRI.getFile().getName()));
//		// IfcModel newModel4 = downloadModel(revision4.getProject().getId(),
//		// revision4.getId());
//		// writeToFile(newModel4, new File("files" + File.separator + "test." +
//		// TestFile.HAUS_SOURCE_FILE.getFile().getName()));
//
//		// pid = createProject("project");
//		// Revision revision1 =
//		// checkInModel(readModelFromFile(TestFile.EMPTY_TEST.getFile()), pid,
//		// uid, TestFile.EMPTY_TEST.getFile().getName());
//		// Revision revision2 =
//		// checkInModel(readModelFromFile(TestFile.EMPTY_TEST.getFile()), pid,
//		// uid, TestFile.EMPTY_TEST.getFile().getName());
//		// Revision revision3 =
//		// checkInModel(readModelFromFile(TestFile.EMPTY_TEST.getFile()), pid,
//		// uid, TestFile.EMPTY_TEST.getFile().getName());
//		// Revision revision4 =
//		// checkInModel(readModelFromFile(TestFile.EMPTY_TEST.getFile()), pid,
//		// uid, TestFile.EMPTY_TEST.getFile().getName());
//		// IfcModel newModel1 = downloadModel(revision1.getProject().getId(),
//		// revision1.getId());
//		// writeToFile(newModel1, new File("files" + File.separator + "test." +
//		// TestFile.NIEDRI.getFile().getName()));
//		// IfcModel newModel2 = downloadModel(revision2.getProject().getId(),
//		// revision2.getId());
//		// writeToFile(newModel2, new File("files" + File.separator + "test." +
//		// TestFile.EMPTY_TEST.getFile().getName()));
//
//		// int j=1;
//		Random random = new Random();
//		for (int j = 1; j < 5; j++) {
//			int pid = createProject("project" + j);
//			for (int i = 0; i < 3; i++) {
//				TestFile testFile = TestFile.values()[(random.nextInt(TestFile.values().length))];
//				System.out.println(testFile.getFile());
//				IfcModel model = readModelFromFile(testFile.getFile());
//				Revision revision = checkInModel(ModelConverter.newIfcModel(model), pid, uid, testFile.getFile().getName());
//				model = null;
//				System.gc();
//				IfcModel newModel = downloadModel(revision.getProject().getId(), revision.getId());
//				writeToFile(ModelConverter.newIfcModel(newModel), new File("files" + File.separator + "test." + testFile.getFile().getName()));
//			}
//		}
//		// writeToFile(newModel);
//		// System.out.println(new Session(database,
//		// "admin").getDatabaseInformation());
//		database.close();
//
//		// check(revision1);
//		// check(revision2);
//		// check(revision3);
//		// check(revision4);
//	}
//
//	private void check(Revision revision) {
//		File dataDir = new File("../BimServer/database");
//		BerkeleyColumnDatabase columnDatabase = new BerkeleyColumnDatabase(dataDir);
//		database = new Database(packages, columnDatabase, new FieldIgnoreMap(packages));
//		IfcModel newModel2 = downloadModel(revision.getProject().getId(), revision.getId());
//		writeToFile(ModelConverter.newIfcModel(newModel2), new File("files" + File.separator + "test." + revision.getId() + "."
//				+ TestFile.EMPTY_TEST.getFile().getName()));
//		database.close();
//	}
//
//	private int getAdmin() {
//		Session session = new Session(database, "admin");
//		int id = session.getUserByName("admin").getId();
//		session.close();
//		return id;
//	}
//
//	private int createProject(String name) {
//		Session session = new Session(database, "admin");
//		int pid = -1;
//		try {
//			pid = session.addProject(name);
//		} catch (UserException e) {
//			e.printStackTrace();
//		}
//		session.close();
//		return pid;
//	}
//
//	private void writeToFile(IfcModel newModel, File file) {
//		IfcFileWriter fileWriter = new IfcFileWriter(newModel, schema);
//		try {
//			fileWriter.write(file);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private IfcModel downloadModel(int pid, int rid) {
//		Session session = new Session(database, "admin");
//		IfcModel newModel = session.download(pid, rid);
//		session.close();
//		return newModel;
//	}
//
//	private Revision checkInModel(IfcModel model, int pid, int uid, String comment) {
//		Session session = new Session(database, "admin");
//		Revision revision = session.checkin(model, pid, uid, comment);
//		session.close();
//		return revision;
//	}
//
//	private IfcModel readModelFromFile(File file) {
//		FastIfcFileReader fastIfcFileReader = new FastIfcFileReader(schema);
//		try {
//			fastIfcFileReader.read(file);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		IfcModel model = fastIfcFileReader.getModel();
//		return model;
//	}
//}