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
import org.bimserver.shared.reflector.Reflector;

import org.bimserver.shared.reflector.KeyValuePair;

public class NotificationInterfaceReflectorImpl implements org.bimserver.shared.interfaces.NotificationInterface {

private Reflector reflector;

	public NotificationInterfaceReflectorImpl (Reflector reflector) {this.reflector = reflector;}
	public void newLogAction(org.bimserver.interfaces.objects.SLogAction logAction, org.bimserver.interfaces.objects.SToken token, java.lang.String apiUrl) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("NotificationInterface", "newLogAction", void.class, new KeyValuePair("logAction", logAction), new KeyValuePair("token", token), new KeyValuePair("apiUrl", apiUrl));
	}
	public void progress(long topicId, org.bimserver.interfaces.objects.SLongActionState state) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("NotificationInterface", "progress", void.class, new KeyValuePair("topicId", topicId), new KeyValuePair("state", state));
	}
}
