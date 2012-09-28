package org.bimserver.servlets;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class EndPointManager {

	private final BiMap<Long, EndPoint> endPoints = HashBiMap.create();
	private long idCounter = 1;
	
	public long register(EndPoint endPoint) {
		long id = idCounter++;
		endPoints.put(id, endPoint);
		return id;
	}

	public void unregister(EndPoint endPoint) {
		endPoints.remove(endPoint.getEndPointId());
		endPoint.cleanup();
	}

	public EndPoint get(long endPointId) {
		return endPoints.get(endPointId);
	}
}
