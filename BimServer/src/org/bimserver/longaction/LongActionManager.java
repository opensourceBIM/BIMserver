package org.bimserver.longaction;

import java.util.concurrent.LinkedBlockingDeque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongActionManager extends Thread {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongActionManager.class);
	private final LinkedBlockingDeque<LongAction> queue = new LinkedBlockingDeque<LongAction>();
	private volatile boolean running = true;
	private boolean finished = false;

	public LongActionManager() {
		setName("LongActionManager");
	}

	public void start(LongAction longAction) {
		queue.add(longAction);
	}

	@Override
	public void run() {
		try {
			while (running) {
				LongAction longAction = queue.take();
				try {
					longAction.execute();
				} catch (Exception e) {
					LOGGER.error("", e);

				}
			}
		} catch (InterruptedException e) {
			if (running) {
				LOGGER.error("", e);
			}
		}
		finished = true;
	}

	public void shutdown() {
		running = false;
		interrupt();
	}
	
	public void shutdownGracefully() {
		running = false;
		while (!finished) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				LOGGER.error("", e);
			}
		}
	}
}