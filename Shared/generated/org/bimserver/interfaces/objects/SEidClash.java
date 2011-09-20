package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

@XmlRootElement
public class SEidClash extends SClash implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("EidClash");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("name1", java.lang.String.class));
		sClass.addField(new SField("name2", java.lang.String.class));
		sClass.addField(new SField("type1", java.lang.String.class));
		sClass.addField(new SField("type2", java.lang.String.class));
		sClass.addField(new SField("revision1Id", long.class));
		sClass.addField(new SField("revision2Id", long.class));
		sClass.addField(new SField("eid1", long.class));
		sClass.addField(new SField("eid2", long.class));
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
		if (sField.getName().equals("eid1")) {
			return getEid1();
		}
		if (sField.getName().equals("eid2")) {
			return getEid2();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
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