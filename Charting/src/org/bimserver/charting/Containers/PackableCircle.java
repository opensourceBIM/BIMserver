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

import org.openmali.vecmath2.Vector2d;

import prefuse.data.Node;

public class PackableCircle {

	public Vector2d Location = null;
	public double Radius;
	public boolean Filled = false;
	//
	public Node Next = null;
	public Node Current = null;
	public Node Previous = null;

	public PackableCircle() {
	}

	public PackableCircle(Vector2d location, double radius) {
		this.Location = location;
		this.Radius = radius;
	}

	public Rectangle getBounds() {
		return new Rectangle(Location.x() - Radius, Location.y() - Radius, Location.x() + Radius, Location.y() + Radius);
	}

	public Rectangle getComponentMinimumAndMaximum(PackableCircle other) {
		Rectangle thisBounds = getBounds();
		Rectangle otherBounds = other.getBounds();
		return thisBounds.getMinimumAndMaximumComponents(otherBounds);
	}

	public double getDiameter() {
		return Radius * 2;
	}
}