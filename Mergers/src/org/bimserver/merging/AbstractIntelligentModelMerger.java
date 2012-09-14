package org.bimserver.merging;

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
	private final Logger LOGGER = LoggerFactory.getLogger(IntelligentNameBasedModelMerger.class);
	private ReferenceCounter referenceCounter;
	private IfcModelSet modelSet;
	private IfcModelInterface model;
	private Set<String> processedIdentifiers = new HashSet<String>();

	public abstract String getIdentifier(IdEObject idEObject);
	
	/*
	 * ifcModels MUST be ordered by date already
	 */
	public IfcModelInterface merge(Project project, IfcModelSet modelSet, ModelHelper modelHelper) throws MergeException {
		this.modelSet = modelSet;
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
		for (IfcModelInterface model : modelSet) {
			for (IdEObject idEObject : model.getValues()) {
				if (idEObject instanceof IfcRoot) {
					IfcRoot ifcRoot = (IfcRoot) idEObject;
					String identifier = getIdentifier(idEObject);
					if (identifier != null) {
						if (!processedIdentifiers.contains(identifier)) {
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
			}
		}
		return map;
	}

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
						// Do not merge lists
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
			processedIdentifiers.add(identifier);
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
		model.remove(objectToRemove);
	}
}
