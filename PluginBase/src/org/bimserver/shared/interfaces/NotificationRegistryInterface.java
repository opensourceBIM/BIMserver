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

import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

@WebService(name = "NotificationRegistryInterface", targetNamespace="org.bimserver")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface NotificationRegistryInterface extends PublicInterface {
	/**
	 * Register a progress topic, remember to unregister with unregisterProgressTopic when done
	 * 
	 * @param type The type of progress
	 * @param description A description of the running service
	 * @return A TopicID, which can be used by updateProgressTopic
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "registerProgressTopic")
	Long registerProgressTopic(
		@WebParam(name = "type", partName = "registerProgressTopic.type") SProgressTopicType type,
		@WebParam(name = "description", partName = "registerProgressTopic.description") String description) throws UserException, ServerException;

	/**
	 * Update the progress information on the given topic
	 * 
	 * @param topicId TopicID
	 * @param state The new state
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "updateProgressTopic")
	void updateProgressTopic(
		@WebParam(name = "topicId", partName = "registerProgressTopic.topicId") Long topicId, 
		@WebParam(name = "state", partName = "registerProgressTopic.state") SLongActionState state) throws UserException, ServerException;
	
	/**
	 * Unregister a progress topic on this server
	 * 
	 * @param topicId TopicID
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "unregisterProgressTopic")
	void unregisterProgressTopic(
		@WebParam(name = "topicId", partName = "unregisterProgressTopic.topicId") Long topicId) throws UserException, ServerException;
	
	/**
	 * @param topicId Register an endpoint to be notified of update on the given (progress) topic
	 * @param endPointId EndPointID, which identifies the endpoint
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "registerProgressHandler")
	void registerProgressHandler(
		@WebParam(name = "topicId", partName = "registerProgressHandler.topicId") Long topicId, 
		@WebParam(name = "endPointId", partName = "registerProgressHandler.endPointId") Long endPointId) throws UserException, ServerException;

	/**
	 * Register the given endpoint to be notified about new revisions on the given project
	 * 
	 * @param endPointId EndPointID
	 * @param poid Project OID
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "registerNewRevisionOnSpecificProjectHandler")
	void registerNewRevisionOnSpecificProjectHandler(
		@WebParam(name = "endPointId", partName = "registerNewRevisionOnSpecificProjectHandler.endPointId") Long endPointId,
		@WebParam(name = "poid", partName = "registerNewRevisionOnSpecificProjectHandler.poid") Long poid) throws UserException, ServerException;

	/**
	 * Register the given endpoint to be notified about new revisions
	 * 
	 * @param endPointId EndPointID
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "registerNewRevisionHandler")
	void registerNewRevisionHandler(
		@WebParam(name = "endPointId", partName = "registerNewRevisionHandler.endPointId") Long endPointId) throws UserException, ServerException;
	
	/**
	 * Register the given endpoint to be notified about extended data being added to the given revision
	 * 
	 * @param endPointId EndPointID
	 * @param roid Revision OID
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "registerNewExtendedDataOnRevisionHandler")
	void registerNewExtendedDataOnRevisionHandler(
		@WebParam(name = "endPointId", partName = "registerNewExtendedDataOnRevisionHandler.endPointId") Long endPointId,
		@WebParam(name = "roid", partName = "registerNewExtendedDataOnRevisionHandler.roid") Long roid) throws UserException, ServerException;

	/**
	 * Unregister, called after registerNewExtendedDataOnRevisionHandler
	 * 
	 * @param endPointId
	 * @param roid
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "unregisterNewExtendedDataOnRevisionHandler")
	void unregisterNewExtendedDataOnRevisionHandler(
		@WebParam(name = "endPointId", partName = "unregisterNewExtendedDataOnRevisionHandler.endPointId") Long endPointId,
		@WebParam(name = "roid", partName = "unregisterNewExtendedDataOnRevisionHandler.roid") Long roid) throws UserException, ServerException;

	/**
	 * Register this endpoint to be notified when a project has been added
	 * 
	 * @param endPointId
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "registerNewProjectHandler")
	void registerNewProjectHandler(
		@WebParam(name = "endPointId", partName = "registerNewProjectHandler.endPointId") Long endPointId) throws UserException, ServerException;

	/**
	 * Unregister this endpoint to be notified when a project has been added
	 * 
	 * @param endPointId
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "unregisterNewProjectHandler")
	void unregisterNewProjectHandler(
		@WebParam(name = "endPointId", partName = "unregisterNewProjectHandler.endPointId") Long endPointId) throws UserException, ServerException;

	/**
	 * Register this endpoint to be notified when a new user has been added
	 * 
	 * @param endPointId
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "registerNewUserHandler")
	void registerNewUserHandler(
		@WebParam(name = "endPointId", partName = "registerNewUserHandler.endPointId") Long endPointId) throws UserException, ServerException;
	
	/**
	 * Unregister this endpoint to be notified when a new user has been added
	 * 
	 * @param endPointId
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "unregisterNewUserHandler")
	void unregisterNewUserHandler(
		@WebParam(name = "endPointId", partName = "unregisterNewUserHandler.endPointId") Long endPointId) throws UserException, ServerException;
	
	/**
	 * 
	 * 
	 * @param endPointId
	 * @param poid
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "unregisterNewRevisionOnSpecificProjectHandler")
	void unregisterNewRevisionOnSpecificProjectHandler(
		@WebParam(name = "endPointId", partName = "unregisterNewRevisionOnSpecificProjectHandler.endPointId") Long endPointId,
		@WebParam(name = "poid", partName = "unregisterNewRevisionOnSpecificProjectHandler.poid") Long poid) throws UserException, ServerException;

	/**
	 * @param endPointId
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "unregisterNewRevisionHandler")
	void unregisterNewRevisionHandler(
		@WebParam(name = "endPointId", partName = "unregisterNewRevisionHandler.endPointId") Long endPointId) throws UserException, ServerException;

	/**
	 * @param topicId
	 * @param endPointId
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "unregisterProgressHandler")
	void unregisterProgressHandler(
		@WebParam(name = "topicId", partName = "unregisterProgressHandler.topicId") Long topicId, 
		@WebParam(name = "endPointId", partName = "unregisterProgressHandler.endPointId") Long endPointId) throws UserException, ServerException;

	/**
	 * @param topicId
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getProgress")
	SLongActionState getProgress(
		@WebParam(name = "topicId", partName = "getProgress.topicId") Long topicId) throws UserException, ServerException;
	
	/**
	 * @param poid
	 * @param roid
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getProgressTopicsOnRevision")
	List<Long> getProgressTopicsOnRevision(
		@WebParam(name = "poid", partName = "getProgressTopicsOnRevision.poid") Long poid,
		@WebParam(name = "roid", partName = "getProgressTopicsOnRevision.roid") Long roid) throws UserException, ServerException;

	/**
	 * @param poid
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getProgressTopicsOnProject")
	List<Long> getProgressTopicsOnProject(
		@WebParam(name = "poid", partName = "getProgressTopicsOnProject.poid") Long poid) throws UserException, ServerException;

	/**
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "getProgressTopicsOnServer")
	List<Long> getProgressTopicsOnServer() throws UserException, ServerException;
	
	/**
	 * @param type
	 * @param poid
	 * @param roid
	 * @param description
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "registerProgressOnRevisionTopic")
	Long registerProgressOnRevisionTopic(
		@WebParam(name = "type", partName = "registerProgressOnRevisionTopic.type") SProgressTopicType type, 
		@WebParam(name = "poid", partName = "registerProgressOnRevisionTopic.poid") Long poid, 
		@WebParam(name = "roid", partName = "registerProgressOnRevisionTopic.roid") Long roid, 
		@WebParam(name = "description", partName = "registerProgressOnRevisionTopic.description") String description) throws UserException, ServerException;

	/**
	 * Register a new progress topic that is related to the given project
	 * 
	 * @param type
	 * @param poid
	 * @param description
	 * @return
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "registerProgressOnProjectTopic")
	Long registerProgressOnProjectTopic(
		@WebParam(name = "type", partName = "registerProgressOnProjectTopic.type") SProgressTopicType type, 
		@WebParam(name = "poid", partName = "registerProgressOnProjectTopic.poid") Long poid, 
		@WebParam(name = "description", partName = "registerProgressOnProjectTopic.description") String description) throws UserException, ServerException;
	
	/**
	 * @param endPointId
	 * @param poid
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "registerChangeProgressOnProject")
	void registerChangeProgressOnProject(
		@WebParam(name = "endPointId", partName = "registerChangeProgressOnProject.endPointId") Long endPointId, 
		@WebParam(name = "poid", partName = "registerChangeProgressOnProject.poid") Long poid) throws ServerException, UserException;
	
	/**
	 * @param endPointId
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "registerChangeProgressOnServer")
	void registerChangeProgressOnServer(
		@WebParam(name = "endPointId", partName = "registerChangeProgressOnServer.endPointId") Long endPointId) throws ServerException, UserException;
	
	/**
	 * @param endPointId
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "unregisterChangeProgressOnServer")
	void unregisterChangeProgressOnServer(
		@WebParam(name = "endPointId", partName = "unregisterChangeProgressOnServer.endPointId") Long endPointId) throws ServerException, UserException;
	
	/**
	 * @param endPointId
	 * @param roid
	 * @param poid
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "registerChangeProgressOnRevision")
	void registerChangeProgressOnRevision(
		@WebParam(name = "endPointId", partName = "registerChangeProgressOnRevision.endPointId") Long endPointId,
		@WebParam(name = "roid", partName = "registerChangeProgressOnRevision.roid") Long roid,
		@WebParam(name = "poid", partName = "registerChangeProgressOnRevision.poid") Long poid) throws ServerException, UserException;
	
	/**
	 * @param endPointId
	 * @param poid
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "unregisterChangeProgressOnProject")
	void unregisterChangeProgressOnProject(
		@WebParam(name = "endPointId", partName = "unregisterChangeProgressOnProject.endPointId") Long endPointId, 
		@WebParam(name = "poid", partName = "unregisterChangeProgressOnProject.poid") Long poid) throws ServerException, UserException;

	/**
	 * @param endPointId
	 * @param roid
	 * @param poid
	 * @throws ServerException
	 * @throws UserException
	 */
	@WebMethod(action = "unregisterChangeProgressOnRevision")
	void unregisterChangeProgressOnRevision(
		@WebParam(name = "endPointId", partName = "unregisterChangeProgressOnRevision.endPointId") Long endPointId, 
		@WebParam(name = "roid", partName = "unregisterChangeProgressOnRevision.roid") Long roid,
		@WebParam(name = "poid", partName = "unregisterChangeProgressOnRevision.poid") Long poid) throws ServerException, UserException;
}