package org.bimserver.tests.ifc;

import static org.junit.Assert.fail;

import java.net.URL;
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
	// TODO actually test the results, and not only whether it generates exceptions
	
	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a new project
			SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Find a deserializer to use
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());

			URL[] urls = new URL[]{
				new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/japanesechars/ac16_sjis.ifc"),
				new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/japanesechars/ac16_unicode.ifc"),
				new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/japanesechars/revit2013_unicode.ifc"),
				new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/japanesechars/revit2014_unicode.ifc"),
				new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/japanesechars/vectorworks_sjis.ifc"),
				new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/japanesechars/vectorworks_unicode.ifc"),
			};
			
			for (URL url : urls) {
				bimServerClient.checkin(newProject.getOid(), "initial", deserializer.getOid(), false, Flow.SYNC, url);
				newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());
				SSerializerPluginConfiguration serializer = bimServerClient.getServiceInterface().getSerializerByContentType("application/ifc");
				bimServerClient.download(newProject.getLastRevisionId(), serializer.getOid(), Paths.get("bimserver_" + url.getFile()));
			}
		} catch (Throwable e) {
			e.printStackTrace();
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}
}
