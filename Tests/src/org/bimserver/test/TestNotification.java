package org.bimserver.test;

import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ProgressHandler;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;

public class TestNotification {
	public static void main(String[] args) {
		JsonBimServerClientFactory bimServerClientFactory = new JsonBimServerClientFactory("http://localhost:8080");
		try {
			final BimServerClient client = bimServerClientFactory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
//			SProject newProject = client.getBimsie1ServiceInterface().addProject("test" + Math.random());
//			SDeserializerPluginConfiguration deserializerByName = client.getBimsie1ServiceInterface().getDeserializerByName("IfcStepDeserializer");
//			client.checkin(newProject.getOid(), "test", deserializerByName.getOid(), false, true, new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc"));
//			newProject = client.getBimsie1ServiceInterface().getProjectByPoid(newProject.getOid());
			SProject project = client.getBimsie1ServiceInterface().getProjectByPoid(458753L);
			SSerializerPluginConfiguration geometrySerializer = client.getBimsie1ServiceInterface().getSerializerByName("JsonGeometrySerializer");
			
			for (int i=0; i<100; i++) {
				final CountDownLatch countDownLatch = new CountDownLatch(1);
				final Long downloadByTypes = client.getBimsie1ServiceInterface().downloadByTypes(Collections.singleton(project.getLastRevisionId()), Collections.singleton("IfcWindow"), geometrySerializer.getOid(), true, false, false, false);
				final ProgressHandler progressHandler = new ProgressHandler() {
					@Override
					public void progress(SLongActionState state) {
						if (state.getProgress() == 100) {
							countDownLatch.countDown();
						}
					}
				};
				client.getNotificationsManager().registerProgressHandler(downloadByTypes, progressHandler);
				try {
					countDownLatch.await(20, TimeUnit.SECONDS);
					client.getNotificationsManager().unregisterProgressHandler(downloadByTypes, progressHandler);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			client.disconnect();
			System.out.println("Done");
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}
