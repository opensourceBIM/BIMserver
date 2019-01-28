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