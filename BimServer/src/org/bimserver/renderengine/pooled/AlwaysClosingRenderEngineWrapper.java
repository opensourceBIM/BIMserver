package org.bimserver.renderengine.pooled;

import java.io.InputStream;

import org.bimserver.plugins.renderengine.Metrics;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEngineModel;
import org.bimserver.renderengine.RenderEngineFactory;

/*
 * Sole purpose of this wrapper is to create a completely new engine on init and destroy it on close, which is not how things are supposed to work eventually.
 * Ideally we want to keep using the same process for a while.
 */
public class AlwaysClosingRenderEngineWrapper implements RenderEngine {

	private RenderEngineFactory renderEngineFactory;
	private RenderEngine wrapped;

	public AlwaysClosingRenderEngineWrapper(RenderEngineFactory renderEngineFactory) {
		this.renderEngineFactory = renderEngineFactory;
	}
	
	@Override
	public void init() throws RenderEngineException {
		wrapped = renderEngineFactory.createRenderEngine();
		wrapped.init();
	}

	@Override
	public RenderEngineModel openModel(InputStream inputStream, long size) throws RenderEngineException {
		return wrapped.openModel(inputStream, size);
	}

	@Override
	public RenderEngineModel openModel(InputStream inputStream) throws RenderEngineException {
		return wrapped.openModel(inputStream);
	}

	@Override
	public void close() throws RenderEngineException {
		wrapped.close();
		wrapped = null;
	}

	@Override
	public boolean isCalculateQuantities() {
		return wrapped.isCalculateQuantities();
	}

	@Override
	public boolean isApplyLayerSets() {
		return wrapped.isApplyLayerSets();
	}

	@Override
	public Metrics getMetrics() {
		return wrapped.getMetrics();
	}
}