package org.bimserver.plugins.serializers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;

public interface Serializer {
	void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, RenderEnginePlugin renderEnginePlugin, PackageMetaData packageMetaData, boolean normalizeOids) throws SerializerException;
	void writeToFile(Path file, ProgressReporter progressReporter) throws SerializerException;
	byte[] getBytes();
	IfcModelInterface getModel();
	InputStream getInputStream() throws IOException;
	void writeToOutputStream(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException;

	/*
	 * The serializer must implement this method, but in most cases won't have
	 * to do anything. Only when reusing a serializer, this method can be used
	 * to cleanup/setup
	 */
	void reset();
	boolean allowCaching();
}