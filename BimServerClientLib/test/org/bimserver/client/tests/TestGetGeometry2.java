package org.bimserver.client.tests;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang.RandomStringUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SLongCheckinActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.plugins.services.CheckinProgressHandler;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.junit.Test;

public class TestGetGeometry2 {
	@Test
	public void test() {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				SProject project = client.getServiceInterface().addProject(RandomStringUtils.randomAlphanumeric(10), "ifc2x3tc1");
				
				SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
				Path path = Paths.get("C:\\Git\\TestFiles\\TestData\\data\\export1.ifc");
				SLongCheckinActionState actionState = client.checkinSync(project.getOid(), "test", deserializer.getOid(), path, new CheckinProgressHandler() {
					@Override
					public void progress(String title, int progress) {
						System.out.println(title + ": " + progress);
					}
				});

				ClientIfcModel model = client.getModel(project, actionState.getRoid(), false, false, true);
				for (IfcProduct product : model.getAllWithSubTypes(IfcProduct.class)) {
					GeometryInfo geometry = product.getGeometry();
					if (geometry != null) {
						System.out.println(product.getGeometry().getData().getNrVertices());
						System.out.println(product.getGeometry().getData().getVertices().getData().length);
					}
				}
			}
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
