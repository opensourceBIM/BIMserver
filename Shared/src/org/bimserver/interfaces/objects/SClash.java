package org.bimserver.interfaces.objects;

import java.util.*;

public class SClash
{
	private long oid;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	private long revisionId;
	private java.lang.String guid1;
	private java.lang.String guid2;
	private java.lang.String name1;
	private java.lang.String name2;
	private java.lang.String type1;
	private java.lang.String type2;
	public long getRevisionId() {
		return revisionId;
	}

	public void setRevisionId(long revisionId) {
		this.revisionId = revisionId;
	}
	

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

	public java.lang.String getName1() {
		return name1;
	}

	public void setName1(java.lang.String name1) {
		this.name1 = name1;
	}

	public java.lang.String getName2() {
		return name2;
	}

	public void setName2(java.lang.String name2) {
		this.name2 = name2;
	}

	public java.lang.String getType1() {
		return type1;
	}

	public void setType1(java.lang.String type1) {
		this.type1 = type1;
	}

	public java.lang.String getType2() {
		return type2;
	}

	public void setType2(java.lang.String type2) {
		this.type2 = type2;
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
		SClash other = (SClash) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}