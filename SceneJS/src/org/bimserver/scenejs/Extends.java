package org.bimserver.scenejs;

import java.util.Arrays;

import org.bimserver.models.store.Bounds;

public class Extends {
	public float[] min = { Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };
	public float[] max = { Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY };
	
	public void addToMinExtents(float[] vertex) {
		for (int i=0; i<vertex.length; i++) {
			min[i] = Math.min(vertex[i], min[i]);
		}
	}
	
	public void addToMaxExtents(float[] vertex) {
		for (int i=0; i<vertex.length; i++) {
			max[i] = Math.max(vertex[i], max[i]);
		}
	}
	
	@Override
	public String toString() {
		return "min: " + Arrays.toString(min) + ", max: " + Arrays.toString(max);
	}

	public void integrate(Bounds bounds) {
		addToMinExtents(new float[]{bounds.getMin().getX(), bounds.getMin().getY(), bounds.getMin().getZ()});
		addToMaxExtents(new float[]{bounds.getMax().getX(), bounds.getMax().getY(), bounds.getMax().getZ()});
	}
}