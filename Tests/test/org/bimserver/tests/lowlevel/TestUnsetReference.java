package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestUnsetReference extends TestWithEmbeddedServer {

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
			lowLevelInterface.setReference(tid, ifcRelContainedInSpatialStructureOid, "RelatingStructure", ifcBuildingOid);
			
			lowLevelInterface.commitTransaction(tid, "Initial");
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			lowLevelInterface.unsetReference(tid, ifcRelContainedInSpatialStructureOid, "RelatingStructure");
			lowLevelInterface.commitTransaction(tid, "unset reference");
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			if (lowLevelInterface.getReference(tid, ifcRelContainedInSpatialStructureOid, "RelatingStructure") != -1) {
				fail("Relation should be unset");
			}
			lowLevelInterface.abortTransaction(tid);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}