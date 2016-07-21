package org.bimserver.tests.ifc;

import static org.junit.Assert.fail;

import java.io.File;
import java.nio.file.Paths;

import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.Flow;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class TestJapaneseChars extends TestWithEmbeddedServer {
	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a new project
			SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Find a deserializer to use
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());

			File[] files = new File[]{
				new File("../TestData/data/ac16_sjis.ifc"),
				new File("../TestData/data/ac16_unicode.ifc"),
				new File("../TestData/data/revit2013_unicode.ifc"),
				new File("../TestData/data/revit2014_unicode.ifc"),
				new File("../TestData/data/vectorworks_sjis.ifc"),
				new File("../TestData/data/vectorworks_unicode.ifc"),
			};
			
			for (File file : files) {
				bimServerClient.checkin(newProject.getOid(), "initial", deserializer.getOid(), false, Flow.SYNC, Paths.get("../TestData/data/revit2013_unicode.ifc"));
				newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());
				SSerializerPluginConfiguration serializer = bimServerClient.getServiceInterface().getSerializerByContentType("application/ifc");
				bimServerClient.download(newProject.getLastRevisionId(), serializer.getOid(), Paths.get("bimserver_" + file.getName()));
			}
		} catch (Throwable e) {
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}
}
