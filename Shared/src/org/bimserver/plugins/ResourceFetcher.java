package org.bimserver.plugins;

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
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ResourceFetcher {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceFetcher.class);
	private final Set<Path> paths = new LinkedHashSet<>();	
	
	public void addPath(Path path) {
		paths.add(path);
	}
	
	public byte[] getData(String key) throws IOException {
		Path path = getPath(key);
		if (path != null) {
			try {
				if (Files.exists(path)) {
					return FileUtils.readFileToByteArray(path.toFile());
				}
			} catch (MalformedURLException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}

	public Set<String> listKeys(String key) {
		Path path = getPath(key);
		Set<String> result = new HashSet<>();
		if (path != null) {
			try {
				for (Path path2 : Files.newDirectoryStream(path)) {
					result.add(path2.getFileName().toString());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public boolean isDirectory(String key) {
		Path path = getPath(key);
		if (path != null) {
			return Files.isDirectory(path);
		}
		return false;
	}
	
	protected Path getPath(String key) {
		for (Path path : paths) {
			Path resolved = path.resolve(key);
			if (Files.exists(resolved)) {
				return resolved;
			}
		}
		return null;
	}

	public URL getURL(String key) throws MalformedURLException {
		URL url = getPath(key).toUri().toURL();
//		LOGGER.info("getURL, " + key + ", " + url.toExternalForm());
		return url;
	}

//	public Path getFile(String name) throws IOException {
//		for (Path path : paths) {
//			Path file = path.resolve(name);
//			if (Files.exists(file)) {
//				return file;
//			}			
//		}
//		return null;
//	}

//	public List<Path> getFiles(String name) {
//		List<Path> result = new ArrayList<>();
//		for (Path path : paths) {
//			Path file = path.resolve(name);
//			if (Files.exists(file)) {
//				result.add(file);
//			}			
//		}
//		return result;
//	}
}