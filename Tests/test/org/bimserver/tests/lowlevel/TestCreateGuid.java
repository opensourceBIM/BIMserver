package org.bimserver.tests.lowlevel;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestCreateGuid extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the low level interface
			LowLevelInterface lowLevelInterface = bimServerClient.getLowLevelInterface();
			
			// Create a new project
			SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Start a transaction
			Long tid = lowLevelInterface.startTransaction(newProject.getOid());
			
			// Create furnishing
			Long furnishingOid = lowLevelInterface.createObject(tid, "IfcFurnishingElement", true);
			lowLevelInterface.setStringAttribute(tid, furnishingOid, "GlobalId", "0uyjn9Jan3nRq36Uj6gwws");
			
			// Commit the transaction
			lowLevelInterface.commitTransaction(tid, "test");

			tid = lowLevelInterface.startTransaction(newProject.getOid());
			assertTrue(lowLevelInterface.getStringAttribute(tid, furnishingOid, "GlobalId").equals("0uyjn9Jan3nRq36Uj6gwws"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}