package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import java.util.List;

import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestGetDataObjectsByType extends TestWithEmbeddedServer{

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
			Long wallOid = lowLevelInterface.createObject(tid, "IfcWall", true);
			Long relContainedInSpatialStructure = lowLevelInterface.createObject(tid, "IfcRelContainedInSpatialStructure", true);
			lowLevelInterface.addReference(tid, relContainedInSpatialStructure, "RelatedElements", wallOid);
			
			// Commit the transaction
			lowLevelInterface.commitTransaction(tid, "test");
			newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());

			List<SDataObject> dataObjectsByType = lowLevelInterface.getDataObjectsByType(newProject.getLastRevisionId(), "ifc2x3tc1", "IfcRelContainedInSpatialStructure", false);
			for (SDataObject sDataObject : dataObjectsByType) {
				System.out.println(sDataObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
