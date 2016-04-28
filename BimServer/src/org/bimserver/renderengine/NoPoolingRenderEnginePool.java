package org.bimserver.renderengine;

import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;

public class NoPoolingRenderEnginePool implements RenderEnginePool {

	private RenderEngineFactory renderEngineFactory;

	public NoPoolingRenderEnginePool(RenderEngineFactory renderEngineFactory) {
		this.renderEngineFactory = renderEngineFactory;
	}
	
	@Override
	public RenderEngine borrowObject() throws RenderEngineException {
		RenderEngine createRenderEngine = renderEngineFactory.createRenderEngine();
		createRenderEngine.init();
		return createRenderEngine;
	}

	@Override
	public void returnObject(RenderEngine renderEngine) throws RenderEngineException {
		renderEngine.close();
	}
}