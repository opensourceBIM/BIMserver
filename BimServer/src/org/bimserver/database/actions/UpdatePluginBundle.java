package org.bimserver.database.actions;

import java.nio.file.Path;
import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SPluginInformation;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.MavenPluginLocation;
import org.bimserver.plugins.PluginDescriptor;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.aether.resolution.ArtifactResolutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdatePluginBundle extends BimDatabaseAction<Void> {

	private static final Logger LOGGER = LoggerFactory.getLogger(UpdatePluginBundle.class);
	private BimServer bimServer;
	private String groupId;
	private String artifactId;
	private String version;
	private String repository;

	public UpdatePluginBundle(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, String repository, String groupId, String artifactId, String version) {
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
			Path jarFile = mavenPluginLocation.getVersionJar(version);
			try {
				List<SPluginInformation> plugins = null;
				try {
					Path pluginXml = mavenPluginLocation.getVersionPluginXml(version);
					plugins = bimServer.getPluginManager().getPluginInformationFromPluginFile(pluginXml);
				} catch (ArtifactResolutionException e) {
					Path jar = mavenPluginLocation.getVersionJar(version);
					plugins = bimServer.getPluginManager().getPluginInformationFromJar(jar);
				}

				IfcModelInterface allOfType = getDatabaseSession().getAllOfType(StorePackage.eINSTANCE.getPluginDescriptor(), OldQuery.getDefault());
				
				for (SPluginInformation sPluginInformation : plugins) {
					// update plugin information with data from potentially existing plugins
				}
				
				bimServer.getPluginManager().update(mavenPluginLocation.getPluginVersionIdentifier(version), mavenPluginLocation.getPluginBundle(version), mavenPluginLocation.getPluginBundleVersion(version), jarFile, plugins);
			} catch (Exception e) {
				throw new UserException(e);
			}
		} catch (Exception e) {
			LOGGER.error("", e);
			throw new UserException(e);
		}

		return null;
	}
}
