package org.bimserver.plugins;

import java.io.ByteArrayInputStream;

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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
import java.util.List;
import java.util.Properties;

import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.interfaces.objects.SPluginBundleType;
import org.bimserver.interfaces.objects.SPluginBundleVersion;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;
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
import org.eclipse.aether.version.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MavenPluginLocation extends PluginLocation<MavenPluginVersion> {

	private static final Logger LOGGER = LoggerFactory.getLogger(MavenPluginLocation.class);
	private String defaultrepository;
	private String groupId;
	private String artifactId;
	private MavenPluginRepository mavenPluginRepository;

	protected MavenPluginLocation(MavenPluginRepository mavenPluginRepository, String defaultrepository, String groupId, String artifactId) {
		this.mavenPluginRepository = mavenPluginRepository;
		this.mavenPluginRepository.getRepositories().add(new RemoteRepository.Builder("given", "default", defaultrepository).build());
		this.defaultrepository = defaultrepository;
		this.groupId = groupId;
		this.artifactId = artifactId;
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
	public List<MavenPluginVersion> getAllVersions() {
		List<MavenPluginVersion> pluginVersions = new ArrayList<>();

		Artifact artifact = new DefaultArtifact(groupId + ":" + artifactId + ":[0,)");

		VersionRangeRequest rangeRequest = new VersionRangeRequest();
		rangeRequest.setArtifact(artifact);
		rangeRequest.setRepositories(mavenPluginRepository.getRepositories());

//		RemoteRepository centralRepo = newCentralRepository();
		try {
			VersionRangeResult rangeResult = mavenPluginRepository.getSystem().resolveVersionRange(mavenPluginRepository.getSession(), rangeRequest);
			List<Version> versions = rangeResult.getVersions();
			if (!versions.isEmpty()) {
				for (int i=versions.size() - 1; i >= Math.max(0, versions.size() - 4); i--) {
					Version version = versions.get(i);
					ArtifactDescriptorRequest descriptorRequest = new ArtifactDescriptorRequest();
					
					Artifact versionArtifact = new DefaultArtifact(groupId + ":" + artifactId + ":pom:" + version.toString());
					
					descriptorRequest.setArtifact(versionArtifact);
					descriptorRequest.setRepositories(mavenPluginRepository.getRepositories());
	
					MavenPluginVersion mavenPluginVersion = new MavenPluginVersion(versionArtifact, version);
					ArtifactDescriptorResult descriptorResult = mavenPluginRepository.getSystem().readArtifactDescriptor(mavenPluginRepository.getSession(), descriptorRequest);
					
					ArtifactRequest request = new ArtifactRequest();
					request.setArtifact(descriptorResult.getArtifact());
					request.setRepositories(mavenPluginRepository.getRepositories());
					ArtifactResult resolveArtifact = mavenPluginRepository.getSystem().resolveArtifact(mavenPluginRepository.getSession(), request);
					
					File pomFile = resolveArtifact.getArtifact().getFile();
					MavenXpp3Reader mavenreader = new MavenXpp3Reader();

					try (FileReader fileReader = new FileReader(pomFile)) {
						Model model = mavenreader.read(fileReader);
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
					pluginVersions.add(0, mavenPluginVersion);
				}
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

	public String getLatestVersionString() {
		Artifact lastArt = new DefaultArtifact(groupId, artifactId, "jar", "LATEST");

		ArtifactRequest request = new ArtifactRequest();
		request.setArtifact(lastArt);
		request.setRepositories(mavenPluginRepository.getRepositories());
		
		try {
			ArtifactResult resolveArtifact = mavenPluginRepository.getSystem().resolveArtifact(mavenPluginRepository.getSession(), request);
			return resolveArtifact.getArtifact().getVersion();
		} catch (ArtifactResolutionException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	public MavenPluginVersion getLatestVersion() {
		Artifact artifact = new DefaultArtifact(groupId + ":" + artifactId + ":LATEST");
		
		VersionRangeRequest rangeRequest = new VersionRangeRequest();
		rangeRequest.setArtifact(artifact);
		rangeRequest.setRepositories(mavenPluginRepository.getRepositories());
		
		try {
			VersionRangeResult rangeResult = mavenPluginRepository.getSystem().resolveVersionRange(mavenPluginRepository.getSession(), rangeRequest);
			List<Version> versions = rangeResult.getVersions();
			if (!versions.isEmpty()) {
				Version version = versions.get(0);
				ArtifactDescriptorRequest descriptorRequest = new ArtifactDescriptorRequest();

				Artifact versionArtifact = new DefaultArtifact(groupId + ":" + artifactId + ":pom:" + version.toString());

				descriptorRequest.setArtifact(versionArtifact);
				descriptorRequest.setRepositories(mavenPluginRepository.getRepositories());

				MavenPluginVersion mavenPluginVersion = new MavenPluginVersion(versionArtifact, version);
				ArtifactDescriptorResult descriptorResult = mavenPluginRepository.getSystem().readArtifactDescriptor(mavenPluginRepository.getSession(), descriptorRequest);

				ArtifactRequest request = new ArtifactRequest();
				request.setArtifact(descriptorResult.getArtifact());
				request.setRepositories(mavenPluginRepository.getRepositories());
				ArtifactResult resolveArtifact = mavenPluginRepository.getSystem().resolveArtifact(mavenPluginRepository.getSession(), request);

				File pomFile = resolveArtifact.getArtifact().getFile();
				MavenXpp3Reader mavenreader = new MavenXpp3Reader();

				try (FileReader fileReader = new FileReader(pomFile)) {
					try {
						Model model = mavenreader.read(fileReader);
						mavenPluginVersion.setModel(model);
					} catch (XmlPullParserException e) {
						e.printStackTrace();
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				for (org.eclipse.aether.graph.Dependency dependency : descriptorResult.getDependencies()) {
					DefaultArtifactVersion artifactVersion = new DefaultArtifactVersion(dependency.getArtifact().getVersion());
					mavenPluginVersion.addDependency(new MavenDependency(dependency.getArtifact(), artifactVersion));
				}
				return mavenPluginVersion;
			}
		} catch (VersionRangeResolutionException e) {
			e.printStackTrace();
		} catch (ArtifactDescriptorException e) {
			e.printStackTrace();
		} catch (ArtifactResolutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Path getVersionJar(String version) throws ArtifactResolutionException {
		Artifact versionArtifact = new DefaultArtifact(groupId, artifactId, "jar", version.toString());
		
		ArtifactRequest request = new ArtifactRequest();
		request.setArtifact(versionArtifact);
		request.setRepositories(mavenPluginRepository.getRepositories());
		ArtifactResult resolveArtifact = mavenPluginRepository.getSystem().resolveArtifact(mavenPluginRepository.getSession(), request);
		
		return resolveArtifact.getArtifact().getFile().toPath();
	}

	public Path getVersionIcon(String version) throws ArtifactResolutionException {
		Artifact versionArtifact = new DefaultArtifact(groupId, artifactId, "icon", "png", version.toString());
		
		ArtifactRequest request = new ArtifactRequest();
		request.setArtifact(versionArtifact);
		request.setRepositories(mavenPluginRepository.getRepositories());
		ArtifactResult resolveArtifact = mavenPluginRepository.getSystem().resolveArtifact(mavenPluginRepository.getSession(), request);
		
		return resolveArtifact.getArtifact().getFile().toPath();
	}

	public Path getVersionDate(String version) throws ArtifactResolutionException {
		Artifact versionArtifact = new DefaultArtifact(groupId, artifactId, "version", "properties", version.toString());
		
		ArtifactRequest request = new ArtifactRequest();
		request.setArtifact(versionArtifact);
		request.setRepositories(mavenPluginRepository.getRepositories());
		ArtifactResult resolveArtifact = mavenPluginRepository.getSystem().resolveArtifact(mavenPluginRepository.getSession(), request);
		
		return resolveArtifact.getArtifact().getFile().toPath();
	}

	public Path getVersionPluginXml(String version) throws ArtifactResolutionException {
		Artifact versionArtifact = new DefaultArtifact(groupId, artifactId, "plugin", "xml", version.toString());
		
		ArtifactRequest request = new ArtifactRequest();
		request.setArtifact(versionArtifact);
		request.setRepositories(mavenPluginRepository.getRepositories());
		ArtifactResult resolveArtifact = mavenPluginRepository.getSystem().resolveArtifact(mavenPluginRepository.getSession(), request);
		
		return resolveArtifact.getArtifact().getFile().toPath();
	}

	public Path getVersionPom(String version) throws ArtifactResolutionException {
		Artifact pomArtifact = new DefaultArtifact(groupId, artifactId, "pom", version.toString());

		ArtifactRequest request = new ArtifactRequest();
		request.setArtifact(pomArtifact);
		request.setRepositories(mavenPluginRepository.getRepositories());
		ArtifactResult resolveArtifact = mavenPluginRepository.getSystem().resolveArtifact(mavenPluginRepository.getSession(), request);
		
		return resolveArtifact.getArtifact().getFile().toPath();
	}
	
	@Override
	public PluginBundleIdentifier getPluginIdentifier() {
		return new PluginBundleIdentifier(groupId, artifactId);
	}

	public SPluginBundle getPluginBundle(String version) {
		try {
			Artifact versionArtifact = new DefaultArtifact(groupId, artifactId, "pom", version);
			
			ArtifactRequest request = new ArtifactRequest();
			request.setArtifact(versionArtifact);
			request.setRepositories(mavenPluginRepository.getRepositories());
			ArtifactResult resolveArtifact = mavenPluginRepository.getSystem().resolveArtifact(mavenPluginRepository.getSession(), request);
	
			File pomFile = resolveArtifact.getArtifact().getFile();
			
			MavenXpp3Reader mavenreader = new MavenXpp3Reader();

			Model model = null;
			try (FileReader fileReader = new FileReader(pomFile)) {
				model = mavenreader.read(fileReader);
			}
			SPluginBundle sPluginBundle = new SPluginBundle();
			
			sPluginBundle.setOrganization(model.getOrganization().getName());
			sPluginBundle.setName(model.getName());

			return sPluginBundle;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (ArtifactResolutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public SPluginBundleVersion getPluginBundleVersion(String version) {
		try {
			Path pomFile = getVersionPom(version);
			
			MavenXpp3Reader mavenreader = new MavenXpp3Reader();

			Model model = null;
			try (FileReader fileReader = new FileReader(pomFile.toFile())) {
				model = mavenreader.read(fileReader);
			}
			SPluginBundleVersion sPluginBundleVersion = new SPluginBundleVersion();
			sPluginBundleVersion.setOrganization(model.getOrganization().getName());
			sPluginBundleVersion.setName(model.getName());
			sPluginBundleVersion.setType(SPluginBundleType.MAVEN);
			sPluginBundleVersion.setGroupId(groupId);
			sPluginBundleVersion.setArtifactId(artifactId);
			sPluginBundleVersion.setVersion(version);
			sPluginBundleVersion.setDescription(model.getDescription());
			sPluginBundleVersion.setRepository(defaultrepository);
			sPluginBundleVersion.setMismatch(false);
			
			try {
				Path icon = getVersionIcon(version);
				sPluginBundleVersion.setIcon(Files.readAllBytes(icon));
			} catch (ArtifactResolutionException e) {
				// Not a problem
			}
			try {
				Path date = getVersionDate(version);
				byte[] bytes = Files.readAllBytes(date);
				Properties properties = new Properties();
				properties.load(new ByteArrayInputStream(bytes));
				String buildDateString = properties.getProperty("build.date");
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
				sPluginBundleVersion.setDate(dateFormat.parse(buildDateString));
			} catch (ArtifactResolutionException e) {
				// Not a problem
			} catch (Exception e) {
				LOGGER.error("", e);
			}

			return sPluginBundleVersion;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (ArtifactResolutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PluginBundleVersionIdentifier getPluginVersionIdentifier(String version) {
		return new PluginBundleVersionIdentifier(getPluginIdentifier(), version);
	}

	public String getRepository(String version) throws ArtifactResolutionException {
		Artifact pomArtifact = new DefaultArtifact(groupId, artifactId, "pom", version.toString());

		ArtifactRequest request = new ArtifactRequest();
		request.setArtifact(pomArtifact);
		request.setRepositories(mavenPluginRepository.getRepositories());
		ArtifactResult resolveArtifact = mavenPluginRepository.getSystem().resolveArtifact(mavenPluginRepository.getSession(), request);
		
		return resolveArtifact.getRepository().toString();
	}

	public MavenPluginBundle getMavenPluginBundle(String version) {
		RepositoryMavenPluginBundle repositoryMavenPluginBundle = new RepositoryMavenPluginBundle(this, version);
		return repositoryMavenPluginBundle;
	}
}