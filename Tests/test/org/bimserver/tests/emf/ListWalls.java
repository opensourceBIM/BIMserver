package org.bimserver.tests.emf;

import static org.junit.Assert.fail;

import java.nio.file.Paths;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcWallStandardCase;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class ListWalls extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a new project
			SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Get the appropriate deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());

			// Checkin the file
			bimServerClient.checkin(newProject.getOid(), "test", deserializer.getOid(), false, true, Paths.get("../TestData/data/Jesse.1.ifc"));

			// Refresh project info
			newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());

			IfcModelInterface model = bimServerClient.getModel(newProject, newProject.getLastRevisionId(), true, false);
			model.getAllWithSubTypes(IfcWallStandardCase.class);
		} catch (Throwable e) {
			e.printStackTrace();
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}
}