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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.interfaces.objects.SPluginBundleType;
import org.bimserver.interfaces.objects.SPluginBundleVersion;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

public class LocalMavenPluginBundle implements MavenPluginBundle {

	private Model model;
	private byte[] jarBytes;
	private byte[] pomBytes;

	public LocalMavenPluginBundle(byte[] jarBytes) {
		this.jarBytes = jarBytes;
		try {
			JarInputStream jarInputStream = new JarInputStream(new ByteArrayInputStream(jarBytes));
			JarEntry nextJarEntry = jarInputStream.getNextJarEntry();
			while (nextJarEntry != null) {
				String name = nextJarEntry.getName();
				if (name.startsWith("META-INF/maven") && name.endsWith("/pom.xml")) {
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					IOUtils.copy(jarInputStream, byteArrayOutputStream);
					pomBytes = byteArrayOutputStream.toByteArray();
					MavenXpp3Reader mavenreader = new MavenXpp3Reader();
					
					try {
						model = mavenreader.read(new ByteArrayInputStream(pomBytes));
					} catch (XmlPullParserException e) {
						e.printStackTrace();
					}
				}
				nextJarEntry = jarInputStream.getNextJarEntry();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public InputStream getPomInputStream() {
		return new ByteArrayInputStream(pomBytes);
	}

	@Override
	public PluginBundleVersionIdentifier getPluginVersionIdentifier() {
		PluginBundleIdentifier pluginBundleIdentifier = new PluginBundleIdentifier(model.getGroupId(), model.getArtifactId());
		return new PluginBundleVersionIdentifier(pluginBundleIdentifier, model.getVersion());
	}

	@Override
	public String getVersion() {
		return model.getVersion();
	}

	@Override
	public InputStream getJarInputStream() {
		return new ByteArrayInputStream(jarBytes);
	}

	@Override
	public SPluginBundle getPluginBundle() {
		SPluginBundle result = new SPluginBundle();
		result.setName(model.getName());
		result.setOrganization(model.getOrganization().getName());
		return result;
	}

	@Override
	public SPluginBundleVersion getPluginBundleVersion() {
		SPluginBundleVersion sPluginBundleVersion = new SPluginBundleVersion();
		sPluginBundleVersion.setType(SPluginBundleType.LOCAL);
		sPluginBundleVersion.setGroupId(model.getGroupId());
		sPluginBundleVersion.setArtifactId(model.getArtifactId());
		sPluginBundleVersion.setVersion(model.getVersion());
		sPluginBundleVersion.setDescription(model.getDescription());
		sPluginBundleVersion.setRepository("local");
		sPluginBundleVersion.setMismatch(false); // TODO
		sPluginBundleVersion.setOrganization(model.getOrganization().getName());
		sPluginBundleVersion.setName(model.getName());
		return sPluginBundleVersion;
	}
}
