package org.bimserver.longaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bimserver.shared.SLongAction;

public class LongActionManager {

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(LongActionManager.class);
	private final Map<LongAction, Thread> threads = new HashMap<LongAction, Thread>();
	private final Map<String, LongAction> actions = new HashMap<String, LongAction>();
	private volatile boolean running = true;

	public synchronized void start(final LongAction longAction) throws CannotBeScheduledException {
		if (running) {
			actions.put(longAction.getIdentification(), longAction);

			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					longAction.execute();
					synchronized (LongActionManager.this) {
						threads.remove(longAction);
					}
				}
			});
			thread.setDaemon(true);
			thread.setName(longAction.getIdentification());
			threads.put(longAction, thread);
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
		for (LongAction longAction : threads.keySet()) {
			SLongAction sLongAction = new SLongAction();
			sLongAction.setIdentification(longAction.getIdentification());
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

	public synchronized LongAction getLongAction(String longActionID) {
		return actions.get(longActionID);
	}

	/*
	 * Untested method
	 */
	public synchronized void shutdownGracefully() {
		running = false;
		Iterator<LongAction> iterator = threads.keySet().iterator();
		while (iterator.hasNext()) {
			LongAction longAction = iterator.next();
			longAction.waitForCompletion();
		}
	}

	public boolean isRunning(LongAction longAction) {
		for (LongAction la : threads.keySet()) {
			if (la.equals(longAction))
				return true;
		}
		return false;
	}
}