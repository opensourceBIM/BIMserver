package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import java.io.File;

import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1LowLevelInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class SetString extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			Bimsie1LowLevelInterface lowLevelInterface = bimServerClient.getBimsie1LowLevelInterface();
			
			// Create a new project
			SProject newProject = bimServerClient.getBimsie1ServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			
			SDeserializerPluginConfiguration suggestedDeserializerForExtension = bimServerClient.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());
			bimServerClient.checkin(newProject.getOid(), "initial", suggestedDeserializerForExtension.getOid(), false, true, new File("../TestData/data/export3.ifc"));
			newProject = bimServerClient.getBimsie1ServiceInterface().getProjectByPoid(newProject.getOid());
			
			long tid = lowLevelInterface.startTransaction(newProject.getOid());

//			IfcModelInterface model = bimServerClient.getModel(newProject, newProject.getLastRevisionId(), false, false);
			lowLevelInterface.commitTransaction(tid, "v2");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}