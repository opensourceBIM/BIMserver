package org.bimserver.longaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.bimserver.shared.SLongAction;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class LongActionManager {

	private final BiMap<Integer, LongAction<?>> actions = HashBiMap.create();

	private volatile boolean running = true;

	private int actionNumberCounter = 0;

	public synchronized void start(final LongAction<?> longAction) throws CannotBeScheduledException {
		if (running) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					longAction.execute();
					synchronized (LongActionManager.this) {
						//actions.remove(longAction.getId());
					}
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

	public synchronized List<SLongAction> getActiveLongActions() {
		List<SLongAction> result = new ArrayList<SLongAction>();
		for (LongAction<?> longAction : actions.values()) {
			SLongAction sLongAction = new SLongAction();
			sLongAction.setIdentification(longAction.getDescription());
			sLongAction.setUserOid(longAction.getUser().getOid());
			sLongAction.setStart(longAction.getStart());
			sLongAction.setUsername(longAction.getUser().getUsername());
			sLongAction.setName(longAction.getUser().getName());
			result.add(sLongAction);
		}
		Collections.sort(result, new Comparator<SLongAction>() {
			@Override
			public int compare(SLongAction o1, SLongAction o2) {
				return o1.getStart().compareTo(o2.getStart());
			}
		});
		return result;
	}

	public synchronized LongAction<?> getLongAction(int id) {
		return actions.get(id);
	}

	@SuppressWarnings("unchecked")
	public synchronized <T extends LongAction<?>> T getLongAction(Class<T> clazz, LongActionKey key) {
		for (LongAction<?> longAction : actions.values()) {
			if (clazz.isInstance(longAction)) {
				LongActionKey longActionKey = longAction.getKey();
				if (longActionKey.equals(key)) {
					return (T) longAction;
				}
			}
		}
		return null;
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
}