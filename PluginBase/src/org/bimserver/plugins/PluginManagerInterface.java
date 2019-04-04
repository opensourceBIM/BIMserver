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
import java.nio.file.Path;

import org.bimserver.emf.MetaDataManager;
import org.bimserver.emf.Schema;
import org.bimserver.models.store.Parameter;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
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

public interface PluginManagerInterface extends PluginClassLoaderProvider {

	Plugin getPlugin(String string, boolean b);

	PluginContext getPluginContext(Plugin plugin);

	FileSystem getOrCreateFileSystem(URI location) throws IOException;

	void notifyPluginStateChange(PluginContext pluginContext, boolean enabled);

	Parameter getParameter(PluginContext pluginContext, String name);

	Path getTempDir();

	String getCompleteClassPath();

	DeserializerPlugin getDeserializerPlugin(String string, boolean enabled);
	
	RenderEnginePlugin getRenderEnginePlugin(String string, boolean enabled);

	DeserializerPlugin requireDeserializer(String string) throws DeserializeException;

	void registerNewRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor, NewRevisionHandler newRevisionHandler);

	void unregisterNewRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor);

	BimServerClientInterface getLocalBimServerClientInterface(AuthenticationInfo tokenAuthentication) throws ServiceException, ChannelConnectionException;

	void registerNewExtendedDataOnProjectHandler(long uoid, ServiceDescriptor serviceDescriptor, NewExtendedDataOnProjectHandler newExtendedDataHandler);

	void registerNewExtendedDataOnRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor, NewExtendedDataOnRevisionHandler newExtendedDataHandler);

	ServiceFactory getServiceFactory();

	MetaDataManager getMetaDataManager();

//	PluginBundle loadPluginsFromEclipseProject(Path projectRoot) throws PluginException;

	DeserializerPlugin getFirstDeserializer(String extension, Schema schema, boolean onlyEnabled) throws PluginException;

	SerializerPlugin getSerializerPlugin(String string);
	
	BasicServerInfo getBasicServerInfo();
}
