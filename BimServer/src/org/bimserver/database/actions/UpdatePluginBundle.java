package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.ByteArrayInputStream;
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
			Path pomFile = mavenPluginLocation.getVersionPom(version);
			try {
				List<SPluginInformation> plugins = null;
				try {
					plugins = bimServer.getPluginManager().getPluginInformationFromPluginFile(new ByteArrayInputStream(mavenPluginLocation.getVersionPluginXml(version)));
				} catch (ArtifactResolutionException e) {
					plugins = bimServer.getPluginManager().getPluginInformationFromJar(jarFile);
				}

//				IfcModelInterface allOfType = getDatabaseSession().getAllOfType(StorePackage.eINSTANCE.getPluginDescriptor(), OldQuery.getDefault());
				
//				for (SPluginInformation sPluginInformation : plugins) {
					// update plugin information with data from potentially existing plugins
//				}
				
				bimServer.getPluginBundleManager().update(mavenPluginLocation.getPluginVersionIdentifier(version), mavenPluginLocation.getPluginBundle(version), mavenPluginLocation.getPluginBundleVersion(version), jarFile, pomFile, plugins);
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
