package org.bimserver.tests.serviceinterface;

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

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.tests.TestWithEmbeddedServer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateProject extends TestWithEmbeddedServer {

	@Test
	public void test() throws ServiceException, ChannelConnectionException {
		// Create a new BimServerClient with authentication
		BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));

		// Create a new project
		String originalName = "test " + Math.random();
		String newName = "test " + Math.random();
		SProject newProject = bimServerClient.getServiceInterface().addProject(originalName, "ifc2x3tc1");

		newProject.setName(newName);

		bimServerClient.getServiceInterface().updateProject(newProject);

		newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());

		assertNotEquals(originalName, newProject.getName(), "Project name not updated");
		assertEquals( newName, newProject.getName(), "Project name not updated to new name");
	}
}