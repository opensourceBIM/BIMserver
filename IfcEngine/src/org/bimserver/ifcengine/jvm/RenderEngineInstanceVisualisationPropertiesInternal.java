package org.bimserver.ifcengine.jvm;


public class RenderEngineInstanceVisualisationPropertiesInternal {

	private int startVertex;
	private int startIndex;
	private int primitiveCount;

	public RenderEngineInstanceVisualisationPropertiesInternal(int startVertex, int startIndex, int primitiveCount) {
		this.startVertex = startVertex;
		this.startIndex = startIndex;
		this.primitiveCount = primitiveCount;
	}

	public int getStartVertex() {
		return startVertex;
	}
	
	public int getPrimitiveCount() {
		return primitiveCount;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
}
