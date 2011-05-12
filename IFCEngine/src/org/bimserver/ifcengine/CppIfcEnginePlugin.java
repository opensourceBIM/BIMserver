package org.bimserver.ifcengine;

import java.io.File;

import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.mangosdk.spi.ProviderFor;

@ProviderFor(value=IfcEnginePlugin.class)
public class CppIfcEnginePlugin implements IfcEnginePlugin {

	@Override
	public String getName() {
		return "CppIfcEnginePlugin";
	}
	
	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init() {
	}

	@Override
	public String getDescription() {
		return "Native implementation of an IFC Engine";
	}

	@Override
	public IfcEngine createIfcEngine(File schemaFile, File nativeBaseDir, File tempDir, String classPath) throws IfcEngineException {
		return new FailSafeIfcEngine(schemaFile, nativeBaseDir, tempDir, classPath);
	}
}