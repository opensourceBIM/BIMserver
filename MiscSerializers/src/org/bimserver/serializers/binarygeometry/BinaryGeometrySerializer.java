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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.models.geometry.GeometryData;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.plugins.serializers.AbstractGeometrySerializer;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.SerializerException;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.io.LittleEndianDataOutputStream;

@Deprecated
public class BinaryGeometrySerializer extends AbstractGeometrySerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(BinaryGeometrySerializer.class);
	private static final byte FORMAT_VERSION = 6;
	private static final byte GEOMETRY_TYPE_TRIANGLES = 0;
	private static final byte GEOMETRY_TYPE_INSTANCE = 1;

	@Override
	public void reset() {
		setMode(Mode.BODY);
	}

	@Override
	protected boolean write(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException {
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

		LittleEndianDataOutputStream dataOutputStream = new LittleEndianDataOutputStream(outputStream);
		// Identifier for clients to determine if this server is even serving binary geometry
		dataOutputStream.writeUTF("BGS");
		
		// Version of the current format being outputted, should be changed for every (released) change in protocol 
		dataOutputStream.writeByte(FORMAT_VERSION);
		
		Bounds modelBounds = new Bounds();
		int nrObjects = 0;
		
		// All access to EClass is being done generically to support multiple IFC schema's with 1 serializer
		EClass productClass = getModel().getPackageMetaData().getEClass("IfcProduct");
		
		List<IdEObject> products = getModel().getAllWithSubTypes(productClass);
		
		// First iteration, to determine number of objects with geometry and calculate model bounds
		for (IdEObject ifcProduct : products) {
			GeometryInfo geometryInfo = (GeometryInfo) ifcProduct.eGet(ifcProduct.eClass().getEStructuralFeature("geometry"));
			if (geometryInfo != null && geometryInfo.getTransformation() != null) {
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
		
		// Keeping track of geometry already sent, this can be used for instancing of reused geometry
		Set<Long> concreteGeometrySent = new HashSet<>();
		
		// Flushing here so the client can show progressbar etc...
		dataOutputStream.flush();
		
		int bytes = 6;
		int counter = 0;
		
		// Second iteration actually writing the geometry
		for (IdEObject ifcProduct : products) {
			GeometryInfo geometryInfo = (GeometryInfo) ifcProduct.eGet(ifcProduct.eClass().getEStructuralFeature("geometry"));
			if (geometryInfo != null && geometryInfo.getTransformation() != null) {
				String type = ifcProduct.eClass().getName();
				dataOutputStream.writeUTF(type);
				dataOutputStream.writeLong(ifcProduct.getOid());

				GeometryData geometryData = geometryInfo.getData();
				byte[] vertices = geometryData.getVertices();
				
				// BEWARE, ByteOrder is always LITTLE_ENDIAN, because that's what GPU's seem to prefer, Java's ByteBuffer default is BIG_ENDIAN though!
				
				bytesTotal += vertices.length;
				byte geometryType = concreteGeometrySent.contains(geometryData.getOid()) ? GEOMETRY_TYPE_INSTANCE : GEOMETRY_TYPE_TRIANGLES;
				dataOutputStream.write(geometryType);
				
				bytes += (type.getBytes(Charsets.UTF_8).length + 3);
				
				// This is an ugly hack to align the bytes, but for 2 different kinds of output (this first one is the websocket implementation)
				int skip = 4 - (bytes % 4); // TODO fix
				if(skip != 0 && skip != 4) {
					dataOutputStream.write(new byte[skip]);
				}
				
				bytes = 0;
				
				dataOutputStream.write(geometryInfo.getTransformation());
				
				if (concreteGeometrySent.contains(geometryData.getOid())) {
					// Reused geometry, only send the id of the reused geometry data
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
					
					// Only when materials are used we send them
					if (geometryData.getMaterials() != null) {
						ByteBuffer materialsByteBuffer = ByteBuffer.wrap(geometryData.getMaterials());
						
						dataOutputStream.writeInt(materialsByteBuffer.capacity() / 4);
						dataOutputStream.write(materialsByteBuffer.array());
					} else {
						// No materials used
						dataOutputStream.writeInt(0);
					}
					
					concreteGeometrySent.add(geometryData.getOid());
				}
				counter++;
				if (counter % 12 == 0) {
					// Flushing in batches, this is to limit the amount of WebSocket messages
					dataOutputStream.flush();
				}
			}
		}
		dataOutputStream.flush();
		if (bytesTotal != 0 && bytesSaved != 0) {
			LOGGER.info((100 * bytesSaved / bytesTotal) + "% saved");
		}
		long end = System.nanoTime();
		LOGGER.debug(((end - start) / 1000000) + " ms");
	}
}
