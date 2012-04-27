package org.bimserver.database;

import org.eclipse.emf.ecore.EClass;

public class RecordIdentifierPlusType {
	private final String packageName;
	private final String className;
	private final int pid;
	private final long oid;
	private final int rid;

	public RecordIdentifierPlusType(EClass eClass, int pid, long oid, int rid) {
		this.packageName = eClass.getEPackage().getName();
		this.className = eClass.getName();
		this.pid = pid;
		this.oid = oid;
		this.rid = rid;
	}

	public String getClassName() {
		return className;
	}
	
	public String getPackageName() {
		return packageName;
	}
	
	public long getOid() {
		return oid;
	}
	
	public int getPid() {
		return pid;
	}
	
	public int getRid() {
		return rid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + (int) (oid ^ (oid >>> 32));
		result = prime * result + ((packageName == null) ? 0 : packageName.hashCode());
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
		RecordIdentifierPlusType other = (RecordIdentifierPlusType) obj;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (oid != other.oid)
			return false;
		if (packageName == null) {
			if (other.packageName != null)
				return false;
		} else if (!packageName.equals(other.packageName))
			return false;
		if (pid != other.pid)
			return false;
		if (rid != other.rid)
			return false;
		return true;
	}
}
