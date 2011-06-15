package org.bimserver.plugins.schema;

import org.bimserver.plugins.Plugin;

public interface SchemaPlugin extends Plugin {
	SchemaDefinition getSchemaDefinition();
}
