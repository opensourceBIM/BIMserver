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
public class SDataObject implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("SDataObject");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("type", java.lang.String.class));
		sClass.addField(new SField("guid", java.lang.String.class));
		sClass.addField(new SField("name", java.lang.String.class));
		sClass.addField(new SField("values", SDataValue.class, true));
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
		if (sField.getName().equals("type")) {
			return getType();
		}
		if (sField.getName().equals("guid")) {
			return getGuid();
		}
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("values")) {
			return getValues();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("type")) {
			setType((String)val);
			return;
		}
		if (sField.getName().equals("guid")) {
			setGuid((String)val);
			return;
		}
		if (sField.getName().equals("name")) {
			setName((String)val);
			return;
		}
		if (sField.getName().equals("values")) {
			setValues((List<SDataValue>)val);
			return;
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
			return;
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private java.lang.String type;
	private java.lang.String guid;
	private java.lang.String name;
	private List<SDataValue> values = new ArrayList<SDataValue>();
	public java.lang.String getType() {
		return type;
	}

	public void setType(java.lang.String type) {
		this.type = type;
	}
	public java.lang.String getGuid() {
		return guid;
	}

	public void setGuid(java.lang.String guid) {
		this.guid = guid;
	}
	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	public List<SDataValue> getValues() {
		return values;
	}

	public void setValues(List<SDataValue> values) {
		this.values = values;
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
		SDataObject other = (SDataObject) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}