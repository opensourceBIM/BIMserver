package org.bimserver.database;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;

public class ObjectsToDelete implements Iterable<RecordIdentifierPlusType> {

	private final Set<RecordIdentifierPlusType> set = new HashSet<RecordIdentifierPlusType>();

	public void put(EClass eClass, int pid, int rid, long oid) {
		RecordIdentifierPlusType recordIdentifier = new RecordIdentifierPlusType(eClass, pid, oid, rid);
		put(recordIdentifier);
	}

	private void put(RecordIdentifierPlusType recordIdentifier) {
		set.add(recordIdentifier);
	}

	@Override
	public Iterator<RecordIdentifierPlusType> iterator() {
		return set.iterator();
	}

	public void clear() {
		set.clear();
	}

	public int size() {
		return set.size();
	}
}