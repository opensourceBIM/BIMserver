package org.bimserver.webservices;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.changes.Change;

public class LongTransaction {

	private long tid;
	private long poid;
	private Set<Change> changes = new HashSet<Change>();

	public LongTransaction(long poid, long tid) {
		this.poid = poid;
		this.tid = tid;
	}
	
	public long getTid() {
		return tid;
	}

	public void add(Change change) {
		changes.add(change);
	}

	public void close() {
	}

	public long getPoid() {
		return poid;
	}

	public Set<Change> getChanges() {
		return changes;
	}
}