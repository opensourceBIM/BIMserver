package org.bimserver.plugins.ifcengine;

public class IfcEngineInstanceVisualisationProperties {
	private int startVertex;
	private int startIndex;
	private int primitiveCount;

	public IfcEngineInstanceVisualisationProperties(int startVertex, int startIndex, int primitiveCount) {
		this.startVertex = startVertex;
		this.startIndex = startIndex;
		this.primitiveCount = primitiveCount;
	}

	public int getStartVertex() {
		return startVertex;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public int getPrimitiveCount() {
		return primitiveCount;
	}
}
