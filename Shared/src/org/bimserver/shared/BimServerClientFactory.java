package org.bimserver.shared;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import org.bimserver.emf.MetaDataManager;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.ServiceException;

public interface BimServerClientFactory {
	BimServerClientInterface create(AuthenticationInfo authenticationInfo) throws ServiceException, ChannelConnectionException;
	BimServerClientInterface create() throws ServiceException, ChannelConnectionException;
	MetaDataManager getMetaDataManager();
}