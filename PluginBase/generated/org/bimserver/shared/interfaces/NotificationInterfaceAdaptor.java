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

public class NotificationInterfaceAdaptor implements org.bimserver.shared.interfaces.NotificationInterface {

	public void closedProgressOnProjectTopic(java.lang.Long poid, java.lang.Long topicId) throws UserException, ServerException {
	}
	
	public void closedProgressOnRevisionTopic(java.lang.Long poid, java.lang.Long roid, java.lang.Long topicId) throws UserException, ServerException {
	}
	
	public void closedProgressOnServerTopic(java.lang.Long topicId) throws UserException, ServerException {
	}
	
	public void newExtendedData(java.lang.Long roid, java.lang.Long edid) throws UserException, ServerException {
	}
	
	public void newProgressOnProjectTopic(java.lang.Long poid, java.lang.Long topicId) throws UserException, ServerException {
	}
	
	public void newProgressOnRevisionTopic(java.lang.Long poid, java.lang.Long roid, java.lang.Long topicId) throws UserException, ServerException {
	}
	
	public void newProgressOnServerTopic(java.lang.Long topicId) throws UserException, ServerException {
	}
	
	public void newProgressTopic(java.lang.Long topicId) throws UserException, ServerException {
	}
	
	public void newProject(java.lang.Long poid) throws UserException, ServerException {
	}
	
	public void newRevision(java.lang.Long poid, java.lang.Long roid) throws UserException, ServerException {
	}
	
	public void newUser(java.lang.Long uoid) throws UserException, ServerException {
	}
	
	public void progress(java.lang.Long topicId, org.bimserver.interfaces.objects.SLongActionState state) throws UserException, ServerException {
	}
	
}