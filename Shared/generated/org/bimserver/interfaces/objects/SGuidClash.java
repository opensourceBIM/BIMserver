package org.bimserver.interfaces.objects;

import javax.xml.bind.annotation.XmlRootElement;

import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;

@XmlRootElement
public class SGuidClash extends SClash implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("GuidClash");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("name1", java.lang.String.class));
		sClass.addField(new SField("name2", java.lang.String.class));
		sClass.addField(new SField("type1", java.lang.String.class));
		sClass.addField(new SField("type2", java.lang.String.class));
		sClass.addField(new SField("revision1Id", long.class));
		sClass.addField(new SField("revision2Id", long.class));
		sClass.addField(new SField("guid1", java.lang.String.class));
		sClass.addField(new SField("guid2", java.lang.String.class));
	}
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	
	public SClass getSClass() {
		return sClass;
	}
	
	public Object sGet(SField sField) {
		if (sField.getName().equals("name1")) {
			return getName1();
		}
		if (sField.getName().equals("name2")) {
			return getName2();
		}
		if (sField.getName().equals("type1")) {
			return getType1();
		}
		if (sField.getName().equals("type2")) {
			return getType2();
		}
		if (sField.getName().equals("revision1Id")) {
			return getRevision1Id();
		}
		if (sField.getName().equals("revision2Id")) {
			return getRevision2Id();
		}
		if (sField.getName().equals("guid1")) {
			return getGuid1();
		}
		if (sField.getName().equals("guid2")) {
			return getGuid2();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
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