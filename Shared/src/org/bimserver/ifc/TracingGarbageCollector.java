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

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.ecore.EReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.tue.buildingsmart.schema.Attribute;
import nl.tue.buildingsmart.schema.EntityDefinition;
import nl.tue.buildingsmart.schema.InverseAttribute;
import nl.tue.buildingsmart.schema.SchemaDefinition;

public class TracingGarbageCollector {
	private static final Logger LOGGER = LoggerFactory.getLogger(TracingGarbageCollector.class);
	private final IfcModel ifcModel;
	private final Set<IdEObject> referencedObjects = new HashSet<IdEObject>();

	public TracingGarbageCollector(IfcModel ifcModel) {
		this.ifcModel = ifcModel;
	}

	@SuppressWarnings("rawtypes")
	public void mark(Set<? extends IdEObject> rootObjects) {
		referencedObjects.addAll(rootObjects);
		SchemaDefinition schema = ifcModel.getPackageMetaData().getSchemaDefinition();
		for (IdEObject rootObject : rootObjects) {
			for (EReference eReference : rootObject.eClass().getEAllReferences()) {
				Attribute attributeBNWithSuper = null;
				if (schema != null) {
					EntityDefinition entityBN = schema.getEntityBN(rootObject.eClass().getName());
					if (entityBN == null) {
						LOGGER.info(rootObject.eClass().getName() + " not found");
					} else {
						attributeBNWithSuper = entityBN.getAttributeBNWithSuper(eReference.getName());
						if (attributeBNWithSuper == null) {
							LOGGER.info(eReference.getName() + " not found");
						}
					}
				}
				if (schema == null || !(attributeBNWithSuper instanceof InverseAttribute)) {
					Object referredObject = rootObject.eGet(eReference);
					if (eReference.isMany()) {
						List list = (List) referredObject;
						for (Object o : list) {
							if (!referencedObjects.contains(o)) {
								mark(makeSet((IdEObject) o));
							}
						}
					} else {
						IdEObject referredIdEObject = (IdEObject) referredObject;
						if (referredIdEObject != null) {
							if (!referencedObjects.contains(referredObject)) {
								mark(makeSet(referredIdEObject));
							}
						}
					}
				}
			}
		}
	}

	private Set<? extends IdEObject> makeSet(IdEObject idEObject) {
		Set<IdEObject> set = new HashSet<IdEObject>();
		set.add(idEObject);
		return set;
	}
	
	public void sweep() {
		Map<Long, IdEObject> objects = ifcModel.getObjects();
		Iterator<Long> iterator = objects.keySet().iterator();
		while (iterator.hasNext()) {
			Long next = iterator.next();
			IdEObject idEObject = objects.get(next);
			if (!referencedObjects.contains(idEObject)) {
				iterator.remove();
			}
		}
	}
}