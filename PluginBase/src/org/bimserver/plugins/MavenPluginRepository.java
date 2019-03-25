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

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.eclipse.aether.DefaultRepositorySystemSession;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.connector.basic.BasicRepositoryConnectorFactory;
import org.eclipse.aether.impl.DefaultServiceLocator;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.LocalRepositoryManager;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.repository.RepositoryPolicy;
import org.eclipse.aether.spi.connector.RepositoryConnectorFactory;
import org.eclipse.aether.spi.connector.transport.TransporterFactory;
import org.eclipse.aether.transport.file.FileTransporterFactory;
import org.eclipse.aether.transport.http.HttpTransporterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MavenPluginRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(MavenPluginRepository.class);
	private final RepositorySystem system;
	private final RepositorySystemSession session;
	private final Set<RemoteRepository> repositories = new LinkedHashSet<>();
	private List<RemoteRepository> localRepositories;
	private final RemoteRepository remoteRepository;
	private String defaultRemoteRepositoryLocation;
	private Path localRepoFile;
	private RemoteRepository local;
	
	public MavenPluginRepository(Path localRepoFile) {
		this(localRepoFile, "http://central.maven.org/maven2", "~/.m2");
	}
	
	public MavenPluginRepository(Path localRepoFile, String defaultRemoteRepositoryLocation, String defaultLocalRepositoryLocation) {
		this.localRepoFile = localRepoFile;
		this.defaultRemoteRepositoryLocation = defaultRemoteRepositoryLocation;

		system = newRepositorySystem();
		session = newRepositorySystemSession(system, localRepoFile);

		RemoteRepository.Builder builder = new RemoteRepository.Builder("central", "default", defaultRemoteRepositoryLocation);
		builder.setPolicy(new RepositoryPolicy(true, RepositoryPolicy.UPDATE_POLICY_INTERVAL + ":60", RepositoryPolicy.CHECKSUM_POLICY_FAIL));
		remoteRepository = builder.build();

		repositories.add(remoteRepository);

		builder = new RemoteRepository.Builder("github", "default", "http://repo.logic-labs.nl.s3.amazonaws.com/release");
		builder.setPolicy(new RepositoryPolicy(true, RepositoryPolicy.UPDATE_POLICY_INTERVAL + ":60", RepositoryPolicy.CHECKSUM_POLICY_IGNORE));
		RemoteRepository remoteRepository2 = builder.build();
		repositories.add(remoteRepository2);

		if (defaultLocalRepositoryLocation != null) {
			RemoteRepository.Builder localRepoBuilder = new RemoteRepository.Builder("local", "default", "file://" + defaultLocalRepositoryLocation);
			localRepoBuilder.setPolicy(new RepositoryPolicy(true, RepositoryPolicy.UPDATE_POLICY_INTERVAL + ":60", RepositoryPolicy.CHECKSUM_POLICY_FAIL));
			repositories.add(localRepoBuilder.build());
			LOGGER.debug("Adding " + defaultLocalRepositoryLocation + " as repository");
		}

		localRepositories = new ArrayList<RemoteRepository>();
		localRepositories.add(local);
	}

	public RemoteRepository getLocal() {
		return local;
	}	
	
	public MavenPluginLocation getPluginLocation(String defaultrepository, String groupId, String artifactId) {
		return new MavenPluginLocation(this, defaultrepository, groupId, artifactId);
	}
	
	public MavenPluginLocation getPluginLocation(String groupId, String artifactId) {
		return new MavenPluginLocation(this, defaultRemoteRepositoryLocation, groupId, artifactId);
	}
	
	private RepositorySystem newRepositorySystem() {
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

	private DefaultRepositorySystemSession newRepositorySystemSession(RepositorySystem system, Path localRepoFile) {
		DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();

		LocalRepository localRepo = new LocalRepository(localRepoFile.toFile());
		LocalRepositoryManager manager = system.newLocalRepositoryManager(session, localRepo);
		session.setLocalRepositoryManager(manager);

		return session;
	}

	public Set<RemoteRepository> getRepositories() {
		return repositories;
	}

	public List<RemoteRepository> getRepositoriesAsList() {
		return new ArrayList<>(repositories);
	}
	
	public RepositorySystemSession getSession() {
		return session;
	}
	
	public RepositorySystem getSystem() {
		return system;
	}

	public void clearCache() throws IOException {
		FileUtils.deleteDirectory(this.localRepoFile.toFile());
	}

	public List<RemoteRepository> getLocalRepositories() {
		return localRepositories;
	}

	public void addRepository(RemoteRepository repository) {
		repositories.add(repository);
	}
}