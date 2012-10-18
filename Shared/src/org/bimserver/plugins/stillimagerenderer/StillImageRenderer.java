package org.bimserver.plugins.stillimagerenderer;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.ProgressHandler;
import org.openmali.vecmath2.Vector3f;

public interface StillImageRenderer {
	void init(IfcModelInterface model);
	byte[] snapshot(Vector3f cameraPosition, Vector3f upVector, Vector3f lookat, int width, int height, ProgressHandler progressHandler);
	byte[] snapshotFront(int width, int height, ProgressHandler progressHandler);
	byte[] snapshotLeft(int width, int height, ProgressHandler progressHandler);
	byte[] snapshotTop(int width, int height, ProgressHandler progressHandler);
	void close();
	Vector3f getCenter();
}