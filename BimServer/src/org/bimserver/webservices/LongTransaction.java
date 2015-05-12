package org.bimserver.webservices;

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

import java.util.LinkedHashSet;
import java.util.Set;

import org.bimserver.changes.Change;
import org.bimserver.emf.PackageMetaData;

public class LongTransaction {

	private long tid;
	private Set<Change> changes = new LinkedHashSet<Change>();
	private int pid;
	private int rid;
	private long poid;
	private long roid;
	private PackageMetaData packageMetaData;

	public LongTransaction(PackageMetaData packageMetaData, long poid, long roid, int pid, int rid, long tid) {
		this.packageMetaData = packageMetaData;
		this.poid = poid;
		this.roid = roid;
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

	public PackageMetaData getPackageMetaData() {
		return packageMetaData;
	}

	public long getRoid() {
		return roid;
	}
}