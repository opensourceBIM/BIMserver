package org.bimserver.cache;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.activation.DataSource;

import org.bimserver.BimServer;
import org.bimserver.longaction.DownloadParameters;
import org.bimserver.utils.PathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiskCacheManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(DiskCacheManager.class);
	private final Path cacheDir;
	private final BimServer bimServer;
	private final Set<String> cachedFileNames = new HashSet<String>();
	private final Map<DownloadParameters, DiskCacheOutputStream> busyCaching = new HashMap<DownloadParameters, DiskCacheOutputStream>();

	public DiskCacheManager(BimServer bimServer, Path cacheDir) {
		this.bimServer = bimServer;
		this.cacheDir = cacheDir;
		try {
			if (!Files.exists(cacheDir)) {
					Files.createDirectory(cacheDir);
			}
			for (Path file : PathUtils.getDirectories(this.cacheDir)) {
				if (file.getFileName().toString().endsWith(".__tmp")) {
					Files.delete(file);
				} else {
					cachedFileNames.add(file.getFileName().toString());
				}
			}
		} catch (IOException e) {
			LOGGER.error("", e);
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
					LOGGER.info("Waiting for " + downloadParameters.getFileName());
					diskCacheOutputStream.waitForFinish();
				} catch (InterruptedException e) {
					LOGGER.error("", e);
				}
			}
			Path file = cacheDir.resolve(downloadParameters.getId());
			if (!Files.exists(file)) {
				LOGGER.error("File " + file.getFileName().toString() + " not found in cache");
			} else {
				LOGGER.info("Reading from cache " + downloadParameters.getFileName());
				FileInputStreamDataSource fileInputStreamDataSource = new FileInputStreamDataSource(file);
				fileInputStreamDataSource.setName(downloadParameters.getFileNameWithoutExtension());
				return fileInputStreamDataSource;
			}
		}
		return null;
	}

	public DiskCacheOutputStream startCaching(DownloadParameters downloadParameters) {
		try {
			LOGGER.info("Start caching " + downloadParameters.getFileName());
			DiskCacheOutputStream out = new DiskCacheOutputStream(this, cacheDir.resolve(downloadParameters.getId()), downloadParameters);
			synchronized (busyCaching) {
				busyCaching.put(downloadParameters, out);
			}
			return out;
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	public synchronized Integer cleanup() {
		int removed = 0;
		try {
			for (Path file : PathUtils.getDirectories(cacheDir)) {
				try {
					Files.delete(file);
					removed++;
				} catch (IOException e) {
					LOGGER.error("", e);
				}
			}
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		cachedFileNames.clear();
		return removed;
	}

	public void doneGenerating(DiskCacheOutputStream diskCacheOutputStream) {
		synchronized (busyCaching) {
			LOGGER.info("Done caching " + diskCacheOutputStream.getDownloadParameters().getFileName());
			busyCaching.remove(diskCacheOutputStream.getDownloadParameters());
			cachedFileNames.add(diskCacheOutputStream.getDownloadParameters().getId());
		}
	}

	public void remove(DiskCacheOutputStream diskCacheOutputStream) {
		LOGGER.info("Removing cache " + diskCacheOutputStream.getDownloadParameters().getFileName());
		cachedFileNames.remove(diskCacheOutputStream.getDownloadParameters().getId());
		synchronized (busyCaching) {
			busyCaching.remove(diskCacheOutputStream.getDownloadParameters());
		}
	}
}