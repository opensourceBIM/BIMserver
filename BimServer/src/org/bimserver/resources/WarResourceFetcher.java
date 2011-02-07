package org.bimserver.resources;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContext;

import org.bimserver.shared.ResourceFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WarResourceFetcher extends ResourceFetcher {

	private final ServletContext servletContext;
	private static final Logger LOGGER = LoggerFactory.getLogger(WarResourceFetcher.class);

	public WarResourceFetcher(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Override
	public URL getResource(String name) {
		File file = getFile(name);
		if (file != null && file.exists()) {
			try {
				return file.getAbsoluteFile().toURI().toURL();
			} catch (MalformedURLException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}

	@Override
	public File getFile(String name) {
		return new File(servletContext.getRealPath("/") + "WEB-INF" + File.separator + name);
	}
}