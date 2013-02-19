package org.bimserver.plugins.renderengine;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.List;
import java.util.Set;

public interface RenderEngineModel {
	public static final int PRECISION = Precision.BIT;
	public static final int INDEX_BITS = IndexFormat.BIT;
	public static final int NORMALS = 32;
	public static final int TRIANGLES = 256;
	public static final int WIREFRAME = 4096;
	
	RenderEngineSurfaceProperties initializeModelling() throws RenderEngineException;
	void setPostProcessing(boolean postProcessing) throws RenderEngineException;
	void setFormat(int format, int mask) throws RenderEngineException;
	RenderEngineGeometry finalizeModelling(RenderEngineSurfaceProperties surfaceProperties) throws RenderEngineException;
	List<? extends RenderEngineInstance> getInstances(String name) throws RenderEngineException;
	void close() throws RenderEngineException;
	Set<RenderEngineClash> findClashesWithEids(double d) throws RenderEngineException;
	Set<RenderEngineClash> findClashesWithGuids(double d) throws RenderEngineException;
	RenderEngineInstance getInstanceFromExpressId(int oid) throws RenderEngineException;
	void setSettings(RenderEngineSettings settings) throws RenderEngineException;
}