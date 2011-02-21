package org.bimserver.resources;

import java.io.File;

import javax.servlet.ServletContext;

import org.bimserver.shared.ResourceFetcher;

public class WarResourceFetcher extends ResourceFetcher {

	public WarResourceFetcher(ServletContext servletContext) {
		addPath(new File(servletContext.getRealPath("/") + "WEB-INF"));
	}
}