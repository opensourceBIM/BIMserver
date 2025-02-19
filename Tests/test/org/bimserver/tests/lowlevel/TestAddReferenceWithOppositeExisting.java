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

import static org.junit.Assert.fail;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestAddReferenceWithOppositeExisting extends TestWithEmbeddedServer {

	@Test
	public void test() throws ServiceException, ChannelConnectionException {
		// Create a new BimServerClient with authentication
		BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));

		LowLevelInterface lowLevelInterface = bimServerClient.getLowLevelInterface();

		// Create a new project
		SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");

		// Start a transaction
		Long tid = lowLevelInterface.startTransaction(newProject.getOid());

		Long ifcRelContainedInSpatialStructureOid = lowLevelInterface.createObject(tid, "IfcRelContainedInSpatialStructure", true);
		Long ifcBuildingOid1 = lowLevelInterface.createObject(tid, "IfcBuilding", true);
		Long ifcBuildingOid2 = lowLevelInterface.createObject(tid, "IfcBuilding", true);
		lowLevelInterface.addReference(tid, ifcBuildingOid1, "ContainsElements", ifcRelContainedInSpatialStructureOid);

		lowLevelInterface.commitTransaction(tid, "Initial", false);

		tid = lowLevelInterface.startTransaction(newProject.getOid());
		lowLevelInterface.addReference(tid, ifcBuildingOid2, "ContainsElements", ifcRelContainedInSpatialStructureOid);
		try {
			lowLevelInterface.commitTransaction(tid, "2", false);
		} catch (UserException e) {
//				if (e.getErrorCode() != ErrorCode.SET_REFERENCE_FAILED_OPPOSITE_ALREADY_SET) {
				fail("Didn't get the right errormessage");
//				}
		} finally {
			fail("Expected error code");
		}
	}
}