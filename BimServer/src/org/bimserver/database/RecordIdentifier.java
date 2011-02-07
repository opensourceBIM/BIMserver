package org.bimserver.database;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
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