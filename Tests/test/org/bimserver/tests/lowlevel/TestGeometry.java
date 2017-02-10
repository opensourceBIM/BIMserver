package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import java.net.URL;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.geometry.GeometryInfo;
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
			bimServerClient.checkin(project.getOid(), "test", deserializer.getOid(), false, Flow.SYNC, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/AC11-Institute-Var-2-IFC.ifc"));
//			bimServerClient.checkin(project.getOid(), "test", deserializer.getOid(), false, Flow.SYNC, Paths.get("D:\\Dropbox\\Shared\\IFC files\\ArenA 2014\\3D IFC\\arena.ifc"));
			long end = System.nanoTime();
			
			System.out.println(((end - start) / 1000000) + " ms");
			
			// Refresh project
			project = bimServerClient.getServiceInterface().getProjectByPoid(project.getOid());
			
			int nrTriangles = 0;
			
			// Load model without lazy loading (complete model at once)
			IfcModelInterface model = bimServerClient.getModel(project, project.getLastRevisionId(), true, true);
			for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
				GeometryInfo geometryInfo = ifcProduct.getGeometry();
				if (geometryInfo != null) {
					nrTriangles += geometryInfo.getPrimitiveCount();
				}
			}
			Assert.assertEquals(45268, nrTriangles);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
