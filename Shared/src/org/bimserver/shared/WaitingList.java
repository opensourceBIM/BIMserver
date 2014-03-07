package org.bimserver.shared;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.services.BimServerClientException;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitingList<T> {
	private static final Logger LOGGER = LoggerFactory.getLogger(WaitingList.class);
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
				AbstractEList<EObject> list = (AbstractEList<EObject>) waitingObject.getObject().eGet(waitingObject.getStructuralFeature());
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
						throw new DeserializeException(waitingObject.getLineNumber(), "Field " + waitingObject.getStructuralFeature().getName() + " of "
								+ waitingObject.getStructuralFeature().getEContainingClass().getName() + " cannot contain a " + eObject.eClass().getName());
					}
				}
			} else {
				if (((EClass) waitingObject.getStructuralFeature().getEType()).isSuperTypeOf(eObject.eClass())) {
					waitingObject.getObject().eSet(waitingObject.getStructuralFeature(), eObject);
				} else {
					throw new DeserializeException(waitingObject.getLineNumber(), "Field " + waitingObject.getStructuralFeature().getName() + " of "
							+ waitingObject.getStructuralFeature().getEContainingClass().getName() + " cannot contain a " + eObject.eClass().getName());
				}
			}
		}
		waitingObjects.remove(expressId);
	}

	public int size() {
		return waitingObjects.size();
	}
	
	public void dumpIfNotEmpty() throws BimServerClientException {
		if (size() > 0) {
			for (Entry<T, List<WaitingObject>> entry : waitingObjects.entrySet()) {
				StringBuilder sb = new StringBuilder("" + entry.getKey() + " ");
				for (WaitingObject waitingObject : entry.getValue()) {
					sb.append(waitingObject.toString() + " ");
				}
				LOGGER.info(sb.toString());
			}
			throw new BimServerClientException("Waitinglist not empty, this usually means some objects were referred, but not included in the download");
		}
	}
}