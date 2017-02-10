package org.bimserver.tests.emf;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.URL;
import java.util.List;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.Flow;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestLoadCompleteModel extends TestWithEmbeddedServer {

	@Test
	public void start() {
		try {
			// New client
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a project
			SProject project = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Look for a deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
			
			// Checkin file
			bimServerClient.checkin(project.getOid(), "test", deserializer.getOid(), false, Flow.SYNC, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/AC11-Institute-Var-2-IFC.ifc"));
			
			// Refresh project
			project = bimServerClient.getServiceInterface().getProjectByPoid(project.getOid());
			
			// Load model without lazy loading (complete model at once)
			IfcModelInterface model = bimServerClient.getModel(project, project.getLastRevisionId(), false, true);

			// Change the window names
			for (IfcWindow window : model.getAllWithSubTypes(IfcWindow.class)) {
				window.setName(window.getName() + " Changed");
			}
			long newRoid = model.commit("Changed window names");
			
			IfcModelInterface newModel = bimServerClient.getModel(project, newRoid, true, false);
			List<IfcWindow> windows = newModel.getAllWithSubTypes(Ifc2x3tc1Package.eINSTANCE.getIfcWindow());
			for (IfcWindow window : windows) {
				assertTrue(window.getName().endsWith(" Changed"));
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}