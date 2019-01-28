package org.bimserver.renderengine;

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
