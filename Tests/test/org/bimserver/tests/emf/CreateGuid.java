package org.bimserver.tests.emf;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class CreateGuid extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClient bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the service interface
			ServiceInterface serviceInterface = bimServerClient.getServiceInterface();
			
			// Create a new project
			SProject newProject = serviceInterface.addProject("test" + Math.random());
			
			ClientIfcModel model = bimServerClient.newModel(newProject);
			IfcFurnishingElement furnishing = model.create(Ifc2x3tc1Package.eINSTANCE.getIfcFurnishingElement());
			furnishing.setGlobalId("0uyjn9Jan3nRq36Uj6gwws");
			
			long roid = model.commit("Initial model");

			ClientIfcModel newModel = bimServerClient.getModel(newProject.getOid(), roid, true);
			List<IfcFurnishingElement> furnishingElements = newModel.getAllWithSubTypes(Ifc2x3tc1Package.eINSTANCE.getIfcFurnishingElement());
			assertTrue(furnishingElements.size() == 1);
			IfcFurnishingElement newF = furnishingElements.get(0);
			assertTrue(newF.getGlobalId().equals("0uyjn9Jan3nRq36Uj6gwws"));
		} catch (Throwable e) {
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}
}