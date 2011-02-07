package org.bimserver.cache;

import java.util.Date;

public abstract class GenericCacheValue {
	private Date lastAccess;
	private final int maxUnaccessedTimeMillis;

	public GenericCacheValue(int maxUnaccessedTime) {
		this.maxUnaccessedTimeMillis = maxUnaccessedTime;
		access();
	}

	public void access() {
		lastAccess = new Date();
	}
	
	public boolean shouldCleanUp() {
		return new Date().getTime() - lastAccess.getTime() > maxUnaccessedTimeMillis;
	}
}
