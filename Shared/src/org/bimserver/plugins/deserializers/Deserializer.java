package org.bimserver.plugins.deserializers;

import java.io.File;
import java.io.InputStream;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.schema.SchemaDefinition;

public interface Deserializer {
	void init(SchemaDefinition schemaDefinition);
	IfcModelInterface read(File file, boolean setOids) throws DeserializeException;
	IfcModelInterface read(InputStream inputStream, String fileName, boolean setOids, long fileSize) throws DeserializeException;
}