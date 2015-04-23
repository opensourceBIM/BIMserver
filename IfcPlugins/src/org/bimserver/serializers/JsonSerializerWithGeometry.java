package org.bimserver.serializers;

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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.OutputStream;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.SharedJsonSerializer;
import org.bimserver.ifc.IfcSerializer;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;

public class JsonSerializerWithGeometry extends IfcSerializer {

	private SharedJsonSerializer sharedJsonSerializer;

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, RenderEnginePlugin renderEnginePlugin,
			PackageMetaData packageMetaData, boolean normalizeOids) throws SerializerException {
		super.init(model, projectInfo, pluginManager, renderEnginePlugin, packageMetaData, normalizeOids);
		sharedJsonSerializer = new SharedJsonSerializer(getModel(), pluginManager.getServicesMap());
	}
	
	@Override
	public void reset() {
	}

	@Override
	protected boolean write(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException {
		return sharedJsonSerializer.write(outputStream, progressReporter);
	}
}