package org.bimserver.tests.serviceinterface;

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

import org.bimserver.interfaces.objects.SCompareType;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SModelComparePluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestCompare extends TestWithEmbeddedServer {

	@Test
	public void testIfc2x3tc1Guid() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a new project
			SProject newProject1 = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			SProject newProject2 = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Get the appropriate deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject1.getOid());
			SSerializerPluginConfiguration serializer = bimServerClient.getServiceInterface().getSerializerByName("Ifc2x3tc1");

			// Checkin the file
			bimServerClient.checkinSync(newProject1.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/compare_by_guid_rev_1.ifc"));
			bimServerClient.checkinSync(newProject2.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/compare_by_guid_rev_2.ifc"));
			
			newProject1 = bimServerClient.getServiceInterface().getProjectByPoid(newProject1.getOid());
			newProject2 = bimServerClient.getServiceInterface().getProjectByPoid(newProject2.getOid());
			
			SModelComparePluginConfiguration defaultModelCompare = bimServerClient.getPluginInterface().getModelCompareByName("GUID based");
			
			bimServerClient.getServiceInterface().compare(newProject1.getLastRevisionId(), newProject2.getLastRevisionId(), SCompareType.ALL, defaultModelCompare.getOid());
			Long topicId = bimServerClient.getServiceInterface().downloadCompareResults(serializer.getOid(), newProject1.getLastRevisionId(), newProject2.getLastRevisionId(), defaultModelCompare.getOid(), SCompareType.ALL, true);
			
			bimServerClient.saveDownloadData(topicId, Paths.get("tmptestdata/ifc2x3tc1guidcompare.ifc"));
		} catch (Throwable e) {
			e.printStackTrace();
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testIfc2x3tc1Name() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a new project
			SProject newProject1 = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			SProject newProject2 = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Get the appropriate deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject1.getOid());
			SSerializerPluginConfiguration serializer = bimServerClient.getServiceInterface().getSerializerByName("Ifc2x3tc1");

			// Checkin the file
			bimServerClient.checkinSync(newProject1.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/compare_by_guid_rev_1.ifc"));
			bimServerClient.checkinSync(newProject2.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/compare_by_guid_rev_2.ifc"));
			
			newProject1 = bimServerClient.getServiceInterface().getProjectByPoid(newProject1.getOid());
			newProject2 = bimServerClient.getServiceInterface().getProjectByPoid(newProject2.getOid());
			
			SModelComparePluginConfiguration defaultModelCompare = bimServerClient.getPluginInterface().getModelCompareByName("Name based");
			
			bimServerClient.getServiceInterface().compare(newProject1.getLastRevisionId(), newProject2.getLastRevisionId(), SCompareType.ALL, defaultModelCompare.getOid());
			Long topicId = bimServerClient.getServiceInterface().downloadCompareResults(serializer.getOid(), newProject1.getLastRevisionId(), newProject2.getLastRevisionId(), defaultModelCompare.getOid(), SCompareType.ALL, true);
			bimServerClient.saveDownloadData(topicId, Paths.get("tmptestdata/ifc2x3tc1namecompare.ifc"));
		} catch (Throwable e) {
			e.printStackTrace();
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}

	@Test
	public void testIfc4Guid() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a new project
			SProject newProject1 = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc4");
			SProject newProject2 = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc4");
			
			// Get the appropriate deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject1.getOid());
			SSerializerPluginConfiguration serializer = bimServerClient.getServiceInterface().getSerializerByName("Ifc4");
			
			// Checkin the file
			bimServerClient.checkinSync(newProject1.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/compare_by_name_rev_1.ifc"));
			bimServerClient.checkinSync(newProject2.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/compare_by_name_rev_2.ifc"));
			
			newProject1 = bimServerClient.getServiceInterface().getProjectByPoid(newProject1.getOid());
			newProject2 = bimServerClient.getServiceInterface().getProjectByPoid(newProject2.getOid());
			
			SModelComparePluginConfiguration defaultModelCompare = bimServerClient.getPluginInterface().getModelCompareByName("GUID based");
			
			bimServerClient.getServiceInterface().compare(newProject1.getLastRevisionId(), newProject2.getLastRevisionId(), SCompareType.ALL, defaultModelCompare.getOid());
			long topicId = bimServerClient.getServiceInterface().downloadCompareResults(serializer.getOid(), newProject1.getLastRevisionId(), newProject2.getLastRevisionId(), defaultModelCompare.getOid(), SCompareType.ALL, true);
			bimServerClient.saveDownloadData(topicId, Paths.get("tmptestdata/ifc4guidcompare.ifc"));
		} catch (Throwable e) {
			e.printStackTrace();
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}

	@Test
	public void testIfc4Name() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a new project
			SProject newProject1 = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc4");
			SProject newProject2 = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc4");
			
			// Get the appropriate deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject1.getOid());
			SSerializerPluginConfiguration serializer = bimServerClient.getServiceInterface().getSerializerByName("Ifc4");
			
			// Checkin the file
			bimServerClient.checkinSync(newProject1.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/compare_by_name_rev_1.ifc"));
			bimServerClient.checkinSync(newProject2.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/compare_by_name_rev_2.ifc"));
			
			newProject1 = bimServerClient.getServiceInterface().getProjectByPoid(newProject1.getOid());
			newProject2 = bimServerClient.getServiceInterface().getProjectByPoid(newProject2.getOid());
			
			SModelComparePluginConfiguration defaultModelCompare = bimServerClient.getPluginInterface().getModelCompareByName("Name based");
			
			bimServerClient.getServiceInterface().compare(newProject1.getLastRevisionId(), newProject2.getLastRevisionId(), SCompareType.ALL, defaultModelCompare.getOid());
			long topicId = bimServerClient.getServiceInterface().downloadCompareResults(serializer.getOid(), newProject1.getLastRevisionId(), newProject2.getLastRevisionId(), defaultModelCompare.getOid(), SCompareType.ALL, true);
			bimServerClient.saveDownloadData(topicId, Paths.get("tmptestdata/ifc4namecompare.ifc"));
		} catch (Throwable e) {
			e.printStackTrace();
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}
}