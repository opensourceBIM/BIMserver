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

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

@XmlRootElement
public class SReferenceDataValue extends SDataValue implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("SReferenceDataValue");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("fieldName", java.lang.String.class));
		sClass.addField(new SField("typeName", java.lang.String.class));
		sClass.addField(new SField("guid", java.lang.String.class));
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
		if (sField.getName().equals("fieldName")) {
			return getFieldName();
		}
		if (sField.getName().equals("typeName")) {
			return getTypeName();
		}
		if (sField.getName().equals("guid")) {
			return getGuid();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("fieldName")) {
			setFieldName((String)val);
			return;
		}
		if (sField.getName().equals("typeName")) {
			setTypeName((String)val);
			return;
		}
		if (sField.getName().equals("guid")) {
			setGuid((String)val);
			return;
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
			return;
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private java.lang.String typeName;
	private java.lang.String guid;
	public java.lang.String getTypeName() {
		return typeName;
	}

	public void setTypeName(java.lang.String typeName) {
		this.typeName = typeName;
	}
	public java.lang.String getGuid() {
		return guid;
	}

	public void setGuid(java.lang.String guid) {
		this.guid = guid;
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
		SReferenceDataValue other = (SReferenceDataValue) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}