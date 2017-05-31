package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import java.net.URL;
import java.nio.file.Paths;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.interfaces.objects.SVector3f;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.Flow;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

import junit.framework.Assert;

public class TestSetWrappedIntegerGeometry extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			bimServerClient.getSettingsInterface().setCacheOutputFiles(false);
			LowLevelInterface lowLevelInterface = bimServerClient.getLowLevelInterface();
			
			SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			SDeserializerPluginConfiguration suggestedDeserializerForExtension = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());
			bimServerClient.checkin(newProject.getOid(), "initial", suggestedDeserializerForExtension.getOid(), false, Flow.SYNC, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/revit_quantities.ifc"));
			newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());
			
			SSerializerPluginConfiguration serializer = bimServerClient.getServiceInterface().getSerializerByName("Ifc2x3tc1 (Streaming)");
			
			bimServerClient.download(newProject.getLastRevisionId(), serializer.getOid(), Paths.get("test1.ifc"));

			IfcModelInterface model = bimServerClient.getModel(newProject, newProject.getLastRevisionId(), false, false);
			long tid = lowLevelInterface.startTransaction(newProject.getOid());
			
			IfcPropertySingleValue ifcPropertySingleValue = model.getAll(IfcPropertySingleValue.class).iterator().next();

			bimServerClient.getLowLevelInterface().setWrappedLongAttribute(tid, ifcPropertySingleValue.getOid(), "NominalValue", "IfcInteger", 12345L);

			long roid = lowLevelInterface.commitTransaction(tid, "v2");
			
			IfcModelInterface newModel = bimServerClient.getModel(newProject, roid, true, false, true);
			SVector3f minBounds = newModel.getModelMetaData().getMinBounds();
			SVector3f maxBounds = newModel.getModelMetaData().getMaxBounds();
			
			org.junit.Assert.assertNotNull(minBounds);
			org.junit.Assert.assertNotNull(maxBounds);
			
			bimServerClient.download(newProject.getLastRevisionId(), serializer.getOid(), Paths.get("test2.ifc"));
			
			bimServerClient.download(roid, serializer.getOid(), Paths.get("test3.ifc"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}