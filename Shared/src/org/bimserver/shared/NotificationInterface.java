package org.bimserver.shared;

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

import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.bimserver.interfaces.objects.SNewProjectNotification;
import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.exceptions.ServiceException;

public interface NotificationInterface {
	
	@WebMethod(action = "serverHasStarted")
	void serverHasStarted() throws ServiceException;
	
	@WebMethod(action = "serverWillBeShutdown")
	void serverWillBeShutdown() throws ServiceException;
	
	@WebMethod(action = "newProject")
	void newProject(
		@WebParam(name = "newProjectNotification", partName = "newProject.newProjectNotification") SNewProjectNotification newProjectNotification) throws ServiceException;
	
	@WebMethod(action = "newRevision")
	void newRevision(
		@WebParam(name = "newRevisionNotification", partName = "newRevision.newRevisionNotification") SNewRevisionNotification newRevisionNotification,
		@WebParam(name = "token", partName = "newRevision.token") SToken token,
		@WebParam(name = "apiUrl", partName = "newRevision.apiUrl") String apiUrl) throws ServiceException;
}