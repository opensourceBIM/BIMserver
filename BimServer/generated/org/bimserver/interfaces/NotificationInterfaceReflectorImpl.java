package org.bimserver.interfaces;

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
import org.bimserver.shared.Reflector;

import org.bimserver.shared.KeyValuePair;

@SuppressWarnings("unchecked")
public class NotificationInterfaceReflectorImpl implements org.bimserver.shared.NotificationInterface {

private Reflector reflector;

	public NotificationInterfaceReflectorImpl (Reflector reflector) {this.reflector = reflector;}
	public void newProject(org.bimserver.interfaces.objects.SNewProjectNotification arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("NotificationInterface", "newProject", void.class, new KeyValuePair("arg0", arg0));
	}
	public void newRevision(org.bimserver.interfaces.objects.SNewRevisionNotification arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("NotificationInterface", "newRevision", void.class, new KeyValuePair("arg0", arg0));
	}
	public void serverHasStarted() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("NotificationInterface", "serverHasStarted", void.class);
	}
	public void serverWillBeShutdown() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("NotificationInterface", "serverWillBeShutdown", void.class);
	}
}
