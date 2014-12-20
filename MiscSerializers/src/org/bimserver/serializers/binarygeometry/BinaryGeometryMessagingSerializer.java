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

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.io.LittleEndianDataOutputStream;

public class BinaryGeometryMessagingSerializer implements MessagingSerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(BinaryGeometryMessagingSerializer.class);
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
		GEOMETRY_INSTANCE((byte)2);
		
		private byte id;

		private MessageType(byte id) {
			this.id = id;
		}
		
		public byte getId() {
			return id;
		}
	}
	
	private Mode mode = Mode.START;
	private Set<Long> concreteGeometrySent;
	private Iterator<IdEObject> iterator;
	private PackageMetaData packageMetaData;

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
			writeStart(outputStream);
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
	
	private void writeStart(OutputStream outputStream) throws IOException {
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
				Bounds objectBounds = new Bounds(new Float3(geometryInfo.getMinBounds().getX(), geometryInfo.getMinBounds().getY(), geometryInfo.getMinBounds()
						.getZ()), new Float3(geometryInfo.getMaxBounds().getX(), geometryInfo.getMaxBounds().getY(), geometryInfo.getMaxBounds().getZ()));
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
		
		concreteGeometrySent = new HashSet<>();
		EClass productEClass = packageMetaData.getEClass("IfcProduct");
		iterator = model.getAllWithSubTypes(productEClass).iterator();
	}
	
	private boolean writeData(OutputStream outputStream) throws IOException {
		IdEObject ifcProduct = iterator.next();
		LittleEndianDataOutputStream dataOutputStream = new LittleEndianDataOutputStream(outputStream);
		GeometryInfo geometryInfo = (GeometryInfo) ifcProduct.eGet(ifcProduct.eClass().getEStructuralFeature("geometry"));
		if (geometryInfo != null && geometryInfo.getTransformation() != null) {
			GeometryData geometryData = geometryInfo.getData();
			MessageType geometryType = concreteGeometrySent.contains(geometryData.getOid()) ? MessageType.GEOMETRY_INSTANCE : MessageType.GEOMETRY_TRIANGLES;

			dataOutputStream.writeByte(geometryType.getId());
			dataOutputStream.writeUTF(ifcProduct.eClass().getName());
			Long roid = model.getRidRoidMap().get(ifcProduct.getRid());
			dataOutputStream.writeLong(roid);
			dataOutputStream.writeLong(ifcProduct.getOid());
			
			byte[] vertices = geometryData.getVertices();
			
			// BEWARE, ByteOrder is always LITTLE_ENDIAN, because that's what GPU's seem to prefer, Java's ByteBuffer default is BIG_ENDIAN though!
			
			// This is an ugly hack to align the bytes, but for 2 different kinds of output (this first one is the websocket implementation)
			int skip = 4 - ((3 + ifcProduct.eClass().getName().getBytes(Charsets.UTF_8).length) % 4);
			if(skip != 0 && skip != 4) {
				dataOutputStream.write(new byte[skip]);
			}
			
			dataOutputStream.write(geometryInfo.getTransformation());
			
			if (concreteGeometrySent.contains(geometryData.getOid())) {
				// Reused geometry, only send the id of the reused geometry data
				dataOutputStream.writeLong(geometryData.getOid());
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
		}
		return iterator.hasNext();
	}
}