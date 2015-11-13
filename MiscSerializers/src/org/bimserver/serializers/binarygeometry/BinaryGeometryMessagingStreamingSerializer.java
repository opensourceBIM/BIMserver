package org.bimserver.serializers.binarygeometry;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Iterator;
import java.util.Map;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.MessagingStreamingSerializer;
import org.bimserver.plugins.serializers.ObjectProvider;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.HashMapWrappedVirtualObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.io.LittleEndianDataOutputStream;

public class BinaryGeometryMessagingStreamingSerializer implements MessagingStreamingSerializer {
	private static final byte FORMAT_VERSION = 7;
	
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
		GEOMETRY_INSTANCE_PARTED((byte)4),
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
	private Map<Long, Object> concreteGeometrySent;
	private Iterator<IdEObject> iterator;
	private PackageMetaData packageMetaData;
	private long splitCounter = -1;
	private ObjectProvider objectProvider;
	private HashMapVirtualObject next;
	private Bounds modelBounds;
	
	@Override
	public void init(ObjectProvider objectProvider, ProjectInfo projectInfo, PluginManager pluginManager, PackageMetaData packageMetaData) throws SerializerException {
		this.objectProvider = objectProvider;
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
				return true;
			}
			break;
		case END:
			writeEnd(outputStream);
			return false;
		default:
			break;
		}
		return true;
	}
	
	private boolean writeEnd(OutputStream outputStream) throws IOException {
		outputStream.write(MessageType.END.getId());
		return true;
	}
	
	private boolean writeStart(OutputStream outputStream) throws IOException {
		LittleEndianDataOutputStream dataOutputStream = new LittleEndianDataOutputStream(outputStream);
		// Identifier for clients to determine if this server is even serving binary geometry
		dataOutputStream.writeByte(MessageType.INIT.getId());
		dataOutputStream.writeUTF("BGS");
		
		// Version of the current format being outputted, should be changed for every (released) change in protocol 
		dataOutputStream.writeByte(FORMAT_VERSION);
		
		int skip = 4 - (7 % 4);
		if(skip != 0 && skip != 4) {
			dataOutputStream.write(new byte[skip]);
		}

//		modelBounds.writeTo(dataOutputStream);
//		dataOutputStream.writeInt(nrObjects);
		
//		concreteGeometrySent = new HashMap<Long, Object>();

		try {
			next = objectProvider.next();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		}

		return next != null;
	}
	
	private boolean writeData(OutputStream outputStream) throws IOException {
		System.out.println(next.getOid());
		LittleEndianDataOutputStream dataOutputStream = new LittleEndianDataOutputStream(outputStream);
		if (next.eClass() == GeometryPackage.eINSTANCE.getGeometryInfo()) {
			Object transformation = next.eGet(next.eClass().getEStructuralFeature("transformation"));
			Object data = next.eGet(next.eClass().getEStructuralFeature("data"));
			dataOutputStream.writeByte(MessageType.GEOMETRY_INFO.getId());
			dataOutputStream.write(new byte[3]);
			dataOutputStream.writeLong(next.getRoid());
			dataOutputStream.writeLong(next.getOid());
			HashMapWrappedVirtualObject minBounds = (HashMapWrappedVirtualObject) next.eGet(next.eClass().getEStructuralFeature("minBounds"));
			HashMapWrappedVirtualObject maxBounds = (HashMapWrappedVirtualObject) next.eGet(next.eClass().getEStructuralFeature("minBounds"));
			Float minX = (Float) minBounds.eGet("x");
			Float minY = (Float) minBounds.eGet("y");
			Float minZ = (Float) minBounds.eGet("z");
			Float maxX = (Float) maxBounds.eGet("x");
			Float maxY = (Float) maxBounds.eGet("y");
			Float maxZ = (Float) maxBounds.eGet("z");
			dataOutputStream.writeFloat(minX);
			dataOutputStream.writeFloat(minY);
			dataOutputStream.writeFloat(minZ);
			dataOutputStream.writeFloat(maxX);
			dataOutputStream.writeFloat(maxY);
			dataOutputStream.writeFloat(maxZ);
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

//				Bounds objectBounds = new Bounds(geometryInfo.getMinBounds(), geometryInfo.getMaxBounds());
//				objectBounds.writeTo(dataOutputStream);

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
				dataOutputStream.write(new byte[3]);
				dataOutputStream.writeLong(next.getOid());

//				Bounds objectBounds = new Bounds(geometryInfo.getMinBounds(), geometryInfo.getMaxBounds());
//				objectBounds.writeTo(dataOutputStream);
				
//				dataOutputStream.writeLong(geometryData.getOid());
				
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
//				List<Long> arrayList = new ArrayList<Long>();
//				arrayList.add(geometryData.getOid());
//				concreteGeometrySent.put(geometryData.getOid(), arrayList);
			}
		} else if (packageMetaData.getEClass("IfcProduct").isSuperTypeOf(next.eClass())) {
			Object geometry = next.eGet(next.eClass().getEStructuralFeature("geometry"));
			if (geometry != null) {
				// TODO indicate what's coming
				dataOutputStream.writeLong(next.getOid());
				dataOutputStream.writeLong((Long)geometry);
			}
		} else {
			// Ignore
		}
//		GeometryInfo geometryInfo = (GeometryInfo) ifcProduct.eGet(ifcProduct.eClass().getEStructuralFeature("geometry"));
//		if (geometryInfo != null && geometryInfo.getTransformation() != null) {
//			GeometryData geometryData = geometryInfo.getData();
			
//			int totalNrIndices = geometryData.getIndices().length / 4;
//			int maxIndexValues = 16389;
//			
//			Object reuse = concreteGeometrySent.get(geometryData.getOid());
//			MessageType messageType = null;
//			if (reuse == null) {
//				if (totalNrIndices > maxIndexValues) {
//					messageType = MessageType.GEOMETRY_TRIANGLES_PARTED;
//				} else {
//					messageType = MessageType.GEOMETRY_TRIANGLES;
//				}
//			} else {
//				if (reuse instanceof List) {
//					messageType = MessageType.GEOMETRY_INSTANCE_PARTED;
//				} else {
//					messageType = MessageType.GEOMETRY_INSTANCE;
//				}
//			}
//			dataOutputStream.writeByte(messageType.getId());
//			dataOutputStream.writeUTF(ifcProduct.eClass().getName());
//			dataOutputStream.writeLong(roid);
//			dataOutputStream.writeLong(ifcProduct.getOid());
			
			// BEWARE, ByteOrder is always LITTLE_ENDIAN, because that's what GPU's seem to prefer, Java's ByteBuffer default is BIG_ENDIAN though!
			
//			int skip = 4 - 3;
//			int skip = 4 - ((3 + ifcProduct.eClass().getName().getBytes(Charsets.UTF_8).length) % 4);
//			if(skip != 0 && skip != 4) {
//				dataOutputStream.write(new byte[skip]);
//			}
//			
//			dataOutputStream.write(geometryInfo.getTransformation());
//			
//			if (reuse != null && reuse instanceof Long) {
//				// Reused geometry, only send the id of the reused geometry data
//				dataOutputStream.writeLong(geometryData.getOid());
//			} else if (reuse != null && reuse instanceof List) {
//				List<Long> list = (List<Long>)reuse;
//				dataOutputStream.writeInt(list.size());
//				for (long coreId : list) {
//					dataOutputStream.writeLong(coreId);
//				}
//			} else {
//
//			}
//		}
		try {
			next = objectProvider.next();
		} catch (BimserverDatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return next != null;
	}
}