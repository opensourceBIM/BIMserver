package org.bimserver.geometry;

import java.nio.ByteBuffer;

public class BufferSet {

	private ByteBuffer indicesByteBuffer;
	private ByteBuffer verticesByteBuffer;
	private ByteBuffer normalsByteBuffer;
	private ByteBuffer colorsByteBuffer;

	public BufferSet(ByteBuffer indicesByteBuffer, ByteBuffer verticesByteBuffer, ByteBuffer normalsByteBuffer, ByteBuffer colorsByteBuffer) {
		this.indicesByteBuffer = indicesByteBuffer;
		this.verticesByteBuffer = verticesByteBuffer;
		this.normalsByteBuffer = normalsByteBuffer;
		this.colorsByteBuffer = colorsByteBuffer;
	}

	public ByteBuffer getIndicesByteBuffer() {
		return indicesByteBuffer;
	}

	public void setIndicesByteBuffer(ByteBuffer indicesByteBuffer) {
		this.indicesByteBuffer = indicesByteBuffer;
	}
	
	public ByteBuffer getVerticesByteBuffer() {
		return verticesByteBuffer;
	}

	public void setVerticesByteBuffer(ByteBuffer verticesByteBuffer) {
		this.verticesByteBuffer = verticesByteBuffer;
	}

	public ByteBuffer getNormalsByteBuffer() {
		return normalsByteBuffer;
	}

	public void setNormalsByteBuffer(ByteBuffer normalsByteBuffer) {
		this.normalsByteBuffer = normalsByteBuffer;
	}

	public ByteBuffer getColorsByteBuffer() {
		return colorsByteBuffer;
	}

	public void setColorsByteBuffer(ByteBuffer colorsByteBuffer) {
		this.colorsByteBuffer = colorsByteBuffer;
	}
}
