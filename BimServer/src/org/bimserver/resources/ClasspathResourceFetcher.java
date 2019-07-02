package org.bimserver.resources;

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

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.bimserver.plugins.ResourceFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.ByteStreams;

public class ClasspathResourceFetcher extends ResourceFetcher {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClasspathResourceFetcher.class);
	
	public ClasspathResourceFetcher() {
		
	}

	@Override
	public boolean isDirectory(String key) {
		try {
			return getURL(key) != null;
		} catch (MalformedURLException e) {
			LOGGER.error("", e);
		}
		return false;
	}
	
	@Override
	public Set<String> listKeys(String key) {
		return super.listKeys(key);
	}
	
	@Override
	public URL getURL(String key) throws MalformedURLException {
		return getClass().getClassLoader().getResource(key);
	}
	
	@Override
	public byte[] getData(String key) throws IOException {
		LOGGER.info(key + " " + getClass().getClassLoader());
		LOGGER.info("Count: " + getClass().getClassLoader().getResources(key));
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(key)) {
			if (inputStream != null) {
				return ByteStreams.toByteArray(inputStream);
			}
		}
		return super.getData(key);
	}
}
