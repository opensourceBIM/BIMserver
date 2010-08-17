package org.bimserver.ifcengine;

public class Geometry {
	private final int[] indices;
	private final float[] vertices;
	private final float[] normals;

	public Geometry(int[] indices, float[] vertices, float[] normals) {
		this.indices = indices;
		this.vertices = vertices;
		this.normals = normals;
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

	public int getNrVertices() {
		return vertices.length;
	}

	public int getNrNormals() {
		return normals.length;
	}

	public int getNrIndices() {
		return indices.length;
	}
}