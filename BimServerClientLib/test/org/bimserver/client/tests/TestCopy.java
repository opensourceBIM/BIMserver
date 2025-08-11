package org.bimserver.client.tests;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.RandomStringUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SLongCheckinActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.junit.Test;

public class TestCopy {
	@Test
	public void test() throws Exception {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				SProject project = client.getServiceInterface().addProject(RandomStringUtils.randomAlphanumeric(10), "ifc2x3tc1");
				
				SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
				Path path = Paths.get("../../TestFiles/TestData/data/export1.ifc");
				SLongCheckinActionState actionState = client.checkinSync(project.getOid(), "test", deserializer.getOid(), path, (title, progress) ->
						System.out.println(title + ": " + progress)
				);
				long roid = actionState.getRoid();
				client.getServiceInterface().clone(roid, "Clone-" + RandomStringUtils.randomAlphabetic(10), "Cloned", true);
			}
		}
		Thread.sleep(1000);
	}
}
