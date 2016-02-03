package org.bimserver.database.actions;

import java.nio.file.Path;
import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SPluginInformation;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.MavenPluginLocation;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.aether.resolution.ArtifactResolutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetPluginInformation extends BimDatabaseAction<List<SPluginInformation>> {

	private static final Logger LOGGER = LoggerFactory.getLogger(GetPluginInformation.class);
	private BimServer bimServer;
	private String groupId;
	private String artifactId;
	private String version;
	private String repository;

	public GetPluginInformation(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, String repository, String groupId, String artifactId, String version) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.repository = repository;
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
	}

	@Override
	public List<SPluginInformation> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		MavenPluginLocation mavenPluginLocation = bimServer.getMavenPluginRepository().getPluginLocation(repository, groupId, artifactId);
		
		try {
			try {
				Path pluginXml = mavenPluginLocation.getVersionPluginXml(version);
				return bimServer.getPluginManager().getPluginInformationFromPluginFile(pluginXml);
			} catch (ArtifactResolutionException e) {
				Path jar = mavenPluginLocation.getVersionJar(version);
				return bimServer.getPluginManager().getPluginInformationFromJar(jar);
			}
		} catch (Exception e) {
			throw new UserException(e);
		}
	}
}
