package org.bimserver.test;

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

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

public class TestNotification {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
//			SProject newProject = client.getServiceInterface().addProject("test" + Math.random());
//			SDeserializerPluginConfiguration deserializerByName = client.getServiceInterface().getDeserializerByName("IfcStepDeserializer");
//			client.checkin(newProject.getOid(), "test", deserializerByName.getOid(), false, true, new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc"));
//			newProject = client.getServiceInterface().getProjectByPoid(newProject.getOid());
			SProject project = client.getServiceInterface().getProjectByPoid(458753L);
			SSerializerPluginConfiguration geometrySerializer = client.getServiceInterface().getSerializerByName("JsonGeometrySerializer");
			
			for (int i=0; i<100; i++) {
//				final CountDownLatch countDownLatch = new CountDownLatch(1);
//				final Long downloadByTypes = client.getServiceInterface().downloadByTypes(Collections.singleton(project.getLastRevisionId()), "ifc2x3tc1", Collections.singleton("IfcWindow"), geometrySerializer.getOid(), true, false, false, false);
//				final ProgressHandler progressHandler = new ProgressHandler() {
//					@Override
//					public void progress(SLongActionState state) {
//						if (state.getProgress() == 100) {
//							countDownLatch.countDown();
//						}
//					}
//				};
//				client.getNotificationsManager().registerProgressHandler(downloadByTypes, progressHandler);
//				try {
//					countDownLatch.await(20, TimeUnit.SECONDS);
//					client.getNotificationsManager().unregisterProgressHandler(downloadByTypes, progressHandler);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
			
			client.disconnect();
			System.out.println("Done");
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}
