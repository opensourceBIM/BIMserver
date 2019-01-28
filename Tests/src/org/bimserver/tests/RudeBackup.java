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
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
//import org.apache.commons.io.IOUtils;
//import org.bimserver.Server;
//import org.bimserver.ServerInitializer;
//import org.bimserver.ifc.database.IfcDatabase;
//import org.bimserver.interfaces.objects.SProject;
//import org.bimserver.interfaces.objects.SRevision;
//import org.bimserver.shared.AuthenticatedServiceWrapper;
//import org.bimserver.shared.CheckoutResult;
//import org.bimserver.shared.ResultType;
//import org.bimserver.shared.ServiceInterface;
//import org.bimserver.shared.Token;
//import org.bimserver.shared.UserException;
//
//public class RudeBackup {
//	private IfcDatabase<Long> database;
//
//	public static void main(String[] args) {
//		// new LeonTest().start();
//		new RudeBackup().test();
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
//				if (project.getParentId() == -1) {
//				System.out.println(project.getName() + " met " + project.getRevisions().size() + " revisie(s)");
//				   listSubProject(project, service, token);
//				}
//			}
//		} catch (UserException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Klaar");
//	}
//
//	private void listSubProject(SProject project, ServiceInterface service, Token token) {
//		try {
//			for (int pid : project.getSubProjects()) {
//		    SProject subproject;
//			subproject = service.getProjectById(token, pid);
//		    System.out.println(" -> " + subproject.getName() +  " met " + subproject.getRevisions().size() + " revisie(s)");
//	    	SRevision lastRevision = service.getLastRevision(token, pid);
//	    	List<SRevision> allRevisionsOfProject = service.getAllRevisionsOfProject(token, pid);
//	    	for (SRevision sRevision : allRevisionsOfProject) {
//	    		System.out.println(sRevision.getId());
//	    	}
//			CheckoutResult download = service.download(token, pid, lastRevision.getId(), ResultType.IFC);
//	    	InputStream inputStream = download.getFile().getInputStream();
//	    	FileOutputStream fos = new FileOutputStream(Paths.get(subproject.getName() + ".ifc"));
//	    	IOUtils.copy(inputStream, fos);
//	    	fos.close();
//	    	listSubProject(subproject, service, token);
//
//			}
//			} catch (UserException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//   }
//		
//}