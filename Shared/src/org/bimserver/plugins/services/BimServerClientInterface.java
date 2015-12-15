package org.bimserver.plugins.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;

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

public interface BimServerClientInterface extends ServiceHolder, AutoCloseable {

	IfcModelInterface getModel(SProject project, long roid, boolean deep, boolean recordChanges, boolean includeGeometry) throws BimServerClientException, UserException, ServerException, PublicInterfaceNotFoundException;
	IfcModelInterface getModel(SProject project, long roid, boolean deep, boolean recordChanges) throws BimServerClientException, UserException, ServerException, PublicInterfaceNotFoundException;

	IfcModelInterface newModel(SProject newProject, boolean recordChanges) throws ServerException, UserException, BimServerClientException, PublicInterfaceNotFoundException;

	void commit(IfcModelInterface model, String comment);
	
	void download(long roid, long serializerOid, OutputStream outputStream);
	void download(long roid, long serializerOid, Path file) throws IOException;
	
	long checkin(long poid, String string, long deserializerOid, boolean merge, boolean sync, Path file) throws IOException, UserException, ServerException;
	
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