package org.bimserver.client.notifications;

public interface BinaryMessageListener {

	void newData(byte[] bytes, int start, int length);
}
