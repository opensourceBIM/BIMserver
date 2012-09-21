package org.bimserver.client.notifications;

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

import java.io.PrintWriter;

import org.bimserver.interfaces.objects.SNewProjectNotification;
import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.exceptions.ServiceException;

public class NotificationLogger implements NotificationInterface {

	private final PrintWriter out;

	public NotificationLogger(PrintWriter out) {
		this.out = out;
	}

	@Override
	public void newProject(SNewProjectNotification newProjectNotification) throws ServiceException {
		out.println("New project " + newProjectNotification.getProjectId());
		out.flush();
	}

	@Override
	public void newRevision(SNewRevisionNotification newRevisionNotification, SToken token, String apiUrl) throws ServiceException {
		out.println("New revision " + newRevisionNotification.getRevisionId());
		out.flush();
	}

	@Override
	public void serverHasStarted() {
		out.println("BIMserver started");
		out.flush();
	}

	@Override
	public void serverWillBeShutdown() {
		out.println("BIMserver will be shut down");
		out.flush();
	}
}