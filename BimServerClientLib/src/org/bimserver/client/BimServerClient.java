package org.bimserver.client;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.bimserver.client.notifications.NotificationsManager;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.plugins.services.BimServerClientException;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.Geometry;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.AutologinAuthenticationInfo;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.ServiceHolder;
import org.bimserver.shared.SystemAuthentication;
import org.bimserver.shared.TokenAuthentication;
import org.bimserver.shared.TokenChangeListener;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.UserTokenAuthentication;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1AuthInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1LowLevelInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1NotificationInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1NotificationRegistryInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1RemoteServiceInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1ServiceInterface;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BimServerClient implements ConnectDisconnectListener, TokenHolder, ServiceHolder, BimServerClientInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(BimServerClient.class);
	private final Set<ConnectDisconnectListener> connectDisconnectListeners = new HashSet<ConnectDisconnectListener>();
	private final Set<TokenChangeListener> tokenChangeListeners = new HashSet<TokenChangeListener>();
	private final Channel channel;
	private final SServicesMap servicesMap;
	private final NotificationsManager notificationsManager;
	private final String baseAddress;
	private AuthenticationInfo authenticationInfo = new AnonymousAuthentication();
	private String token;
	private BimServerClientFactory factory;

	public BimServerClient(BimServerClientFactory factory, String baseAddress, SServicesMap servicesMap, Channel channel) {
		this.factory = factory;
		this.baseAddress = baseAddress;
		this.servicesMap = servicesMap;
		this.channel = channel;
		this.notificationsManager = new NotificationsManager(this);
	}

	public MetaDataManager getMetaDataManager() {
		return factory.getMetaDataManager();
	}
	
	public void setAuthentication(AuthenticationInfo authenticationInfo) throws ServerException, UserException, ChannelConnectionException {
		this.authenticationInfo = authenticationInfo;
		connect();
	}

	public void connect() throws ServerException, UserException, ChannelConnectionException {
		disconnect();
		this.channel.registerConnectDisconnectListener(this);
		this.channel.connect(this);
		authenticate();
	}

	private void authenticate() throws ServerException, UserException {
		try {
			Bimsie1AuthInterface authInterface = channel.get(Bimsie1AuthInterface.class);
			if (authenticationInfo instanceof UsernamePasswordAuthenticationInfo) {
				UsernamePasswordAuthenticationInfo usernamePasswordAuthenticationInfo = (UsernamePasswordAuthenticationInfo) authenticationInfo;
				setToken(authInterface.login(usernamePasswordAuthenticationInfo.getUsername(), usernamePasswordAuthenticationInfo.getPassword()));
			} else if (authenticationInfo instanceof AutologinAuthenticationInfo) {
				AutologinAuthenticationInfo autologinAuthenticationInfo = (AutologinAuthenticationInfo) authenticationInfo;
				setToken(autologinAuthenticationInfo.getAutologinCode());
			} else if (authenticationInfo instanceof TokenAuthentication) {
				TokenAuthentication tokenAuthentication = (TokenAuthentication)authenticationInfo;
				setToken(tokenAuthentication.getToken());
			} else if (authenticationInfo instanceof UserTokenAuthentication) {
				UserTokenAuthentication tokenAuthentication = (UserTokenAuthentication)authenticationInfo;
				setToken(authInterface.loginUserToken(tokenAuthentication.getToken()));
			} else if (authenticationInfo instanceof SystemAuthentication) {
			}
		} catch (PublicInterfaceNotFoundException e) {
			LOGGER.error("", e);
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

	public void disconnect() {
		if (notificationsManager != null) {
			notificationsManager.disconnect();
		}
		channel.disconnect();
	}

	@Override
	public void connected() {
		try {
			authenticate();
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

	public ClientIfcModel getModel(SProject project, long roid, boolean deep, boolean recordChanges) throws BimServerClientException, UserException, ServerException, PublicInterfaceNotFoundException {
		if (roid == -1) {
			throw new UserException("Roid cannot be -1");
		}
		return new ClientIfcModel(this, project.getOid(), roid, deep, getMetaDataManager().getPackageMetaData(project.getSchema()), recordChanges, false);
	}

	public ClientIfcModel getModel(SProject project, long roid, boolean deep, boolean recordChanges, boolean includeGeometry) throws BimServerClientException, UserException, ServerException, PublicInterfaceNotFoundException {
		if (roid == -1) {
			throw new UserException("Roid cannot be -1");
		}
		return new ClientIfcModel(this, project.getOid(), roid, deep, getMetaDataManager().getPackageMetaData(project.getSchema()), recordChanges, includeGeometry);
	}

	public boolean isConnected() {
		return token != null;
	}

	public void unregisterNotificationListener(Bimsie1NotificationInterface notificationInterface) {
		notificationsManager.unregisterNotifictionListener(notificationInterface);
	}

	public Bimsie1NotificationInterface getNotificationInterface() throws PublicInterfaceNotFoundException {
		return get(Bimsie1NotificationInterface.class);
	}

	public Bimsie1RemoteServiceInterface getRemoteServiceInterface() throws PublicInterfaceNotFoundException {
		return get(Bimsie1RemoteServiceInterface.class);
	}
	
	public Bimsie1LowLevelInterface getBimsie1LowLevelInterface() throws PublicInterfaceNotFoundException {
		return get(Bimsie1LowLevelInterface.class);
	}
	
	public ServiceInterface getServiceInterface() throws PublicInterfaceNotFoundException {
		return get(ServiceInterface.class);
	}

	public AdminInterface getAdminInterface() throws PublicInterfaceNotFoundException {
		return get(AdminInterface.class);
	}
	
	public Bimsie1AuthInterface getBimsie1AuthInterface() throws PublicInterfaceNotFoundException {
		return get(Bimsie1AuthInterface.class);
	}

	@Override
	public AuthInterface getAuthInterface() throws PublicInterfaceNotFoundException {
		return get(AuthInterface.class);
	}
	
	public SettingsInterface getSettingsInterface() throws PublicInterfaceNotFoundException {
		return get(SettingsInterface.class);
	}
	
	public PluginInterface getPluginInterface() throws PublicInterfaceNotFoundException {
		return get(PluginInterface.class);
	}
	
	public SServicesMap getServicesMap() {
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

	public long checkin(long poid, String comment, long deserializerOid, boolean merge, boolean sync, long fileSize, String filename, InputStream inputStream) throws UserException, ServerException {
		return channel.checkin(baseAddress, token, poid, comment, deserializerOid, merge, sync, fileSize, filename, inputStream);
	}

	public void download(long roid, long serializerOid, OutputStream outputStream) {
		try {
			Long download = getBimsie1ServiceInterface().download(roid, serializerOid, true, false);
			InputStream inputStream = getDownloadData(download, serializerOid);
			try {
				IOUtils.copy(inputStream, outputStream);
				getServiceInterface().cleanupLongAction(download);
			} finally {
				inputStream.close();
			}
		} catch (ServerException e) {
			LOGGER.error("", e);
		} catch (UserException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (PublicInterfaceNotFoundException e) {
			LOGGER.error("", e);
		}
	}

	public void download(long roid, long serializerOid, File file) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(file);
		try {
			download(roid, serializerOid, outputStream);
		} finally {
			outputStream.close();
		}
	}

	public InputStream getDownloadData(long downloadId, long serializerOid) throws IOException {
		return channel.getDownloadData(baseAddress, token, downloadId, serializerOid);
	}

	public IfcModelInterface newModel(SProject project, boolean recordChanges) throws ServerException, UserException, BimServerClientException, PublicInterfaceNotFoundException {
		return new ClientIfcModel(this, project.getOid(), -1, false, getMetaDataManager().getPackageMetaData(project.getSchema()), recordChanges, false);
	}

	public <T extends PublicInterface> T get(Class<T> clazz) throws PublicInterfaceNotFoundException {
		T t = channel.get(clazz);
		if (t == null) {
			throw new PublicInterfaceNotFoundException("No interface of type " + clazz.getSimpleName() + " registered on this channel");
		}
		return channel.get(clazz);
	}
	
	@Override
	public MetaInterface getMeta() throws PublicInterfaceNotFoundException {
		return channel.getMeta();
	}
	
	@Override
	public Bimsie1NotificationRegistryInterface getRegistry() throws PublicInterfaceNotFoundException {
		return channel.getRegistry();
	}

	public AuthInterface getBimServerAuthInterface() throws PublicInterfaceNotFoundException {
		return channel.getBimServerAuthInterface();
	}

	public Bimsie1ServiceInterface getBimsie1ServiceInterface() throws PublicInterfaceNotFoundException {
		return channel.getBimsie1ServiceInterface();
	}

	@Override
	public void commit(IfcModelInterface model, String comment) {
		if (model instanceof ClientIfcModel) {
			try {
				((ClientIfcModel)model).commit(comment);
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
	}

	public NotificationsManager getNotificationsManager() {
		if (!notificationsManager.isRunning()) {
			notificationsManager.connect(servicesMap, StringUtils.stripHttps(baseAddress));
			notificationsManager.startAndWaitForInit();
		}
		return notificationsManager;
	}

	@Override
	public Geometry getGeometry(long roid, IfcProduct ifcProduct) {
		try {
			SSerializerPluginConfiguration serializerByPluginClassName = getPluginInterface().getSerializerByPluginClassName("org.bimserver.serializers.binarygeometry.BinaryGeometrySerializerPlugin");
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			download(roid, serializerByPluginClassName.getOid(), outputStream);
			return null;
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}