package org.bimserver.renderengine;

import java.util.GregorianCalendar;

import org.bimserver.plugins.renderengine.RenderEngine;

public class RenderEngineLease implements AutoCloseable {
	private GregorianCalendar start;
	private RenderEngine renderEngine;
	private RenderEnginePool renderEnginePool;
	
	public RenderEngineLease(RenderEnginePool renderEnginePool, RenderEngine renderEngine) {
		this.renderEnginePool = renderEnginePool;
		this.renderEngine = renderEngine;
		start = new GregorianCalendar();
	}

	public GregorianCalendar getStart() {
		return start;
	}

	public RenderEngine getRenderEngine() {
		return renderEngine;
	}

	@Override
	public void close() throws Exception {
//		renderEnginePool.release(this);
	}
}
