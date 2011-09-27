package org.bimserver.interfaces.objects;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SClash implements SBase
{
	private long oid = -1;
	private static final SClass sClass = new SClass("SClash");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("name1", java.lang.String.class));
		sClass.addField(new SField("name2", java.lang.String.class));
		sClass.addField(new SField("type1", java.lang.String.class));
		sClass.addField(new SField("type2", java.lang.String.class));
		sClass.addField(new SField("revision1Id", long.class));
		sClass.addField(new SField("revision2Id", long.class));
		SPackage.getInstance().addSClass(sClass);

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
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("name1")) {
			setName1((String)val);
			return;
		}
		if (sField.getName().equals("name2")) {
			setName2((String)val);
			return;
		}
		if (sField.getName().equals("type1")) {
			setType1((String)val);
			return;
		}
		if (sField.getName().equals("type2")) {
			setType2((String)val);
			return;
		}
		if (sField.getName().equals("revision1Id")) {
			setRevision1Id((Long)val);
			return;
		}
		if (sField.getName().equals("revision2Id")) {
			setRevision2Id((Long)val);
			return;
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
			return;
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
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