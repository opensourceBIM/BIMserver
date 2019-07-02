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

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.TracingGarbageCollector;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.plugins.ObjectAlreadyExistsException;
import org.bimserver.shared.IncrementingOidProvider;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;

public class RevisionMerger {

	private IfcModelInterface oldModel;
	private IfcModelInterface newModel;
	private IfcModel resultModel;

	public RevisionMerger(IfcModelInterface oldModel, IfcModelInterface newModel) {
		this.oldModel = oldModel;
		this.newModel = newModel;
		resultModel = new BasicIfcModel(null, null, (int)oldModel.size()); //TODO
	}
	
	public IfcModel merge() throws IfcModelInterfaceException {
		for (IdEObject idEObject : oldModel.getValues()) {
			copy(resultModel, idEObject, false);
		}
		resultModel.indexGuids();
		newModel.fixOids(new IncrementingOidProvider(resultModel.getHighestOid() + 1));
		
		copyAttributesGuidObjectsAndAddNewObjects();
		updateReferences();
		fixExplicitNullReferences();
		fixNonGuidObjects();
		TracingGarbageCollector tracingGarbageCollector = new TracingGarbageCollector(resultModel);
		Set<IdEObject> rootObjects = new HashSet<IdEObject>();
		for (IdEObject idEObject : resultModel.getValues()) {
			if (idEObject instanceof IfcProject) {
				rootObjects.add(idEObject);
			}
		}
		tracingGarbageCollector.mark(rootObjects);
		tracingGarbageCollector.sweep();
		
		return resultModel;
	}

