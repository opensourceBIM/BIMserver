package org.bimserver.tests.serviceinterface;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import org.apache.commons.io.IOUtils;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.Flow;
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
			SProject mainProject = bimServerClient.getServiceInterface().addProject("main" + Math.random(), "ifc2x3tc1");
			SProject sub1 = bimServerClient.getServiceInterface().addProjectAsSubProject("Sub1" + Math.random(), mainProject.getOid(), "ifc2x3tc1");
			SProject sub2 = bimServerClient.getServiceInterface().addProjectAsSubProject("Sub2" + Math.random(), mainProject.getOid(), "ifc2x3tc1");
			SProject sub3 = bimServerClient.getServiceInterface().addProjectAsSubProject("Sub3" + Math.random(), mainProject.getOid(), "ifc2x3tc1");

			// This is the file we will be checking in
			Path ifcFile1 = Paths.get("../TestData/data/AC11-Institute-Var-2-IFC.ifc");
			Path ifcFile2 = Paths.get("../TestData/data/AC90R1-niedriha-V2-2x3.ifc");
			Path ifcFile3 = Paths.get("../TestData/data/AC11-FZK-Haus-IFC.ifc");

			// Find a deserializer to use
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", mainProject.getOid());

			// Checkin
			bimServerClient.checkin(sub1.getOid(), "test", deserializer.getOid(), false, Flow.SYNC, ifcFile1);
			bimServerClient.checkin(sub2.getOid(), "test", deserializer.getOid(), false, Flow.SYNC, ifcFile2);
			bimServerClient.checkin(sub3.getOid(), "test", deserializer.getOid(), false, Flow.SYNC, ifcFile3);

			// Find a serializer
			SSerializerPluginConfiguration serializer = bimServerClient.getServiceInterface().getSerializerByContentType("application/ifc");

			// Get the project details
			mainProject = bimServerClient.getServiceInterface().getProjectByPoid(mainProject.getOid());

			// Download the latest revision (the one we just checked in)
//			Long topicId = bimServerClient.getServiceInterface().downloadByTypes(Collections.singleton(mainProject.getLastRevisionId()),
//					Collections.singleton("IfcWall"), serializer.getOid(), true, false, true, true);
			Long topicId = bimServerClient.getServiceInterface().downloadRevisions(Collections.singleton(mainProject.getLastRevisionId()), serializer.getOid(), true);
			IOUtils.copy(bimServerClient.getDownloadData(topicId, serializer.getOid()), new FileOutputStream(new File("out.ifc")));
			long e = System.nanoTime();
			System.out.println(((e - s) / 1000000) + " ms");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
