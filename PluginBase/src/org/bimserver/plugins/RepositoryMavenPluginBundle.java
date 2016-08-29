package org.bimserver.plugins;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.interfaces.objects.SPluginBundleVersion;
import org.eclipse.aether.resolution.ArtifactResolutionException;

public class RepositoryMavenPluginBundle implements MavenPluginBundle {

	private MavenPluginLocation mavenPluginLocation;
	private String version;

	public RepositoryMavenPluginBundle(MavenPluginLocation mavenPluginLocation, String version) {
		this.mavenPluginLocation = mavenPluginLocation;
		this.version = version;
	}
	
	@Override
	public InputStream getPomInputStream() {
		try {
			Path path = mavenPluginLocation.getVersionPom(version);
			return Files.newInputStream(path);
		} catch (ArtifactResolutionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PluginBundleVersionIdentifier getPluginVersionIdentifier() {
		return mavenPluginLocation.getPluginVersionIdentifier(version);
	}

	@Override
	public String getVersion() {
		return version;
	}

	@Override
	public InputStream getJarInputStream() {
		try {
			Path path = mavenPluginLocation.getVersionJar(version);
			return Files.newInputStream(path);
		} catch (ArtifactResolutionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SPluginBundle getPluginBundle() {
		return mavenPluginLocation.getPluginBundle(version);
	}

	@Override
	public SPluginBundleVersion getPluginBundleVersion() {
		return mavenPluginLocation.getPluginBundleVersion(version);
	}
}