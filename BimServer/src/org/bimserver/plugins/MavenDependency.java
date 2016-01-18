package org.bimserver.plugins;

import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.eclipse.aether.artifact.Artifact;

public class MavenDependency {

	private Artifact artifact;
	private DefaultArtifactVersion artifactVersion;

	public MavenDependency(Artifact artifact, DefaultArtifactVersion artifactVersion) {
		this.artifact = artifact;
		this.artifactVersion = artifactVersion;
	}
	
	public Artifact getArtifact() {
		return artifact;
	}
	
	public DefaultArtifactVersion getArtifactVersion() {
		return artifactVersion;
	}
}
