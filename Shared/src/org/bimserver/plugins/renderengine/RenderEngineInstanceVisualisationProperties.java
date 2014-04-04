package org.bimserver.plugins.renderengine;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

public class RenderEngineInstanceVisualisationProperties {
	private final int startIndex;
	private final int startVertex;
	private final int nrPrimitives;

	public RenderEngineInstanceVisualisationProperties(int startIndex, int startVertex, int nrPrimitives) {
		this.startIndex = startIndex;
		this.startVertex = startVertex;
		this.nrPrimitives = nrPrimitives;
	}
	
	public float[] getMaterials() {
		return null;
	}

	public int[] getMaterialIndices() {
		return null;
	}
	
	public int getNrPrimitives() {
		return nrPrimitives;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	
	public int getStartVertex() {
		return startVertex;
	}
}