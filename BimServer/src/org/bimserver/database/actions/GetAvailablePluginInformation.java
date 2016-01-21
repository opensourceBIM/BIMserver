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
import java.util.List;

import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.apache.maven.artifact.versioning.VersionRange;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SPluginBundleType;
import org.bimserver.interfaces.objects.SPluginBundleUpdateInformation;
import org.bimserver.interfaces.objects.SPluginBundleVersion;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.GitHubPluginRepository;
import org.bimserver.plugins.MavenDependency;
import org.bimserver.plugins.MavenPluginLocation;
import org.bimserver.plugins.MavenPluginVersion;
import org.bimserver.plugins.PluginBundleImpl;
import org.bimserver.plugins.PluginLocation;
import org.bimserver.plugins.PluginVersion;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAvailablePluginInformation extends BimDatabaseAction<List<SPluginBundleUpdateInformation>> {
	private static final Logger LOGGER = LoggerFactory.getLogger(GetAvailablePluginInformation.class);
	private BimServer bimServer;
	private boolean strictVersionChecking;
	private DefaultArtifactVersion bimserverVersion;

	public GetAvailablePluginInformation(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, boolean strictVersionChecking) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.strictVersionChecking = strictVersionChecking;
	}

	@Override
	public List<SPluginBundleUpdateInformation> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		List<SPluginBundleUpdateInformation> result = new ArrayList<>();

		GitHubPluginRepository repository = new GitHubPluginRepository(bimServer.getServerSettingsCache().getServerSettings().getServiceRepositoryUrl());

		bimserverVersion = new DefaultArtifactVersion(bimServer.getVersionChecker().getLocalVersion().getFullString());

		for (PluginLocation pluginLocation : repository.listPluginLocations()) {
			PluginBundleImpl pluginBundle = bimServer.getPluginManager().getPluginBundle(pluginLocation.getIdentifier());
			// Skipping all plugin bundles that already have an installed version
			if (pluginBundle == null) {
				if (pluginLocation instanceof MavenPluginLocation) {
					MavenPluginLocation mavenPluginLocation = (MavenPluginLocation) pluginLocation;
					SPluginBundleUpdateInformation processMavenPluginLocation = processMavenPluginLocation(mavenPluginLocation);
					if (processMavenPluginLocation != null) {
						result.add(processMavenPluginLocation);
					}
				}
			}
		}

		return result;
	}

	private SPluginBundleUpdateInformation processMavenPluginLocation(MavenPluginLocation mavenPluginLocation) {
		SPluginBundleUpdateInformation pluginUpdateInformation = new SPluginBundleUpdateInformation();
		boolean usefulBundle = false;
		for (PluginVersion pluginVersion : mavenPluginLocation.getAllVersions()) {
			if (pluginVersion instanceof MavenPluginVersion) {
				SPluginBundleVersion sPluginVersion = new SPluginBundleVersion();
				boolean useful = true;
				MavenPluginVersion mavenPluginVersion = (MavenPluginVersion) pluginVersion;
				for (MavenDependency mavenDependency : mavenPluginVersion.getDependencies()) {
					if (mavenDependency.getArtifact().getGroupId().equals("org.opensourcebim")) {
						String artifactId = mavenDependency.getArtifact().getArtifactId();
						// Shared and PluginBase always have the same versions
						// as this BIMserver, so if any of them is a dependency
						// for the plugin, it's version has to be ok
						if (artifactId.equals("Shared") || artifactId.equals("PluginBase")) {
							VersionRange versionRange = VersionRange.createFromVersion(mavenDependency.getArtifact().getVersion());
							if (versionRange.containsVersion(bimserverVersion)) {

							} else {
								sPluginVersion.setMismatch(true);
								if (strictVersionChecking) {
									useful = false;
									LOGGER.info("Skipping version " + mavenPluginVersion.getArtifact().getVersion() + " or artifact " + mavenPluginVersion.getArtifact().getArtifactId());
								}
							}
						}
					}
				}
				if (useful) {
					usefulBundle = true;

					sPluginVersion.setArtifactId(mavenPluginLocation.getArtifactId());
					sPluginVersion.setGroupId(mavenPluginLocation.getGroupId());
					sPluginVersion.setRepository(mavenPluginLocation.getRepository());
					sPluginVersion.setType(SPluginBundleType.MAVEN);
					sPluginVersion.setVersion(mavenPluginVersion.getVersion().toString());
					sPluginVersion.setDescription(mavenPluginVersion.getModel().getDescription());
					pluginUpdateInformation.setName(mavenPluginVersion.getModel().getName());
					pluginUpdateInformation.setOrganization(mavenPluginVersion.getModel().getOrganization().getName());
					pluginUpdateInformation.setLatestVersion(sPluginVersion);
					pluginUpdateInformation.getAvailableVersions().add(sPluginVersion);
				}
			}
		}
		if (usefulBundle) {
			return pluginUpdateInformation;
		}
		return null;
	}
}