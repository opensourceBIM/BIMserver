package org.bimserver.tests.lowlevel;

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

import static org.junit.Assert.fail;

import java.net.URL;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.geometry.Vector3f;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.Flow;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Assert;
import org.junit.Test;

public class TestGeometry extends TestWithEmbeddedServer {
	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the low level interface
			LowLevelInterface lowLevelInterface = bimServerClient.getLowLevelInterface();
			
			// Create a new project
			SProject project = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Look for a deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
			
			// Checkin file
			
			long start = System.nanoTime();
			bimServerClient.checkinSync(project.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/AC11-Institute-Var-2-IFC.ifc"));
//			bimServerClient.checkin(project.getOid(), "test", deserializer.getOid(), false, Flow.SYNC, Paths.get("D:\\Dropbox\\Shared\\IFC files\\ArenA 2014\\3D IFC\\arena.ifc"));
			long end = System.nanoTime();
			
			System.out.println(((end - start) / 1000000) + " ms");
			
			// Refresh project
			project = bimServerClient.getServiceInterface().getProjectByPoid(project.getOid());
			
			int nrTriangles = 0;

			// Load model without lazy loading (complete model at once)
			IfcModelInterface model = bimServerClient.getModel(project, project.getLastRevisionId(), true, true, true);
			
			Assert.assertNotNull(model.getModelMetaData().getMinBounds());
			Assert.assertNotNull(model.getModelMetaData().getMaxBounds());
			
			for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
				GeometryInfo geometryInfo = ifcProduct.getGeometry();
				if (geometryInfo != null) {
					Vector3f minBounds = geometryInfo.getBounds().getMin();
					Vector3f maxBounds = geometryInfo.getBounds().getMax();
					Assert.assertNotNull(minBounds);
					Assert.assertNotNull(maxBounds);
					nrTriangles += geometryInfo.getPrimitiveCount();
				}
			}
			Assert.assertEquals(45260, nrTriangles);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}