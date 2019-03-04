package org.bimserver.emf;

import java.io.InputStream;

import org.apache.commons.lang3.NotImplementedException;

public class SharedJsonStreamingDeserializer {

	private PackageMetaData packageMetaData;

	public SharedJsonStreamingDeserializer(PackageMetaData packageMetaData) {
		this.packageMetaData = packageMetaData;
	}

	public long read(InputStream inputStream) {
		throw new NotImplementedException("Streaming json deserializer not implemented");
	}
}
