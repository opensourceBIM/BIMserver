package org.bimserver.servlets;

import java.io.DataOutputStream;
import java.io.IOException;

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

	public void integrate(Bounds objectBounds) {
		this.min.min(objectBounds.min);
		this.max.max(objectBounds.max);
	}

	public void writeTo(DataOutputStream dataOutputStream) throws IOException {
		min.writeTo(dataOutputStream);
		max.writeTo(dataOutputStream);
	}
}
