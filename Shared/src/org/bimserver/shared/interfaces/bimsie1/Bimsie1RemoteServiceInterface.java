package org.bimserver.shared.interfaces.bimsie1;

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
import org.bimserver.shared.interfaces.PublicInterface;

@WebService(name = "Bimsie1RemoteServiceInterface", targetNamespace="org.buildingsmart.bimsie1")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface Bimsie1RemoteServiceInterface extends PublicInterface {
	
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