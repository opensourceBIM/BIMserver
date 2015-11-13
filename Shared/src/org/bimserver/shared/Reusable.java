package org.bimserver.shared;

import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.deserializers.DatabaseInterface;

public class Reusable {
	private int pid;
	private int rid;
	private long roid;
	private PackageMetaData packageMetaData;
	private DatabaseInterface databaseInterface;
	
	public Reusable(DatabaseInterface databaseInterface, PackageMetaData packageMetaData, int pid, int rid, long roid) {
		this.databaseInterface = databaseInterface;
		this.packageMetaData = packageMetaData;
		this.pid = pid;
		this.rid = rid;
		this.roid = roid;
	}
	
	public PackageMetaData getPackageMetaData() {
		return packageMetaData;
	}
	
	public int getPid() {
		return pid;
	}
	
	public long getRoid() {
		return roid;
	}
	
	public int getRid() {
		return rid;
	}

	public DatabaseInterface getDatabaseInterface() {
		return databaseInterface;
	}
}
