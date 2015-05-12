package org.bimserver.plugins.web;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

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
import org.bimserver.plugins.PluginSourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public abstract class AbstractWebModulePlugin implements WebModulePlugin {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractWebModulePlugin.class);
	private PluginContext pluginContext;
	private static final DateFormat HTTP_EXPIRES = expiresDateFormat();
	public static final String FAR_FUTURE_EXPIRE_DATE = HTTP_EXPIRES.format(makeExpiresDate());

	public static DateFormat expiresDateFormat() {
		DateFormat httpDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
		httpDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		return httpDateFormat;
	}
	
	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		pluginContext = pluginManager.getPluginContext(this);
	}
	
	private static Date makeExpiresDate() {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.add(Calendar.DAY_OF_YEAR, 120);
		return gregorianCalendar.getTime();
	}
	
	@Override
	public boolean service(String requestUri, HttpServletResponse response) {
		try {
			if (requestUri.startsWith(getDefaultContextPath())) {
				requestUri = requestUri.substring(getDefaultContextPath().length());
			}
			while (requestUri.startsWith("/")) {
				requestUri = requestUri.substring(1);
			}
			if (requestUri.equals("")) {
				requestUri = "index.html";
			}
			if (requestUri.endsWith("plugin.version")) {
				if (getPluginContext().getPluginType() == PluginSourceType.INTERNAL) {
					// Probably the default plugin
					return false;
				} else if (getPluginContext().getPluginType() == PluginSourceType.ECLIPSE_PROJECT) {
					// We don't want to cache in Eclipse, because we change files without changing the plugin version everytime
					response.getOutputStream().write(("{\"version\":\"" + getIdentifier() + "-" + System.nanoTime() + "\"}").getBytes(Charsets.UTF_8));
					return true;
				} else if (getPluginContext().getPluginType() == PluginSourceType.JAR_FILE) {
					response.getOutputStream().write(("{\"version\":\"" + getIdentifier() + "-" + getVersion() + "\"}").getBytes(Charsets.UTF_8));
					return true;
				}
			}
			if (!requestUri.equals("index.html")) {
				response.setHeader("Expires", FAR_FUTURE_EXPIRE_DATE);
			}
			InputStream resourceAsInputStream = pluginContext.getResourceAsInputStream(getSubDir() + requestUri);
//			LOGGER.info("Getting " + getSubDir() + path + " results in: " + resourceAsInputStream);
			if (resourceAsInputStream != null) {
				IOUtils.copy(resourceAsInputStream, response.getOutputStream());
				resourceAsInputStream.close();
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
	 * @return An identifier for this specific WebModule that will be used in the version-string that can be used for caching purposes
	 */
	public abstract String getIdentifier();
	
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