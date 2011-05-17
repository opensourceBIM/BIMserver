package org.bimserver.ifc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;

import org.bimserver.plugins.serializers.EmfSerializer;

public class EmfSerializerDataSource implements DataSource {

	private final EmfSerializer serializer;

	public EmfSerializerDataSource(EmfSerializer serializer) {
		this.serializer = serializer;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return serializer.getInputStream();
	}

	@Override
	public String getName() {
		return serializer.getModel().getName();
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return null;
	}

	public EmfSerializer getSerializer() {
		return serializer;
	}
}