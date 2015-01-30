package org.bimserver.charting.Containers;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Locale;

import org.openmali.vecmath2.Vector2d;

public class Rectangle {
	public Double x1 = 0.0;
	public Double y1 = 0.0;
	public Double x2 = 0.0;
	public Double y2 = 0.0;

	/**
	 * @param p1
	 * @param p2
	 */
	public Rectangle(Vector2d p1, Vector2d p2) {
		super();
		x1 = p1.x();
		y1 = p1.y();
		x2 = p2.x();
		y2 = p2.y();
	}

	public Rectangle(Double x1, Double y1, Double x2, Double y2) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public Double x() {
		return x1;
	}

	public Double y() {
		return y1;
	}

	public Double x2() {
		return x2;
	}

	public Double y2() {
		return y2;
	}

	public Rectangle getMinimumAndMaximumComponents(Rectangle other) {
		return new Rectangle(
			Math.min(x1, other.x1),
			Math.min(y1, other.y1),
			Math.max(x2, other.x2),
			Math.max(y2, other.y2)
		);
	}

	public Vector2d getCenter() {
		return new Vector2d((x1 + x2) / 2.0, (y1 + y2) / 2.0);
	}

	@Override
	public String toString() {
		return String.format(Locale.US, "P1(%s, %s), P2(%s, %s)", x1, y1, x2, y2);
	}
}
