package org.bimserver.plugins.ifcengine;

import java.io.File;
import java.io.InputStream;

public interface IfcEngine {
	IfcEngineModel openModel(File ifcFile) throws IfcEngineException;
	IfcEngineModel openModel(InputStream inputStream, int size) throws IfcEngineException;
	IfcEngineModel openModel(byte[] bytes) throws IfcEngineException;
	void close();
}