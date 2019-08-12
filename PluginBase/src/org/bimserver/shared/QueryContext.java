package org.bimserver.shared;

import org.bimserver.database.OidCounters;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.deserializers.DatabaseInterface;

public class QueryContext {
	private int pid;
	private int rid;
	private long roid;
	private PackageMetaData packageMetaData;
	private DatabaseInterface databaseInterface;
	private int highestStopId;
	private OidCounters oidCounters;
	private long croid;
	
	public QueryContext(DatabaseInterface databaseInterface, PackageMetaData packageMetaData, int pid, int rid, long roid, long croid, int highestStopId) {
		this.databaseInterface = databaseInterface;
		this.packageMetaData = packageMetaData;
		this.pid = pid;
		this.rid = rid;
		this.roid = roid;
		this.croid = croid;
		this.highestStopId = highestStopId;
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

	public int getStopRid() {
		return highestStopId;
	}

	public OidCounters getOidCounters() {
		return oidCounters;
	}

	public void setOidCounters(OidCounters oidCounters) {
		this.oidCounters = oidCounters;
	}
	
	public long getCroid() {
		return croid;
	}
}
