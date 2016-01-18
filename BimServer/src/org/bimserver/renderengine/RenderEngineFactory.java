package org.bimserver.renderengine;

import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;

public interface RenderEngineFactory {

	RenderEngine createRenderEngine() throws RenderEngineException;

}
