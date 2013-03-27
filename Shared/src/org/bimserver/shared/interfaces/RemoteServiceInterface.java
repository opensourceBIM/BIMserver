package org.bimserver.shared.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.bimserver.interfaces.objects.SProfileDescriptor;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

@WebService(name = "RemoteServiceInterface", targetNamespace="org.buildingsmart.bimsie")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface RemoteServiceInterface extends PublicInterface {
	
	@WebMethod(action = "newRevision")
	void newRevision(
		@WebParam(name = "poid", partName = "newRevision.poid") Long poid,
		@WebParam(name = "roid", partName = "newRevision.roid") Long roid,
		@WebParam(name = "serviceIdentifier", partName = "newRevision.serviceIdentifier") String serviceIdentifier,
		@WebParam(name = "profileIdentifier", partName = "newRevision.profileIdentifier") String profileIdentifier,
		@WebParam(name = "token", partName = "newRevision.token") String token,
		@WebParam(name = "apiUrl", partName = "newRevision.apiUrl") String apiUrl) throws UserException, ServerException;
	
	@WebMethod(action = "getPublicProfiles")
	List<SProfileDescriptor> getPublicProfiles(
		@WebParam(name = "serviceIdentifier", partName = "getPrivateProfiles.serviceIdentifier") String serviceIdentifier) throws UserException, ServerException;
	
	@WebMethod(action = "getPrivateProfiles")
	List<SProfileDescriptor> getPrivateProfiles(
		@WebParam(name = "serviceIdentifier", partName = "getPrivateProfiles.serviceIdentifier") String serviceIdentifier,
		@WebParam(name = "token", partName = "getPrivateProfiles.token") String token) throws UserException, ServerException;

	@WebMethod(action = "getService")
	SServiceDescriptor getService(
		@WebParam(name = "serviceIdentifier", partName = "getService.serviceIdentifier") String serviceIdentifier) throws UserException, ServerException;
}