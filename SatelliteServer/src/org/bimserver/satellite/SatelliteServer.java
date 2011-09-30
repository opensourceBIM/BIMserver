package org.bimserver.satellite;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.NotificationInterfaceAdapter;
import org.bimserver.client.Session;
import org.bimserver.client.SocketNotificationsClient;
import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;

public class SatelliteServer {

	public void connect(String address, int port, String username, String password) throws IOException {
		final BimServerClient bimServerClient = new BimServerClient();
		bimServerClient.connectProtocolBuffers(address, port);
		try {
			bimServerClient.getServiceInterface().login(username, password);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		final Session session = bimServerClient.createSession();
		NotificationInterfaceAdapter notificationInterface = new NotificationInterfaceAdapter(){
			@Override
			public void newRevision(SNewRevisionNotification newRevisionNotification) throws ServiceException {
				long roid = newRevisionNotification.getRevisionId();
				SRevision revision = bimServerClient.getServiceInterface().getRevision(roid);
				session.loadModel(revision);
			}
		};
		
		final ProtocolBuffersMetaData protocolBuffersMetaData = new ProtocolBuffersMetaData();
		try {
			protocolBuffersMetaData.load(new File("../BimServerClientLib/src/service.desc"));
			protocolBuffersMetaData.load(new File("../BimServerClientLib/src/notification.desc"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		SocketNotificationsClient notificationsClient = new SocketNotificationsClient(protocolBuffersMetaData, new SService(NotificationInterface.class), new InetSocketAddress("localhost", 8055), notificationInterface);
		notificationsClient.start();
	}
}