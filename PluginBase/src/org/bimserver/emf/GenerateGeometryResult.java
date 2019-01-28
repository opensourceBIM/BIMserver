package org.bimserver.emf;

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

import org.bimserver.models.geometry.GeometryFactory;
import org.bimserver.models.geometry.Vector3f;

public class GenerateGeometryResult {

	private Vector3f min;
	private Vector3f max;

	public GenerateGeometryResult() {
		min = GeometryFactory.eINSTANCE.createVector3f();
		min.setX(Float.POSITIVE_INFINITY);
		min.setY(Float.POSITIVE_INFINITY);
		min.setZ(Float.POSITIVE_INFINITY);
		
		max = GeometryFactory.eINSTANCE.createVector3f();
		max.setX(Float.NEGATIVE_INFINITY);
		max.setY(Float.NEGATIVE_INFINITY);
		max.setZ(Float.NEGATIVE_INFINITY);
	}
	
	public Vector3f getMinBounds() {
		return min;
	}

	public Vector3f getMaxBounds() {
		return max;
	}
}
