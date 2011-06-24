package org.bimserver.interfaces.objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SEidClash extends SClash
{
	private long oid;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	private long eid1;
	private long eid2;

	public long getEid1() {
		return eid1;
	}

	public void setEid1(long eid1) {
		this.eid1 = eid1;
	}

	public long getEid2() {
		return eid2;
	}

	public void setEid2(long eid2) {
		this.eid2 = eid2;
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
		SEidClash other = (SEidClash) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}