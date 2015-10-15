package org.bimserver.tests.emf;

import static org.junit.Assert.fail;

import java.nio.file.Paths;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class ContainedInStructure extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the service interface
			bimServerClient.getSettingsInterface().setGenerateGeometryOnCheckin(false);
			
			// Create a new project
			SProject newProject = bimServerClient.getBimsie1ServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Get the appropriate deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());

			// Checkin the file
			bimServerClient.checkin(newProject.getOid(), "test", deserializer.getOid(), false, true, Paths.get("../TestData/data/AC11-FZK-Haus-IFC.ifc"));

			// Refresh project info
			newProject = bimServerClient.getBimsie1ServiceInterface().getProjectByPoid(newProject.getOid());

			IfcModelInterface model = bimServerClient.getModel(newProject, newProject.getLastRevisionId(), true, false);
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