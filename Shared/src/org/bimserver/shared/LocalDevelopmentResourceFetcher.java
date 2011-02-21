package org.bimserver.shared;

import java.io.File;

public class LocalDevelopmentResourceFetcher extends ResourceFetcher {

	public LocalDevelopmentResourceFetcher() {
		addPath(new File("../BimServer/home"));
		addPath(new File("../BimServer/defaultsettings/" + "shared"));
		addPath(new File("../BimServer/build/targets/" + "local"));
		addPath(new File("../BimServer/build/targets/" + "shared"));
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