package org.bimserver.resources;

import java.nio.file.Path;

import org.bimserver.plugins.ResourceFetcher;

public class JarResourceFetcher extends ResourceFetcher {
	
	public JarResourceFetcher(Path...paths) {
		for (Path path : paths) {
			addPath(path);
		}
	}
//	
//	@Override
//	public Path getFile(String name) throws IOException {
//		if (name.startsWith("lib")) {
//			Path file = Paths.get(name);
//			if (Files.exists(file)) {
//				return file;
//			}
//		}
//		return super.getFile(name);
//	}
}