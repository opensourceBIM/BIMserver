package org.bimserver.o3d;

public class SetGeometryResult {
	private final int addedIndices;
	private final int addedVertices;
	private final BinaryIndexBuffer binaryIndexBuffer;
	private final BinaryVertexBuffer binaryVertexBuffer;
	
	public SetGeometryResult(int addedIndices, int addedVertices, BinaryIndexBuffer binaryIndexBuffer, BinaryVertexBuffer binaryVertexBuffer) {
		this.addedIndices = addedIndices;
		this.addedVertices = addedVertices;
		this.binaryIndexBuffer = binaryIndexBuffer;
		this.binaryVertexBuffer = binaryVertexBuffer;
	}

	public int getAddedIndices() {
		return addedIndices;
	}

	public int getAddedVertices() {
		return addedVertices;
	}

	public BinaryIndexBuffer getBinaryIndexBuffer() {
		return binaryIndexBuffer;
	}

	public BinaryVertexBuffer getBinaryVertexBuffer() {
		return binaryVertexBuffer;
	}	
}