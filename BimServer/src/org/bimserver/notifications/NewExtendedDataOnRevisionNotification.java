package org.bimserver.notifications;

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

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class NewExtendedDataOnRevisionNotification extends Notification {

	private Long roid;
	private Long edid;

	public NewExtendedDataOnRevisionNotification(BimServer bimServer, Long edid, Long roid) {
		super(bimServer);
		this.edid = edid;
		this.roid = roid;
	}

	public long getRoid() {
		return roid;
	}

	public long getEdid() {
		return edid;
	}

	@Override
	public void process() throws BimserverDatabaseException, UserException, ServerException {
		NewExtendedDataOnRevisionTopic topic = getBimServer().getNotificationsManager().getNewExtendedDataOnRevisionTopic(new NewExtendedDataOnRevisionTopicKey(roid));
		if (topic != null) {
			topic.process(this);
		}
	}
}
