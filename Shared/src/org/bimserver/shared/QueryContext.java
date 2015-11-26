package org.bimserver.shared;

import java.util.Map;

import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.deserializers.DatabaseInterface;
import org.eclipse.emf.ecore.EClass;

public class QueryContext {
	private int pid;
	private int rid;
	private long roid;
	private PackageMetaData packageMetaData;
	private DatabaseInterface databaseInterface;
	private int highestStopId;
	private Map<EClass, Long> oidCounters;
	
	public QueryContext(DatabaseInterface databaseInterface, PackageMetaData packageMetaData, int pid, int rid, long roid, int highestStopId) {
		this.databaseInterface = databaseInterface;
		this.packageMetaData = packageMetaData;
		this.pid = pid;
		this.rid = rid;
		this.roid = roid;
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

	public Map<EClass, Long> getOidCounters() {
		return oidCounters;
	}

	public void setOidCounters(Map<EClass, Long> oidCounters) {
		this.oidCounters = oidCounters;
	}
}
