package org.bimserver.geometry;

import java.util.HashSet;
import java.util.Set;

public class TransformedVertexNotMatching {

	private final Set<Mismatch> mismatches = new HashSet<>();
	private float biggestMismatch = -1;
	
	public void add(float[] transformedOriginal, float[] transformedNew, double[] productTranformationMatrix, double[] totalTranformationMatrix) {
		mismatches.add(new Mismatch(transformedOriginal, transformedNew, productTranformationMatrix, totalTranformationMatrix));
		for (int i=0; i<transformedOriginal.length; i++) {
			float a = transformedNew[i];
			float b = transformedOriginal[i];
			float diff = Math.abs(a - b);
			if (diff > biggestMismatch) {
				biggestMismatch = diff;
			}
		}
	}
	
	public float getBiggestMismatch() {
		return biggestMismatch;
	}

	public long size() {
		return mismatches.size();
	}
}
