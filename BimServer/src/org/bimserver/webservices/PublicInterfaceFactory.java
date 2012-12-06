package org.bimserver.webservices;

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

import java.util.concurrent.TimeUnit;

import org.bimserver.BimServer;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.webservices.authorization.AnonymousAuthorization;
import org.bimserver.webservices.authorization.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublicInterfaceFactory implements ServiceFactory {
	private final BimServer bimServer;
	private static final Logger LOGGER = LoggerFactory.getLogger(PublicInterfaceFactory.class);

	public PublicInterfaceFactory(BimServer bimServer) {
		this.bimServer = bimServer;
	}

	@SuppressWarnings("unchecked")
	public <T extends PublicInterface> T getService(Class<T> publicInterface, Authorization authorization) {
		if (publicInterface == ServiceInterface.class) {
			return (T) new Service(bimServer, null, "", authorization);
		} else {
			return (T) new NotificationImpl(bimServer, authorization);
		}
	}
	
	public synchronized <T extends PublicInterface> T getService(Class<T> publicInterface) throws UserException {
		Authorization authorization = new AnonymousAuthorization(1, TimeUnit.HOURS);
		return getService(publicInterface, authorization);
	}
	
	public synchronized <T extends PublicInterface> T getService(Class<T> publicInterface, String token) throws UserException {
		try {
			Authorization authorization = Authorization.fromToken(bimServer.getEncryptionKey(), token);
			return getService(publicInterface, authorization);
		} catch (Exception e) {
			LOGGER.error("", e);
			throw new UserException(e);
		}
	}

	@Override
	public String getName() {
		return "ServiceInterface";
	}
}