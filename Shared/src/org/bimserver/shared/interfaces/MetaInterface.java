package org.bimserver.shared.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.bimserver.interfaces.objects.SServiceInterface;
import org.bimserver.interfaces.objects.SServiceMethod;
import org.bimserver.interfaces.objects.SServiceParameter;
import org.bimserver.interfaces.objects.SServiceType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public interface MetaInterface extends PublicInterface {
	@WebMethod(action="getServiceInterfaces")
	List<SServiceInterface> getServiceInterfaces() throws ServerException, UserException;
	
	@WebMethod(action="getServiceMethods")
	List<SServiceMethod> getServiceMethods(
		@WebParam(name = "serviceInterfaceName", partName = "getServiceMethods.serviceInterfaceName") String serviceInterfaceName) throws ServerException, UserException;
	
	@WebMethod(action="getServiceTypes")
	List<SServiceType> getServiceTypes(
		@WebParam(name = "serviceInterfaceName", partName = "getServiceTypes.serviceInterfaceName") String serviceInterfaceName) throws ServerException, UserException;
	
	@WebMethod(action="getServiceMethodParameters")
	List<SServiceParameter> getServiceMethodParameters(
		@WebParam(name = "serviceInterfaceName", partName = "getServiceMethodParameters.serviceInterfaceName") String serviceInterfaceName,
		@WebParam(name = "serviceMethodName", partName = "getServiceMethodParameters.serviceMethodName") String serviceMethodName) throws ServerException, UserException;
}
