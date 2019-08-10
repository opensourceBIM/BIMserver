package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.client.protocolbuffers.ProtocolBuffersBimServerClientFactory;
import org.bimserver.client.soap.SoapBimServerClientFactory;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.plugins.MavenPluginRepository;
import org.bimserver.plugins.OptionsParser;
import org.bimserver.plugins.PluginBundleManager;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.meta.SServicesMap;
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

	public static void loadPlugins(PluginBundleManager pluginBundleManager, Path current, Path[] pluginDirectories) throws PluginException {
		LOGGER.info("Loading plugins from " + current.toString());

		if (pluginDirectories != null) {
			for (Path pluginDirectory : pluginDirectories) {
				try {
					pluginBundleManager.loadAllPluginsFromEclipseWorkspaces(pluginDirectory, false);
				} catch (PluginException e) {
					LOGGER.error("", e);
				} catch (IOException e) {
					LOGGER.error("", e);
				}
			}
		}
	}
	
	public static final PluginManagerInterface setupPluginManager(String[] args) {
		try {
			Path home = Paths.get("home");
			
			if (!Files.exists(home)) {
				Files.createDirectory(home);
			}
			Path tmp = home.resolve("tmp");
			if (!Files.exists(tmp)) {
				Files.createDirectories(tmp);
			}
			MavenPluginRepository mavenPluginRepository = new MavenPluginRepository();
			PluginManager pluginManager = new PluginManager(tmp, System.getProperty("java.class.path"), null, null, null, null);

			MetaDataManager metaDataManager = new MetaDataManager(tmp);
			pluginManager.setMetaDataManager(metaDataManager);
			PluginBundleManager pluginBundleManager = new PluginBundleManager(pluginManager, mavenPluginRepository, home.resolve("plugins"));
			loadPlugins(pluginBundleManager, Paths.get(".."), new OptionsParser(args).getPluginDirectories());
			metaDataManager.init(false);

			pluginManager.initAllLoadedPlugins();
			return pluginManager;
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param address
	 * @return
	 */
	@SuppressWarnings("resource")
	public static final BimServerClientInterface setupJson(String address) {
		try {
			Path home = Paths.get("home");
			if (!Files.isDirectory(home)) {
				Files.createDirectory(home);
			}
			Path tmp = home.resolve("tmp");
			if (!Files.isDirectory(tmp)) {
				Files.createDirectory(tmp);
			}
			MavenPluginRepository mavenPluginRepository = new MavenPluginRepository();
			PluginManager pluginManager = new PluginManager(tmp, System.getProperty("java.class.path"), null, null, null, null);
			PluginBundleManager pluginBundleManager = new PluginBundleManager(pluginManager, mavenPluginRepository, home.resolve("plugins"));
			pluginBundleManager.loadAllPluginsFromEclipseWorkspace(Paths.get("../"), true);
			
			MetaDataManager metaDataManager = new MetaDataManager(tmp);
			pluginManager.setMetaDataManager(metaDataManager);
			metaDataManager.init(false);

			pluginManager.initAllLoadedPlugins();
			
			BimServerClientFactory factory = new JsonBimServerClientFactory(metaDataManager, address);
			return factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
		} catch (PluginException e) {
			LOGGER.error("", e);
		} catch (ServiceException e) {
			LOGGER.error("", e);
		} catch (ChannelConnectionException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (BimServerClientException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	public static final BimServerClientInterface setupSoap(String address) {
		try {
			Path home = Paths.get("home");
			Path tmp = home.resolve("tmp");
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(home);
			MetaDataManager metaDataManager = new MetaDataManager(tmp);
			pluginManager.setMetaDataManager(metaDataManager);
			try (BimServerClientFactory factory = new SoapBimServerClientFactory(metaDataManager, address)) {
				return factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		} catch (PluginException e) {
			LOGGER.error("", e);
		}
		return null;
	}
	
	public static final BimServerClientInterface setupProtocolBuffers(String address) {
		Path home = Paths.get("home");
		Path tmp = home.resolve("tmp");
		MetaDataManager metaDataManager = new MetaDataManager(tmp);
		try (BimServerClientFactory factory = new ProtocolBuffersBimServerClientFactory(address, 8000, 8000, null, metaDataManager, new SServicesMap())) {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(home);
			pluginManager.setMetaDataManager(metaDataManager);
			return factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
		} catch (PluginException e) {
			LOGGER.error("", e);
		} catch (ServiceException e) {
			LOGGER.error("", e);
		} catch (ChannelConnectionException e) {
			LOGGER.error("", e);
		} catch (BimServerClientException e) {
			LOGGER.error("", e);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return null;
	}
}