package org.bimserver.collada;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.models.ifc2x3tc1.IfcProduct;

public class ColladaConfiguration {
	public List<IfcProduct> exportedObjects = new ArrayList<IfcProduct>();
	// Off: Don't define the default light; don't include the default light in the visual scene. 
	public boolean wantLights = true;
	// Off: Don't calculate camera; don't include camera definition; don't add to the visual scene.
	public boolean wantCameras = true;
	// Off: Don't store any geometry; don't add any geometry nodes to the visual scene.
	public boolean wantGeometry = true;

	// Provide a means by which the serializer can choose only certain objects to add to the Collada file.
	public ColladaConfiguration(List<IfcProduct> exportedObjects) {
		super();
		this.exportedObjects = exportedObjects;
	}

	// Provide a means by which the serializer can choose only certain objects, whether there are lights, whether there are cameras, and whether the geometry will be used (for anything other than camera calculations).
	public ColladaConfiguration(List<IfcProduct> exportedObjects, boolean wantLights, boolean wantCameras, boolean wantGeometry) {
		super();
		this.exportedObjects = exportedObjects;
		this.wantLights = wantLights;
		this.wantCameras = wantCameras;
		this.wantGeometry = wantGeometry;
	}
}
