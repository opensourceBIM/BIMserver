package org.bimserver.plugins;

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

import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.interfaces.objects.SPluginBundleType;
import org.bimserver.interfaces.objects.SPluginBundleVersion;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;
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

public class MavenPluginLocation extends PluginLocation<MavenPluginVersion> {

	private String defaultrepository;
	private String groupId;
	private String artifactId;
	private MavenPluginRepository mavenPluginRepository;
	private String repository;

	protected MavenPluginLocation(MavenPluginRepository mavenPluginRepository, String defaultrepository, String groupId, String artifactId) {
		this.mavenPluginRepository = mavenPluginRepository;
		this.defaultrepository = defaultrepository;
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.repository = mavenPluginRepository.getRemoteRepositoryUrl();
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

			Model model = mavenreader.read(new FileReader(pomFile));
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

			Model model = mavenreader.read(new FileReader(pomFile.toFile()));
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

	public String getRepository() {
		return repository;
	}

	public MavenPluginBundle getMavenPluginBundle(String version) {
		RepositoryMavenPluginBundle repositoryMavenPluginBundle = new RepositoryMavenPluginBundle(this, version);
		return repositoryMavenPluginBundle;
	}
}