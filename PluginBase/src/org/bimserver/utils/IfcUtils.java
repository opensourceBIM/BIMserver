package org.bimserver.utils;

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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcElement;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcSpatialStructureElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class IfcUtils {
	public static Path getShortestAllPaths(IdEObject start, IdEObject end) {
		Set<Path> paths = new LinkedHashSet<Path>();
		Path basePath = new Path(start);
		getAllPaths(basePath, end, paths, new HashSet<EObject>());
		System.out.println("Number of paths: " + paths.size());
		List<Path> pathList = new ArrayList<Path>(paths);
		java.util.Collections.sort(pathList, new Comparator<Path>() {
			@Override
			public int compare(Path o1, Path o2) {
				return o1.getLength() - o2.getLength();
			}
		});
		return pathList.get(0);
	}
	
	public static int getAllPaths(Path basePath, IdEObject otherObject, Set<Path> paths, Set<EObject> noConnectionPaths) {
		int connectionsFound = 0;
		if (noConnectionPaths.contains(basePath.getLastObject())) {
			return 0;
		}
		for (EReference eReference : basePath.getLastObject().eClass().getEAllReferences()) {
			Object reference = basePath.getLastObject().eGet(eReference);
			if (reference != null) {
				if (eReference.isMany()) {
					@SuppressWarnings("rawtypes")
					List list = (List)reference;
					for (int index=0; index<list.size(); index++) {
						Object refObject = list.get(index);
						IdEObject refIdEObject = (IdEObject)refObject;
						if (basePath.contains(refIdEObject)) {
							// do nothing
						} else if (refIdEObject == otherObject) {
							paths.add(new Path(basePath, eReference, index, refIdEObject));
							System.out.println(paths.size());
						} else {
							connectionsFound += getAllPaths(new Path(basePath, eReference, index, (IdEObject) refObject), otherObject, paths, noConnectionPaths);
						}
					}
				} else {
					if (basePath.contains((IdEObject) reference)) {
						// do nothing
					} else if (reference == otherObject) {
						paths.add(new Path(basePath, eReference, -1, (IdEObject) reference));
						System.out.println(paths.size());
					} else {
						connectionsFound += getAllPaths(new Path(basePath, eReference, -1, (IdEObject) reference), otherObject, paths, noConnectionPaths);
					}
				}
			}
		}
		if (connectionsFound == 0) {
			noConnectionPaths.add(basePath.getLastObject());
		}
		return connectionsFound;
	}
	
	public static IfcBuildingStorey getIfcBuildingStorey(IfcProduct ifcProduct) {
		if (ifcProduct instanceof IfcBuildingStorey) {
			return (IfcBuildingStorey) ifcProduct;
		}
		for (IfcRelDecomposes ifcRelDecomposes : ifcProduct.getDecomposes()) {
			IfcObjectDefinition relatingObject = ifcRelDecomposes.getRelatingObject();
			if (relatingObject instanceof IfcBuildingStorey) {
				return (IfcBuildingStorey)relatingObject;
			}
		}
		if (ifcProduct instanceof IfcElement) {
			IfcElement ifcElement = (IfcElement)ifcProduct;
			for (IfcRelContainedInSpatialStructure ifcRelContainedInSpatialStructure : ifcElement.getContainedInStructure()) {
				IfcSpatialStructureElement relatingStructure = ifcRelContainedInSpatialStructure.getRelatingStructure();
				if (relatingStructure instanceof IfcBuildingStorey) {
					return (IfcBuildingStorey) relatingStructure;
				} else {
					if (relatingStructure instanceof IfcSpace) {
						return getIfcBuildingStorey(relatingStructure);
					}
				}
			}
		}
		return null;
	}

	public static List<IfcProduct> getChildren(IfcBuildingStorey ifcBuildingStorey) {
		List<IfcProduct> list = new ArrayList<>();
		for (IfcRelDecomposes ifcRelDecomposes : ifcBuildingStorey.getIsDecomposedBy()) {
			for (IfcObjectDefinition ifcObjectDefinition : ifcRelDecomposes.getRelatedObjects()) {
				if (ifcObjectDefinition instanceof IfcProduct) {
					list.add((IfcProduct) ifcObjectDefinition);
				}
			}
		}
		return list;
	}

	public static IfcProject getIfcProject(IfcProduct ifcProduct) {
		if (ifcProduct instanceof IfcProject) {
			return (IfcProject) ifcProduct;
		}
		for (IfcRelDecomposes ifcRelDecomposes : ifcProduct.getDecomposes()) {
			IfcObjectDefinition relatingObject = ifcRelDecomposes.getRelatingObject();
			if (relatingObject instanceof IfcProject) {
				return (IfcProject)relatingObject;
			} else if (relatingObject instanceof IfcProduct){
				return getIfcProject((IfcProduct) relatingObject);
			}
		}
		if (ifcProduct instanceof IfcElement) {
			IfcElement ifcElement = (IfcElement)ifcProduct;
			for (IfcRelContainedInSpatialStructure ifcRelContainedInSpatialStructure : ifcElement.getContainedInStructure()) {
				IfcSpatialStructureElement relatingStructure = ifcRelContainedInSpatialStructure.getRelatingStructure();
				if (relatingStructure instanceof IfcProject) {
					return (IfcProject) relatingStructure;
				} else if (relatingStructure instanceof IfcBuildingStorey) {
					return getIfcProject(relatingStructure);
				} else {
					if (relatingStructure instanceof IfcSpace) {
						return getIfcProject(relatingStructure);
					}
				}
			}
		}
		return null;
	}
}