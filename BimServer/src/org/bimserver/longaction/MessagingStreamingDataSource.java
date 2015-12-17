package org.bimserver.longaction;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bimserver.plugins.serializers.ExtendedDataSource;
import org.bimserver.plugins.serializers.MessagingStreamingSerializer;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.SerializerException;

public class MessagingStreamingDataSource extends ExtendedDataSource {

	private MessagingStreamingSerializer messagingStreamingSerializer;

	public MessagingStreamingDataSource(MessagingStreamingSerializer messagingStreamingSerializer) {
		this.messagingStreamingSerializer = messagingStreamingSerializer;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new MessagingSerializerInputstream(messagingStreamingSerializer);
	}
	
	@Override
	public String getName() {
		return null;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return null;
	}

	public void writeToOutputStream(OutputStream outputStream, ProgressReporter progressReporter) throws IOException, SerializerException {
		while(messagingStreamingSerializer.writeMessage(outputStream, null)) {
		}
	}
}