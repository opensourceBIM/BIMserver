package org.bimserver.shared;

import java.nio.file.Path;

import org.bimserver.plugins.ResourceFetcher;

public class LocalDevelopmentResourceFetcher extends ResourceFetcher {

	public LocalDevelopmentResourceFetcher(Path workspaceDir) {
//		addPath(workspaceDir.resolve("Builds/defaultsettings/local"));
//		addPath(workspaceDir.resolve("Builds/defaultsettings/shared"));
//		addPath(workspaceDir.resolve("Builds/build/targets/local"));
//		addPath(workspaceDir.resolve("Builds/build/targets/shared"));
		addPath(workspaceDir.resolve("BimServer"));
		addPath(workspaceDir.resolve("BimServerClientLib/src/org/bimserver/client/protocolbuffers"));
	}

//	@Override
//	public Path getFile(String name) throws IOException {
//		if (name.startsWith("lib")) {
//			for (Path projectFile : PathUtils.list(Paths.get(".."))) {
//				Path file = projectFile.resolve(name);
//				if (Files.exists(file)) {
//					return file;
//				}
//			}
//		}
//		return super.getFile(name);
//	}
}