package org.bimserver;

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

import java.io.File;

import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.client.protocolbuffers.ProtocolBuffersBimServerClientFactory;
import org.bimserver.client.soap.SoapBimServerClientFactory;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.plugins.OptionsParser;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ruben de Laat
 * 
 * Convenience class for setting up clients on different protocols to locally running BIMserver
 *
 */
public class LocalDevSetup {
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalDevSetup.class);

	public static void loadPlugins(PluginManager pluginManager, File current, File[] pluginDirectories) throws PluginException {
		LOGGER.info("Loading plugins from " + current.getAbsolutePath());

		if (pluginDirectories != null) {
			for (File pluginDirectory : pluginDirectories) {
				try {
					pluginManager.loadAllPluginsFromEclipseWorkspaces(pluginDirectory, false);
				} catch (PluginException e) {
					LOGGER.error("", e);
				}
			}
		}
	}
	
	public static final PluginManager setupPluginManager(String[] args) {
		try {
			File home = new File("home");
			
			if (!home.exists()) {
				home.mkdir();
			}
			PluginManager pluginManager = new PluginManager(new File(home, "tmp"), System.getProperty("java.class.path"), null, null, null);

			MetaDataManager metaDataManager = new MetaDataManager(pluginManager);
			pluginManager.setMetaDataManager(metaDataManager);
			loadPlugins(pluginManager, new File(".."), new OptionsParser(args).getPluginDirectories());
			metaDataManager.init();

			pluginManager.initAllLoadedPlugins();
			return pluginManager;
		} catch (PluginException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param address
	 * @return
	 */
	public static final BimServerClientInterface setupJson(String address) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			MetaDataManager metaDataManager = new MetaDataManager(pluginManager);
			pluginManager.setMetaDataManager(metaDataManager);
			BimServerClientFactory factory = new JsonBimServerClientFactory(metaDataManager, address);
			return factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
		} catch (PluginException e) {
			LOGGER.error("", e);
		} catch (ServiceException e) {
			LOGGER.error("", e);
		} catch (ChannelConnectionException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	public static final BimServerClientInterface setupSoap(String address) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			MetaDataManager metaDataManager = new MetaDataManager(pluginManager);
			pluginManager.setMetaDataManager(metaDataManager);
			BimServerClientFactory factory = new SoapBimServerClientFactory(metaDataManager, address);
			return factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
		} catch (PluginException e) {
			LOGGER.error("", e);
		} catch (ServiceException e) {
			LOGGER.error("", e);
		} catch (ChannelConnectionException e) {
			LOGGER.error("", e);
		}
		return null;
	}
	
	public static final BimServerClientInterface setupProtocolBuffers(String address) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			MetaDataManager metaDataManager = new MetaDataManager(pluginManager);
			pluginManager.setMetaDataManager(metaDataManager);
			BimServerClientFactory factory = new ProtocolBuffersBimServerClientFactory(address, 8000, 8000, null, metaDataManager);
			return factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
		} catch (PluginException e) {
			LOGGER.error("", e);
		} catch (ServiceException e) {
			LOGGER.error("", e);
		} catch (ChannelConnectionException e) {
			LOGGER.error("", e);
		}
		return null;
	}
}