package org.bimserver.resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.bimserver.plugins.ResourceFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.ByteStreams;

public class ClasspathResourceFetcher extends ResourceFetcher {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClasspathResourceFetcher.class);
	public ClasspathResourceFetcher() {
		
	}

	@Override
	public boolean isDirectory(String key) {
		return true;
	}
	
	@Override
	public Set<String> listKeys(String key) {
		return super.listKeys(key);
	}
	
	@Override
	public byte[] getData(String key) throws IOException {
		if (!key.startsWith("/")) {
			key = "/" + key;
		}
		LOGGER.info(key + " " + getClass().getClassLoader());
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(key)) {
			if (inputStream != null) {
				return ByteStreams.toByteArray(inputStream);
			}
		}
		return super.getData(key);
	}
}
