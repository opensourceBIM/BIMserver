package org.bimserver.ifc;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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

import java.util.Map;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.PluginClassLoaderProvider;

public class BasicIfcModel extends IfcModel {

	private PluginClassLoaderProvider pluginClassLoaderProvider;

	public BasicIfcModel(PackageMetaData packageMetaData, Map<Integer, Long> pidRoidMap) {
		super(packageMetaData, pidRoidMap);
	}

	public BasicIfcModel(PackageMetaData packageMetaData, Map<Integer, Long> pidRoidMap, int size) {
		super(packageMetaData, pidRoidMap, size);
	}
	
	public void setPluginClassLoaderProvider(PluginClassLoaderProvider pluginClassLoaderProvider) {
		this.pluginClassLoaderProvider = pluginClassLoaderProvider;
	}
	
	public PluginClassLoaderProvider getPluginClassLoaderProvider() {
		return pluginClassLoaderProvider;
	}

	@Override
	public void load(IdEObject idEObject) {
	}
}
