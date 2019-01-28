package org.bimserver.plugins.stillimagerenderer;

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

import java.io.IOException;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.ProgressHandler;
import org.bimserver.utils.Vector3f;

public interface StillImageRenderer {
	void init(IfcModelInterface model) throws StillImageRendererException;
	byte[] snapshot(Vector3f cameraPosition, Vector3f upVector, Vector3f lookat, int width, int height, ProgressHandler progressHandler) throws IOException;
	byte[] snapshotFront(int width, int height, ProgressHandler progressHandler) throws IOException;
	byte[] snapshotLeft(int width, int height, ProgressHandler progressHandler) throws IOException;
	byte[] snapshotTop(int width, int height, ProgressHandler progressHandler) throws IOException;
	void close();
	Vector3f getCenter();
}