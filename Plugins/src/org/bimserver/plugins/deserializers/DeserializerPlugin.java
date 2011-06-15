package org.bimserver.plugins.deserializers;

import org.bimserver.plugins.Plugin;

public interface DeserializerPlugin extends Plugin {
	EmfDeserializer createDeserializer();
	boolean canHandleExtension(String extension);
}