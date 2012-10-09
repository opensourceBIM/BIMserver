package org.bimserver.shared.interfaces;

import org.bimserver.interfaces.objects.SToken;
import org.bimserver.models.store.Token;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public interface PublicInterface {

	void setToken(Token token);
	SToken getCurrentToken() throws ServerException, UserException;
}