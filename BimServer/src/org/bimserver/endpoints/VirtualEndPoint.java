package org.bimserver.endpoints;

import org.bimserver.shared.StreamingSocketInterface;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.RemoteServiceInterface;

public class VirtualEndPoint implements EndPoint {

	@Override
	public long getEndPointId() {
		return 0;
	}

	@Override
	public NotificationInterface getNotificationInterface() {
		return null;
	}

	@Override
	public RemoteServiceInterface getRemoteServiceInterface() {
		return null;
	}

	@Override
	public void cleanup() {
	}

	@Override
	public long getUoid() {
		return 0;
	}

	@Override
	public String getToken() {
		return null;
	}

	@Override
	public StreamingSocketInterface getStreamingSocketInterface() {
		return null;
	}
}