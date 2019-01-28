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

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Collections;

import org.apache.commons.io.IOUtils;
import org.bimserver.database.queries.om.DefaultQueries;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.test.TestWithEmbeddedServer;
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

			// Find a deserializer to use
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", mainProject.getOid());

			// Checkin
			bimServerClient.checkinSync(sub1.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/AC11-Institute-Var-2-IFC.ifc"));
			bimServerClient.checkinSync(sub2.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/AC90R1-niedriha-V2-2x3.ifc"));
			bimServerClient.checkinSync(sub3.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/AC11-FZK-Haus-IFC.ifc"));

			// Find a serializer
			SSerializerPluginConfiguration serializer = bimServerClient.getServiceInterface().getSerializerByContentType("application/ifc");

			// Get the project details
			mainProject = bimServerClient.getServiceInterface().getProjectByPoid(mainProject.getOid());

			// Download the latest revision (the one we just checked in)
//			Long topicId = bimServerClient.getServiceInterface().downloadByTypes(Collections.singleton(mainProject.getLastRevisionId()),
//					Collections.singleton("IfcWall"), serializer.getOid(), true, false, true, true);
			Long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(mainProject.getLastRevisionId()), DefaultQueries.allAsString(), serializer.getOid(), true);
			IOUtils.copy(bimServerClient.getDownloadData(topicId), new FileOutputStream(new File("out.ifc")));
			bimServerClient.getServiceInterface().cleanupLongAction(topicId);
			long e = System.nanoTime();
			System.out.println(((e - s) / 1000000) + " ms");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}