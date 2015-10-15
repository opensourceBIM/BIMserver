package org.bimserver.resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.plugins.ResourceFetcher;

public class JarResourceFetcher extends ResourceFetcher {
	
	public JarResourceFetcher() {
		addPath(Paths.get("home"));
		addPath(Paths.get("config"));
	}
	
	@Override
	public Path getFile(String name) throws IOException {
		if (name.startsWith("lib")) {
			Path file = Paths.get(name);
			if (Files.exists(file)) {
				return file;
			}
		}
		return super.getFile(name);
	}
}