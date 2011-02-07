package org.bimserver.o3d;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.bimserver.utils.LittleEndianBinUtils;

public class BinaryVertexFile {

	private final List<BinaryVertexBuffer> buffers = new ArrayList<BinaryVertexBuffer>();
	private int currentOffset;
	private int nextOffset;
	
	public void addBuffer(BinaryVertexBuffer binaryVertexBuffer) {
		buffers.add(binaryVertexBuffer);
		currentOffset = nextOffset;
		nextOffset += 4 + 4 + 4 + 1 + 1 + 1 + 1 + 4 + (binaryVertexBuffer.getNrVertices() * 4);
	}

	public int getCurrentOffset() {
		return currentOffset;
	}

	public int getNextOffset() {
		return nextOffset;
	}

	public void serialize(OutputStream outputStream) throws IOException {
		for (BinaryVertexBuffer binaryVertexBuffer : buffers) {
			outputStream.write("BUFF".getBytes("ASCII"));
			outputStream.write(LittleEndianBinUtils.intToByteArray(1));
			outputStream.write(LittleEndianBinUtils.intToByteArray(2));
			outputStream.write(LittleEndianBinUtils.byteToByteArray((byte) 1));
			outputStream.write(LittleEndianBinUtils.byteToByteArray((byte) 3));
			outputStream.write(LittleEndianBinUtils.byteToByteArray((byte) 1));
			outputStream.write(LittleEndianBinUtils.byteToByteArray((byte) 3));
			binaryVertexBuffer.serialize(outputStream);
		}
	}
}