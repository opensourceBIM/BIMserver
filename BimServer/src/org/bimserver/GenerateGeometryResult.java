package org.bimserver;

import org.bimserver.models.geometry.Bounds;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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
	private double[] minUntranslated;
	private double[] maxUntranslated;

	public GenerateGeometryResult() {
		min = new double[]{Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};
		max = new double[]{-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE};
		minUntranslated = new double[]{Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};
		maxUntranslated = new double[]{-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE};
	}

	public double[] getMin() {
		return min;
	}
	
	public double[] getMax() {
		return max;
	}
	
	public Bounds getBoundsUntranslated() {
		Bounds bounds = GeometryFactory.eINSTANCE.createBounds();
		Vector3f min = GeometryFactory.eINSTANCE.createVector3f();
		min.setX(this.minUntranslated[0]);
		min.setY(this.minUntranslated[1]);
		min.setZ(this.minUntranslated[2]);
		
		Vector3f max = GeometryFactory.eINSTANCE.createVector3f();
		max.setX(this.maxUntranslated[0]);
		max.setY(this.maxUntranslated[1]);
		max.setZ(this.maxUntranslated[2]);
		
		bounds.setMin(min);
		bounds.setMax(max);
		
		return bounds;
	}
	
	public Bounds getBounds() {
		Bounds bounds = GeometryFactory.eINSTANCE.createBounds();
		Vector3f min = GeometryFactory.eINSTANCE.createVector3f();
		min.setX(this.min[0]);
		min.setY(this.min[1]);
		min.setZ(this.min[2]);
		
		Vector3f max = GeometryFactory.eINSTANCE.createVector3f();
		max.setX(this.max[0]);
		max.setY(this.max[1]);
		max.setZ(this.max[2]);
		
		bounds.setMin(min);
		bounds.setMax(max);
		
		return bounds;
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

	public double getUntranslatedMinX() {
		return minUntranslated[0];
	}
	
	public double getUntranslatedMinY() {
		return minUntranslated[1];
	}
	
	public double getUntranslatedMinZ() {
		return minUntranslated[2];
	}
	
	public double getUntranslatedMaxX() {
		return maxUntranslated[0];
	}
	
	public double getUntranslatedMaxY() {
		return maxUntranslated[1];
	}
	
	public double getUntranslatedMaxZ() {
		return maxUntranslated[2];
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

	public void setUntranslatedMinX(double value) {
		minUntranslated[0] = value;
	}
	
	public void setUntranslatedMinY(double value) {
		minUntranslated[1] = value;
	}
	
	public void setUntranslatedMinZ(double value) {
		minUntranslated[2] = value;
	}
	
	public void setUntranslatedMaxX(double value) {
		maxUntranslated[0] = value;
	}
	
	public void setUntranslatedMaxY(double value) {
		maxUntranslated[1] = value;
	}
	
	public void setUntranslatedMaxZ(double value) {
		maxUntranslated[2] = value;
	}
}