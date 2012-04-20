package org.bimserver.notifications;

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

//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//
//import org.bimserver.BimServer;
//import org.bimserver.database.BimDatabaseException;
//import org.bimserver.database.DatabaseSession;
//import org.bimserver.database.BimDeadlockException;
//import org.bimserver.emf.IdEObject;
//import org.bimserver.ifc.IfcModel;
//import org.bimserver.interfaces.SConverter;
//import org.bimserver.interfaces.objects.SLogAction;
//import org.bimserver.models.log.LogAction;
//import org.bimserver.models.store.StorePackage;
//import org.bimserver.models.store.User;
//import org.bimserver.shared.pb.ProtocolBuffersConverter;
//import org.bimserver.shared.pb.ProtocolBuffersMetaData;
//import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;
//
//import com.google.protobuf.Descriptors.ServiceDescriptor;
//import com.google.protobuf.Message;
//
//public class HttpCallbackNotificationDispatcher implements NotificationListener {
//
//	private final BimServer bimServer;
//	private ServiceDescriptor serviceDescriptor;
//	private ProtocolBuffersMetaData protocolBuffersMetaData;
//
//	public HttpCallbackNotificationDispatcher(BimServer bimServer) {
//		this.bimServer = bimServer;
//		try {
//			protocolBuffersMetaData = new ProtocolBuffersMetaData();
//			protocolBuffersMetaData.load(getClass().getClassLoader().getResource("service.desc"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void notify(LogAction notificationMessage) {
//		DatabaseSession session = bimServer.getDatabase().createSession();
//		try {
//			IfcModel allOfType = session.getAllOfType(StorePackage.eINSTANCE.getUser(), false);
//			for (IdEObject idEObject : allOfType.getValues()) {
//				if (idEObject instanceof User) {
//					User user = (User)idEObject;
//					if (user.getNotificationUrl() != null && !user.getNotificationUrl().isEmpty()) {
//						try {
//							URL url = new URL(user.getNotificationUrl());
//							URLConnection connection = url.openConnection();
//							InputStream inputStream = connection.getInputStream();
//							DataOutputStream das = new DataOutputStream(connection.getOutputStream());
//							das.writeUTF("listener");
//							das.writeUTF("newLogAction");
//							ProtocolBuffersConverter converter = new ProtocolBuffersConverter();
//							MethodDescriptorContainer methodDescriptorContainer = protocolBuffersMetaData.getMethod("listener", "newLogAction");
//							SConverter sConverter = new SConverter();
//							SLogAction sLogAction = sConverter.convertToSObject(notificationMessage);
//							Message request = converter.convertSObjectToProtocolBuffersObject(methodDescriptorContainer.getInputDescriptor(), sLogAction);
//							request.writeTo(das);
//						} catch (MalformedURLException e) {
//							e.printStackTrace();
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			}
//		} catch (BimDatabaseException e) {
//			e.printStackTrace();
//		} catch (BimDeadlockException e) {
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//	}
//}