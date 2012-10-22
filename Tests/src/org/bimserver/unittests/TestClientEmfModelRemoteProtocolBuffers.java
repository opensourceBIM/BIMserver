package org.bimserver.unittests;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import static org.junit.Assert.fail;

import java.util.Random;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.client.Session;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestClientEmfModelRemoteProtocolBuffers {
	private Session session;
	private static BimServerClient bimServerClient;

	@BeforeClass
	public static void setup() {
		bimServerClient = new BimServerClient("", null);
		try {
			UsernamePasswordAuthenticationInfo usernamePasswordAuthenticationInfo = new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin");
			bimServerClient.setAuthentication(usernamePasswordAuthenticationInfo);
			bimServerClient.connectProtocolBuffers("localhost", 8020);
		} catch (ConnectionException e1) {
			e1.printStackTrace();
		}
	}

	@AfterClass
	public static void shutdown() {
		bimServerClient.disconnect();
	}

	private int createProject() {
		try {
			SProject project = bimServerClient.getServiceInterface().addProject("Project " + new Random().nextInt());
			return project.getId();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Test
	public void test() {
		try {
			session = bimServerClient.createSession();
			int pid = createProject();
			session.startTransaction(pid);
			new CreateFromScratch().createIfcProject(session);
			session.commitTransaction("tralala");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}