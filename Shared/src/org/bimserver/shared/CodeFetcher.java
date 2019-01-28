package org.bimserver.shared;

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
				if (inputStream == null) {
					return null;
				}
				try {
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