package org.bimserver.plugins.ifcengine;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcEngineFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcEngineFactory.class);
	private IfcEnginePlugin ifcEnginePlugin;
	private final File schemaFile;
	private final File nativeBaseDir;
	private final File tempDir;
	private final String classPath;
	
	public IfcEngineFactory(File schemaFile, File nativeBaseDir, File tempDir, String classPath, IfcEnginePlugin ifcEnginePlugin) {
		this.schemaFile = schemaFile;
		this.nativeBaseDir = nativeBaseDir;
		this.tempDir = tempDir;
		this.classPath = classPath;
		this.ifcEnginePlugin = ifcEnginePlugin;
	}
	
	public IfcEngine createIfcEngine() throws IfcEngineException {
		return ifcEnginePlugin.createIfcEngine(schemaFile, nativeBaseDir, tempDir, classPath);
	}
}