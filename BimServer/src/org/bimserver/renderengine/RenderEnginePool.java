package org.bimserver.renderengine;

import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;

public interface RenderEnginePool  {

	RenderEngine borrowObject() throws RenderEngineException;

	void returnObject(RenderEngine renderEngine) throws RenderEngineException;
}