package org.bimserver.shared;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.CannotStoreReferenceInFieldException;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerErrorCode;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitingListVirtualObject {
	private static final Logger LOGGER = LoggerFactory.getLogger(WaitingListVirtualObject.class);
	private final Map<Long, List<WaitingVirtualObject>> waitingObjects = new HashMap<>();

	// TODO this seems to only be used for debugging/error checking, make optional
	private final Map<Long, OpenConnectionCounter> openConnections = new HashMap<>();

	public boolean containsKey(long recordNumber) {
		return waitingObjects.containsKey(recordNumber);
	}

	private OpenConnectionCounter getOpenConnectionCounter(EClass eClass, long oid) {
		if (oid == -1 || oid == 0) {
			throw new RuntimeException("uhoh");
		}
		OpenConnectionCounter openConnectionCounter = openConnections.get(oid);
		if (openConnectionCounter == null) {
			openConnectionCounter = new OpenConnectionCounter(eClass);
			openConnections.put(oid, openConnectionCounter);
		}
		return openConnectionCounter;
	}
	
	public void add(long referenceId, WaitingVirtualObject waitingObject) {
		getOpenConnectionCounter(waitingObject.eClass(), waitingObject.getOid()).incrementAndGet();
		
		List<WaitingVirtualObject> waitingList = null;
		if (waitingObjects.containsKey(referenceId)) {
			waitingList = waitingObjects.get(referenceId);
		} else {
			waitingList = new ArrayList<WaitingVirtualObject>();
			waitingObjects.put(referenceId, waitingList);
		}
		waitingList.add(waitingObject);
	}
	
	private void decrementOpenConnections(VirtualObject virtualObject) throws BimserverDatabaseException {
		OpenConnectionCounter openConnectionCounter = getOpenConnectionCounter(virtualObject.eClass(), virtualObject.getOid());
		long decrementAndGet = openConnectionCounter.decrementAndGet();
		if (decrementAndGet == 0) {
			openConnections.remove(virtualObject.getOid());
			virtualObject.save();
		} else if (decrementAndGet < 0) {
			throw new BimserverDatabaseException("Inconsistent state");
		}
	}
	
	public void updateNode(long expressId, EClass ec, VirtualObject eObject) throws DeserializeException, BimserverDatabaseException {
		for (WaitingVirtualObject waitingObject : waitingObjects.get(expressId)) {
			if (waitingObject.getStructuralFeature().isMany()) {
				ListWaitingVirtualObject listWaitingObject = (ListWaitingVirtualObject)waitingObject;
				if (((EClass) waitingObject.getStructuralFeature().getEType()).isSuperTypeOf(eObject.eClass())) {
					if (waitingObject instanceof TwoDimensionalListWaitingVirtualObject) {
						TwoDimensionalListWaitingVirtualObject twoDimensionalListWaitingVirtualObject = (TwoDimensionalListWaitingVirtualObject)waitingObject;
						ListCapableVirtualObject object2 = twoDimensionalListWaitingVirtualObject.getObject2();
						object2.setListItemReference(waitingObject.getStructuralFeature(), listWaitingObject.getIndex(), eObject.eClass(), eObject.getOid(), waitingObject.getBufferPosition());
					} else {
						waitingObject.getObject().setListItemReference(waitingObject.getStructuralFeature(), listWaitingObject.getIndex(), eObject.eClass(), eObject.getOid(), waitingObject.getBufferPosition());
					}
					decrementOpenConnections(waitingObject.getObject());
				} else {
					throw new DeserializeException(DeserializerErrorCode.REFERENCED_OBJECT_CANNOT_BE_STORED_IN_THIS_FIELD, waitingObject.getLineNumber(), "Field " + waitingObject.getStructuralFeature().getName() + " of "
							+ waitingObject.getStructuralFeature().getEContainingClass().getName() + " cannot contain a " + eObject.eClass().getName());
				}
			} else {
				if (((EClass) waitingObject.getStructuralFeature().getEType()).isSuperTypeOf(eObject.eClass())) {
					try {
						waitingObject.getObject().setReference((EReference) waitingObject.getStructuralFeature(), eObject.getOid(), waitingObject.getBufferPosition());
					} catch (CannotStoreReferenceInFieldException e) {
						throw new DeserializeException(e.getDeserializerErrorCode(), e.getMessage());
					}
					decrementOpenConnections(waitingObject.getObject());
				} else {
					throw new DeserializeException(DeserializerErrorCode.REFERENCED_OBJECT_CANNOT_BE_STORED_IN_THIS_FIELD, waitingObject.getLineNumber(), "Field " + waitingObject.getStructuralFeature().getName() + " of "
							+ waitingObject.getStructuralFeature().getEContainingClass().getName() + " cannot contain a " + eObject.eClass().getName() + "/" + eObject.getOid());
				}
			}
		}
		waitingObjects.remove(expressId);
	}

	public int size() {
		return waitingObjects.size();
	}
	
	public boolean isEmpty() {
		return waitingObjects.size() == 0 && openConnections.size() == 0;
	}
	
	public void dumpIfNotEmpty() throws DeserializeException {
		if (!openConnections.isEmpty()) {
			for (OpenConnectionCounter openConnectionCounter : openConnections.values()) {
				LOGGER.error("Open connection: " + openConnectionCounter);
			}
		}
		if (size() > 0) {
			for (Entry<Long, List<WaitingVirtualObject>> entry : waitingObjects.entrySet()) {
				StringBuilder sb = new StringBuilder("" + entry.getKey() + " ");
				for (WaitingVirtualObject waitingObject : entry.getValue()) {
					sb.append(waitingObject.toString() + " ");
				}
				LOGGER.info(sb.toString());
			}
			throw new DeserializeException(DeserializerErrorCode.NON_EXISTING_ENTITY_REFERENCED, "Waitinglist not empty, this usually means some objects were referred, but not included in the model");
		}
	}
}