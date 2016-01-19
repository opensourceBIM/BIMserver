package org.bimserver.plugins;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.aether.DefaultRepositorySystemSession;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.connector.basic.BasicRepositoryConnectorFactory;
import org.eclipse.aether.impl.DefaultServiceLocator;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.resolution.ArtifactDescriptorException;
import org.eclipse.aether.resolution.ArtifactDescriptorRequest;
import org.eclipse.aether.resolution.ArtifactDescriptorResult;
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

public class MavenPluginLocation extends PluginLocation {

	private String defaultrepository;
	private String groupId;
	private String artifactId;
	private RepositorySystem system;
	private RepositorySystemSession session;
	private List<RemoteRepository> repositories;

	public MavenPluginLocation(String defaultrepository, String groupId, String artifactId) {
		this.defaultrepository = defaultrepository;
		this.groupId = groupId;
		this.artifactId = artifactId;
		
		system = newRepositorySystem();
		session = newRepositorySystemSession(system);
		repositories = newRepositories(system, session);
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public String getGroupId() {
		return groupId;
	}

	@Override
	public String toString() {
		return groupId + "." + artifactId;
	}

	@Override
	public List<PluginVersion> getAllVersions() {
		List<PluginVersion> pluginVersions = new ArrayList<>();

		Artifact artifact = new DefaultArtifact(groupId + ":" + artifactId + ":[0,)");

		VersionRangeRequest rangeRequest = new VersionRangeRequest();
		rangeRequest.setArtifact(artifact);
		rangeRequest.setRepositories(repositories);

//		RemoteRepository centralRepo = newCentralRepository();
		try {
			VersionRangeResult rangeResult = system.resolveVersionRange(session, rangeRequest);
			List<Version> versions = rangeResult.getVersions();
			for (Version version : versions) {
				ArtifactDescriptorRequest descriptorRequest = new ArtifactDescriptorRequest();
				
				Artifact versionArtifact = new DefaultArtifact(groupId + ":" + artifactId + ":pom:" + version.toString());
				
				descriptorRequest.setArtifact(versionArtifact);
				descriptorRequest.setRepositories(repositories);

				MavenPluginVersion mavenPluginVersion = new MavenPluginVersion(versionArtifact, version);
				ArtifactDescriptorResult descriptorResult = system.readArtifactDescriptor(session, descriptorRequest);
				
				ArtifactRequest request = new ArtifactRequest();
				request.setArtifact(descriptorResult.getArtifact());
				request.setRepositories(repositories);
				ArtifactResult resolveArtifact = system.resolveArtifact(session, request);
				
				File pomFile = resolveArtifact.getArtifact().getFile();
				
				MavenXpp3Reader mavenreader = new MavenXpp3Reader();

				try {
					Model model = mavenreader.read(new FileReader(pomFile));
					mavenPluginVersion.setModel(model);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (XmlPullParserException e) {
					e.printStackTrace();
				}

				for (org.eclipse.aether.graph.Dependency dependency : descriptorResult.getDependencies()) {
					DefaultArtifactVersion artifactVersion = new DefaultArtifactVersion(dependency.getArtifact().getVersion());
					mavenPluginVersion.addDependency(new MavenDependency(dependency.getArtifact(), artifactVersion));
				}
				pluginVersions.add(mavenPluginVersion);
			}

		} catch (VersionRangeResolutionException e) {
			e.printStackTrace();
		} catch (ArtifactDescriptorException e) {
			e.printStackTrace();
		} catch (ArtifactResolutionException e) {
			e.printStackTrace();
		}

		return pluginVersions;
	}

	public RepositorySystem newRepositorySystem() {
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

	public DefaultRepositorySystemSession newRepositorySystemSession(RepositorySystem system) {
		DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();

		LocalRepository localRepo = new LocalRepository("target/local-repo");
		session.setLocalRepositoryManager(system.newLocalRepositoryManager(session, localRepo));

		session.setTransferListener(new ConsoleTransferListener());
		session.setRepositoryListener(new ConsoleRepositoryListener());

		// uncomment to generate dirty trees
		// session.setDependencyGraphTransformer( null );

		return session;
	}

	public List<RemoteRepository> newRepositories(RepositorySystem system, RepositorySystemSession session) {
		return new ArrayList<RemoteRepository>(Arrays.asList(newCentralRepository()));
	}

	private RemoteRepository newCentralRepository() {
		return new RemoteRepository.Builder("central", "default", defaultrepository).build();
	}

	public String getRepository() {
		return defaultrepository;
	}

	public File getVersionJar(String version) throws ArtifactResolutionException {
		ArtifactDescriptorRequest descriptorRequest = new ArtifactDescriptorRequest();
		
		Artifact versionArtifact = new DefaultArtifact(groupId + ":" + artifactId + ":" + version.toString());
		
		descriptorRequest.setArtifact(versionArtifact);
		descriptorRequest.setRepositories(repositories);

		ArtifactRequest request = new ArtifactRequest();
		request.setArtifact(versionArtifact);
		request.setRepositories(repositories);
		ArtifactResult resolveArtifact = system.resolveArtifact(session, request);
		
		File jarFile = resolveArtifact.getArtifact().getFile();
		
		return jarFile;
	}
}