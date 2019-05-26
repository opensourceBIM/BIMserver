package org.bimserver.plugins.renderengine;

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

	boolean isCalculateQuantities();

	boolean isApplyLayerSets();
	
	Metrics getMetrics();
}