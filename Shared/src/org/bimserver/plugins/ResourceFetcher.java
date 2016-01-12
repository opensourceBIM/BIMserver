package org.bimserver.plugins;

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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ResourceFetcher {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceFetcher.class);
	private final Set<Path> paths = new LinkedHashSet<>();	
	
	public void addPath(Path path) {
		paths.add(path);
	}
	
	public URL getResource(String name) throws IOException {
		Path file = getFile(name);
		if (file != null && Files.exists(file)) {
			try {
				return file.toUri().toURL();
			} catch (MalformedURLException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}

	public Path getFile(String name) throws IOException {
		for (Path path : paths) {
			Path file = path.resolve(name);
			if (Files.exists(file)) {
				return file;
			}			
		}
		return null;
	}

	public List<Path> getFiles(String name) {
		List<Path> result = new ArrayList<>();
		for (Path path : paths) {
			Path file = path.resolve(name);
			if (Files.exists(file)) {
				result.add(file);
			}			
		}
		return result;
	}
}