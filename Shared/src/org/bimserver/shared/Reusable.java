package org.bimserver.shared;

import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.deserializers.DatabaseInterface;

public class Reusable {
	private int pid;
	private int rid;
	private PackageMetaData packageMetaData;
	private DatabaseInterface databaseInterface;
	
	public Reusable(DatabaseInterface databaseInterface, PackageMetaData packageMetaData, int pid, int rid) {
		this.databaseInterface = databaseInterface;
		this.packageMetaData = packageMetaData;
		this.pid = pid;
		this.rid = rid;
	}
	
	public PackageMetaData getPackageMetaData() {
		return packageMetaData;
	}
	
	public int getPid() {
		return pid;
	}
	
	public int getRid() {
		return rid;
	}

	public DatabaseInterface getDatabaseInterface() {
		return databaseInterface;
	}
}
