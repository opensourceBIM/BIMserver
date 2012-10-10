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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProfileDescriptor;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;

public class MultiCastNotificationImpl implements NotificationInterface {
	private final Set<NotificationInterface> notificationInterfaces = new HashSet<NotificationInterface>();

	public MultiCastNotificationImpl(NotificationInterface... notificationInterfaces) {
		for (NotificationInterface notificationInterface : notificationInterfaces) {
			this.notificationInterfaces.add(notificationInterface);
		}
	}

	public void add(NotificationInterface notificationInterface) {
		notificationInterfaces.add(notificationInterface);
	}

	public void remove(NotificationInterface notificationInterface) {
		notificationInterfaces.remove(notificationInterface);
	}

	@Override
	public void newLogAction(SLogAction logAction, String serviceIdentifier, SToken token, String apiUrl) throws UserException, ServerException {
		for (NotificationInterface notificationInterface : notificationInterfaces) {
			notificationInterface.newLogAction(logAction, serviceIdentifier, token, apiUrl);
		}
	}

	@Override
	public void progress(long topicId, SLongActionState state) throws UserException, ServerException {
		for (NotificationInterface notificationInterface : notificationInterfaces) {
			notificationInterface.progress(topicId, state);
		}
	}

	@Override
	public void setToken(SToken token) {
	}

	@Override
	public SToken getCurrentToken() throws ServerException, UserException {
		return null;
	}

	@Override
	public List<SProfileDescriptor> getPublicProfiles(String serviceIdentifier) {
		return null;
	}

	@Override
	public List<SProfileDescriptor> getPrivateProfiles(String serviceIdentifier, String token) {
		return null;
	}

	@Override
	public SServiceDescriptor getService(String serviceIdentifier) {
		return null;
	}
}