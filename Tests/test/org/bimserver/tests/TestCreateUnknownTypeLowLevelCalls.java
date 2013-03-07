package org.bimserver.tests;

import static org.junit.Assert.fail;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.junit.Test;

public class TestCreateUnknownTypeLowLevelCalls extends TestWithEmbeddedServer {

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
			
			Long cartesianPointOid = serviceInterface.createObject(tid, "IfcCartesionPoint"); // IfcCartesi(O)nPoint
			
			// Commit the transaction
			serviceInterface.commitTransaction(tid, "test");
		} catch (Exception e) {
			if (e instanceof UserException) {
				
			} else {
				e.printStackTrace();
				fail(e.getMessage());
			}
		}
	}
}