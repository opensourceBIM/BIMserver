package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestRemoveObject extends TestWithEmbeddedServer {

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
			
			Long ifcRelContainedInSpatialStructureOid = lowLevelInterface.createObject(tid, "IfcRelContainedInSpatialStructure", true);
			Long ifcBuildingOid = lowLevelInterface.createObject(tid, "IfcBuilding", true);
			lowLevelInterface.addReference(tid, ifcBuildingOid, "ContainsElements", ifcRelContainedInSpatialStructureOid);
			
			lowLevelInterface.commitTransaction(tid, "Initial");
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			lowLevelInterface.removeObject(tid, ifcBuildingOid);
			lowLevelInterface.commitTransaction(tid, "removed");
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			long reference = lowLevelInterface.getReference(tid, ifcRelContainedInSpatialStructureOid, "RelatingStructure");
			if (reference != -1) {
				fail("Should be unset (is " + reference + ")");
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}