package org.bimserver.test.framework.actions;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class DownloadModelLowLevel extends Action {

	public DownloadModelLowLevel(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException, PublicInterfaceNotFoundException {
		SRevision randomRevision = virtualUser.getRandomRevision();
		if (randomRevision != null) {
			IfcModelInterface model;
			try {
				SProject project = virtualUser.getBimServerClient().getBimsie1ServiceInterface().getProjectByPoid(randomRevision.getProjectId());
				model = virtualUser.getBimServerClient().getModel(project, randomRevision.getOid(), true, false);
				PluginManager pluginManager = getTestFramework().getPluginManager();
				SerializerPlugin serializerPlugin = pluginManager.getSerializerPlugin("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin", true);
				Serializer serializer = serializerPlugin.createSerializer(new PluginConfiguration());
				model.generateMinimalExpressIds();
				serializer.init(model, null, pluginManager, null, false);
				serializer.writeToFile(getTestFramework().getTestConfiguration().getOutputFolder().resolve("test.ifc"), null);
			} catch (BimServerClientException e1) {
				e1.printStackTrace();
			} catch (SerializerException e) {
				e.printStackTrace();
			}
		}
	}
}