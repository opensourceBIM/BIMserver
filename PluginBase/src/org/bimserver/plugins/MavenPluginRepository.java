package org.bimserver.plugins;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.eclipse.aether.DefaultRepositorySystemSession;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.connector.basic.BasicRepositoryConnectorFactory;
import org.eclipse.aether.impl.DefaultServiceLocator;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.repository.RepositoryPolicy;
import org.eclipse.aether.spi.connector.RepositoryConnectorFactory;
import org.eclipse.aether.spi.connector.transport.TransporterFactory;
import org.eclipse.aether.transport.file.FileTransporterFactory;
import org.eclipse.aether.transport.http.HttpTransporterFactory;

public class MavenPluginRepository {
	private final RepositorySystem system;
	private final RepositorySystemSession session;
	private final List<RemoteRepository> repositories;
	private final RemoteRepository remoteRepository;
	private String defaultRepository;
	private Path localRepoFile;
	
	public MavenPluginRepository(Path localRepoFile) {
		this(localRepoFile, "http://central.maven.org/maven2");
	}
	
	public MavenPluginRepository(Path localRepoFile, String defaultRepository) {
		this.localRepoFile = localRepoFile;
		this.defaultRepository = defaultRepository;
		system = newRepositorySystem();
		session = newRepositorySystemSession(system, localRepoFile);
		RemoteRepository.Builder builder = new RemoteRepository.Builder("central", "default", defaultRepository);
		builder.setPolicy(new RepositoryPolicy(true, RepositoryPolicy.UPDATE_POLICY_INTERVAL + ":60", RepositoryPolicy.CHECKSUM_POLICY_FAIL));
		remoteRepository = builder.build();
		repositories = new ArrayList<RemoteRepository>(Arrays.asList(remoteRepository));
	}
	
	public MavenPluginLocation getPluginLocation(String defaultrepository, String groupId, String artifactId) {
		return new MavenPluginLocation(this, defaultrepository, groupId, artifactId);
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
		session.setLocalRepositoryManager(system.newLocalRepositoryManager(session, localRepo));

		return session;
	}

	public List<RemoteRepository> getRepositories() {
		return repositories;
	}
	
	public RepositorySystemSession getSession() {
		return session;
	}
	
	public RepositorySystem getSystem() {
		return system;
	}

	public String getRemoteRepositoryUrl() {
		return defaultRepository;
	}

	public void clearCache() throws IOException {
		FileUtils.deleteDirectory(this.localRepoFile.toFile());
	}
}