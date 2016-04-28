package org.bimserver.renderengine.pooled;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.renderengine.RenderEngineFactory;
import org.bimserver.renderengine.RenderEnginePool;

public class CommonsRenderEnginePool implements RenderEnginePool {
	private GenericObjectPool<RenderEngine> genericObjectPool;
	
	public CommonsRenderEnginePool(int poolSize, RenderEngineFactory renderEngineFactory) throws RenderEngineException {
		PooledObjectFactory<RenderEngine> pooledObjectFactory = new PooledObjectFactory<RenderEngine>() {
			@Override
			public void activateObject(PooledObject<RenderEngine> arg0) throws Exception {
				arg0.getObject().init();
			}

			@Override
			public void destroyObject(PooledObject<RenderEngine> arg0) throws Exception {
				arg0.getObject().close();
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
		};
		
		genericObjectPool = new GenericObjectPool<RenderEngine>(pooledObjectFactory);
		
		genericObjectPool.setMaxWaitMillis(1000 * 60 * 1);
		genericObjectPool.setMaxTotal(8);
	}

	@Override
	public RenderEngine borrowObject() throws RenderEngineException {
		try {
			return genericObjectPool.borrowObject();
		} catch (Exception e) {
			throw new RenderEngineException(e);
		}
	}

	@Override
	public void returnObject(RenderEngine renderEngine) throws RenderEngineException {
		genericObjectPool.returnObject(renderEngine);
	}
}