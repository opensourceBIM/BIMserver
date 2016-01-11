package org.bimserver.plugins.serializers;

import java.io.InputStream;
import java.io.OutputStream;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.plugins.PluginManagerInterface;

public interface StreamingSerializer {
	void init(ObjectProvider objectProvider, ProjectInfo projectInfo, IfcHeader ifcHeader, PluginManagerInterface pluginManager, PackageMetaData packageMetaData) throws SerializerException;
	void writeToOutputStream(OutputStream outputStream) throws SerializerException, BimserverDatabaseException;
	InputStream getInputStream();
}