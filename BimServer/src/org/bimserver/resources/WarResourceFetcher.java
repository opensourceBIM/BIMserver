package org.bimserver.resources;

import java.io.File;

import javax.servlet.ServletContext;

import org.bimserver.shared.ResourceFetcher;

public class WarResourceFetcher extends ResourceFetcher {

	public WarResourceFetcher(ServletContext servletContext, String homeDir) {
		if (homeDir != null) {
			addPath(new File(homeDir));
		}
		addPath(new File(servletContext.getRealPath("/") + "WEB-INF"));
	}
}