package org.bimserver.longaction;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class LongActionManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongActionManager.class);
	private static final int FIVE_MINUTES_IN_MS = 5;
	private final BiMap<Long, LongAction<?>> actions = HashBiMap.create();
	private volatile boolean running = true;
	private int actionNumberCounter = 0;
	private final BimServer bimServer;

	public LongActionManager(BimServer bimServer) {
		this.bimServer = bimServer;
	}
	
	public synchronized void start(final LongAction<?> longAction) throws CannotBeScheduledException {
		if (running) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					longAction.execute();
				}
			});
			longAction.setId(actionNumberCounter++);
			longAction.init();
			thread.setDaemon(true);
			thread.setName(longAction.getDescription());
			actions.put(longAction.getId(), longAction);
			thread.start();
		} else {
			throw new CannotBeScheduledException();
		}
	}

	public synchronized void shutdown() {
		running = false;
	}

	public synchronized List<org.bimserver.models.store.LongAction> getActiveLongActions() throws BimserverDatabaseException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			List<org.bimserver.models.store.LongAction> result = new ArrayList<org.bimserver.models.store.LongAction>();
			for (LongAction<?> longAction : actions.values()) {
				org.bimserver.models.store.LongAction storeLongAction = null;
//			if (longAction instanceof LongCheckinAction) {
//				LongCheckinAction longCheckinAction = (LongCheckinAction)longAction;
//				org.bimserver.models.store.LongCheckinAction storeLongCheckinAction = StoreFactory.eINSTANCE.createLongCheckinAction();
//				storeLongCheckinAction.getRevisions().addAll(longCheckinAction.getCreateCheckinAction().getCroid());
//			} else {
				storeLongAction = StoreFactory.eINSTANCE.createLongAction();
//			}
				User user = session.get(StorePackage.eINSTANCE.getUser(), longAction.getAuthorization().getUoid(), false, null);
				storeLongAction.setIdentification(longAction.getDescription());
				storeLongAction.setUser(user);
				storeLongAction.setStart(longAction.getStart().getTime());
				storeLongAction.setUsername(longAction.getUserUsername());
				storeLongAction.setName(longAction.getUserName());
				result.add(storeLongAction);
			}
			Collections.sort(result, new Comparator<org.bimserver.models.store.LongAction>() {
				@Override
				public int compare(org.bimserver.models.store.LongAction o1, org.bimserver.models.store.LongAction o2) {
					return o1.getStart().compareTo(o2.getStart());
				}
			});
			return result;
		} finally {
			session.close();
		}
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
					LOGGER.info("Cleaning up long running action: " + longAction.getDescription());
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

	public synchronized void remove(Integer actionId) {
		actions.remove(actionId);
	}

	public void remove(LongAction<?> action) {
		actions.inverse().remove(action);
	}
}