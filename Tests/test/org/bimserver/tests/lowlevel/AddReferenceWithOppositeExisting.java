package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ErrorCode;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1LowLevelInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class AddReferenceWithOppositeExisting extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			Bimsie1LowLevelInterface lowLevelInterface = bimServerClient.getBimsie1LowLevelInterface();
			
			// Create a new project
			SProject newProject = bimServerClient.getBimsie1ServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Start a transaction
			Long tid = lowLevelInterface.startTransaction(newProject.getOid());
			
			Long ifcRelContainedInSpatialStructureOid = lowLevelInterface.createObject(tid, "IfcRelContainedInSpatialStructure", true);
			Long ifcBuildingOid1 = lowLevelInterface.createObject(tid, "IfcBuilding", true);
			Long ifcBuildingOid2 = lowLevelInterface.createObject(tid, "IfcBuilding", true);
			lowLevelInterface.addReference(tid, ifcBuildingOid1, "ContainsElements", ifcRelContainedInSpatialStructureOid);
			
			lowLevelInterface.commitTransaction(tid, "Initial");
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			lowLevelInterface.addReference(tid, ifcBuildingOid2, "ContainsElements", ifcRelContainedInSpatialStructureOid);
			try {
				lowLevelInterface.commitTransaction(tid, "2");
			} catch (UserException e) {
				if (e.getErrorCode() != ErrorCode.SET_REFERENCE_FAILED_OPPOSITE_ALREADY_SET) {
					fail("Didn't get the right errormessage");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}