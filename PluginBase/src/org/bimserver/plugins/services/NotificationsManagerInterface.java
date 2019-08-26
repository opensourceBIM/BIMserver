package org.bimserver.plugins.services;

public interface NotificationsManagerInterface {

	void registerProgressHandler(Long topicId, ProgressHandler progressHandler);
}
