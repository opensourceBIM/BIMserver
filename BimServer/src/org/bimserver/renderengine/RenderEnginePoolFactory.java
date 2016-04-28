package org.bimserver.renderengine;

import org.bimserver.plugins.renderengine.RenderEngineException;

public interface RenderEnginePoolFactory {

	RenderEnginePool newRenderEnginePool(RenderEngineFactory renderEngineFactory) throws RenderEngineException;

}
