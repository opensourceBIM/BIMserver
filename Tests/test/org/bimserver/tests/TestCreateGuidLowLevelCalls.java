package org.bimserver.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.junit.Test;

public class TestCreateGuidLowLevelCalls extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClient bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the service interface
			ServiceInterface serviceInterface = bimServerClient.getServiceInterface();
			
			// Create a new project
			SProject newProject = serviceInterface.addProject("test" + Math.random());
			
			// Start a transaction
			Long tid = serviceInterface.startTransaction(newProject.getOid());
			
			// Create a GUID object
			Long globalIdOid = serviceInterface.createObject(tid, "IfcGloballyUniqueId");
			serviceInterface.setStringAttribute(tid, globalIdOid, "wrappedValue", "0uyjn9Jan3nRq36Uj6gwws");
			
			// Create furnishing
			Long furnishingOid = serviceInterface.createObject(tid, "IfcFurnishingElement");
			serviceInterface.setReference(tid, furnishingOid, "GlobalId", globalIdOid);
			
			// Commit the transaction
			serviceInterface.commitTransaction(tid, "test");

			tid = serviceInterface.startTransaction(newProject.getOid());
			Long referenceOid = serviceInterface.getReference(tid, furnishingOid, "GlobalId");
			assertTrue(serviceInterface.getStringAttribute(tid, referenceOid, "wrappedValue").equals("0uyjn9Jan3nRq36Uj6gwws"));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}