package org.bimserver.renderengine;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;

public class RenderEnginePool {
	private final Queue<RenderEngine> available;
	private final Set<RenderEngine> busy;
	private final Queue<CountDownLatch> waiting = new ArrayBlockingQueue<>(1000);
	
	public RenderEnginePool(int poolSize, RenderEngineFactory renderEngineFactory) throws RenderEngineException {
		available = new ArrayBlockingQueue<>(poolSize);
		busy = new HashSet<>();
		for (int i=0; i<poolSize; i++) {
			available.add(renderEngineFactory.createRenderEngine());
		}
	}

	public RenderEngine request() throws InterruptedException {
		CountDownLatch latch = null;
		synchronized (this) {
			if (available.isEmpty()) {
				latch = new CountDownLatch(1);
				waiting.add(latch);
			} else {
				return getRenderEngineSafe();
			}
		}
		if (latch != null) {
			latch.await();
			synchronized (this) {
				return getRenderEngineSafe();
			}
		}
		return null;
	}

	public void release(RenderEngine renderEngine) {
		synchronized (this) {
			busy.remove(renderEngine);
			available.add(renderEngine);
			CountDownLatch countDownLatch = waiting.poll();
			if (countDownLatch != null) {
				countDownLatch.countDown();
			}
		}
	}
	
	public RenderEngine getRenderEngineSafe() {
		RenderEngine renderEngine = available.poll();
		busy.add(renderEngine);
		return renderEngine;
	}
}