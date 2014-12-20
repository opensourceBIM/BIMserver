package org.bimserver.plugins.serializers;

import java.io.IOException;
import java.io.OutputStream;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;

public interface MessagingSerializer {
	void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, RenderEnginePlugin renderEnginePlugin, PackageMetaData packageMetaData, boolean normalizeOids) throws SerializerException;
	/**
	 * @param streamingSocketInterface This is where you write your messages to
	 * @param progressReporter Report any available progress to the progressReporter
	 * @return true if there are more messages, false if there are no more
	 * @throws IOException
	 */
	boolean writeMessage(OutputStream outputStream, ProgressReporter progressReporter) throws IOException;
}