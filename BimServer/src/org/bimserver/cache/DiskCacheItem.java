package org.bimserver.cache;

public interface DiskCacheItem {

	void waitForFinish() throws InterruptedException;
	DownloadDescriptor getDownloadDescriptor();
}
