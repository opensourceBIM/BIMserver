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
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.exceptions.ServerException;

public class AdminInterfaceAdaptor implements org.bimserver.shared.interfaces.AdminInterface {

	public java.lang.Integer clearOutputFileCache() throws UserException, ServerException {
		return null;
	}
	
	public void disablePlugin(java.lang.String name) throws UserException, ServerException {
	}
	
	public void enablePlugin(java.lang.String name) throws UserException, ServerException {
	}
	
	public void gc() throws UserException, ServerException {
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> getAllPlugins() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SBimServerInfo getBimServerInfo() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SDatabaseInformation getDatabaseInformation() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SJavaInfo getJavaInfo() throws UserException, ServerException {
		return null;
	}
	
	public java.util.Date getLastDatabaseReset() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SVersion getLatestVersion() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SLogAction> getLogs() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SMetrics getMetrics() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SMigration> getMigrations() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String getProtocolBuffersFile(java.lang.String interfaceName) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SServerInfo getServerInfo() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String getServerLog() throws UserException, ServerException {
		return null;
	}
	
	public java.util.Date getServerStartTime() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SSystemInfo getSystemInfo() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SVersion getVersion() throws UserException, ServerException {
		return null;
	}
	
	public void migrateDatabase() throws UserException, ServerException {
	}
	
	public void regenerateGeometry(java.lang.Long croid) throws UserException, ServerException {
	}
	
	public void setup(java.lang.String siteAddress, java.lang.String serverName, java.lang.String serverDescription, java.lang.String serverIcon, java.lang.String adminName, java.lang.String adminUsername, java.lang.String adminPassword) throws UserException, ServerException {
	}
	
	public void shutdown() throws UserException, ServerException {
	}
	
	public java.lang.Boolean upgradePossible() throws UserException, ServerException {
		return null;
	}
	
}