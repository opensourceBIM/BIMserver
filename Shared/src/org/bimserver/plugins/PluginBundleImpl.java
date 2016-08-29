package org.bimserver.plugins;

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
