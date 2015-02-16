package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import java.io.File;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1LowLevelInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class RemoveObject2 extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the service interface
			SSerializerPluginConfiguration serializer = bimServerClient.getBimsie1ServiceInterface().getSerializerByContentType("application/ifc");
			
			Bimsie1LowLevelInterface lowLevelInterface = bimServerClient.getBimsie1LowLevelInterface();
			
			// Create a new project
			SProject newProject = bimServerClient.getBimsie1ServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Start a transaction
			Long tid = lowLevelInterface.startTransaction(newProject.getOid());
			
			Long ifcRelContainedInSpatialStructureOid = lowLevelInterface.createObject(tid, "IfcRelContainedInSpatialStructure", true);
			Long ifcBuildingOid = lowLevelInterface.createObject(tid, "IfcBuilding", true);
			Long ifcWallOid = lowLevelInterface.createObject(tid, "IfcWall", true);
			lowLevelInterface.addReference(tid, ifcBuildingOid, "ContainsElements", ifcRelContainedInSpatialStructureOid);
			lowLevelInterface.addReference(tid, ifcRelContainedInSpatialStructureOid, "RelatedElements", ifcWallOid);
			
			Long newRoid = lowLevelInterface.commitTransaction(tid, "Initial");

			bimServerClient.download(newRoid, serializer.getOid(), new File("test1.ifc"));
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			lowLevelInterface.removeObject(tid, ifcWallOid);
			lowLevelInterface.removeObject(tid, ifcRelContainedInSpatialStructureOid);
			newRoid = lowLevelInterface.commitTransaction(tid, "removed");
			
			bimServerClient.download(newRoid, serializer.getOid(), new File("test2.ifc"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}