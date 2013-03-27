package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class TestCreateUnknownTypeLowLevelCalls extends TestWithEmbeddedServer {

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
			
			lowLevelInterface.createObject(tid, "IfcCartesionPoint"); // IfcCartesi(O)nPoint
			
			// Commit the transaction
			lowLevelInterface.commitTransaction(tid, "test");
		} catch (Exception e) {
			if (e instanceof UserException) {
				
			} else {
				e.printStackTrace();
				fail(e.getMessage());
			}
		}
	}
}