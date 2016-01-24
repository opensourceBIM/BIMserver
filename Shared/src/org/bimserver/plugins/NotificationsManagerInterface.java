package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.plugins.services.NewExtendedDataOnProjectHandler;
import org.bimserver.plugins.services.NewExtendedDataOnRevisionHandler;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1RemoteServiceInterface;

public interface NotificationsManagerInterface {

	void unregisterInternalNewRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor);
	void registerInternalNewRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor, NewRevisionHandler newRevisionHandler);
	void registerInternalNewExtendedDataOnProjectHandler(long uoid, ServiceDescriptor serviceDescriptor, NewExtendedDataOnProjectHandler newExtendedDataHandler);
	void registerInternalNewExtendedDataOnRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor, NewExtendedDataOnRevisionHandler newExtendedDataHandler);
	void register(long uoid, ServiceDescriptor serviceDescriptor, Bimsie1RemoteServiceInterface remoteServiceInterface);
}