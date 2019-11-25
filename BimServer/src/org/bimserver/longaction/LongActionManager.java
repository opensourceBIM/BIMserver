package org.bimserver.longaction;

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

import java.util.GregorianCalendar;
import java.util.Iterator;

import org.bimserver.BimServer;
import org.bimserver.models.store.ActionState;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class LongActionManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongActionManager.class);
	private static final int FIVE_MINUTES_IN_MS = 5000 * 60; // 5 minutes
	private final BiMap<Long, LongAction<?>> actions = HashBiMap.create();
	private volatile boolean running = true;
	private BimServer bimServer;

	public LongActionManager(BimServer bimServer) {
		this.bimServer = bimServer;
	}
	
	public synchronized void start(final LongAction<?> longAction) throws CannotBeScheduledException {
		if (running) {
			synchronized (this) {
				// NPE has happened here, need to figure out why (possibly concurrent related)
				// This has probably been fixed by changing the lock object from the Class (erroneous) to the Object
				actions.put(longAction.getProgressTopic().getKey().getId(), longAction);
			}
			bimServer.getExecutorService().submit(new Runnable() {
				@Override
				public void run() {
					longAction.init();
					longAction.execute();
				}
			}, "LongAction Runner");
		} else {
			throw new CannotBeScheduledException();
		}
	}

	public synchronized void shutdown() {
		running = false;
	}

	public synchronized LongAction<?> getLongAction(long id) {
		return actions.get(id);
	}

	public synchronized void cleanup() {
		Iterator<Long> iterator = actions.keySet().iterator();
		GregorianCalendar now = new GregorianCalendar();
		while (iterator.hasNext()) {
			long id = iterator.next();
			LongAction<?> longAction = actions.get(id);
			if (longAction.getActionState() == ActionState.FINISHED) {
				GregorianCalendar stop = longAction.getStop();
				if (now.getTimeInMillis() - stop.getTimeInMillis() > FIVE_MINUTES_IN_MS) {
					LOGGER.debug("[AUTO] Cleaning up topic " + longAction.getProgressTopic().getKey().getId() + " (" + longAction.getDescription() + ")");
					iterator.remove();
				}
			}
		}
	}

	/*
	 * Untested method
	 */
	public synchronized void shutdownGracefully() {
		running = false;
		Iterator<LongAction<?>> iterator = actions.values().iterator();
		while (iterator.hasNext()) {
			LongAction<?> longAction = iterator.next();
			longAction.waitForCompletion();
		}
	}

	public synchronized void remove(long topicId) throws UserException {
		LongAction<?> longAction = actions.get(topicId);
		if (longAction != null) {
			LOGGER.debug("[MAN] Cleaning up topic " + longAction.getProgressTopic().getKey().getId() + " (" + longAction.getDescription() + ")");
			try {
				longAction.stop();
			} finally {
				actions.remove(topicId);
			}
		} else {
//			throw new UserException("No Topic with TopicId " + topicId + " found");
		}
	}

	public synchronized void remove(LongAction<?> action) {
		LOGGER.debug("Cleaning up topics: " + action.getDescription());
		try {
			action.stop();
		} finally {
			actions.inverse().remove(action);
		}
	}
}