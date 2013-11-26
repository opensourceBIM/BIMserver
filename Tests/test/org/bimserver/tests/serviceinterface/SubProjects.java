package org.bimserver.tests.serviceinterface;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class SubProjects extends TestWithEmbeddedServer {
	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));

			long s = System.nanoTime();
			// Create a new project
			SProject mainProject = bimServerClient.getBimsie1ServiceInterface().addProject("main" + Math.random());
			SProject sub1 = bimServerClient.getBimsie1ServiceInterface().addProjectAsSubProject("Sub1" + Math.random(), mainProject.getOid());
			SProject sub2 = bimServerClient.getBimsie1ServiceInterface().addProjectAsSubProject("Sub2" + Math.random(), mainProject.getOid());
			SProject sub3 = bimServerClient.getBimsie1ServiceInterface().addProjectAsSubProject("Sub3" + Math.random(), mainProject.getOid());

			// This is the file we will be checking in
			File ifcFile1 = new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc");
			File ifcFile2 = new File("../TestData/data/AC90R1-niedriha-V2-2x3.ifc");
			File ifcFile3 = new File("../TestData/data/AC11-FZK-Haus-IFC.ifc");

			// Find a deserializer to use
			SDeserializerPluginConfiguration deserializer = bimServerClient.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc");

			// Checkin
			bimServerClient.checkin(sub1.getOid(), "test", deserializer.getOid(), false, true, ifcFile1);
			bimServerClient.checkin(sub2.getOid(), "test", deserializer.getOid(), false, true, ifcFile2);
			bimServerClient.checkin(sub3.getOid(), "test", deserializer.getOid(), false, true, ifcFile3);

			// Find a serializer
			SSerializerPluginConfiguration serializer = bimServerClient.getBimsie1ServiceInterface().getSerializerByContentType("application/ifc");

			// Get the project details
			mainProject = bimServerClient.getBimsie1ServiceInterface().getProjectByPoid(mainProject.getOid());

			// Download the latest revision (the one we just checked in)
//			Long downloadId = bimServerClient.getBimsie1ServiceInterface().downloadByTypes(Collections.singleton(mainProject.getLastRevisionId()),
//					Collections.singleton("IfcWall"), serializer.getOid(), true, false, true, true);
			Long downloadId = bimServerClient.getBimsie1ServiceInterface().download(mainProject.getLastRevisionId(), serializer.getOid(), true, true);
			IOUtils.copy(bimServerClient.getDownloadData(downloadId, serializer.getOid()), new FileOutputStream(new File("out.ifc")));
			long e = System.nanoTime();
			System.out.println(((e - s) / 1000000) + " ms");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
