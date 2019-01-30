package org.bimserver.geometry;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

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

public class DebuggingInfo {

	private double[] productTranformationMatrix;
	private FloatBuffer vertices;
	private IntBuffer indices;

	public DebuggingInfo(double[] productTranformationMatrix, IntBuffer indices, FloatBuffer vertices) {
		this.productTranformationMatrix = productTranformationMatrix;
		this.indices = indices;
		this.vertices = vertices;
	}

	public FloatBuffer getVertices() {
		return vertices;
	}
	
	public IntBuffer getIndices() {
		return indices;
	}
	
	public double[] getProductTranformationMatrix() {
		return productTranformationMatrix;
	}
}