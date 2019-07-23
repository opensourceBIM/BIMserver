package org.bimserver.plugins.services;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Geometry {
	private static final byte GEOMETRY_TYPE_TRIANGLES = 0;
	private static final byte GEOMETRY_TYPE_INSTANCE = 1;
	private IntBuffer indices;
	private FloatBuffer vertices;
	private FloatBuffer normals;
	@SuppressWarnings("unused")
	private FloatBuffer materials;
	private float minX;
	private float minY;
	private float minZ;
	private float maxX;
	private float maxY;
	private float maxZ;

	@SuppressWarnings("unused")
	public Geometry(InputStream inputStream, long oidToUse) throws IOException {
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		String protocol = dataInputStream.readUTF();
		byte version = dataInputStream.readByte();
		dataInputStream.readFloat();
		dataInputStream.readFloat();
		dataInputStream.readFloat();
		dataInputStream.readFloat();
		dataInputStream.readFloat();
		dataInputStream.readFloat();
		int nrObjects = dataInputStream.readInt();
		int offset = 2;
		for (int i=0; i<nrObjects; i++) {
			String type = dataInputStream.readUTF();
			long oid = dataInputStream.readLong();
			byte geometryType = dataInputStream.readByte();
			
			offset += 3 + type.getBytes("UTF-8").length;
			int skip = 4 - (offset % 4);
			if (skip != 0 && skip != 4) {
				dataInputStream.skip(skip);
			}
			offset = 0;
			
			for (int x=0; x<16; x++) {
				dataInputStream.readFloat();
			}
			if (geometryType == GEOMETRY_TYPE_INSTANCE) {
				dataInputStream.readLong();
			} else if (geometryType == GEOMETRY_TYPE_TRIANGLES) {
				dataInputStream.readLong();
				minX = dataInputStream.readFloat();
				minY = dataInputStream.readFloat();
				minZ = dataInputStream.readFloat();
				maxX = dataInputStream.readFloat();
				maxY = dataInputStream.readFloat();
				maxZ = dataInputStream.readFloat();
				int nrIndices = dataInputStream.readInt();
				IntBuffer indices = readIntBuffer(dataInputStream, nrIndices);
				int nrVertices = dataInputStream.readInt();
				FloatBuffer vertices = readFloatBuffer(dataInputStream, nrVertices);
				int nrNormals = dataInputStream.readInt();
				FloatBuffer normals = readFloatBuffer(dataInputStream, nrNormals);
				int nrMaterials = dataInputStream.readInt();
				FloatBuffer materials = readFloatBuffer(dataInputStream, nrMaterials * 4);
				
				if (oidToUse == oid) {
					this.indices = indices;
					this.vertices = vertices;
					this.normals = normals;
					this.materials = materials;
				}
			}
		}
	}
	
	public float getMaxX() {
		return maxX;
	}
	
	public float getMaxY() {
		return maxY;
	}
	
	public float getMaxZ() {
		return maxZ;
	}

	public float getMinX() {
		return minX;
	}
	
	public float getMinY() {
		return minY;
	}
	
	public float getMinZ() {
		return minZ;
	}
	
	private ByteBuffer readBuffer(DataInputStream dataInputStream, int nrBytes) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(nrBytes);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		int read = dataInputStream.read(buffer.array());
		int totalRead = 0;
		while (read != -1 && totalRead < nrBytes) {
			totalRead += read;
			read = dataInputStream.read(buffer.array(), totalRead, nrBytes - totalRead);
		}
		return buffer;
	}
	
	private FloatBuffer readFloatBuffer(DataInputStream dataInputStream, int nrInts) throws IOException {
		FloatBuffer asFloatBuffer = readBuffer(dataInputStream, nrInts * 4).asFloatBuffer();
		return asFloatBuffer;
	}

	private IntBuffer readIntBuffer(DataInputStream dataInputStream, int nrFloats) throws IOException {
		return readBuffer(dataInputStream, nrFloats * 4).asIntBuffer();
	}

	public IntBuffer getIndices() {
		return indices;
	}
	
	public FloatBuffer getVertices() {
		return vertices;
	}
	
	public FloatBuffer getNormals() {
		return normals;
	}
	
	@Override
	public String toString() {
		return "Geometry [" + indices.capacity() + ", " + vertices.capacity() + ", " + normals.capacity() + "]";
	}
}