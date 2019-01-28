package org.bimserver.tests.emf;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.nio.file.Paths;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestRemoveReferenceList extends TestWithEmbeddedServer {
	
	// This test makes no sense, since getContainedInStructure is a Set (unordered)
	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the service interface
			bimServerClient.getSettingsInterface().setGenerateGeometryOnCheckin(false);

			// Create a new project
			SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
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
			newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());

			bimServerClient.download(newProject.getLastRevisionId(), bimServerClient.getServiceInterface().getSerializerByContentType("application/ifc").getOid(), Paths.get("testX.ifc"));

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
			newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());
			model = bimServerClient.getModel(newProject, newProject.getLastRevisionId(), true, false);
			for (IfcFurnishingElement ifcFurnishingElement : model.getAll(IfcFurnishingElement.class)) {
				assertTrue("Size should be 2, is " + ifcFurnishingElement.getContainedInStructure().size(), ifcFurnishingElement.getContainedInStructure().size() == 2);
				assertEquals("link", "link1", ifcFurnishingElement.getContainedInStructure().get(0).getName());
				assertEquals("link", "link3", ifcFurnishingElement.getContainedInStructure().get(1).getName());
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