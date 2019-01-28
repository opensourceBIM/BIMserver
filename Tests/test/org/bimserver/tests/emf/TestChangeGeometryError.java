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
import static org.junit.Assert.fail;

import java.net.URL;
import java.util.List;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.geometry.Buffer;
import org.bimserver.models.geometry.GeometryFactory;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.Flow;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestChangeGeometryError extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a new project
			SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Look for a deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());

			bimServerClient.checkinSync(newProject.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/AC11-Institute-Var-2-IFC.ifc"));

			newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());
			
			IfcModelInterface model = bimServerClient.getModel(newProject, newProject.getLastRevisionId(), false, true, true);
			List<IfcWall> walls = model.getAllWithSubTypes(Ifc2x3tc1Package.eINSTANCE.getIfcWall());
			IfcWall firstWall = walls.get(0);
			Buffer buffer = GeometryFactory.eINSTANCE.createBuffer();
			buffer.setData(new byte[10]);
			firstWall.getGeometry().getData().setVertices(buffer);

			model.commit("Tried to change geometry, which should not be possible");
			fail("This have thrown an error");
		} catch (Throwable e) {
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			e.printStackTrace();
			assertEquals("Only objects from the following schemas are allowed to be changed: Ifc2x3tc1 and IFC4, this object (GeometryData) is from the \"geometry\" package", e.getMessage());
		}
	}
}