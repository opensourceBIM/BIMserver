package org.bimserver.renderengine.pooled;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.renderengine.RenderEngineFactory;
import org.bimserver.renderengine.RenderEnginePool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonsRenderEnginePool implements RenderEnginePool {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonsRenderEnginePool.class);
	private GenericObjectPool<RenderEngine> genericObjectPool;
	private RenderEngineFactory renderEngineFactory;
	
	public CommonsRenderEnginePool(int poolSize, RenderEngineFactory renderEngineFactory) throws RenderEngineException {
		LOGGER.info("Pool size: " + poolSize);
		this.renderEngineFactory = renderEngineFactory;
		
		// This pool is currently only used for making sure there is a max amount of engines running simultaneously.
		// It is not actually pooling the render engines because the render engines used are not stable enough to reuse at the moment.
		
		PooledObjectFactory<RenderEngine> pooledObjectFactory = new PooledObjectFactory<RenderEngine>() {
			@Override
			public void activateObject(PooledObject<RenderEngine> arg0) throws Exception {
				arg0.getObject().init();
			}

			@Override
			public void destroyObject(PooledObject<RenderEngine> arg0) throws Exception {
			}

			@Override
			public PooledObject<RenderEngine> makeObject() throws Exception {
				AlwaysClosingRenderEngineWrapper alwaysClosingRenderEngineWrapper = new AlwaysClosingRenderEngineWrapper(renderEngineFactory);
				return new DefaultPooledObject<RenderEngine>(alwaysClosingRenderEngineWrapper);
			}

			@Override
			public void passivateObject(PooledObject<RenderEngine> arg0) throws Exception {
				arg0.getObject().close();
			}

			@Override
			public boolean validateObject(PooledObject<RenderEngine> arg0) {
				return false;
			}
		};
		
		genericObjectPool = new GenericObjectPool<RenderEngine>(pooledObjectFactory);
		
		genericObjectPool.setMaxWaitMillis(1000 * 60 * 60);
		genericObjectPool.setMaxTotal(poolSize);
	}

	@Override
	public RenderEngine borrowObject() throws RenderEngineException {
		try {
			RenderEngine borrowObject = genericObjectPool.borrowObject();
			return borrowObject;
		} catch (Exception e) {
			throw new RenderEngineException(e);
		}
	}

	@Override
	public void returnObject(RenderEngine renderEngine) throws RenderEngineException {
		genericObjectPool.returnObject(renderEngine);
	}

	@Override
	public RenderEngineFactory getRenderEngineFactory() {
		return renderEngineFactory;
	}
}