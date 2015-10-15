package org.bimserver.plugins;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ResourceFetcher {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceFetcher.class);
	private final Set<Path> paths = new LinkedHashSet<>();	
	
	public void addPath(Path path) {
		paths.add(path);
	}
	
	public URL getResource(String name) throws IOException {
		Path file = getFile(name);
		if (file != null && Files.exists(file)) {
			try {
				return file.toUri().toURL();
			} catch (MalformedURLException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}

	public Path getFile(String name) throws IOException {
		for (Path path : paths) {
			Path file = path.resolve(name);
			if (Files.exists(file)) {
				return file;
			}			
		}
		return null;
	}

	public List<Path> getFiles(String name) {
		List<Path> result = new ArrayList<>();
		for (Path path : paths) {
			Path file = path.resolve(name);
			if (Files.exists(file)) {
				result.add(file);
			}			
		}
		return result;
	}
}