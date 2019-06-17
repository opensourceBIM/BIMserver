package org.bimserver.database.queries;

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

import org.bimserver.interfaces.objects.SBounds;
import org.bimserver.interfaces.objects.SVector3f;
import org.bimserver.models.geometry.GeometryFactory;
import org.bimserver.models.geometry.Vector3f;

public class Bounds {
	private double minX;
	private double minY;
	private double minZ;
	private double maxX;
	private double maxY;
	private double maxZ;

	public Bounds() {
		minX = Double.MAX_VALUE;
		minY = Double.MAX_VALUE;
		minZ = Double.MAX_VALUE;
		maxX = -Double.MAX_VALUE;
		maxY = -Double.MAX_VALUE;
		maxZ = -Double.MAX_VALUE;
	}
	
	public Bounds(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
		this.minX = minX;
		this.minY = minY;
		this.minZ = minZ;
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxZ = maxZ;
	}

	public Bounds(org.bimserver.models.geometry.Bounds bounds) {
		this.minX = bounds.getMin().getX();
		this.minY = bounds.getMin().getY();
		this.minZ = bounds.getMin().getZ();
		this.maxX = bounds.getMax().getX();
		this.maxY = bounds.getMax().getY();
		this.maxZ = bounds.getMax().getZ();
	}
	
	public Bounds(SBounds bounds) {
		this.minX = bounds.getMin().getX();
		this.minY = bounds.getMin().getY();
		this.minZ = bounds.getMin().getZ();
		this.maxX = bounds.getMax().getX();
		this.maxY = bounds.getMax().getY();
		this.maxZ = bounds.getMax().getZ();
	}

	public double getMinX() {
		return minX;
	}
	
	public double getMaxX() {
		return maxX;
	}
	
	public double getMaxY() {
		return maxY;
	}
	
	public double getMaxZ() {
		return maxZ;
	}
	
	public double getMinY() {
		return minY;
	}
	
	public double getMinZ() {
		return minZ;
	}

	public Bounds offset(int x, int y, int z) {
		return new Bounds(
			minX + (x == 1 ? getHalfWidth() : 0), 
			minY + (y == 1 ? getHalfHeight() : 0), 
			minZ + (z == 1 ? getHalfDepth() : 0), 
			maxX - (x == 0 ? getHalfWidth() : 0), 
			maxY - (y == 0 ? getHalfHeight() : 0), 
			maxZ - (z == 0 ? getHalfDepth() : 0));
	}

	public boolean within(Bounds bounds) {
		return getMinX() >= bounds.getMinX() && getMinY() >= bounds.getMinY() && getMinZ() >= bounds.getMinZ() && getMaxX() < bounds.getMaxX() && getMaxY() < bounds.getMaxY() && getMaxZ() < bounds.getMaxZ();
	}

	public void integrate(org.bimserver.models.geometry.Bounds bounds) {
		if (bounds.getMin().getX() < minX) {
			minX = bounds.getMin().getX();
		}
		if (bounds.getMin().getY() < minY) {
			minY = bounds.getMin().getY();
		}
		if (bounds.getMin().getZ() < minZ) {
			minZ = bounds.getMin().getZ();
		}
		if (bounds.getMax().getX() > maxX) {
			maxX = bounds.getMax().getX();
		}
		if (bounds.getMax().getY() > maxY) {
			maxY = bounds.getMax().getY();
		}
		if (bounds.getMax().getZ() > maxZ) {
			maxZ = bounds.getMax().getZ();
		}
	}
	
	@Override
	public String toString() {
		return minX + ", " + minY + ", " + minZ + " -- " + maxX + ", " + maxY + ", " + maxZ + " -- " + getWidth() + "x" + getHeight() + "x" + getDepth();
	}

	public double getWidth() {
		return getMaxX() - getMinX();
	}
	
	public double getHeight() {
		return getMaxY() - getMinY();
	}
	
	public double getDepth() {
		return getMaxZ() - getMinZ();
	}
	
	public double getHalfWidth() {
		return (getMaxX() - getMinX()) / 2f;
	}

	public double getHalfHeight() {
		return (getMaxY() - getMinY()) / 2f;
	}
	
	public double getHalfDepth() {
		return (getMaxZ() - getMinZ()) / 2f;
	}

	public void integrate(Bounds bounds) {
		if (bounds.getMinX() < minX) {
			minX = bounds.getMinX();
		}
		if (bounds.getMinY() < minY) {
			minY = bounds.getMinY();
		}
		if (bounds.getMinZ() < minZ) {
			minZ = bounds.getMinZ();
		}
		if (bounds.getMaxX() > maxX) {
			maxX = bounds.getMaxX();
		}
		if (bounds.getMaxY() > maxY) {
			maxY = bounds.getMaxY();
		}
		if (bounds.getMaxZ() > maxZ) {
			maxZ = bounds.getMaxZ();
		}
	}

	public Bounds scale(Bounds from, Bounds to) {
		
		return null;
	}

	public org.bimserver.models.geometry.Bounds toDbBounds() {
		org.bimserver.models.geometry.Bounds bounds = GeometryFactory.eINSTANCE.createBounds();
		Vector3f min = GeometryFactory.eINSTANCE.createVector3f();
		min.setX(getMinX());
		min.setY(getMinY());
		min.setZ(getMinZ());
		Vector3f max = GeometryFactory.eINSTANCE.createVector3f();
		max.setX(getMaxX());
		max.setY(getMaxY());
		max.setZ(getMaxZ());
		bounds.setMin(min);
		bounds.setMax(max);
		return bounds;
	}

	public SBounds toSBounds() {
		SBounds bounds = new SBounds();
		SVector3f min = new SVector3f();
		min.setX(getMinX());
		min.setY(getMinY());
		min.setZ(getMinZ());
		SVector3f max = new SVector3f();
		max.setX(getMaxX());
		max.setY(getMaxY());
		max.setZ(getMaxZ());
		bounds.setMin(min);
		bounds.setMax(max);
		return bounds;
	}
}
