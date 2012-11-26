package org.bimserver.endpoints;

import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

public class EndPointManager {

	private final BiMap<Long, EndPoint> endPoints = Maps.synchronizedBiMap(HashBiMap.<Long, EndPoint>create());
	private final AtomicLong idCounter = new AtomicLong(1);
	
	public long register(EndPoint endPoint) {
		long id = idCounter.incrementAndGet();
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

	public void clear() {
		for (Entry<Long, EndPoint> entry : endPoints.entrySet()) {
			entry.getValue().cleanup();
		}
		endPoints.clear();
	}
}