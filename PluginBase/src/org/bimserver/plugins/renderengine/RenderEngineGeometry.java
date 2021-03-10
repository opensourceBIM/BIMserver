package org.bimserver.plugins.renderengine;

import java.nio.ByteBuffer;

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

public class RenderEngineGeometry {
	private final ByteBuffer indices;
	private final ByteBuffer vertices;
	private final ByteBuffer normals;
	private final ByteBuffer materials;
	private final ByteBuffer materialIndices;

	public RenderEngineGeometry(ByteBuffer indices, ByteBuffer vertices, ByteBuffer normals, ByteBuffer materials, ByteBuffer materialIndices) {
		this.indices = indices;
		this.vertices = vertices;
		this.normals = normals;
		this.materials = materials;
		this.materialIndices = materialIndices;
	}
	
	public int getIndex(int index) {
		return indices.get(index);
	}
	
	public double getVertex(int index) {
		return vertices.get(index);
	}
	
	public float getNormal(int index) {
		return normals.get(index);
	}

	public float getMaterial(int index) {
		return materials.get(index);
	}

	public int getMaterialIndex(int index) {
		return materialIndices.get(index);
	}

	public int getNrIndices() {
		return indices.asIntBuffer().capacity();
	}

	public int getNrVertices() {
		return vertices.asDoubleBuffer().capacity();
	}

	public int getNrNormals() {
		return normals.asFloatBuffer().capacity();
	}

	public int getNrMaterials(){
		return materials.asFloatBuffer().capacity();
	}

	public int getNrMaterialIndices() {
		return materialIndices.asIntBuffer().capacity();
	}

	public ByteBuffer getIndices() {
		return indices;
	}

	public ByteBuffer getVertices() {
		return vertices;
	}
	
	public ByteBuffer getNormals() {
		return normals;
	}
	
	public ByteBuffer getMaterials() {
		return materials;
	}

	public ByteBuffer getMaterialIndices() {
		return materialIndices;
	}
}