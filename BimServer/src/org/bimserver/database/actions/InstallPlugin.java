package org.bimserver.database.actions;

import java.io.File;
import java.nio.file.Paths;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.MavenPluginLocation;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.aether.resolution.ArtifactResolutionException;

public class InstallPlugin extends BimDatabaseAction<Void> {

	private BimServer bimServer;
	private String groupId;
	private String artifactId;
	private String version;
	private String repository;

	public InstallPlugin(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, String repository, String groupId, String artifactId, String version) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.repository = repository;
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		MavenPluginLocation mavenPluginLocation = new MavenPluginLocation(repository, groupId, artifactId);
		
		try {
			File jarFile = mavenPluginLocation.getVersionJar(version);
			bimServer.getPluginManager().loadPluginsFromJar(Paths.get(jarFile.getAbsolutePath()));
		} catch (ArtifactResolutionException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		}

		return null;
	}
}
