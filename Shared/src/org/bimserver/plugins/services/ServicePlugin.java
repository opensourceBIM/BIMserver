package org.bimserver.plugins.services;

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

import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;

public abstract class ServicePlugin implements Plugin {

	public abstract String getTitle();
	private PluginManager pluginManager;
	
	public ServiceInterface getServiceInterface(String token) throws UserException {
		return pluginManager.getServiceFactory().get(token, AccessMethod.INTERNAL).get(ServiceInterface.class);
	}

	protected void registerNewRevisionHandler(ServiceDescriptor serviceDescriptor, final NewRevisionHandler newRevisionHandler) {
		pluginManager.registerNewRevisionHandler(serviceDescriptor, newRevisionHandler);
	}
	
	protected BimServerClientInterface getLocalBimServerClientInterface(AuthenticationInfo tokenAuthentication) throws ServiceException, ChannelConnectionException {
		return pluginManager.getLocalBimServerClientInterface(tokenAuthentication);
	}
	
	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		this.pluginManager = pluginManager;
	}
	
	public PluginManager getPluginManager() {
		return pluginManager;
	}

	public void registerNewExtendedDataOnProjectHandler(ServiceDescriptor serviceDescriptor, NewExtendedDataOnProjectHandler newExtendedDataHandler) {
		pluginManager.registerNewExtendedDataOnProjectHandler(serviceDescriptor, newExtendedDataHandler);
	}

	public void registerNewExtendedDataOnRevisionHandler(ServiceDescriptor serviceDescriptor, NewExtendedDataOnRevisionHandler newExtendedDataHandler) {
		pluginManager.registerNewExtendedDataOnRevisionHandler(serviceDescriptor, newExtendedDataHandler);
	}
	
	/**
	 * This will start an instance of the ServicePlugin with the settings for a specific user
	 * 
	 * @param pluginConfiguration
	 */
	public abstract void register(PluginConfiguration pluginConfiguration);
}