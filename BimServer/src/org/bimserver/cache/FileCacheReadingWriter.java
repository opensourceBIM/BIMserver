package org.bimserver.cache;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.Writer;

import com.google.common.io.ByteStreams;

public class FileCacheReadingWriter implements Writer, Closeable {

	private Path file;
	private DataInputStream inputStream;
	private int nextSize = -1;
	private byte[] buffer;

	public FileCacheReadingWriter(Path file) {
		this.file = file;
		try {
			inputStream = new DataInputStream(new BufferedInputStream(Files.newInputStream(file)));
			nextSize = inputStream.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean writeMessage(OutputStream outputStream, ProgressReporter progressReporter) throws IOException, SerializerException {
		if (buffer == null || nextSize > buffer.length) {
			buffer = new byte[nextSize];
		}
		ByteStreams.readFully(inputStream, buffer, 0, nextSize);
		outputStream.write(buffer, 0, nextSize);
		nextSize = inputStream.readInt();
		return nextSize != -1;
	}

	public void setName(String fileNameWithoutExtension) {
	}

	@Override
	public void close() throws IOException {
		inputStream.close();
	}
}