	@SuppressWarnings("rawtypes")
	public void cleanupUnmodified() {
		Iterator<Long> iterator = resultModel.keySet().iterator();
		while (iterator.hasNext()) {
			Long oid = iterator.next();
			IdEObject idEObject = resultModel.get(oid);
			IdEObject originalObject = oldModel.get(oid);
			if (originalObject != null) {
				boolean objectChanged = false;
				for (EAttribute eAttribute : idEObject.eClass().getEAllAttributes()) {
					Object value = idEObject.eGet(eAttribute);
					Object originalValue = originalObject.eGet(eAttribute);
					if (((value == null && originalValue != null) || (value != null && originalValue == null))) {
						objectChanged = true;
						continue;
					}
					if (!(value == null && originalValue == null) && !value.equals(originalValue)) {
						objectChanged = true;
						continue;
					}
				}
				if (!objectChanged) {
					for (EReference eReference : idEObject.eClass().getEAllReferences()) {
						if (eReference.isMany()) {
							List list = (List)idEObject.eGet(eReference);
							List originalList = (List)originalObject.eGet(eReference);
							if (list.size() != originalList.size()) {
								objectChanged = true;
								continue;
							}
							for (int i=0; i<list.size(); i++) {
								IdEObject referencedObject = (IdEObject) list.get(i);
								IdEObject originalReferencedObject = (IdEObject) originalList.get(i);
								if ((referencedObject == null && originalReferencedObject != null) || (referencedObject != null && originalReferencedObject == null)) {
									objectChanged = true;
									continue;
								}
								if (!(referencedObject == null && originalReferencedObject == null) && referencedObject.getOid() != originalReferencedObject.getOid()) {
									objectChanged = true;
									continue;
								}
							}
						} else {
							IdEObject referencedObject = (IdEObject) idEObject.eGet(eReference);
							IdEObject originalReferencedObject = (IdEObject) originalObject.eGet(eReference);
							if ((referencedObject == null && originalReferencedObject != null) || (referencedObject != null && originalReferencedObject == null)) {
								objectChanged = true;
								continue;
							}
							if (!(referencedObject == null && originalReferencedObject == null) && referencedObject.getOid() != originalReferencedObject.getOid()) {
								objectChanged = true;
								continue;
							}
						}
					}
				}
				if (!objectChanged) {
					iterator.remove();
				}
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void fixNonGuidObjects() throws IfcModelInterfaceException {
		Set<List> clearedLists = new HashSet<List>();
		for (IdEObject idEObject : newModel.getValues()) {
			if (idEObject instanceof IfcRoot) {
				String guid = ((IfcRoot) idEObject).getGlobalId();
				for (EReference eReference : idEObject.eClass().getEAllReferences()) {
					Object referencedObject = idEObject.eGet(eReference);
					if (eReference.isMany()) {
						List list = (List) referencedObject;
						List newList = (List)resultModel.getByGuid(guid).eGet(eReference);
						boolean listIsCleared = false;
						for (Object o : list) {
							if (!(o instanceof IfcRoot) && !(o instanceof IfcGloballyUniqueId)) {
								if (!listIsCleared) {
									newList.clear();
									listIsCleared = true;
								}
								IdEObject referencedIDEObject = (IdEObject) o;
								if (resultModel.contains(referencedIDEObject.getOid())) {
									newList.add(resultModel.get(referencedIDEObject.getOid()));
								} else {
									IdEObject smartCopy = copy(resultModel, referencedIDEObject, true);
									newList.add(smartCopy);
								}
							}
						}
					} else {
						if (referencedObject == null) {
							if (resultModel.getByGuid(guid).eGet(eReference) != null && eReference.getEOpposite() != null) {
								IdEObject x = (IdEObject) resultModel.getByGuid(guid).eGet(eReference);
								if (eReference.getEOpposite().isMany()) {
									List l = (List) x.eGet(eReference.getEOpposite());
									if (!clearedLists.contains(l)) {
										clearedLists.add(l);
										l.clear();
									}
								} else {
									x.eSet(eReference.getEOpposite(), null);
								}
							}
							resultModel.getByGuid(guid).eSet(eReference, null);
						} else {
							if (!(referencedObject instanceof IfcRoot) && !(referencedObject instanceof IfcGloballyUniqueId)) {
								IdEObject referencedIDEObject = (IdEObject) referencedObject;
								if (resultModel.contains(referencedIDEObject.getOid())) {
									if (resultModel.getByGuid(guid).eGet(eReference) != null && eReference.getEOpposite() != null) {
										IdEObject x = (IdEObject) resultModel.getByGuid(guid).eGet(eReference);
										if (eReference.getEOpposite().isMany()) {
											List l = (List) x.eGet(eReference.getEOpposite());
											if (!clearedLists.contains(l)) {
												clearedLists.add(l);
												l.clear();
											}
										} else {
											x.eSet(eReference.getEOpposite(), null);
										}
									}
									resultModel.getByGuid(guid).eSet(eReference, resultModel.get(referencedIDEObject.getOid()));
								} else {
									IdEObject smartCopy = copy(resultModel, referencedIDEObject, true);
									if (resultModel.getByGuid(guid).eGet(eReference) != null && eReference.getEOpposite() != null) {
										IdEObject re = (IdEObject) resultModel.getByGuid(guid).eGet(eReference);
										if (eReference.getEOpposite().isMany()) {
											List l = (List)re.eGet(eReference.getEOpposite());
											if (!clearedLists.contains(l)) {
												clearedLists.add(l);
												l.clear();
											}
										} else {
											re.eSet(eReference.getEOpposite(), null);
										}
									}
									resultModel.getByGuid(guid).eSet(eReference, smartCopy);
								}
							}
						}
					}
				}
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private IdEObject copy(IfcModel target, IdEObject idEObject, boolean limitToNonGuids) throws IfcModelInterfaceException {
		if (target.contains(idEObject.getOid())) {
			return target.get(idEObject.getOid());
		}
		IdEObject newObject = (IdEObject) idEObject.eClass().getEPackage().getEFactoryInstance().create(idEObject.eClass());
		((IdEObjectImpl)newObject).setOid(idEObject.getOid());
		if (newObject.getOid() != -1) {
			target.add(newObject.getOid(), newObject);
		}
		for (EAttribute eAttribute : newObject.eClass().getEAllAttributes()) {
			newObject.eSet(eAttribute, idEObject.eGet(eAttribute));
		}
		for (EReference eReference : newObject.eClass().getEAllReferences()) {
			Object referencedObject = idEObject.eGet(eReference);
			if (referencedObject instanceof IdEObject) {
				IdEObject refEObject = (IdEObject)referencedObject;
				if (!limitToNonGuids || !(referencedObject instanceof IfcRoot) && !(referencedObject instanceof IfcGloballyUniqueId)) {
					newObject.eSet(eReference, copy(target, refEObject, limitToNonGuids));
				}
			} else if (referencedObject instanceof List) {
				List list = (List)referencedObject;
				List newList = (List)newObject.eGet(eReference);
				for (Object o : list) {
					if (!limitToNonGuids || !(o instanceof IfcRoot) && !(o instanceof IfcGloballyUniqueId)) {
						IdEObject listObject = (IdEObject)o;
						IdEObject smartCopy = copy(target, listObject, limitToNonGuids);
						if (!newList.contains(smartCopy)) {
							newList.add(smartCopy);
						}
					}
				}
			}
		}
		return newObject;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void fixExplicitNullReferences() {
		for (IdEObject idEObject : newModel.getValues()) {
			if (idEObject instanceof IfcRoot) {
				String guid = ((IfcRoot) idEObject).getGlobalId();
				for (EReference eReference : idEObject.eClass().getEAllReferences()) {
					if (eReference.isMany()) {
						List list = (List) idEObject.eGet(eReference);
						List oldList = (List) resultModel.getByGuid(guid).eGet(eReference);
						Set<Object> guidsToRemove = new HashSet<Object>();
						for (Object o : oldList) {
							if (o instanceof IfcRoot) {
								String referredGuid = ((IfcRoot) o).getGlobalId();
								if (newModel.containsGuid(referredGuid)) {
									boolean found = false;
									for (Object q : list) {
										if (q instanceof IfcRoot) {
											String qGuid = ((IfcRoot) q).getGlobalId();
											if (qGuid.equals(referredGuid)) {
												found = true;
												break;
											}
										}
									}
									if (!found) {
										guidsToRemove.add(referredGuid);
									}
								}
							}
						}
						if (!guidsToRemove.isEmpty()) {
//							LOGGER.info("Removing list references");
							oldList.removeAll(guidsToRemove);
						}
					} else {
						if (idEObject.eGet(eReference) == null) {
							Object eGet = resultModel.getByGuid(guid).eGet(eReference);
							if (eGet != null) {
								if (eGet instanceof IfcRoot) {
									String oldGuid = ((IfcRoot) eGet).getGlobalId();
									if (newModel.containsGuid(oldGuid)) {
//										LOGGER.info("Settings explicit null reference");
										resultModel.getByGuid(guid).eSet(eReference, null);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void updateReferences() {
		for (IdEObject idEObject : newModel.getValues()) {
			if (idEObject instanceof IfcRoot) {
				String guid = ((IfcRoot) idEObject).getGlobalId();
				IfcRoot oldObject = (IfcRoot) resultModel.getByGuid(guid);
				for (EReference eReference : idEObject.eClass().getEAllReferences()) {
					Object referencedObject = idEObject.eGet(eReference);
					if (referencedObject instanceof IfcRoot) {
						String referencedGuid = ((IfcRoot) referencedObject).getGlobalId();
						IfcRoot newObject = (IfcRoot) resultModel.getByGuid(referencedGuid);
						oldObject.eSet(eReference, newObject);
//						LOGGER.info("Fixing reference from " + guid + " to " + referencedGuid);
					} else if (referencedObject instanceof List) {
						List referencedList = (List) referencedObject;
						List oldReferencedList = (List) oldObject.eGet(eReference);
						for (Object object : referencedList) {
							if (object instanceof IfcRoot) {
								IfcRoot referencedItem = (IfcRoot) object;
								String itemGuid = referencedItem.getGlobalId();
								oldReferencedList.add(resultModel.getByGuid(itemGuid));
//								LOGGER.info("Fixing list reference from " + guid + " to " + itemGuid);
							}
						}
					}
				}
			}
		}
	}

	private void copyAttributesGuidObjectsAndAddNewObjects() throws IfcModelInterfaceException, ObjectAlreadyExistsException {
		for (IdEObject idEObject : newModel.getValues()) {
			if (idEObject instanceof IfcRoot) {
				IfcRoot ifcRoot = (IfcRoot) idEObject;
				String guid = ifcRoot.getGlobalId();
				if (resultModel.containsGuid(guid)) {
//					LOGGER.info("Updating attributes for object " + idEObject.eClass().getName() + " " + guid);
					IfcRoot oldObject = (IfcRoot) resultModel.getByGuid(guid);
					for (EAttribute eAttribute : idEObject.eClass().getEAllAttributes()) {
						Object newValue = idEObject.eGet(eAttribute);
						oldObject.eSet(eAttribute, newValue);
					}
				} else {
//					LOGGER.info("Adding new GUID object " + idEObject.eClass().getName() + " " + guid);
					IdEObject newObject = (IdEObject) idEObject.eClass().getEPackage().getEFactoryInstance().create(idEObject.eClass());
					((IdEObjectImpl)newObject).setOid(idEObject.getOid());
					((IfcRoot) newObject).setGlobalId(newGuid(guid));
					for (EAttribute eAttribute : newObject.eClass().getEAllAttributes()) {
						newObject.eSet(eAttribute, idEObject.eGet(eAttribute));
					}
					resultModel.add(newObject.getOid(), newObject);
				}
			}
		}
	}

	private String newGuid(String guid) {
		return guid;
	}
}