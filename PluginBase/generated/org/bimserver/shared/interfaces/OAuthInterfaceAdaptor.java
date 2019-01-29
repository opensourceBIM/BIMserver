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

public class OAuthInterfaceAdaptor implements org.bimserver.shared.interfaces.OAuthInterface {

	public java.lang.String authorize(java.lang.Long oAuthServerOid, org.bimserver.interfaces.objects.SAuthorization authorization) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String generateForwardUrl(java.lang.String registrationEndpoint, java.lang.String authorizeUrl, java.lang.String returnUrl) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SAuthorization getAuthorizationById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SOAuthServer getOAuthServerByClientId(java.lang.String clientId) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SOAuthServer getOAuthServerById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String getRemoteToken(java.lang.Long soid, java.lang.String code, java.lang.Long serverId) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SOAuthAuthorizationCode> listAuthorizationCodes() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SOAuthAuthorizationCode> listIssuedAuthorizationCodes() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SOAuthServer> listRegisteredServers() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SOAuthServer> listRegisteredServersLocal() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long registerApplication(java.lang.String registrationEndpoint, java.lang.String apiUrl, java.lang.String redirectUrl) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SOAuthServer registerRemoteApplication(java.lang.String redirectUrl, java.lang.String name, java.lang.String description) throws UserException, ServerException {
		return null;
	}
	
	public void revokeApplication(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void revokeAuthorization(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void setAuthorizationCode(java.lang.Long applicationId, java.lang.String code) throws UserException, ServerException {
	}
	
}