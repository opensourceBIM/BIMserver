package org.bimserver.database;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.QueryInterface;
import org.bimserver.models.store.ConcreteRevision;
import org.eclipse.emf.ecore.EClass;

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
	private Map<EClass, Long> oidCounters;

	private static final OldQuery DEFAULT = new OldQuery();
	
	public static final void setPackageMetaDataForDefaultQuery(PackageMetaData packageMetaData) {
		DEFAULT.packageMetaData = packageMetaData;
	}
	
	public static OldQuery getDefault() {
		return DEFAULT;
	}
	
	public void setOidCounters(Map<EClass, Long> oidCounters) {
		this.oidCounters = oidCounters;
	}
	
	public Map<EClass, Long> getOidCounters() {
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

	public void updateOidCounters(ConcreteRevision subRevision, DatabaseSession databaseSession) throws BimserverDatabaseException {
		if (subRevision.getOidCounters() != null) {
			Map<EClass, Long> oidCounters = new HashMap<>();
			ByteBuffer buffer = ByteBuffer.wrap(subRevision.getOidCounters());
			for (int i=0; i<buffer.capacity() / 8; i++) {
				buffer.order(ByteOrder.LITTLE_ENDIAN);
				long oid = buffer.getLong();
				buffer.order(ByteOrder.BIG_ENDIAN);
				EClass eClass = databaseSession.getEClass((short)oid);
				oidCounters.put(eClass, oid);
			}
			setOidCounters(oidCounters);
		}
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