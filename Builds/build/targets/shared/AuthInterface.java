package org.bimserver.shared.interfaces;

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

@WebService(name = "AuthInterface")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface AuthInterface extends PublicInterface {
	
	/**
	 * Login with a username/password combination
	 * @param username The username (must be a valid e-mail address)
	 * @param password The password
	 * @return True when successful, false if not
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "login")
	String login(
		@WebParam(name = "username", partName = "login.username") String username,
		@WebParam(name = "password", partName = "login.password") String password) throws ServerException, UserException;

	/**
	 * Login with an autologin hash (useful for the "remember-me" functionality in web-interfaces)
	 * @param username The username (must be a valid e-mail address)
	 * @param hash The hash (which is computed as sha256(username + sha256(password))
	 * @return True when successful, false if not
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "autologin")
	String autologin(
		@WebParam(name = "username", partName = "autologin.username") String username,
		@WebParam(name = "hash", partName = "autologin.hash") String hash) throws ServerException, UserException;

	/**
	 * Logout from this ServiceInterface (beware, the ServiceInterface is not closed and is still usable)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "logout")
	void logout() throws ServerException, UserException;
	
	/**
	 * @return The currently logged-in User
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getCurrentUser")
	SUser getCurrentUser() throws ServerException, UserException;

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

	/**
	 * Get the remove address (which is actually the address the server thinks the client is connecting from)
	 * @return A string with a hostname or ip address
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getRemoteAddress")
	String getRemoteAddress() throws ServerException, UserException;
	
	/**
	 * @return The User that it currently loggedin on this ServiceInterface
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getLoggedInUser")
	SUser getLoggedInUser() throws ServerException, UserException;
}
