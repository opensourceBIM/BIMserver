package org.bimserver.cache;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
import java.io.FileOutputStream;
import java.io.IOException;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import org.bimserver.BimServer;
import org.bimserver.database.DatabaseSession;
import org.bimserver.longaction.DownloadParameters;
import org.bimserver.plugins.serializers.EmfSerializerDataSource;
import org.bimserver.plugins.serializers.SerializerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiskCacheManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(DiskCacheManager.class);
	private final File cacheDir;
	private final BimServer bimServer;

	public DiskCacheManager(BimServer bimServer, File cacheDir) {
		this.bimServer = bimServer;
		this.cacheDir = cacheDir;
		if (!cacheDir.exists()) {
			cacheDir.mkdir();
		}
	}
	
	public boolean contains(DownloadParameters downloadParameters) {
		if (isEnabled()) {
			File cachefile = new File(cacheDir, downloadParameters.getId());
			return cachefile.exists();
		} else {
			return false;
		}
	}
	
	private boolean isEnabled() {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			return bimServer.getServerSettings(session).getCacheOutputFiles();
		} finally {
			session.close();
		}
	}

	public void store(DownloadParameters downloadParameters, DataHandler dataHandler) {
		if (isEnabled()) {
			try {
				EmfSerializerDataSource emfSerializerDataSource = (EmfSerializerDataSource)dataHandler.getDataSource();
				FileOutputStream fileOutputStream = new FileOutputStream(new File(cacheDir, downloadParameters.getId()));
				emfSerializerDataSource.getSerializer().writeToOutputStream(fileOutputStream);
				fileOutputStream.close();
			} catch (IOException e) {
				LOGGER.error("", e);
			} catch (SerializerException e) {
				LOGGER.error("", e);
			}
		}
	}

	public DataSource get(DownloadParameters downloadParameters) {
		if (isEnabled()) {
			FileInputStreamDataSource fileInputStreamDataSource = new FileInputStreamDataSource(new File(cacheDir, downloadParameters.getId()));
			fileInputStreamDataSource.setName(downloadParameters.getFileName());
			return fileInputStreamDataSource;
		}
		return null;
	}
}