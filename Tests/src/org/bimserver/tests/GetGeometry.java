package org.bimserver.tests;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;

public class GetGeometry {
	public static void main(String[] args) throws BimServerClientException, Exception {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				SProject project = client.getServiceInterface().getTopLevelProjectByName("Types");
				ClientIfcModel model = client.getModel(project, project.getLastRevisionId(), true, false, true);
				for (IfcProduct ifcProduct : model.getAll(IfcProduct.class)) {
					if (ifcProduct.getGeometry() == null) {
						System.out.println(ifcProduct.getGlobalId());
					}
				}
			}
		}
	}
}
