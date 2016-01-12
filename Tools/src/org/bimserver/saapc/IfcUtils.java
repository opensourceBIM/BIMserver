package org.bimserver.saapc;

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
}