package org.bimserver.plugins.ifcengine;

import java.io.File;

import org.bimserver.plugins.Plugin;

public interface IfcEnginePlugin extends Plugin {
	IfcEngine createIfcEngine(File schemaFile, File nativeBaseDir, File tempDir, String classPath) throws IfcEngineException;
}