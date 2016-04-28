package org.bimserver.renderengine.pooled;

import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.renderengine.RenderEngineFactory;
import org.bimserver.renderengine.RenderEnginePool;
import org.bimserver.renderengine.RenderEnginePoolFactory;

public class CommonsPoolingRenderEnginePoolFactory implements RenderEnginePoolFactory {

	private int nrRenderEngineProcesses;

	public CommonsPoolingRenderEnginePoolFactory(int nrRenderEngineProcesses) {
		this.nrRenderEngineProcesses = nrRenderEngineProcesses;
	}
	
	@Override
	public RenderEnginePool newRenderEnginePool(RenderEngineFactory renderEngineFactory) throws RenderEngineException {
		return new CommonsRenderEnginePool(nrRenderEngineProcesses, renderEngineFactory);
	}
}
