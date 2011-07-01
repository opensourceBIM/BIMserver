package org.bimserver.templating;

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
		LOGGER.info("Using \"" + StringUtils.getPrettyFileUrl(resource) + "\" as template dir");
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