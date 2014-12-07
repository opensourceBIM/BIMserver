package org.bimserver.longaction;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import org.bimserver.cache.DiskCacheManager;

public class CachingDataHandler extends DataHandler {

	private DownloadParameters downloadParameters;
	private DiskCacheManager diskCacheManager;
	private DataSource dataSource;

	public CachingDataHandler(DiskCacheManager diskCacheManager, DownloadParameters downloadParameters) {
		super((DataSource)null);
		this.diskCacheManager = diskCacheManager;
		this.downloadParameters = downloadParameters;
	}
	
	@Override
	public DataSource getDataSource() {
		if (dataSource == null) {
			dataSource = diskCacheManager.get(downloadParameters);
		}
		return dataSource;
	}
}
