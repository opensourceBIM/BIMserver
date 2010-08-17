package org.bimserver.o3d;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.bimserver.utils.LittleEndianBinUtils;

public class BinaryVertexBuffer {

	private final List<Float> vertices = new ArrayList<Float>();
	
	public void addVertex(float vertex) {
		vertices.add(vertex);
	}

	public int getNrVertices() {
		return vertices.size();
	}

	public void serialize(OutputStream outputStream) throws IOException {
		outputStream.write(LittleEndianBinUtils.intToByteArray(vertices.size()/6));
		for (Float vertex : vertices) {
			outputStream.write(LittleEndianBinUtils.floatToByteArray(vertex));
		}
	}
}
