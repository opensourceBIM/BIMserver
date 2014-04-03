package org.bimserver.emf;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.util.Map;
import java.util.TreeMap;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.PluginManager;
import org.eclipse.emf.ecore.EPackage;

public class MetaDataManager {
	private final Map<String, PackageMetaData> ePackages = new TreeMap<String, PackageMetaData>();
	private PluginManager pluginManager;

//	public MetaDataManager(Set<EPackage> ePackages, PluginManager pluginManager) {
//		this.pluginManager = pluginManager;
//		for (EPackage ePackage : ePackages) {
//			addEPackage(ePackage);
//		}
//	}
	
	public MetaDataManager(PluginManager pluginManager) {
		this.pluginManager = pluginManager;
		addEPackage(Ifc2x3tc1Package.eINSTANCE, Schema.IFC2X3TC1);
		addEPackage(Ifc4Package.eINSTANCE, Schema.IFC4);
		addEPackage(StorePackage.eINSTANCE, Schema.STORE);
		addEPackage(LogPackage.eINSTANCE, Schema.LOG);
	}
	
	public PackageMetaData getEPackage(String schema) {
		schema = schema.toLowerCase();
		return ePackages.get(schema);
	}

	public void addEPackage(EPackage ePackage, Schema schema) {
		ePackages.put(ePackage.getName(), new PackageMetaData(this, ePackage, schema));
	}

	public PluginManager getPluginManager() {
		return pluginManager;
	}
}