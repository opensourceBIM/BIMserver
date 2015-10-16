package org.bimserver.shared;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.utils.PathUtils;

public class LocalDevelopmentResourceFetcher extends ResourceFetcher {

	public LocalDevelopmentResourceFetcher(Path workspaceDir) {
		addPath(workspaceDir.resolve("Builds/defaultsettings/local"));
		addPath(workspaceDir.resolve("Builds/defaultsettings/shared"));
		addPath(workspaceDir.resolve("Builds/build/targets/local"));
		addPath(workspaceDir.resolve("Builds/build/targets/shared"));
		addPath(workspaceDir.resolve("BimServerClientLib/src/org/bimserver/client/protocolbuffers"));
	}

	@Override
	public Path getFile(String name) throws IOException {
		if (name.startsWith("lib")) {
			for (Path projectFile : PathUtils.list(Paths.get(".."))) {
				Path file = projectFile.resolve(name);
				if (Files.exists(file)) {
					return file;
				}
			}
		}
		return super.getFile(name);
	}
}