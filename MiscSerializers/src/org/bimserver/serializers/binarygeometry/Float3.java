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

import com.google.common.io.LittleEndianDataOutputStream;

public class Float3 {
	public float x;
	public float y;
	public float z;

	public Float3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void min(Float3 min) {
		if (min.x < this.x) {
			this.x = min.x;
		}
		if (min.y < this.y) {
			this.y = min.y;
		}
		if (min.z < this.z) {
			this.z = min.z;
		}
	}

	public void max(Float3 max) {
		if (max.x > this.x) {
			this.x = max.x;
		}
		if (max.y > this.y) {
			this.y = max.y;
		}
		if (max.z > this.z) {
			this.z = max.z;
		}
	}

	public void writeTo(LittleEndianDataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeFloat(x);
		dataOutputStream.writeFloat(y);
		dataOutputStream.writeFloat(z);
	}
}