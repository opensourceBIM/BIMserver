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

import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.MavenPluginLocation;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetPluginBundle extends PluginBundleDatabaseAction<SPluginBundle> {
	private static final Logger LOGGER = LoggerFactory.getLogger(GetPluginBundle.class);
	private BimServer bimServer;
	private DefaultArtifactVersion bimserverVersion;
	private String repository;
	private String groupId;
	private String artifactId;
	private boolean strictChecking;

	public GetPluginBundle(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, String repository, String groupId, String artifactId, boolean strictChecking) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.repository = repository;
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.strictChecking = strictChecking;
	}

	@Override
	public SPluginBundle execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		if (bimServer.getVersionChecker() != null && bimServer.getVersionChecker().getLocalVersion() != null) {
			bimserverVersion = new DefaultArtifactVersion(bimServer.getVersionChecker().getLocalVersion().getFullString());
		} else {
			LOGGER.info("No BIMserver version");
		}
		
		MavenPluginLocation pluginLocation = bimServer.getMavenPluginRepository().getPluginLocation(repository, groupId, artifactId);
		
		SPluginBundle sPluginBundle = processPluginLocation(pluginLocation, strictChecking, bimserverVersion);
		if (sPluginBundle != null) {
			return sPluginBundle;
		} else {
			throw new UserException("No plugin bundle available for your version of BIMserver: " + groupId + "." + artifactId);
		}
	}
}