package org.bimserver.database;

public class ClearProjectPlan {

	private final int pid;
	private final int oldRid;
	private final int newRid;

	public ClearProjectPlan(int pid, int oldRid, int newRid) {
		this.pid = pid;
		this.oldRid = oldRid;
		this.newRid = newRid;
	}
	
	public int getPid() {
		return pid;
	}

	public int getOldRid() {
		return oldRid;
	}
	
	public int getNewRid() {
		return newRid;
	}
}
