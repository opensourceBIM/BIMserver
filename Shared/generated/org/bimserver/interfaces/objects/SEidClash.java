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
import javax.xml.bind.annotation.XmlTransient;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SEidClash extends SClash implements SBase
{
	private long oid = -1;
	@XmlTransient
	private static SClass sClass;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	
	@XmlTransient
	public SClass getSClass() {
		return sClass;
	}
	
	public static void setSClass(SClass sClass) {
		SEidClash.sClass = sClass;
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
		if (sField.getName().equals("eid1")) {
			setEid1((Long)val);
			return;
		}
		if (sField.getName().equals("eid2")) {
			setEid2((Long)val);
			return;
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
			return;
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