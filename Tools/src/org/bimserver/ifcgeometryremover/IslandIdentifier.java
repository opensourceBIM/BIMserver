package org.bimserver.ifcgeometryremover;

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

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifc.ReferenceCounter;
import org.bimserver.ifc.ReferenceCounter.Reference;
import org.eclipse.emf.ecore.EReference;

public class IslandIdentifier {

	private static class Island {
		public final Set<IdEObject> objects = new HashSet<IdEObject>();
	}

	private final Set<Island> islands = new HashSet<Island>();
	private final Set<IdEObject> identified = new HashSet<IdEObject>();
	private ReferenceCounter referenceCounter;

	public IslandIdentifier(IfcModelInterface model) {
		referenceCounter = new ReferenceCounter(model);
		referenceCounter.updateReferences();
		Iterator<IdEObject> iterator = model.iterator();
		while (iterator.hasNext()) {
			IdEObject object = iterator.next();
			floodfill(object, null);
		}
	}

	private void floodfill(IdEObject object, Island island) {
		if ((island != null && island.objects.contains(object)) || identified.contains(object)) {
			return;
		} else {
			if (island == null) {
				island = new Island();
				islands.add(island);
			}
			island.objects.add(object);
			identified.add(object);
		}
		for (EReference eReference : object.eClass().getEAllReferences()) {
			Object referred = object.eGet(eReference);
			if (referred != null) {
				if (eReference.isMany()) {
					List<?> list = (List<?>) referred;
					for (Object item : list) {
						floodfill((IdEObject) item, island);
					}
				} else {
					floodfill((IdEObject) referred, island);
				}
			}
		}
		Set<Reference> referencesTo = referenceCounter.getReferencesTo(object);
		if (referencesTo != null) {
			for (Reference reference : referencesTo) {
				floodfill(reference.getIdEObject(), island);
			}
		}
	}

	public void dump() {
		System.out.println(islands.size() + " islands");
		for (Island island : islands) {
			System.out.println(island.objects.size());
			if (island.objects.size() < 20) {
				for (IdEObject o : island.objects) {
					System.out.println("\t" + o.eClass().getName() + " (" + o.getExpressId() + ")");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}