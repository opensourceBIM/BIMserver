package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import java.util.List;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1LowLevelInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class GetDataObjectsByType extends TestWithEmbeddedServer{

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClient bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the low level interface
			Bimsie1LowLevelInterface lowLevelInterface = bimServerClient.getBimsie1LowLevelInterface();
			
			// Create a new project
			SProject newProject = bimServerClient.getBimsie1ServiceInterface().addProject("test" + Math.random());
			
			// Start a transaction
			Long tid = lowLevelInterface.startTransaction(newProject.getOid());
			
			// Create furnishing
			Long wallOid = lowLevelInterface.createObject(tid, "IfcWall");
			Long relContainedInSpatialStructure = lowLevelInterface.createObject(tid, "IfcRelContainedInSpatialStructure");
			lowLevelInterface.addReference(tid, relContainedInSpatialStructure, "RelatedElements", wallOid);
			
			// Commit the transaction
			lowLevelInterface.commitTransaction(tid, "test");
			newProject = bimServerClient.getBimsie1ServiceInterface().getProjectByPoid(newProject.getOid());

			List<SDataObject> dataObjectsByType = lowLevelInterface.getDataObjectsByType(newProject.getLastRevisionId(), "IfcRelContainedInSpatialStructure", false);
			for (SDataObject sDataObject : dataObjectsByType) {
				System.out.println(sDataObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
