package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import java.io.File;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1LowLevelInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class SetString extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			bimServerClient.getSettingsInterface().setCacheOutputFiles(false);
			Bimsie1LowLevelInterface lowLevelInterface = bimServerClient.getBimsie1LowLevelInterface();
			
			SProject newProject = bimServerClient.getBimsie1ServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			SDeserializerPluginConfiguration suggestedDeserializerForExtension = bimServerClient.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());
			bimServerClient.checkin(newProject.getOid(), "initial", suggestedDeserializerForExtension.getOid(), false, true, new File("../TestData/data/WallOnly.ifc"));
			newProject = bimServerClient.getBimsie1ServiceInterface().getProjectByPoid(newProject.getOid());
			
			SSerializerPluginConfiguration serializer = bimServerClient.getBimsie1ServiceInterface().getSerializerByName("Ifc2x3");
			
			bimServerClient.download(newProject.getLastRevisionId(), serializer.getOid(), new File("test1.ifc"));

			IfcModelInterface model = bimServerClient.getModel(newProject, newProject.getLastRevisionId(), false, false);
			long tid = lowLevelInterface.startTransaction(newProject.getOid());
			
			IfcRoot wall = model.getByGuid("3Ep4r0uuX5ywPYOUG2H2A4");
			
			bimServerClient.getBimsie1LowLevelInterface().setStringAttribute(tid, wall.getOid(), "Name", "Test 12345");
			
			long roid = lowLevelInterface.commitTransaction(tid, "v2");
			
			bimServerClient.download(newProject.getLastRevisionId(), serializer.getOid(), new File("test2.ifc"));
			
			bimServerClient.download(roid, serializer.getOid(), new File("test3.ifc"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}