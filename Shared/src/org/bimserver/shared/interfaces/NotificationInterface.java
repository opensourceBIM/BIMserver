package org.bimserver.shared.interfaces;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import org.bimserver.interfaces.objects.SImmediateNotificationResult;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProfileDescriptor;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public interface NotificationInterface extends PublicInterface {
	
	@WebMethod(action = "newLogAction")
	SImmediateNotificationResult newLogAction(
		@WebParam(name = "uuid", partName = "newLogAction.uuid") String uuid,
		@WebParam(name = "logAction", partName = "newLogAction.logAction") SLogAction logAction,
		@WebParam(name = "serviceIdentifier", partName = "newLogAction.serviceIdentifier") String serviceIdentifier,
		@WebParam(name = "profileIdentifer", partName = "newLogAction.profileIdentifer") String profileIdentifer,
		@WebParam(name = "token", partName = "newRevision.token") SToken token,
		@WebParam(name = "apiUrl", partName = "newRevision.apiUrl") String apiUrl) throws UserException, ServerException;

	@WebMethod(action = "progress")
	void progress(
		@WebParam(name = "topicId", partName = "progress.topicId") Long topicId, 
		@WebParam(name = "state", partName = "progress.state") SLongActionState state) throws UserException, ServerException;
	
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