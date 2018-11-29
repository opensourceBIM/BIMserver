package org.bimserver.tests;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;

public class GetGeometry {
	public static void main(String[] args) throws BimServerClientException, Exception {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				SProject project = client.getServiceInterface().getTopLevelProjectByName("Types");
				ClientIfcModel model = client.getModel(project, project.getLastRevisionId(), true, false, true);
				for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
					if (ifcProduct.getGeometry() == null) {
						boolean hasParts = false;
						for (IfcRelDecomposes ifcRelDecomposes : ifcProduct.getIsDecomposedBy()) {
							for (IfcObjectDefinition ifcObjectDefinition : ifcRelDecomposes.getRelatedObjects()) {
								if (ifcObjectDefinition instanceof IfcProduct) {
									hasParts = true;
									if (((IfcProduct) ifcObjectDefinition).getGeometry() == null) {
										checkGeometry(((IfcProduct) ifcObjectDefinition));
									}
								}
							}
						}
						if (!hasParts) {
							checkGeometry(ifcProduct);
						}
					}
				}
			}
		}
	}

	private static void checkGeometry(IfcProduct ifcProduct) {
		IfcProductRepresentation representation = ifcProduct.getRepresentation();
		if (representation == null) {
			return;
		}
		for (IfcRepresentation ifcRepresentation : representation.getRepresentations()) {
			String repType = ifcRepresentation.getRepresentationType();
			if (repType != null && repType.equals("BoundingBox")) {
				continue;
			}
		}
		System.out.println(ifcProduct.eClass().getName() + " " + ifcProduct.getGlobalId());
	}
}