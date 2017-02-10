package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestIfcMeasureWithUnit extends TestWithEmbeddedServer {

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
			Long ifcMeasureWithUnitOid = lowLevelInterface.createObject(tid, "IfcMeasureWithUnit", false);
			lowLevelInterface.setWrappedDoubleAttribute(tid, ifcMeasureWithUnitOid, "ValueComponent", "IfcPlaneAngleMeasure", 0.12345);

			// Commit the transaction
			lowLevelInterface.commitTransaction(tid, "test");

			tid = lowLevelInterface.startTransaction(newProject.getOid());
			double v = lowLevelInterface.getDoubleAttribute(tid, ifcMeasureWithUnitOid, "ValueComponent");
			if (v != 0.12345) {
				fail("0.12345 expected, got " + v);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}