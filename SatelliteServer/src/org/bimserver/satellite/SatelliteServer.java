package org.bimserver.satellite;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.Session;
import org.bimserver.client.notifications.MultiCastNotificationImpl;
import org.bimserver.client.notifications.SocketNotificationsClient;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;

public class SatelliteServer {
	private BimServerClient bimServerClient = new BimServerClient();
	private SocketNotificationsClient notificationsClient = new SocketNotificationsClient();
	
	public void connect(SatelliteSettings settings, NotificationInterface... notificationInterfaces) throws IOException {
		bimServerClient.connectProtocolBuffers(settings.getAddress(), settings.getPort());
		try {
			bimServerClient.getServiceInterface().login(settings.getUsername(), settings.getPassword());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		final Session session = bimServerClient.createSession();
		MultiCastNotificationImpl multiCast = new MultiCastNotificationImpl(notificationInterfaces);

		final ProtocolBuffersMetaData protocolBuffersMetaData = new ProtocolBuffersMetaData();
		try {
			protocolBuffersMetaData.load(new File("../BimServerClientLib/src/service.desc"));
			protocolBuffersMetaData.load(new File("../BimServerClientLib/src/notification.desc"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		notificationsClient.connect(protocolBuffersMetaData, new SService(NotificationInterface.class), new InetSocketAddress("localhost", 8055), multiCast);
		notificationsClient.start();
	}

	public BimServerClient getBimServerClient() {
		return bimServerClient;
	}
	
	public SocketNotificationsClient getNotificationsClient() {
		return notificationsClient;
	}

	public void disconnect() {
		notificationsClient.disconnect();
		bimServerClient.disconnect();
	}
}