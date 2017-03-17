package org.bimserver.database.actions;

import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SPluginInformation;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.MavenPluginBundle;
import org.bimserver.plugins.MavenPluginLocation;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstallPluginBundle extends BimDatabaseAction<Void> {

	private static final Logger LOGGER = LoggerFactory.getLogger(InstallPluginBundle.class);
	private BimServer bimServer;
	private String groupId;
	private String artifactId;
	private String version;
	private String repository;
	private List<SPluginInformation> plugins;

	public InstallPluginBundle(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, String repository, String groupId, String artifactId, String version, List<SPluginInformation> plugins) {
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
		LOGGER.info("Installing plugin " + repository + " " + groupId + "." + artifactId + "." + version);
		MavenPluginLocation mavenPluginLocation = bimServer.getMavenPluginRepository().getPluginLocation(repository, groupId, artifactId);
		if (version == null) {
			String latestVersion = mavenPluginLocation.getLatestVersionString();
			LOGGER.info("Using version " + latestVersion + " because no version given");
			version = latestVersion;
		}
		try {
			LOGGER.info(mavenPluginLocation.getRepository(version));
			LOGGER.info(mavenPluginLocation.getVersionDate(version).toString());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		MavenPluginBundle mavenPluginBundle = mavenPluginLocation.getMavenPluginBundle(version);
		LOGGER.info(mavenPluginBundle.getVersion());

		try {
			bimServer.getPluginManager().install(mavenPluginBundle, plugins, false);
		} catch (Exception e) {
			LOGGER.error("", e);
			throw new UserException(e);
		}

		return null;
	}
}
