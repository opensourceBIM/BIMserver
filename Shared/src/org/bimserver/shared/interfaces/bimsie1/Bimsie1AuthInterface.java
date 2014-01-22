package org.bimserver.shared.interfaces.bimsie1;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PublicInterface;

@WebService(name = "Bimsie1AuthInterface", targetNamespace="org.buildingsmart.bimsie1")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface Bimsie1AuthInterface extends PublicInterface {
	
	/**
	 * Login with a username/password combination
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

	@WebMethod(action = "loginOpenId")
	String loginOpenId(
		@WebParam(name = "op", partName = "loginOpenId.op") String op,
		@WebParam(name = "returnUrl", partName = "loginOpenId.returnUrl") String returnUrl) throws ServerException, UserException;

	@WebMethod(action = "validateOpenId")
	String validateOpenId(
		@WebParam(name = "queryString", partName = "validateOpenId.queryString") String queryString) throws ServerException, UserException;
	
	/**
	 * Logout
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "logout")
	void logout() throws ServerException, UserException;
	
	/**
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

	@WebMethod(action = "loginUserToken")
	String loginUserToken(
		@WebParam(name = "token", partName = "loginUserToken.token") String token) throws ServerException, UserException;
}