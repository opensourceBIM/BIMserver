package org.bimserver.servlets;

import java.io.DataOutputStream;
import java.io.IOException;

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

	public void writeTo(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeFloat(x);
		dataOutputStream.writeFloat(y);
		dataOutputStream.writeFloat(z);
	}
}