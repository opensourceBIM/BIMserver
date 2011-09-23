package org.bimserver.o3d;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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