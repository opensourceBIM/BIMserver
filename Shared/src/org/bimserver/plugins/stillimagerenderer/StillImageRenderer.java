package org.bimserver.plugins.stillimagerenderer;

import java.io.IOException;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.ProgressHandler;
import org.openmali.vecmath2.Vector3f;

public interface StillImageRenderer {
	void init(IfcModelInterface model);
	byte[] snapshot(Vector3f cameraPosition, Vector3f upVector, Vector3f lookat, int width, int height, ProgressHandler progressHandler) throws IOException;
	byte[] snapshotFront(int width, int height, ProgressHandler progressHandler) throws IOException;
	byte[] snapshotLeft(int width, int height, ProgressHandler progressHandler) throws IOException;
	byte[] snapshotTop(int width, int height, ProgressHandler progressHandler) throws IOException;
	void close();
	Vector3f getCenter();
}