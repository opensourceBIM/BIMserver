package org.bimserver;

import java.io.File;

import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.client.protocolbuffers.ProtocolBuffersBimServerClientFactory;
import org.bimserver.client.soap.SoapBimServerClientFactory;
import org.bimserver.emf.MetaDataManager;
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