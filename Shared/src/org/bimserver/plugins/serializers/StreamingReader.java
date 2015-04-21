package org.bimserver.plugins.serializers;

import java.io.OutputStream;

public interface StreamingReader {

	boolean write(OutputStream out);
}