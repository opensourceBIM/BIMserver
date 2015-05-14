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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.geometry.GeometryData;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.MessagingSerializer;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.eclipse.emf.ecore.EClass;

import com.google.common.base.Charsets;
import com.google.common.io.LittleEndianDataOutputStream;

public class BinaryGeometryMessagingSerializer implements MessagingSerializer {
	private static final byte FORMAT_VERSION = 6;
	private IfcModelInterface model;
	
	private enum Mode {
		START,
		DATA,
		END
	}
	
	private enum MessageType {
		INIT((byte)0),
		GEOMETRY_TRIANGLES((byte)1),
		GEOMETRY_INSTANCE((byte)2),
		GEOMETRY_TRIANGLES_PARTED((byte)3),
		GEOMETRY_INSTANCE_PARTED((byte)4);
		
		private byte id;

		private MessageType(byte id) {
			this.id = id;
		}
		
		public byte getId() {
			return id;
		}
	}
	
	private Mode mode = Mode.START;
	private Map<Long, Object> concreteGeometrySent;
	private Iterator<IdEObject> iterator;
	private PackageMetaData packageMetaData;
	private long splitCounter = -1;

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, RenderEnginePlugin renderEnginePlugin,
			PackageMetaData packageMetaData, boolean normalizeOids) throws SerializerException {
				this.model = model;
				this.packageMetaData = packageMetaData;
	}

	@Override
	public boolean writeMessage(OutputStream outputStream, ProgressReporter progressReporter) throws IOException {
		switch (mode) {
		case START:
			if (!writeStart(outputStream)) {
				mode = Mode.END;
				return false;
			}
			mode = Mode.DATA;
			break;
		case DATA:
			if (!writeData(outputStream)) {
				mode = Mode.END;
				return false;
			}
			break;
		case END:
			return false;
		default:
			break;
		}
		return true;
	}
	
	private boolean writeStart(OutputStream outputStream) throws IOException {
		LittleEndianDataOutputStream dataOutputStream = new LittleEndianDataOutputStream(outputStream);
		// Identifier for clients to determine if this server is even serving binary geometry
		dataOutputStream.writeByte(MessageType.INIT.getId());
		dataOutputStream.writeUTF("BGS");
		
		// Version of the current format being outputted, should be changed for every (released) change in protocol 
		dataOutputStream.writeByte(FORMAT_VERSION);
		
		Bounds modelBounds = new Bounds();
		int nrObjects = 0;
		
		// All access to EClass is being done generically to support multiple IFC schema's with 1 serializer
		EClass productClass = model.getPackageMetaData().getEClass("IfcProduct");
		
		List<IdEObject> products = model.getAllWithSubTypes(productClass);
		
		// First iteration, to determine number of objects with geometry and calculate model bounds
		for (IdEObject ifcProduct : products) {
			GeometryInfo geometryInfo = (GeometryInfo) ifcProduct.eGet(ifcProduct.eClass().getEStructuralFeature("geometry"));
			if (geometryInfo != null && geometryInfo.getTransformation() != null) {
				Bounds objectBounds = new Bounds(
						new Float3(
							geometryInfo.getMinBounds().getX(), 
							geometryInfo.getMinBounds().getY(), 
							geometryInfo.getMinBounds().getZ()), 
						new Float3(
							geometryInfo.getMaxBounds().getX(), 
							geometryInfo.getMaxBounds().getY(), 
							geometryInfo.getMaxBounds().getZ()));
				modelBounds.integrate(objectBounds);
				nrObjects++;
			}
		}
		
		int skip = 4 - (7 % 4);
		if(skip != 0 && skip != 4) {
			dataOutputStream.write(new byte[skip]);
		}
		
		modelBounds.writeTo(dataOutputStream);
		dataOutputStream.writeInt(nrObjects);
		
		concreteGeometrySent = new HashMap<Long, Object>();
		EClass productEClass = packageMetaData.getEClass("IfcProduct");
		iterator = model.getAllWithSubTypes(productEClass).iterator();
		
		return nrObjects > 0;
	}
	
	@SuppressWarnings("unchecked")
	private boolean writeData(OutputStream outputStream) throws IOException {
		IdEObject ifcProduct = iterator.next();
		LittleEndianDataOutputStream dataOutputStream = new LittleEndianDataOutputStream(outputStream);
		GeometryInfo geometryInfo = (GeometryInfo) ifcProduct.eGet(ifcProduct.eClass().getEStructuralFeature("geometry"));
		if (geometryInfo != null && geometryInfo.getTransformation() != null) {
			GeometryData geometryData = geometryInfo.getData();
			
			int totalNrIndices = geometryData.getIndices().length / 4;
			int maxIndexValues = 16389;
			
			Object reuse = concreteGeometrySent.get(geometryData.getOid());
			MessageType messageType = null;
			if (reuse == null) {
				if (totalNrIndices > maxIndexValues) {
					messageType = MessageType.GEOMETRY_TRIANGLES_PARTED;
				} else {
					messageType = MessageType.GEOMETRY_TRIANGLES;
				}
			} else {
				if (reuse instanceof List) {
					messageType = MessageType.GEOMETRY_INSTANCE_PARTED;
				} else {
					messageType = MessageType.GEOMETRY_INSTANCE;
				}
			}
			dataOutputStream.writeByte(messageType.getId());
			dataOutputStream.writeUTF(ifcProduct.eClass().getName());
			Long roid = model.getPidRoidMap().get(ifcProduct.getPid());
			dataOutputStream.writeLong(roid);
			dataOutputStream.writeLong(ifcProduct.getOid());
			
			// BEWARE, ByteOrder is always LITTLE_ENDIAN, because that's what GPU's seem to prefer, Java's ByteBuffer default is BIG_ENDIAN though!
			
			int skip = 4 - ((3 + ifcProduct.eClass().getName().getBytes(Charsets.UTF_8).length) % 4);
			if(skip != 0 && skip != 4) {
				dataOutputStream.write(new byte[skip]);
			}
			
			dataOutputStream.write(geometryInfo.getTransformation());
			
			if (reuse != null && reuse instanceof Long) {
				// Reused geometry, only send the id of the reused geometry data
				dataOutputStream.writeLong(geometryData.getOid());
			} else if (reuse != null && reuse instanceof List) {
				List<Long> list = (List<Long>)reuse;
				dataOutputStream.writeInt(list.size());
				for (long coreId : list) {
					dataOutputStream.writeLong(coreId);
				}
			} else {
				if (totalNrIndices > maxIndexValues) {
					// Split geometry, this algorithm - for now - just throws away all the reuse of vertices that might be there
					// Also, although usually the vertices buffers are too large, this algorithm is based on the indices, so we
					// probably are not cramming as much data as we can in each "part", but that's not really a problem I think

					int nrParts = (totalNrIndices + maxIndexValues - 1) / maxIndexValues;
					dataOutputStream.writeInt(nrParts);

					Bounds objectBounds = new Bounds(geometryInfo.getMinBounds(), geometryInfo.getMaxBounds());
					objectBounds.writeTo(dataOutputStream);

					ByteBuffer indicesBuffer = ByteBuffer.wrap(geometryData.getIndices());
					indicesBuffer.order(ByteOrder.LITTLE_ENDIAN);
					IntBuffer indicesIntBuffer = indicesBuffer.asIntBuffer();

					ByteBuffer vertexBuffer = ByteBuffer.wrap(geometryData.getVertices());
					vertexBuffer.order(ByteOrder.LITTLE_ENDIAN);
					FloatBuffer verticesFloatBuffer = vertexBuffer.asFloatBuffer();
					
					ByteBuffer normalsBuffer = ByteBuffer.wrap(geometryData.getNormals());
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
					Bounds objectBounds = new Bounds(geometryInfo.getMinBounds(), geometryInfo.getMaxBounds());
					objectBounds.writeTo(dataOutputStream);
					
					dataOutputStream.writeLong(geometryData.getOid());
					
					ByteBuffer indicesBuffer = ByteBuffer.wrap(geometryData.getIndices());
					dataOutputStream.writeInt(indicesBuffer.capacity() / 4);
					dataOutputStream.write(indicesBuffer.array());
					
					ByteBuffer vertexByteBuffer = ByteBuffer.wrap(geometryData.getVertices());
					dataOutputStream.writeInt(vertexByteBuffer.capacity() / 4);
					dataOutputStream.write(vertexByteBuffer.array());
					
					ByteBuffer normalsBuffer = ByteBuffer.wrap(geometryData.getNormals());
					dataOutputStream.writeInt(normalsBuffer.capacity() / 4);
					dataOutputStream.write(normalsBuffer.array());
					
					// Only when materials are used we send them
					if (geometryData.getMaterials() != null) {
						ByteBuffer materialsByteBuffer = ByteBuffer.wrap(geometryData.getMaterials());
						
						dataOutputStream.writeInt(materialsByteBuffer.capacity() / 4);
						dataOutputStream.write(materialsByteBuffer.array());
					} else {
						// No materials used
						dataOutputStream.writeInt(0);
					}
					List<Long> arrayList = new ArrayList<Long>();
					arrayList.add(geometryData.getOid());
					concreteGeometrySent.put(geometryData.getOid(), arrayList);
				}
			}
		}
		return iterator.hasNext();
	}
}