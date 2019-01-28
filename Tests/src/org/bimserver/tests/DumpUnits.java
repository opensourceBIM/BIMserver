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

import java.util.List;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SBounds;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.utils.IfcUtils;

public class DumpUnits {
	public static void main(String[] args) {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				List<SProjectSmall> allRelatedProjects = client.getServiceInterface().getAllRelatedProjects(31588353L);
				for (SProjectSmall projectSmall : allRelatedProjects) {
					if (projectSmall.getLastRevisionId() != -1 && projectSmall.getNrSubProjects() == 0) {
						SProject project = client.getServiceInterface().getProjectByPoid(projectSmall.getOid());
						System.out.println(project.getName());
						SBounds bounds = client.getServiceInterface().getModelBounds(project.getLastRevisionId());
						if (bounds != null) {
							System.out.println(bounds.getMin().getX() + ", " + bounds.getMin().getY() + ", " + bounds.getMin().getZ() + " --- " + bounds.getMax().getX() + ", " + bounds.getMax().getY() + ", " + bounds.getMax().getZ());
							ClientIfcModel model = client.getModel(project, project.getLastRevisionId(), false, false);
							System.out.println(IfcUtils.getLengthUnitPrefix(model));
						}
					}
				}
			}
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
