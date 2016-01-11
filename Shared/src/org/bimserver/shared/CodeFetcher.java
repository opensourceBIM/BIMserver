package org.bimserver.shared;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.bimserver.shared.meta.SourceCodeFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class CodeFetcher implements SourceCodeFetcher {
	private static final Logger LOGGER = LoggerFactory.getLogger(CodeFetcher.class);
	
	@Override
	public String get(Class<?> clazz) {
		URL url = clazz.getResource(clazz.getSimpleName() + ".java");
		if (url == null) {
			try {
				url = new File("../PluginBase/src/" + clazz.getName().replace(".", "/") + ".java").toURI().toURL();
			} catch (MalformedURLException e) {
				LOGGER.error("", e);				}
		}
		if (url != null) {
			try {
				InputStream inputStream = url.openStream();
				try {
					if (inputStream == null) {
						return null;
					}
					StringWriter out = new StringWriter();
					IOUtils.copy(inputStream, out);
					return out.toString();
				} finally {
					inputStream.close();
				}
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}
}