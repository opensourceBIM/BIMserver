package org.bimserver.unittests;

import static org.junit.Assert.fail;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bimserver.BimServer;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.HttpNotificationsClient;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.web.LocalDevBimWebServerStarter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestNotifications {
	private static BimServer bimServer;

	@BeforeClass
	public static void before() {
		try {
			File home = new File("home");
			if (home.isDirectory()) {
				FileUtils.deleteDirectory(home);
			}

			LocalDevBimWebServerStarter localDevBimWebServerStarter = new LocalDevBimWebServerStarter();
			localDevBimWebServerStarter.start("localhost", 8082, "home", "../BimWebServer/www");
			bimServer = localDevBimWebServerStarter.getBimServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void after() {
		
	}
	
	@Test
	public void test() {
		HttpNotificationsClient notificationsClient = new HttpNotificationsClient();
		
		BimServerClient bimServerClient = new BimServerClient();
		bimServerClient.connectProtocolBuffers("localhost", 8020);
		try {
			bimServerClient.getServiceInterface().login("admin@bimserver.org", "admin");
			bimServerClient.getServiceInterface().setHttpCallback(bimServerClient.getServiceInterface().getCurrentUser().getOid(), "localhost");
			SProject addProject = bimServerClient.getServiceInterface().addProject("test12345");
			System.out.println(addProject.getName());
		} catch (ServiceException e) {
			fail(e.getMessage());
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
