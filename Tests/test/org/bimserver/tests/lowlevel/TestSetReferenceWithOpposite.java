package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import java.util.List;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestSetReferenceWithOpposite extends TestWithEmbeddedServer {

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
			List<Long> references = lowLevelInterface.getReferences(tid, ifcBuildingOid, "ContainsElements");
			if (references.size() != 1) {
				fail("Should be 1");
			}
			if (!references.get(0).equals(ifcRelContainedInSpatialStructureOid)) {
				fail("Wrong " + references.get(0) + " / " + ifcRelContainedInSpatialStructureOid);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}