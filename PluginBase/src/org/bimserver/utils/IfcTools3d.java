package org.bimserver.utils;

import org.bimserver.models.geometry.Bounds;

public class IfcTools3d {
	public static float getVolume(Bounds bounds) {
		return (float) ((bounds.getMax().getX() - bounds.getMin().getX()) * (bounds.getMax().getY() - bounds.getMin().getY()) * (bounds.getMax().getZ() * bounds.getMin().getZ()));
	}

	public static float getArea(Bounds bounds) {
		return (float) ((bounds.getMax().getX() - bounds.getMin().getX()) * (bounds.getMax().getY() - bounds.getMin().getY()));
	}
}
