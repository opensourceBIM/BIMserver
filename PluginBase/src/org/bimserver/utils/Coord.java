package org.bimserver.utils;

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

public class Coord {
	private double x;
	private double y;
	private double z;

	public Coord(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Coord(double value) {
		x = value;
		y = value;
		z = value;
	}

	public double[] asVector() {
		return new double[]{x, y, z, 1};
	}

	public void setVector(double[] result) {
		x = result[0];
		y = result[1];
		z = result[2];
	}

	public double get(int i) {
		if (i == 0) {
			return x;
		} else if (i == 1) {
			return y;
		} else if (i == 2) {
			return z;
		}
		return 0;
	}

	public void set(int i, double d) {
		if (i == 0) {
			x = d;
		} else if (i == 1) {
			y = d;
		} else if (i == 2) {
			z = d;
		}
	}
}
