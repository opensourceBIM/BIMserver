package org.bimserver.shared.interfaces;

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
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.exceptions.ServerException;

public class SettingsInterfaceAdaptor implements SettingsInterface {

	public org.bimserver.interfaces.objects.SServerSettings getServerSettings() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String getServiceRepositoryUrl() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String getSettingEmailSenderAddress() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Integer getSettingProtocolBuffersPort() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String getSettingSiteAddress() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String getSettingSmtpServer() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isSettingAllowSelfRegistration() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isSettingAllowUsersToCreateTopLevelProjects() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isSettingCacheOutputFiles() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isSettingCheckinMergingEnabled() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isSettingGenerateGeometryOnCheckin() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isSettingHideUserListForNonAdmin() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isSettingSendConfirmationEmailAfterRegistration() throws UserException, ServerException {
		return null;
	}
	
	public void setServerSettings(org.bimserver.interfaces.objects.SServerSettings serverSettings) throws UserException, ServerException {
	}
	
	public void setServiceRepositoryUrl(java.lang.String url) throws UserException, ServerException {
	}
	
	public void setSettingAllowSelfRegistration(java.lang.Boolean allowSelfRegistration) throws UserException, ServerException {
	}
	
	public void setSettingAllowUsersToCreateTopLevelProjects(java.lang.Boolean allowUsersToCreateTopLevelProjects) throws UserException, ServerException {
	}
	
	public void setSettingCacheOutputFiles(java.lang.Boolean cacheOutputFiles) throws UserException, ServerException {
	}
	
	public void setSettingCheckinMergingEnabled(java.lang.Boolean checkinMergingEnabled) throws UserException, ServerException {
	}
	
	public void setSettingEmailSenderAddress(java.lang.String emailSenderAddress) throws UserException, ServerException {
	}
	
	public void setSettingGenerateGeometryOnCheckin(java.lang.Boolean generateGeometryOnCheckin) throws UserException, ServerException {
	}
	
	public void setSettingHideUserListForNonAdmin(java.lang.Boolean hideUserListForNonAdmin) throws UserException, ServerException {
	}
	
	public void setSettingProtocolBuffersPort(java.lang.Integer port) throws UserException, ServerException {
	}
	
	public void setSettingSendConfirmationEmailAfterRegistration(java.lang.Boolean sendConfirmationEmailAfterRegistration) throws UserException, ServerException {
	}
	
	public void setSettingSiteAddress(java.lang.String siteAddress) throws UserException, ServerException {
	}
	
	public void setSettingSmtpServer(java.lang.String smtpServer) throws UserException, ServerException {
	}
	
	public void setWhiteListedDomains(java.util.List<java.lang.String> domains) throws UserException, ServerException {
	}
	
}