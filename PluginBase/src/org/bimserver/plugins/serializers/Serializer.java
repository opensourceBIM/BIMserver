package org.bimserver.plugins.serializers;

import java.io.OutputStream;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginManagerInterface;

/**
 * @author Ruben de Laat
 *	
 * A serializer serializes model data to a stream. Serializers can only be used once (in previous versions they could be use multiple times and had a reset() method).
 */
public interface Serializer extends StreamingReader {
	/**
	 * Initialize this serializer
	 * 
	 * @param model The model that will be serialized
	 * @param projectInfo ProjectInformation that is stored in the BIMserver project
	 * @param pluginManager PluginManager that can be used to call other plugins
	 * @param normalizeOids Whether to normalize the oids (usually means the oid will be regenerated from 1)
	 * @throws SerializerException
	 */
	void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManagerInterface pluginManager, boolean normalizeOids) throws SerializerException;

	/**
	 * @param outputStream The stream to write to
	 * @param progressReporter An interface you can use to report progress
	 * @throws SerializerException
	 */
	void writeToOutputStream(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException;
	
	/**
	 * @return Whether the results of this serializer can be cached by BIMserver, defaults to true
	 */
	default boolean allowCaching() {
		return true;
	}
}