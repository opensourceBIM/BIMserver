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
import java.net.InetSocketAddress;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.bimserver.BimServer;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.client.notifications.SocketNotificationsClient;
import org.bimserver.combined.LocalDevBimCombinedServerStarter;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.meta.ServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestNotifications {
	private static BimServer bimServer;

	@BeforeClass
	public static void before() {
		try {
			File home = new File("home");
			if (home.isDirectory()) {
				FileUtils.deleteDirectory(home);
			}

			LocalDevBimCombinedServerStarter localDevBimWebServerStarter = new LocalDevBimCombinedServerStarter();
			localDevBimWebServerStarter.start("localhost", 80);
			bimServer = localDevBimWebServerStarter.getBimServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void after() {
		
	}
	
	@Test
	public void test() {
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
		try {
			ServicesMap servicesMap = new ServicesMap();
			servicesMap.add(new SService(FileUtils.readFileToString(new File("../Shared/src/org/bimserver/shared/NotificationInterface.java")), NotificationInterface.class));
			socketNotificationsClient.connect(servicesMap, new InetSocketAddress("localhost", 8055));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		socketNotificationsClient.start();
		
		BimServerClient bimServerClient = new BimServerClient("", null);
		try {
			bimServerClient.connectProtocolBuffers("localhost", 8020);
		} catch (ConnectionException e1) {
			e1.printStackTrace();
		}
		try {
			bimServerClient.getServiceInterface().login("admin@bimserver.org", "admin");
			//TODO
//			bimServerClient.getServiceInterface().setHttpCallback(bimServerClient.getServiceInterface().getCurrentUser().getOid(), "localhost:8055");
			bimServerClient.getServiceInterface().addProject("test12345");
		} catch (ServiceException e) {
			fail(e.getMessage());
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