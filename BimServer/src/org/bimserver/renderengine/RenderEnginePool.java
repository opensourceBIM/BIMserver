package org.bimserver.renderengine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class RenderEnginePool extends GenericObjectPool<RenderEngine> {
	private static final Logger LOGGER = LoggerFactory.getLogger(RenderEnginePool.class);
//	private final Queue<RenderEngine> available;
//	private final Set<RenderEngine> busy;
//	private final Queue<CountDownLatch> waiting = new ArrayBlockingQueue<>(1000);
//	private final Set<RenderEngineLease> leases = new HashSet<>();
	
	public RenderEnginePool(int poolSize, RenderEngineFactory renderEngineFactory) throws RenderEngineException {
		super(new PooledObjectFactory<RenderEngine>() {
			@Override
			public void activateObject(PooledObject<RenderEngine> arg0) throws Exception {
				arg0.getObject().init();
			}

			@Override
			public void destroyObject(PooledObject<RenderEngine> arg0) throws Exception {
			}

			@Override
			public PooledObject<RenderEngine> makeObject() throws Exception {
				return new DefaultPooledObject<RenderEngine>(renderEngineFactory.createRenderEngine());
			}

			@Override
			public void passivateObject(PooledObject<RenderEngine> arg0) throws Exception {
			}

			@Override
			public boolean validateObject(PooledObject<RenderEngine> arg0) {
				return false;
			}
		});
		
		setMaxTotal(8);
		
//		available = new ArrayBlockingQueue<>(poolSize);
//		busy = new HashSet<>();
//		for (int i=0; i<poolSize; i++) {
//			available.add(renderEngineFactory.createRenderEngine());
//		}
	}
//	
//	@Override
//	public void run() {
//		while (true) {
//			GregorianCalendar cutoff = new GregorianCalendar();
//			cutoff.add(Calendar.MINUTE, 1);
//			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
//			for (RenderEngineLease lease : leases) {
//				if (lease.getStart().before(cutoff)) {
//					LOGGER.warn("Render Engine Leased for too long (since " + dateFormat.format(lease.getStart().getTime()) + ")");
//				}
//			}
//			try {
//				Thread.sleep(60000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}

//	@SuppressWarnings("unused")
//	public RenderEngineLease request() throws InterruptedException {
//		CountDownLatch latch = null;
//		synchronized (this) {
//			if (available.isEmpty()) {
//				latch = new CountDownLatch(1);
//				waiting.add(latch);
//			} else {
//				LOGGER.info("Granting RenderEngine " + toString());
//				return getRenderEngineSafe();
//			}
//		}
//		if (latch != null) {
//			latch.await();
//			synchronized (this) {
//				LOGGER.info("Granting RenderEngine " + toString());
//				return getRenderEngineSafe();
//			}
//		}
//		return null;
//	}
	
//	@Override
//	public String toString() {
//		return "Busy: " + busy.size() + " / Available: "  + available.size();
//	}
//
//	public void release(RenderEngineLease renderEngineLease) {
//		LOGGER.info("Releasing " + toString());
//		synchronized (this) {
//			busy.remove(renderEngineLease.getRenderEngine());
//			available.add(renderEngineLease.getRenderEngine());
//			CountDownLatch countDownLatch = waiting.poll();
//			if (countDownLatch != null) {
//				countDownLatch.countDown();
//			}
//		}
//	}
	
//	public RenderEngineLease getRenderEngineSafe() {
//		RenderEngineLease renderEngineLease = new RenderEngineLease(this, available.poll());
//		busy.add(renderEngineLease.getRenderEngine());
//		return renderEngineLease;
//	}
}