package org.bimserver.plugins.services;

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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.ServiceHolder;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1RemoteServiceInterface;

public interface BimServerClientInterface extends ServiceHolder {

	IfcModelInterface getModel(SProject project, long roid, boolean deep, boolean recordChanges, boolean includeGeometry) throws BimServerClientException, UserException, ServerException, PublicInterfaceNotFoundException;
	IfcModelInterface getModel(SProject project, long roid, boolean deep, boolean recordChanges) throws BimServerClientException, UserException, ServerException, PublicInterfaceNotFoundException;

	IfcModelInterface newModel(SProject newProject, boolean recordChanges) throws ServerException, UserException, BimServerClientException, PublicInterfaceNotFoundException;

	void commit(IfcModelInterface model, String comment);
	
	void download(long roid, long serializerOid, OutputStream outputStream);
	void download(long roid, long serializerOid, File file) throws IOException;
	
	long checkin(long poid, String string, long deserializerOid, boolean merge, boolean sync, File file) throws IOException, UserException, ServerException;
	
	/**
	 * Convenience method that given you the InputStream belonging to an already started download
	 * 
	 * @param download
	 * @param serializerOid
	 * @return
	 * @throws IOException
	 */
	InputStream getDownloadData(long download, long serializerOid) throws IOException;
	
	void setAuthentication(AuthenticationInfo authenticationInfo) throws ServerException, UserException, ChannelConnectionException;
	
	/**
	 * Get the geometry for the given revision/product, this method is not tested
	 * 
	 * @param roid
	 * @param ifcProduct
	 * @return
	 */
	Geometry getGeometry(long roid, IfcProduct ifcProduct);

	AuthInterface getBimServerAuthInterface() throws PublicInterfaceNotFoundException;
	Bimsie1RemoteServiceInterface getRemoteServiceInterface() throws PublicInterfaceNotFoundException;

	/**
	 * This will close all the connections, call this method as soon as you are done using this BimServerClient
	 */
	void disconnect();
}