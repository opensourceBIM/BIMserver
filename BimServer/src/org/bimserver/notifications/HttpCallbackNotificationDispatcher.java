package org.bimserver.notifications;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.interfaces.SConverter;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.models.log.LogAction;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.pb.ProtocolBuffersConverter;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;

import com.google.protobuf.Descriptors.ServiceDescriptor;
import com.google.protobuf.Message;

public class HttpCallbackNotificationDispatcher implements NotificationListener {

	private final BimServer bimServer;
	private ServiceDescriptor serviceDescriptor;
	private ProtocolBuffersMetaData protocolBuffersMetaData;

	public HttpCallbackNotificationDispatcher(BimServer bimServer) {
		this.bimServer = bimServer;
		try {
			protocolBuffersMetaData = new ProtocolBuffersMetaData();
			protocolBuffersMetaData.load(getClass().getClassLoader().getResource("service.desc"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void notify(LogAction notificationMessage) {
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			IfcModel allOfType = session.getAllOfType(StorePackage.eINSTANCE.getUser(), false);
			for (IdEObject idEObject : allOfType.getValues()) {
				if (idEObject instanceof User) {
					User user = (User)idEObject;
					if (user.getNotificationUrl() != null && !user.getNotificationUrl().isEmpty()) {
						try {
							URL url = new URL(user.getNotificationUrl());
							URLConnection connection = url.openConnection();
							InputStream inputStream = connection.getInputStream();
							DataOutputStream das = new DataOutputStream(connection.getOutputStream());
							das.writeUTF("listener");
							das.writeUTF("newLogAction");
							ProtocolBuffersConverter converter = new ProtocolBuffersConverter();
							MethodDescriptorContainer methodDescriptorContainer = protocolBuffersMetaData.getMethod("listener", "newLogAction");
							SConverter sConverter = new SConverter();
							SLogAction sLogAction = sConverter.convertToSObject(notificationMessage);
							Message request = converter.convertSObjectToProtocolBuffersObject(methodDescriptorContainer.getInputDescriptor(), sLogAction);
							request.writeTo(das);
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}