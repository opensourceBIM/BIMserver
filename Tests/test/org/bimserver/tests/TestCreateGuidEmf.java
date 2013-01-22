package org.bimserver.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.eclipse.jdt.internal.codeassist.ThrownExceptionFinder;
import org.junit.Test;

public class TestCreateGuidEmf extends TestWithEmbeddedServer {

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
			IfcGloballyUniqueId guid = model.create(Ifc2x3tc1Package.eINSTANCE.getIfcGloballyUniqueId());
			guid.setWrappedValue("0uyjn9Jan3nRq36Uj6gwws");
			furnishing.setGlobalId(guid);
			
			long roid = model.commit("Initial model");

			ClientIfcModel newModel = bimServerClient.getModel(newProject.getOid(), roid, true);
			List<IfcFurnishingElement> furnishingElements = newModel.getAllWithSubTypes(Ifc2x3tc1Package.eINSTANCE.getIfcFurnishingElement());
			assertTrue(furnishingElements.size() == 1);
			IfcFurnishingElement newF = furnishingElements.get(0);
			assertTrue(newF.getGlobalId().getWrappedValue().equals("0uyjn9Jan3nRq36Uj6gwws"));
		} catch (Throwable e) {
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}
}