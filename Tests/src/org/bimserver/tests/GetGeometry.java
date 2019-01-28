package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

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