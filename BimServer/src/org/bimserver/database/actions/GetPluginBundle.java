package org.bimserver.database.actions;

import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.MavenPluginLocation;
import org.bimserver.plugins.PluginBundle;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class GetPluginBundle extends PluginBundleDatabaseAction<SPluginBundle> {
	private BimServer bimServer;
	private DefaultArtifactVersion bimserverVersion;
	private String repository;
	private String groupId;
	private String artifactId;

	public GetPluginBundle(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, String repository, String groupId, String artifactId) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.repository = repository;
		this.groupId = groupId;
		this.artifactId = artifactId;
	}

	@Override
	public SPluginBundle execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		bimserverVersion = new DefaultArtifactVersion(bimServer.getVersionChecker().getLocalVersion().getFullString());

		MavenPluginLocation pluginLocation = bimServer.getMavenPluginRepository().getPluginLocation(repository, groupId, artifactId);
		
		PluginBundle pluginBundle = bimServer.getPluginManager().getPluginBundle(pluginLocation.getPluginIdentifier());
		// Skipping all plugin bundles that already have an installed version
		if (pluginBundle == null) {
			SPluginBundle sPluginBundle = processPluginLocation(pluginLocation, false, bimserverVersion);
			if (sPluginBundle != null) {
				return sPluginBundle;
			}
		}
		throw new UserException("Plugin bundle not found");
	}
}