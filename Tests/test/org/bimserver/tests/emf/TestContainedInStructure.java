package org.bimserver.tests.emf;

import static org.junit.Assert.fail;

import java.io.File;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class TestContainedInStructure extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClient bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the service interface
			ServiceInterface serviceInterface = bimServerClient.getServiceInterface();
			bimServerClient.getSettingsInterface().setGenerateGeometryOnCheckin(false);
			
			// Create a new project
			SProject newProject = serviceInterface.addProject("test" + Math.random());
			
			// Get the appropriate deserializer
			SDeserializerPluginConfiguration deserializer = serviceInterface.getSuggestedDeserializerForExtension("ifc");

			// Checkin the file
			bimServerClient.checkin(newProject.getOid(), "test", deserializer.getOid(), false, true, new File("../TestData/data/AC11-FZK-Haus-IFC.ifc"));

			// Refresh project info
			newProject = serviceInterface.getProjectByPoid(newProject.getOid());

			ClientIfcModel model = bimServerClient.getModel(newProject.getOid(), newProject.getLastRevisionId(), true);
			for (IfcFurnishingElement ifcFurnishingElement : model.getAllWithSubTypes(IfcFurnishingElement.class)) {
				System.out.println(ifcFurnishingElement);
				for (IfcRelContainedInSpatialStructure ifcRelContainedInSpatialStructure : ifcFurnishingElement.getContainedInStructure()) {
					System.out.println(ifcRelContainedInSpatialStructure.getRelatingStructure());
				}
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