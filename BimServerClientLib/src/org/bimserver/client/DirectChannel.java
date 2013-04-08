package org.bimserver.client;

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

import java.io.IOException;
import java.io.InputStream;

import javax.activation.DataHandler;

import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.TokenChangeListener;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.utils.InputStreamDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DirectChannel extends Channel implements TokenChangeListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(DirectChannel.class);
	private ServiceFactory serviceFactory;
	private SServicesMap sServicesMap;

	public DirectChannel(ServiceFactory serviceFactory, SServicesMap sServicesMap) {
		this.serviceFactory = serviceFactory;
		this.sServicesMap = sServicesMap;
	}

	public void connect() throws UserException {
		for (Class<? extends PublicInterface> interface1 : sServicesMap.getInterfaceClasses()) {
			if (!has(interface1)) {
				add(interface1.getName(), serviceFactory.get(AccessMethod.INTERNAL).get(interface1));
			}
		}
		notifyOfConnect();
	}

	@Override
	public void disconnect() {
		notifyOfDisconnect();
	}
	
	@Override
	public long checkin(String baseAddress, String token, long poid, String comment, long deserializerOid, boolean merge, boolean sync, long fileSize, String filename, InputStream inputStream) throws ServerException, UserException {
		try {
			return get(ServiceInterface.class).checkin(poid, comment, deserializerOid, fileSize, filename, new DataHandler(new InputStreamDataSource(inputStream)), merge, sync);
		} catch (PublicInterfaceNotFoundException e) {
			LOGGER.error("", e);
			return -1;
		}
	}
	
	@Override
	public InputStream getDownloadData(String baseAddress, String token, long download, long serializerOid) throws IOException {
		try {
			SDownloadResult downloadData = get(ServiceInterface.class).getDownloadData(download);
			return downloadData.getFile().getInputStream();
		} catch (ServerException e) {
			LOGGER.error("", e);
		} catch (UserException e) {
			LOGGER.error("", e);
		} catch (PublicInterfaceNotFoundException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public void connect(TokenHolder tokenHolder) throws ChannelConnectionException {
		tokenHolder.registerTokenChangeListener(this);
	}

	@Override
	public void newToken(String token) {
		try {
			get(AuthInterface.class).tokenlogin(token);
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		}
	}
}