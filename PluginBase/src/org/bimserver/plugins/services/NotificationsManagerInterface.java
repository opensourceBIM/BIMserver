package org.bimserver.plugins.services;

import org.bimserver.client.notifications.BinaryMessageListener;

import com.fasterxml.jackson.databind.JsonNode;

public interface NotificationsManagerInterface {

	void registerProgressHandler(Long topicId, ProgressHandler progressHandler);

	void setBinaryMessageListener(long topicId, BinaryMessageListener binaryMessageListener);

	void send(JsonNode jsonNode);
}
