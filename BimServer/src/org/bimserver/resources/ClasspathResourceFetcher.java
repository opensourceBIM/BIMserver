package org.bimserver.resources;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
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
		try {
			return getURL(key) != null;
		} catch (MalformedURLException e) {
			LOGGER.error("", e);
		}
		return false;
	}
	
	@Override
	public Set<String> listKeys(String key) {
		return super.listKeys(key);
	}
	
	@Override
	public URL getURL(String key) throws MalformedURLException {
		return getClass().getClassLoader().getResource(key);
	}
	
	@Override
	public byte[] getData(String key) throws IOException {
		LOGGER.info(key + " " + getClass().getClassLoader());
		LOGGER.info("Count: " + getClass().getClassLoader().getResources(key));
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(key)) {
			if (inputStream != null) {
				return ByteStreams.toByteArray(inputStream);
			}
		}
		return super.getData(key);
	}
}
