package org.bimserver.shared;

import java.io.File;

import org.bimserver.plugins.ResourceFetcher;

public class LocalDevelopmentResourceFetcher extends ResourceFetcher {

	public LocalDevelopmentResourceFetcher() {
		addPath(new File("../Builds/defaultsettings/" + "local"));
		addPath(new File("../Builds/defaultsettings/" + "shared"));
		addPath(new File("../Builds/build/targets/" + "local"));
		addPath(new File("../Builds/build/targets/" + "shared"));
	}

	@Override
	public File getFile(String name) {
		if (name.startsWith("lib")) {
			for (File projectFile : new File("..").listFiles()) {
				File file = new File(projectFile, name);
				if (file.exists()) {
					return file;
				}
			}
		}
		return super.getFile(name);
	}
}