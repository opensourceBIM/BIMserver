package org.bimserver.client.tests;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.apache.commons.lang.RandomStringUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.CheckinProgressHandler;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.DefaultErrorCode;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.junit.Test;

public class TestServerRestart {
	@Test
	public void test() {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				try (Scanner scanner = new Scanner(System.in)) {
					for (int i=0; i<10; i++) {
						System.out.println("Restart server now, then press key");
						scanner.nextLine();
						
						try {
							checkin(client);
						} catch (UserException e) {
							if (e.getErrorCode() == DefaultErrorCode.ENDPOINT_NOT_FOUND) {
								client.getNotificationsManager().startAndWaitForInit();
								checkin(client);
							} else {
								System.err.println(e.getMessage());
							}
						}
					}
				}
				Thread.sleep(5000);
			}
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void checkin(BimServerClient client) throws ServerException, UserException {
		SProject project = client.getServiceInterface().addProject(RandomStringUtils.randomAlphanumeric(10), "ifc2x3tc1");
		
		SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
		Path path = Paths.get("C:\\Git\\TestFiles\\TestData\\data\\export1.ifc");
		client.checkinSync(project.getOid(), "test", deserializer.getOid(), path, new CheckinProgressHandler() {
			@Override
			public void progress(String title, int progress) {
				System.out.println(title + ": " + progress);
			}
		});
	}
}
