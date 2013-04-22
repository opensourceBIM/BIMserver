package org.bimserver.unittests;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
import java.net.InetSocketAddress;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.bimserver.LocalDevBimServerStarter;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.BimServerClientFactory;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.client.notifications.SocketNotificationsClient;
import org.bimserver.client.protocolbuffers.ProtocolBuffersBimServerClientFactory;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestNotifications {

	@BeforeClass
	public static void before() {
		try {
			File home = new File("home");
			if (home.isDirectory()) {
				FileUtils.deleteDirectory(home);
			}

			LocalDevBimServerStarter localDevBimWebServerStarter = new LocalDevBimServerStarter();
			localDevBimWebServerStarter.start("localhost", 80);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void after() {
	}
	
	@Test
	public void test() throws PublicInterfaceNotFoundException {
		final ProtocolBuffersMetaData protocolBuffersMetaData = new ProtocolBuffersMetaData();
		try {
			protocolBuffersMetaData.load(new File("../BimServerClientLib/src/service.desc"));
			protocolBuffersMetaData.load(new File("../BimServerClientLib/src/notification.desc"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		final CountDownLatch countDownLatch = new CountDownLatch(1);
		
		SocketNotificationsClient socketNotificationsClient = new SocketNotificationsClient();
//		NotificationInterfaceAdapter notificationInterfaceAdapter = new NotificationInterfaceAdapter() {
//			@Override
//			public void newProject(SNewProjectNotification newProjectNotification) throws ServiceException {
//				countDownLatch.countDown();
//			}
//		};
			SServicesMap servicesMap = new SServicesMap();
//			servicesMap.add(new SService(FileUtils.readFileToString(new File("../Shared/src/org/bimserver/shared/NotificationInterface.java")), NotificationInterface.class));
			socketNotificationsClient.connect(servicesMap, new InetSocketAddress("localhost", 8055));
		socketNotificationsClient.start();
		
		BimServerClientFactory factory = new ProtocolBuffersBimServerClientFactory("localhost", 8020, 8080);
		
		try {
			BimServerClient bimServerClient = factory.create();
			bimServerClient.getAuth().login("admin@bimserver.org", "admin");
			//TODO
//			bimServerClient.getServiceInterface().setHttpCallback(bimServerClient.getServiceInterface().getCurrentUser().getOid(), "localhost:8055");
			bimServerClient.getService().addProject("test12345");
		} catch (ServiceException e) {
			fail(e.getMessage());
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		}
		try {
			if (!countDownLatch.await(10, TimeUnit.SECONDS)) {
				fail("No notification received in time");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}