package org.bimserver.client.tests;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang.RandomStringUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SServerInfo;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.plugins.services.CheckinProgressHandler;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.utils.IfcUtils;
import org.junit.Test;

public class TestGetUuid {
	@Test
	public void test() {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				SServerInfo serverInfo = client.getAdminInterface().getServerInfo();
				System.out.println(serverInfo.getServerState());
				System.out.println(serverInfo.getUuid());
				
				SProject project = client.getServiceInterface().addProject(RandomStringUtils.randomAlphanumeric(10), "ifc2x3tc1");
				
				SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
				Path path = Paths.get("C:\\Git\\TestFiles\\TestData\\data\\AC11-Institute-Var-2-IFC.ifc");
				client.checkinSync(project.getOid(), "test", deserializer.getOid(), path, new CheckinProgressHandler() {
					@Override
					public void progress(String title, int progress) {
						System.out.println(title + ": " + progress);
					}
				});
				
				project = client.getServiceInterface().getProjectByPoid(project.getOid());
				ClientIfcModel model = client.getModel(project, project.getLastRevisionId(), true, true);
				
				for (IfcBuildingStorey ifcBuildingStorey : model.getAll(IfcBuildingStorey.class)) {
					System.out.println(ifcBuildingStorey.getUuid() + ":" + ifcBuildingStorey.getRid());
				}
				
				System.out.println("Length unit: " + IfcUtils.getLengthUnitPrefix(model));
				
				IfcProject ifcProject = model.getAll(IfcProject.class).iterator().next();
				ifcProject.setName(ifcProject.getName() + " updated");
				long newRoid = model.commit("commit message");
				
				model = client.getModel(project, newRoid, true, true);
				ifcProject = model.getAll(IfcProject.class).iterator().next();
				System.out.println(ifcProject.getName());
			}
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
