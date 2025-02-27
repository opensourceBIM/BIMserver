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

import java.util.List;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestDeleteObjects extends TestWithEmbeddedServer {

	@Test
	public void test() throws ServiceException, ChannelConnectionException, BimServerClientException, IfcModelInterfaceException {
		// Create a new BimServerClient with authentication
		BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));

		// Create a new project
		SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");

		IfcModelInterface model = bimServerClient.newModel(newProject, true);

		for (int i=0; i<10; i++) {
			IfcWall wall = model.create(Ifc2x3tc1Package.eINSTANCE.getIfcWall());
			wall.setName("Wall " + i);
			wall.setGlobalId("Wall " + i);
		}

		long roid = model.commit("Initial model");

		model = bimServerClient.getModel(newProject, roid, true, true);
		List<IfcWall> walls = model.getAllWithSubTypes(Ifc2x3tc1Package.eINSTANCE.getIfcWall());
		assertEquals(10, walls.size());
		IfcWall wall6 = (IfcWall) model.getByGuid("Wall 6");
		assertNotNull(wall6);
		wall6.remove();

		roid = model.commit("Removed wall 6");

		model = bimServerClient.getModel(newProject, roid, true, false);
		walls = model.getAllWithSubTypes(Ifc2x3tc1Package.eINSTANCE.getIfcWall());
		assertEquals(9, walls.size());
	}
}