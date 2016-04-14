package org.bimserver.renderengine;

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
		
		setMaxWaitMillis(1000 * 60 * 1);
		
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