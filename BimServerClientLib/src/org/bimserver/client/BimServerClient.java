package org.bimserver.client;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.bimserver.client.channels.Channel;
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
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.AutologinAuthenticationInfo;
import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.shared.TokenChangeListener;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.meta.ServicesMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class BimServerClient implements ConnectDisconnectListener, TokenHolder {
	private static final Logger LOGGER = LoggerFactory.getLogger(BimServerClient.class);
	private final Set<ConnectDisconnectListener> connectDisconnectListeners = new HashSet<ConnectDisconnectListener>();
	private final Set<TokenChangeListener> tokenChangeListeners = new HashSet<TokenChangeListener>();
	private final Channel channel;
	private SocketNotificationsClient notificationsClient;
	private AuthenticationInfo authenticationInfo = new AnonymousAuthentication();
	private ServicesMap servicesMap = new ServicesMap();
	private String baseAddress;
	private String token;

	protected BimServerClient(String baseAddress, ServicesMap servicesMap, Channel channel) {
		this.baseAddress = baseAddress;
		this.servicesMap = servicesMap;
		this.channel = channel;
		this.notificationsClient = new SocketNotificationsClient();
	}

	public void setAuthentication(AuthenticationInfo authenticationInfo) throws ServerException, UserException, ChannelConnectionException {
		this.authenticationInfo = authenticationInfo;
		connect();
	}

	protected void connect() throws ServerException, UserException, ChannelConnectionException {
		disconnect();
		this.channel.registerConnectDisconnectListener(this);
		this.channel.connect(this);
		authenticate();
	}
	
	private void authenticate() throws ServerException, UserException {
		if (authenticationInfo instanceof UsernamePasswordAuthenticationInfo) {
			UsernamePasswordAuthenticationInfo usernamePasswordAuthenticationInfo = (UsernamePasswordAuthenticationInfo)authenticationInfo;
			setToken(channel.getServiceInterface().login(usernamePasswordAuthenticationInfo.getUsername(), usernamePasswordAuthenticationInfo.getPassword()));
		} else if (authenticationInfo instanceof AutologinAuthenticationInfo) {
			AutologinAuthenticationInfo autologinAuthenticationInfo = (AutologinAuthenticationInfo)authenticationInfo;
			setToken(channel.getServiceInterface().autologin(autologinAuthenticationInfo.getUsername(), autologinAuthenticationInfo.getAutologinCode()));
		}
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
		return channel.getServiceInterface();
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
		channel.disconnect();
	}

	@Override
	public void connected() {
		try {
			if (authenticationInfo instanceof UsernamePasswordAuthenticationInfo) {
				UsernamePasswordAuthenticationInfo usernamePasswordAuthenticationInfo = (UsernamePasswordAuthenticationInfo) authenticationInfo;
				setToken(channel.getServiceInterface().login(usernamePasswordAuthenticationInfo.getUsername(), usernamePasswordAuthenticationInfo.getPassword()));
			} else if (authenticationInfo instanceof AutologinAuthenticationInfo) {
				AutologinAuthenticationInfo autologinAuthenticationInfo = (AutologinAuthenticationInfo) authenticationInfo;
				setToken(channel.getServiceInterface().autologin(autologinAuthenticationInfo.getUsername(), autologinAuthenticationInfo.getAutologinCode()));
			}
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
		if (token != null) {
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
			if (token != null) {
				// try {
				// TODO
				// getServiceInterface().setHttpCallback(getServiceInterface().getCurrentUser().getOid(),
				// "localhost:8055");
				// } catch (ServiceException e) {
				// LOGGER.error("", e);
				// }
			} else {
				registerConnectDisconnectListener(new ConnectDisconnectListener() {
					@Override
					public void disconnected() {
					}

					@Override
					public void connected() {
						// try {
						// TODO
						// getServiceInterface().setHttpCallback(getServiceInterface().getCurrentUser().getOid(),
						// "localhost:8055");
						// } catch (ServiceException e) {
						// LOGGER.error("", e);
						// }
					}
				});
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IfcModelInterface getModel(long roid) throws BimServerClientException, UserException, ServerException {
		try {
			List<SDataObject> dataObjects = getServiceInterface().getDataObjects(roid);
			IfcModelInterface model = new IfcModel(dataObjects.size());
			for (SDataObject dataObject : dataObjects) {
				String type = dataObject.getType();
				EClass eClass = (EClass) Ifc2x3tc1Package.eINSTANCE.getEClassifier(type);
				if (eClass == null) {
					throw new BimServerClientException("No class found with name " + type);
				}
				IdEObject idEObject = (IdEObject) Ifc2x3tc1Factory.eINSTANCE.create(eClass);
				((IdEObjectImpl) idEObject).setOid(dataObject.getOid());
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
		} else if (eType == einstance.getEByteArray()) {
			return stringValue.getBytes(Charsets.UTF_8);
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

	public boolean isConnected() {
		return token != null;
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

	@Override
	public String getToken() {
		return token;
	}

	@Override
	public void setToken(String token) {
		this.token = token;
		for (TokenChangeListener tokenChangeListener : tokenChangeListeners) {
			tokenChangeListener.newToken(token);
		}
	}

	@Override
	public void registerTokenChangeListener(TokenChangeListener tokenChangeListener) {
		tokenChangeListeners.add(tokenChangeListener);
	}

	public long checkin(long poid, String comment, long deserializerOid, boolean merge, boolean sync, File file) throws IOException, UserException, ServerException {
		FileInputStream fis = new FileInputStream(file);
		long result = checkin(poid, comment, deserializerOid, merge, sync, file.length(), file.getName(), fis);
		fis.close();
		return result;
	}	
	
	public long checkin(long poid, String comment, long deserializerOid, boolean merge, boolean sync, long fileSize, String filename, InputStream inputStream) throws UserException, ServerException {
		return channel.checkin(baseAddress, token, poid, comment, deserializerOid, merge, sync, fileSize, filename, inputStream);
	}

	public void download(long roid, long serializerOid, OutputStream outputStream) {
		try {
			Long download = getServiceInterface().download(roid, serializerOid, true, true);
			InputStream inputStream = getDownloadData(download, serializerOid);
			IOUtils.copy(inputStream, outputStream);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void download(long roid, long serializerOid, File file) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(file);
		download(roid, serializerOid, outputStream);
		outputStream.close();
	}
	
	public InputStream getDownloadData(long download, long oid) throws IOException {
		return channel.getDownloadData(baseAddress, token, download, oid);
	}
}