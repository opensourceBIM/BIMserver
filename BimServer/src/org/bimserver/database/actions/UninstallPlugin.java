package org.bimserver.database.actions;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.MavenPluginLocation;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UninstallPlugin extends BimDatabaseAction<Void> {

	private static final Logger LOGGER = LoggerFactory.getLogger(UninstallPlugin.class);
	private BimServer bimServer;
	private String groupId;
	private String artifactId;
	private String version;
	private String repository;

	public UninstallPlugin(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, String repository, String groupId, String artifactId, String version) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.repository = repository;
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		MavenPluginLocation mavenPluginLocation = bimServer.getMavenPluginRepository().getPluginLocation(repository, groupId, artifactId);

		try {
			bimServer.getPluginManager().uninstall(mavenPluginLocation.getPluginVersionIdentifier(version));
		} catch (Exception e) {
			throw new UserException(e);
		}

		return null;
	}
}
