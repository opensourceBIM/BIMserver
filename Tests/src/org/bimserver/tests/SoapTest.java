//package org.bimserver.tests;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.activation.DataHandler;
//
//import org.apache.cxf.endpoint.Client;
//import org.apache.cxf.frontend.ClientProxy;
//import org.apache.cxf.frontend.ClientProxyFactoryBean;
//import org.apache.cxf.interceptor.LoggingInInterceptor;
//import org.apache.cxf.interceptor.LoggingOutInterceptor;
//import org.apache.cxf.transport.http.HTTPConduit;
//import org.bimserver.client.ConsoleAppender;
//import org.bimserver.shared.CheckoutResult;
//import org.bimserver.shared.ResultType;
//import org.bimserver.shared.ServiceInterface;
//import org.bimserver.shared.Token;
//import org.bimserver.shared.UserException;
//
//public class SoapTest {
//	public static void main(String[] args) {
//		new SoapTest().start();
//	}
//
//	private void start() {
//		ClientProxyFactoryBean cpfb = new ClientProxyFactoryBean();
//		cpfb.setServiceClass(ServiceInterface.class);
//		cpfb.setAddress("http://localhost:8082/bimserver/services/soap");
//		
//		Map<String,Object> properties = new HashMap<String, Object>();
//		properties.put("mtom-enabled", Boolean.TRUE);
//		cpfb.setProperties(properties);
//		
//		ServiceInterface remoteService = (ServiceInterface) cpfb.create();
//
//		Client client = ClientProxy.getClient(remoteService);
//		client.getInInterceptors().add(new LoggingInInterceptor(ConsoleAppender.getPrintWriter()));
//		client.getOutInterceptors().add(new LoggingOutInterceptor(ConsoleAppender.getPrintWriter()));
//		HTTPConduit http = (HTTPConduit) client.getConduit();
//		http.getClient().setConnectionTimeout(360000);
//		http.getClient().setAllowChunking(false);
//		http.getClient().setReceiveTimeout(320000);
//
//		try {
//			Token token = remoteService.login("admin", "admin");
//			CheckoutResult downloadByOid = remoteService.downloadByOid(token, 2, 1, 21, ResultType.IFCXML);
//			DataHandler file = downloadByOid.getFile();
//			try {
//				InputStream inputStream = file.getInputStream();
//				byte[] buffer = new byte[1024];
//				int red = inputStream.read(buffer);
//				while (red != -1) {
//					System.out.println(new String(buffer, 0, red));
//					red = inputStream.read(buffer);
//				}
//				inputStream.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} catch (UserException e) {
//			e.printStackTrace();
//		}
//	}
//}