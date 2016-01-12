package org.bimserver.serializers.binarygeometry;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.interfaces.objects.SVector3f;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.serializers.MessagingStreamingSerializer;
import org.bimserver.plugins.serializers.ObjectProvider;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.HashMapWrappedVirtualObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.LittleEndianDataOutputStream;

public class BinaryGeometryMessagingStreamingSerializer implements MessagingStreamingSerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(BinaryGeometryMessagingStreamingSerializer.class);
	private static final byte FORMAT_VERSION = 7;
	
	private enum Mode {
		START,
		DATA,
		END
	}
	
	private enum MessageType {
		INIT((byte)0),
		GEOMETRY_TRIANGLES((byte)1),
		GEOMETRY_TRIANGLES_PARTED((byte)3),
		GEOMETRY_INFO((byte)5),
		END((byte)6);
		
		private byte id;

		private MessageType(byte id) {
			this.id = id;
		}
		
		public byte getId() {
			return id;
		}
	}

	private Mode mode = Mode.START;
	private long splitCounter = -1;
	private ObjectProvider objectProvider;
	private HashMapVirtualObject next;
	private ProjectInfo projectInfo;
	private LittleEndianDataOutputStream dataOutputStream;
	
	@Override
	public void init(ObjectProvider objectProvider, ProjectInfo projectInfo, PluginManagerInterface pluginManager, PackageMetaData packageMetaData) throws SerializerException {
		this.objectProvider = objectProvider;
		this.projectInfo = projectInfo;
	}

	@Override
	public boolean writeMessage(OutputStream outputStream, ProgressReporter progressReporter) throws IOException, SerializerException {
		dataOutputStream = new LittleEndianDataOutputStream(outputStream);
		switch (mode) {
		case START:
			if (!writeStart()) {
				mode = Mode.END;
				return true;
			}
			mode = Mode.DATA;
			break;
		case DATA:
			if (!writeData()) {
				mode = Mode.END;
				return true;
			}
			break;
		case END:
			writeEnd();
			return false;
		default:
			break;
		}
		return true;
	}
	
	private boolean writeEnd() throws IOException {
		dataOutputStream.write(MessageType.END.getId());
		return true;
	}
	
	private boolean writeStart() throws IOException {
		// Identifier for clients to determine if this server is even serving binary geometry
		dataOutputStream.writeByte(MessageType.INIT.getId());
		dataOutputStream.writeUTF("BGS");
		
		// Version of the current format being outputted, should be changed for every (released) change in protocol 
		dataOutputStream.writeByte(FORMAT_VERSION);
		
		int skip = 4 - (7 % 4);
		if(skip != 0 && skip != 4) {
			dataOutputStream.write(new byte[skip]);
		}

		SVector3f minBounds = projectInfo.getMinBounds();
		dataOutputStream.writeDouble(minBounds.getX());
		dataOutputStream.writeDouble(minBounds.getY());
		dataOutputStream.writeDouble(minBounds.getZ());
		SVector3f maxBounds = projectInfo.getMaxBounds();
		dataOutputStream.writeDouble(maxBounds.getX());
		dataOutputStream.writeDouble(maxBounds.getY());
		dataOutputStream.writeDouble(maxBounds.getZ());
		
		try {
			next = objectProvider.next();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		}

		return next != null;
	}
	
	private boolean writeData() throws IOException, SerializerException {
		if (next.eClass() == GeometryPackage.eINSTANCE.getGeometryInfo()) {
			Object transformation = next.eGet(next.eClass().getEStructuralFeature("transformation"));
			Object data = next.eGet(next.eClass().getEStructuralFeature("data"));
			dataOutputStream.writeByte(MessageType.GEOMETRY_INFO.getId());
			dataOutputStream.write(new byte[7]);
			dataOutputStream.writeLong(next.getRoid());
			dataOutputStream.writeLong(next.getOid());
			HashMapWrappedVirtualObject minBounds = (HashMapWrappedVirtualObject) next.eGet(next.eClass().getEStructuralFeature("minBounds"));
			HashMapWrappedVirtualObject maxBounds = (HashMapWrappedVirtualObject) next.eGet(next.eClass().getEStructuralFeature("maxBounds"));
			Double minX = (Double) minBounds.eGet("x");
			Double minY = (Double) minBounds.eGet("y");
			Double minZ = (Double) minBounds.eGet("z");
			Double maxX = (Double) maxBounds.eGet("x");
			Double maxY = (Double) maxBounds.eGet("y");
			Double maxZ = (Double) maxBounds.eGet("z");
			dataOutputStream.writeDouble(minX);
			dataOutputStream.writeDouble(minY);
			dataOutputStream.writeDouble(minZ);
			dataOutputStream.writeDouble(maxX);
			dataOutputStream.writeDouble(maxY);
			dataOutputStream.writeDouble(maxZ);
			dataOutputStream.write((byte[])transformation);
			dataOutputStream.writeLong((Long)data);
		} else if (next.eClass() == GeometryPackage.eINSTANCE.getGeometryData()) {
			EStructuralFeature indicesFeature = next.eClass().getEStructuralFeature("indices");
			EStructuralFeature verticesFeature = next.eClass().getEStructuralFeature("vertices");
			EStructuralFeature normalsFeature = next.eClass().getEStructuralFeature("normals");
			EStructuralFeature materialsFeature = next.eClass().getEStructuralFeature("materials");
			
			byte[] indices = (byte[])next.eGet(indicesFeature);
			byte[] vertices = (byte[])next.eGet(verticesFeature);
			byte[] normals = (byte[])next.eGet(normalsFeature);
			byte[] materials = (byte[])next.eGet(materialsFeature);

			int totalNrIndices = indices.length / 4;
			int maxIndexValues = 16389;

			if (totalNrIndices > maxIndexValues) {
				dataOutputStream.write(MessageType.GEOMETRY_TRIANGLES_PARTED.getId());
				dataOutputStream.write(new byte[3]);
				dataOutputStream.writeLong(next.getOid());
				
				// Split geometry, this algorithm - for now - just throws away all the reuse of vertices that might be there
				// Also, although usually the vertices buffers are too large, this algorithm is based on the indices, so we
				// probably are not cramming as much data as we can in each "part", but that's not really a problem I think

				int nrParts = (totalNrIndices + maxIndexValues - 1) / maxIndexValues;
				dataOutputStream.writeInt(nrParts);

				ByteBuffer indicesBuffer = ByteBuffer.wrap(indices);
				indicesBuffer.order(ByteOrder.LITTLE_ENDIAN);
				IntBuffer indicesIntBuffer = indicesBuffer.asIntBuffer();

				ByteBuffer vertexBuffer = ByteBuffer.wrap(vertices);
				vertexBuffer.order(ByteOrder.LITTLE_ENDIAN);
				FloatBuffer verticesFloatBuffer = vertexBuffer.asFloatBuffer();
				
				ByteBuffer normalsBuffer = ByteBuffer.wrap(normals);
				normalsBuffer.order(ByteOrder.LITTLE_ENDIAN);
				FloatBuffer normalsFloatBuffer = normalsBuffer.asFloatBuffer();
				
				for (int part=0; part<nrParts; part++) {
					long splitId = splitCounter--;
					dataOutputStream.writeLong(splitId);
					
					int indexCounter = 0;
					int upto = Math.min((part + 1) * maxIndexValues, totalNrIndices);
					dataOutputStream.writeInt(upto - part * maxIndexValues);
					for (int i=part * maxIndexValues; i<upto; i++) {
						dataOutputStream.writeInt(indexCounter++);
					}
					
					dataOutputStream.writeInt((upto - part * maxIndexValues) * 3);
					for (int i=part * maxIndexValues; i<upto; i+=3) {
						int oldIndex1 = indicesIntBuffer.get(i);
						int oldIndex2 = indicesIntBuffer.get(i+1);
						int oldIndex3 = indicesIntBuffer.get(i+2);
						dataOutputStream.writeFloat(verticesFloatBuffer.get(oldIndex1 * 3));
						dataOutputStream.writeFloat(verticesFloatBuffer.get(oldIndex1 * 3 + 1));
						dataOutputStream.writeFloat(verticesFloatBuffer.get(oldIndex1 * 3 + 2));
						dataOutputStream.writeFloat(verticesFloatBuffer.get(oldIndex2 * 3));
						dataOutputStream.writeFloat(verticesFloatBuffer.get(oldIndex2 * 3 + 1));
						dataOutputStream.writeFloat(verticesFloatBuffer.get(oldIndex2 * 3 + 2));
						dataOutputStream.writeFloat(verticesFloatBuffer.get(oldIndex3 * 3));
						dataOutputStream.writeFloat(verticesFloatBuffer.get(oldIndex3 * 3 + 1));
						dataOutputStream.writeFloat(verticesFloatBuffer.get(oldIndex3 * 3 + 2));
					}
					dataOutputStream.writeInt((upto - part * maxIndexValues) * 3);
					for (int i=part * maxIndexValues; i<upto; i+=3) {
						int oldIndex1 = indicesIntBuffer.get(i);
						int oldIndex2 = indicesIntBuffer.get(i+1);
						int oldIndex3 = indicesIntBuffer.get(i+2);
						
						dataOutputStream.writeFloat(normalsFloatBuffer.get(oldIndex1 * 3));
						dataOutputStream.writeFloat(normalsFloatBuffer.get(oldIndex1 * 3 + 1));
						dataOutputStream.writeFloat(normalsFloatBuffer.get(oldIndex1 * 3 + 2));
						dataOutputStream.writeFloat(normalsFloatBuffer.get(oldIndex2 * 3));
						dataOutputStream.writeFloat(normalsFloatBuffer.get(oldIndex2 * 3 + 1));
						dataOutputStream.writeFloat(normalsFloatBuffer.get(oldIndex2 * 3 + 2));
						dataOutputStream.writeFloat(normalsFloatBuffer.get(oldIndex3 * 3));
						dataOutputStream.writeFloat(normalsFloatBuffer.get(oldIndex3 * 3 + 1));
						dataOutputStream.writeFloat(normalsFloatBuffer.get(oldIndex3 * 3 + 2));
					}
					
					dataOutputStream.writeInt(0);
				}
			} else {
				dataOutputStream.write(MessageType.GEOMETRY_TRIANGLES.getId());
				dataOutputStream.write(new byte[7]);
				dataOutputStream.writeLong(next.getOid());

				ByteBuffer indicesBuffer = ByteBuffer.wrap(indices);
				dataOutputStream.writeInt(indicesBuffer.capacity() / 4);
				dataOutputStream.write(indicesBuffer.array());
				
				ByteBuffer vertexByteBuffer = ByteBuffer.wrap(vertices);
				dataOutputStream.writeInt(vertexByteBuffer.capacity() / 4);
				dataOutputStream.write(vertexByteBuffer.array());
				
				ByteBuffer normalsBuffer = ByteBuffer.wrap(normals);
				dataOutputStream.writeInt(normalsBuffer.capacity() / 4);
				dataOutputStream.write(normalsBuffer.array());
				
				// Only when materials are used we send them
				if (materials != null) {
					ByteBuffer materialsByteBuffer = ByteBuffer.wrap(materials);
					
					dataOutputStream.writeInt(materialsByteBuffer.capacity() / 4);
					dataOutputStream.write(materialsByteBuffer.array());
				} else {
					// No materials used
					dataOutputStream.writeInt(0);
				}
			}
		} else {
			LOGGER.info("Ignoring");
		}
		try {
			next = objectProvider.next();
		} catch (BimserverDatabaseException e) {
			throw new SerializerException(e);
		}
		return next != null;
	}
}