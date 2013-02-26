package org.bimserver.shared.interfaces;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public interface NotificationInterface extends PublicInterface {

	@WebMethod(action = "newRevision")
	void newRevision(
		@WebParam(name = "poid", partName = "progress.poid") Long poid,
		@WebParam(name = "roid", partName = "progress.roid") Long roid) throws UserException, ServerException;

	@WebMethod(action = "newExtendedData")
	void newExtendedData(
		@WebParam(name = "roid", partName = "progress.roid") Long roid,
		@WebParam(name = "edid", partName = "newExtendedData.edid") Long edid) throws UserException, ServerException;
	
	@WebMethod(action = "newProject")
	void newProject(
		@WebParam(name = "poid", partName = "newProject.poid") Long poid) throws UserException, ServerException;

	@WebMethod(action = "newUser")
	void newUser(
		@WebParam(name = "uoid", partName = "newUser.uoid") Long uoid) throws UserException, ServerException;
	
	@WebMethod(action = "progress")
	void progress(
		@WebParam(name = "topicId", partName = "progress.topicId") Long topicId, 
		@WebParam(name = "state", partName = "progress.state") SLongActionState state) throws UserException, ServerException;
}