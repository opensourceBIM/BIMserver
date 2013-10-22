package org.bimserver.serializers.binarygeometry;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import org.bimserver.models.ifc2x3tc1.GeometryData;
import org.bimserver.models.ifc2x3tc1.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcSlab;
import org.bimserver.models.ifc2x3tc1.IfcSlabTypeEnum;
import org.bimserver.plugins.serializers.AbstractGeometrySerializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinaryGeometrySerializer extends AbstractGeometrySerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(BinaryGeometrySerializer.class);
	private static final byte FORMAT_VERSION = 1;

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
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		dataOutputStream.writeUTF("BGS");
		dataOutputStream.writeByte(FORMAT_VERSION);
		
		Bounds modelBounds = new Bounds();
		int nrObjects = 0;
		for (IfcProduct ifcProduct : getModel().getAllWithSubTypes(IfcProduct.class)) {
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
		for (IfcProduct ifcProduct : getModel().getAllWithSubTypes(IfcProduct.class)) {
			GeometryInfo geometryInfo = ifcProduct.getGeometry();
			if (geometryInfo != null) {
				if (ifcProduct instanceof IfcSlab && ((IfcSlab) ifcProduct).getPredefinedType() == IfcSlabTypeEnum.ROOF) {
					dataOutputStream.writeUTF("IfcRoof");
				} else {
					dataOutputStream.writeUTF(ifcProduct.eClass().getName());
				}
				dataOutputStream.writeLong(ifcProduct.getOid());
				
				Bounds objectBounds = new Bounds(geometryInfo.getMinBounds(), geometryInfo.getMaxBounds());
				objectBounds.writeTo(dataOutputStream);
				
				GeometryData geometryData = geometryInfo.getData();
				byte[] vertices = geometryData.getVertices();
				dataOutputStream.writeInt(vertices.length);
				
				ByteBuffer buffer = ByteBuffer.wrap(vertices);
				convertOrder(buffer);
				dataOutputStream.write(buffer.array());
				
				byte[] normals = geometryData.getNormals();
				dataOutputStream.writeInt(normals.length);
				
				buffer = ByteBuffer.wrap(normals);
				convertOrder(buffer);
				dataOutputStream.write(buffer.array());
			}
		}
		dataOutputStream.flush();
	}
	
	private void convertOrder(ByteBuffer input) {
		input.position(0);
		for (int i = 0; i < input.capacity(); i += 4) {
			input.order(ByteOrder.BIG_ENDIAN);
			float x = input.getFloat();
			input.order(ByteOrder.nativeOrder());
			input.position(input.position() - 4);
			input.putFloat(x);
		}
		input.position(0);
	}
}