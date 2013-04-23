package org.bimserver.plugins.web;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractWebModulePlugin implements WebModulePlugin {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractWebModulePlugin.class);
	private PluginContext pluginContext;
	
	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		pluginContext = pluginManager.getPluginContext(this);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getPathInfo();
			path = path.substring(getContextPath().length());
			if (path == null || path.equals("")) {
				response.sendRedirect(getContextPath() + "/");
			} else if (path.equals("/")) {
				path = "index.html";
			}
			if (path.startsWith("/")) {
				path = path.substring(1);
			}
			if (path.endsWith(".js")) {
				response.setContentType("application/javascript");
			} else if (path.endsWith(".css")) {
				response.setContentType("text/css");
			} else if (path.endsWith(".png")) {
				response.setContentType("image/png");
			} else if (path.endsWith(".gif")) {
				response.setContentType("image/gif");
			}
			InputStream resourceAsInputStream = pluginContext.getResourceAsInputStream(path);
			if (resourceAsInputStream != null) {
				IOUtils.copy(resourceAsInputStream, response.getOutputStream());
			} else {
				LOGGER.error(path + " not found");
			}
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public PluginContext getPluginContext() {
		return pluginContext;
	}
}
