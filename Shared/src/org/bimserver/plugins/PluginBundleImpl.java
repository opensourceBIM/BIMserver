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

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.interfaces.objects.SPluginBundleVersion;

public class PluginBundleImpl implements PluginBundle, Iterable<PluginContext> {
	private final Map<String, PluginContext> pluginsContexts = new HashMap<>();
	private final Set<Closeable> cloaseables = new HashSet<>();
	private SPluginBundleVersion pluginBundleVersion;
	private PluginBundleVersionIdentifier pluginBundleVersionIdentifier;
	private SPluginBundle sPluginBundle;
	private PluginDescriptor pluginDescriptor;

	public PluginBundleImpl(PluginBundleVersionIdentifier pluginBundleVersionIdentifier, SPluginBundle sPluginBundle, SPluginBundleVersion pluginBundleVersion, PluginDescriptor pluginDescriptor) {
		this.pluginBundleVersionIdentifier = pluginBundleVersionIdentifier;
		this.sPluginBundle = sPluginBundle;
		this.pluginBundleVersion = pluginBundleVersion;
		this.pluginDescriptor = pluginDescriptor;
	}
	
	public PluginDescriptor getPluginDescriptor() {
		return pluginDescriptor;
	}
	
	public void add(PluginContext pluginContext) {
		pluginsContexts.put(pluginContext.getIdentifier(), pluginContext);
	}

	@Override
	public Iterator<PluginContext> iterator() {
		return pluginsContexts.values().iterator();
	}

	public void close() throws IOException {
		for (Closeable closeable : cloaseables) {
			closeable.close();
		}
	}

	public void addCloseable(Closeable closeable) {
		cloaseables.add(closeable);
	}

	public PluginBundleVersionIdentifier getPluginBundleVersionIdentifier() {
		return pluginBundleVersionIdentifier;
	}

	@Override
	public String getVersion() {
		return pluginBundleVersion.getVersion();
	}

	public SPluginBundleVersion getPluginBundleVersion() {
		return pluginBundleVersion;
	}

	@Override
	public SPluginBundle getPluginBundle() {
		SPluginBundle result = new SPluginBundle();
		result.setName(sPluginBundle.getName());
		result.setOrganization(sPluginBundle.getOrganization());
		
		if (sPluginBundle.getInstalledVersion() != null) {
			SPluginBundleVersion installedVersion = new SPluginBundleVersion();
			installedVersion.setArtifactId(sPluginBundle.getInstalledVersion().getArtifactId());
			installedVersion.setDescription(sPluginBundle.getInstalledVersion().getDescription());
			installedVersion.setGroupId(sPluginBundle.getInstalledVersion().getGroupId());
			installedVersion.setIcon(sPluginBundle.getInstalledVersion().getIcon());
			installedVersion.setMismatch(sPluginBundle.getInstalledVersion().isMismatch());
			installedVersion.setName(sPluginBundle.getInstalledVersion().getName());
			installedVersion.setOrganization(sPluginBundle.getInstalledVersion().getOrganization());
			installedVersion.setRepository(sPluginBundle.getInstalledVersion().getRepository());
			installedVersion.setType(sPluginBundle.getInstalledVersion().getType());
			installedVersion.setVersion(sPluginBundle.getInstalledVersion().getVersion());
			result.setInstalledVersion(installedVersion);
		}
		
		return result;
	}

	@Override
	public PluginContext getPluginContext(String identifier) {
		return pluginsContexts.get(identifier);
	}
}
