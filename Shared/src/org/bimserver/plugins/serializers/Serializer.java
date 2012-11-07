package org.bimserver.plugins.serializers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngine;

public interface Serializer {
	void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, IfcEngine ifcEngine, boolean normalizeOids) throws SerializerException;
	void writeToFile(File file) throws SerializerException;
	byte[] getBytes();
	IfcModelInterface getModel();
	InputStream getInputStream() throws IOException;
	void writeToOutputStream(OutputStream outputStream) throws SerializerException;
	void reset();
}