package org.bimserver.ifc.step.serializer;

import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.ObjectProvider;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;

public class Ifc2x3tc1StepStreamingSerializer extends IfcStepStreamingSerializer {

	public Ifc2x3tc1StepStreamingSerializer(PluginConfiguration pluginConfiguration) {
		super(pluginConfiguration);
	}
	
	@Override
	public void init(ObjectProvider objectProvider, ProjectInfo projectInfo, IfcHeader ifcHeader, PluginManager pluginManager, PackageMetaData packageMetaData) throws SerializerException {
		setHeaderSchema("IFC2X3");
		super.init(objectProvider, projectInfo, ifcHeader, pluginManager, packageMetaData);
	}
}