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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestRemoveReferenceWithOpposite2 extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			LowLevelInterface lowLevelInterface = bimServerClient.getLowLevelInterface();
			
			// Create a new project
			SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Start a transaction
			Long tid = lowLevelInterface.startTransaction(newProject.getOid());
			
			Long ifcRelAssignsToGroupOid = lowLevelInterface.createObject(tid, "IfcRelAssignsToGroup", true);
			Long ifcFurnishingElement1Oid = lowLevelInterface.createObject(tid, "IfcFurnishingElement", true);
			Long ifcFurnishingElement2Oid = lowLevelInterface.createObject(tid, "IfcFurnishingElement", true);

			lowLevelInterface.addReference(tid, ifcRelAssignsToGroupOid, "RelatedObjects", ifcFurnishingElement1Oid);
			lowLevelInterface.addReference(tid, ifcRelAssignsToGroupOid, "RelatedObjects", ifcFurnishingElement2Oid);
			
			lowLevelInterface.commitTransaction(tid, "Initial", false);
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			
			List<Long> references = lowLevelInterface.getReferences(tid, ifcRelAssignsToGroupOid, "RelatedObjects");
			assertEquals("Number of references", 2, references.size());
			
			lowLevelInterface.removeReferenceByOid(tid, ifcRelAssignsToGroupOid, "RelatedObjects", ifcFurnishingElement1Oid);
			lowLevelInterface.commitTransaction(tid, "2", false);
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			references = lowLevelInterface.getReferences(tid, ifcRelAssignsToGroupOid, "RelatedObjects");
			assertEquals("Number of references", 1, references.size());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}