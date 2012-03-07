package org.bimserver.database.actions;

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

import java.io.IOException;
import java.net.InetSocketAddress;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.PostCommitAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.pb.NotificationInterfaceReflectorImpl;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.pb.Reflector;
import org.bimserver.shared.pb.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SetHttpCallbackUrlDatabaseAction extends BimDatabaseAction<Void> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SetHttpCallbackUrlDatabaseAction.class);
	private final long uoid;
	private final String url;
	private final long actingUoid;
	private final BimServer bimServer;

	public SetHttpCallbackUrlDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, BimServer bimServer, long actingUoid, long uoid, String url) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.actingUoid = actingUoid;
		this.uoid = uoid;
		this.url = url;
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = getUserByUoid(actingUoid);
		if (actingUoid != uoid) {
			if (actingUser.getUserType() != UserType.ADMIN && actingUser.getUserType() != UserType.SYSTEM) {
				throw new UserException("Only admin users can change other user's callback url");
			}
		}
		final User user = getUserByUoid(uoid);
		user.setNotificationUrl(url);
		getDatabaseSession().store(user);
		getDatabaseSession().addPostCommitAction(new PostCommitAction() {
			@Override
			public void execute() throws UserException {
				InetSocketAddress address = new InetSocketAddress(url.substring(0, url.indexOf(":")), Integer.parseInt(url.substring(url.indexOf(":") + 1)));
				try {
					SocketChannel channel = new SocketChannel();
					channel.connect(address);
					bimServer.getNotificationsManager().register(user, new NotificationInterfaceReflectorImpl(new Reflector(bimServer.getProtocolBuffersMetaData(), bimServer.getNotificationInterfaceService(), channel)));
				} catch (IOException e) {
					LOGGER.error("", e);
				}
			}
		});
		return null;
	}
}