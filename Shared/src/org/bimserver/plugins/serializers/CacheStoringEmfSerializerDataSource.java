package org.bimserver.plugins.serializers;

import java.io.OutputStream;

import org.bimserver.utils.MultiplexingOutputStream;

public class CacheStoringEmfSerializerDataSource extends EmfSerializerDataSource {

	private OutputStream diskCacheOutputStream;

	public CacheStoringEmfSerializerDataSource(Serializer serializer, OutputStream diskCacheOutputStream) {
		super(serializer);
		this.diskCacheOutputStream = diskCacheOutputStream;
	}
	
	@Override
	public void writeToOutputStream(OutputStream outputStream) throws SerializerException {
		super.writeToOutputStream(new MultiplexingOutputStream(outputStream, diskCacheOutputStream));
	}
}