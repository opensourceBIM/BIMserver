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
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.bimserver.client.channels.Channel;
import org.bimserver.client.notifications.SocketNotificationsClient;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
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
import org.bimserver.shared.interfaces.RemoteServiceInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.meta.ServicesMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BimServerClient implements ConnectDisconnectListener, TokenHolder {
	private static final Logger LOGGER = LoggerFactory.getLogger(BimServerClient.class);
	private final Set<ConnectDisconnectListener> connectDisconnectListeners = new HashSet<ConnectDisconnectListener>();
	private final Set<TokenChangeListener> tokenChangeListeners = new HashSet<TokenChangeListener>();
	private final Channel channel;
	private final ServicesMap servicesMap;
	private final SocketNotificationsClient notificationsClient;
	private final String baseAddress;
	private MetaDataManager metaDataManager = new MetaDataManager();
	private AuthenticationInfo authenticationInfo = new AnonymousAuthentication();
	private String token;

	protected BimServerClient(String baseAddress, ServicesMap servicesMap, Channel channel) {
		this.baseAddress = baseAddress;
		this.servicesMap = servicesMap;
		this.channel = channel;
		this.notificationsClient = new SocketNotificationsClient();
		metaDataManager.addEPackage(Ifc2x3tc1Package.eINSTANCE);
	}

	public MetaDataManager getMetaDataManager() {
		return metaDataManager;
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
			UsernamePasswordAuthenticationInfo usernamePasswordAuthenticationInfo = (UsernamePasswordAuthenticationInfo) authenticationInfo;
			setToken(channel.getServiceInterface().login(usernamePasswordAuthenticationInfo.getUsername(), usernamePasswordAuthenticationInfo.getPassword()));
		} else if (authenticationInfo instanceof AutologinAuthenticationInfo) {
			AutologinAuthenticationInfo autologinAuthenticationInfo = (AutologinAuthenticationInfo) authenticationInfo;
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

	public ClientIfcModel getModel(long poid, long roid, boolean deep) throws BimServerClientException, UserException, ServerException {
		return new ClientIfcModel(this, poid, roid, deep);
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

	public RemoteServiceInterface getRemoteServiceInterface() {
		if (channel != null) {
			return channel.getRemoteServiceInterface();
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
		if (sync) {
			fis.close();
		}
		return result;
	}

	public long checkin(long poid, String comment, long deserializerOid, boolean merge, boolean sync, long fileSize, String filename, InputStream inputStream)
			throws UserException, ServerException {
		return channel.checkin(baseAddress, token, poid, comment, deserializerOid, merge, sync, fileSize, filename, inputStream);
	}

	public void download(long roid, long serializerOid, OutputStream outputStream) {
		try {
			Long download = getServiceInterface().download(roid, serializerOid, true, true);
			InputStream inputStream = getDownloadData(download, serializerOid);
			IOUtils.copy(inputStream, outputStream);
			getServiceInterface().cleanupLongAction(download);
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

	public InputStream getDownloadData(long download, long serializerOid) throws IOException {
		return channel.getDownloadData(baseAddress, token, download, serializerOid);
	}

	public ClientIfcModel newModel(SProject project) throws ServerException, UserException, BimServerClientException {
		return new ClientIfcModel(this, project.getOid(), -1, false);
	}
}