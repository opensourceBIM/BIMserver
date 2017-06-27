package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2017  BIMserver.org
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

import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.MavenPluginLocation;
import org.bimserver.plugins.PluginBundle;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class GetPluginBundle extends PluginBundleDatabaseAction<SPluginBundle> {
	private BimServer bimServer;
	private DefaultArtifactVersion bimserverVersion;
	private String repository;
	private String groupId;
	private String artifactId;

	public GetPluginBundle(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, String repository, String groupId, String artifactId) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.repository = repository;
		this.groupId = groupId;
		this.artifactId = artifactId;
	}

	@Override
	public SPluginBundle execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		if (bimServer.getVersionChecker().getLocalVersion() != null) {
			bimserverVersion = new DefaultArtifactVersion(bimServer.getVersionChecker().getLocalVersion().getFullString());
		}

		MavenPluginLocation pluginLocation = bimServer.getMavenPluginRepository().getPluginLocation(repository, groupId, artifactId);
		
		PluginBundle pluginBundle = bimServer.getPluginManager().getPluginBundle(pluginLocation.getPluginIdentifier());
		// Skipping all plugin bundles that already have an installed version
		if (pluginBundle == null) {
			SPluginBundle sPluginBundle = processPluginLocation(pluginLocation, false, bimserverVersion);
			if (sPluginBundle != null) {
				return sPluginBundle;
			}
		}
		throw new UserException("Plugin bundle already installed " + groupId + "." + artifactId);
	}
}