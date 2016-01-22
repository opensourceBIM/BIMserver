package org.bimserver.plugins;

import org.bimserver.shared.exceptions.PluginException;

public class PluginBundleVersionIdentifier {

	private PluginBundleIdentifier pluginBundleIdentifier;
	private String version;

	public PluginBundleVersionIdentifier(PluginBundleIdentifier pluginBundleIdentifier, String version) {
		this.pluginBundleIdentifier = pluginBundleIdentifier;
		this.version = version;
	}

	public PluginBundleVersionIdentifier(String groupId, String artifactId, String version) {
		this.pluginBundleIdentifier = new PluginBundleIdentifier(groupId, artifactId);
		this.version = version;
	}

	public String getFileName() {
		return pluginBundleIdentifier.getGroupId() + "." + pluginBundleIdentifier.getArtifactId() + "-" + version + ".jar";
	}

	public PluginBundleIdentifier getPluginBundleIdentifier() {
		return pluginBundleIdentifier;
	}

	public static PluginBundleVersionIdentifier fromFileName(String filename) throws PluginException {
		try {
			String groupId = null;
			String artifactId = null;
			String version = null;
			if (filename.endsWith(".jar")) {
				filename = filename.substring(0, filename.length() - 4);
				version = filename.substring(filename.lastIndexOf("-") + 1);
				filename = filename.substring(0, filename.lastIndexOf("-"));
				artifactId = filename.substring(filename.lastIndexOf(".") + 1);
				groupId = filename.substring(0, filename.lastIndexOf("."));
				PluginBundleIdentifier pluginBundleIdentifier = new PluginBundleIdentifier(groupId, artifactId);
				PluginBundleVersionIdentifier pluginBundleVersionIdentifier = new PluginBundleVersionIdentifier(pluginBundleIdentifier, version);
				return pluginBundleVersionIdentifier;
			}
		} catch (Exception e) {
			throw new PluginException("Problem parsing filename " + filename, e);
		}
		return null;
	}

	public String getHumanReadable() {
		return pluginBundleIdentifier.getHumanReadable() + ":" + version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pluginBundleIdentifier == null) ? 0 : pluginBundleIdentifier.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PluginBundleVersionIdentifier other = (PluginBundleVersionIdentifier) obj;
		if (pluginBundleIdentifier == null) {
			if (other.pluginBundleIdentifier != null)
				return false;
		} else if (!pluginBundleIdentifier.equals(other.pluginBundleIdentifier))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
}