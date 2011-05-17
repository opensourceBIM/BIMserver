package org.bimserver.plugins.ifcengine;

import java.io.File;

import org.bimserver.plugins.BimPlugin;

public interface IfcEnginePlugin extends BimPlugin {
	IfcEngine createIfcEngine(File schemaFile, File nativeBaseDir, File tempDir, String classPath) throws IfcEngineException;
}