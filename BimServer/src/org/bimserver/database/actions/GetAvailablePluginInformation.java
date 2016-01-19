package org.bimserver.database.actions;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Port;

import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.apache.maven.artifact.versioning.VersionRange;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SPluginType;
import org.bimserver.interfaces.objects.SPluginUpdateInformation;
import org.bimserver.interfaces.objects.SPluginVersion;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.GitHubPluginRepository;
import org.bimserver.plugins.MavenDependency;
import org.bimserver.plugins.MavenPluginLocation;
import org.bimserver.plugins.MavenPluginVersion;
import org.bimserver.plugins.PluginLocation;
import org.bimserver.plugins.PluginVersion;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAvailablePluginInformation extends BimDatabaseAction<List<SPluginUpdateInformation>> {
	private static final Logger LOGGER = LoggerFactory.getLogger(GetPluginUpdateInformation.class);
	private BimServer bimServer;
	private boolean strictVersionChecking;
	private DefaultArtifactVersion bimserverVersion;

	public GetAvailablePluginInformation(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, boolean strictVersionChecking) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.strictVersionChecking = strictVersionChecking;
	}

	@Override
	public List<SPluginUpdateInformation> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		List<SPluginUpdateInformation> result = new ArrayList<>();

		LOGGER.info("Test");

		GitHubPluginRepository repository = new GitHubPluginRepository(bimServer.getServerSettingsCache().getServerSettings().getServiceRepositoryUrl());

		bimserverVersion = new DefaultArtifactVersion(bimServer.getVersionChecker().getLocalVersion().getFullString());

		for (PluginLocation pluginLocation : repository.listPluginLocations()) {
			if (pluginLocation instanceof MavenPluginLocation) {
				MavenPluginLocation mavenPluginLocation = (MavenPluginLocation) pluginLocation;
				SPluginUpdateInformation processMavenPluginLocation = processMavenPluginLocation(mavenPluginLocation);
				if (processMavenPluginLocation != null) {
					result.add(processMavenPluginLocation);
				}
			}

		}

		return result;
	}

	private SPluginUpdateInformation processMavenPluginLocation(MavenPluginLocation mavenPluginLocation) {
		SPluginUpdateInformation pluginUpdateInformation = new SPluginUpdateInformation();
		boolean usefulBundle = false;
		for (PluginVersion pluginVersion : mavenPluginLocation.getAllVersions()) {
			if (pluginVersion instanceof MavenPluginVersion) {
				SPluginVersion sPluginVersion = new SPluginVersion();
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
					sPluginVersion.setType(SPluginType.MAVEN);
					sPluginVersion.setVersion(mavenPluginVersion.getVersion().toString());
					sPluginVersion.setDescription(mavenPluginVersion.getModel().getDescription());
					pluginUpdateInformation.setName(mavenPluginVersion.getArtifact().getArtifactId());
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