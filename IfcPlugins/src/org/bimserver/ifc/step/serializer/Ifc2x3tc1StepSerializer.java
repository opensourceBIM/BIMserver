package org.bimserver.ifc.step.serializer;

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
import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;

public class Ifc2x3tc1StepSerializer extends IfcStepSerializer {

	public Ifc2x3tc1StepSerializer(PluginConfiguration pluginConfiguration) {
		super(pluginConfiguration);
	}
	
	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManagerInterface pluginManager, PackageMetaData packageMetaData, boolean normalizeOids) throws SerializerException {
		setHeaderSchema("IFC2X3");
		super.init(model, projectInfo, pluginManager, packageMetaData, normalizeOids);
	}
}
