package org.bimserver.plugins.serializers;

import java.io.OutputStream;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.plugins.PluginManager;

public interface StreamingSerializer {
	void init(ObjectProvider objectProvider, ProjectInfo projectInfo, IfcHeader ifcHeader, PluginManager pluginManager, PackageMetaData packageMetaData) throws SerializerException;
	void writeToOutputStream(OutputStream outputStream) throws SerializerException, BimserverDatabaseException;
}