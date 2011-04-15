package org.bimserver.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import org.bimserver.ifc.EmfSerializer;
import org.bimserver.ifc.SerializerException;
import org.bimserver.longaction.DownloadParameters;
import org.bimserver.utils.InputStreamDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiskCacheManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(DiskCacheManager.class);
	private boolean enabled = false;
	private final File cacheDir;

	public DiskCacheManager(File cacheDir) {
		this.cacheDir = cacheDir;
		if (!cacheDir.exists()) {
			cacheDir.mkdir();
		}
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public boolean contains(DownloadParameters downloadParameters) {
		if (enabled) {
			File cachefile = new File(cacheDir, downloadParameters.getId());
			return cachefile.exists();
		} else {
			return false;
		}
	}
	
	public void store(DownloadParameters downloadParameters, DataHandler dataHandler) {
		if (enabled) {
			try {
				EmfSerializer emfSerializer = (EmfSerializer)dataHandler.getDataSource();
				FileOutputStream fileOutputStream = new FileOutputStream(new File(cacheDir, downloadParameters.getId()));
				emfSerializer.writeToOutputStream(fileOutputStream);
				fileOutputStream.close();
			} catch (IOException e) {
				LOGGER.error("", e);
			} catch (SerializerException e) {
				LOGGER.error("", e);
			}
		}
	}

	public DataSource get(DownloadParameters downloadParameters) {
		if (enabled) {
			try {
				return new InputStreamDataSource(new FileInputStream(new File(cacheDir, downloadParameters.getId())));
			} catch (FileNotFoundException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}
}