package org.bimserver.test.framework;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.client.factories.UsernamePasswordAuthenticationInfo;
import org.bimserver.plugins.PluginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Creates a randomly initialized connection to a local bimserver
 */
public class RandomBimServerClientFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(RandomBimServerClientFactory.class);
	private int current = 0;
	
	public synchronized BimServerClient create() {
		try {
			BimServerClient bimServerClient = new BimServerClient(LocalDevPluginLoader.createPluginManager());
			bimServerClient.setAuthentication(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			if (current == 0) {
				LOGGER.info("New BimServerClient: Protocol Buffers");
				bimServerClient.connectProtocolBuffers("localhost", 8020);
			} else if (current == 1) {
				LOGGER.info("New BimServerClient: SOAP/useSoapHeaderSessions");
				bimServerClient.connectSoap("http://localhost/soap", true);
			} else if (current == 2){
				LOGGER.info("New BimServerClient: SOAP");
				bimServerClient.connectSoap("http://localhost/soap", false);
			}
			current = (current + 1) % 3;
			return bimServerClient;
		} catch (PluginException e) {
			LOGGER.error("", e);
		} catch (ConnectionException e) {
			LOGGER.error("", e);
		};
		return null;
	}
}
