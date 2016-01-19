package org.bimserver.database.actions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.apache.maven.artifact.versioning.VersionRange;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SPluginUpdateInformation;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.GitHubPluginRepository;
import org.bimserver.plugins.MavenDependency;
import org.bimserver.plugins.MavenPluginVersion;
import org.bimserver.plugins.PluginLocation;
import org.bimserver.plugins.PluginVersion;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetPluginUpdateInformation extends BimDatabaseAction<List<SPluginUpdateInformation>> {
	private static final Logger LOGGER = LoggerFactory.getLogger(GetPluginUpdateInformation.class);
	private BimServer bimServer;
	
	public GetPluginUpdateInformation(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
	}

	@Override
	public List<SPluginUpdateInformation> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		List<SPluginUpdateInformation> result = new ArrayList<>();

		GitHubPluginRepository repository = new GitHubPluginRepository(bimServer.getServerSettingsCache().getServerSettings().getServiceRepositoryUrl());
		
		DefaultArtifactVersion bimserverVersion = null;
		
		MavenXpp3Reader mavenreader = new MavenXpp3Reader();
		Path pom = Paths.get("pom.xml");
		try {
			Model model = mavenreader.read(new FileReader(pom.toFile()));
			bimserverVersion = new DefaultArtifactVersion(model.getVersion());
			LOGGER.info("BIMserver version: " + model.getVersion());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
		
		for (PluginLocation pluginLocation : repository.listPluginLocations()) {
			for (PluginVersion pluginVersion : pluginLocation.getAllVersions()) {
				if (pluginVersion instanceof MavenPluginVersion) {
					SPluginUpdateInformation pluginUpdateInformation = new SPluginUpdateInformation();
					boolean useful = true;
					MavenPluginVersion mavenPluginVersion = (MavenPluginVersion)pluginVersion;
					for (MavenDependency mavenDependency : mavenPluginVersion.getDependencies()) {
						if (mavenDependency.getArtifact().getGroupId().equals("org.opensourcebim")) {
							String artifactId = mavenDependency.getArtifact().getArtifactId();
							// Shared and PluginBase always have the same versions as this BIMserver, so if any of them is a dependency for the plugin, it's version has to be ok
							if (artifactId.equals("Shared") || artifactId.equals("PluginBase")) {
								VersionRange versionRange = VersionRange.createFromVersion(mavenDependency.getArtifact().getVersion());
								if (versionRange.containsVersion(bimserverVersion)) {
									
								} else {
									useful = false;
									LOGGER.info("Skipping version " + mavenPluginVersion.getArtifact().getVersion() + " or artifact " + mavenPluginVersion.getArtifact().getArtifactId());
								}
							}
						}
					}
					if (useful) {
						result.add(pluginUpdateInformation);
					}
				}
			}
		}
		
		return result;
	}
}