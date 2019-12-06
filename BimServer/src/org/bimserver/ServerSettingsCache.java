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

import java.util.HashSet;
import java.util.Set;

import org.bimserver.database.BimDatabase;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
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
	}

	public synchronized void updateCache() {
		DatabaseSession session = database.createSession(OperationType.READ_ONLY);
		try {
			serverSettings = session.getSingle(StorePackage.eINSTANCE.getServerSettings(), new OldQuery(session.getMetaDataManager().getPackageMetaData("store"), true));
			if (serverSettings.getSessionTimeOutSeconds() == 0) {
				serverSettings.setSessionTimeOutSeconds(60 * 60 * 24 * 30);
			}
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
		if (database.getMigrator().migrationRequired()) {
			throw new RuntimeException("Trying to accesss ServerSettings while database needs to be migrated");
		}
		if (serverSettings == null) {
			updateCache();
		}
		return serverSettings;
	}

	public void init() {
		updateCache();
	}
}