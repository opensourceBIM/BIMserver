package org.bimserver.templating;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.URLResourceLoader;
import org.bimserver.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemplateEngine {

	private static final Logger LOGGER = LoggerFactory.getLogger(TemplateEngine.class);
	private VelocityEngine velocityEngine;

	public TemplateEngine() {
	}

	public String process(Map<String, Object> context, TemplateIdentifier templateIdentifier) {
		StringWriter stringWriter = new StringWriter();
		VelocityContext velocityContext = new VelocityContext(context);
		try {
			velocityEngine.mergeTemplate(templateIdentifier.getFileName(), "UTF-8", velocityContext, stringWriter);
			return stringWriter.toString();
		} catch (ResourceNotFoundException e) {
			LOGGER.error("", e);
		} catch (ParseErrorException e) {
			LOGGER.error("", e);
		} catch (MethodInvocationException e) {
			LOGGER.error("", e);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return "";
	}

	public void init(URL resource) {
		LOGGER.debug("Using \"" + StringUtils.getPrettyFileUrl(resource) + "\" as template dir");
		velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(VelocityEngine.RESOURCE_LOADER, "url");
		velocityEngine.setProperty("url.resource.loader.class", URLResourceLoader.class.getName());
		velocityEngine.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute");
		velocityEngine.setProperty("runtime.log.logsystem.log4j.logger", "velocity");
		try {
			velocityEngine.setProperty("url.resource.loader.root", URLDecoder.decode(resource.toString(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("", e);
		}
		try {
			velocityEngine.init();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
}