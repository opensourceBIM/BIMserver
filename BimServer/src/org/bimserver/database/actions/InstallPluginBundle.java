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

import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SPluginInformation;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.MavenPluginBundle;
import org.bimserver.plugins.MavenPluginLocation;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstallPluginBundle extends BimDatabaseAction<Void> {

	private static final Logger LOGGER = LoggerFactory.getLogger(InstallPluginBundle.class);
	private BimServer bimServer;
	private String groupId;
	private String artifactId;
	private String version;
	private String repository;
	private List<SPluginInformation> plugins;

	public InstallPluginBundle(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, String repository, String groupId, String artifactId, String version, List<SPluginInformation> plugins) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.repository = repository;
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
		this.plugins = plugins;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		LOGGER.info("Installing plugin " + repository + " " + groupId + "." + artifactId + "." + version);
		MavenPluginLocation mavenPluginLocation = bimServer.getMavenPluginRepository().getPluginLocation(repository, groupId, artifactId);
		if (version == null) {
			String latestVersion = mavenPluginLocation.getLatestVersionString();
			LOGGER.info("Using version " + latestVersion + " because no version given");
			version = latestVersion;
		}
		try {
			LOGGER.info(mavenPluginLocation.getRepository(version));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		MavenPluginBundle mavenPluginBundle = mavenPluginLocation.getMavenPluginBundle(version);
		LOGGER.info(mavenPluginBundle.getVersion());

		try {
			bimServer.getPluginBundleManager().install(mavenPluginBundle, plugins, false);
		} catch (Exception e) {
			LOGGER.error("", e);
			throw new UserException(e);
		}

		return null;
	}
}
