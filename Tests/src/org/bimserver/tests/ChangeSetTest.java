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
//import java.util.HashSet;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Unmarshaller;
//
//import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
//import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;
//
//import org.apache.cxf.helpers.FileUtils;
//import org.bimserver.ModelConverter;
//import org.bimserver.emf2codb.Database;
//import org.bimserver.emf2codb.DatabaseReadException;
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
//import org.bimserver.shared.ChangeSet;
//import org.bimserver.shared.ChangeSetResult;
//import org.bimserver.shared.UserException;
//import org.eclipse.emf.ecore.EPackage;
//
//public class ChangeSetTest {
//	private SchemaDefinition schema;
//	private Database database;
//	private HashSet<EPackage> packages;
//	private int uid;
//	private int pid;
//
//	public static void main(String[] args) {
//		new ChangeSetTest().start();
//	}
//
//	private void start() {
//		File dataDir = Paths.get("../BimServer/database");
//		FileUtils.removeDir(dataDir);
//		BerkeleyColumnDatabase columnDatabase = new BerkeleyColumnDatabase(dataDir);
//		packages = new HashSet<EPackage>();
//		packages.add(Ifc2x3tc1Package.eINSTANCE);
//		database = new Database(packages, columnDatabase, new FieldIgnoreMap(packages));
//		ExpressSchemaParser schemaParser = new ExpressSchemaParser(IfcFileReader.DEFAULT_SCHEMA_FILE);
//		schemaParser.parse();
//		schema = schemaParser.getSchema();
//		uid = getAdmin();
//		pid = createProject("project");
//		// pid = 2;
//		IfcModel model = readModelFromFile(TestFile.WALL_ONLY.getFile());
//		Revision checkInModel = checkInModel(ModelConverter.newIfcModel(model), pid, uid, TestFile.WALL_ONLY.getFile().getName());
//		check(1);
//
//		ChangeSetResult processChangeSet = processChangeSet(Paths.get("ChangeSetAuto.xml"));
//		check(processChangeSet.getNewRevisionNr());
//	}
//
//	private void check(int rid) {
//		File dataDir = Paths.get("../BimServer/database");
//		BerkeleyColumnDatabase columnDatabase = new BerkeleyColumnDatabase(dataDir);
//		IfcModel newModel2 = downloadModel(pid, rid);
//		writeToFile(ModelConverter.newIfcModel(newModel2), Paths.get("files" + File.separator + "test." + rid + ".ifc"));
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
//		try {
//			IfcModel newModel = session.download(pid, rid);
//			return newModel;
//		} catch (DatabaseReadException e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			session.close();
//		}
//	}
//
//	private Revision checkInModel(IfcModel model, int pid, int uid, String comment) {
//		Session session = new Session(database, "admin");
//		try {
//			Revision revision = session.checkin(model, pid, uid, comment);
//			return revision;
//		} catch (DatabaseReadException e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			session.close();
//		}
//	}
//
//	private ChangeSetResult processChangeSet(File file) {
//		Session session = new Session(database, uid);
//		try {
//			JAXBContext context = JAXBContext.newInstance(ChangeSet.class);
//			Unmarshaller unmarshaller = context.createUnmarshaller();
//			ChangeSet changeSet = (ChangeSet) unmarshaller.unmarshal(file);
//			ChangeSetResult processChangeSet = session.processChangeSet(changeSet, pid, file.getName(), uid);
//			return processChangeSet;
//		} catch (JAXBException e) {
//			e.printStackTrace();
//		} catch (DatabaseReadException e) {
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return null;
//	}
//
//	private int getAdmin() {
//		Session session = new Session(database, "admin");
//		try {
//			int id = session.getUserByName("admin").getId();
//			return id;
//		} catch (DatabaseReadException e) {
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return -1;
//	}
//
//	private int createProject(String name) {
//		Session session = new Session(database, "admin");
//		int pid = -1;
//		try {
//			pid = session.addProject(name);
//			return pid;
//		} catch (UserException e) {
//			e.printStackTrace();
//		} catch (DatabaseReadException e) {
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return -1;
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
