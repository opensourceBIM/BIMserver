package org.bimserver.servlets;

import java.io.DataOutputStream;
import java.io.IOException;

import org.bimserver.models.ifc2x3tc1.Vector3f;

public class Bounds {
	public Float3 min;
	public Float3 max;

	public Bounds(Float3 min, Float3 max) {
		this.min = min;
		this.max = max;
	}

	public Bounds() {
		this.min = new Float3(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
		this.max = new Float3(-Float.MAX_VALUE, -Float.MAX_VALUE, -Float.MAX_VALUE);
	}

	public Bounds(Vector3f minBounds, Vector3f maxBounds) {
		this.min = new Float3(minBounds.getX(), minBounds.getY(), minBounds.getZ());
		this.max = new Float3(maxBounds.getX(), maxBounds.getY(), maxBounds.getZ());
	}

	public void integrate(Bounds objectBounds) {
		this.min.min(objectBounds.min);
		this.max.max(objectBounds.max);
	}

	public void writeTo(DataOutputStream dataOutputStream) throws IOException {
		min.writeTo(dataOutputStream);
		max.writeTo(dataOutputStream);
	}
}
