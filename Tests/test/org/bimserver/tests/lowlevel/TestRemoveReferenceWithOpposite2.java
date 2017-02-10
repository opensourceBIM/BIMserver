package org.bimserver.tests.lowlevel;

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
			
			lowLevelInterface.commitTransaction(tid, "Initial");
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			
			List<Long> references = lowLevelInterface.getReferences(tid, ifcRelAssignsToGroupOid, "RelatedObjects");
			assertEquals("Number of references", 2, references.size());
			
			lowLevelInterface.removeReferenceByOid(tid, ifcRelAssignsToGroupOid, "RelatedObjects", ifcFurnishingElement1Oid);
			lowLevelInterface.commitTransaction(tid, "2");
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			references = lowLevelInterface.getReferences(tid, ifcRelAssignsToGroupOid, "RelatedObjects");
			assertEquals("Number of references", 1, references.size());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}