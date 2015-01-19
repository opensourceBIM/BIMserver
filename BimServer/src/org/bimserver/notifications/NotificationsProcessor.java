package org.bimserver.notifications;

import java.util.concurrent.LinkedBlockingQueue;

import org.bimserver.BimServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationsProcessor extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsProcessor.class);
	private final BimServer bimServer;
	private final LinkedBlockingQueue<Notification> queue = new LinkedBlockingQueue<>(1000000);
	private volatile boolean running = true;

	public NotificationsProcessor(BimServer bimServer) {
		this.bimServer = bimServer;
	}

	@Override
	public void run() {
		try {
			while (running) {
				queue.take().run();
			}
		} catch (InterruptedException e) {
			if (running) {
				LOGGER.error("Unexpected interruption");
			}
		}
	}

	public void termintate() {
		running = false;
		interrupt();
	}

	public void queue(Notification notification) {
		if (!queue.offer(notification)) {
			LOGGER.error("Notification queue is full!");
		}
	}
}
