package org.bimserver.geometry;

/******************************************************************************
 * Copyright (C) 2009-2019 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see
 * {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

public class Vector2D extends Vector0D {

	public static final Vector2D ZERO = null;

	public double x;
	public double y;

	public Vector2D(double d, double e) {
	}

	public Vector2D() {
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void y(double y) {
		this.y = y;
	}

	public void x(double x) {
		this.x = x;
	}

	@Override
	public double get(int index) {
		switch (index) {
		case 0:
			return x;
		case 1:
			return y;
		}
		return 0;
	}
}
