package org.bimserver.plugins;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ResourceFetcher {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceFetcher.class);
	private final Set<File> paths = new LinkedHashSet<File>();	
	
	public void addPath(File path) {
		paths.add(path);
	}
	
	public URL getResource(String name) {
		File file = getFile(name);
		if (file != null && file.exists()) {
			try {
				return file.getAbsoluteFile().toURI().toURL();
			} catch (MalformedURLException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}

	public File getFile(String name) {
		for (File path : paths) {
			File file = new File(path, name);
			if (file.exists()) {
				return file;
			}			
		}
		return null;
	}
}