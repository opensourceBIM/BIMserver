package org.bimserver.tests.emf;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class CreateGuid extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a new project
			SProject newProject = bimServerClient.getBimsie1ServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			IfcModelInterface model = bimServerClient.newModel(newProject, true);
			IfcFurnishingElement furnishing = model.create(Ifc2x3tc1Package.eINSTANCE.getIfcFurnishingElement());
			furnishing.setGlobalId("0uyjn9Jan3nRq36Uj6gwws");
			
			long roid = model.commit("Initial model");

			IfcModelInterface newModel = bimServerClient.getModel(newProject, roid, true, false);
			List<IfcFurnishingElement> furnishingElements = newModel.getAllWithSubTypes(Ifc2x3tc1Package.eINSTANCE.getIfcFurnishingElement());
			assertTrue("There must be 1 furnishing element, not " + furnishingElements.size(), furnishingElements.size() == 1);
			IfcFurnishingElement newF = furnishingElements.get(0);
			assertTrue("GUID must be 0uyjn9Jan3nRq36Uj6gwws", newF.getGlobalId().equals("0uyjn9Jan3nRq36Uj6gwws"));
		} catch (Throwable e) {
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}
}