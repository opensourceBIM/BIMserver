package org.bimserver.plugins.serializers;

import org.bimserver.plugins.Plugin;

public interface SerializerPlugin extends Plugin {
	EmfSerializer createSerializer();
	String getDefaultSerializerName();
	String getDefaultExtension();
	String getDefaultContentType();
}