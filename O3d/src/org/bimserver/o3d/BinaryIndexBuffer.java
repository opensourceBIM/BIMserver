package org.bimserver.o3d;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.bimserver.utils.LittleEndianBinUtils;

public class BinaryIndexBuffer {

	private final List<Integer> indices = new ArrayList<Integer>();
	
	public void addIndex(int index) {
		indices.add(index);
	}

	public int getNrIndices() {
		return indices.size();
	}

	public List<Integer> getIndices() {
		return indices;
	}
	
	public void serialize(OutputStream outputStream) throws IOException {
		outputStream.write(LittleEndianBinUtils.intToByteArray(indices.size()));
		for (Integer index : indices) {
			outputStream.write(LittleEndianBinUtils.intToByteArray(index));
		}		
	}
}