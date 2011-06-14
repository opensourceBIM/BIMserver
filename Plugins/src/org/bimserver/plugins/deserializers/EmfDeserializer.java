package org.bimserver.plugins.deserializers;

import java.io.InputStream;

import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.IfcModelInterface;

public abstract class EmfDeserializer {

	public abstract void init(SchemaDefinition schema);

	public abstract IfcModelInterface read(InputStream in, long fileSize) throws DeserializeException;

	public abstract IfcModelInterface getModel();
}