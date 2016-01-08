package org.bimserver.serializers;

import java.io.InputStream;
import java.io.OutputStream;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.SharedJsonStreamingSerializer;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.serializers.ObjectProvider;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.StreamingSerializer;

public class StreamingJsonSerializer implements StreamingSerializer {

	private ObjectProvider objectProvider;
	private ProjectInfo projectInfo;
	private IfcHeader ifcHeader;
	private PluginManagerInterface pluginManager;
	private PackageMetaData packageMetaData;

	@Override
	public void init(ObjectProvider objectProvider, ProjectInfo projectInfo, IfcHeader ifcHeader, PluginManagerInterface pluginManager, PackageMetaData packageMetaData) throws SerializerException {
		System.out.println(objectProvider);
		this.objectProvider = objectProvider;
		this.projectInfo = projectInfo;
		this.ifcHeader = ifcHeader;
		this.pluginManager = pluginManager;
		this.packageMetaData = packageMetaData;
	}

	@Override
	public void writeToOutputStream(OutputStream outputStream) throws SerializerException, BimserverDatabaseException {
		SharedJsonStreamingSerializer sharedJsonStreamingSerializer = new SharedJsonStreamingSerializer(objectProvider, ifcHeader, true);
		
		boolean result = sharedJsonStreamingSerializer.write(outputStream);
		while (result) {
			result = sharedJsonStreamingSerializer.write(outputStream);
		}
	}

	@Override
	public InputStream getInputStream() {
		return null;
	}
}