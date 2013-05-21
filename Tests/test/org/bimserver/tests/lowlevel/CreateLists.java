package org.bimserver.tests.lowlevel;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class CreateLists extends TestWithEmbeddedServer {

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
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			ArrayList<Double> al = new ArrayList<Double>();
			al.add(1.0);
			al.add(2.0);
			al.add(3.0);
			lowLevelInterface.setDoubleAttributes(tid, cartesianPointOid, "Coordinates", al);
			lowLevelInterface.commitTransaction(tid, "replace");
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			coordinates = lowLevelInterface.getDoubleAttributes(tid, cartesianPointOid, "Coordinates");
			if (coordinates.size() != 3) {
				fail("Coordinates size should be 3, it is " + coordinates.size());
			}
			assertTrue(coordinates.get(0) == 1.0 && coordinates.get(1) == 2.0 && coordinates.get(2) == 3.0);
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			lowLevelInterface.setDoubleAttributeAtIndex(tid, cartesianPointOid, "Coordinates", 1, 5.0);
			lowLevelInterface.commitTransaction(tid, "changed middle one");
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			coordinates = lowLevelInterface.getDoubleAttributes(tid, cartesianPointOid, "Coordinates");
			if (coordinates.size() != 3) {
				fail("Coordinates size should be 3, it is " + coordinates.size());
			}
			assertTrue(coordinates.get(0) + ", " + coordinates.get(1) + ", " + coordinates.get(2), coordinates.get(0) == 1.0 && coordinates.get(1) == 5.0 && coordinates.get(2) == 3.0);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}