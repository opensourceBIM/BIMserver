package org.bimserver.plugins.renderengine;

import java.io.InputStream;

public interface RenderEngine extends AutoCloseable {
	/**
	 * Initialize the render engine. This is only called once per RenderEngine instance and all work that can be done before loading a model should be done here (for example starting another process).
	 * 
	 * @throws RenderEngineException
	 */
	void init() throws RenderEngineException;

	/**
	 * Open a model. If the size is not known in advance, use the other openModel method
	 * 
	 * @param inputStream
	 * @param size
	 * @return
	 * @throws RenderEngineException
	 */
	RenderEngineModel openModel(InputStream inputStream, long size) throws RenderEngineException;
	
	/**
	 * Open a model. The other openModel method is recommended when the size is known in advance.
	 * 
	 * @param inputStream
	 * @return
	 * @throws RenderEngineException
	 */
	RenderEngineModel openModel(InputStream inputStream) throws RenderEngineException;
	
	/* (non-Javadoc)
	 * @see java.lang.AutoCloseable#close()
	 */
	void close() throws RenderEngineException;
}