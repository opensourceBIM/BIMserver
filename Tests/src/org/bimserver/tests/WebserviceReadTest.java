//package org.bimserver.tests;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//import org.apache.commons.io.IOUtils;
//import org.apache.cxf.frontend.ClientProxy;
//import org.apache.cxf.frontend.ClientProxyFactoryBean;
//import org.apache.cxf.transport.http.HTTPConduit;
//import org.bimserver.interfaces.objects.SProject;
//import org.bimserver.interfaces.objects.SRevision;
//import org.bimserver.shared.CheckoutResult;
//import org.bimserver.shared.ResultType;
//import org.bimserver.shared.ServiceInterface;
//import org.bimserver.shared.Token;
//import org.bimserver.shared.UserException;
//
//public class WebserviceReadTest {
//	public static void main(String[] args) {
//		new WebserviceReadTest().start();
//	}
//
//	private void start() {
//		ClientProxyFactoryBean clientProxyFactoryBean = new ClientProxyFactoryBean();
//		clientProxyFactoryBean.setServiceClass(ServiceInterface.class);
//		clientProxyFactoryBean.setAddress("http://localhost:8082/bimserver/services/soap");
//		ServiceInterface client = (ServiceInterface) clientProxyFactoryBean.create();
//
//		HTTPConduit http = (HTTPConduit) ClientProxy.getClient(client).getConduit();
//		http.getClient().setConnectionTimeout(3600000); // 1 hour
//		http.getClient().setAllowChunking(false);
//		http.getClient().setReceiveTimeout(3600000); // 1 hour
//
//		downloadAll(client);
//	}
//
//	private void downloadAll(ServiceInterface client) {
//		try {
//			Token token = client.login("admin", "admin");
//			List<SProject> allProjects = client.getAllProjects(token);
//			for (SProject project : allProjects) {
//				List<SRevision> revisions = client.getAllRevisionsOfProject(token, project.getId());
//				for (SRevision revision : revisions) {
//					for (ResultType resultType : ResultType.getUserTypes()) {
//						try {
//							CheckoutResult download = client.download(token, project.getId(), revision.getId(), resultType);
//							String pathname = download.getProjectName() + download.getRevisionNr() + "." + resultType.getDefaultExtension();
//							System.out.println("Downloading " + pathname);
//							File file = new File("downloaded" + File.separator + pathname);
//							FileOutputStream out = new FileOutputStream(file);
//							IOUtils.copy(download.getFile().getInputStream(), out);
//							out.close();
//						} catch (IOException e) {
//							e.printStackTrace();
//						} catch (UserException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			}
//		} catch (UserException e1) {
//			e1.printStackTrace();
//		}
//	}
//}