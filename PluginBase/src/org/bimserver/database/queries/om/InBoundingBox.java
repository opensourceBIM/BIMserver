package org.bimserver.database.queries.om;

/******************************************************************************
 * Copyright (C) 2009-2017  BIMserver.org
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
	private double x;
	private double y;
	private double z;
	private double width;
	private double height;
	private double depth;
	private boolean partial;

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
}