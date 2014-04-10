package org.bimserver.plugins.streamingdeserializers;

import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginConfiguration;

public interface StreamingDeserializerPlugin extends Plugin {
	StreamingDeserializer createDeserializer(PluginConfiguration pluginConfiguration);
}
