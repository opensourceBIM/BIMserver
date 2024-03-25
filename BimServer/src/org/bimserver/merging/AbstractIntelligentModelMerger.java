package org.bimserver.merging;

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

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifc.ReferenceCounter;
import org.bimserver.models.ifc4.*;
import org.bimserver.models.store.Project;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.modelmerger.MergeException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.bimserver.ifc.ReferenceCounter.Reference;

import java.util.*;
import java.util.stream.Collectors;

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

		cleanIdenticalRelationships();
		cleanIdenticalPropertySets();
		cleanUnreachableObjects();

		LOGGER.info("Model size: " + model.size());
		return model;
	}

	private void cleanIdenticalPropertySets() {
		List<IfcTypeObject> typeObjects = model.getAllWithSubTypes(IfcTypeObject.class);
		typeObjects.forEach(to -> {
			Map<String, List<IfcPropertySetDefinition>> map = to.getHasPropertySets().stream().collect(Collectors.groupingBy(IfcPropertySetDefinition::getName));
			map.entrySet().forEach(es -> {
					for (int i = 1; i < es.getValue().size(); i++) {
						es.getValue().get(i).unsetDefinesType();
						model.remove(es.getValue().get(i));
					}
			});
		});
		List<IfcObject> objects = model.getAllWithSubTypes(IfcObject.class);
		objects.forEach(o -> {
			Map<String, List<IfcPropertySetDefinition>> map = o.getIsDefinedBy().stream().map(rel -> (IfcPropertySetDefinition)rel.getRelatingPropertyDefinition()).collect(Collectors.groupingBy(IfcPropertySetDefinition::getName));
			map.entrySet().forEach(es -> {
				for (int i = 1; i < es.getValue().size(); i++) {
					es.getValue().get(i).getDefinesOccurrence().forEach(rel -> model.remove(rel));
					es.getValue().get(i).unsetDefinesOccurrence();
					model.remove(es.getValue().get(i));
				}
			});
		});
	}

	private Map<String, List<IdEObject>> buildIdentifierMap() {
		Map<String, List<IdEObject>> map = new HashMap<String, List<IdEObject>>();
		for (IdEObject idEObject : model.getValues()) {
			//if (idEObject instanceof IfcRoot) {
				//IfcRoot ifcRoot = (IfcRoot) idEObject;
				IdEObject ifcRoot = idEObject;
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
			//}
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
						// This is strange, in some cases the list can be merged without problems, but we just play "safe" here
						//if (!newestObject.eIsSet(eReference)) {
						List<?> l = (List<?>)newestObject.eGet(eReference);
						for (int i = list.size() - 2; i >= 0; i--) {
							IdEObject olderObject = list.get(i);
							if (olderObject.eIsSet(eReference)) {
								List a = (List) olderObject.eGet(eReference);
								l.addAll(a);
								for (Object o : a) {
									referenceCounter.addReference(new ReferenceCounter.MultiReference(newestObject, (IdEObject) o, eReference));
								}
								a.clear();
								break;
							}
						}
						//}
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

	private void cleanIdenticalRelationships() {
		List<IfcRelationship> allRels = model.getAllWithSubTypes(IfcRelationship.class);
		List<IfcRelationship> relsToDelete = findDuplicateRelsToRemove(allRels);
		relsToDelete.forEach(r -> model.remove(r));
	}

	private void cleanUnreachableObjects() {
		IfcProject proj = model.getAll(IfcProject.class).stream().findFirst().get();
		Set<IdEObject> reachable = getAllReachableObjectsFrom(proj, false);
		Collection<IdEObject> allObjects = model.getValues();
		List<IdEObject> toRemove = allObjects.stream().filter(o -> !reachable.contains(o)).collect(Collectors.toList());
		toRemove.forEach(o -> model.remove(o));
	}

	public Set<IdEObject> getAllReachableObjectsFrom(IdEObject object, boolean stopTraversalOnFindingProject){
		Set<IdEObject> reachable = new HashSet<>();
		DFSForObjectGraphTraversal(object, reachable, stopTraversalOnFindingProject);
		return reachable;
	}

	private boolean DFSForObjectGraphTraversal(IdEObject object, Set<IdEObject> reachable, boolean stopTraversalOnFindingProject){
		for (EReference eReference : object.eClass().getEAllReferences()) {
			if (eReference.isMany()) {
				List list = (List) object.eGet(eReference);
				for (Object o : list) {
					if (o != null) {
						if (!reachable.contains(o)) {
							reachable.add((IdEObject) o);
							if (stopTraversalOnFindingProject && o instanceof IfcProject)
								return true;
							if (DFSForObjectGraphTraversal((IdEObject) o, reachable, stopTraversalOnFindingProject))
								return true;
						}
					}
				}
			} else {
				Object o = object.eGet(eReference);
				if (o != null) {
					if (!reachable.contains(o)) {
						reachable.add((IdEObject) o);
						if (stopTraversalOnFindingProject && o instanceof IfcProject)
							return true;
						if (DFSForObjectGraphTraversal((IdEObject) o, reachable, stopTraversalOnFindingProject))
							return true;
					}

				}
			}
		}
//		for (EAttribute eAttribute : object.eClass().getEAllAttributes()) {
//			Object o = object.eGet(eAttribute);
//			if (o instanceof IdEObject){
//
//			}
//		}
		return false;
	}

	public List<IfcRelationship> findDuplicateRelsToRemove(List<IfcRelationship> allRels) {
		List<IfcRelationship> duplicates = new ArrayList<>();

		Map<EClass, Map<Object, List<IfcRelationship>>> relsTypesMap = allRels.stream()
				.collect(Collectors.groupingBy(IfcRelationship::eClass,
						Collectors.groupingBy(this::getMainRelating
						)));

		for (EClass eClass : relsTypesMap.keySet()) {
			Map<Object, List<IfcRelationship>> objectSetMap = relsTypesMap.get(eClass);
			for (Object o : objectSetMap.keySet()){
				if (objectSetMap.get(o).size() > 0){
					List<IfcRelationship> rels = objectSetMap.get(o);
					for (int i = 0; i < rels.size(); i++){
						for (int j = i+1; j < rels.size(); j++){
							Optional<IfcRelationship> optional = isEqualsIfcRelationships(rels.get(i), rels.get(j));
							if (optional.isPresent())
								duplicates.add(optional.get());
						}
					}
				}
			}
		}
		return duplicates;
	}

	private Object getMainRelating(IfcRelationship rel) {
		List<EReference> refs = rel.eClass().getEAllReferences().stream().filter(r->!r.isMany()).collect(Collectors.toList());
		for (EReference ref : refs) {
			if (ref.getName().equals("OwnerHistory"))
				continue;
			return rel.eGet(ref);
		}
		return rel.getOwnerHistory();
	}

	private Optional<IfcRelationship> isEqualsIfcRelationships(IfcRelationship rel1, IfcRelationship rel2) {
		if (!rel1.eClass().equals(rel2.eClass()))
			return Optional.empty();
		IfcRelationship duplicate = rel2;
		EList<EReference> refs = rel1.eClass().getEAllReferences();
		for (EReference ref : refs) {
			if (ref.getName().equals("OwnerHistory"))
				continue;
			if (ref.isMany()) {
				Set<Object> set1 = new HashSet<Object>((List)rel1.eGet(ref));
				Set<Object> set2 = new HashSet<Object>((List)rel2.eGet(ref));
				Set<Object> shortSet, longSet;
				if (set1.size() < set2.size()) {
					shortSet = set1;
					longSet = set2;
					duplicate = rel1;
				} else {
					shortSet = set2;
					longSet = set1;
					duplicate = rel2;
				}

				for (Object o : shortSet) {
					if (!longSet.contains(o))
						return Optional.empty();
				}
			} else {
				if (rel1.eGet(ref) == null || rel2.eGet(ref) == null) {
					return Optional.empty();
				}
				if (!rel1.eGet(ref).equals(rel2.eGet(ref)))
					return Optional.empty();
			}
		}
		return Optional.of(duplicate);
	}




}
