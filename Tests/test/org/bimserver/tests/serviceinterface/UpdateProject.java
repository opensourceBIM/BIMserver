package org.bimserver.tests.serviceinterface;

import static org.junit.Assert.fail;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class UpdateProject extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a new project
			String originalName = "test " + Math.random();
			String newName = "test " + Math.random();
			SProject newProject = bimServerClient.getBimsie1ServiceInterface().addProject(originalName, "ifc2x3tc1");

			newProject.setName(newName);
			
			bimServerClient.getServiceInterface().updateProject(newProject);
			
			newProject = bimServerClient.getBimsie1ServiceInterface().getProjectByPoid(newProject.getOid());
			
			if (newProject.getName().equals(originalName)) {
				fail("Project name not updated");
			} else if (!newProject.getName().equals(newName)) {
				fail("Project name not updated to new name");
			}
		} catch (Throwable e) {
			e.printStackTrace();
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}
}