package org.bimserver.test.framework.actions;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;

import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class DownloadModelLowLevel extends Action {

	public DownloadModelLowLevel(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		SRevision randomRevision = virtualUser.getRandomRevision();
		if (randomRevision != null) {
			IfcModelInterface model = virtualUser.getBimServerClient().getModel(randomRevision.getOid());
			PluginManager pluginManager = virtualUser.getBimServerClient().getPluginManager();
			try {
				SerializerPlugin serializerPlugin = pluginManager.getFirstSerializerPlugin("application/ifc", true);
				EmfSerializer serializer = serializerPlugin.createSerializer();
				serializer.init(model, null, pluginManager, pluginManager.requireIfcEngine().createIfcEngine());
				serializer.writeToFile(new File(getTestFramework().getTestConfiguration().getOutputFolder(), "test.ifc"));
			} catch (PluginException e) {
				e.printStackTrace();
			} catch (SerializerException e) {
				e.printStackTrace();
			}
		}
	}
}