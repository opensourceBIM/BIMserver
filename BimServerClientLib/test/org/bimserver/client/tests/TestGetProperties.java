package org.bimserver.client.tests;

import org.apache.commons.lang.RandomStringUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SLongCheckinActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.plugins.services.CheckinProgressHandler;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.utils.IfcUtils;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestGetProperties {
	@Test
	public void test() throws Exception {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				SProject project = client.getServiceInterface().addProject(RandomStringUtils.randomAlphanumeric(10), "ifc2x3tc1");
				SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
				Path path = Paths.get("../../TestFiles/TestData/data/AC9R1-Haus-G-H-Ver2-2x3.ifc");
				SLongCheckinActionState actionState = client.checkinSync(project.getOid(), "test", deserializer.getOid(), path, new CheckinProgressHandler() {
					@Override
					public void progress(String title, int progress) {
						System.out.println(title + ": " + progress);
					}
				});
				ClientIfcModel model = client.getModel(project, actionState.getRoid(), false, false);
				for (IfcWall wall : model.getAllWithSubTypes(IfcWall.class)) {
					String layerName = IfcUtils.getStringProperty(wall, "Layername");
					Assert.assertNotNull(layerName);
					Assert.assertFalse(layerName.isEmpty());
				}
			}
		}
		Thread.sleep(1000);
	}
}
