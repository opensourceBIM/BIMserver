package org.bimserver.client;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.bimserver.client.notifications.NotificationsManager;
import org.bimserver.database.queries.om.DefaultQueries;
import org.bimserver.database.queries.om.JsonQueryObjectModelConverter;
import org.bimserver.database.queries.om.Query;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SLongCheckinActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.CheckinProgressHandler;
import org.bimserver.plugins.services.Geometry;
import org.bimserver.plugins.services.ProgressHandler;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.AutologinAuthenticationInfo;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.shared.ServiceHolder;
import org.bimserver.shared.SystemAuthentication;
import org.bimserver.shared.TokenAuthentication;
import org.bimserver.shared.TokenChangeListener;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.UserTokenAuthentication;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.interfaces.NewServicesInterface;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.NotificationRegistryInterface;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.RemoteServiceInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Joiner;

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
	private MetaDataManager metaDataManager;
	private long binaryGeometryMessagingStreamingSerializer = -1;
	private long ifcSerializerOid = -1;
	private long binaryGeometrySerializerOid = -1;

	public BimServerClient(MetaDataManager metaDataManager, String baseAddress, SServicesMap servicesMap, Channel channel) {
		this.metaDataManager = metaDataManager;
		this.baseAddress = baseAddress;
		this.servicesMap = servicesMap;
		this.channel = channel;
		this.notificationsManager = new NotificationsManager(this);
	}

	public MetaDataManager getMetaDataManager() {
		return metaDataManager;
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

	public void authenticate() throws ServerException, UserException {
		try {
			AuthInterface authInterface = channel.get(AuthInterface.class);
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

	public ClientIfcModel getModel(SProject project, long roid, boolean deep, boolean recordChanges, boolean includeGeometry) throws UserException, ServerException {
		if (roid == -1) {
			throw new UserException("Roid cannot be -1");
		}
		return new ClientIfcModel(this, project.getOid(), roid, deep, getMetaDataManager().getPackageMetaData(project.getSchema()), recordChanges, includeGeometry);
	}
	
	public StreamingModel getStreamingModel(SProject project, long roid) {
		return new StreamingModel(this, metaDataManager.getPackageMetaData(project.getSchema()), roid);
	}

	public boolean isConnected() {
		return token != null;
	}

	public void unregisterNotificationListener(NotificationInterface notificationInterface) {
		notificationsManager.unregisterNotifictionListener(notificationInterface);
	}

	public NotificationInterface getNotificationInterface() throws PublicInterfaceNotFoundException {
		return get(NotificationInterface.class);
	}

	public RemoteServiceInterface getRemoteServiceInterface() throws PublicInterfaceNotFoundException {
		return get(RemoteServiceInterface.class);
	}
	
	public LowLevelInterface getLowLevelInterface() throws PublicInterfaceNotFoundException {
		return get(LowLevelInterface.class);
	}
	
	public ServiceInterface getServiceInterface() throws PublicInterfaceNotFoundException {
		return get(ServiceInterface.class);
	}

	public AdminInterface getAdminInterface() throws PublicInterfaceNotFoundException {
		return get(AdminInterface.class);
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

	public SLongCheckinActionState checkin(long poid, String comment, long deserializerOid, long fileSize, String filename, InputStream inputStream, CheckinProgressHandler progressHandler) throws ServerException, UserException, PublicInterfaceNotFoundException {
		long topicId = getServiceInterface().initiateCheckin(poid, deserializerOid);
		ProgressHandler progressHandlerWrapper = new ProgressHandler() {
			@Override
			public void progress(SLongActionState state) {
				progressHandler.progress(state.getTitle(), state.getProgress());
			}
		};
		getNotificationsManager().registerProgressHandler(topicId, progressHandlerWrapper);
		return channel.checkinSync(baseAddress, token, poid, comment, deserializerOid, false, fileSize, filename, inputStream, topicId);
	}

	public SLongCheckinActionState checkinSync(long poid, String comment, long deserializerOid, Path file, CheckinProgressHandler progressHandler) throws ServerException, UserException, PublicInterfaceNotFoundException {
		long topicId = getServiceInterface().initiateCheckin(poid, deserializerOid);
		ProgressHandler progressHandlerWrapper = new ProgressHandler() {
			@Override
			public void progress(SLongActionState state) {
				progressHandler.progress(state.getTitle(), state.getProgress());
			}
		};
		getNotificationsManager().registerProgressHandler(topicId, progressHandlerWrapper);
		try (InputStream newInputStream = Files.newInputStream(file)) {
			SLongCheckinActionState checkinSync = channel.checkinSync(baseAddress, token, poid, comment, deserializerOid, false, Files.size(file), file.getFileName().toString(), newInputStream, topicId);
			getNotificationsManager().unregisterProgressHandler(topicId, progressHandlerWrapper);
			return checkinSync;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public SLongCheckinActionState checkin(long poid, String comment, long deserializerOid, URL url, CheckinProgressHandler progressHandler) throws ServerException, UserException, PublicInterfaceNotFoundException {
		long topicId = getServiceInterface().initiateCheckin(poid, deserializerOid);
		ProgressHandler progressHandlerWrapper = new ProgressHandler() {
			@Override
			public void progress(SLongActionState state) {
				progressHandler.progress(state.getTitle(), state.getProgress());
			}
		};
		getNotificationsManager().registerProgressHandler(topicId, progressHandlerWrapper);

		try {
			InputStream openStream = url.openStream();
			try {
				channel.checkinAsync(baseAddress, token, poid, comment, deserializerOid, false, -1, url.toString(), openStream, topicId);
			} finally {
				openStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		getNotificationsManager().unregisterProgressHandler(topicId, progressHandlerWrapper);
		return (SLongCheckinActionState) getRegistry().getProgress(topicId);
	}
	
	public SLongCheckinActionState checkinSync(long poid, String comment, long deserializerOid, boolean merge, long fileSize, String filename, InputStream inputStream) throws UserException, ServerException {
		return channel.checkinSync(baseAddress, token, poid, comment, deserializerOid, merge, fileSize, filename, inputStream, null);
	}

	public long checkinAsync(long poid, String comment, long deserializerOid, boolean merge, long fileSize, String filename, InputStream inputStream, long topicId) throws UserException, ServerException {
		return channel.checkinAsync(baseAddress, token, poid, comment, deserializerOid, merge, fileSize, filename, inputStream, topicId);
	}

	public void bulkCheckin(long poid, Path file, String comment) throws UserException, ServerException {
		channel.bulkCheckin(baseAddress, token, poid, comment, file);
	}
	
	public SLongCheckinActionState checkinSync(long poid, String comment, long deserializerOid, boolean merge, URL url) throws UserException, ServerException {
		try {
			InputStream openStream = url.openStream();
			try {
				SLongCheckinActionState longActionState = channel.checkinSync(baseAddress, token, poid, comment, deserializerOid, merge, -1, url.toString(), openStream, null);
				if (longActionState.getState() == SActionState.AS_ERROR) {
					throw new UserException(Joiner.on(", ").join(longActionState.getErrors()));
				} else {
					return longActionState;
				}
			} finally {
				openStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public long checkinAsync(long poid, String comment, long deserializerOid, boolean merge, URL url, long topicId) throws UserException, ServerException {
		try {
			InputStream openStream = url.openStream();
			try {
				channel.checkinAsync(baseAddress, token, poid, comment, deserializerOid, merge, -1, url.toString(), openStream, topicId);
				return topicId;
			} finally {
				openStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public void download(long roid, long serializerOid, OutputStream outputStream) throws BimServerClientException {
		try {
			Long topicId = getServiceInterface().download(Collections.singleton(roid), DefaultQueries.allAsString(), serializerOid, false);
			SLongActionState progress = getNotificationRegistryInterface().getProgress(topicId);
			if (progress != null && progress.getState() == SActionState.AS_ERROR) {
				throw new BimServerClientException(Joiner.on(", ").join(progress.getErrors()));
			} else {
				try (InputStream inputStream = getDownloadData(topicId)) {
					IOUtils.copy(inputStream, outputStream);
					getServiceInterface().cleanupLongAction(topicId);
				}
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

	public void download(long roid, long serializerOid, Path file) throws IOException, BimServerClientException {
		FileOutputStream outputStream = new FileOutputStream(file.toFile());
		try {
			download(roid, serializerOid, outputStream);
		} finally {
			outputStream.close();
		}
	}
	
	@Override
	public void download(long roid, Query query, long serializerOid, Path file) throws IOException, BimServerClientException {
//		JsonQueryObjectModelConverter jsonQueryObjectModelConverter = new JsonQueryObjectModelConverter();
//		Long topicId = getServiceInterface().download(Collections.singleton(roid), jsonQueryObjectModelConverter.toJson(query).toString(), serializerOid, true);
//		InputStream downloadData = getDownloadData(topicId);
//		IOUtils.copy(downloadData, new FileOutputStream(file.toFile()));
	}
	
	@Override
	public void download(long roid, String query, long serializerOid, Path file) throws ServerException, UserException, PublicInterfaceNotFoundException, IOException {
		Long topicId = getServiceInterface().download(Collections.singleton(roid), query, serializerOid, false);
		try (InputStream downloadData = getDownloadData(topicId)) {
			FileOutputStream fos = new FileOutputStream(file.toFile());
			try {
				IOUtils.copy(downloadData, fos);
			} finally {
				fos.close();
			}
		}
	}

	public InputStream getDownloadData(long topicId) throws IOException {
		return channel.getDownloadData(baseAddress, token, topicId);
	}

	public IfcModelInterface newModel(SProject project, boolean recordChanges) throws ServerException, UserException, BimServerClientException, PublicInterfaceNotFoundException {
		return new ClientIfcModel(this, project.getOid(), -1, false, getMetaDataManager().getPackageMetaData(project.getSchema()), recordChanges, false);
	}

	public <T extends PublicInterface> T get(Class<T> clazz) throws PublicInterfaceNotFoundException {
		T t = channel.get(clazz);
		if (t == null) {
			throw new PublicInterfaceNotFoundException("No interface of type " + clazz.getSimpleName() + " registered on this channel");
		}
		return t;
	}
	
	@Override
	public MetaInterface getMeta() throws PublicInterfaceNotFoundException {
		return channel.getMeta();
	}
	
	@Override
	public NotificationRegistryInterface getRegistry() throws PublicInterfaceNotFoundException {
		return channel.getRegistry();
	}

	public AuthInterface getBimServerAuthInterface() throws PublicInterfaceNotFoundException {
		return channel.getBimServerAuthInterface();
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
			synchronized (notificationsManager) {
				if (!notificationsManager.isRunning()) {
					notificationsManager.connect(servicesMap, baseAddress);
					notificationsManager.startAndWaitForInit();
				}
			}
		}
		return notificationsManager;
	}

	@Override
	public Geometry getGeometry(long roid, IdEObject ifcProduct) {
		try {
			SSerializerPluginConfiguration serializerByPluginClassName = getPluginInterface().getSerializerByPluginClassName("org.bimserver.serializers.binarygeometry.BinaryGeometrySerializerPlugin");
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			download(roid, serializerByPluginClassName.getOid(), outputStream);
			Files.write(Paths.get("bin.bin"), outputStream.toByteArray());
			ByteArrayInputStream bain = new ByteArrayInputStream(outputStream.toByteArray());
			return new Geometry(bain, ifcProduct.getOid());
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BimServerClientException e) {
			e.printStackTrace();
		}
		return null;
	}

	public long getBinaryGeometryMessagingStreamingSerializerOid() throws ServerException, UserException, PublicInterfaceNotFoundException {
		if (binaryGeometryMessagingStreamingSerializer == -1) {
			SSerializerPluginConfiguration serializerPluginConfiguration = getPluginInterface().getSerializerByPluginClassName("org.bimserver.serializers.binarygeometry.BinaryGeometryMessagingStreamingSerializerPlugin");
			if (serializerPluginConfiguration != null) {
				binaryGeometryMessagingStreamingSerializer = serializerPluginConfiguration.getOid();
			} else {
				throw new UserException("No binary geometry messaging serializer found");
			}
		}
		return binaryGeometryMessagingStreamingSerializer;
	}
	
	public long query(Query query, long roid, long serializerOid) throws ServerException, UserException, PublicInterfaceNotFoundException {
		ObjectNode queryNode = new JsonQueryObjectModelConverter(query.getPackageMetaData()).toJson(query);
		Long topicId = getServiceInterface().download(Collections.singleton(roid), queryNode.toString(), serializerOid, false);
		return topicId;
	}

	@Override
	public void close() throws Exception {
		disconnect();
	}

	public void downloadExtendedData(long edid, Path outputFile) throws IOException {
		try (InputStream downloadData = channel.getDownloadExtendedData(baseAddress, token, edid)) {
			Files.copy(downloadData, outputFile, StandardCopyOption.REPLACE_EXISTING);
		}
	}

	public void downloadExtendedData(long edid, OutputStream outputStream) throws IOException {
		try (InputStream downloadData = channel.getDownloadExtendedData(baseAddress, token, edid)) {
			IOUtils.copy(downloadData, outputStream);
		}
	}

	@Override
	public NewServicesInterface getNewServicesInterface() throws PublicInterfaceNotFoundException {
		return get(NewServicesInterface.class);
	}

	@Override
	public NotificationRegistryInterface getNotificationRegistryInterface() throws PublicInterfaceNotFoundException {
		return get(NotificationRegistryInterface.class);
	}

	@Override
	public void saveDownloadData(long topicId, Path path) throws IOException {
		try (InputStream inputStream = channel.getDownloadData(baseAddress, token, topicId)) {
			try (OutputStream newOutputStream = Files.newOutputStream(path)) {
				IOUtils.copy(inputStream, newOutputStream);
			}
		}
	}

	@Override
	public SLongCheckinActionState checkinSync(long poid, String comment, long deserializerOid, boolean merge, Path file)
			throws IOException, UserException, ServerException {
		try (InputStream newInputStream = Files.newInputStream(file)) {
			return checkinSync(poid, comment, deserializerOid, merge, Files.size(file), file.getFileName().toString(), newInputStream);
		}
	}

	@Override
	public long checkinAsync(long poid, String comment, long deserializerOid, boolean merge, Path file, long topicId)
			throws IOException, UserException, ServerException {
		try (InputStream newInputStream = Files.newInputStream(file)) {
			return checkinAsync(poid, comment, deserializerOid, merge, Files.size(file), file.getFileName().toString(), newInputStream, topicId);
		}
	}
	
	public long getJsonSerializerOid() throws ServerException, UserException, PublicInterfaceNotFoundException {
		if (ifcSerializerOid == -1) {
			SSerializerPluginConfiguration serializerPluginConfiguration = getPluginInterface().getSerializerByPluginClassName("org.bimserver.serializers.JsonStreamingSerializerPlugin");
			if (serializerPluginConfiguration != null) {
				ifcSerializerOid = serializerPluginConfiguration.getOid();
			} else {
				throw new UserException("No JSON streaming serializer found");
			}
		}
		return ifcSerializerOid;
	}

	public long getBinaryGeometrySerializerOid() throws ServerException, UserException, PublicInterfaceNotFoundException {
		if (binaryGeometrySerializerOid == -1) {
			SSerializerPluginConfiguration serializerPluginConfiguration = getPluginInterface().getSerializerByPluginClassName("org.bimserver.serializers.binarygeometry.BinaryGeometrySerializerPlugin");
			if (serializerPluginConfiguration != null) {
				binaryGeometrySerializerOid = serializerPluginConfiguration.getOid();
			} else {
				throw new UserException("No binary geometry serializer found");
			}
		}
		return binaryGeometrySerializerOid;
	}
	
	public void waitForDonePreparing(long topicId) throws UserException, ServerException, PublicInterfaceNotFoundException {
		for (int i = 0; i < 10; i++) {
			SLongActionState progress = getRegistry().getProgress(topicId);
			if (progress != null) {
				if (progress.getTitle() != null && progress.getTitle().equals("Done preparing")) {
					break;
				} else if (progress.getState() == SActionState.AS_ERROR) {
					throw new UserException(Joiner.on(", ").join(progress.getErrors()));
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public AuthenticationInfo getAuthenticationInfo() {
		return authenticationInfo;
	}
	
	public String getBaseAddress() {
		return baseAddress;
	}
}