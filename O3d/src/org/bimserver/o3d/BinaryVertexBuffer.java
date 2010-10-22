package org.bimserver.o3d;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.bimserver.utils.LittleEndianBinUtils;

public class BinaryVertexBuffer {

	private final List<Float> vertices = new ArrayList<Float>();
	private final List<Float> normals = new ArrayList<Float>();
	
	public void addVertex(float vertex) {
		getVertices().add(vertex);
	}

	public int getNrVertices() {
		return getVertices().size();
	}

	public void serialize(OutputStream outputStream) throws IOException {
		outputStream.write(LittleEndianBinUtils.intToByteArray(getVertices().size()/6));
		for (Float vertex : getVertices()) {
			outputStream.write(LittleEndianBinUtils.floatToByteArray(vertex));
		}
	}

	public List<Float> getVertices() {
		return vertices;
	}

	public void addNormal(float normal) {
		normals.add(normal);
	}

	public List<Float> getNormals() {
		return normals;
	}
}
