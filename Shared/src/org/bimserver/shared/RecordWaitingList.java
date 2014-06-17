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

import org.bimserver.database.Record;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.services.BimServerClientException;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecordWaitingList<T> {
	private static final Logger LOGGER = LoggerFactory.getLogger(RecordWaitingList.class);
	private final Map<T, List<RecordWaitingObject>> waitingObjects = new HashMap<T, List<RecordWaitingObject>>();

	public boolean containsKey(T recordNumber) {
		return waitingObjects.containsKey(recordNumber);
	}

	public void add(T referenceId, RecordWaitingObject waitingObject) {
		List<RecordWaitingObject> waitingList = null;
		if (waitingObjects.containsKey(referenceId)) {
			waitingList = waitingObjects.get(referenceId);
		} else {
			waitingList = new ArrayList<RecordWaitingObject>();
			waitingObjects.put(referenceId, waitingList);
		}
		waitingList.add(waitingObject);
	}
	
	public void updateNode(T expressId, EClass ec, Record otherRecord) throws DeserializeException {
		for (RecordWaitingObject waitingObject : waitingObjects.get(expressId)) {
			if (waitingObject.getStructuralFeature().isMany()) {
				List<Record> list = waitingObject.getRecord().getList(waitingObject.getStructuralFeature());
				if (waitingObject instanceof SingleRecordWaitingObject) {
					list.add(otherRecord);
				} else {
					RecordListWaitingObject listWaitingObject = (RecordListWaitingObject)waitingObject;
					if (((EClass) waitingObject.getStructuralFeature().getEType()).isSuperTypeOf(otherRecord.eClass())) {
						while (list.size() <= listWaitingObject.getIndex()) {
							list.add(new Record(otherRecord.eClass()));
						}
						list.set(listWaitingObject.getIndex(), otherRecord);
					} else {
						throw new DeserializeException(waitingObject.getLineNumber(), "Field " + waitingObject.getStructuralFeature().getName() + " of "
								+ waitingObject.getStructuralFeature().getEContainingClass().getName() + " cannot contain a " + otherRecord.eClass().getName());
					}
				}
			} else {
				if (((EClass) waitingObject.getStructuralFeature().getEType()).isSuperTypeOf(otherRecord.eClass())) {
					waitingObject.getRecord().setReference(waitingObject.getStructuralFeature(), otherRecord.getOid());
				} else {
					throw new DeserializeException(waitingObject.getLineNumber(), "Field " + waitingObject.getStructuralFeature().getName() + " of "
							+ waitingObject.getStructuralFeature().getEContainingClass().getName() + " cannot contain a " + otherRecord.eClass().getName());
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
			for (Entry<T, List<RecordWaitingObject>> entry : waitingObjects.entrySet()) {
				StringBuilder sb = new StringBuilder("" + entry.getKey() + " ");
				for (RecordWaitingObject waitingObject : entry.getValue()) {
					sb.append(waitingObject.toString() + " ");
				}
				LOGGER.info(sb.toString());
			}
			throw new BimServerClientException("Waitinglist not empty, this usually means some objects were referred, but not included in the download");
		}
	}
}