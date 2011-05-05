package org.bimserver.clients.j3d;

import javax.media.j3d.TransformGroup;

import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3.IfcRoot;

public interface IfcEngine {
	void createTriangles(IfcRoot ifcRootObject, IfcModel ifcModel, TransformGroup buildingTransformGroup);
}