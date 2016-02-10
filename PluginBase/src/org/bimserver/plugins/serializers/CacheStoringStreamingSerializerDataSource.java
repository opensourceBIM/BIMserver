package org.bimserver.plugins.serializers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bimserver.utils.MultiplexingOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheStoringStreamingSerializerDataSource extends ExtendedDataSource {

	private static final Logger LOGGER = LoggerFactory.getLogger(CacheStoringStreamingSerializerDataSource.class);
	private RemovableFileOutputStream diskCacheOutputStream;
	private StreamingSerializer serializer;
	private DoneListener doneListener;

	public CacheStoringStreamingSerializerDataSource(StreamingSerializer serializer, RemovableFileOutputStream diskCacheOutputStream, DoneListener doneListener) {
		this.serializer = serializer;
		this.diskCacheOutputStream = diskCacheOutputStream;
		this.doneListener = doneListener;
	}
	
	public void writeToOutputStream(OutputStream outputStream, ProgressReporter progressReporter) throws Exception {
		MultiplexingOutputStream multiplexer = null;
		boolean closed = false;
		try {
			multiplexer = new MultiplexingOutputStream(outputStream, diskCacheOutputStream);
			serializer.writeToOutputStream(multiplexer);
			doneListener.done();
		} catch (Exception e) {
			if (multiplexer != null) {
				RemovableFileOutputStream diskCache = (RemovableFileOutputStream) multiplexer.getB();
				multiplexer.getA().close();
				diskCache.cancel();
			}
			closed = true;
			throw e;
		} finally {
			if (!closed && multiplexer != null) {
				multiplexer.close();
			}
		}
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return null;
	}
}