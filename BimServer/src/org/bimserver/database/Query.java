package org.bimserver.database;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.QueryInterface;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Query implements QueryInterface {

	public static enum Deep {
		NO,
		YES
	}
	
	private final int pid;
	private final int rid;
	private final long roid;
	private final ObjectIDM objectIDM;
	private final Deep deep;
	private final int stopRid;
	private PackageMetaData packageMetaData;
	private Map<EClass, Long> oidCounters;

	private static final Query DEFAULT = new Query();
	
	public static final void setPackageMetaDataForDefaultQuery(PackageMetaData packageMetaData) {
		DEFAULT.packageMetaData = packageMetaData;
	}
	
	public static Query getDefault() {
		return DEFAULT;
	}
	
	public void setOidCounters(Map<EClass, Long> oidCounters) {
		this.oidCounters = oidCounters;
	}
	
	public Map<EClass, Long> getOidCounters() {
		return oidCounters;
	}
	
	private Query() {
		this.packageMetaData = null;
		this.pid = Database.STORE_PROJECT_ID;
		this.roid = -1;
		this.rid = Integer.MAX_VALUE;
		this.stopRid = Integer.MIN_VALUE;
		this.objectIDM = null;
		this.deep = Deep.NO;
	}
	
	public Query(PackageMetaData packageMetaData, int pid, int rid, long roid) {
		this.packageMetaData = packageMetaData;
		this.pid = pid;
		this.rid = rid;
		this.roid = roid;
		this.stopRid = Integer.MIN_VALUE;
		this.objectIDM = null;
		this.deep = Deep.NO;
	}
	
	public Query(PackageMetaData packageMetaData, boolean deep) {
		this.packageMetaData = packageMetaData;
		this.pid = Database.STORE_PROJECT_ID;
		this.rid = Integer.MAX_VALUE;
		this.roid = -1;
		this.stopRid = Integer.MIN_VALUE;
		this.objectIDM = null;
		this.deep = deep ? Deep.YES : Deep.NO;
	}

	public Query(PackageMetaData packageMetaData, int pid, int rid, long roid, Deep deep) {
		this.packageMetaData = packageMetaData;
		this.objectIDM = null;
		this.pid = pid;
		this.rid = rid;
		this.roid = roid;
		this.stopRid = Integer.MIN_VALUE;
		this.deep = deep;
	}

	public Query(PackageMetaData packageMetaData, int pid, int rid, long roid, ObjectIDM objectIDM, Deep deep) {
		this.packageMetaData = packageMetaData;
		this.pid = pid;
		this.rid = rid;
		this.roid = roid;
		this.stopRid = Integer.MIN_VALUE;
		this.objectIDM = objectIDM;
		this.deep = deep;
	}
	
	public Query(PackageMetaData packageMetaData, int pid, int rid, long roid, ObjectIDM objectIDM, Deep deep, int stopRid) {
		this.packageMetaData = packageMetaData;
		this.pid = pid;
		this.rid = rid;
		this.roid = roid;
		this.stopRid = stopRid;
		this.objectIDM = objectIDM;
		this.deep = deep;
	}

	public void updateOidCounters(ConcreteRevision subRevision, DatabaseSession databaseSession) {
		if (subRevision.getOidCounters() != null) {
			Map<EClass, Long> oidCounters = new HashMap<>();
			ByteBuffer buffer = ByteBuffer.wrap(subRevision.getOidCounters());
			for (int i=0; i<buffer.capacity() / 10; i++) {
				short cid = buffer.getShort();
				long oid = buffer.getLong();
				oidCounters.put(databaseSession.getEClass(cid), oid);
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
	
	public ObjectIDM getObjectIDM() {
		return objectIDM;
	}
	
	public boolean shouldIncludeClass(EClass eClass) {
		return objectIDM == null || objectIDM.shouldIncludeClass(eClass, eClass);
	}

	public boolean shouldFollowReference(EClass originalQueryClass, EClass eClass, EStructuralFeature feature) {
		return objectIDM == null || objectIDM.shouldFollowReference(originalQueryClass, eClass, feature);
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