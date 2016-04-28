package org.bimserver.renderengine;

public class NoPoolingRenderEnginePoolFactory implements RenderEnginePoolFactory {

	@Override
	public RenderEnginePool newRenderEnginePool(RenderEngineFactory renderEngineFactory) {
		return new NoPoolingRenderEnginePool(renderEngineFactory);
	}
}
