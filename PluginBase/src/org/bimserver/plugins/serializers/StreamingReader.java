package org.bimserver.plugins.serializers;

import java.io.OutputStream;

import org.bimserver.BimserverDatabaseException;

public interface StreamingReader {

	boolean write(OutputStream out) throws SerializerException, BimserverDatabaseException;
}