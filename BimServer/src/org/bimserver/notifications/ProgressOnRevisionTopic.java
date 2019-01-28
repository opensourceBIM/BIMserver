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

import org.bimserver.interfaces.objects.SProgressTopicType;

public class ProgressOnRevisionTopic extends ProgressTopic {
	private long poid;
	private long roid;

	public ProgressOnRevisionTopic(NotificationsManager notificationsManager, ProgressOnRevisionTopicKey key, long poid, long roid, SProgressTopicType type, String description) {
		super(notificationsManager, key, type, description);
		this.poid = poid;
		this.roid = roid;
	}
	
	public long getPoid() {
		return poid;
	}
	
	public long getRoid() {
		return roid;
	}
}
