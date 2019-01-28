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

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.bimserver.interfaces.objects.SAuthorization;
import org.bimserver.interfaces.objects.SOAuthAuthorizationCode;
import org.bimserver.interfaces.objects.SOAuthServer;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

@WebService(name = "OAuthInterface", targetNamespace="org.bimserver")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface OAuthInterface extends PublicInterface {
	
	/**
	 * Registers this application (An installed BIMserver) to the given OAuth-enabled Service provider, this step is required for exchanging the clientSecret
	 * @throws UserException 
	 * @throws ServerException
	 * returns the clientId 
	 */
	@WebMethod(action="registerApplication")
	Long registerApplication(
		@WebParam(name = "registrationEndpoint", partName = "registerApplication.registrationEndpoint") String registrationEndpoint,
		@WebParam(name = "apiUrl", partName = "registerApplication.apiUrl") String apiUrl,
		@WebParam(name = "redirectUrl", partName = "registerApplication.redirectUrl") String redirectUrl) throws UserException, ServerException;

	/**
	 * @return Returns a list of OAuthClient objects that contains the information that this BIMserver stores about the connections it has with remote servers
	 * @throws ServerException 
	 * @throws UserException 
	 */
	@WebMethod(action="listRegisteredServers")
	List<SOAuthServer> listRegisteredServers() throws ServerException, UserException;

	@WebMethod(action="listRegisteredServersLocal")
	List<SOAuthServer> listRegisteredServersLocal() throws ServerException, UserException;
	
	@WebMethod(action="generateForwardUrl")
	String generateForwardUrl(
		@WebParam(name = "registrationEndpoint", partName = "generateForwardUrl.registrationEndpoint") String registrationEndpoint, 
		@WebParam(name = "authorizeUrl", partName = "generateForwardUrl.authorizeUrl") String authorizeUrl, 
		@WebParam(name = "returnUrl", partName = "generateForwardUrl.returnUrl") String returnUrl) throws ServerException, UserException;
	
	@WebMethod(action="setAuthorizationCode")
	void setAuthorizationCode(
		@WebParam(name = "applicationId", partName = "setAuthorizationCode.applicationId") Long applicationId, 
		@WebParam(name = "code", partName = "setAuthorizationCode.code") String code) throws UserException, ServerException;
	
	@WebMethod(action="getOAuthServerById")
	SOAuthServer getOAuthServerById(
		@WebParam(name = "oid", partName = "getOAuthServerById.oid") Long oid) throws ServerException, UserException;

	@WebMethod(action="getOAuthServerByClientId")
	SOAuthServer getOAuthServerByClientId(
			@WebParam(name = "clientId", partName = "getOAuthServerByClientId.clientId") String clientId) throws ServerException, UserException;
	
	@WebMethod(action="listAuthorizationCodes")
	List<SOAuthAuthorizationCode> listAuthorizationCodes() throws ServerException, UserException;

	@WebMethod(action="authorize")
	String authorize(
		@WebParam(name = "oAuthServerOid", partName = "authorize.oAuthServerOid") Long oAuthServerOid, 
		@WebParam(name = "authorization", partName = "authorize.authorization") SAuthorization authorization) throws ServerException, UserException;

	@WebMethod(action="revokeApplication")
	void revokeApplication(@WebParam(name = "oid", partName = "revoke.oid") Long oid) throws ServerException, UserException;

	@WebMethod(action="listIssuedAuthorizationCodes")
	List<SOAuthAuthorizationCode> listIssuedAuthorizationCodes() throws ServerException, UserException;
	
	@WebMethod(action="getAuthorizationById")
	SAuthorization getAuthorizationById(@WebParam(name = "oid", partName = "getAuthorizationById.oid") Long oid) throws ServerException, UserException;

	@WebMethod(action="revokeAuthorization")
	void revokeAuthorization(@WebParam(name = "oid", partName = "revokeAuthorization.oid") Long oid) throws ServerException, UserException;
	
	@WebMethod(action="getRemoteToken")
	String getRemoteToken(
		@WebParam(name = "soid", partName = "getRemoteToken.soid") Long soid,
		@WebParam(name = "code", partName = "getRemoteToken.code") String code,
		@WebParam(name = "serverId", partName = "getRemoteToken.serverId") Long serverId) throws ServerException, UserException;

	@WebMethod(action="registerRemoteApplication")
	SOAuthServer registerRemoteApplication(
		@WebParam(name = "redirectUrl", partName = "registerRemoteApplication.redirectUrl") String redirectUrl, 
		@WebParam(name = "name", partName = "registerRemoteApplication.name") String name, 
		@WebParam(name = "description", partName = "registerRemoteApplication.description") String description) throws UserException, ServerException;
}