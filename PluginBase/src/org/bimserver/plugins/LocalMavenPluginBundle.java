package org.bimserver.plugins;

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
