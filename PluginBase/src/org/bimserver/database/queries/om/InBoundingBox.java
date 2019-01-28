package org.bimserver.database.queries.om;

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

import org.bimserver.geometry.AxisAlignedBoundingBox;

public class InBoundingBox extends PartOfQuery {
	private double x = Double.NaN;
	private double y = Double.NaN;
	private double z = Double.NaN;
	private double width = Double.NaN;
	private double height = Double.NaN;
	private double depth = Double.NaN;
	private boolean partial;
	private boolean useCenterPoint;
	private boolean excludeOctants;
	private Float densityLowerThreshold;
	private Float densityUpperThreshold;

	public InBoundingBox(double x, double y, double z, double width, double height, double depth) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	public InBoundingBox(AxisAlignedBoundingBox boundingBox) {
		this.x = boundingBox.getMin()[0];
		this.y = boundingBox.getMin()[1];
		this.z = boundingBox.getMin()[2];
		this.width = boundingBox.getMax()[0] - boundingBox.getMin()[0];
		this.height = boundingBox.getMax()[1] - boundingBox.getMin()[1];
		this.depth = boundingBox.getMax()[2] - boundingBox.getMin()[2];
	}

	public InBoundingBox() {
	}

	public double getDepth() {
		return depth;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	public void dump(int indent, StringBuilder sb) {
		sb.append(indent(indent) + "x: " + x + ", y: " + y + ", z: " + z + ", width: " + width + ", height: " + height + ", depth: " + depth);
	}

	public boolean isPartial() {
		return partial;
	}

	public void setPartial(boolean partial) {
		this.partial = partial;
	}

	public Float getDensityLowerThreshold() {
		return densityLowerThreshold;
	}

	public void setDensityLowerThreshold(Float densityLowerThreshold) {
		this.densityLowerThreshold = densityLowerThreshold;
	}

	public Float getDensityUpperThreshold() {
		return densityUpperThreshold;
	}

	public void setDensityUpperThreshold(Float densityUpperThreshold) {
		this.densityUpperThreshold = densityUpperThreshold;
	}

	public boolean isUseCenterPoint() {
		return useCenterPoint;
	}

	public void setUseCenterPoint(boolean useCenterPoint) {
		this.useCenterPoint = useCenterPoint;
	}

	public boolean isExcludeOctants() {
		return excludeOctants;
	}

	public void setExcludeOctants(boolean excludeOctants) {
		this.excludeOctants = excludeOctants;
	}
}