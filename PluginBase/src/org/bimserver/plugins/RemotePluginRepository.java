package org.bimserver.plugins;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.eclipse.aether.DefaultRepositorySystemSession;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.connector.basic.BasicRepositoryConnectorFactory;
import org.eclipse.aether.impl.DefaultServiceLocator;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.resolution.ArtifactRequest;
import org.eclipse.aether.resolution.ArtifactResolutionException;
import org.eclipse.aether.resolution.ArtifactResult;
import org.eclipse.aether.spi.connector.RepositoryConnectorFactory;
import org.eclipse.aether.spi.connector.transport.TransporterFactory;
import org.eclipse.aether.transport.file.FileTransporterFactory;
import org.eclipse.aether.transport.http.HttpTransporterFactory;

public class RemotePluginRepository {
	public static void main(String[] args) throws ArtifactResolutionException {
		System.out.println("------------------------------------------------------------");
		System.out.println(RemotePluginRepository.class.getSimpleName());

		RepositorySystem system = newRepositorySystem();

		RepositorySystemSession session = newRepositorySystemSession(system);

		Artifact artifact = new DefaultArtifact("org.eclipse.aether:aether-util:1.0.0.v20140518");

		ArtifactRequest artifactRequest = new ArtifactRequest();
		artifactRequest.setArtifact(artifact);
		artifactRequest.setRepositories(newRepositories(system, session));

		ArtifactResult artifactResult = system.resolveArtifact(session, artifactRequest);

		artifact = artifactResult.getArtifact();

		System.out.println(artifact + " resolved to  " + artifact.getFile());
	}

	public static RepositorySystem newRepositorySystem() {
		/*
		 * Aether's components implement org.eclipse.aether.spi.locator.Service
		 * to ease manual wiring and using the prepopulated
		 * DefaultServiceLocator, we only need to register the repository
		 * connector and transporter factories.
		 */
		DefaultServiceLocator locator = MavenRepositorySystemUtils.newServiceLocator();
		locator.addService(RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class);
		locator.addService(TransporterFactory.class, FileTransporterFactory.class);
		locator.addService(TransporterFactory.class, HttpTransporterFactory.class);

		locator.setErrorHandler(new DefaultServiceLocator.ErrorHandler() {
			@Override
			public void serviceCreationFailed(Class<?> type, Class<?> impl, Throwable exception) {
				exception.printStackTrace();
			}
		});

		return locator.getService(RepositorySystem.class);
	}

	public static DefaultRepositorySystemSession newRepositorySystemSession(RepositorySystem system) {
		DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();

		LocalRepository localRepo = new LocalRepository("target/local-repo");
		session.setLocalRepositoryManager(system.newLocalRepositoryManager(session, localRepo));

		session.setTransferListener(new ConsoleTransferListener());
		session.setRepositoryListener(new ConsoleRepositoryListener());

		// uncomment to generate dirty trees
		// session.setDependencyGraphTransformer( null );

		return session;
	}

	public static List<RemoteRepository> newRepositories(RepositorySystem system, RepositorySystemSession session) {
		return new ArrayList<RemoteRepository>(Arrays.asList(newCentralRepository()));
	}

	private static RemoteRepository newCentralRepository() {
		return new RemoteRepository.Builder("central", "default", "https://repo1.maven.org/maven2/").build();
	}

}
