package org.bimserver.shared.interfaces;

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
	 * @param serviceInterfaceName
	 * @return A list of all methods of the given service
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getServiceMethods")
	List<SServiceMethod> getServiceMethods(
		@WebParam(name = "serviceInterfaceName", partName = "getServiceMethods.serviceInterfaceName") String serviceInterfaceName) throws ServerException, UserException;
	
	/**
	 * @param serviceInterfaceName
	 * @return A list of all types known for the given service
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getServiceTypes")
	List<SServiceType> getServiceTypes(
		@WebParam(name = "serviceInterfaceName", partName = "getServiceTypes.serviceInterfaceName") String serviceInterfaceName) throws ServerException, UserException;
	
	/**
	 * @param serviceInterfaceName
	 * @param serviceMethodName
	 * @return A list of all parameters of the given method of the given service
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="getServiceMethodParameters")
	List<SServiceParameter> getServiceMethodParameters(
		@WebParam(name = "serviceInterfaceName", partName = "getServiceMethodParameters.serviceInterfaceName") String serviceInterfaceName,
		@WebParam(name = "serviceMethodName", partName = "getServiceMethodParameters.serviceMethodName") String serviceMethodName) throws ServerException, UserException;
}
