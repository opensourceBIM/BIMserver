package org.bimserver.client;

import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.impl.IfcProductImpl;

public class IfcProductFaker extends IfcProductImpl {
	@Override
	public GeometryInfo getGeometry() {
		GeometryInfo geometryInfo = super.getGeometry();
		if (geometryInfo == null) {
			
		}
		return geometryInfo;
	}
}
