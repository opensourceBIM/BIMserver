package org.bimserver.tests.ifc;

import static org.junit.Assert.fail;

import java.io.File;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class TestJapaneseChars extends TestWithEmbeddedServer {
	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClient bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the service interface
			ServiceInterface serviceInterface = bimServerClient.getServiceInterface();
			
			// Create a new project
			SProject newProject = serviceInterface.addProject("test" + Math.random());
			
			// Find a deserializer to use
			SDeserializerPluginConfiguration deserializer = bimServerClient.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc");

			File[] files = new File[]{
				new File("../TestData/data/ac16_sjis.ifc"),
				new File("../TestData/data/ac16_unicode.ifc"),
				new File("../TestData/data/revit2013_unicode.ifc"),
				new File("../TestData/data/revit2014_unicode.ifc"),
				new File("../TestData/data/vectorworks_sjis.ifc"),
				new File("../TestData/data/vectorworks_unicode.ifc"),
			};
			
			for (File file : files) {
				bimServerClient.checkin(newProject.getOid(), "initial", deserializer.getOid(), false, true, new File("../TestData/data/revit2013_unicode.ifc"));
				newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());
				SSerializerPluginConfiguration serializer = bimServerClient.getBimsie1ServiceInterface().getSerializerByContentType("application/ifc");
				bimServerClient.download(newProject.getLastRevisionId(), serializer.getOid(), new File("bimserver_" + file.getName()));
			}
		} catch (Throwable e) {
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}
}
