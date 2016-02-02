package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.interfaces.objects.SPluginBundleVersion;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.GitHubPluginRepository;
import org.bimserver.plugins.PluginBundle;
import org.bimserver.plugins.PluginBundleIdentifier;
import org.bimserver.plugins.PluginLocation;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetInstalledPluginBundles extends BimDatabaseAction<List<SPluginBundle>> {
	private static final Logger LOGGER = LoggerFactory.getLogger(GetInstalledPluginBundles.class);
	private BimServer bimServer;
	private boolean strictVersionChecking;
	private DefaultArtifactVersion bimserverVersion;

	public GetInstalledPluginBundles(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, boolean strictVersionChecking) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.strictVersionChecking = strictVersionChecking;
	}

	@Override
	public List<SPluginBundle> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		List<SPluginBundle> result = new ArrayList<>();

		bimserverVersion = new DefaultArtifactVersion(bimServer.getVersionChecker().getLocalVersion().getFullString());

		GitHubPluginRepository repository = new GitHubPluginRepository(bimServer.getMavenPluginRepository(), bimServer.getServerSettingsCache().getServerSettings().getServiceRepositoryUrl());

		Map<PluginBundleIdentifier, PluginLocation<?>> repositoryKnownLocation = new HashMap<>();
		for (PluginLocation<?> pluginLocation : repository.listPluginLocations()) {
			repositoryKnownLocation.put(pluginLocation.getPluginIdentifier(), pluginLocation);
		}
		
		for (PluginBundle pluginBundle : bimServer.getPluginManager().getPluginBundles()) {
			SPluginBundleVersion installedVersion = pluginBundle.getPluginBundleVersion();

			PluginBundleIdentifier pluginBundleIdentifier = new PluginBundleIdentifier(installedVersion.getGroupId(), installedVersion.getArtifactId());
			if (repositoryKnownLocation.containsKey(pluginBundleIdentifier)) {
				PluginLocation<?> pluginLocation = repositoryKnownLocation.get(pluginBundleIdentifier);
				
				SPluginBundle sPluginBundle = GetAvailablePluginBundles.processPluginLocation(pluginLocation, strictVersionChecking, bimserverVersion);

				if (sPluginBundle == null) {
					// No versions found on repository
					sPluginBundle = pluginBundle.getPluginBundle();
				}
				
				if (!sPluginBundle.getAvailableVersions().contains(pluginBundle.getPluginBundleVersion())) {
					sPluginBundle.getAvailableVersions().add(pluginBundle.getPluginBundleVersion());
				}
				sPluginBundle.setInstalledVersion(installedVersion);
				
				result.add(sPluginBundle);
			}
		}

		return result;
	}
}