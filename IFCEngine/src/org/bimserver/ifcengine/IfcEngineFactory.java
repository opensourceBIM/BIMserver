package org.bimserver.ifcengine;

import java.io.File;

public class IfcEngineFactory {
	private final File schemaFile;
	private final File nativeBaseDir;
	private final String classPath;

	public IfcEngineFactory(File schemaFile, File nativeBaseDir, String classPath) {
		this.schemaFile = schemaFile;
		this.nativeBaseDir = nativeBaseDir;
		this.classPath = classPath;
	}

	public FailSafeIfcEngine createFailSafeIfcEngine() throws IfcEngineException {
		return new FailSafeIfcEngine(schemaFile, nativeBaseDir, classPath);
	}
}