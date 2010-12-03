package org.bimserver.ifcengine;

import java.io.File;

public class IfcEngineFactory {
	private final File schemaFile;
	private final File nativeBaseDir;

	public IfcEngineFactory(File schemaFile, File nativeBaseDir) {
		this.schemaFile = schemaFile;
		this.nativeBaseDir = nativeBaseDir;
	}

	public FailSafeIfcEngine createFailSafeIfcEngine() throws IfcEngineException {
		return new FailSafeIfcEngine(schemaFile, nativeBaseDir);
	}
}