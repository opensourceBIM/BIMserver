package org.bimserver.o3d;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.bimserver.utils.LittleEndianBinUtils;

public class BinaryIndexFile {
	private final List<BinaryIndexBuffer> buffers = new ArrayList<BinaryIndexBuffer>();
	private int currentOffset = 0;
	private int nextOffset = 0;

	public void addBuffer(BinaryIndexBuffer binaryIndexBuffer) {
		buffers.add(binaryIndexBuffer);
		currentOffset = nextOffset;
		nextOffset += 4 + 4 + 4 + 1 + 1 + 4 + (binaryIndexBuffer.getNrIndices() * 4);
	}
	
	public int getCurrentOffset() {
		return currentOffset;
	}

	public int getNextOffset() {
		return nextOffset;
	}

	public void serialize(OutputStream outputStream) throws IOException {
		for (BinaryIndexBuffer binaryIndexBuffer : buffers) {
			outputStream.write("BUFF".getBytes("ASCII"));
			outputStream.write(LittleEndianBinUtils.intToByteArray(1));
			outputStream.write(LittleEndianBinUtils.intToByteArray(1));
			outputStream.write(LittleEndianBinUtils.byteToByteArray((byte) 2));
			outputStream.write(LittleEndianBinUtils.byteToByteArray((byte) 1));
			binaryIndexBuffer.serialize(outputStream);
		}
	}
}