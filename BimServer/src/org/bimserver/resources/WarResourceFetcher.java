package org.bimserver.resources;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContext;

import org.bimserver.shared.ResourceFetcher;

public class WarResourceFetcher extends ResourceFetcher {

	private final ServletContext servletContext;

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
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public File getFile(String name) {
		return new File(servletContext.getRealPath("/") + "WEB-INF" + File.separator + name);
	}
}