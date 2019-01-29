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

public class AuthInterfaceAdaptor implements org.bimserver.shared.interfaces.AuthInterface {

	public java.lang.Boolean changePassword(java.lang.Long uoid, java.lang.String oldPassword, java.lang.String newPassword) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SAccessMethod getAccessMethod() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SUser getLoggedInUser() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean isLoggedIn() throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String login(java.lang.String username, java.lang.String password) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String loginUserToken(java.lang.String token) throws UserException, ServerException {
		return null;
	}
	
	public void logout() throws UserException, ServerException {
	}
	
	public void requestPasswordChange(java.lang.String username, java.lang.String resetUrl, java.lang.Boolean includeSiteAddress) throws UserException, ServerException {
	}
	
	public void setHash(java.lang.Long uoid, byte[] hash, byte[] salt) throws UserException, ServerException {
	}
	
	public org.bimserver.interfaces.objects.SUser validateAccount(java.lang.Long uoid, java.lang.String token, java.lang.String password) throws UserException, ServerException {
		return null;
	}
	
}