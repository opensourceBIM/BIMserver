package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import java.util.List;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1LowLevelInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class RemoveReferenceWithOpposite2 extends TestWithEmbeddedServer {

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
			
			Long ifcRelAssignsToGroupOid = lowLevelInterface.createObject(tid, "IfcRelAssignsToGroup", true);
			Long ifcFurnishingElement1Oid = lowLevelInterface.createObject(tid, "IfcFurnishingElement", true);
			Long ifcFurnishingElement2Oid = lowLevelInterface.createObject(tid, "IfcFurnishingElement", true);

			lowLevelInterface.addReference(tid, ifcRelAssignsToGroupOid, "RelatedObjects", ifcFurnishingElement1Oid);
			lowLevelInterface.addReference(tid, ifcRelAssignsToGroupOid, "RelatedObjects", ifcFurnishingElement2Oid);
			
			lowLevelInterface.commitTransaction(tid, "Initial");
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			lowLevelInterface.removeReferenceByOid(tid, ifcRelAssignsToGroupOid, "RelatedObjects", ifcFurnishingElement1Oid);
			lowLevelInterface.commitTransaction(tid, "2");
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			List<Long> references = lowLevelInterface.getReferences(tid, ifcFurnishingElement1Oid, "HasAssignments");
			if (references.size() != 1) {
				fail("References should be 1");
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}