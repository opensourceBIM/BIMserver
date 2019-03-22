package org.bimserver.database;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.QueryInterface;
import org.bimserver.models.store.ConcreteRevision;

public class OldQuery implements QueryInterface {

	public static enum Deep {
		NO,
		YES
	}
	
	private final int pid;
	private final int rid;
	private final long roid;
	private final Deep deep;
	private final int stopRid;
	private PackageMetaData packageMetaData;
	private OidCounters oidCounters;

	private static final OldQuery DEFAULT = new OldQuery();
	
	public static final void setPackageMetaDataForDefaultQuery(PackageMetaData packageMetaData) {
		DEFAULT.packageMetaData = packageMetaData;
	}
	
	public static OldQuery getDefault() {
		return DEFAULT;
	}
	
	public void setOidCounters(OidCounters oidCounters) {
		this.oidCounters = oidCounters;
	}
	
	public OidCounters getOidCounters() {
		return oidCounters;
	}
	
	private OldQuery() {
		this.packageMetaData = null;
		this.pid = Database.STORE_PROJECT_ID;
		this.roid = -1;
		this.rid = Integer.MAX_VALUE;
		this.stopRid = Integer.MIN_VALUE;
		this.deep = Deep.NO;
	}
	
	public OldQuery(PackageMetaData packageMetaData, int pid, int rid, long roid) {
		this.packageMetaData = packageMetaData;
		this.pid = pid;
		this.rid = rid;
		this.roid = roid;
		this.stopRid = Integer.MIN_VALUE;
		this.deep = Deep.NO;
	}
	
	public OldQuery(PackageMetaData packageMetaData, boolean deep) {
		this.packageMetaData = packageMetaData;
		this.pid = Database.STORE_PROJECT_ID;
		this.rid = Integer.MAX_VALUE;
		this.roid = -1;
		this.stopRid = Integer.MIN_VALUE;
		this.deep = deep ? Deep.YES : Deep.NO;
	}

	public OldQuery(PackageMetaData packageMetaData, int pid, int rid, long roid, Deep deep) {
		this.packageMetaData = packageMetaData;
		this.pid = pid;
		this.rid = rid;
		this.roid = roid;
		this.stopRid = Integer.MIN_VALUE;
		this.deep = deep;
	}

	public OldQuery(PackageMetaData packageMetaData, int pid, int rid, long roid, Deep deep, int stopRid) {
		this.packageMetaData = packageMetaData;
		this.pid = pid;
		this.rid = rid;
		this.roid = roid;
		this.stopRid = stopRid;
		this.deep = deep;
	}

	public OidCounters updateOidCounters(ConcreteRevision subRevision, DatabaseSession databaseSession) throws BimserverDatabaseException {
		if (subRevision.getOidCounters() != null) {
			OidCounters oidCounters = new OidCounters(databaseSession, subRevision.getOidCounters());
			setOidCounters(oidCounters);
			return oidCounters;
		}
		return null;
	}
	
	public int getStopRid() {
		return stopRid;
	}

	public int getPid() {
		return pid;
	}
	
	public int getRid() {
		return rid;
	}

	public boolean isDeep() {
		return deep == Deep.YES;
	}
	
	@Override
	public PackageMetaData getPackageMetaData() {
		return packageMetaData;
	}

	@Override
	public long getRoid() {
		return roid;
	}
}