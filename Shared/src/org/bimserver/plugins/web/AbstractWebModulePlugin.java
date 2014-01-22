package org.bimserver.plugins.web;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PrimitiveDefinition;
import org.bimserver.models.store.PrimitiveEnum;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StringType;
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
			if (path.startsWith(getDefaultContextPath())) {
				path = path.substring(getDefaultContextPath().length());
			}
			if (path == null || path.equals("")) {
				response.sendRedirect(request.getContextPath() + getDefaultContextPath() + "/");
			} else if (path.equals("/")) {
				path = "index.html";
			}
			if (path.startsWith("/")) {
				path = path.substring(1);
			}
			InputStream resourceAsInputStream = pluginContext.getResourceAsInputStream(getSubDir() + path);
			if (resourceAsInputStream != null) {
				IOUtils.copy(resourceAsInputStream, response.getOutputStream());
				return true;
			} else {
				return false;
			}
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			// Skip those, they make the log file look like there are many things wrong, probably just a browser disconnect
		}
		return false;
	}

	public String getSubDir() {
		return "";
	}
	
	/**
	 * @return The context path on which to serve this webmodule
	 */
	public abstract String getDefaultContextPath();

	@Override
	public ObjectDefinition getSettingsDefinition() {
		ObjectDefinition objectDefinition = StoreFactory.eINSTANCE.createObjectDefinition();

		PrimitiveDefinition stringDefinition = StoreFactory.eINSTANCE.createPrimitiveDefinition();
		stringDefinition.setType(PrimitiveEnum.STRING);
		
		ParameterDefinition contextPathParameter = StoreFactory.eINSTANCE.createParameterDefinition();
		contextPathParameter.setName("contextPath");
		contextPathParameter.setDescription("Context Path to run this Web Module on");
		StringType defaultValue = StoreFactory.eINSTANCE.createStringType();
		defaultValue.setValue(getDefaultContextPath());
		contextPathParameter.setDefaultValue(defaultValue);
		contextPathParameter.setType(stringDefinition);
		objectDefinition.getParameters().add(contextPathParameter);
		
		return objectDefinition;
	}
	
	public PluginContext getPluginContext() {
		return pluginContext;
	}
}