package org.bimserver.ifc.step.serializer;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;

public class Ifc4StepSerializer extends IfcStepSerializer {

	public Ifc4StepSerializer(PluginConfiguration pluginConfiguration) {
		super(pluginConfiguration);
	}
	
	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, RenderEnginePlugin renderEnginePlugin, PackageMetaData packageMetaData, boolean normalizeOids) throws SerializerException {
		try {
			setSchema(pluginManager.requireSchemaDefinition("ifc4"));
			setHeaderSchema("IFC4");
		} catch (PluginException e) {
			throw new SerializerException(e);
		}
		super.init(model, projectInfo, pluginManager, renderEnginePlugin, packageMetaData, normalizeOids);
	}
}