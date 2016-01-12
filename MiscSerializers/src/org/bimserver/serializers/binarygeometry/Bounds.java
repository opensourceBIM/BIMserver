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

import org.bimserver.models.geometry.Vector3f;

import com.google.common.io.LittleEndianDataOutputStream;

public class Bounds {
	public Double3 min;
	public Double3 max;

	public Bounds(Double3 min, Double3 max) {
		this.min = min;
		this.max = max;
	}

	public Bounds() {
		this.min = new Double3(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
		this.max = new Double3(-Float.MAX_VALUE, -Float.MAX_VALUE, -Float.MAX_VALUE);
	}

	public Bounds(Vector3f minBounds, Vector3f maxBounds) {
		this.min = new Double3(minBounds.getX(), minBounds.getY(), minBounds.getZ());
		this.max = new Double3(maxBounds.getX(), maxBounds.getY(), maxBounds.getZ());
	}

	public void integrate(Bounds objectBounds) {
		this.min.min(objectBounds.min);
		this.max.max(objectBounds.max);
	}

	public void writeTo(LittleEndianDataOutputStream dataOutputStream) throws IOException {
		min.writeTo(dataOutputStream);
		max.writeTo(dataOutputStream);
	}
}