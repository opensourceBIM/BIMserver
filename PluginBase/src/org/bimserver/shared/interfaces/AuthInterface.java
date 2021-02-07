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

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

@WebService(name = "AuthInterface", targetNamespace="org.bimserver")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface AuthInterface extends PublicInterface {
	/**
	 * Login with a username/password combination
	 * 
	 * @param username The username (must be a valid e-mail address)
	 * @param password The password
	 * @return A token, use this token in subsequent calls. Read the documentation of the transport 
	 * mechanism (SOAP, Protocol Buffers or JSON) to see how to send the token
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "login")
	String login(
		@WebParam(name = "username", partName = "login.username") String username,
		@WebParam(name = "password", partName = "login.password") String password) throws ServerException, UserException;

	/**
	 * Logout
	 * 
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "logout")
	void logout() throws ServerException, UserException;
	
	/**
	 * Check whether the server considers the user (token) as logged-in
	 * 
	 * @return Whether this ServiceInterface is logged-in
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "isLoggedIn")
	Boolean isLoggedIn() throws ServerException, UserException;

	/**
	 * @return The method of access this ServiceInterface is using (SOAP, PB etc...)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAccessMethod")
	SAccessMethod getAccessMethod() throws ServerException, UserException;

	/**
	 * Login with a user-token
	 * 
	 * @param token The token to login with
	 * @return A token, use this token in subsequent calls. Read the documentation of the transport 
	 * mechanism (SOAP, Protocol Buffers or JSON) to see how to send the token
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "loginUserToken")
	String loginUserToken(
		@WebParam(name = "token", partName = "loginUserToken.token") String token) throws ServerException, UserException;

	
	/**
	 * @return The User that it currently logged in on this ServiceInterface
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getLoggedInUser")
	SUser getLoggedInUser() throws ServerException, UserException;

	/**
	 * Change a User's password, not the preferred way, use requestPasswordChange for a safer version
	 * @param uoid The ObjectID of the User
	 * @param oldPassword The old password
	 * @param newPassword The new password
	 * @return Whether the password was successfully changed
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "changePassword")
	Boolean changePassword(
		@WebParam(name = "uoid", partName = "changePassword.uoid") Long uoid,
		@WebParam(name = "oldPassword", partName = "changePassword.oldPassword") String oldPassword,
		@WebParam(name = "newPassword", partName = "changePassword.newPassword") String newPassword) throws ServerException, UserException;

	/**
	 * Set password hash and salt for a user's password
	 * @param uoid The ObjectID of the user
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setHash")
	void setHash(
		@WebParam(name = "uoid", partName = "setHash.uoid") Long uoid,
		@WebParam(name = "hash", partName = "setHash.hash") byte[] hash,
		@WebParam(name = "salt", partName = "setHash.salt") byte[] salt) throws ServerException, UserException;
	
	/**
	 * Request a password change, an e-mail will be send with a validation url
	 * @param username The username of the user to change the password for
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "requestPasswordChange")
	void requestPasswordChange(
		@WebParam(name = "username", partName = "requestPasswordChange.username") String username,
		@WebParam(name = "resetUrl", partName = "requestPasswordChange.resetUrl") String resetUrl,
		@WebParam(name = "includeSiteAddress", partName = "requestPasswordChange.includeSiteAddress") Boolean includeSiteAddress) throws ServerException, UserException;

//	@WebMethod(action = "createToken")
//	String createToken(
//		@WebParam(name = "validitySeconds", partName = "createToken.validitySeconds") Integer validitySeconds) throws UserException, ServerException;

	/**
	 * @param uoid The ObejctID of the User
	 * @param token The token generated by requestPasswordChange
	 * @param password The new password
	 * @return A User object if the change is successful, null otherwise
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "validateAccount")
	SUser validateAccount(
		@WebParam(name = "uoid", partName = "validateAccount.uoid") Long uoid,
		@WebParam(name = "token", partName = "validateAccount.token") String token,
		@WebParam(name = "password", partName = "validateAccount.password") String password) throws ServerException, UserException;
}
