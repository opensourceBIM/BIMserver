package org.bimserver.plugins;

import java.nio.file.Path;

public class Dependency {

	private Path jarFile;

	public Dependency(Path jarFile) {
		this.jarFile = jarFile;
	}

	public Path getPath() {
		return jarFile;
	}
}
