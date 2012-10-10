package org.bimserver.shared.interfaces;

import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public interface PublicInterface {

	void setToken(SToken token) throws ServerException, UserException;
	SToken getCurrentToken() throws ServerException, UserException;
}