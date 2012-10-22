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

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.bimserver.BimServer;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.BimServerClientException;
import org.bimserver.client.ConnectionException;
import org.bimserver.client.Session;
import org.bimserver.combined.LocalDevBimCombinedServerStarter;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifc.step.serializer.IfcStepSerializer;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevisionSummary;
import org.bimserver.interfaces.objects.SRevisionSummaryContainer;
import org.bimserver.interfaces.objects.SRevisionSummaryType;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestClientEmfModelLocal {
	private Session session;
	private BimServerClient bimServerClient;
	private static BimServer bimServer;

	@BeforeClass
	public static void setup() {
		try {
			File home = new File("home");
			if (home.isDirectory()) {
				FileUtils.deleteDirectory(home);
			}

			LocalDevBimCombinedServerStarter localDevBimWebServerStarter = new LocalDevBimCombinedServerStarter();
			localDevBimWebServerStarter.start("localhost", 8082);
			bimServer = localDevBimWebServerStarter.getBimServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void shutdown() {
		// bimServer.stop();
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
		bimServerClient = new BimServerClient("", null);
		try {
			UsernamePasswordAuthenticationInfo usernamePasswordAuthenticationInfo = new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin");
			bimServerClient.setAuthentication(usernamePasswordAuthenticationInfo);
			bimServerClient.connectProtocolBuffers("localhost", 8020);
		} catch (ConnectionException e1) {
			e1.printStackTrace();
		}
		try {
			session = bimServerClient.createSession();
			int pid = createProject();
			session.startTransaction(pid);
			CreateFromScratch createFromScratch = new CreateFromScratch();
			createFromScratch.createIfcProject(session);
			long roid = session.commitTransaction("tralala");

			dumpToFile(roid);
			
			session.startTransaction(pid);
			createFromScratch.createWall(session);
			roid = session.commitTransaction("test");
			
			dumpToFile(roid);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private void dumpToFile(long roid) throws SerializerException {
		try {
			IfcModelInterface model = bimServerClient.getModel(roid);
			IfcStepSerializer serializer = new IfcStepSerializer();
			serializer.init(model, null, bimServer.getPluginManager(), null);
			File output = new File("output");
			if (!output.exists()) {
				output.mkdir();
			}
			serializer.writeToFile(new File(output, roid + ".ifc"));
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		}
	}

	public void dumpSummary(long roid) throws ServiceException {
		SRevisionSummary revisionSummary = bimServerClient.getServiceInterface().getRevisionSummary(roid);
		List<SRevisionSummaryContainer> list = revisionSummary.getList();
		for (SRevisionSummaryContainer container : list) {
			System.out.println(container.getName());
			for (SRevisionSummaryType type : container.getTypes()) {
				System.out.println(type.getName() + ": " + type.getCount());
			}
		}
	}
}
