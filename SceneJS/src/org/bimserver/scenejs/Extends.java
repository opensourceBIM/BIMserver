package org.bimserver.scenejs;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import java.util.Arrays;

import org.bimserver.models.store.Bounds;

public class Extends {
	public float[] min = { Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };
	public float[] max = { Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY };
	
	public void addToMinExtents(float[] vertex) {
		for (int i=0; i<vertex.length; i++) {
			min[i] = Math.min(vertex[i], min[i]);
		}
	}
	
	public void addToMaxExtents(float[] vertex) {
		for (int i=0; i<vertex.length; i++) {
			max[i] = Math.max(vertex[i], max[i]);
		}
	}
	
	@Override
	public String toString() {
		return "min: " + Arrays.toString(min) + ", max: " + Arrays.toString(max);
	}

	public void integrate(Bounds bounds) {
		addToMinExtents(new float[]{bounds.getMin().getX(), bounds.getMin().getY(), bounds.getMin().getZ()});
		addToMaxExtents(new float[]{bounds.getMax().getX(), bounds.getMax().getY(), bounds.getMax().getZ()});
	}
}