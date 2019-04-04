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
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import org.bimserver.emf.MetaDataManager;
import org.bimserver.models.store.Parameter;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.NewExtendedDataOnProjectHandler;
import org.bimserver.plugins.services.NewExtendedDataOnRevisionHandler;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PluginClassLoaderProvider;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServiceException;

public class PluginContext {

	private final PluginManagerInterface pluginManager;
	private final ClassLoader classLoader;
	private final PluginSourceType pluginType;
	private final URI location;
	private final Plugin plugin;
	private final String classLocation;
	private boolean enabled = true;
	private FileSystem fileSystem;
	private Path rootPath;
	private Set<Dependency> dependencies;
	private PluginBundle pluginBundle;
	private String description;
	private boolean initialized;
	private Class<?> pluginInterface;
	private String identifier;
	private PluginConfiguration systemSettings;

	public PluginContext(PluginManagerInterface pluginManager, PluginBundle pluginBundle, Class<?> pluginInterface, ClassLoader classLoader, PluginSourceType pluginType, String description, URI location, Plugin plugin, String classLocation, Set<Dependency> dependencies, String identifier) throws IOException {
		this.pluginManager = pluginManager;
		this.pluginBundle = pluginBundle;
		this.pluginInterface = pluginInterface;
		this.classLoader = classLoader;
		this.pluginType = pluginType;
		this.description = description;
		this.location = location;
		this.plugin = plugin;
		this.classLocation = classLocation;
		this.dependencies = dependencies;
		this.identifier = identifier;

		switch (pluginType) {
		case ECLIPSE_PROJECT:
			fileSystem = FileSystems.getDefault();
			rootPath = Paths.get(location);
			break;
		case INTERNAL:
			break;
		case JAR_FILE:
			fileSystem = pluginManager.getOrCreateFileSystem(location);
			rootPath = fileSystem.getPath("/");
			break;
		default:
			break;
		}
	}
	
	public BasicServerInfo getBasicServerInfo() {
		return pluginManager.getBasicServerInfo();
	}
	
	public PluginSourceType getPluginType() {
		return pluginType;
	}

	public Plugin getPlugin() {
		return plugin;
	}

	public URI getLocation() {
		return location;
	}

	public void setEnabled(boolean enabled, boolean notify) {
		this.enabled = enabled;
		if (notify) {
			pluginManager.notifyPluginStateChange(this, enabled);
		}
	}

	public boolean isEnabled() {
		return enabled;
	}

	public String getClassLocation() {
		return classLocation;
	}

	public ClassLoader getClassLoader() {
		return classLoader;
	}

	public Path getRootPath() {
		return rootPath;
	}
	
	public Parameter getParameter(String name) {
		return pluginManager.getParameter(this, name);
	}
	
	public Set<Dependency> getDependencies() {
		return dependencies;
	}

	public PluginBundle getPluginBundle() {
		return pluginBundle;
	}

	public String getDescription() {
		return description;
	}

	public boolean isInitialized() {
		return initialized;
	}

	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}

	public String getVersion() {
		// All plugins in a bundle have the same version
		return pluginBundle.getVersion();
	}

	public Class<?> getPluginInterface() {
		return pluginInterface;
	}

	public void initialize(PluginConfiguration systemSettings) throws PluginException {
//		if (!isInitialized()) {
			plugin.init(this, systemSettings);
			setInitialized(true);
//		}
	}

	public String getIdentifier() {
		return identifier;
	}

	public Path getTempDir() {
		return pluginManager.getTempDir().resolve(getPluginBundle().getPluginBundleVersion().getGroupId() + "." + getPluginBundle().getPluginBundleVersion().getArtifactId());
	}

	public MetaDataManager getMetaDataManager() {
		return pluginManager.getMetaDataManager();
	}

	public ServiceFactory getServiceFactory() {
		return pluginManager.getServiceFactory();
	}

	public void registerNewRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor, NewRevisionHandler newRevisionHandler) {
		pluginManager.registerNewRevisionHandler(uoid, serviceDescriptor, newRevisionHandler);
	}

	public void unregisterNewRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor) {
		pluginManager.unregisterNewRevisionHandler(uoid, serviceDescriptor);
	}

	public BimServerClientInterface getLocalBimServerClientInterface(AuthenticationInfo tokenAuthentication) throws ServiceException, ChannelConnectionException {
		return pluginManager.getLocalBimServerClientInterface(tokenAuthentication);
	}

	public void registerNewExtendedDataOnProjectHandler(long uoid, ServiceDescriptor serviceDescriptor, NewExtendedDataOnProjectHandler newExtendedDataHandler) {
		pluginManager.registerNewExtendedDataOnProjectHandler(uoid, serviceDescriptor, newExtendedDataHandler);
	}

	public void registerNewExtendedDataOnRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor, NewExtendedDataOnRevisionHandler newExtendedDataHandler) {
		pluginManager.registerNewExtendedDataOnRevisionHandler(uoid, serviceDescriptor, newExtendedDataHandler);
	}

	public DeserializerPlugin requireDeserializer(String extension) throws DeserializeException {
		return pluginManager.requireDeserializer(extension);
	}

	public DeserializerPlugin getDeserializerPlugin(String string, boolean b) {
		return pluginManager.getDeserializerPlugin(string, b);
	}

	public SerializerPlugin getSerializerPlugin(String string) {
		return pluginManager.getSerializerPlugin(string);
	}
	
	public PluginConfiguration getSystemSettings() {
		return systemSettings;
	}

	public PluginClassLoaderProvider getPluginClassLoaderProvider() {
		return pluginManager;
	}
}