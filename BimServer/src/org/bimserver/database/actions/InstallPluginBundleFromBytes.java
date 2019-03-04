package org.bimserver.database.actions;

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

import java.io.ByteArrayInputStream;
import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SPluginInformation;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.LocalMavenPluginBundle;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstallPluginBundleFromBytes extends BimDatabaseAction<Void> {

	private static final Logger LOGGER = LoggerFactory.getLogger(InstallPluginBundleFromBytes.class);
	private BimServer bimServer;
	private byte[] data;
	private Boolean installAllPluginsForAllUsers;
	private Boolean installAllPluginsForNewUsers;

	public InstallPluginBundleFromBytes(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, byte[] data, Boolean installAllPluginsForAllUsers, Boolean installAllPluginsForNewUsers) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.data = data;
		this.installAllPluginsForAllUsers = installAllPluginsForAllUsers;
		this.installAllPluginsForNewUsers = installAllPluginsForNewUsers;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		LocalMavenPluginBundle mavenPluginBundle = new LocalMavenPluginBundle(data);

		try {
			List<SPluginInformation> pluginInformationFromPluginFile = bimServer.getPluginManager().getPluginInformationFromJar(new ByteArrayInputStream(data));
			for (SPluginInformation sPluginInformation : pluginInformationFromPluginFile) {
				sPluginInformation.setEnabled(true);
				if (installAllPluginsForAllUsers) {
					sPluginInformation.setInstallForAllUsers(true);
				}
				if (installAllPluginsForNewUsers) {
					sPluginInformation.setInstallForNewUsers(true);
				}
			}
			bimServer.getPluginBundleManager().install(mavenPluginBundle, pluginInformationFromPluginFile, false);
		} catch (Exception e) {
			LOGGER.error("", e);
			throw new UserException(e);
		}

		return null;
	}
}
