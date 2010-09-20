package org.bimserver.ifcengine;

import java.io.File;

import org.bimserver.shared.ResourceFetcher;

public class IfcEngineFactory {
	private final File schemaFile;
	private final File nativeBaseDir;
	private final ResourceFetcher resourceFetcher;

	public IfcEngineFactory(File schemaFile, File nativeBaseDir, ResourceFetcher resourceFetcher) {
		this.schemaFile = schemaFile;
		this.nativeBaseDir = nativeBaseDir;
		this.resourceFetcher = resourceFetcher;
	}
	
	public FailSafeIfcEngine createFailSafeIfcEngine() throws IfcEngineException {
		return new FailSafeIfcEngine(schemaFile, nativeBaseDir, resourceFetcher);
	}
}
