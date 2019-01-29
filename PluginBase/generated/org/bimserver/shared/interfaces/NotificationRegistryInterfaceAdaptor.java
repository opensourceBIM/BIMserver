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

public class NotificationRegistryInterfaceAdaptor implements org.bimserver.shared.interfaces.NotificationRegistryInterface {

	public org.bimserver.interfaces.objects.SLongActionState getProgress(java.lang.Long topicId) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<java.lang.Long> getProgressTopicsOnProject(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<java.lang.Long> getProgressTopicsOnRevision(java.lang.Long poid, java.lang.Long roid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<java.lang.Long> getProgressTopicsOnServer() throws UserException, ServerException {
		return null;
	}
	
	public void registerChangeProgressOnProject(java.lang.Long endPointId, java.lang.Long poid) throws UserException, ServerException {
	}
	
	public void registerChangeProgressOnRevision(java.lang.Long endPointId, java.lang.Long roid, java.lang.Long poid) throws UserException, ServerException {
	}
	
	public void registerChangeProgressOnServer(java.lang.Long endPointId) throws UserException, ServerException {
	}
	
	public void registerNewExtendedDataOnRevisionHandler(java.lang.Long endPointId, java.lang.Long roid) throws UserException, ServerException {
	}
	
	public void registerNewProjectHandler(java.lang.Long endPointId) throws UserException, ServerException {
	}
	
	public void registerNewRevisionHandler(java.lang.Long endPointId) throws UserException, ServerException {
	}
	
	public void registerNewRevisionOnSpecificProjectHandler(java.lang.Long endPointId, java.lang.Long poid) throws UserException, ServerException {
	}
	
	public void registerNewUserHandler(java.lang.Long endPointId) throws UserException, ServerException {
	}
	
	public void registerProgressHandler(java.lang.Long topicId, java.lang.Long endPointId) throws UserException, ServerException {
	}
	
	public java.lang.Long registerProgressOnProjectTopic(org.bimserver.interfaces.objects.SProgressTopicType type, java.lang.Long poid, java.lang.String description) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long registerProgressOnRevisionTopic(org.bimserver.interfaces.objects.SProgressTopicType type, java.lang.Long poid, java.lang.Long roid, java.lang.String description) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long registerProgressTopic(org.bimserver.interfaces.objects.SProgressTopicType type, java.lang.String description) throws UserException, ServerException {
		return null;
	}
	
	public void unregisterChangeProgressOnProject(java.lang.Long endPointId, java.lang.Long poid) throws UserException, ServerException {
	}
	
	public void unregisterChangeProgressOnRevision(java.lang.Long endPointId, java.lang.Long roid, java.lang.Long poid) throws UserException, ServerException {
	}
	
	public void unregisterChangeProgressOnServer(java.lang.Long endPointId) throws UserException, ServerException {
	}
	
	public void unregisterNewExtendedDataOnRevisionHandler(java.lang.Long endPointId, java.lang.Long roid) throws UserException, ServerException {
	}
	
	public void unregisterNewProjectHandler(java.lang.Long endPointId) throws UserException, ServerException {
	}
	
	public void unregisterNewRevisionHandler(java.lang.Long endPointId) throws UserException, ServerException {
	}
	
	public void unregisterNewRevisionOnSpecificProjectHandler(java.lang.Long endPointId, java.lang.Long poid) throws UserException, ServerException {
	}
	
	public void unregisterNewUserHandler(java.lang.Long endPointId) throws UserException, ServerException {
	}
	
	public void unregisterProgressHandler(java.lang.Long topicId, java.lang.Long endPointId) throws UserException, ServerException {
	}
	
	public void unregisterProgressTopic(java.lang.Long topicId) throws UserException, ServerException {
	}
	
	public void updateProgressTopic(java.lang.Long topicId, org.bimserver.interfaces.objects.SLongActionState state) throws UserException, ServerException {
	}
	
}