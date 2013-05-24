package org.bimserver.tests.emf;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.List;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class LoadCompleteModel extends TestWithEmbeddedServer {

	@Test
	public void start() {
		try {
			// New client
			BimServerClient bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a project
			SProject project = bimServerClient.getServiceInterface().addProject("test" + Math.random());
			
			// Look for a deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc");
			
			// Checkin file
			bimServerClient.checkin(project.getOid(), "test", deserializer.getOid(), false, true, new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc"));
			
			// Refresh project
			project = bimServerClient.getServiceInterface().getProjectByPoid(project.getOid());
			
			// Load model without lazy loading (complete model at once)
			ClientIfcModel model = bimServerClient.getModel(project.getOid(), project.getLastRevisionId(), false);

			// Change the window names
			for (IfcWindow window : model.getAllWithSubTypes(IfcWindow.class)) {
				window.setName(window.getName() + " Changed");
			}
			long newRoid = model.commit("Changed window names");
			
			ClientIfcModel newModel = bimServerClient.getModel(project.getOid(), newRoid, true);
			List<IfcWindow> windows = newModel.getAllWithSubTypes(Ifc2x3tc1Package.eINSTANCE.getIfcWindow());
			for (IfcWindow window : windows) {
				assertTrue(window.getName().endsWith(" Changed"));
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}