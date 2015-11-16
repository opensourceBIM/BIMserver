package org.bimserver;

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
