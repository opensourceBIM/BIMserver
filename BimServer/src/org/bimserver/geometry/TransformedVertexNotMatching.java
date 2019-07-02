package org.bimserver.geometry;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

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
