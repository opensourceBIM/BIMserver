package org.bimserver.renderengine;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

	@SuppressWarnings("unused")
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