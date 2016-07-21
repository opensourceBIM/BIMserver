package org.bimserver.unittests;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.bimserver.BimServer;
import org.bimserver.client.protocolbuffers.ProtocolBuffersBimServerClientFactory;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevisionSummary;
import org.bimserver.interfaces.objects.SRevisionSummaryContainer;
import org.bimserver.interfaces.objects.SRevisionSummaryType;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.utils.SerializerUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestClientEmfModelLocal {
	private BimServerClientInterface bimServerClient;
	private static BimServer bimServer;

	@BeforeClass
	public static void setup() {
		try {
			File home = new File("home");
			if (home.isDirectory()) {
				FileUtils.deleteDirectory(home);
			}

//			LocalDevBimServerStarter localDevBimWebServerStarter = new LocalDevBimServerStarter();
//			localDevBimWebServerStarter.start(1, "localhost", 8082, 8085, null);
//			bimServer = localDevBimWebServerStarter.getBimServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void shutdown() {
		// bimServer.stop();
	}

	private SProject createProject() throws PublicInterfaceNotFoundException {
		try {
			SProject project = bimServerClient.getServiceInterface().addProject("Project " + new Random().nextInt(), "ifc4");
			return project;
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Test
	public void test() {
		ProtocolBuffersMetaData protocolBuffersMetaData = new ProtocolBuffersMetaData();
		protocolBuffersMetaData.load(bimServer.getServicesMap(), ProtocolBuffersBimServerClientFactory.class);
		try {
			BimServerClientFactory factory = new ProtocolBuffersBimServerClientFactory("localhost", 8020, 8080, protocolBuffersMetaData, null, new SServicesMap());
			UsernamePasswordAuthenticationInfo usernamePasswordAuthenticationInfo = new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin");
			bimServerClient = factory.create(usernamePasswordAuthenticationInfo);
		} catch (ChannelConnectionException e1) {
			e1.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (BimServerClientException e) {
			e.printStackTrace();
		}
		try {
			IfcModelInterface model = bimServerClient.newModel(createProject(), false);
			SProject project = createProject();
			CreateFromScratch createFromScratch = new CreateFromScratch();
			createFromScratch.createIfcProject(model);
			long roid = model.commit("tralala");

			dumpToFile(project, roid);
			
			createFromScratch.createWall(model);
			roid = model.commit("test");
			
			dumpToFile(project, roid);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private void dumpToFile(SProject project, long roid) throws SerializerException {
		try {
			IfcModelInterface model = bimServerClient.getModel(project, roid, false, false);
			Serializer serializer = null;//new Ifc4StepSerializer(new PluginConfiguration());
			
			PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData("ifc2x3tc1");
			
			serializer.init(model, null, bimServer.getPluginManager(), false);
			Path output = Paths.get("output");
			if (!Files.exists(output)) {
				Files.createDirectory(output);
			}
			
			SerializerUtils.writeToFile(serializer, output.resolve(roid + ".ifc"));
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void dumpSummary(long roid) throws ServiceException, PublicInterfaceNotFoundException {
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
