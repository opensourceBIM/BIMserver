package org.bimserver;

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

import java.util.ArrayList;
import java.util.List;

import org.bimserver.geometry.Density;
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
	private double[] minUntransformed;
	private double[] maxUntransformed;
	private float multiplierToMm;
	private List<Density> densities = new ArrayList<>();

	public GenerateGeometryResult() {
		min = new double[]{Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};
		max = new double[]{-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE};
		minUntransformed = new double[]{Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};
		maxUntransformed = new double[]{-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE};
	}

	public double[] getMin() {
		return min;
	}
	
	public double[] getMax() {
		return max;
	}
	
	public Bounds getBoundsUntransformed() {
		Bounds bounds = GeometryFactory.eINSTANCE.createBounds();
		Vector3f min = GeometryFactory.eINSTANCE.createVector3f();
		min.setX(this.minUntransformed[0]);
		min.setY(this.minUntransformed[1]);
		min.setZ(this.minUntransformed[2]);
		
		Vector3f max = GeometryFactory.eINSTANCE.createVector3f();
		max.setX(this.maxUntransformed[0]);
		max.setY(this.maxUntransformed[1]);
		max.setZ(this.maxUntransformed[2]);
		
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
		return minUntransformed[0];
	}
	
	public double getUntranslatedMinY() {
		return minUntransformed[1];
	}
	
	public double getUntranslatedMinZ() {
		return minUntransformed[2];
	}
	
	public double getUntranslatedMaxX() {
		return maxUntransformed[0];
	}
	
	public double getUntranslatedMaxY() {
		return maxUntransformed[1];
	}
	
	public double getUntranslatedMaxZ() {
		return maxUntransformed[2];
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
		minUntransformed[0] = value;
	}
	
	public void setUntranslatedMinY(double value) {
		minUntransformed[1] = value;
	}
	
	public void setUntranslatedMinZ(double value) {
		minUntransformed[2] = value;
	}
	
	public void setUntranslatedMaxX(double value) {
		maxUntransformed[0] = value;
	}
	
	public void setUntranslatedMaxY(double value) {
		maxUntransformed[1] = value;
	}
	
	public void setUntranslatedMaxZ(double value) {
		maxUntransformed[2] = value;
	}

	public void setMultiplierToMm(float multiplierToMm) {
		this.multiplierToMm = multiplierToMm;
	}
	
	public float getMultiplierToMm() {
		return multiplierToMm;
	}

	public synchronized void addDensity(Density density) {
		densities.add(density);
	}
	
	public List<Density> getDensities() {
		return densities;
	}
}