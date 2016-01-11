package org.bimserver.plugins.deserializers;

import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginConfiguration;

public interface StreamingDeserializerPlugin extends Plugin {
	/**
	 * @param pluginConfiguration User specific settings for this plugin
	 * @return The deserializer
	 */
	StreamingDeserializer createDeserializer(PluginConfiguration pluginConfiguration);
	
	/**
	 * @param extension
	 * @return Whether this plugin can handle the given extension
	 */
	boolean canHandleExtension(String extension);
	
	/**
	 * @return A set of Schemas this deserializer can deserialize
	 */
	Set<Schema> getSupportedSchemas();
}
