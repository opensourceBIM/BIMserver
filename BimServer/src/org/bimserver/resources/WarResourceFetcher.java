package org.bimserver.resources;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.bimserver.plugins.ResourceFetcher;

public class WarResourceFetcher extends ResourceFetcher {

	public WarResourceFetcher(ServletContext servletContext, Path homeDir) {
		if (homeDir != null) {
			addPath(homeDir);
		}
		String realPath = servletContext.getRealPath("/");
		if (!realPath.endsWith("/")) {
			realPath = realPath + "/";
		}
		addPath(Paths.get(realPath + "WEB-INF"));
	}
}