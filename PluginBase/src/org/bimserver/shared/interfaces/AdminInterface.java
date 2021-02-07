package org.bimserver.shared.interfaces;

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

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.bimserver.interfaces.objects.SBimServerInfo;
import org.bimserver.interfaces.objects.SDatabaseInformation;
import org.bimserver.interfaces.objects.SJavaInfo;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SMetrics;
import org.bimserver.interfaces.objects.SMigration;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.interfaces.objects.SServerInfo;
import org.bimserver.interfaces.objects.SSystemInfo;
import org.bimserver.interfaces.objects.SVersion;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

@WebService(name = "AdminInterface", targetNamespace="org.bimserver")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface AdminInterface extends PublicInterface {
	/**
	 * Get a list of all plugins
	 * @return A list of all plugins
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllPlugins")
	List<SPluginDescriptor> getAllPlugins() throws ServerException, UserException;
	
	/**
	 * Enable a plugin
	 * @param name Name of the plugin to enable
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "enablePlugin")
	void enablePlugin(
		@WebParam(name = "name", partName = "enablePlugin.name") String name) throws ServerException, UserException;
	
	/**
	 * Disable a plugin
	 * @param name Name of the plugin to disable
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "disablePlugin")
	void disablePlugin(
		@WebParam(name = "name", partName = "disablePlugin.name") String name) throws ServerException, UserException;
	
	/**
	 * Get information about the BIMserver database
	 * @return A SDatabaseInformation Object containing the information
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDatabaseInformation")
	SDatabaseInformation getDatabaseInformation() throws ServerException, UserException;

	/**
	 * Get information about the last database reset
	 * @return When the last database reset occurred
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getLastDatabaseReset")
	Date getLastDatabaseReset() throws ServerException, UserException;

	/**
	 * Setup this BIMserver. This BIMserver will not be available until you execute this method successfully. You can
	 * only do this once. After initial setup, use the methods provided by the SettingsInterface to change values.
	 * @param siteAddress The address the server will be reachable at (for example: http://demo.bimserver.org)
	 * @param adminName Name of the admin User (e.g. "Administrator")
	 * @param adminUsername Username of the admin User (must be a valid e-mail address)
	 * @param adminPassword Password of the admin User
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setup")
	void setup(
		@WebParam(name = "siteAddress", partName = "setup.siteAddress") String siteAddress,
		@WebParam(name = "serverName", partName = "setup.serverName") String serverName,
		@WebParam(name = "serverDescription", partName = "setup.serverDescription") String serverDescription,
		@WebParam(name = "serverIcon", partName = "setup.serverIcon") String serverIcon,
		@WebParam(name = "adminName", partName = "setup.adminName") String adminName,
		@WebParam(name = "adminUsername", partName = "setup.adminUsername") String adminUsername,
		@WebParam(name = "adminPassword", partName = "setup.adminPassword") String adminPassword) throws ServerException, UserException;
	
	/**
	 * Get a list of logged actions
	 * @return A list with all Log objects, Log objects contain information about action performed on the BIMserver like ProjectAdded, UserAdded etc...
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getLogs")
	List<SLogAction> getLogs() throws ServerException, UserException;

	/**
	 * Get a list of all migrations
	 * @return A list of all Migrations (either executed or not)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getMigrations")
	List<SMigration> getMigrations() throws ServerException, UserException;

	/**
	 * This will try to upgrade the database to the latest revision, this method will do nothing if the database schema is already up-to-date
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "migrateDatabase")
	void migrateDatabase() throws ServerException, UserException;
	
	/**
	 * Get information about this BIMserver's state
	 * @return A SServerInfo object containing information about the current state
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getServerInfo")
	SServerInfo getServerInfo() throws ServerException, UserException;
	
	/**
	 * Get the BIMserver log
	 * @return The BIMserver log (can be big)
	 * @throws ServerException 
	 */
	@WebMethod(action = "getServerLog")
	String getServerLog() throws ServerException, UserException;
	
	/**
	 * Initiate clearing the output cache
	 * @return The amount of removed files
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "clearOutputFileCache")
	Integer clearOutputFileCache() throws UserException, ServerException;

	/**
	 * Get information about the system this BIMserver is running on
	 * @return A SSystemInfo object
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getSystemInfo")
	SSystemInfo getSystemInfo() throws UserException, ServerException;
	
	/**
	 * Get information about the Java environment this BIMserver is running on
	 * @return A SJavaInfo object
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getJavaInfo")
	SJavaInfo getJavaInfo() throws UserException, ServerException;

	/**
	 * Get information about this BIMserver
	 * @return A SBimServerInfo object
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "getBimServerInfo")
	SBimServerInfo getBimServerInfo() throws ServerException, UserException;
	
	/**
	 * This will return the content of the .proto file (equivalent for SOAP's WSDL) for the ProtocolBuffers interface
	 * @return A serialized version of the .proto file
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getProtocolBuffersFile")
	String getProtocolBuffersFile(
		@WebParam(name = "interfaceName", partName = "getProtocolBuffersFile.interfaceName") String interfaceName) throws ServerException, UserException;
	
	/**
	 * Get the actual version of this BIMserver
	 * @return A SVersion object containg the version information
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getVersion")
	SVersion getVersion() throws ServerException, UserException;
	
	/**
	 * Check which version of BIMserver is the latest available (will download an XML file from bimserver.org)
	 * @return A SVersion object containing the version information
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getLatestVersion")
	SVersion getLatestVersion() throws ServerException, UserException;
	
	/**
	 * Check whether an upgrade of the BIMserver is available (will download an XML file from bimserver.org)
	 * @return Whether a new version is available
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "upgradePossible")
	Boolean upgradePossible() throws ServerException, UserException;
	
	/**
	 * Get the date when this BIMserver was last started
	 * @return The Date when the BIMserver was last started
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getServerStartTime")
	Date getServerStartTime() throws ServerException, UserException;

	/**
	 * Regenerate the geometry for a specified croid
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "regenerateGeometry")
	void regenerateGeometry(@WebParam(name = "croid", partName = "regenerateGeometry.croid") Long croid) throws ServerException, UserException;
	
	@WebMethod(action = "getMetrics")
	SMetrics getMetrics() throws UserException, ServerException;

	@WebMethod(action = "shutdown")
	void shutdown() throws UserException, ServerException;

	@WebMethod(action = "gc")
	void gc() throws UserException, ServerException;
}