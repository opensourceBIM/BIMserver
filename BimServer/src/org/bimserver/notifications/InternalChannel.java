package org.bimserver.notifications;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import org.apache.http.impl.client.CloseableHttpClient;
import org.bimserver.client.Channel;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.meta.SServicesMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InternalChannel extends Channel {

	private static final Logger LOGGER = LoggerFactory.getLogger(InternalChannel.class);
	private ServiceFactory serviceFactory;
	private SServicesMap sServicesMap;

	public InternalChannel(CloseableHttpClient httpClient, ServiceFactory serviceFactory, SServicesMap sServicesMap) {
		super(httpClient);
		this.serviceFactory = serviceFactory;
		this.sServicesMap = sServicesMap;
	}
	
	@Override
	public void disconnect() {
	}

	@Override
	public void connect(TokenHolder tokenHolder) throws ChannelConnectionException {
		for (Class<? extends PublicInterface> interface1 : sServicesMap.getInterfaceClasses()) {
			try {
				add(interface1.getName(), serviceFactory.get(AccessMethod.INTERNAL).get(interface1));
			} catch (UserException e) {
				LOGGER.error("", e);
			}
		}
	}
}