package org.bimserver.emf;

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

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.PluginManager;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public class MetaDataManager {
	private final Map<String, PackageMetaData> ePackages = new TreeMap<String, PackageMetaData>();
	private PluginManager pluginManager;

	public MetaDataManager(PluginManager pluginManager) {
		this.pluginManager = pluginManager;
	}
	
	public void init() {
		addEPackage(Ifc2x3tc1Package.eINSTANCE, Schema.IFC2X3TC1);
		addEPackage(Ifc4Package.eINSTANCE, Schema.IFC4);
		addEPackage(GeometryPackage.eINSTANCE, Schema.GEOMETRY);
		addEPackage(StorePackage.eINSTANCE, Schema.STORE);
		addEPackage(LogPackage.eINSTANCE, Schema.LOG);
		
		initDependencies();
	}

	private void initDependencies() {
		for (PackageMetaData packageMetaData : ePackages.values()) {
			for (EClassifier eClassifier : packageMetaData.getEPackage().getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass)eClassifier;
					for (EReference eReference : eClass.getEReferences()) {
						if (eReference.getEType().getEPackage() != packageMetaData.getEPackage()) {
							packageMetaData.addDependency(getPackageMetaData(eReference.getEType().getEPackage().getName()));
						}
					}
				}
			}
		}
	}

	public PackageMetaData getPackageMetaData(String schema) {
		if (schema == null) {
			throw new IllegalArgumentException("schema cannot be null");
		}
		PackageMetaData packageMetaData = ePackages.get(schema.toLowerCase());
		if (packageMetaData == null) {
			throw new RuntimeException("No PackageMetaData found for " + schema);
		}
		return packageMetaData;
	}

	public void addEPackage(EPackage ePackage, Schema schema) {
		ePackages.put(ePackage.getName().toLowerCase(), new PackageMetaData(this, ePackage, schema));
	}

	public PluginManager getPluginManager() {
		return pluginManager;
	}

	public Collection<PackageMetaData> getAll() {
		return ePackages.values();
	}

	public Collection<PackageMetaData> getAllIfc() {
		Set<PackageMetaData> result = new HashSet<>();
		result.add(getPackageMetaData("Ifc2x3tc1"));
		result.add(getPackageMetaData("Ifc4"));
		return result;
	}
}