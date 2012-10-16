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

@SuppressWarnings("unchecked")
public class NotificationInterfaceReflectorImpl implements org.bimserver.shared.interfaces.NotificationInterface {

private Reflector reflector;

	public NotificationInterfaceReflectorImpl (Reflector reflector) {this.reflector = reflector;}
	public org.bimserver.interfaces.objects.SToken getCurrentToken() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SToken) reflector.callMethod("NotificationInterface", "getCurrentToken", org.bimserver.interfaces.objects.SToken.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor> getPrivateProfiles(java.lang.String serviceIdentifier, java.lang.String token) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor>) reflector.callMethod("NotificationInterface", "getPrivateProfiles", java.util.List.class, new KeyValuePair("serviceIdentifier", serviceIdentifier), new KeyValuePair("token", token));
	}
	public java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor> getPublicProfiles(java.lang.String serviceIdentifier) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor>) reflector.callMethod("NotificationInterface", "getPublicProfiles", java.util.List.class, new KeyValuePair("serviceIdentifier", serviceIdentifier));
	}
	public org.bimserver.interfaces.objects.SServiceDescriptor getService(java.lang.String serviceIdentifier) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SServiceDescriptor) reflector.callMethod("NotificationInterface", "getService", org.bimserver.interfaces.objects.SServiceDescriptor.class, new KeyValuePair("serviceIdentifier", serviceIdentifier));
	}
	public org.bimserver.interfaces.objects.SImmediateNotificationResult newLogAction(java.lang.String uuid, org.bimserver.interfaces.objects.SLogAction logAction, java.lang.String serviceIdentifier, java.lang.String profileIdentifer, org.bimserver.interfaces.objects.SToken token, java.lang.String apiUrl) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SImmediateNotificationResult) reflector.callMethod("NotificationInterface", "newLogAction", org.bimserver.interfaces.objects.SImmediateNotificationResult.class, new KeyValuePair("uuid", uuid), new KeyValuePair("logAction", logAction), new KeyValuePair("serviceIdentifier", serviceIdentifier), new KeyValuePair("profileIdentifer", profileIdentifer), new KeyValuePair("token", token), new KeyValuePair("apiUrl", apiUrl));
	}
	public void progress(long topicId, org.bimserver.interfaces.objects.SLongActionState state) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("NotificationInterface", "progress", void.class, new KeyValuePair("topicId", topicId), new KeyValuePair("state", state));
	}
	public void setToken(org.bimserver.interfaces.objects.SToken arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("NotificationInterface", "setToken", void.class, new KeyValuePair("arg0", arg0));
	}
}
