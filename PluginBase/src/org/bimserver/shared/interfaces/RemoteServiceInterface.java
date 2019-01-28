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

import org.bimserver.interfaces.objects.SProfileDescriptor;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

@WebService(name = "RemoteServiceInterface", targetNamespace="org.bimserver")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface RemoteServiceInterface extends PublicInterface {
	
	/**
	 * This method gets called when a new revision has been created
	 * 
	 * @param poid ProjectID
	 * @param roid RevisionID
	 * @param soid ServiceID (optional)
	 * @param serviceIdentifier
	 * @param profileIdentifier
	 * @param userToken
	 * @param token
	 * @param apiUrl
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "newRevision")
	void newRevision(
		@WebParam(name = "poid", partName = "newRevision.poid") Long poid,
		@WebParam(name = "roid", partName = "newRevision.roid") Long roid,
		@WebParam(name = "soid", partName = "newRevision.soid") Long soid,
		@WebParam(name = "serviceIdentifier", partName = "newRevision.serviceIdentifier") String serviceIdentifier,
		@WebParam(name = "profileIdentifier", partName = "newRevision.profileIdentifier") String profileIdentifier,
		@WebParam(name = "userToken", partName = "newRevision.userToken") String userToken,
		@WebParam(name = "token", partName = "newRevision.token") String token,
		@WebParam(name = "apiUrl", partName = "newRevision.apiUrl") String apiUrl) throws UserException, ServerException;

	/**
	 * This method gets called when new extended data has been added to a project
	 * 
	 * @param poid ProjectID
	 * @param edid ExtendedDataID
	 * @param soid ServiceID (optional)
	 * @param serviceIdentifier
	 * @param profileIdentifier
	 * @param userToken
	 * @param token
	 * @param apiUrl
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "newExtendedDataOnProject")
	void newExtendedDataOnProject(
		@WebParam(name = "poid", partName = "newExtendedDataOnProject.poid") Long poid,
		@WebParam(name = "edid", partName = "newExtendedDataOnProject.edid") Long edid,
		@WebParam(name = "soid", partName = "newExtendedDataOnProject.soid") Long soid,
		@WebParam(name = "serviceIdentifier", partName = "newExtendedDataOnProject.serviceIdentifier") String serviceIdentifier,
		@WebParam(name = "profileIdentifier", partName = "newExtendedDataOnProject.profileIdentifier") String profileIdentifier,
		@WebParam(name = "userToken", partName = "newExtendedDataOnProject.userToken") String userToken,
		@WebParam(name = "token", partName = "newExtendedDataOnProject.token") String token,
		@WebParam(name = "apiUrl", partName = "newExtendedDataOnProject.apiUrl") String apiUrl) throws UserException, ServerException;

	/**
	 * This method gets called when new extended data has been added to a revision
	 * 
	 * @param poid
	 * @param roid
	 * @param edid
	 * @param soid
	 * @param serviceIdentifier
	 * @param profileIdentifier
	 * @param userToken
	 * @param token
	 * @param apiUrl
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "newExtendedDataOnRevision")
	void newExtendedDataOnRevision(
		@WebParam(name = "poid", partName = "newExtendedDataOnRevision.poid") Long poid,
		@WebParam(name = "roid", partName = "newExtendedDataOnRevision.roid") Long roid,
		@WebParam(name = "edid", partName = "newExtendedDataOnRevision.edid") Long edid,
		@WebParam(name = "soid", partName = "newExtendedDataOnRevision.soid") Long soid,
		@WebParam(name = "serviceIdentifier", partName = "newExtendedDataOnRevision.serviceIdentifier") String serviceIdentifier,
		@WebParam(name = "profileIdentifier", partName = "newExtendedDataOnRevision.profileIdentifier") String profileIdentifier,
		@WebParam(name = "userToken", partName = "newExtendedDataOnRevision.userToken") String userToken,
		@WebParam(name = "token", partName = "newExtendedDataOnRevision.token") String token,
		@WebParam(name = "apiUrl", partName = "newExtendedDataOnRevision.apiUrl") String apiUrl) throws UserException, ServerException;
	
	/**
	 * A remote server should be able to provide a list of profiles. This method returns the public profiles that do not need authentication
	 * 
	 * @param serviceIdentifier
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getPublicProfiles")
	List<SProfileDescriptor> getPublicProfiles(
		@WebParam(name = "serviceIdentifier", partName = "getPrivateProfiles.serviceIdentifier") String serviceIdentifier) throws UserException, ServerException;
	
	/**
	 * A remote server should be able to provide a list of profiles
	 * 
	 * @param serviceIdentifier A unique service identifier, defined by the remote server
	 * @param token A token the remote server can use to identify the user
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getPrivateProfiles")
	List<SProfileDescriptor> getPrivateProfiles(
		@WebParam(name = "serviceIdentifier", partName = "getPrivateProfiles.serviceIdentifier") String serviceIdentifier,
		@WebParam(name = "token", partName = "getPrivateProfiles.token") String token) throws UserException, ServerException;

	/**
	 * Should return a description of a certain service
	 * 
	 * @param serviceIdentifier Unique service identifier
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getService")
	SServiceDescriptor getService(
		@WebParam(name = "serviceIdentifier", partName = "getService.serviceIdentifier") String serviceIdentifier) throws UserException, ServerException;
}