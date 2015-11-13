package org.bimserver.ifc.step.serializer;

import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.ObjectProvider;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;

public class Ifc4StepStreamingSerializer extends IfcStepStreamingSerializer {

	public Ifc4StepStreamingSerializer(PluginConfiguration pluginConfiguration) {
		super(pluginConfiguration);
	}
	
	@Override
	public void init(ObjectProvider objectProvider, ProjectInfo projectInfo, IfcHeader ifcHeader, PluginManager pluginManager, PackageMetaData packageMetaData) throws SerializerException {
		setHeaderSchema("IFC4");
		super.init(objectProvider, projectInfo, ifcHeader, pluginManager, packageMetaData);
	}
}
