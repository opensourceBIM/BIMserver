package org.bimserver.tests;

import static org.junit.Assert.fail;

import java.io.File;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcWallStandardCase;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.junit.Test;

public class TestListWalls extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClient bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the service interface
			ServiceInterface serviceInterface = bimServerClient.getServiceInterface();
			
			// Create a new project
			SProject newProject = serviceInterface.addProject("test" + Math.random());
			
			// Get the appropriate deserializer
			SDeserializerPluginConfiguration deserializer = serviceInterface.getSuggestedDeserializerForExtension("ifc");

			// Checkin the file
			bimServerClient.checkin(newProject.getOid(), "test", deserializer.getOid(), false, true, new File("C:\\Users\\Ruben de Laat\\Downloads\\Jesse.1.ifc"));

			// Refresh project info
			newProject = serviceInterface.getProjectByPoid(newProject.getOid());

			ClientIfcModel model = bimServerClient.getModel(newProject.getOid(), newProject.getLastRevisionId(), true);
			for (IfcWallStandardCase wall : model.getAllWithSubTypes(IfcWallStandardCase.class)) {
				System.out.println(wall);
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