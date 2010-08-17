package org.bimserver;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LongActionManager extends Thread {

	private final BlockingQueue<LongAction> queue = new LinkedBlockingQueue<LongAction>();
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
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
			if (running) {
				e.printStackTrace();
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
				e.printStackTrace();
			}
		}
	}
}