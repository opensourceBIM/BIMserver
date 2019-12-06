package org.bimserver.notifications;

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

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OperationType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class NewProjectNotification extends Notification {

	private long poid;

	public NewProjectNotification(BimServer bimServer, long poid) {
		super(bimServer);
		this.poid = poid;
	}
	
	@Override
	public void process() throws UserException, ServerException, BimserverDatabaseException {
		NewProjectTopic newProjectTopic = getBimServer().getNotificationsManager().getNewProjectTopic();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			if (newProjectTopic != null) {
				newProjectTopic.process(session, poid, this);
			}
		} finally {
			session.close();
		}
	}
}
