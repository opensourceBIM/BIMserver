package org.bimserver.plugins.services;

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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;

import org.bimserver.database.queries.om.Query;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.interfaces.objects.SLongCheckinActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.ServiceHolder;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.NotificationRegistryInterface;
import org.bimserver.shared.interfaces.RemoteServiceInterface;

public interface BimServerClientInterface extends ServiceHolder, AutoCloseable {

	IfcModelInterface getModel(SProject project, long roid, boolean deep, boolean recordChanges, boolean includeGeometry) throws BimServerClientException, UserException, ServerException, PublicInterfaceNotFoundException;
	IfcModelInterface getModel(SProject project, long roid, boolean deep, boolean recordChanges) throws BimServerClientException, UserException, ServerException, PublicInterfaceNotFoundException;

	IfcModelInterface newModel(SProject newProject, boolean recordChanges) throws ServerException, UserException, BimServerClientException, PublicInterfaceNotFoundException;

	void commit(IfcModelInterface model, String comment);
	
	void download(long roid, long serializerOid, OutputStream outputStream) throws BimServerClientException;
	void download(long roid, long serializerOid, Path file) throws IOException, BimServerClientException;
	void download(long roid, Query query, long serializerOid, Path file) throws IOException, BimServerClientException;
	
	SLongCheckinActionState checkinSync(long poid, String comment, long deserializerOid, boolean merge, Path file) throws IOException, UserException, ServerException;
	long checkinAsync(long poid, String comment, long deserializerOid, boolean merge, Path file, long topicId) throws IOException, UserException, ServerException;
	SLongCheckinActionState checkinSync(long poid, String comment, long deserializerOid, Path file, CheckinProgressHandler progressHandler) throws ServerException, UserException, PublicInterfaceNotFoundException;

	SLongCheckinActionState checkinSync(long poid, String comment, long deserializerOid, boolean merge, URL url) throws UserException, ServerException;
	long checkinAsync(long poid, String comment, long deserializerOid, boolean merge, URL url, long topicId) throws UserException, ServerException;
	SLongCheckinActionState checkin(long poid, String comment, long deserializerOid, URL url, CheckinProgressHandler progressHandler) throws ServerException, UserException, PublicInterfaceNotFoundException;
	
	SLongCheckinActionState checkinSync(long poid, String comment, long deserializerOid, boolean merge, long fileSize, String filename, InputStream inputStream) throws UserException, ServerException;
	long checkinAsync(long poid, String comment, long deserializerOid, boolean merge, long fileSize, String filename, InputStream inputStream, long topicId) throws UserException, ServerException;
	SLongCheckinActionState checkin(long poid, String comment, long deserializerOid, long fileSize, String filename, InputStream inputStream, CheckinProgressHandler progressHandler) throws ServerException, UserException, PublicInterfaceNotFoundException;

	/**
	 * Convenience method that given you the InputStream belonging to an already started download
	 * 
	 * @param topicId The topic ID returned from initiating the download
	 * @throws IOException
	 */
	InputStream getDownloadData(long topicId) throws IOException;
	void saveDownloadData(long topicId, Path path) throws IOException;
	
	void setAuthentication(AuthenticationInfo authenticationInfo) throws ServerException, UserException, ChannelConnectionException;
	
	/**
	 * Get the geometry for the given revision/product, this method is not tested
	 * 
	 * @param roid
	 * @param ifcProduct
	 * @return
	 */
	Geometry getGeometry(long roid, IdEObject ifcProduct);

	AuthInterface getBimServerAuthInterface() throws PublicInterfaceNotFoundException;
	RemoteServiceInterface getRemoteServiceInterface() throws PublicInterfaceNotFoundException;
	NotificationRegistryInterface getNotificationRegistryInterface() throws PublicInterfaceNotFoundException;

	/**
	 * This will close all the connections, call this method as soon as you are done using this BimServerClient
	 */
	void disconnect();
	
	MetaDataManager getMetaDataManager();
	void download(long roid, String query, long oid, Path file) throws ServerException, UserException, PublicInterfaceNotFoundException, IOException;
	void authenticate() throws ServerException, UserException;
	void downloadExtendedData(long edid, OutputStream outputStream) throws IOException;
	AuthenticationInfo getAuthenticationInfo();
	String getBaseAddress();
	long query(Query query, long roid, long serializerOid) throws ServerException, UserException, PublicInterfaceNotFoundException;
	NotificationsManagerInterface getNotificationsManager();
	String getToken();
}