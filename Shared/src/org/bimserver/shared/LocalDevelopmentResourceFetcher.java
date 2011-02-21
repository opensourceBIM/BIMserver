package org.bimserver.shared;

import java.io.File;

public class LocalDevelopmentResourceFetcher extends ResourceFetcher {

	public LocalDevelopmentResourceFetcher() {
		addPath(new File("../BimServer/defaultsettings" + File.separator + "local"));
		addPath(new File("../BimServer/defaultsettings" + File.separator + "shared"));
		addPath(new File("../BimServer/deploy" + File.separator + "local"));
		addPath(new File("../BimServer/deploy" + File.separator + "shared"));
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