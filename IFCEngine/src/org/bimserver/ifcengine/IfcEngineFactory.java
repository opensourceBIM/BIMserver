package org.bimserver.ifcengine;

import java.io.File;

public class IfcEngineFactory {
	private final File schemaFile;
	private final File nativeBaseDir;
	private final String classPath;
	private final File tempDir;

	public IfcEngineFactory(File schemaFile, File nativeBaseDir, File tempDir, String classPath) {
		this.schemaFile = schemaFile;
		this.nativeBaseDir = nativeBaseDir;
		this.tempDir = tempDir;
		this.classPath = classPath;
	}

	public FailSafeIfcEngine createFailSafeIfcEngine() throws IfcEngineException {
		return new FailSafeIfcEngine(schemaFile, nativeBaseDir, tempDir, classPath);
	}
}