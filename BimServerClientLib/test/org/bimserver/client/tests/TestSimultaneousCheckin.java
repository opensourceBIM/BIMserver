package org.bimserver.client.tests;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang.RandomStringUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.CheckinProgressHandler;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.junit.Test;

public class TestSimultaneousCheckin {
	@Test
	public void test() throws Exception {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				SProject project = client.getServiceInterface().addProject(RandomStringUtils.randomAlphanumeric(10), "ifc2x3tc1");
				
				SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
				Path path = Paths.get("../../TestFiles/TestData/data/export1.ifc");
				client.checkinSync(project.getOid(), "test", deserializer.getOid(), path, new CheckinProgressHandler() {
					@Override
					public void progress(String title, int progress) {
						System.out.println(title + ": " + progress);
					}
				});
			}
			Thread.sleep(1000);
		}
	}
}
