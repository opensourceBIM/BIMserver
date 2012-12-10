package org.bimserver.cache;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.activation.DataSource;

import org.bimserver.BimServer;
import org.bimserver.longaction.DownloadParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiskCacheManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(DiskCacheManager.class);
	private final File cacheDir;
	private final BimServer bimServer;
	private final Set<String> cachedFileNames = new HashSet<String>();
	private final Map<DownloadParameters, DiskCacheOutputStream> busyCaching = new HashMap<DownloadParameters, DiskCacheOutputStream>();

	public DiskCacheManager(BimServer bimServer, File cacheDir) {
		this.bimServer = bimServer;
		this.cacheDir = cacheDir;
		if (!cacheDir.exists()) {
			cacheDir.mkdir();
		}
		for (File file : this.cacheDir.listFiles()) {
			cachedFileNames.add(file.getName());
		}
	}
	
	public boolean contains(DownloadParameters downloadParameters) {
		if (isEnabled()) {
			synchronized (busyCaching) {
				if (busyCaching.containsKey(downloadParameters)) {
					return true;
				}
			}
			synchronized (cachedFileNames) {
				return cachedFileNames.contains(downloadParameters.getId());
			}
		} else {
			return false;
		}
	}
	
	public boolean isEnabled() {
		return bimServer.getServerSettingsCache().getServerSettings().getCacheOutputFiles();
	}

	public DataSource get(DownloadParameters downloadParameters) {
		if (isEnabled()) {
			DiskCacheOutputStream diskCacheOutputStream = null;
			synchronized (busyCaching) {
				diskCacheOutputStream = busyCaching.get(downloadParameters);
			}
			if (diskCacheOutputStream != null) {
				try {
					diskCacheOutputStream.waitForFinish();
				} catch (InterruptedException e) {
					LOGGER.error("", e);
				}
			}
			FileInputStreamDataSource fileInputStreamDataSource = new FileInputStreamDataSource(new File(cacheDir, downloadParameters.getId()));
			fileInputStreamDataSource.setName(downloadParameters.getFileName());
			return fileInputStreamDataSource;
		}
		return null;
	}

	public OutputStream startCaching(DownloadParameters downloadParameters) {
		try {
			DiskCacheOutputStream out = new DiskCacheOutputStream(this, new File(cacheDir, downloadParameters.getId()));
			synchronized (busyCaching) {
				busyCaching.put(downloadParameters, out);
			}
			return new BufferedOutputStream(out);
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	public synchronized Integer cleanup() {
		int removed = 0;
		for (File file : cacheDir.listFiles()) {
			if (file.delete()) {
				removed++;
			}
		}
		cachedFileNames.clear();
		return removed;
	}

	public void doneGenerating(DiskCacheOutputStream diskCacheOutputStream) {
		synchronized (busyCaching) {
			busyCaching.remove(diskCacheOutputStream.getName());
			cachedFileNames.add(diskCacheOutputStream.getName());
		}
	}
}