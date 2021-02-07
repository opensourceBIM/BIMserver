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

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.bimserver.interfaces.objects.SServiceInterface;
import org.bimserver.interfaces.objects.SServiceMethod;
import org.bimserver.interfaces.objects.SServiceParameter;
import org.bimserver.interfaces.objects.SServiceType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

@WebService(name = "MetaInterface", targetNamespace="org.bimserver")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface MetaInterface extends PublicInterface {
	/**
	 * @return A list of all the registered services
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getServiceInterfaces")
	List<SServiceInterface> getServiceInterfaces() throws ServerException, UserException;
	
	/**
	 * @return An SServiceInterface object containing the service information
	 * @param serviceInterfaceName The name of the service
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getServiceInterface")
	SServiceInterface getServiceInterface(
		@WebParam(name = "serverInterfaceName", partName = "getServiceInterface.serviceInterfaceName") String serviceInterfaceName) throws ServerException, UserException;
	
	/**
	 * @param serviceInterfaceName The name of the service
	 * @return A list of all methods of the given service
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getServiceMethods")
	List<SServiceMethod> getServiceMethods(
		@WebParam(name = "serviceInterfaceName", partName = "getServiceMethods.serviceInterfaceName") String serviceInterfaceName) throws ServerException, UserException;

	/**
	 * @param serviceInterfaceName The name of the service
	 * @param methodName The name of the method
	 * @return The method with the given name of the given service
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getServiceMethod")
	SServiceMethod getServiceMethod(
		@WebParam(name = "serviceInterfaceName", partName = "getServiceMethod.serviceInterfaceName") String serviceInterfaceName,
		@WebParam(name = "methodName", partName = "getServiceMethod.methodName") String methodName) throws ServerException, UserException;
	
	/**
	 * @return A list of all types known for the given service
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getServiceTypes")
	List<SServiceType> getServiceTypes() throws ServerException, UserException;
	
	/**
	 * @param serviceInterfaceName The name of the service
	 * @param serviceMethodName The name of the method
	 * @return A list of all parameters of the given method of the given service
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getServiceMethodParameters")
	List<SServiceParameter> getServiceMethodParameters(
		@WebParam(name = "serviceInterfaceName", partName = "getServiceMethodParameters.serviceInterfaceName") String serviceInterfaceName,
		@WebParam(name = "serviceMethodName", partName = "getServiceMethodParameters.serviceMethodName") String serviceMethodName) throws ServerException, UserException;

	@WebMethod(action="getEnumLiterals")
	List<String> getEnumLiterals(
		@WebParam(name = "enumName", partName = "getEnumLiterals.enumName") String enumName) throws UserException, ServerException;
	
	@WebMethod(action="getAllAsJson")
	String getAllAsJson() throws UserException, ServerException;
}
