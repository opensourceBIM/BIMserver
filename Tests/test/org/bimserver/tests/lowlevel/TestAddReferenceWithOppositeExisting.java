package org.bimserver.tests.lowlevel;

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
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.tests.TestWithEmbeddedServer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestAddReferenceWithOppositeExisting extends TestWithEmbeddedServer {

	@Test
	public void test() throws ServiceException, ChannelConnectionException {
		// Create a new BimServerClient with authentication
		BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));

		LowLevelInterface lowLevelInterface = bimServerClient.getLowLevelInterface();

		// Create a new project
		SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");

		// Start a transaction
		Long tid1 = lowLevelInterface.startTransaction(newProject.getOid());

		Long ifcRelContainedInSpatialStructureOid = lowLevelInterface.createObject(tid1, "IfcRelContainedInSpatialStructure", true);
		Long ifcBuildingOid1 = lowLevelInterface.createObject(tid1, "IfcBuilding", true);
		Long ifcBuildingOid2 = lowLevelInterface.createObject(tid1, "IfcBuilding", true);
		lowLevelInterface.addReference(tid1, ifcBuildingOid1, "ContainsElements", ifcRelContainedInSpatialStructureOid);

		lowLevelInterface.commitTransaction(tid1, "Initial", false);

		Long tid2 = lowLevelInterface.startTransaction(newProject.getOid());
		lowLevelInterface.addReference(tid2, ifcBuildingOid2, "ContainsElements", ifcRelContainedInSpatialStructureOid);
		Exception thrown = assertThrows(UserException.class, () ->
				lowLevelInterface.commitTransaction(tid2, "2", false)
				);
		// assertEquals( ErrorCode.SET_REFERENCE_FAILED_OPPOSITE_ALREADY_SET, ((UserException) thrown).getErrorCode());
	}
}