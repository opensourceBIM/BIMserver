package org.bimserver.tests.emf;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.nio.file.Paths;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class RemoveReferenceList extends TestWithEmbeddedServer {
	
	// This test makes no sense, since getContainedInStructure is a Set (unordered)
	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the service interface
			bimServerClient.getSettingsInterface().setGenerateGeometryOnCheckin(false);

			// Create a new project
			SProject newProject = bimServerClient.getBimsie1ServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			IfcModelInterface model = bimServerClient.newModel(newProject, true);
			
			IfcFurnishingElement furnishingElement = model.create(IfcFurnishingElement.class);
			furnishingElement.setName("Furnishing 1");
			
			IfcRelContainedInSpatialStructure link1 = model.create(IfcRelContainedInSpatialStructure.class);
			link1.setName("link1");
			IfcRelContainedInSpatialStructure link2 = model.create(IfcRelContainedInSpatialStructure.class);
			link2.setName("link2");
			IfcRelContainedInSpatialStructure link3 = model.create(IfcRelContainedInSpatialStructure.class);
			link3.setName("link3");

			link1.getRelatedElements().add(furnishingElement);
			link2.getRelatedElements().add(furnishingElement);
			link3.getRelatedElements().add(furnishingElement);
			
			model.commit("initial");
			
			// refresh
			newProject = bimServerClient.getBimsie1ServiceInterface().getProjectByPoid(newProject.getOid());

			bimServerClient.download(newProject.getLastRevisionId(), bimServerClient.getBimsie1ServiceInterface().getSerializerByContentType("application/ifc").getOid(), Paths.get("testX.ifc"));

			model = bimServerClient.getModel(newProject, newProject.getLastRevisionId(), true, true);
			for (IfcFurnishingElement ifcFurnishingElement : model.getAll(IfcFurnishingElement.class)) {
				if (ifcFurnishingElement.getContainedInStructure().size() != 3) {
					fail("Size should be 3, is " + ifcFurnishingElement.getContainedInStructure().size());
				}
				// Remove the middle one
				IfcRelContainedInSpatialStructure middleOne = null;
				for (IfcRelContainedInSpatialStructure rel : ifcFurnishingElement.getContainedInStructure()) {
					if (rel.getName().equals("link2")) {
						middleOne = rel;
						break;
					}
				}
				ifcFurnishingElement.getContainedInStructure().remove(middleOne);
			}
			
			model.commit("removed middle link");
			
			// refresh
			newProject = bimServerClient.getBimsie1ServiceInterface().getProjectByPoid(newProject.getOid());
			model = bimServerClient.getModel(newProject, newProject.getLastRevisionId(), true, false);
			for (IfcFurnishingElement ifcFurnishingElement : model.getAll(IfcFurnishingElement.class)) {
				assertTrue("Size should be 2, is " + ifcFurnishingElement.getContainedInStructure().size(), ifcFurnishingElement.getContainedInStructure().size() == 2);
				if (!ifcFurnishingElement.getContainedInStructure().get(0).getName().equals("link1")) {
					fail("First one should be link 1");
				}
				if (!ifcFurnishingElement.getContainedInStructure().get(1).getName().equals("link3")) {
					fail("Second one should be link 3");
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