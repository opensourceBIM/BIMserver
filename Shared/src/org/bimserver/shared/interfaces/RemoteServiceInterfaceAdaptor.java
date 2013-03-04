package org.bimserver.shared.interfaces;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

public class RemoteServiceInterfaceAdaptor implements RemoteServiceInterface {

	public java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor> getPrivateProfiles(java.lang.String serviceIdentifier, java.lang.String token) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor> getPublicProfiles(java.lang.String serviceIdentifier) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SServiceDescriptor getService(java.lang.String serviceIdentifier) throws UserException, ServerException {
		return null;
	}
	
	public void newRevision(java.lang.Long poid, java.lang.Long roid, java.lang.String serviceIdentifier, java.lang.String profileIdentifier, java.lang.String token, java.lang.String apiUrl) throws UserException, ServerException {
	}
	
}