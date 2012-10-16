package org.bimserver.plugins.stillimagerenderer;

import org.bimserver.emf.IfcModelInterface;
import org.openmali.vecmath2.Vector3f;

public interface StillImageRenderer {
	void init(IfcModelInterface model);
	byte[] snapshot(Vector3f cameraPosition, Vector3f upVector, Vector3f lookat, int width, int height);
	byte[] snapshotFront(int width, int height);
	byte[] snapshotLeft(int width, int height);
	byte[] snapshotTop(int width, int height);
	Vector3f getCenter();
}
