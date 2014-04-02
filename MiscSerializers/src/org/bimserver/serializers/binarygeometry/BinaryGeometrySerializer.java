package org.bimserver.serializers.binarygeometry;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.models.ifc2x3tc1.GeometryData;
import org.bimserver.models.ifc2x3tc1.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.plugins.serializers.AbstractGeometrySerializer;
import org.bimserver.plugins.serializers.AligningOutputStream;
import org.bimserver.plugins.serializers.SerializerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinaryGeometrySerializer extends AbstractGeometrySerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(BinaryGeometrySerializer.class);
	private static final byte FORMAT_VERSION = 4;
	private static final byte GEOMETRY_TYPE_TRIANGLES = 0;
	private static final byte GEOMETRY_TYPE_INSTANCE = 1;

	@Override
	public void reset() {
		setMode(Mode.BODY);
	}

	@Override
	protected boolean write(OutputStream outputStream) throws SerializerException {
		if (getMode() == Mode.BODY) {
			try {
				calculateGeometryExtents();
				writeGeometries(outputStream);
			} catch (Exception e) {
				LOGGER.error("", e);
			}
			setMode(Mode.FINISHED);
			return true;
		} else if (getMode() == Mode.FINISHED) {
			return false;
		}
		return false;
	}

	private void writeGeometries(OutputStream outputStream) throws IOException {
		long start = System.nanoTime();

		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		dataOutputStream.writeUTF("BGS");
		dataOutputStream.writeByte(FORMAT_VERSION);
		
		Bounds modelBounds = new Bounds();
		int nrObjects = 0;
		
		List<IfcProduct> products = getModel().getAllWithSubTypes(IfcProduct.class);
		
		for (IfcProduct ifcProduct : products) {
			GeometryInfo geometryInfo = ifcProduct.getGeometry();
			if (geometryInfo != null) {
				Bounds objectBounds = new Bounds(new Float3(geometryInfo.getMinBounds().getX(), geometryInfo.getMinBounds().getY(), geometryInfo.getMinBounds()
						.getZ()), new Float3(geometryInfo.getMaxBounds().getX(), geometryInfo.getMaxBounds().getY(), geometryInfo.getMaxBounds().getZ()));
				modelBounds.integrate(objectBounds);
				nrObjects++;
			}
		}
		modelBounds.writeTo(dataOutputStream);
		dataOutputStream.writeInt(nrObjects);
		int bytesSaved = 0;
		int bytesTotal = 0;
		
		Set<Long> concreteGeometrySent = new HashSet<>();
		
		dataOutputStream.flush();
		
		int counter = 0;
		
		for (IfcProduct ifcProduct : products) {
			GeometryInfo geometryInfo = ifcProduct.getGeometry();
			if (geometryInfo != null && geometryInfo.getTransformation() != null) {
				dataOutputStream.writeUTF(ifcProduct.eClass().getName());
				dataOutputStream.writeLong(ifcProduct.getOid());

				GeometryData geometryData = geometryInfo.getData();
				byte[] vertices = geometryData.getVertices();
				
				// BEWARE, ByteOrder is always LITTLE_ENDIAN, because that's what GPU's seem to prefer, Java's ByteBuffer default is BIG_ENDIAN though!
				
				bytesTotal += vertices.length;
				byte geometryType = concreteGeometrySent.contains(geometryData.getOid()) ? GEOMETRY_TYPE_INSTANCE : GEOMETRY_TYPE_TRIANGLES;
				dataOutputStream.write(geometryType);

				if (outputStream instanceof AligningOutputStream) {
					((AligningOutputStream)outputStream).align4();
				} else {
					int skip = 4 - (dataOutputStream.size() % 4);
					if(skip != 0 && skip != 4) {
						dataOutputStream.write(new byte[skip]);
					}
				}
				
				dataOutputStream.write(geometryInfo.getTransformation());

				if (concreteGeometrySent.contains(geometryData.getOid())) {
					dataOutputStream.writeLong(geometryData.getOid());
					bytesSaved += vertices.length;
				} else {
					ByteBuffer vertexByteBuffer = ByteBuffer.wrap(vertices);
					dataOutputStream.writeLong(geometryData.getOid());

					Bounds objectBounds = new Bounds(geometryInfo.getMinBounds(), geometryInfo.getMaxBounds());
					objectBounds.writeTo(dataOutputStream);

					ByteBuffer indicesBuffer = ByteBuffer.wrap(geometryData.getIndices());
					dataOutputStream.writeInt(indicesBuffer.capacity() / 4);
					dataOutputStream.write(indicesBuffer.array());
					
					dataOutputStream.writeInt(vertexByteBuffer.capacity() / 4);
					dataOutputStream.write(vertexByteBuffer.array());
					
					ByteBuffer normalsBuffer = ByteBuffer.wrap(geometryData.getNormals());
					dataOutputStream.writeInt(normalsBuffer.capacity() / 4);
					dataOutputStream.write(normalsBuffer.array());

					ByteBuffer materialIndexByteBuffer = ByteBuffer.wrap(geometryData.getMaterialIndices());
					materialIndexByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
					IntBuffer materialIndicesBuffer = materialIndexByteBuffer.asIntBuffer();
					ByteBuffer materialsByteBuffer = ByteBuffer.wrap(geometryData.getMaterials());
					materialsByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
					FloatBuffer materialsBuffer = materialsByteBuffer.asFloatBuffer();
					dataOutputStream.writeInt(materialIndicesBuffer.capacity() * 3);
					for (int i=0; i<materialIndicesBuffer.capacity(); i++) {
						int materialIndex = materialIndicesBuffer.get(i);
						if (materialIndex == -1) {
							ByteBuffer test = ByteBuffer.wrap(new byte[16]);
							test.order(ByteOrder.LITTLE_ENDIAN);
							FloatBuffer fl = test.asFloatBuffer();
							fl.put(1f);
							fl.put(0f);
							fl.put(0f);
							fl.put(1f);
							for (int j=0; j<3; j++) {
								dataOutputStream.write(test.array());
							}
						} else {
							float r = materialsBuffer.get(materialIndex);
							float g = materialsBuffer.get(materialIndex + 1);
							float b = materialsBuffer.get(materialIndex + 2);
							float a = materialsBuffer.get(materialIndex + 3);
							ByteBuffer test = ByteBuffer.wrap(new byte[16]);
							test.order(ByteOrder.LITTLE_ENDIAN);
							FloatBuffer fl = test.asFloatBuffer();
							fl.put(r);
							fl.put(g);
							fl.put(b);
							fl.put(a);
							for (int j=0; j<3; j++) {
								dataOutputStream.write(test.array());
							}
						}
					}
					
					concreteGeometrySent.add(geometryData.getOid());
				}
			}
			counter++;
			if (counter % 12 == 0) {
				dataOutputStream.flush();
			}
		}
		dataOutputStream.flush();
		if (bytesTotal != 0 && bytesSaved != 0) {
			LOGGER.debug((100 * bytesSaved / bytesTotal) + "% saved");
		}
		long end = System.nanoTime();
		LOGGER.debug(((end - start) / 1000000) + " ms");
	}
}