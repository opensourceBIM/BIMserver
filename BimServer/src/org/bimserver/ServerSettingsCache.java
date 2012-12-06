package org.bimserver;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.StorePackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerSettingsCache {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerSettingsCache.class);
	private BimDatabase database;
	private final Set<String> allowedHosts = new HashSet<String>();
	private boolean onlyWhitelistedDomains = false;
	private ServerSettings serverSettings;

	public ServerSettingsCache(BimDatabase database) {
		this.database = database;
		updateCache();
	}

	public synchronized void updateCache() {
		DatabaseSession session = database.createSession();
		try {
			serverSettings = session.getSingle(StorePackage.eINSTANCE.getServerSettings(), ServerSettings.class);
			allowedHosts.clear();
			for (String domain : serverSettings.getWhitelistedDomains()) {
				allowedHosts.add(domain);
			}
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
	}

	public boolean isHostAllowed(String address) {
		if (!onlyWhitelistedDomains) {
			return true;
		}
		if (address.startsWith("http://")) {
			address = address.substring(7);
		}
		return allowedHosts.contains(address);
	}

	public ServerSettings getServerSettings() {
		return serverSettings;
	}
}