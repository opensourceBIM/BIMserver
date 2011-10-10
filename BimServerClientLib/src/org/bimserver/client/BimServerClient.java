package org.bimserver.client;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;

import javax.activation.DataHandler;

import org.bimserver.client.channels.Channel;
import org.bimserver.client.channels.DirectChannel;
import org.bimserver.client.channels.ProtocolBuffersChannel;
import org.bimserver.client.channels.SoapChannel;
import org.bimserver.client.notifications.SocketNotificationsClient;
import org.bimserver.interfaces.objects.SCheckinResult;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SSerializer;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.EmfSerializerDataSource;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;

public class BimServerClient implements ConnectDisconnectListener {
	private final Set<ConnectDisconnectListener> connectDisconnectListeners = new HashSet<ConnectDisconnectListener>();
	private Channel channel;
	private SocketNotificationsClient notificationsClient;
	private ProtocolBuffersMetaData protocolBuffersMetaData;
	private SchemaDefinition schema;
	private final PluginManager pluginManager;
	private boolean connected = false;

	public BimServerClient(PluginManager pluginManager) {
		this.pluginManager = pluginManager;
		protocolBuffersMetaData = new ProtocolBuffersMetaData();
		try {
			protocolBuffersMetaData.load(getClass().getClassLoader().getResource("service.desc"));
			protocolBuffersMetaData.load(getClass().getClassLoader().getResource("notification.desc"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		notificationsClient = new SocketNotificationsClient();
		try {
			schema = pluginManager.requireSchemaDefinition();
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}

	public void connectDirect(ServiceInterface serviceInterface) {
		DirectChannel directChannel = new DirectChannel();
		this.channel = directChannel;
		directChannel.registerConnectDisconnectListener(this);
		directChannel.connect(serviceInterface);
	}
	
	public void connectProtocolBuffers(String address, int port) throws ConnectionException {
		ProtocolBuffersChannel protocolBuffersChannel = new ProtocolBuffersChannel(protocolBuffersMetaData);
		this.channel = protocolBuffersChannel;
		protocolBuffersChannel.registerConnectDisconnectListener(this);
		try {
			protocolBuffersChannel.connect(address, port);
		} catch (IOException e) {
			throw new ConnectionException(e);
		}
	}
	
	public void connectSoap(final String address) {
		SoapChannel soapChannel = new SoapChannel();
		this.channel = soapChannel;
		soapChannel.registerConnectDisconnectListener(this);
		soapChannel.connect(address);
	}

	public void login(String username, String password) throws ServiceException {
		channel.getServiceInterface().login(username, password);
	}
	
	public void registerConnectDisconnectListener(ConnectDisconnectListener connectDisconnectListener) {
		connectDisconnectListeners.add(connectDisconnectListener);
	}
	
	public void notifyOfConnect() {
		for (ConnectDisconnectListener connectDisconnectListener : connectDisconnectListeners) {
			connectDisconnectListener.connected();
		}
	}
	
	public void notifyOfDisconnect() {
		for (ConnectDisconnectListener connectDisconnectListener : connectDisconnectListeners) {
			connectDisconnectListener.disconnected();
		}
	}
	
	public ServiceInterface getServiceInterface() {
		return channel.getServiceInterface();
	}
	
	public Session createSession() {
		if (channel.getServiceInterface() == null) {
			throw new RuntimeException("Connect first");
		}
		Session session = new Session(channel.getServiceInterface());
		return session;
	}

	public void disconnect() {
		channel.disconnect();
	}

	@Override
	public void connected() {
		connected = true;
		notifyOfConnect();
	}

	@Override
	public void disconnected() {
		notifyOfDisconnect();
	}

	public void registerNotificationListener(NotificationInterface notificationInterface) {
		setNotificationsEnabled(true);
		notificationsClient.registerNotifictionListener(notificationInterface);
	}
	
	public void setNotificationsEnabled(boolean enabled) {
		if (enabled) {
			notificationsClient.connect(protocolBuffersMetaData, new SService(NotificationInterface.class), new InetSocketAddress("localhost", 8055));
			notificationsClient.start();
			if (connected) {
				try {
					getServiceInterface().setHttpCallback(getServiceInterface().getCurrentUser().getOid(), "localhost:8055");
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public IfcModelInterface getModel(long roid) {
		try {
			SSerializer serializer = getServiceInterface().getSerializerByContentType("application/ifc");
			Integer downloadId = getServiceInterface().download(roid, serializer.getName(), true);
			SDownloadResult downloadData = getServiceInterface().getDownloadData(downloadId);
			DataHandler file = downloadData.getFile();
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
			EmfDeserializer deserializer = deserializerPlugin.createDeserializer();
			deserializer.init(schema);
			IfcModelInterface model = deserializer.read(file.getInputStream(), "", true, 0);
			return model;
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		}
		return null;
	}

	public long uploadModel(long poid, String comment, IfcModelInterface model) {
		try {
			SerializerPlugin serializerPlugin = pluginManager.getFirstSerializerPlugin("application/ifc", true);
			EmfSerializer serializer = serializerPlugin.createSerializer();
			serializer.init(model, null, pluginManager);
			SCheckinResult checkinSync = getServiceInterface().checkinSync(poid, comment, "IfcStepDeserializer", 0L, new DataHandler(new EmfSerializerDataSource(serializer)), false);
			return checkinSync.getRevisionId();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		}
		return -1;
	}
}