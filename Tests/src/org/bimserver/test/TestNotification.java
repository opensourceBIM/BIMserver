package org.bimserver.test;

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
