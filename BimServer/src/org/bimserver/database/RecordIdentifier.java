package org.bimserver.database;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

public class RecordIdentifier {
	private final int pid;
	private final long oid;
	private final int rid;

	public RecordIdentifier(int pid, long oid, int rid) {
		this.pid = pid;
		this.oid = oid;
		this.rid = rid;
	}

	public int getRid() {
		return rid;
	}

	public int getPid() {
		return pid;
	}

	public long getOid() {
		return oid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (oid ^ (oid >>> 32));
		result = prime * result + pid;
		result = prime * result + rid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecordIdentifier other = (RecordIdentifier) obj;
		if (oid != other.oid)
			return false;
		if (pid != other.pid)
			return false;
		if (rid != other.rid)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "pid: " + pid + ", oid: " + oid + ", rid: " + rid;
	}
}