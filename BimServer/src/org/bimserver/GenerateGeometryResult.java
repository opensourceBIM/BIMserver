package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

import org.bimserver.models.geometry.GeometryFactory;
import org.bimserver.models.geometry.Vector3f;

public class GenerateGeometryResult {

	private double[] min;
	private double[] max;

	public GenerateGeometryResult() {
		min = new double[3];
		max = new double[3];
	}

	public double[] getMin() {
		return min;
	}
	
	public double[] getMax() {
		return max;
	}
	
	public Vector3f getMinBoundsAsVector3f() {
		Vector3f min = GeometryFactory.eINSTANCE.createVector3f();
		min.setX(this.min[0]);
		min.setY(this.min[1]);
		min.setZ(this.min[2]);
		return min;
	}

	public Vector3f getMaxBoundsAsVector3f() {
		Vector3f max = GeometryFactory.eINSTANCE.createVector3f();
		max.setX(this.max[0]);
		max.setY(this.max[1]);
		max.setZ(this.max[2]);
		return max;
	}

	public double getMinX() {
		return min[0];
	}

	public double getMinY() {
		return min[1];
	}
	
	public double getMinZ() {
		return min[2];
	}

	public double getMaxX() {
		return max[0];
	}
	
	public double getMaxY() {
		return max[1];
	}

	public double getMaxZ() {
		return max[2];
	}

	public void setMinX(double value) {
		min[0] = value;
	}
	
	public void setMinY(double value) {
		min[1] = value;
	}
	
	public void setMinZ(double value) {
		min[2] = value;
	}
	
	public void setMaxX(double value) {
		max[0] = value;
	}
	
	public void setMaxY(double value) {
		max[1] = value;
	}
	
	public void setMaxZ(double value) {
		max[2] = value;
	}
}