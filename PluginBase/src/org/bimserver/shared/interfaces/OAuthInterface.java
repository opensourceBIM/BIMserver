package org.bimserver.shared.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

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
		@WebParam(name = "apiUrl", partName = "registerApplication.apiUrl") String apiUrl) throws UserException, ServerException;

	/**
	 * @return Returns a list of OAuthClient objects that contains the information that this BIMserver stores about the connections it has with remote servers
	 * @throws ServerException 
	 * @throws UserException 
	 */
	@WebMethod(action="listRegisteredServers")
	List<SOAuthServer> listRegisteredServers() throws ServerException, UserException;

	@WebMethod(action="generateForwardUrl")
	String generateForwardUrl(
		@WebParam(name = "registrationEndpoint", partName = "generateForwardUrl.registrationEndpoint") String registrationEndpoint, 
		@WebParam(name = "authorizeUrl", partName = "generateForwardUrl.authorizeUrl") String authorizeUrl, 
		@WebParam(name = "returnUrl", partName = "generateForwardUrl.returnUrl") String returnUrl) throws ServerException, UserException;
	
	@WebMethod(action="setAuthorizationCode")
	void setAuthorizationCode(
		@WebParam(name = "applicationId", partName = "setAuthorizationCode.applicationId") Long applicationId, 
		@WebParam(name = "code", partName = "setAuthorizationCode.code") String code) throws UserException, ServerException;
}