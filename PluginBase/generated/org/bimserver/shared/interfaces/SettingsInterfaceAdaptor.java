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

public class SettingsInterfaceAdaptor implements org.bimserver.shared.interfaces.SettingsInterface {

	public java.lang.String getEmailSenderAddress() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Integer getProtocolBuffersPort() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SServerSettings getServerSettings() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String getServiceRepositoryUrl() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String getSiteAddress() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String getSmtpServer() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isAllowSelfRegistration() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isAllowUsersToCreateTopLevelProjects() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isCacheOutputFiles() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isCheckinMergingEnabled() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isGenerateGeometryOnCheckin() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isHideUserListForNonAdmin() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isPluginStrictVersionChecking() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isSendConfirmationEmailAfterRegistration() throws UserException, ServerException {
		return null;
	}
	
	public void setAllowSelfRegistration(java.lang.Boolean allowSelfRegistration) throws UserException, ServerException {
	}
	
	public void setAllowUsersToCreateTopLevelProjects(java.lang.Boolean allowUsersToCreateTopLevelProjects) throws UserException, ServerException {
	}
	
	public void setCacheOutputFiles(java.lang.Boolean cacheOutputFiles) throws UserException, ServerException {
	}
	
	public void setCheckinMergingEnabled(java.lang.Boolean checkinMergingEnabled) throws UserException, ServerException {
	}
	
	public void setEmailSenderAddress(java.lang.String emailSenderAddress) throws UserException, ServerException {
	}
	
	public void setGenerateGeometryOnCheckin(java.lang.Boolean generateGeometryOnCheckin) throws UserException, ServerException {
	}
	
	public void setHideUserListForNonAdmin(java.lang.Boolean hideUserListForNonAdmin) throws UserException, ServerException {
	}
	
	public void setPluginStrictVersionChecking(java.lang.Boolean strict) throws UserException, ServerException {
	}
	
	public void setProtocolBuffersPort(java.lang.Integer port) throws UserException, ServerException {
	}
	
	public void setSendConfirmationEmailAfterRegistration(java.lang.Boolean sendConfirmationEmailAfterRegistration) throws UserException, ServerException {
	}
	
	public void setServerDescription(java.lang.String strict) throws UserException, ServerException {
	}
	
	public void setServerIcon(java.lang.String serverIcon) throws UserException, ServerException {
	}
	
	public void setServerName(java.lang.String serverName) throws UserException, ServerException {
	}
	
	public void setServerSettings(org.bimserver.interfaces.objects.SServerSettings serverSettings) throws UserException, ServerException {
	}
	
	public void setServiceRepositoryUrl(java.lang.String url) throws UserException, ServerException {
	}
	
	public void setSiteAddress(java.lang.String siteAddress) throws UserException, ServerException {
	}
	
	public void setSmtpServer(java.lang.String smtpServer) throws UserException, ServerException {
	}
	
	public void setWhiteListedDomains(java.util.List<java.lang.String> domains) throws UserException, ServerException {
	}
	
}