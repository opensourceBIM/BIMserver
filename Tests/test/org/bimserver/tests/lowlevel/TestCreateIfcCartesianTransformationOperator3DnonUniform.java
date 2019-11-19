package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.ifc2x3tc1.IfcCartesianTransformationOperator3DnonUniform;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Assert;
import org.junit.Test;

public class TestCreateIfcCartesianTransformationOperator3DnonUniform extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			LowLevelInterface lowLevelInterface = bimServerClient.getLowLevelInterface();
			
			// Create a new project
			SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Look for a deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());
			
			// Checkin file
			bimServerClient.checkinSync(newProject.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/export1.ifc"));

			newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());

			IfcModelInterface model = bimServerClient.getModel(newProject, newProject.getLastRevisionId(), true, false);
			long originalSize = model.size();
			
			// Start a transaction
			Long tid = lowLevelInterface.startTransaction(newProject.getOid());
			
			Long oid = lowLevelInterface.createObject(tid, "IfcCartesianTransformationOperator3DnonUniform", false);
			
			double value1 = 1D;
			lowLevelInterface.setDoubleAttribute(tid, oid, "Scale", value1);
			double value2 = 2D;
			lowLevelInterface.setDoubleAttribute(tid, oid, "Scale2", value2);
			double value3 = 1D;
			lowLevelInterface.setDoubleAttribute(tid, oid, "Scale3", value3);
			
			// Commit the transaction
			lowLevelInterface.commitTransaction(tid, "test", false);

			tid = lowLevelInterface.startTransaction(newProject.getOid());
			Assert.assertEquals(lowLevelInterface.getDoubleAttribute(tid, oid, "Scale"), value1, 0.01d);
			Assert.assertEquals(lowLevelInterface.getDoubleAttribute(tid, oid, "Scale2"), value2, 0.01d);
			Assert.assertEquals(lowLevelInterface.getDoubleAttribute(tid, oid, "Scale3"), value3, 0.01d);
			
			newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());
			
			model = bimServerClient.getModel(newProject, newProject.getLastRevisionId(), true, false);
			Assert.assertEquals(originalSize + 1, model.size());
			Assert.assertEquals(1, model.getAllWithSubTypes(IfcCartesianTransformationOperator3DnonUniform.class).size());
			
			SSerializerPluginConfiguration serializer = bimServerClient.getServiceInterface().getSerializerByContentType("application/ifc");
			try (FileOutputStream fos = new FileOutputStream(new File("output.ifc"))) {
				bimServerClient.download(newProject.getLastRevisionId(), serializer.getOid(), fos);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}