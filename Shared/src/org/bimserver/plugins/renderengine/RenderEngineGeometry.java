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

public class RenderEngineGeometry {
	private final int[] indices;
	private final float[] vertices;
	private final float[] normals;
	private float[] materials;
	private int[] materialIndices;

	public RenderEngineGeometry(int[] indices, float[] vertices, float[] normals, float[] materials, int[] materialIndices) {
		this.indices = indices;
		this.vertices = vertices;
		this.normals = normals;
		this.materials = materials;
		this.materialIndices = materialIndices;
	}
	
	public int getIndex(int index) {
		return indices[index];
	}
	
	public float getVertex(int index) {
		return vertices[index];
	}
	
	public float getNormal(int index) {
		return normals[index];
	}

	public float[] getMaterials() {
		return materials;
	}
	
	public int[] getMaterialIndices() {
		return materialIndices;
	}
	
	public int getNrVertices() {
		return vertices.length;
	}

	public int getNrNormals() {
		return normals.length;
	}

	public int getNrIndices() {
		return indices.length;
	}

	public float[] getVertices() {
		return vertices;
	}
	
	public float[] getNormals() {
		return normals;
	}
	
	public int[] getIndices() {
		return indices;
	}

	public int getMaterialIndex(int index) {
		return materialIndices[index];
	}

	public float getMaterial(int i) {
		return materials[i];
	}
}