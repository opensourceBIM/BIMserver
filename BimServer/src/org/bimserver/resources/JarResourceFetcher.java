package org.bimserver.resources;

import java.io.File;

import org.bimserver.plugins.ResourceFetcher;

public class JarResourceFetcher extends ResourceFetcher {
	
	public JarResourceFetcher() {
		addPath(new File("home"));
		addPath(new File("config"));
	}
	
	@Override
	public File getFile(String name) {
		if (name.startsWith("lib")) {
			File file = new File(name);
			if (file.exists()) {
				return file;
			}
		}
		return super.getFile(name);
	}
}