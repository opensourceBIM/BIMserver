package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import java.util.Random;

import org.bimserver.client.BimServerClient;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class UnsetReferenceWithOpposite extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClient bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the service interface
			ServiceInterface serviceInterface = bimServerClient.getService();
//			PluginInterface pluginInterface = bimServerClient.getPlugin();
			
			LowLevelInterface service = bimServerClient.getLowLevel();
			
			Long projectId = serviceInterface.addProject("PG-unsetReferenceTest" + new Random().nextInt()).getOid();
			Long transactionId = service.startTransaction(projectId);

			Long ifcRelContainedInSpatialStructureId = service.createObject(transactionId, "IfcRelContainedInSpatialStructure");
			Long ifcBuildingId = service.createObject(transactionId, "IfcBuilding");
			service.setReference(transactionId, ifcRelContainedInSpatialStructureId,"RelatingStructure", ifcBuildingId);

//			Long revisionId = service.commitTransaction(transactionId, "comment");
			
//			SSerializerPluginConfiguration serializerByPluginClassName = pluginInterface.getSerializerByPluginClassName("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin");
//			bimServerClient.download(revisionId, serializerByPluginClassName.getOid(), new File("1.ifc"));

//			transactionId = service.startTransaction(projectId);
//			service.unsetReference(transactionId, ifcRelContainedInSpatialStructureId, "RelatingStructure");
//			revisionId = service.commitTransaction(transactionId, "comment");

//			bimServerClient.download(revisionId, serializerByPluginClassName.getOid(), new File("2.ifc"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
