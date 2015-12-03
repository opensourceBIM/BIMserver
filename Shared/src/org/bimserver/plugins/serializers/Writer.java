package org.bimserver.plugins.serializers;

import java.io.IOException;
import java.io.OutputStream;

public interface Writer {

	boolean writeMessage(OutputStream outputStream, ProgressReporter progressReporter) throws IOException, SerializerException;
}
