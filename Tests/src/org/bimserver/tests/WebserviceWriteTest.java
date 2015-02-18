package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import javax.activation.DataHandler;
//import javax.activation.FileDataSource;
//import javax.xml.ws.soap.SOAPFaultException;
//
//import org.apache.cxf.frontend.ClientProxy;
//import org.apache.cxf.frontend.ClientProxyFactoryBean;
//import org.apache.cxf.transport.http.HTTPConduit;
//import org.bimserver.interfaces.objects.SProject;
//import org.bimserver.shared.CheckinResult;
//import org.bimserver.shared.ServiceInterface;
//import org.bimserver.shared.Token;
//import org.bimserver.shared.UserException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class WebserviceWriteTest extends Thread {
//	private static final Logger LOGGER = LoggerFactory.getLogger(WebserviceWriteTest.class);
//
//	private final List<Integer> userIds = new ArrayList<Integer>();
//	private final List<Integer> projectIds = new ArrayList<Integer>();
//
//	public static void main(String[] args) {
//		for (int i = 0; i < 1; i++) {
//			new WebserviceWriteTest().start();
//		}
//	}
//
//	@Override
//	public void run() {
//		Random random = new Random();
////		File testFilesDir = new File("C:\\Documents and Settings\\Ruben de Laat\\My Documents\\ifc selected");
//		File testFilesDir = new File("G:\\ifc selected");
//		File[] listFiles = testFilesDir.listFiles();
//		for (File file : listFiles) {
//			System.out.println(file);
//			ClientProxyFactoryBean clientProxyFactoryBean = new ClientProxyFactoryBean();
//			clientProxyFactoryBean.setServiceClass(ServiceInterface.class);
//			clientProxyFactoryBean.setAddress("http://localhost:8081/bimserver/services/anonymous");
////			clientProxyFactoryBean.setAddress("http://192.168.5.34:8080/bimserver-0.2RC1/services/anonymous");
//			ServiceInterface client = (ServiceInterface) clientProxyFactoryBean.create();
//
//			HTTPConduit http = (HTTPConduit) ClientProxy.getClient(client).getConduit();
//			http.getClient().setConnectionTimeout(3600000); // 1 hour
//			http.getClient().setAllowChunking(false);
//			http.getClient().setReceiveTimeout(3600000); // 1 hour
//
//			String projectName = "project " + random.nextInt();
//			try {
//				Token token = client.login("admin", "admin");
//				int userId = 0;
//				if (random.nextBoolean() || userIds.size() < 3) {
//					String username1 = "user" + random.nextInt();
//					String password1 = "password";
//					try {
//						userId = client.addUser(token, username1, password1, username1);
//						userIds.add(userId);
//					} catch (UserException e2) {
//						e2.printStackTrace();
//					}
//				} else {
//					userId = userIds.get(random.nextInt(userIds.size()));
//				}
//
//				int projectId = 0;
//				if (random.nextBoolean() || projectIds.size() < 3) {
//					try {
//						SProject sProject = client.addProject(token, projectName);
//						projectIds.add(sProject.getId());
//					} catch (UserException e1) {
//						e1.printStackTrace();
//					}
//				} else {
//					projectId = projectIds.get(random.nextInt(projectIds.size()));
//				}
//				client.addUserToProject(token, userId, projectId);
//
//				try {
//					CheckinResult result = client.checkin(token, projectId, file.getName(), file.length(), new DataHandler(new FileDataSource(file)));
//					LOGGER.info("Project " + result.getProjectName() + " successfully stored, new revision " + result.getRevisionNr());
//				} catch (UserException e) {
//					LOGGER.info("Error storing " + file.getName() + " " + e.getUserMessage());
//				} catch (SOAPFaultException e) {
//					e.printStackTrace();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			} catch (UserException e3) {
//				e3.printStackTrace();
//			}
//		}
//
//		// CheckoutResult checkoutResult = client.checkoutLastRevision(token,
//		// projectId);
//		// if (checkoutResult.isOke()) {
//		// LOGGER.info("Revision " + checkoutResult.getRevisionNr() +
//		// " of project " + checkoutResult.getProjectName() +
//		// " successfully checked out by "
//		// + username2);
//		// } else {
//		// LOGGER.info("Error checking out last revision of " +
//		// result.getProjectName());
//		// }
//		//		
//		// FastIfcFileReader fastIfcFileReader = new FastIfcFileReader(null);
//		// try {
//		// fastIfcFileReader.read(checkoutResult.getIfcFile().getInputStream(),
//		// 0);
//		// IfcModel model = fastIfcFileReader.getModel();
//		// doChanges(model);
//		//			
//		// client.checkin(0, projectId, "Aantal zaken aangepast", new
//		// DataHandler(new ModelDataSource(model, null)));
//		// } catch (IOException e) {
//		// e.printStackTrace();
//		// }
//	}
//
//	// private static void doChanges(IfcModel model) {
//	// IfcDatabase ifcDatabase = new IfcDatabase(model);
//	// List<IfcWall> allWalls = ifcDatabase.getAll(IfcWall.class);
//	// for (IfcWall wall : allWalls) {
//	// wall.getDescription().setWrappedValue(wall.getDescription().getWrappedValue()
//	// + " Aangepast");
//	// }
//	// }
//}