package org.bimserver.tests.lowlevel;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class TestCreateListsLowLevelCalls extends TestWithEmbeddedServer {

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
			
			Long cartesianPointOid = lowLevelInterface.createObject(tid, "IfcCartesianPoint");
			
			double firstVal = 5.1;
			lowLevelInterface.addDoubleAttribute(tid, cartesianPointOid, "Coordinates", firstVal);
			double secondVal = 6.2;
			lowLevelInterface.addDoubleAttribute(tid, cartesianPointOid, "Coordinates", secondVal);
			double thirdVal = 7.3;
			lowLevelInterface.addDoubleAttribute(tid, cartesianPointOid, "Coordinates", thirdVal);
			
			// Commit the transaction
			lowLevelInterface.commitTransaction(tid, "test");

			tid = lowLevelInterface.startTransaction(newProject.getOid());
			List<Double> coordinates = lowLevelInterface.getDoubleAttributes(tid, cartesianPointOid, "Coordinates");
			assertTrue(coordinates.get(0) == firstVal && coordinates.get(1) == secondVal && coordinates.get(2) == thirdVal);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}