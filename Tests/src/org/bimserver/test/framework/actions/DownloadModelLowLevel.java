package org.bimserver.test.framework.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

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
import org.bimserver.utils.SerializerUtils;

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
				serializer.init(model, null, pluginManager, false);
				SerializerUtils.writeToFile(serializer, getTestFramework().getTestConfiguration().getOutputFolder().resolve("test.ifc"));
			} catch (BimServerClientException e1) {
				e1.printStackTrace();
			} catch (SerializerException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}