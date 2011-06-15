package org.bimserver.resources;

import java.io.File;

import javax.servlet.ServletContext;

import org.bimserver.plugins.ResourceFetcher;

public class WarResourceFetcher extends ResourceFetcher {

	public WarResourceFetcher(ServletContext servletContext, File homeDir) {
		if (homeDir != null) {
			addPath(homeDir);
		}
		addPath(new File(servletContext.getRealPath("/") + "WEB-INF"));
	}
}