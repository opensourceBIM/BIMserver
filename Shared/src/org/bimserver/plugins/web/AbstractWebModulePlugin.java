package org.bimserver.plugins.web;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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
	public boolean service(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getPathInfo();
			if (path.startsWith(getContextPath())) {
				path = path.substring(getContextPath().length());
			}
			if (path == null || path.equals("")) {
				response.sendRedirect(getContextPath() + "/");
			} else if (path.equals("/")) {
				path = "index.html";
			}
			if (path.startsWith("/")) {
				path = path.substring(1);
			}
			InputStream resourceAsInputStream = pluginContext.getResourceAsInputStream(path);
			if (resourceAsInputStream != null) {
				IOUtils.copy(resourceAsInputStream, response.getOutputStream());
				return true;
			} else {
				return false;
			}
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return false;
	}
	
	public PluginContext getPluginContext() {
		return pluginContext;
	}
}