package org.bimserver.notifications;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.concurrent.LinkedBlockingQueue;

import org.bimserver.BimServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationsProcessor extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsProcessor.class);
	private final LinkedBlockingQueue<Notification> queue = new LinkedBlockingQueue<>(1000000);
	private volatile boolean running = true;

	public NotificationsProcessor(BimServer bimServer) {
		setName("Notifications processor");
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
