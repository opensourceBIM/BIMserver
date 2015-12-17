package org.bimserver.cache;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.plugins.serializers.ExtendedDataSource;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.SerializerException;

public class FileInputStreamDataSource extends ExtendedDataSource {

	private final Path file;
	private String name;
	private InputStream inputStream;
	
	public FileInputStreamDataSource(Path file) {
		this.file = file;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		if (inputStream != null) {
			inputStream.close();
		}
		inputStream = Files.newInputStream(file);
		return inputStream;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return null;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long size() {
		try {
			return Files.size(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void writeToOutputStream(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException, IOException, BimserverDatabaseException {
		copy(getInputStream(), outputStream, progressReporter, Files.size(file));
	}
	
	private long copy(InputStream input, OutputStream output, ProgressReporter progressReporter, long totalSize) throws IOException {
		byte[] buffer = new byte[4096];
        long count = 0;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
            progressReporter.update(count, totalSize);
        }
        return count;
	}
}