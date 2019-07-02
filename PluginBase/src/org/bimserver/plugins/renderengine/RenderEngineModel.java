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

import java.util.Collection;

public interface RenderEngineModel extends AutoCloseable {
	public static final int PRECISION = Precision.BIT;
	public static final int INDEX_BITS = IndexFormat.BIT;
	public static final int NORMALS = 32;
	public static final int TRANSFORM_GEOMETRY = 128;
	public static final int TRIANGLES = 256;
	public static final int WIREFRAME = 4096;

	void setFormat(int format, int mask) throws RenderEngineException;
	void setSettings(RenderEngineSettings settings) throws RenderEngineException;
	RenderEngineInstance getInstanceFromExpressId(long expressId) throws RenderEngineException;
	Collection<RenderEngineInstance> listInstances() throws RenderEngineException;
	void generateGeneralGeometry() throws RenderEngineException;
	void close() throws RenderEngineException;
	void setFilter(RenderEngineFilter renderEngineFilter) throws RenderEngineException;
}