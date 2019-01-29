package org.bimserver.test;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;

public class GetVolumes {
	public static void main(String[] args) {
		new GetVolumes().start();
	}

	private void start() {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient bimServerClient = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				SProject project = bimServerClient.getServiceInterface().getProjectsByName("K06K09").get(0);
				ClientIfcModel model = bimServerClient.getModel(project, project.getLastRevisionId(), true, false, true);
				for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
					if (ifcProduct.eClass().getName().equals("IfcStair")) {
						GeometryInfo geometryInfo = ifcProduct.getGeometry();
						if (geometryInfo != null) {
							System.out.println(ifcProduct.getName() + ": " + geometryInfo.getVolume());
						}
					}
				}
			}
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
