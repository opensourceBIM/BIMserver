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
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.HashSet;
//
//import javax.activation.DataHandler;
//import javax.activation.FileDataSource;
//
//import nl.tue.buildingsmart.emf.DerivedReader;
//import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
//import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;
//
//import org.bimserver.EmfSerializerFactory;
//import org.bimserver.Service;
//import org.bimserver.EmfSerializerFactory.EmfSerializerCreator;
//import org.bimserver.database.Database;
//import org.bimserver.database.berkeley.BerkeleyColumnDatabase;
//import org.bimserver.database.berkeley.DatabaseInitException;
//import org.bimserver.emf.IfcModel;
//import org.bimserver.emf.EmfSerializer;
//import org.bimserver.ifc.FileFieldIgnoreMap;
//import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3tc1Package;
//import org.bimserver.ifc.file.writer.IfcStepSerializer;
//import org.bimserver.services.TokenManager;
//import org.bimserver.shared.ResourceFetcher;
//import org.bimserver.shared.ResultType;
//import org.bimserver.shared.Token;
//import org.bimserver.shared.UserException;
//import org.bimserver.utils.CollectionUtils;
//
//public class NewDatabaseTester {
//	public static void main(String[] args) {
//		new NewDatabaseTester().start();
//	}
//
//	private void start() {
//		HashSet<Ifc2x3tc1Package> packages = CollectionUtils.singleSet(Ifc2x3tc1Package.eINSTANCE);
//		ResourceFetcher resourceFetcher = new ResourceFetcher() {
//			@Override
//			public URL getResource(String name) {
//				try {
//					File file = Paths.get("C:\\Workspaces\\BimServer\\BimServer\\www\\WEB-INF\\" + name);
//					if (file.exists()) {
//						return new URL("file:///" + file.getAbsolutePath());
//					} else {
//						return null;
//					}
//				} catch (MalformedURLException e) {
//				}
//				return null;
//			}
//		};
//		File schemaFile = Paths.get("../BimServer/www/WEB-INF/IFC2x3_FINAL.exp");
//		ExpressSchemaParser schemaParser = new ExpressSchemaParser(schemaFile);
//		schemaParser.parse();
//		final SchemaDefinition schema = schemaParser.getSchema();
//		try {
//			new DerivedReader(schemaFile, schema);
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		final FileFieldIgnoreMap fieldIgnoreMap = new FileFieldIgnoreMap(packages, resourceFetcher);
//		File databaseDir = Paths.get("database");
//		BerkeleyColumnDatabase columnDatabase;
//		try {
//			columnDatabase = new BerkeleyColumnDatabase(databaseDir);
//			Database database = new Database(packages, columnDatabase, fieldIgnoreMap);
//			EmfSerializerFactory emfSerializerFactory = EmfSerializerFactory.getInstance();
//			emfSerializerFactory.register(ResultType.IFC, new EmfSerializerCreator() {
//				@Override
//				public EmfSerializer create(IfcModel model, String fileName) {
//					IfcStepSerializer ifcSerializer = new IfcStepSerializer(fileName, model, schema);
//					return ifcSerializer;
//				}
//			});
//			TokenManager tokenManager = new TokenManager();
//			Service service = new Service(database, emfSerializerFactory, schema, tokenManager, lon);
//			Token token = service.login("admin", "admin");
//			File checkinFile = TestFile.AC11.getFile();
//			int addProject = service.addProject(token, "project", null);
//			long start = System.nanoTime();
//			service.checkin(token, addProject, "test", checkinFile.length(), new DataHandler(new FileDataSource(checkinFile)));
//			long end = System.nanoTime();
//			System.out.println("writing: " + (((end - start) / 1000000) + " ms"));
//			service.download(token, addProject, 1, ResultType.IFC);
//			database.close();
//		} catch (DatabaseInitException e) {
//			e.printStackTrace();
//		} catch (UserException e) {
//			e.printStackTrace();
//		}
//	}
//}
