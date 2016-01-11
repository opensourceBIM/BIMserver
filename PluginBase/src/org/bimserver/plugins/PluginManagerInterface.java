package org.bimserver.plugins;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.Path;

import org.bimserver.emf.MetaDataManager;
import org.bimserver.models.store.Parameter;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMException;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.NewExtendedDataOnProjectHandler;
import org.bimserver.plugins.services.NewExtendedDataOnRevisionHandler;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.plugins.stillimagerenderer.StillImageRenderPlugin;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServiceException;

public interface PluginManagerInterface {

	Plugin getPlugin(String string, boolean b);

	PluginContext getPluginContext(Plugin abstractWebModulePlugin);

	FileSystem getOrCreateFileSystem(URI location) throws IOException;

	void notifyPluginStateChange(PluginContext pluginContext, boolean enabled);

	Parameter getParameter(PluginContext pluginContext, String name);

	Path getTempDir();

	String getCompleteClassPath();

	DeserializerPlugin getDeserializerPlugin(String string, boolean b);

	StillImageRenderPlugin getFirstStillImageRenderPlugin() throws PluginException;

	RenderEnginePlugin requireRenderEngine() throws PluginException;

	DeserializerPlugin requireDeserializer(String string) throws DeserializeException;

	void registerNewRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor, NewRevisionHandler newRevisionHandler);

	void unregisterNewRevisionHandler(ServiceDescriptor serviceDescriptor);

	BimServerClientInterface getLocalBimServerClientInterface(AuthenticationInfo tokenAuthentication) throws ServiceException, ChannelConnectionException;

	void registerNewExtendedDataOnProjectHandler(long uoid, ServiceDescriptor serviceDescriptor, NewExtendedDataOnProjectHandler newExtendedDataHandler);

	void registerNewExtendedDataOnRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor, NewExtendedDataOnRevisionHandler newExtendedDataHandler);

	ServiceFactory getServiceFactory();

	MetaDataManager getMetaDataManager();

	ObjectIDM requireObjectIDM() throws ObjectIDMException;
}
