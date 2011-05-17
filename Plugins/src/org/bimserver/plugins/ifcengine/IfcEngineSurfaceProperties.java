package org.bimserver.plugins.ifcengine;

public class IfcEngineSurfaceProperties {

	private final int modelId;
	private final int verticesCount;
	private final int indicesCount;
	private final double scale;

	public IfcEngineSurfaceProperties(int modelId, int verticesCount, int indicesCount, double scale) {
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