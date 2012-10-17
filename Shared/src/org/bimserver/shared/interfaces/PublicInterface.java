package org.bimserver.shared.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public interface PublicInterface {

	@WebMethod(action = "setToken")
	void setToken(
		@WebParam(name = "token", partName = "setToken.token") SToken token) throws ServerException, UserException;
	
	@WebMethod(action = "getCurrentToken")
	SToken getCurrentToken() throws ServerException, UserException;
}