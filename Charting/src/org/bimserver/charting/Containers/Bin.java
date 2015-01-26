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

import java.util.ArrayList;
import java.util.Collection;

import org.openmali.vecmath2.Vector2d;

/**
 * Intended to contain data values by ID (i.e. "0-20"), such that length can be queried.
 */
public class Bin extends ArrayList<Vector2d> {

	// Previously called (x, y) in d3-hexbins.
	public Vector2d Location = Vector2d.ZERO;
	// Previously called (i, j) in d3-hexbins.
	public Vector2d WorldSpaceLocation = Vector2d.ZERO;

	/**
	 * 
	 */
	public Bin() {
		super();
	}

	/**
	 * @param c
	 */
	public Bin(Collection<? extends Vector2d> c) {
		super(c);
	}

	/**
	 * @param initialCapacity
	 */
	public Bin(int initialCapacity) {
		super(initialCapacity);
	}
}
