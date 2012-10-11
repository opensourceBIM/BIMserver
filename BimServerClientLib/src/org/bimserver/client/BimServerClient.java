package org.bimserver.client;

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

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;

import org.bimserver.client.channels.Channel;
import org.bimserver.client.channels.DirectChannel;
import org.bimserver.client.channels.ProtocolBuffersChannel;
import org.bimserver.client.channels.SoapChannel;
import org.bimserver.client.notifications.SocketNotificationsClient;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.interfaces.objects.SCheckinResult;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.interfaces.objects.SDataValue;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SListDataValue;
import org.bimserver.interfaces.objects.SReferenceDataValue;
import org.bimserver.interfaces.objects.SSimpleDataValue;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializerDataSource;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.AutologinAuthenticationInfo;
import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.meta.ServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BimServerClient implements ConnectDisconnectListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(BimServerClient.class);
	private final Set<ConnectDisconnectListener> connectDisconnectListeners = new HashSet<ConnectDisconnectListener>();
	private Channel channel;
	private SocketNotificationsClient notificationsClient;
	private ProtocolBuffersMetaData protocolBuffersMetaData;
//	private SchemaDefinition schema;
	private final PluginManager pluginManager;
	private boolean connected = false;
	private AuthenticationInfo authenticationInfo;
	private ServicesMap servicesMap = new ServicesMap();

	public BimServerClient(PluginManager pluginManager) {
		this(pluginManager, pluginManager.getServicesMap());
	}
	
	public BimServerClient(PluginManager pluginManager, ServicesMap servicesMap) {
		this.servicesMap = servicesMap;
		this.pluginManager = pluginManager;
		protocolBuffersMetaData = new ProtocolBuffersMetaData();
		try {
			protocolBuffersMetaData.load(getClass().getClassLoader().getResource("service.desc"));
			protocolBuffersMetaData.load(getClass().getClassLoader().getResource("notification.desc"));
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		notificationsClient = new SocketNotificationsClient();
	}

	public void setAuthentication(AuthenticationInfo authenticationInfo) {
		this.authenticationInfo = authenticationInfo;
	}

	public <T extends PublicInterface> void connectDirect(Class<T> interfaceClass, T serviceInterface) {
		DirectChannel directChannel = new DirectChannel();
		disconnect();
		this.channel = directChannel;
		directChannel.registerConnectDisconnectListener(this);
		directChannel.connect(interfaceClass, serviceInterface);
	}

	public void connectProtocolBuffers(String address, int port) throws ConnectionException {
//		if (authenticationInfo == null) {
//			throw new ConnectionException("Authentication information required, use \"setAuthentication\" first");
//		}
		disconnect();
		ProtocolBuffersChannel protocolBuffersChannel = new ProtocolBuffersChannel(protocolBuffersMetaData, servicesMap);
		this.channel = protocolBuffersChannel;
		protocolBuffersChannel.registerConnectDisconnectListener(this);
		try {
			protocolBuffersChannel.connect(address, port);
		} catch (IOException e) {
			throw new ConnectionException(e);
		}
	}

	public void connectJson(final String address, boolean useHttpSession) throws ConnectionException {
		disconnect();
		JsonChannel jsonChannel = new JsonChannel(servicesMap);
		this.channel = jsonChannel;
		jsonChannel.connect(address, useHttpSession, authenticationInfo);
	}
	
	public void connectSoap(final String address, boolean useSoapHeaderSessions) throws ConnectionException {
//		if (authenticationInfo == null) {
//			throw new ConnectionException("Authentication information required, use \"setAuthentication\" first");
//		}
		disconnect();
		SoapChannel soapChannel = new SoapChannel();
		this.channel = soapChannel;
		soapChannel.registerConnectDisconnectListener(this);
		soapChannel.connect(address, useSoapHeaderSessions);
	}

	public Channel getChannel() {
		return channel;
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
		if (channel != null) {
			return channel.getServiceInterface();
		}
		return null;
	}

	public Session createSession() {
		ServiceInterface serviceInterface = getServiceInterface();
		if (serviceInterface == null) {
			throw new RuntimeException("Connect first");
		}
		Session session = new Session(serviceInterface);
		return session;
	}

	public void disconnect() {
		try {
			if (getServiceInterface() != null) {
				getServiceInterface().close();
			}
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
		if (channel != null) {
			channel.disconnect();
		}
	}

	@Override
	public void connected() {
		try {
			if (authenticationInfo instanceof UsernamePasswordAuthenticationInfo) {
				UsernamePasswordAuthenticationInfo usernamePasswordAuthenticationInfo = (UsernamePasswordAuthenticationInfo) authenticationInfo;
				connected = channel.getServiceInterface().login(usernamePasswordAuthenticationInfo.getUsername(), usernamePasswordAuthenticationInfo.getPassword()) != null;
			} else if (authenticationInfo instanceof AutologinAuthenticationInfo) {
				AutologinAuthenticationInfo autologinAuthenticationInfo = (AutologinAuthenticationInfo) authenticationInfo;
				connected = channel.getServiceInterface().autologin(autologinAuthenticationInfo.getUsername(), autologinAuthenticationInfo.getAutologinCode()) != null;
			}
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
		if (connected) {
			notifyOfConnect();
		}
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
		if (enabled && !notificationsClient.isRunning()) {
			notificationsClient.connect(protocolBuffersMetaData, servicesMap, new InetSocketAddress("localhost", 8055));
			notificationsClient.startAndWaitForInit();
			if (connected) {
//				try {
					// TODO
//					getServiceInterface().setHttpCallback(getServiceInterface().getCurrentUser().getOid(), "localhost:8055");
//				} catch (ServiceException e) {
//					LOGGER.error("", e);
//				}
			} else {
				registerConnectDisconnectListener(new ConnectDisconnectListener() {
					@Override
					public void disconnected() {
					}

					@Override
					public void connected() {
//						try {
							// TODO
//							getServiceInterface().setHttpCallback(getServiceInterface().getCurrentUser().getOid(), "localhost:8055");
//						} catch (ServiceException e) {
//							LOGGER.error("", e);
//						}
					}
				});
			}
		}
	}

//	public IfcModelInterface getModel(long roid) {
//		try {
//			SSerializer serializer = getServiceInterface().getSerializerByContentType("application/ifc");
//			Integer downloadId = getServiceInterface().download(roid, serializer.getName(), true, true);
//			SDownloadResult downloadData = getServiceInterface().getDownloadData(downloadId);
//			DataHandler file = downloadData.getFile();
//			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
//			EmfDeserializer deserializer = deserializerPlugin.createDeserializer();
//			deserializer.init(schema);
//			IfcModelInterface model = deserializer.read(file.getInputStream(), "", true, 0);
//			return model;
//		} catch (ServiceException e) {
//			LOGGER.error("", e);
//		} catch (DeserializeException e) {
//			LOGGER.error("", e);
//		} catch (IOException e) {
//			LOGGER.error("", e);
//		} catch (PluginException e) {
//			LOGGER.error("", e);
//		}
//		return null;
//	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IfcModelInterface getModel(long roid) throws BimServerClientException, UserException, ServerException {
		try {
			List<SDataObject> dataObjects = getServiceInterface().getDataObjects(roid);
			IfcModelInterface model = new IfcModel(dataObjects.size());
			for (SDataObject dataObject : dataObjects) {
				EClass eClass = (EClass) Ifc2x3tc1Package.eINSTANCE.getEClassifier(dataObject.getType());
				IdEObject idEObject = (IdEObject) Ifc2x3tc1Factory.eINSTANCE.create(eClass);
				((IdEObjectImpl)idEObject).setOid(dataObject.getOid());
				model.add(dataObject.getOid(), idEObject);
				for (SDataValue dataValue : dataObject.getValues()) {
					if (dataValue instanceof SSimpleDataValue) {
						SSimpleDataValue simpleDataValue = (SSimpleDataValue) dataValue;
						EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(dataValue.getFieldName());
						if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject() || eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
							EStructuralFeature asStringFeature = eClass.getEStructuralFeature(eStructuralFeature.getName() + "AsString");
							idEObject.eSet(asStringFeature, simpleDataValue.getStringValue());
						}
						idEObject.eSet(eStructuralFeature, convertStringValue(eStructuralFeature, simpleDataValue.getStringValue()));
					} else if (dataValue instanceof SListDataValue) {
						EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(dataValue.getFieldName());
						if (eStructuralFeature == null) {
							throw new BimServerClientException("Field " + dataValue.getFieldName() + " not found on " + eClass.getName());
						}
						SListDataValue listDataValue = (SListDataValue) dataValue;
						if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject() || eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
							EStructuralFeature asStringFeature = eClass.getEStructuralFeature(eStructuralFeature.getName() + "AsString");
							List list = (List) idEObject.eGet(asStringFeature);
							for (SDataValue listValue : listDataValue.getValues()) {
								if (listValue instanceof SSimpleDataValue) {
									list.add(((SSimpleDataValue) listValue).getStringValue());
								}
							}
						}
						List list = (List) idEObject.eGet(eStructuralFeature);
						for (SDataValue listValue : listDataValue.getValues()) {
							if (listValue instanceof SSimpleDataValue) {
								Object value = convertStringValue(eStructuralFeature, ((SSimpleDataValue) listValue).getStringValue());
								if (value != null) {
									list.add(value);
								}
							}
						}
					}
				}
			}
			for (SDataObject dataObject : dataObjects) {
				IdEObject idEObject = model.get(dataObject.getOid());
				for (SDataValue dataValue : dataObject.getValues()) {
					if (dataValue instanceof SReferenceDataValue) {
						EStructuralFeature eStructuralFeature = idEObject.eClass().getEStructuralFeature(dataValue.getFieldName());
						SReferenceDataValue referenceDataValue = (SReferenceDataValue) dataValue;
						idEObject.eSet(eStructuralFeature, model.get(referenceDataValue.getOid()));
					} else if (dataValue instanceof SListDataValue) {
						EStructuralFeature eStructuralFeature = idEObject.eClass().getEStructuralFeature(dataValue.getFieldName());
						if (eStructuralFeature == null) {
							throw new UserException("Feature " + dataValue.getFieldName() + " not found on class " + idEObject.eClass());
						}
						List list = (List) idEObject.eGet(eStructuralFeature);
						SListDataValue listDataValue = (SListDataValue) dataValue;
						for (SDataValue listValue : listDataValue.getValues()) {
							if (listValue instanceof SReferenceDataValue) {
								SReferenceDataValue referenceDataValue = (SReferenceDataValue) listValue;
								IdEObject e = model.get(referenceDataValue.getOid());
								if (e == null) {
									throw new UserException("Object with oid " + referenceDataValue.getOid() + " not found");
								}
								list.add(e);
							}
						}
					}
				}
			}
			return model;
		} catch (IfcModelInterfaceException e) {
			throw new BimServerClientException(e);
		}
	}

	private Object convertStringValue(EStructuralFeature eStructuralFeature, String stringValue) {
		EClassifier eType = eStructuralFeature.getEType();
		EcorePackage einstance = EcorePackage.eINSTANCE;
		if (eType == einstance.getEString()) {
			return stringValue;
		} else if (eType == einstance.getEFloat() || eType == einstance.getEFloatObject()) {
			return Float.parseFloat(stringValue);
		} else if (eType == einstance.getEDouble() || eType == einstance.getEDoubleObject()) {
			return Double.parseDouble(stringValue);
		} else if (eType == einstance.getEBoolean() || eType == einstance.getEBooleanObject()) {
			return Boolean.parseBoolean(stringValue);
		} else if (eType == einstance.getEInt() || eType == einstance.getEIntegerObject()) {
			return Integer.parseInt(stringValue);
		} else if (eType instanceof EEnum) {
			EEnum eEnum = (EEnum) eType;
			return eEnum.getEEnumLiteral(stringValue).getInstance();
		} else if (eType instanceof EClass) {
			if (eType.getName().equals("IfcGloballyUniqueId")) {
				IfcGloballyUniqueId ifcGloballyUniqueId = Ifc2x3tc1Factory.eINSTANCE.createIfcGloballyUniqueId();
				ifcGloballyUniqueId.setWrappedValue(stringValue);
				return ifcGloballyUniqueId;
			} else {
				return null;
			}
		} else {
			throw new RuntimeException("Unimplemented type: " + eStructuralFeature.getEType());
		}
	}

	public long uploadModel(long poid, String comment, IfcModelInterface model) {
		try {
			SerializerPlugin serializerPlugin = pluginManager.getFirstSerializerPlugin("application/ifc", true);
			Serializer serializer = serializerPlugin.createSerializer();
			serializer.init(model, null, pluginManager, null);
			SDeserializerPluginConfiguration deserializerPluginConfiguration = getServiceInterface().getSuggestedDeserializerForExtension("ifc");
			String fileName = "unknown";
			long checkinId = getServiceInterface().checkin(poid, comment, deserializerPluginConfiguration.getOid(), 0L, fileName, new DataHandler(new EmfSerializerDataSource(serializer)), false, true); // TODO
			SCheckinResult checkinResult = getServiceInterface().getCheckinState(checkinId);
			return checkinResult.getRevisionId();
		} catch (ServiceException e) {
			LOGGER.error("", e);
		} catch (SerializerException e) {
			LOGGER.error("", e);
		} catch (PluginException e) {
			LOGGER.error("", e);
		}
		return -1;
	}

	public boolean isConnected() {
		return connected;
	}

	public PluginManager getPluginManager() {
		return pluginManager;
	}

	public void unregisterNotificationListener(NotificationInterface notificationInterface) {
		notificationsClient.unregisterNotifictionListener(notificationInterface);
	}

	public NotificationInterface getNotificationInterface() {
		if (channel != null) {
			return channel.getNotificationInterface();
		}
		return null;
	}
	
	public ServicesMap getServicesMap() {
		return servicesMap;
	}
}