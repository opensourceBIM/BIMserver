package org.bimserver.plugins.serializers;

import org.bimserver.plugins.BimPlugin;

public interface SerializerPlugin extends BimPlugin {
	EmfSerializer createSerializer();
	String getDefaultSerializerName();
	String getDefaultExtension();
	String getDefaultContentType();
}