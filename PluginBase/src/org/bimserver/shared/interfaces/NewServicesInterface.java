package org.bimserver.shared.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.bimserver.interfaces.objects.SFormatSerializerMap;
import org.bimserver.interfaces.objects.SNewServiceDescriptor;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

@WebService(name = "NewServicesInterface", targetNamespace="org.bimserver")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface NewServicesInterface extends PublicInterface {
	/**
	 * @return
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action="listAllServiceDescriptors")
	List<SNewServiceDescriptor> listAllServiceDescriptors() throws ServerException, UserException;

	@WebMethod(action="listAvailableOutputFormats")
	List<SFormatSerializerMap> listAvailableOutputFormats(@WebParam(name = "poid", partName = "listAvailableOutputFormats.poid") Long poid) throws ServerException, UserException;
}
