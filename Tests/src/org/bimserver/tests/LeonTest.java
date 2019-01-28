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
//import java.util.List;
//import java.util.Set;
//
//import org.bimserver.Server;
//import org.bimserver.ServerInitializer;
//import org.bimserver.database.BimDatabase;
//import org.bimserver.database.BimDatabaseException;
//import org.bimserver.database.DatabaseSession;
//import org.bimserver.database.BimDeadlockException;
//import org.bimserver.database.actions.DownloadOfTypeDatabaseAction;
//import org.bimserver.database.store.ConcreteRevision;
//import org.bimserver.database.store.Project;
//import org.bimserver.database.store.Revision;
//import org.bimserver.database.store.User;
//import org.bimserver.database.store.log.AccessMethod;
//import org.bimserver.emf.IfcModel;
//import org.bimserver.ifc.SchemaLoader;
//import org.bimserver.ifc.database.IfcDatabase;
//import org.bimserver.ifc.emf.Ifc2x3.IfcSpace;
//import org.bimserver.ifc.emf.Ifc2x3.IfcWall;
//import org.bimserver.ifc.file.reader.FastIfcFileReader;
//import org.bimserver.interfaces.objects.SProject;
//import org.bimserver.shared.AuthenticatedServiceWrapper;
//import org.bimserver.shared.ServiceInterface;
//import org.bimserver.shared.Token;
//import org.bimserver.shared.UserException;
//import org.eclipse.emf.ecore.EObject;
//
//public class LeonTest {
//	private IfcDatabase<Long> database;
//
//	public static void main(String[] args) {
//		new LeonTest().test();
//		new LeonTest().start2();
//	}
//
//	private void test() {
//		Server server = new Server();
//		server.start("localhost", 8083);
//		ServiceInterface service = (ServiceInterface) ServerInitializer.getServletContext().getAttribute("service");
//		try {
//			Token token = service.login("admin", "admin");
//			AuthenticatedServiceWrapper authenticatedServiceWrapper = new AuthenticatedServiceWrapper(service, token, false);
//			List<SProject> projects = service.getAllProjects(token);
//			for (SProject project : projects) {
//				System.out.println(project.getName());
//			}
//		} catch (UserException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void start2() {
//		BimDatabase database = ServerInitializer.getDatabase();
//		DatabaseSession databaseSession = database.createSession();
//
//		try {
//			Project project = databaseSession.getProjectById(2);
//			System.out.println(project.getName());
//			// VirtualRevision virtualRevision =
//			// project.getLastVirtualRevision();
//			// List<VirtualRevision> revisions = project.getVirtualRevisions();
//			// System.out.println(revisions.size());
//			User user = databaseSession.getUserById(1);
//
//			System.out.println(project.getName());
//
//			for (Revision vrevision : project.getRevisions()) {
//				System.out.println("virtuele revisie " + vrevision.getId() + " van :" + project.getName());
////				DownloadDatabaseAction downloadDatabaseAction = new DownloadDatabaseAction(project.getId(), vrevision.getId(), user.getId());
//				DownloadOfTypeDatabaseAction downloadDatabaseAction = new DownloadOfTypeDatabaseAction(AccessMethod.INTERNAL, project.getId(), vrevision.getId(), "IfcWall", user.getId());
//				IfcModel IfcModel = databaseSession.executeAction(downloadDatabaseAction, 3);
//				new IfcDatabase<Long>(IfcModel, null);
//
//				// vrevision.getLastRevision().getSize();
//				long size = 0;
//				for (ConcreteRevision crevision : vrevision.getConcreteRevisions()) {
//					System.out.println("concrete revision met comment: " + vrevision.getComment() + " met datum: " + vrevision.getDate() + " met size: " + vrevision.getSize());
//					size = size + vrevision.getSize();
//					Set<Long> keySet = IfcModel.getObjects().keySet();
//					for (Long key : keySet) {
//						// System.out.println("key = " + key);
//						EObject ifcObject = IfcModel.getObjects().get(key);
//						if (ifcObject instanceof IfcSpace) {
//							System.out.println("guid van ifcSpace = " +((IfcSpace) ifcObject).getGlobalId().toString());
//						}
//						if (ifcObject instanceof IfcWall) {
//							System.out.println("guid van " + ((IfcWall) ifcObject).getName().getWrappedValue() + " = " +((IfcWall) ifcObject).getGlobalId().getWrappedValue());
//						}
//						// System.out.println(eObject);
//						// Set<Long> keySet2 = IfcModel.getObjects().keySet();
//
//					}
//				}
//				System.out.println("total size: " + size + " van virtuele revisie " + vrevision.getId() + " van :" + project.getName() + "(nu komt nieuwe vertuele revisie)");
//			}
//
//		} catch (BimDeadlockException e) {
//			e.printStackTrace();
//		} catch (BimDatabaseException e) {
//			e.printStackTrace();
//		} catch (UserException e) {
//			e.printStackTrace();
//		}
//
//		databaseSession.close();
//		System.out.println("klaar");
//	}
//
//	private void start() {
//
//		File src = TestFile.HITOS_SOURCE_FILE.getFile();
//
//		FastIfcFileReader ifcReader = new FastIfcFileReader(SchemaLoader.loadDefaultSchema());
//		try {
//			ifcReader.read(src);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		database = new IfcDatabase<Long>(ifcReader.getModel(), null);
//		System.out.println("muren...");
//
//		List<IfcWall> walls = database.getAll(IfcWall.class);
//		for (IfcWall wall : walls) {
//			System.out.println(wall.getName().getWrappedValue());
//		}
//
//		System.out.println("..spaces...");
//
//		List<IfcSpace> spaces = database.getAll(IfcSpace.class);
//		for (IfcSpace space : spaces) {
//			System.out.println("naam:" + space.getName().getWrappedValue());
//			System.out.println("   met lange naam: " + space.getLongName().getWrappedValue());
//			System.out.println("   met elevation : " + space.getElevationWithFlooring().getStringValuewrappedValue());
//		}
//
//		System.out.println("..einde");
//	}
//}