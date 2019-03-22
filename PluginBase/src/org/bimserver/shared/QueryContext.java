package org.bimserver.shared;

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

import java.util.Map;

import org.bimserver.database.OidCounters;
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
