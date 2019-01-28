package org.bimserver.tests.ifc;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import static org.junit.Assert.fail;

import java.net.URL;
import java.nio.file.Paths;

import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.Flow;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Assert;
import org.junit.Test;

public class TestJapaneseChars extends TestWithEmbeddedServer {
	private BimServerClientInterface bimServerClient;

	// TODO actually test the results, and not only whether it generates exceptions
	
	@Test
	public void test() {
		try {
			bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			test(new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/japanesechars/ac16_sjis.ifc"), null);
			test(new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/japanesechars/ac16_unicode.ifc"), null);
			test(new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/japanesechars/revit2013_unicode.ifc"), "FILE_NAME.name is not an optional field, but $ used");
			test(new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/japanesechars/revit2013_unicode_fixed.ifc"), null);
			test(new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/japanesechars/revit2014_unicode.ifc"), null);
			test(new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/japanesechars/vectorworks_sjis.ifc"), null);
			test(new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/japanesechars/vectorworks_unicode.ifc"), null);
		} catch (Throwable e) {
			e.printStackTrace();
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}
	
	public void test(URL url, String expectedMessage) {
		try {
			SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			// Find a deserializer to use
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());
			
			bimServerClient.checkinSync(newProject.getOid(), "initial", deserializer.getOid(), false, url);
			
			newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());
			SSerializerPluginConfiguration serializer = bimServerClient.getServiceInterface().getSerializerByContentType("application/ifc");
			bimServerClient.download(newProject.getLastRevisionId(), serializer.getOid(), Paths.get("bimserver_" + url.getFile().substring(url.getFile().lastIndexOf("/") + 1)));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertEquals(expectedMessage, e.getMessage());
		}
	}
}
