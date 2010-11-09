package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SGuidClash extends SClash
{
	private long oid;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	private java.lang.String guid1;
	private java.lang.String guid2;

	public java.lang.String getGuid1() {
		return guid1;
	}

	public void setGuid1(java.lang.String guid1) {
		this.guid1 = guid1;
	}

	public java.lang.String getGuid2() {
		return guid2;
	}

	public void setGuid2(java.lang.String guid2) {
		this.guid2 = guid2;
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
		SGuidClash other = (SGuidClash) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}