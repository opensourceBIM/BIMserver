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
//import java.io.IOException;
//import java.util.List;
//import java.util.Set;
//
//import javax.activation.DataHandler;
//import javax.activation.FileDataSource;
//
//import nl.tue.buildingsmart.emf.DerivedReader;
//import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
//import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;
//
//import org.apache.commons.io.FileUtils;
//import org.bimserver.EmfSerializerFactory;
//import org.bimserver.LongActionManager;
//import org.bimserver.ServerSettings;
//import org.bimserver.Service;
//import org.bimserver.Settings;
//import org.bimserver.Version;
//import org.bimserver.VersionChecker;
//import org.bimserver.database.Database;
//import org.bimserver.database.berkeley.BerkeleyColumnDatabase;
//import org.bimserver.database.berkeley.DatabaseInitException;
//import org.bimserver.database.store.log.AccessMethod;
//import org.bimserver.ifc.FieldIgnoreMap;
//import org.bimserver.ifc.FileFieldIgnoreMap;
//import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3tc1Package;
//import org.bimserver.ifcengine.FailSafeIfcEngine;
//import org.bimserver.interfaces.objects.SProject;
//import org.bimserver.services.TokenManager;
//import org.bimserver.shared.LocalDevelopmentResourceFetcher;
//import org.bimserver.shared.ResourceFetcher;
//import org.bimserver.shared.ServiceInterface;
//import org.bimserver.shared.Token;
//import org.bimserver.shared.UserException;
//import org.bimserver.utils.CollectionUtils;
//import org.bimserver.utils.Formatters;
//
//public class PerformanceTester {
//	public static void main(String[] args) {
//		new PerformanceTester().start();
//	}
//
//	private void start() {
//		ResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher();
//		Set<Ifc2x3tc1Package> packages = CollectionUtils.singleSet(Ifc2x3tc1Package.eINSTANCE);
//		FieldIgnoreMap fieldIgnoreMap = new FileFieldIgnoreMap(packages, resourceFetcher);
//		try {
//			File dataDir = Paths.get("database_tmp");
//			BerkeleyColumnDatabase columnDatabase = new BerkeleyColumnDatabase(dataDir);
//			Database database = new Database(packages, columnDatabase, fieldIgnoreMap);
//			EmfSerializerFactory emfSerializerFactory = EmfSerializerFactory.getInstance();
//			Version version = VersionChecker.init(resourceFetcher).getLocalVersion();
//			TokenManager tokenManager = new TokenManager();
//			LongActionManager longActionManager = new LongActionManager();
//			longActionManager.start();
//			File nativeFolder = Paths.get("../IfcEngine/lib");
//			File schemaFile = Paths.get("../BimServer/deploy/shared/IFC2X3_TC1.exp");
//			ExpressSchemaParser schemaParser = new ExpressSchemaParser(schemaFile);
//			schemaParser.parse();
//			SchemaDefinition schema = schemaParser.getSchema();
//			new DerivedReader(schemaFile, schema);
//			ServerSettings.setSettings(Settings.readFromFile(Paths.get("../BimServer/deploy/local/settings.xml")));
//			FailSafeIfcEngine failSafeIfcEngine = new FailSafeIfcEngine(schemaFile, nativeFolder, resourceFetcher, true);
//			emfSerializerFactory.init(version, schema, fieldIgnoreMap, failSafeIfcEngine);
//			emfSerializerFactory.initSerializers();
//			ServiceInterface soapService = new Service(database, emfSerializerFactory, schema, tokenManager, longActionManager, failSafeIfcEngine, AccessMethod.SOAP);
//			Token token = soapService.login("admin", "admin");
//			if (token != null) {
//				List<SProject> projects = soapService.getProjectByName("test");
//				SProject project = null;
//				if (projects.size() == 0) {
//					project = soapService.addProject(token, "test");
//				} else {
//					project = projects.get(0);
//				}
//				long start = System.nanoTime();
//				soapService.checkinSync(token, project.getOid(), "test 1", TestFile.AC11.getFile().length(), new DataHandler(new FileDataSource(TestFile.AC11.getFile())));
//				soapService.checkinSync(token, project.getOid(), "test 2", TestFile.HAUS_SOURCE_FILE.getFile().length(), new DataHandler(new FileDataSource(TestFile.HAUS_SOURCE_FILE.getFile())));
//				soapService.checkinSync(token, project.getOid(), "test 3", TestFile.NIEDRI.getFile().length(), new DataHandler(new FileDataSource(TestFile.NIEDRI.getFile())));
//				long end = System.nanoTime();
//				System.out.println(Formatters.formatNanoSeconds(end - start));
//			}
//			longActionManager.shutdownGracefully();
//			database.close();
//			if (dataDir.exists()) {
//				FileUtils.deleteDirectory(dataDir);
//			}
//		} catch (DatabaseInitException e) {
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (UserException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}