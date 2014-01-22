package org.bimserver.plugins;

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

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ResourceFetcher {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceFetcher.class);
	private final Set<File> paths = new LinkedHashSet<File>();	
	
	public void addPath(File path) {
		paths.add(path);
	}
	
	public URL getResource(String name) {
		File file = getFile(name);
		if (file != null && file.exists()) {
			try {
				return file.getAbsoluteFile().toURI().toURL();
			} catch (MalformedURLException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}

	public File getFile(String name) {
		for (File path : paths) {
			File file = new File(path, name);
			if (file.exists()) {
				return file;
			}			
		}
		return null;
	}
}