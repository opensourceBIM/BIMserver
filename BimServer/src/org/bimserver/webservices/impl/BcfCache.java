package org.bimserver.webservices.impl;

import java.util.HashMap;
import java.util.Map;

import org.opensourcebim.bcf.BcfFile;

public class BcfCache {
	public static BcfCache INSTANCE = new BcfCache();
	private final Map<Long, BcfFile> map = new HashMap<>();
	
	public BcfCache() {
		
	}
	
	public synchronized void put(Long extendedDataId, BcfFile bcfFile) {
		map.put(extendedDataId, bcfFile);
	}
	
	public BcfFile get(Long extendedDataId) {
		return map.get(extendedDataId);
	}
}
