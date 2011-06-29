package org.bimserver.interfaces.objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SLogAction
{
	private long oid;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	private java.util.Date date;
	private long executorId;
	private SAccessMethod accessMethod;

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public long getExecutorId() {
		return executorId;
	}

	public void setExecutorId(long executorId) {
		this.executorId = executorId;
	}
	
	public SAccessMethod getAccessMethod() {
		return accessMethod;
	}

	public void setAccessMethod(SAccessMethod accessMethod) {
		this.accessMethod = accessMethod;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (oid ^ (oid >>> 32));
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
		SLogAction other = (SLogAction) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}