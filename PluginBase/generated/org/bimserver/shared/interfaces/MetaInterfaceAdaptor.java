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

public class MetaInterfaceAdaptor implements org.bimserver.shared.interfaces.MetaInterface {

	public java.lang.String getAllAsJson() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<java.lang.String> getEnumLiterals(java.lang.String enumName) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SServiceInterface getServiceInterface(java.lang.String getServiceInterface) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SServiceInterface> getServiceInterfaces() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SServiceMethod getServiceMethod(java.lang.String serviceInterfaceName, java.lang.String methodName) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SServiceParameter> getServiceMethodParameters(java.lang.String serviceInterfaceName, java.lang.String serviceMethodName) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SServiceMethod> getServiceMethods(java.lang.String serviceInterfaceName) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SServiceType> getServiceTypes() throws UserException, ServerException {
		return null;
	}
	
}