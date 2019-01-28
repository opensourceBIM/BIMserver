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

public class RenderEngineSurfaceProperties {

	private final int modelId;
	private final int verticesCount;
	private final int indicesCount;
	private final double scale;

	public RenderEngineSurfaceProperties(int modelId, int verticesCount, int indicesCount, double scale) {
		this.modelId = modelId;
		this.verticesCount = verticesCount;
		this.indicesCount = indicesCount;
		this.scale = scale;
	}

	public int getModelId() {
		return modelId;
	}

	public int getVerticesCount() {
		return verticesCount;
	}

	public int getIndicesCount() {
		return indicesCount;
	}

	public double getScale() {
		return scale;
	}
}