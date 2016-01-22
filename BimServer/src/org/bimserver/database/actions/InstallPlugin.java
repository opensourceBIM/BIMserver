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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstallPlugin extends BimDatabaseAction<Void> {

	private static final Logger LOGGER = LoggerFactory.getLogger(InstallPlugin.class);
	private BimServer bimServer;
	private String groupId;
	private String artifactId;
	private String version;
	private String repository;
	private List<SPluginInformation> plugins;

	public InstallPlugin(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, String repository, String groupId, String artifactId, String version, List<SPluginInformation> plugins) {
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
		MavenPluginLocation mavenPluginLocation = new MavenPluginLocation(repository, groupId, artifactId);
		
		try {
			Path jarFile = mavenPluginLocation.getVersionJar(version);
			
			bimServer.getPluginManager().install(mavenPluginLocation.getPluginVersionIdentifier(version), mavenPluginLocation.getPluginBundle(version), mavenPluginLocation.getPluginBundleVersion(version), jarFile, plugins);
		} catch (Exception e) {
			LOGGER.error("", e);
			throw new UserException(e);
		}

		return null;
	}
}
