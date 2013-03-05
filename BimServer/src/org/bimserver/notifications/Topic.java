package org.bimserver.notifications;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.endpoints.EndPoint;

public class Topic {
	private final Set<EndPoint> endPoints = new HashSet<EndPoint>();
	
	public Set<EndPoint> getEndPoints() {
		return endPoints;
	}
	
	public void register(EndPoint endPoint) throws TopicRegisterException {
		endPoints.add(endPoint);
	}

	public void unregister(EndPoint endPoint) throws TopicRegisterException {
		endPoints.remove(endPoint);
	}
}