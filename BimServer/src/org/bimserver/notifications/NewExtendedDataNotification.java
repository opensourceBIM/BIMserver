package org.bimserver.notifications;

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

import org.bimserver.BimServer;

public class NewExtendedDataNotification extends Notification {

	public NewExtendedDataNotification(BimServer bimServer, Long edid, Long soid) {
		super(bimServer);
	}

	@Override
	public void process() {
//		NewExtendedDataTopic newRevisionTopic = notificationsManager.getNewRevisionTopic();
//		Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, Query.getDefault());
//		for (Service service : project.getServices()) {
//			triggerNewRevision(notificationsManager, bimServer, notificationsManager.getSiteAddress(), project, roid, Trigger.NEW_REVISION, service);
//		}
//		if (newRevisionTopic != null) {
//			newRevisionTopic.process(session, poid, roid, this);
//		}
//		NewRevisionOnSpecificProjectTopic newRevisionOnSpecificProjectTopic = notificationsManager.getNewRevisionOnSpecificProjectTopic(new NewRevisionOnSpecificProjectTopicKey(poid));
//		if (newRevisionOnSpecificProjectTopic != null) {
//			newRevisionOnSpecificProjectTopic.process(session, poid, roid, this);
//		}
	}
}
