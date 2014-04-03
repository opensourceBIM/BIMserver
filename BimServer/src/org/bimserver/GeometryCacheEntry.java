package org.bimserver;

import java.nio.ByteBuffer;

import org.bimserver.models.geometry.GeometryInfo;

public class GeometryCacheEntry {
	public GeometryCacheEntry(ByteBuffer verticesBuffer, ByteBuffer normalsBuffer, GeometryInfo geometryInfo) {
		this.vertices = verticesBuffer;
		this.normals = normalsBuffer;
		this.geometryInfo = geometryInfo;
	}

	private ByteBuffer vertices;
	private ByteBuffer normals;
	private GeometryInfo geometryInfo;

	public ByteBuffer getVertices() {
		return vertices;
	}

	public ByteBuffer getNormals() {
		return normals;
	}

	public GeometryInfo getGeometryInfo() {
		return geometryInfo;
	}
}