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
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;
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
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.interfaces.objects.SDataValue;
import org.bimserver.interfaces.objects.SListDataValue;
import org.bimserver.interfaces.objects.SReferenceDataValue;
import org.bimserver.interfaces.objects.SSimpleDataValue;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.AutologinAuthenticationInfo;
import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.shared.ReflectorBuilder;
import org.bimserver.shared.ReflectorFactory;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.meta.ServicesMap;
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
//	private SchemaDefinition schema;
	private boolean connected = false;
	private AuthenticationInfo authenticationInfo;
	private ServicesMap servicesMap = new ServicesMap();
	private ReflectorFactory reflectorFactory;
	private String baseAddress;

	public BimServerClient(String baseAddress, ServicesMap servicesMap) {
		this.baseAddress = baseAddress;
		this.servicesMap = servicesMap;
		notificationsClient = new SocketNotificationsClient();
		reflectorFactory = new ReflectorBuilder(servicesMap).newReflectorFactory();
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
		ProtocolBuffersChannel protocolBuffersChannel = new ProtocolBuffersChannel(servicesMap, reflectorFactory);
		this.channel = protocolBuffersChannel;
		protocolBuffersChannel.registerConnectDisconnectListener(this);
		try {
			protocolBuffersChannel.connect(address, port);
		} catch (IOException e) {
			throw new ConnectionException(e);
		}
	}

	public void connectJson(boolean useHttpSession) throws ConnectionException {
		disconnect();
		JsonChannel jsonChannel = new JsonChannel(servicesMap, reflectorFactory);
		this.channel = jsonChannel;
		jsonChannel.connect(baseAddress + "/jsonapi", useHttpSession, authenticationInfo);
	}
	
	public void connectSoap(boolean useSoapHeaderSessions) throws ConnectionException {
//		if (authenticationInfo == null) {
//			throw new ConnectionException("Authentication information required, use \"setAuthentication\" first");
//		}
		disconnect();
		SoapChannel soapChannel = new SoapChannel();
		this.channel = soapChannel;
		soapChannel.registerConnectDisconnectListener(this);
		soapChannel.connect(baseAddress + "/soap", useSoapHeaderSessions);
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
	}

	public void setNotificationsEnabled(boolean enabled) {
		if (enabled && !notificationsClient.isRunning()) {
			notificationsClient.connect(servicesMap, new InetSocketAddress("localhost", 8055));
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
//		try {
//			SerializerPlugin serializerPlugin = pluginManager.getFirstSerializerPlugin("application/ifc", true);
//			Serializer serializer = serializerPlugin.createSerializer();
//			serializer.init(model, null, pluginManager, null);
//			SDeserializerPluginConfiguration deserializerPluginConfiguration = getServiceInterface().getSuggestedDeserializerForExtension("ifc");
//			String fileName = "unknown";
//			long checkinId = getServiceInterface().checkin(poid, comment, deserializerPluginConfiguration.getOid(), 0L, fileName, new DataHandler(new EmfSerializerDataSource(serializer)), false, true); // TODO
//			SCheckinResult checkinResult = getServiceInterface().getCheckinState(checkinId);
//			return checkinResult.getRevisionId();
//		} catch (ServiceException e) {
//			LOGGER.error("", e);
//		} catch (SerializerException e) {
//			LOGGER.error("", e);
//		} catch (PluginException e) {
//			LOGGER.error("", e);
//		}
		return -1;
	}

	public boolean isConnected() {
		return connected;
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

	public InputStream getDownloadData(long download, long serializerOid, SToken token) {
		String address = baseAddress + "/download?tokenString=" + token.getTokenString() + "&tokenExpires=" + token.getExpires() + "&longActionId=" + download + "&serializerOid=" + serializerOid;
		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient.addRequestInterceptor(new HttpRequestInterceptor() {

            public void process(
                    final HttpRequest request,
                    final HttpContext context) throws HttpException, IOException {
                if (!request.containsHeader("Accept-Encoding")) {
                    request.addHeader("Accept-Encoding", "gzip");
                }
            }

        });

        httpclient.addResponseInterceptor(new HttpResponseInterceptor() {

            public void process(
                    final HttpResponse response,
                    final HttpContext context) throws HttpException, IOException {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    Header ceheader = entity.getContentEncoding();
                    if (ceheader != null) {
                        HeaderElement[] codecs = ceheader.getElements();
                        for (int i = 0; i < codecs.length; i++) {
                            if (codecs[i].getName().equalsIgnoreCase("gzip")) {
                                response.setEntity(
                                        new GzipDecompressingEntity(response.getEntity()));
                                return;
                            }
                        }
                    }
                }
            }

        });
		HttpPost httppost = new HttpPost(address);
		try {
			HttpResponse httpResponse = httpclient.execute(httppost);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				return httpResponse.getEntity().getContent();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}