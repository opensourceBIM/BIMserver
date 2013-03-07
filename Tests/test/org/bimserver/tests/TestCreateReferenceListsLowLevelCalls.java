package org.bimserver.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.junit.Test;

public class TestCreateReferenceListsLowLevelCalls extends TestWithEmbeddedServer {

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
			
			Long ifcShapeRepresentationOid = serviceInterface.createObject(tid, "IfcShapeRepresentation");
			
			long ifcRepresentationItem1 = serviceInterface.createObject(tid, "IfcStyledItem");
			long ifcRepresentationItem2 = serviceInterface.createObject(tid, "IfcMappedItem");
			long ifcRepresentationItem3 = serviceInterface.createObject(tid, "IfcGeometricRepresentationItem");
			
			serviceInterface.addReference(tid, ifcShapeRepresentationOid, "Items", ifcRepresentationItem1);
			serviceInterface.addReference(tid, ifcShapeRepresentationOid, "Items", ifcRepresentationItem2);
			serviceInterface.addReference(tid, ifcShapeRepresentationOid, "Items", ifcRepresentationItem3);
			
			// Commit the transaction
			serviceInterface.commitTransaction(tid, "test");

			tid = serviceInterface.startTransaction(newProject.getOid());
			List<Long> itemOids = serviceInterface.getReferences(tid, ifcShapeRepresentationOid, "Items");
			assertTrue(itemOids.get(0) == ifcRepresentationItem1 && itemOids.get(1) == ifcRepresentationItem2 && itemOids.get(2) == ifcRepresentationItem3);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}