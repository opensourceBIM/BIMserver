package org.bimserver.webservices;

import java.util.LinkedHashSet;
import java.util.Set;

import org.bimserver.changes.Change;

public class LongTransaction {

	private long tid;
	private Set<Change> changes = new LinkedHashSet<Change>();
	private int pid;
	private int rid;
	private long poid;

	public LongTransaction(long poid, int pid, int rid, long tid) {
		this.poid = poid;
		this.pid = pid;
		this.rid = rid;
		this.tid = tid;
	}
	
	public int getPid() {
		return pid;
	}
	
	public int getRid() {
		return rid;
	}
	
	public long getTid() {
		return tid;
	}

	public void add(Change change) {
		changes.add(change);
	}

	public void close() {
	}

	public Set<Change> getChanges() {
		return changes;
	}

	public long getPoid() {
		return poid;
	}
}