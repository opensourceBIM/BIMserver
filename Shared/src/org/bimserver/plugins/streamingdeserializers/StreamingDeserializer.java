package org.bimserver.plugins.streamingdeserializers;

import java.io.InputStream;

import org.bimserver.database.DatabaseSessionInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.deserializers.DeserializeException;

public interface StreamingDeserializer {

	void init(PackageMetaData packageMetaData);
	void read(InputStream inputStream, DatabaseSessionInterface databaseSession, String filename, long size) throws DeserializeException;
}