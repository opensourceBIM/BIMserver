package org.bimserver.shared.interfaces;

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
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.exceptions.ServerException;

public class Bimsie1AuthInterfaceAdaptor implements org.bimserver.shared.interfaces.bimsie1.Bimsie1AuthInterface {

	public org.bimserver.interfaces.objects.SAccessMethod getAccessMethod() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isLoggedIn() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String login(java.lang.String username, java.lang.String password) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String loginOpenId(java.lang.String op, java.lang.String returnUrl) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String loginUserToken(java.lang.String token) throws UserException, ServerException {
		return null;
	}
	
	public void logout() throws UserException, ServerException {
	}
	
	public java.lang.String validateOpenId(java.lang.String queryString) throws UserException, ServerException {
		return null;
	}
	
}