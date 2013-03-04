package org.bimserver.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.plugins.deserializers.DeserializeException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class WaitingList<T> {
	private final Map<T, List<WaitingObject>> waitingObjects = new HashMap<T, List<WaitingObject>>();

	public boolean containsKey(T recordNumber) {
		return waitingObjects.containsKey(recordNumber);
	}

	public void add(T referenceId, WaitingObject waitingObject) {
		List<WaitingObject> waitingList = null;
		if (waitingObjects.containsKey(referenceId)) {
			waitingList = waitingObjects.get(referenceId);
		} else {
			waitingList = new ArrayList<WaitingObject>();
			waitingObjects.put(referenceId, waitingList);
		}
		waitingList.add(waitingObject);
	}
	
	@SuppressWarnings("unchecked")
	public void updateNode(T expressId, EClass ec, EObject eObject) throws DeserializeException {
		for (WaitingObject waitingObject : waitingObjects.get(expressId)) {
			if (waitingObject.getStructuralFeature().isMany()) {
				BasicEList<EObject> list = (BasicEList<EObject>) waitingObject.getObject().eGet(waitingObject.getStructuralFeature());
				if (waitingObject instanceof SingleWaitingObject) {
					list.addUnique(eObject);
				} else {
					ListWaitingObject listWaitingObject = (ListWaitingObject)waitingObject;
					if (((EClass) waitingObject.getStructuralFeature().getEType()).isSuperTypeOf(eObject.eClass())) {
						while (list.size() <= listWaitingObject.getIndex()) {
							list.addUnique(ec.getEPackage().getEFactoryInstance().create(eObject.eClass()));
						}
						list.setUnique(listWaitingObject.getIndex(), eObject);
					} else {
						throw new DeserializeException("Field " + waitingObject.getStructuralFeature().getName() + " of "
								+ waitingObject.getStructuralFeature().getEContainingClass().getName() + " cannot contain a " + eObject.eClass().getName());
					}
				}
			} else {
				if (((EClass) waitingObject.getStructuralFeature().getEType()).isSuperTypeOf(eObject.eClass())) {
					waitingObject.getObject().eSet(waitingObject.getStructuralFeature(), eObject);
				} else {
					throw new DeserializeException("Field " + waitingObject.getStructuralFeature().getName() + " of "
							+ waitingObject.getStructuralFeature().getEContainingClass().getName() + " cannot contain a " + eObject.eClass().getName());
				}
			}
		}
		waitingObjects.remove(expressId);
	}

	public int size() {
		return waitingObjects.size();
	}
}