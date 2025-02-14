package org.bimserver.tests.emf;

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

import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcObjectPlacement;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.Flow;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestMoveObject extends TestWithEmbeddedServer{
	@Test
	public void test() throws ServiceException, ChannelConnectionException, IOException, BimServerClientException {
		// Create a new BimServerClient with authentication
		BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));

		// Create a new project
		SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");

		// Get the appropriate deserializer
		SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());

		// Checkin the file
		bimServerClient.checkinSync(newProject.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/AC11-Institute-Var-2-IFC.ifc"));

		// Refresh project info
		newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());

		IfcModelInterface model = bimServerClient.getModel(newProject, newProject.getLastRevisionId(), true, true);
		for (IfcFurnishingElement ifcFurnishingElement : model.getAllWithSubTypes(IfcFurnishingElement.class)) {
			IfcObjectPlacement objectPlacement = ifcFurnishingElement.getObjectPlacement();
			if (objectPlacement != null && objectPlacement instanceof IfcLocalPlacement) {
				IfcLocalPlacement localPlacement = (IfcLocalPlacement)objectPlacement;
				IfcAxis2Placement relativePlacement = localPlacement.getRelativePlacement();
				if (relativePlacement != null) {
					if (relativePlacement instanceof IfcAxis2Placement3D) {
						IfcAxis2Placement3D axis2Placement3D = (IfcAxis2Placement3D)relativePlacement;
						IfcCartesianPoint location = axis2Placement3D.getLocation();
						double newValue = location.getCoordinates().get(2) + 50;
						System.out.println("Changing z value of " + ifcFurnishingElement.getName() + " from " + location.getCoordinates().get(2) + " to " + newValue);
						location.getCoordinates().set(2, newValue);
					}
				}
			}
		}
		long newRoid = model.commit("Moved all furniture 50 meters up");
		SSerializerPluginConfiguration ifcSerializer = bimServerClient.getServiceInterface().getSerializerByContentType("application/ifc");
		bimServerClient.download(newRoid, ifcSerializer.getOid(), Paths.get("movedf.ifc"));
	}
}