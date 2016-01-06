package org.bimserver.serializers.binarygeometry;

import java.io.IOException;

import com.google.common.io.LittleEndianDataOutputStream;

public class Double3 {
	public double x;
	public double y;
	public double z;

	public Double3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void min(Double3 min) {
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

	public void max(Double3 max) {
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
		dataOutputStream.writeDouble(x);
		dataOutputStream.writeDouble(y);
		dataOutputStream.writeDouble(z);
	}
}