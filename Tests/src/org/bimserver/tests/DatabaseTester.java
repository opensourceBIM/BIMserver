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
//import java.util.HashSet;
//
//import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
//import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;
//
//import org.apache.cxf.helpers.FileUtils;
//import org.bimserver.ModelConverter;
//import org.bimserver.emf2codb.ColumnDatabase;
//import org.bimserver.emf2codb.Database;
//import org.bimserver.emf2codb.DatabaseException;
//import org.bimserver.emf2codb.FieldIgnoreMap;
//import org.bimserver.emf2codb.Session;
//import org.bimserver.emf2codb.berkeley.BerkeleyColumnDatabase;
//import org.bimserver.emf2codb.store.Project;
//import org.bimserver.emf2codb.store.Revision;
//import org.bimserver.emf2codb.store.User;
//import org.bimserver.ifc.IfcModel;
//import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3tc1Package;
//import org.bimserver.ifc.file.reader.FastIfcFileReader;
//import org.bimserver.ifc.file.reader.IfcFileReader;
//import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
//import org.bimserver.shared.UserException;
//import org.bimserver.utils.CollectionUtils;
//import org.eclipse.emf.ecore.EPackage;
//
//public class DatabaseTester {
//	private SchemaDefinition schema;
//
//	public static void main(String[] args) {
//		new DatabaseTester().start();
//	}
//
//	private void start() {
//		ExpressSchemaParser schemaParser = new ExpressSchemaParser(IfcFileReader.DEFAULT_SCHEMA_FILE);
//		schemaParser.parse();
//		schema = schemaParser.getSchema();
//
//		File dataDir = Paths.get("../BimServer/database");
//		FileUtils.removeDir(dataDir);
//		ColumnDatabase cdb = new BerkeleyColumnDatabase(dataDir);
//		HashSet<EPackage> packages = CollectionUtils.singleSet((EPackage) Ifc2x3tc1Package.eINSTANCE);
//		try {
//			Database database = new Database(packages, cdb, new FieldIgnoreMap(packages));
//			createAndCheckinProject(1, database, TestFile.EMPTY_TEST.getFile());
//			createAndCheckinProject(2, database, TestFile.EMPTY_TEST.getFile());
//			createAndCheckinProject(3, database, TestFile.EMPTY_TEST.getFile());
//			test(database);
//		} catch (DatabaseException e) {
//			e.printStackTrace();
//		}
//		// writeBack(database, rid);
//		// ChangeSetResult performChange1 = performChange1(database);
//		// performChange2(database, performChange1.getAddedOids().get(0),
//		// performChange1.getAddedOids().get(3));
//		cdb.close();
//	}
//
//	private void test(Database database) {
//		try {
//			Session session = database.createSession("admin");
//			try {
//				System.out.println(session.getProjectById(2).getName());
//				System.out.println(session.getProjectById(2).getLastRevision().getUser());
//			} finally {
//				session.close();
//			}
//		} catch (DatabaseException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private Revision createAndCheckinProject(int i, Database database, File file) {
//		try {
//			Session session = database.createSession("admin");
//			try {
//				session.addProject("project " + file.getName() + i);
//			} catch (UserException e1) {
//				e1.printStackTrace();
//			} catch (DatabaseException e) {
//				e.printStackTrace();
//			}
//			
//			User user = null;
//			try {
//				user = session.getUserByName("admin");
//			} catch (DatabaseException e1) {
//				e1.printStackTrace();
//			}
//			Project project = null;
//			try {
//				project = session.getProject("project " + file.getName() + i);
//			} catch (DatabaseException e1) {
//				e1.printStackTrace();
//			}
//			FastIfcFileReader reader = new FastIfcFileReader(schema);
//			try {
//				reader.read(file);
//			} catch (IncorrectIfcFileException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			IfcModel ifcModel = reader.getModel();
//			try {
//				Revision checkin = session.checkin(ModelConverter.newIfcModel(ifcModel), project.getId(), user.getId(), "test");
//				System.out.println("size: " + session.getModelSize(project.getId(), checkin.getId()));
//				return checkin;
//			} catch (DatabaseException e) {
//				e.printStackTrace();
//			} finally {
//				session.close();
//			}
//			return null;
//			// writeBack(database, checkin.getId());
//		} catch (DatabaseException e2) {
//			e2.printStackTrace();
//		}
//		return null;
//	}
//
//	// private ChangeSetResult performChange1(Database database) {
//	// Session session = database.createSession("admin");
//	// User user = session.getUserByName("admin");
//	// Project project = session.getProject("blaat1");
//	// ChangeSet changeSet1 = new ChangeSet();
//	// IfcWall ifcWall1 = Ifc2x3tc1Factory.eINSTANCE.createIfcWall();
//	// IfcLabel label1 = Ifc2x3tc1Factory.eINSTANCE.createIfcLabel();
//	// label1.setWrappedValue("New Wall 1");
//	// ifcWall1.setName(label1);
//	// IfcWall ifcWall2 = Ifc2x3tc1Factory.eINSTANCE.createIfcWall();
//	// IfcLabel label2 = Ifc2x3tc1Factory.eINSTANCE.createIfcLabel();
//	// label2.setWrappedValue("New Wall 2");
//	// ifcWall2.setName(label2);
//	// Addition addition1 = changeSet1.addAddition(new
//	// Addition("IfcLabel").addAttribute(new AttributeValuePair("wrappedValue",
//	// "New Wall 1")));
//	// changeSet1.addAddition(new Addition("IfcWall").addAttribute(new
//	// AttributeInternalReferencePair("Name", addition1)));
//	// Addition addition2 = changeSet1.addAddition(new
//	// Addition("IfcLabel").addAttribute(new AttributeValuePair("wrappedValue",
//	// "New Wall 2")));
//	// changeSet1.addAddition(new Addition("IfcWall").addAttribute(new
//	// AttributeInternalReferencePair("Name", addition2)));
//	//
//	// ChangeSetResult revisionAfterChange1 =
//	// session.processChangeSet(changeSet1, project.getId(), "changeset1",
//	// user.getId());
//	// session.close();
//	// writeBack(database, revisionAfterChange1.getNewRevisionNr());
//	// return revisionAfterChange1;
//	// }
//
//	// private int performChange2(Database database, long id1, long id2) {
//	// Session session = database.createSession("admin");
//	// User user = session.getUserByName("admin");
//	// Project project = session.getProject("blaat1");
//	//
//	// ChangeSet changeSet2 = new ChangeSet();
//	// Modification modification = new Modification("IfcLabel", id1);
//	// modification.addAttribute(new AttributeValuePair("wrappedValue",
//	// "New Wall 1 - Revised"));
//	// changeSet2.addModification(modification);
//	// changeSet2.addRemoval(new Removal("IfcWall", id2));
//	//
//	// project = session.getProject("blaat1");
//	// ChangeSetResult revisionAfterChange2 =
//	// session.processChangeSet(changeSet2, project.getId(), "changeset2",
//	// user.getId());
//	// session.close();
//	// writeBack(database, revisionAfterChange2.getNewRevisionNr());
//	// return revisionAfterChange2.getNewRevisionNr();
//	// }
//
////	private void writeBack(Database database, int revisionNr) {
////		Session session = database.createSession("admin");
////
////		User user = session.getUserByName("admin");
////		Project project = session.getProject("blaat1");
////
////		Revision revision = session.getRevision(project.getId(), revisionNr);
////		IfcModel checkout = session.download(project.getId(), revision.getId());
////
////		IfcFileWriter writer = new IfcFileWriter(ModelConverter.newIfcModel(checkout), schema);
////		try {
////			writer.write(Paths.get("tmp" + revisionNr + ".ifc"));
////		} catch (FileNotFoundException e) {
////			e.printStackTrace();
////		}
////		session.close();
////	}
//}