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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestCreateReferenceListsAndClear extends TestWithEmbeddedServer {

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
			
			Long ifcShapeRepresentationOid = lowLevelInterface.createObject(tid, "IfcShapeRepresentation", false);
			
			long ifcRepresentationItem1 = lowLevelInterface.createObject(tid, "IfcStyledItem", false);
			long ifcRepresentationItem2 = lowLevelInterface.createObject(tid, "IfcMappedItem", false);
			long ifcRepresentationItem3 = lowLevelInterface.createObject(tid, "IfcGeometricRepresentationItem", false);
			
			lowLevelInterface.addReference(tid, ifcShapeRepresentationOid, "Items", ifcRepresentationItem1);
			lowLevelInterface.addReference(tid, ifcShapeRepresentationOid, "Items", ifcRepresentationItem2);
			lowLevelInterface.addReference(tid, ifcShapeRepresentationOid, "Items", ifcRepresentationItem3);
			
			// Commit the transaction
			lowLevelInterface.commitTransaction(tid, "test", false);

			tid = lowLevelInterface.startTransaction(newProject.getOid());
			List<Long> itemOids = lowLevelInterface.getReferences(tid, ifcShapeRepresentationOid, "Items");
			assertTrue(itemOids.get(0) == ifcRepresentationItem1 && itemOids.get(1) == ifcRepresentationItem2 && itemOids.get(2) == ifcRepresentationItem3);
			
			lowLevelInterface.removeAllReferences(tid, ifcShapeRepresentationOid, "Items");
			
			lowLevelInterface.commitTransaction(tid, "removed all references", false);
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			
			itemOids = lowLevelInterface.getReferences(tid, ifcShapeRepresentationOid, "Items");
			assertTrue(itemOids.size() == 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}