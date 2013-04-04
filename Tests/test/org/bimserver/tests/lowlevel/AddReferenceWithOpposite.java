package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class AddReferenceWithOpposite extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClient bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the service interface
			ServiceInterface serviceInterface = bimServerClient.getService();
			
			LowLevelInterface lowLevelInterface = bimServerClient.getLowLevel();
			
			// Create a new project
			SProject newProject = serviceInterface.addProject("test" + Math.random());
			
			// Start a transaction
			Long tid = lowLevelInterface.startTransaction(newProject.getOid());
			
			Long ifcRelContainedInSpatialStructureOid = lowLevelInterface.createObject(tid, "IfcRelContainedInSpatialStructure");
			Long ifcBuildingOid = lowLevelInterface.createObject(tid, "IfcBuilding");
			lowLevelInterface.addReference(tid, ifcBuildingOid, "ContainsElements", ifcRelContainedInSpatialStructureOid);
			
			lowLevelInterface.commitTransaction(tid, "Initial");
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			if (!lowLevelInterface.getReference(tid, ifcRelContainedInSpatialStructureOid, "RelatingStructure").equals(ifcBuildingOid)) {
				fail("Not the same");
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}