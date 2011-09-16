package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;
import org.bimserver.shared.meta.*;

@XmlRootElement
public class SClash implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("Clash");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("name1", java.lang.String.class));
		sClass.addField(new SField("name2", java.lang.String.class));
		sClass.addField(new SField("type1", java.lang.String.class));
		sClass.addField(new SField("type2", java.lang.String.class));
		sClass.addField(new SField("revision1Id", long.class));
		sClass.addField(new SField("revision2Id", long.class));
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
	private java.lang.String name1;
	private java.lang.String name2;
	private java.lang.String type1;
	private java.lang.String type2;
	private long revision1Id;
	private long revision2Id;

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
	public long getRevision1Id() {
		return revision1Id;
	}

	public void setRevision1Id(long revision1Id) {
		this.revision1Id = revision1Id;
	}
	
	public long getRevision2Id() {
		return revision2Id;
	}

	public void setRevision2Id(long revision2Id) {
		this.revision2Id = revision2Id;
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