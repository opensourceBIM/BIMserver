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

public class TestCreateReferenceListsLowLevelCalls extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClient bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the service interface
			ServiceInterface serviceInterface = bimServerClient.getServiceInterface();
			
			LowLevelInterface lowLevelInterface = bimServerClient.getLowLevelInterface();
			
			// Create a new project
			SProject newProject = serviceInterface.addProject("test" + Math.random());
			
			// Start a transaction
			Long tid = lowLevelInterface.startTransaction(newProject.getOid());
			
			Long ifcShapeRepresentationOid = lowLevelInterface.createObject(tid, "IfcShapeRepresentation");
			
			long ifcRepresentationItem1 = lowLevelInterface.createObject(tid, "IfcStyledItem");
			long ifcRepresentationItem2 = lowLevelInterface.createObject(tid, "IfcMappedItem");
			long ifcRepresentationItem3 = lowLevelInterface.createObject(tid, "IfcGeometricRepresentationItem");
			
			lowLevelInterface.addReference(tid, ifcShapeRepresentationOid, "Items", ifcRepresentationItem1);
			lowLevelInterface.addReference(tid, ifcShapeRepresentationOid, "Items", ifcRepresentationItem2);
			lowLevelInterface.addReference(tid, ifcShapeRepresentationOid, "Items", ifcRepresentationItem3);
			
			// Commit the transaction
			lowLevelInterface.commitTransaction(tid, "test");

			tid = lowLevelInterface.startTransaction(newProject.getOid());
			List<Long> itemOids = lowLevelInterface.getReferences(tid, ifcShapeRepresentationOid, "Items");
			assertTrue(itemOids.get(0) == ifcRepresentationItem1 && itemOids.get(1) == ifcRepresentationItem2 && itemOids.get(2) == ifcRepresentationItem3);
			
			lowLevelInterface.removeAllReferences(tid, ifcShapeRepresentationOid, "Items");
			
			lowLevelInterface.commitTransaction(tid, "removed all references");
			
			tid = lowLevelInterface.startTransaction(newProject.getOid());
			
			itemOids = lowLevelInterface.getReferences(tid, ifcShapeRepresentationOid, "Items");
			assertTrue(itemOids.size() == 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}