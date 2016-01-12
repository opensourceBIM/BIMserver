package org.bimserver.merging;

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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifc.ReferenceCounter;
import org.bimserver.ifc.ReferenceCounter.Reference;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.store.Project;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.modelmerger.MergeException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractIntelligentModelMerger extends AbstractModelMerger {
	private final Logger LOGGER = LoggerFactory.getLogger(AbstractIntelligentModelMerger.class);
	private ReferenceCounter referenceCounter;
	private IfcModelInterface model;

	public abstract String getIdentifier(IdEObject idEObject);

	/*
	 * ifcModels MUST be ordered by date already
	 */
	public IfcModelInterface merge(Project project, IfcModelSet modelSet, ModelHelper modelHelper) throws MergeException {
		if (modelSet.size() == 1) {
			// Do no merging on only 1 model, same in - same out principle of
			// Leon :)
			return modelSet.iterator().next();
		}
		modelSet.sortByDate();
		model = mergeScales(project, modelSet, modelHelper);

		LOGGER.info("Intelligent merging");

		referenceCounter = new ReferenceCounter(model);
		referenceCounter.updateReferences();
		Map<String, List<IdEObject>> identifierMap = buildIdentifierMap();
		cleanIdentifierMap(identifierMap);

		LOGGER.info("Model size: " + model.size());
		return model;
	}

	private Map<String, List<IdEObject>> buildIdentifierMap() {
		Map<String, List<IdEObject>> map = new HashMap<String, List<IdEObject>>();
		for (IdEObject idEObject : model.getValues()) {
			if (idEObject instanceof IfcRoot) {
				IfcRoot ifcRoot = (IfcRoot) idEObject;
				String identifier = getIdentifier(idEObject);
				if (identifier != null) {
					if (map.containsKey(identifier)) {
						if (map.get(identifier).get(0).eClass() != ifcRoot.eClass()) {
							LOGGER.info("Not merging " + identifier + " because different types are found: " + map.get(identifier).get(0).eClass().getName() + " and "
									+ ifcRoot.eClass().getName());
						} else {
							if (model.contains(ifcRoot)) {
								map.get(identifier).add(ifcRoot);
							}
						}
					} else {
						if (model.contains(ifcRoot)) {
							List<IdEObject> list = new ArrayList<IdEObject>();
							list.add(ifcRoot);
							map.put(identifier, list);
						}
					}
				}
			}
		}
		return map;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void cleanIdentifierMap(Map<String, List<IdEObject>> identifierMap) {
		for (String identifier : identifierMap.keySet()) {
			List<IdEObject> list = identifierMap.get(identifier);
			if (list.size() > 1) {
				IdEObject newestObject = list.get(list.size() - 1);
				// Change all attributes FROM this object
				for (EAttribute eAttribute : newestObject.eClass().getEAllAttributes()) {
					if (eAttribute.isMany()) {
						// Do not merge lists
					} else {
						if (!newestObject.eIsSet(eAttribute)) {
							for (int i = list.size() - 2; i >= 0; i--) {
								IdEObject olderObject = list.get(i);
								if (olderObject.eIsSet(eAttribute)) {
									newestObject.eSet(eAttribute, olderObject.eGet(eAttribute));
									break;
								}
							}
						}
					}
				}
				// Change all references FROM this object
				for (EReference eReference : newestObject.eClass().getEAllReferences()) {
					if (eReference.isMany()) {
						if (!newestObject.eIsSet(eReference)) {
							for (int i = list.size() - 2; i >= 0; i--) {
								IdEObject olderObject = list.get(i);
								if (olderObject.eIsSet(eReference)) {
									List<?> l = (List<?>)newestObject.eGet(eReference);
									List a = (List)olderObject.eGet(eReference);
									l.addAll(a);
									a.clear();
									referenceCounter.addReference(new ReferenceCounter.MultiReference(newestObject, (IdEObject) olderObject.eGet(eReference), eReference));
									break;
								}
							}
						}
					} else {
						if (!newestObject.eIsSet(eReference)) {
							for (int i = list.size() - 2; i >= 0; i--) {
								IdEObject olderObject = list.get(i);
								if (olderObject.eIsSet(eReference)) {
									newestObject.eSet(eReference, olderObject.eGet(eReference));
									referenceCounter.addReference(new ReferenceCounter.SingleReference(newestObject, (IdEObject) olderObject.eGet(eReference), eReference));
									break;
								}
							}
						}
					}
				}
				// Change all references TO this object
				for (IdEObject idEObject : list) {
					if (idEObject != newestObject) {
						removeReplaceLinks(newestObject, idEObject);
					}
				}
			}
		}
	}

	private void removeReplaceLinks(IdEObject mainObject, IdEObject objectToRemove) {
		LOGGER.info("Merging " + mainObject.eClass().getName());
		if (mainObject.eClass() != objectToRemove.eClass()) {
			throw new RuntimeException("Classes must be the same");
		}
		Set<Reference> referencesTo = referenceCounter.getReferencesTo(objectToRemove);
		if (referencesTo != null) {
			Iterator<Reference> referenceIterator = referencesTo.iterator();
			Set<Reference> newReferences = new HashSet<Reference>();
			while (referenceIterator.hasNext()) {
				Reference reference = referenceIterator.next();
				newReferences.add(reference.reAttach(mainObject));
				referenceIterator.remove();
			}
			for (Reference reference : newReferences) {
				referenceCounter.addReference(reference);
			}
		}
//		LOGGER.info("Removing " + objectToRemove);
		referenceCounter.remove(objectToRemove);
		model.remove(objectToRemove);
	}
}
