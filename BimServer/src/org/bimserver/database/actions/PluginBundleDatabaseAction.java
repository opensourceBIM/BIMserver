package org.bimserver.database.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.apache.maven.artifact.versioning.VersionRange;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.interfaces.objects.SPluginBundleType;
import org.bimserver.interfaces.objects.SPluginBundleVersion;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.MavenDependency;
import org.bimserver.plugins.MavenPluginLocation;
import org.bimserver.plugins.MavenPluginVersion;
import org.bimserver.plugins.PluginLocation;
import org.bimserver.plugins.PluginVersion;
import org.eclipse.aether.resolution.ArtifactResolutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PluginBundleDatabaseAction<T> extends BimDatabaseAction<T>{
	private static final Logger LOGGER = LoggerFactory.getLogger(PluginBundleDatabaseAction.class);
	
	public PluginBundleDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod) {
		super(databaseSession, accessMethod);
	}
	

	public SPluginBundle processPluginLocation(PluginLocation<?> pluginLocation, boolean strictVersionChecking, DefaultArtifactVersion bimserverVersion) {
		if (pluginLocation instanceof MavenPluginLocation) {
			return processMavenPluginLocation((MavenPluginLocation) pluginLocation, strictVersionChecking, bimserverVersion);
		}
		return null;
	}
	
	public SPluginBundle processMavenPluginLocation(MavenPluginLocation mavenPluginLocation, boolean strictVersionChecking, ArtifactVersion bimserverVersion) {
		SPluginBundle pluginBundle = new SPluginBundle();
		boolean usefulBundle = false;
		for (PluginVersion pluginVersion : mavenPluginLocation.getAllVersions()) {
			if (pluginVersion instanceof MavenPluginVersion) {
				SPluginBundleVersion sPluginBundleVersion = new SPluginBundleVersion();
				boolean useful = true;
				MavenPluginVersion mavenPluginVersion = (MavenPluginVersion) pluginVersion;
				for (MavenDependency mavenDependency : mavenPluginVersion.getDependencies()) {
					if (mavenDependency.getArtifact().getGroupId().equals("org.opensourcebim")) {
						String artifactId = mavenDependency.getArtifact().getArtifactId();
						// shared and pluginbase always have the same version
						// as this BIMserver, so if any of them is a dependency
						// for the plugin, it's version has to be ok
						if (artifactId.equals("shared") || artifactId.equals("pluginbase")) {
							VersionRange versionRange = VersionRange.createFromVersion(mavenDependency.getArtifact().getVersion());
							if (versionRange.containsVersion(bimserverVersion)) {

							} else {
								sPluginBundleVersion.setMismatch(true);
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

					sPluginBundleVersion.setName(mavenPluginVersion.getModel().getName());
					sPluginBundleVersion.setOrganization(mavenPluginVersion.getModel().getOrganization().getName());
					sPluginBundleVersion.setArtifactId(mavenPluginLocation.getArtifactId());
					sPluginBundleVersion.setGroupId(mavenPluginLocation.getGroupId());
					sPluginBundleVersion.setRepository(mavenPluginLocation.getRepository());
					sPluginBundleVersion.setType(SPluginBundleType.MAVEN);
					sPluginBundleVersion.setVersion(mavenPluginVersion.getVersion().toString());
					sPluginBundleVersion.setDescription(mavenPluginVersion.getModel().getDescription());
					
					pluginBundle.setName(mavenPluginVersion.getModel().getName());
					pluginBundle.setOrganization(mavenPluginVersion.getModel().getOrganization().getName());
					pluginBundle.setLatestVersion(sPluginBundleVersion);
					pluginBundle.getAvailableVersions().add(sPluginBundleVersion);

					try {
						Path icon = mavenPluginLocation.getVersionIcon(mavenPluginVersion.getVersion().toString());
						if (icon != null) {
							sPluginBundleVersion.setIcon(Files.readAllBytes(icon));
						}
					} catch (ArtifactResolutionException e) {
						// This is not important
					} catch (IOException e) {
						LOGGER.error("", e);
					}
				}
			}
		}
		if (usefulBundle) {
			return pluginBundle;
		}
		return null;
	}
}
