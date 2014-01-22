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

import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PublicInterface;

@WebService(name = "Bimsie1NotificationRegistryInterface", targetNamespace="org.buildingsmart.bimsie1")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface Bimsie1NotificationRegistryInterface extends PublicInterface {
	@WebMethod(action = "registerProgressTopic")
	Long registerProgressTopic(
		@WebParam(name = "type", partName = "registerProgressTopic.type") SProgressTopicType type,
		@WebParam(name = "description", partName = "registerProgressTopic.description") String description) throws UserException, ServerException;

	@WebMethod(action = "updateProgressTopic")
	void updateProgressTopic(
		@WebParam(name = "topicId", partName = "registerProgressTopic.topicId") Long topicId, 
		@WebParam(name = "state", partName = "registerProgressTopic.state") SLongActionState state) throws UserException, ServerException;
	
	@WebMethod(action = "unregisterProgressTopic")
	void unregisterProgressTopic(
		@WebParam(name = "topicId", partName = "unregisterProgressTopic.topicId") Long topicId) throws UserException, ServerException;
	
	@WebMethod(action = "registerProgressHandler")
	void registerProgressHandler(
		@WebParam(name = "topicId", partName = "registerProgressHandler.topicId") Long topicId, 
		@WebParam(name = "endPointId", partName = "registerProgressHandler.endPointId") Long endPointId) throws UserException, ServerException;

	@WebMethod(action = "registerNewRevisionOnSpecificProjectHandler")
	void registerNewRevisionOnSpecificProjectHandler(
		@WebParam(name = "endPointId", partName = "registerNewRevisionOnSpecificProjectHandler.endPointId") Long endPointId,
		@WebParam(name = "poid", partName = "registerNewRevisionOnSpecificProjectHandler.poid") Long poid) throws UserException, ServerException;

	@WebMethod(action = "registerNewRevisionHandler")
	void registerNewRevisionHandler(
		@WebParam(name = "endPointId", partName = "registerNewRevisionHandler.endPointId") Long endPointId) throws UserException, ServerException;
	
	@WebMethod(action = "registerNewExtendedDataOnRevisionHandler")
	void registerNewExtendedDataOnRevisionHandler(
		@WebParam(name = "endPointId", partName = "registerNewExtendedDataOnRevisionHandler.endPointId") Long endPointId,
		@WebParam(name = "roid", partName = "registerNewExtendedDataOnRevisionHandler.roid") Long roid) throws UserException, ServerException;

	@WebMethod(action = "unregisterNewExtendedDataOnRevisionHandler")
	void unregisterNewExtendedDataOnRevisionHandler(
		@WebParam(name = "endPointId", partName = "unregisterNewExtendedDataOnRevisionHandler.endPointId") Long endPointId,
		@WebParam(name = "roid", partName = "unregisterNewExtendedDataOnRevisionHandler.roid") Long roid) throws UserException, ServerException;

	@WebMethod(action = "registerNewProjectHandler")
	void registerNewProjectHandler(
		@WebParam(name = "endPointId", partName = "registerNewProjectHandler.endPointId") Long endPointId) throws UserException, ServerException;

	@WebMethod(action = "unregisterNewProjectHandler")
	void unregisterNewProjectHandler(
		@WebParam(name = "endPointId", partName = "unregisterNewProjectHandler.endPointId") Long endPointId) throws UserException, ServerException;

	@WebMethod(action = "registerNewUserHandler")
	void registerNewUserHandler(
		@WebParam(name = "endPointId", partName = "registerNewUserHandler.endPointId") Long endPointId) throws UserException, ServerException;
	
	@WebMethod(action = "unregisterNewUserHandler")
	void unregisterNewUserHandler(
		@WebParam(name = "endPointId", partName = "unregisterNewUserHandler.endPointId") Long endPointId) throws UserException, ServerException;
	
	@WebMethod(action = "unregisterNewRevisionOnSpecificProjectHandler")
	void unregisterNewRevisionOnSpecificProjectHandler(
		@WebParam(name = "endPointId", partName = "unregisterNewRevisionOnSpecificProjectHandler.endPointId") Long endPointId,
		@WebParam(name = "poid", partName = "unregisterNewRevisionOnSpecificProjectHandler.poid") Long poid) throws UserException, ServerException;

	@WebMethod(action = "unregisterNewRevisionHandler")
	void unregisterNewRevisionHandler(
		@WebParam(name = "endPointId", partName = "unregisterNewRevisionHandler.endPointId") Long endPointId) throws UserException, ServerException;

	@WebMethod(action = "unregisterProgressHandler")
	void unregisterProgressHandler(
		@WebParam(name = "topicId", partName = "unregisterProgressHandler.topicId") Long topicId, 
		@WebParam(name = "endPointId", partName = "unregisterProgressHandler.endPointId") Long endPointId) throws UserException, ServerException;

	@WebMethod(action = "getProgress")
	SLongActionState getProgress(
		@WebParam(name = "topicId", partName = "getProgress.topicId") Long topicId) throws UserException, ServerException;
	
	@WebMethod(action = "getProgressTopicsOnRevision")
	List<Long> getProgressTopicsOnRevision(
		@WebParam(name = "poid", partName = "getProgressTopicsOnRevision.poid") Long poid,
		@WebParam(name = "roid", partName = "getProgressTopicsOnRevision.roid") Long roid) throws UserException, ServerException;

	@WebMethod(action = "getProgressTopicsOnProject")
	List<Long> getProgressTopicsOnProject(
		@WebParam(name = "poid", partName = "getProgressTopicsOnProject.poid") Long poid) throws UserException, ServerException;

	@WebMethod(action = "getProgressTopicsOnServer")
	List<Long> getProgressTopicsOnServer() throws UserException, ServerException;
	
	@WebMethod(action = "registerProgressOnRevisionTopic")
	Long registerProgressOnRevisionTopic(
		@WebParam(name = "type", partName = "registerProgressOnRevisionTopic.type") SProgressTopicType type, 
		@WebParam(name = "poid", partName = "registerProgressOnRevisionTopic.poid") Long poid, 
		@WebParam(name = "roid", partName = "registerProgressOnRevisionTopic.roid") Long roid, 
		@WebParam(name = "description", partName = "registerProgressOnRevisionTopic.description") String description) throws UserException, ServerException;

	@WebMethod(action = "registerProgressOnProjectTopic")
	Long registerProgressOnProjectTopic(
		@WebParam(name = "type", partName = "registerProgressOnProjectTopic.type") SProgressTopicType type, 
		@WebParam(name = "poid", partName = "registerProgressOnProjectTopic.poid") Long poid, 
		@WebParam(name = "description", partName = "registerProgressOnProjectTopic.description") String description) throws UserException, ServerException;
	
	@WebMethod(action = "registerChangeProgressOnProject")
	void registerChangeProgressOnProject(
		@WebParam(name = "endPointId", partName = "registerChangeProgressOnProject.endPointId") Long endPointId, 
		@WebParam(name = "poid", partName = "registerChangeProgressOnProject.poid") Long poid) throws ServerException, UserException;
	
	@WebMethod(action = "registerChangeProgressOnServer")
	void registerChangeProgressOnServer(
		@WebParam(name = "endPointId", partName = "registerChangeProgressOnServer.endPointId") Long endPointId) throws ServerException, UserException;
	
	@WebMethod(action = "unregisterChangeProgressOnServer")
	void unregisterChangeProgressOnServer(
		@WebParam(name = "endPointId", partName = "unregisterChangeProgressOnServer.endPointId") Long endPointId) throws ServerException, UserException;
	
	@WebMethod(action = "registerChangeProgressOnRevision")
	void registerChangeProgressOnRevision(
		@WebParam(name = "endPointId", partName = "registerChangeProgressOnRevision.endPointId") Long endPointId,
		@WebParam(name = "roid", partName = "registerChangeProgressOnRevision.roid") Long roid,
		@WebParam(name = "poid", partName = "registerChangeProgressOnRevision.poid") Long poid) throws ServerException, UserException;
	
	@WebMethod(action = "unregisterChangeProgressOnProject")
	void unregisterChangeProgressOnProject(
		@WebParam(name = "endPointId", partName = "unregisterChangeProgressOnProject.endPointId") Long endPointId, 
		@WebParam(name = "poid", partName = "unregisterChangeProgressOnProject.poid") Long poid) throws ServerException, UserException;

	@WebMethod(action = "unregisterChangeProgressOnRevision")
	void unregisterChangeProgressOnRevision(
		@WebParam(name = "endPointId", partName = "unregisterChangeProgressOnRevision.endPointId") Long endPointId, 
		@WebParam(name = "roid", partName = "unregisterChangeProgressOnRevision.roid") Long roid,
		@WebParam(name = "poid", partName = "unregisterChangeProgressOnRevision.poid") Long poid) throws ServerException, UserException;
}