import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.eclipse.aether.DefaultRepositorySystemSession;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.connector.basic.BasicRepositoryConnectorFactory;
import org.eclipse.aether.impl.DefaultServiceLocator;
import org.eclipse.aether.repository.Authentication;
import org.eclipse.aether.repository.AuthenticationContext;
import org.eclipse.aether.repository.AuthenticationDigest;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.LocalRepositoryManager;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.repository.RepositoryPolicy;
import org.eclipse.aether.resolution.ArtifactRequest;
import org.eclipse.aether.resolution.ArtifactResolutionException;
import org.eclipse.aether.resolution.ArtifactResult;
import org.eclipse.aether.resolution.VersionRangeRequest;
import org.eclipse.aether.resolution.VersionRangeResolutionException;
import org.eclipse.aether.resolution.VersionRangeResult;
import org.eclipse.aether.spi.connector.RepositoryConnectorFactory;
import org.eclipse.aether.spi.connector.transport.TransporterFactory;
import org.eclipse.aether.transport.file.FileTransporterFactory;
import org.eclipse.aether.transport.http.HttpTransporterFactory;
import org.eclipse.aether.version.Version;

public class Test {
	private static RepositorySystem newRepositorySystem() {
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
	
	private static DefaultRepositorySystemSession newRepositorySystemSession(RepositorySystem system, Path localRepoFile) {
		DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();

		LocalRepository localRepo = new LocalRepository(localRepoFile.toFile());
		LocalRepositoryManager manager = system.newLocalRepositoryManager(session, localRepo);
		session.setLocalRepositoryManager(manager);

		return session;
	}
	
	public static void main(String[] args) {
		List<RemoteRepository> repositories = new ArrayList<>();

		RemoteRepository.Builder archivaRepoBuilder = new RemoteRepository.Builder("local", "default", "http://archiva.logic-labs.nl/repository/snapshots");
		archivaRepoBuilder.setPolicy(new RepositoryPolicy(true, RepositoryPolicy.UPDATE_POLICY_INTERVAL + ":60", RepositoryPolicy.CHECKSUM_POLICY_FAIL));
		RemoteRepository localRepo = archivaRepoBuilder.build();
		System.out.println(localRepo);
		repositories.add(localRepo);

		RemoteRepository.Builder builder = new RemoteRepository.Builder("central", "default", "http://central.maven.org/maven2");
		builder.setPolicy(new RepositoryPolicy(true, RepositoryPolicy.UPDATE_POLICY_INTERVAL + ":60", RepositoryPolicy.CHECKSUM_POLICY_FAIL));
		RemoteRepository remoteRepository = builder.build();
//		repositories.add(remoteRepository);
		
		RepositorySystem system = newRepositorySystem();
		DefaultRepositorySystemSession session = newRepositorySystemSession(system, Paths.get("maven"));

		Artifact lastArt = new DefaultArtifact("org.opensourcebim", "ifcplugins", "jar", "LATEST");

		ArtifactRequest request = new ArtifactRequest();
		request.setArtifact(lastArt);
		request.setRepositories(repositories);
		
		try {
			ArtifactResult resolveArtifact = system.resolveArtifact(session, request);
			System.out.println(resolveArtifact.getArtifact().getVersion());
		} catch (ArtifactResolutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Artifact versionArtifact = new DefaultArtifact("org.opensourcebim", "ifcplugins", "jar", "(0,]");

		VersionRangeRequest request2 = new VersionRangeRequest();
		request2.setArtifact(versionArtifact);
		request2.setRepositories(repositories);
		
		try {
			VersionRangeResult resolveArtifact2 = system.resolveVersionRange(session, request2);
			System.out.println(resolveArtifact2.getHighestVersion());
		} catch (VersionRangeResolutionException e) {
			e.printStackTrace();
		}
	}
}
