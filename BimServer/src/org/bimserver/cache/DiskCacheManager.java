package org.bimserver.cache;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import org.bimserver.SettingsManager;
import org.bimserver.ifc.EmfSerializerDataSource;
import org.bimserver.longaction.DownloadParameters;
import org.bimserver.plugins.serializers.SerializerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiskCacheManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(DiskCacheManager.class);
	private final File cacheDir;
	private final SettingsManager settingsManager;

	public DiskCacheManager(File cacheDir, SettingsManager settingsManager) {
		this.cacheDir = cacheDir;
		this.settingsManager = settingsManager;
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
		return settingsManager.getSettings().isCacheOutputFiles();
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