package org.bimserver.plugins.schema;

import java.io.File;

import org.bimserver.plugins.Plugin;

public interface SchemaPlugin extends Plugin {
	SchemaDefinition getSchemaDefinition();
	File getExpressSchemaFile();
}
