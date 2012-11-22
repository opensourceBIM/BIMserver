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

public class AccessRightsCache {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccessRightsCache.class);
	private BimDatabase database;
	private final Set<String> allowedHosts = new HashSet<String>();
	private boolean onlyWhitelistedDomains = false;

	public AccessRightsCache(BimDatabase database) {
		this.database = database;
		updateCache();
	}

	public void updateCache() {
		DatabaseSession session = database.createSession();
		try {
			ServerSettings serverSettings = session.getSingle(StorePackage.eINSTANCE.getServerSettings(), ServerSettings.class);
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
}