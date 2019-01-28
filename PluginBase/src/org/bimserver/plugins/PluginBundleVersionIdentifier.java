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

	@Override
	public String toString() {
		return getHumanReadable();
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