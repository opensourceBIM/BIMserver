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

public class Vector2d {

	public static final Vector2d ZERO = null;
	
	public double x;
	public double y;
	public double z;

	public Vector2d(double d, double e) {
		// TODO Auto-generated constructor stub
	}

	public Vector2d() {
		// TODO Auto-generated constructor stub
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

	public void y(double y) {
		this.y = y;
	}
	
	public void z(double z) {
		this.z = z;
	}
	
	public void x(double x) {
		this.x = x;
	}

	public void sub(Vector2d center) {
		// TODO Auto-generated method stub
		
	}
}
