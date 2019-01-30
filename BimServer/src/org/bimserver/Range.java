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

public class Range {

	private double[] reusableFirstVertex;
	private double[] reusableLastVertex;
	private long geometryDataOid = -1;

	public Range(double[] reusableFirstVertex, double[] reusableLastVertex) {
		this.reusableFirstVertex = reusableFirstVertex;
		this.reusableLastVertex = reusableLastVertex;
	}
	
	public void setGeometryDataOid(long geometryDataOid) {
		this.geometryDataOid = geometryDataOid;
	}

	public boolean isSimilar(Range range) {
		double[] diff1 = new double[]{range.reusableFirstVertex[0] - reusableFirstVertex[0], range.reusableFirstVertex[1] - reusableFirstVertex[1], range.reusableFirstVertex[2] - reusableFirstVertex[2]};
		double[] diff2 = new double[]{range.reusableLastVertex[0] - reusableLastVertex[0], range.reusableLastVertex[1] - reusableLastVertex[1], range.reusableLastVertex[2] - reusableLastVertex[2]};
		return diff1[0] == diff2[0] && diff1[1] == diff2[1] && diff1[2] == diff2[2];
	}
	
	public double[] getOffset(Range other) {
		return new double[]{other.reusableFirstVertex[0] - reusableFirstVertex[0], other.reusableFirstVertex[1] - reusableFirstVertex[1], other.reusableFirstVertex[2] - reusableFirstVertex[2]};
	}
	
	public long getGeometryDataOid() {
		return geometryDataOid;
	}
}
